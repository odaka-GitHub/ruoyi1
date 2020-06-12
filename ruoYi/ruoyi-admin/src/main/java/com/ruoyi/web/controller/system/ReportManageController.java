package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.Report;
import com.ruoyi.system.domain.ReportManage;
import com.ruoyi.system.service.IReportManageService;
import com.ruoyi.system.service.IReportService;
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
@RequestMapping("/system/reportManage")
public class ReportManageController extends BaseController
{
    private String prefix = "system/reportManage";

    @Autowired
    private IReportManageService reportManageService;

    @RequiresPermissions("system:reportManage:view")
    @GetMapping()
    public String operlog()
    {
        return prefix + "/reportManage";
    }

    @RequiresPermissions("system:reportManage:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ReportManage reportManage)
    {
        startPage();
        List<ReportManage> list = reportManageService.selectReportManageList(reportManage);
        return getDataTable(list);
    }

    @Log(title = "岗位管理", businessType = BusinessType.EXPORT)
    @RequiresPermissions("system:reportManage:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ReportManage reportManage)
    {
        List<ReportManage> list = reportManageService.selectReportManageList(reportManage);
        ExcelUtil<ReportManage> util = new ExcelUtil<ReportManage>(ReportManage.class);
        return util.exportExcel(list, "预算数据");
    }

    @RequiresPermissions("system:reportManage:remove")
    @Log(title = "预算管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        try
        {
            return toAjax(reportManageService.deleteReportManageByIds(ids));
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
    @RequiresPermissions("system:reportManage:add")
    @Log(title = "预算管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated ReportManage reportManage)
    {
        reportManage.setCreateBy(ShiroUtils.getLoginName());
        return toAjax(reportManageService.insertReportManage(reportManage));
    }

    /**
     * 修改岗位
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        mmap.put("reportManage", reportManageService.selectReportManageById(id));
        return prefix + "/edit";
    }

    /**
     * 修改保存岗位
     */
    @RequiresPermissions("system:reportManage:edit")
    @Log(title = "岗位管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated ReportManage reportManage)
    {
        reportManage.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(reportManageService.updateReportManage(reportManage));
    }

}
