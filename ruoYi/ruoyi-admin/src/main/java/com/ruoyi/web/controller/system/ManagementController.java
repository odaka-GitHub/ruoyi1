package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.Management;
import com.ruoyi.system.service.IManagementService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 岗位信息操作处理
 * 
 * @author ruoyi
 */
@Controller
@RequestMapping("/system/management")
public class ManagementController extends BaseController
{
    private String prefix = "system/management";

    @Autowired
    private IManagementService managementService;

    @RequiresPermissions("system:management:view")
    @GetMapping()
    public String operlog()
    {
        return prefix + "/management";
    }

    @RequiresPermissions("system:management:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Management management)
    {
        startPage();
        List<Management> list = managementService.selectManagementList(management);
        return getDataTable(list);
    }

    @Log(title = "岗位管理", businessType = BusinessType.EXPORT)
    @RequiresPermissions("system:management:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Management management)
    {
        List<Management> list = managementService.selectManagementList(management);
        ExcelUtil<Management> util = new ExcelUtil<Management>(Management.class);
        return util.exportExcel(list, "预算数据");
    }

    @RequiresPermissions("system:management:remove")
    @Log(title = "预算管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        try
        {
            return toAjax(managementService.deleteManagementByIds(ids));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }

    /**
     * 新增岗位
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存岗位
     */
    @RequiresPermissions("system:management:add")
    @Log(title = "预算管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated Management management)
    {
        management.setCreateBy(ShiroUtils.getLoginName());
        return toAjax(managementService.insertManagement(management));
    }

    /**
     * 修改岗位
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        mmap.put("management", managementService.selectManagementById(id));
        return prefix + "/edit";
    }

    /**
     * 修改保存岗位
     */
    @RequiresPermissions("system:management:edit")
    @Log(title = "岗位管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated Management management)
    {
        management.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(managementService.updateManagement(management));
    }

}
