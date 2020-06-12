package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.Account;
import com.ruoyi.system.domain.Pay;
import com.ruoyi.system.service.IAccountService;
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
@RequestMapping("/system/account")
public class AccountController extends BaseController
{
    private String prefix = "system/account";

    @Autowired
    private IAccountService accountService;

    @RequiresPermissions("system:account:view")
    @GetMapping()
    public String operlog()
    {
        return prefix + "/account";
    }

    @RequiresPermissions("system:account:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Account account)
    {
        startPage();
        List<Account> list = accountService.selectAccountList(account);
        return getDataTable(list);
    }

    @Log(title = "支付管理", businessType = BusinessType.EXPORT)
    @RequiresPermissions("system:account:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Account account)
    {
        List<Account> list = accountService.selectAccountList(account);
        ExcelUtil<Account> util = new ExcelUtil<Account>(Account.class);
        return util.exportExcel(list, "预算数据");
    }

    @RequiresPermissions("system:account:remove")
    @Log(title = "支付管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        try
        {
            return toAjax(accountService.deleteAccountByIds(ids));
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
    @RequiresPermissions("system:account:add")
    @Log(title = "预算管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated Account account)
    {
        account.setCreateBy(ShiroUtils.getLoginName());
        return toAjax(accountService.insertAccount(account));
    }

    /**
     * 修改岗位
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        mmap.put("account", accountService.selectAccountById(id));
        return prefix + "/edit";
    }

    /**
     * 修改保存岗位
     */
    @RequiresPermissions("system:account:edit")
    @Log(title = "岗位管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated Account account)
    {
        account.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(accountService.updateAccount(account));
    }

}
