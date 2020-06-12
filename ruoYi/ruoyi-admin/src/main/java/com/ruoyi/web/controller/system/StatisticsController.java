package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.Statistics;
import com.ruoyi.system.domain.Vat;
import com.ruoyi.system.service.IStatisticsService;
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
@RequestMapping("/system/statistics")
public class StatisticsController extends BaseController
{
    private String prefix = "system/statistics";

    @Autowired
    private IStatisticsService statisticsService;

    @RequiresPermissions("system:statistics:view")
    @GetMapping()
    public String operlog()
    {
        return prefix + "/statistics";
    }

    @RequiresPermissions("system:statistics:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Statistics statistics)
    {
        startPage();
        List<Statistics> list = statisticsService.selectStatisticsList(statistics);
        return getDataTable(list);
    }

    @Log(title = "普票管理", businessType = BusinessType.EXPORT)
    @RequiresPermissions("system:statistics:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Statistics statistics)
    {
        List<Statistics> list = statisticsService.selectStatisticsList(statistics);
        ExcelUtil<Statistics> util = new ExcelUtil<Statistics>(Statistics.class);
        return util.exportExcel(list, "普票数据");
    }

    @RequiresPermissions("system:statistics:remove")
    @Log(title = "普票管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        try
        {
            return toAjax(statisticsService.deleteStatisticsByIds(ids));
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
    @RequiresPermissions("system:statistics:add")
    @Log(title = "普票管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated Statistics statistics)
    {
        statistics.setCreateBy(ShiroUtils.getLoginName());
        return toAjax(statisticsService.insertStatistics(statistics));
    }

    /**
     * 修改岗位
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        mmap.put("statistics", statisticsService.selectStatisticsById(id));
        return prefix + "/edit";
    }

    /**
     * 修改保存岗位
     */
    @RequiresPermissions("system:statistics:edit")
    @Log(title = "岗位管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated Statistics statistics)
    {
        statistics.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(statisticsService.updateStatistics(statistics));
    }

}
