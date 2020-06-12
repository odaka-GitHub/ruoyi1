package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.Assess;
import com.ruoyi.system.domain.Business;
import com.ruoyi.system.service.IAssessService;
import com.ruoyi.system.service.IBusinessService;
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
@RequestMapping("/system/assess")
public class AssessController extends BaseController
{
    private String prefix = "system/assess";

    @Autowired
    private IAssessService assessService;

    @RequiresPermissions("system:assess:view")
    @GetMapping()
    public String operlog()
    {
        return prefix + "/assess";
    }

    @RequiresPermissions("system:assess:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Assess assess)
    {
        startPage();
        List<Assess> list = assessService.selectAssessList(assess);
        return getDataTable(list);
    }

    @Log(title = "岗位管理", businessType = BusinessType.EXPORT)
    @RequiresPermissions("system:assess:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Assess assess)
    {
        List<Assess> list = assessService.selectAssessList(assess);
        ExcelUtil<Assess> util = new ExcelUtil<Assess>(Assess.class);
        return util.exportExcel(list, "预算数据");
    }

    @RequiresPermissions("system:assess:remove")
    @Log(title = "预算管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        try
        {
            return toAjax(assessService.deleteAssessByIds(ids));
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
    @RequiresPermissions("system:assess:add")
    @Log(title = "预算管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated Assess assess)
    {
        assess.setCreateBy(ShiroUtils.getLoginName());
        return toAjax(assessService.insertAssess(assess));
    }

    /**
     * 修改岗位
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        mmap.put("assess", assessService.selectAssessById(id));
        return prefix + "/edit";
    }

    /**
     * 修改保存岗位
     */
    @RequiresPermissions("system:assess:edit")
    @Log(title = "岗位管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated Assess assess)
    {
        assess.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(assessService.updateAssess(assess));
    }

}
