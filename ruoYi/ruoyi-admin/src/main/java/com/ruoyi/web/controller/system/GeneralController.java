package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.General;
import com.ruoyi.system.service.IGeneralService;
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
@RequestMapping("/system/general")
public class GeneralController extends BaseController
{
    private String prefix = "system/general";

    @Autowired
    private IGeneralService generalService;

    @RequiresPermissions("system:general:view")
    @GetMapping()
    public String operlog()
    {
        return prefix + "/general";
    }

    @RequiresPermissions("system:general:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(General general)
    {
        startPage();
        List<General> list = generalService.selectGeneralList(general);
        return getDataTable(list);
    }

    @Log(title = "普票管理", businessType = BusinessType.EXPORT)
    @RequiresPermissions("system:general:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(General general)
    {
        List<General> list = generalService.selectGeneralList(general);
        ExcelUtil<General> util = new ExcelUtil<General>(General.class);
        return util.exportExcel(list, "普票数据");
    }

    @RequiresPermissions("system:general:remove")
    @Log(title = "普票管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        try
        {
            return toAjax(generalService.deleteGeneralByIds(ids));
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
    @RequiresPermissions("system:general:add")
    @Log(title = "普票管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated General general)
    {
        general.setCreateBy(ShiroUtils.getLoginName());
        return toAjax(generalService.insertGeneral(general));
    }

    /**
     * 修改岗位
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        mmap.put("general", generalService.selectGeneralById(id));
        return prefix + "/edit";
    }

    /**
     * 修改保存岗位
     */
    @RequiresPermissions("system:general:edit")
    @Log(title = "岗位管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated General general)
    {
        general.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(generalService.updateGeneral(general));
    }

}
