package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.Budget;
import com.ruoyi.system.domain.Pay;
import com.ruoyi.system.service.IBudgetService;
import com.ruoyi.system.service.IPayService;
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
@RequestMapping("/system/pay")
public class PayController extends BaseController
{
    private String prefix = "system/pay";

    @Autowired
    private IPayService payService;

    @RequiresPermissions("system:pay:view")
    @GetMapping()
    public String operlog()
    {
        return prefix + "/pay";
    }

    @RequiresPermissions("system:pay:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Pay pay)
    {
        startPage();
        List<Pay> list = payService.selectPayList(pay);
        return getDataTable(list);
    }

    @Log(title = "支付管理", businessType = BusinessType.EXPORT)
    @RequiresPermissions("system:pay:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Pay pay)
    {
        List<Pay> list = payService.selectPayList(pay);
        ExcelUtil<Pay> util = new ExcelUtil<Pay>(Pay.class);
        return util.exportExcel(list, "预算数据");
    }

    @RequiresPermissions("system:pay:remove")
    @Log(title = "支付管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        try
        {
            return toAjax(payService.deletePayByIds(ids));
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
    @RequiresPermissions("system:pay:add")
    @Log(title = "预算管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated Pay pay)
    {
        pay.setCreateBy(ShiroUtils.getLoginName());
        return toAjax(payService.insertPay(pay));
    }

    /**
     * 修改岗位
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        mmap.put("pay", payService.selectPayById(id));
        return prefix + "/edit";
    }

    /**
     * 修改保存岗位
     */
    @RequiresPermissions("system:pay:edit")
    @Log(title = "岗位管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated Pay pay)
    {
        pay.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(payService.updatePay(pay));
    }

}
