package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.Centralization;
import com.ruoyi.system.service.ICentralizationService;
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
@RequestMapping("/system/centralization")
public class CentralizationController extends BaseController
{
    private String prefix = "system/centralization";

    @Autowired
    private ICentralizationService centralizationService;

    @RequiresPermissions("system:centralization:view")
    @GetMapping()
    public String operlog()
    {
        return prefix + "/centralization";
    }

    @RequiresPermissions("system:centralization:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Centralization centralization)
    {
        startPage();
        List<Centralization> list = centralizationService.selectCentralizationList(centralization);
        return getDataTable(list);
    }

    @Log(title = "集中化管理", businessType = BusinessType.EXPORT)
    @RequiresPermissions("system:centralization:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Centralization centralization)
    {
        List<Centralization> list = centralizationService.selectCentralizationList(centralization);
        ExcelUtil<Centralization> util = new ExcelUtil<Centralization>(Centralization.class);
        return util.exportExcel(list, "集中化数据");
    }

    @RequiresPermissions("system:centralization:remove")
    @Log(title = "集中化管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        try
        {
            return toAjax(centralizationService.deleteCentralizationByIds(ids));
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
    @RequiresPermissions("system:centralization:add")
    @Log(title = "集中化管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated Centralization centralization)
    {
        centralization.setCreateBy(ShiroUtils.getLoginName());
        return toAjax(centralizationService.insertCentralization(centralization));
    }

    /**
     * 修改岗位
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        mmap.put("centralization", centralizationService.selectCentralizationById(id));
        return prefix + "/edit";
    }

    /**
     * 修改保存岗位
     */
    @RequiresPermissions("system:centralization:edit")
    @Log(title = "集中化管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated Centralization centralization)
    {
        centralization.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(centralizationService.updateCentralization(centralization));
    }

}
