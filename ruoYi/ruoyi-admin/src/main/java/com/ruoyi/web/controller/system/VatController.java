package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.Budget;
import com.ruoyi.system.domain.Vat;
import com.ruoyi.system.service.IBudgetService;
import com.ruoyi.system.service.IVatService;
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
@RequestMapping("/system/vat")
public class VatController extends BaseController
{
    private String prefix = "system/vat";

    @Autowired
    private IVatService vatService;

    @RequiresPermissions("system:vat:view")
    @GetMapping()
    public String operlog()
    {
        return prefix + "/vat";
    }

    @RequiresPermissions("system:vat:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Vat vat)
    {
        startPage();
        List<Vat> list = vatService.selectVatList(vat);
        return getDataTable(list);
    }

    @Log(title = "普票管理", businessType = BusinessType.EXPORT)
    @RequiresPermissions("system:vat:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Vat vat)
    {
        List<Vat> list = vatService.selectVatList(vat);
        ExcelUtil<Vat> util = new ExcelUtil<Vat>(Vat.class);
        return util.exportExcel(list, "普票数据");
    }

    @RequiresPermissions("system:vat:remove")
    @Log(title = "普票管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        try
        {
            return toAjax(vatService.deleteVatByIds(ids));
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
    @RequiresPermissions("system:vat:add")
    @Log(title = "普票管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated Vat vat)
    {
        vat.setCreateBy(ShiroUtils.getLoginName());
        return toAjax(vatService.insertVat(vat));
    }

    /**
     * 修改岗位
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        mmap.put("vat", vatService.selectVatById(id));
        logger.debug(mmap.toString());
        return prefix + "/edit";
    }

    /**
     * 修改保存岗位
     */
    @RequiresPermissions("system:vat:edit")
    @Log(title = "岗位管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated Vat vat)
    {
        vat.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(vatService.updateVat(vat));
    }

}
