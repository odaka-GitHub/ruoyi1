package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.ContentMaintain;
import com.ruoyi.system.service.IContentMaintainService;
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
@RequestMapping("/system/contentMaintain")
public class ContentMaintainController extends BaseController
{
    private String prefix = "system/contentMaintain";

    @Autowired
    private IContentMaintainService contentMaintainService;

    @RequiresPermissions("system:contentMaintain:view")
    @GetMapping()
    public String operlog()
    {
        return prefix + "/contentMaintain";
    }

    @RequiresPermissions("system:contentMaintain:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ContentMaintain contentMaintain)
    {
        startPage();
        List<ContentMaintain> list = contentMaintainService.selectContentMaintainList(contentMaintain);
        return getDataTable(list);
    }

    @Log(title = "内容维护管理", businessType = BusinessType.EXPORT)
    @RequiresPermissions("system:contentMaintain:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ContentMaintain contentMaintain)
    {
        List<ContentMaintain> list = contentMaintainService.selectContentMaintainList(contentMaintain);
        ExcelUtil<ContentMaintain> util = new ExcelUtil<ContentMaintain>(ContentMaintain.class);
        return util.exportExcel(list, "普票数据");
    }

    @RequiresPermissions("system:contentMaintain:remove")
    @Log(title = "普票管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        try
        {
            return toAjax(contentMaintainService.deleteContentMaintainByIds(ids));
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
    @RequiresPermissions("system:contentMaintain:add")
    @Log(title = "内容维护管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated ContentMaintain contentMaintain)
    {
        contentMaintain.setCreateBy(ShiroUtils.getLoginName());
        return toAjax(contentMaintainService.insertContentMaintain(contentMaintain));
    }

    /**
     * 修改岗位
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        mmap.put("contentMaintain", contentMaintainService.selectContentMaintainById(id));
        return prefix + "/edit";
    }

    /**
     * 修改保存岗位
     */
    @RequiresPermissions("system:contentMaintain:edit")
    @Log(title = "内容维护管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated ContentMaintain contentMaintain)
    {
        contentMaintain.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(contentMaintainService.updateContentMaintain(contentMaintain));
    }

}
