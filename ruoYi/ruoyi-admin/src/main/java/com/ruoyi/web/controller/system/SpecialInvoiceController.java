package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SpecialInvoice;
import com.ruoyi.system.service.ISpecialInvoiceService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 专票信息操作处理
 * 
 * @author ruoyi
 */
@Controller
@RequestMapping("/system/specialInvoice")
public class SpecialInvoiceController extends BaseController
{
    private String prefix = "system/specialInvoice";

    @Autowired
    private ISpecialInvoiceService specialInvoiceService;

    @RequiresPermissions("system:specialInvoice:view")
    @GetMapping()
    public String operlog()
    {
        return prefix + "/specialInvoice";
    }

    @RequiresPermissions("system:specialInvoice:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SpecialInvoice specialInvoice)
    {
        startPage();
        List<SpecialInvoice> list = specialInvoiceService.selectSpecialInvoiceList(specialInvoice);
        return getDataTable(list);
    }

    @Log(title = "专票管理", businessType = BusinessType.EXPORT)
    @RequiresPermissions("system:specialInvoice:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SpecialInvoice specialInvoice)
    {
        List<SpecialInvoice> list = specialInvoiceService.selectSpecialInvoiceList(specialInvoice);
        ExcelUtil<SpecialInvoice> util = new ExcelUtil<SpecialInvoice>(SpecialInvoice.class);
        return util.exportExcel(list, "专票数据");
    }

    @RequiresPermissions("system:specialInvoice:remove")
    @Log(title = "普票管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        try
        {
            return toAjax(specialInvoiceService.deleteSpecialInvoiceByIds(ids));
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
    @RequiresPermissions("system:specialInvoice:add")
    @Log(title = "专票管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated SpecialInvoice specialInvoice)
    {
        specialInvoice.setCreateBy(ShiroUtils.getLoginName());
        return toAjax(specialInvoiceService.insertSpecialInvoice(specialInvoice));
    }

    /**
     * 修改岗位
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        mmap.put("specialInvoice", specialInvoiceService.selectSpecialInvoiceById(id));
        return prefix + "/edit";
    }

    /**
     * 修改保存岗位
     */
    @RequiresPermissions("system:specialInvoice:edit")
    @Log(title = "岗位管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated SpecialInvoice specialInvoice)
    {
        specialInvoice.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(specialInvoiceService.updateSpecialInvoice(specialInvoice));
    }

}
