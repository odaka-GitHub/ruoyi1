package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.Budget;
import com.ruoyi.system.service.IBudgetService;
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
@RequestMapping("/system/budget")
public class BudgetController extends BaseController
{
    private String prefix = "system/budget";

    @Autowired
    private IBudgetService budgetService;

    @RequiresPermissions("system:budget:view")
    @GetMapping()
    public String operlog()
    {
        return prefix + "/budget";
    }

    @RequiresPermissions("system:budget:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Budget budget)
    {
        startPage();
        List<Budget> list = budgetService.selectBudgetList(budget);
        return getDataTable(list);
    }

    @Log(title = "岗位管理", businessType = BusinessType.EXPORT)
    @RequiresPermissions("system:budget:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Budget budget)
    {
        List<Budget> list = budgetService.selectBudgetList(budget);
        ExcelUtil<Budget> util = new ExcelUtil<Budget>(Budget.class);
        return util.exportExcel(list, "预算数据");
    }

    @RequiresPermissions("system:budget:remove")
    @Log(title = "预算管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        try
        {
            return toAjax(budgetService.deleteBudgetByIds(ids));
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
    @RequiresPermissions("system:budget:add")
    @Log(title = "预算管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated Budget budget)
    {
        budget.setCreateBy(ShiroUtils.getLoginName());
        return toAjax(budgetService.insertBudget(budget));
    }

    /**
     * 修改岗位
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        mmap.put("budget", budgetService.selectBudgetById(id));
        return prefix + "/edit";
    }

    /**
     * 修改保存岗位
     */
    @RequiresPermissions("system:budget:edit")
    @Log(title = "岗位管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated Budget budget)
    {
        budget.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(budgetService.updateBudget(budget));
    }

}
