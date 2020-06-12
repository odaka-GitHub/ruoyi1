package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.Budget;
import com.ruoyi.system.domain.Budgetgoal;
import com.ruoyi.system.service.IBudgetgoalService;
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
@RequestMapping("/system/budgetgoal")
public class BudgetgoalController extends BaseController
{
    private String prefix = "system/budgetgoal";

    @Autowired
    private IBudgetgoalService budgetgoalService;

    @RequiresPermissions("system:budgetgoal:view")
    @GetMapping()
    public String operlog()
    {
        return prefix + "/budgetgoal";
    }

    @RequiresPermissions("system:budgetgoal:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Budgetgoal budgetgoal)
    {
        startPage();
        List<Budgetgoal> list = budgetgoalService.selectBudgetgoalList(budgetgoal);
        return getDataTable(list);
    }

    @Log(title = "岗位管理", businessType = BusinessType.EXPORT)
    @RequiresPermissions("system:budgetgoal:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Budgetgoal budgetgoal)
    {
        List<Budgetgoal> list = budgetgoalService.selectBudgetgoalList(budgetgoal);
        ExcelUtil<Budgetgoal> util = new ExcelUtil<Budgetgoal>(Budgetgoal.class);
        return util.exportExcel(list, "预算数据");
    }

    @RequiresPermissions("system:budgetgoal:remove")
    @Log(title = "预算管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        try
        {
            return toAjax(budgetgoalService.deleteBudgetgoalByIds(ids));
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
    @RequiresPermissions("system:budgetgoal:add")
    @Log(title = "预算管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated Budgetgoal budgetgoal)
    {
        budgetgoal.setCreateBy(ShiroUtils.getLoginName());
        return toAjax(budgetgoalService.insertBudgetgoal(budgetgoal));
    }

    /**
     * 修改岗位
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        mmap.put("budgetgoal", budgetgoalService.selectBudgetgoalById(id));
        return prefix + "/edit";
    }

    /**
     * 修改保存岗位
     */
    @RequiresPermissions("system:budgetgoal:edit")
    @Log(title = "岗位管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated Budgetgoal budgetgoal)
    {
        budgetgoal.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(budgetgoalService.updateBudgetgoal(budgetgoal));
    }

}
