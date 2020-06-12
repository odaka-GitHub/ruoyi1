package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.Business;
import com.ruoyi.system.service.IBusinessService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 岗位信息操作处理
 * 
 * @author ruoyi
 */
@Controller
@RequestMapping("/system/business")
public class BusinessController extends BaseController
{
    private String prefix = "system/business";

    @Autowired
    private IBusinessService businessService;

    @RequiresPermissions("system:business:view")
    @GetMapping()
    public String operlog()
    {
        return prefix + "/business";
    }

    @RequiresPermissions("system:business:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Business business)
    {
        startPage();
        List<Business> list = businessService.selectBusinessList(business);
        return getDataTable(list);
    }

    @Log(title = "岗位管理", businessType = BusinessType.EXPORT)
    @RequiresPermissions("system:business:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Business business)
    {
        List<Business> list = businessService.selectBusinessList(business);
        ExcelUtil<Business> util = new ExcelUtil<Business>(Business.class);
        return util.exportExcel(list, "预算数据");
    }

    @Log(title = "用户管理", businessType = BusinessType.IMPORT)
    @RequiresPermissions("system:business:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<Business> util = new ExcelUtil<Business>(Business.class);
        List<Business> userList = util.importExcel(file.getInputStream());
        String operName = ShiroUtils.getSysUser().getLoginName();
        String message = businessService.importBusiness(userList, updateSupport, operName);
        return AjaxResult.success(message);
    }

    @RequiresPermissions("system:business:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<Business> util = new ExcelUtil<Business>(Business.class);
        return util.importTemplateExcel("用户数据");
    }



    @RequiresPermissions("system:business:remove")
    @Log(title = "预算管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        try
        {
            return toAjax(businessService.deleteBusinessByIds(ids));
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
    @RequiresPermissions("system:business:add")
    @Log(title = "预算管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated Business business)
    {
        business.setCreateBy(ShiroUtils.getLoginName());
        return toAjax(businessService.insertBusiness(business));
    }

    /**
     * 修改岗位
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        mmap.put("business", businessService.selectBusinessById(id));
        return prefix + "/edit";
    }

    /**
     * 修改保存岗位
     */
    @RequiresPermissions("system:business:edit")
    @Log(title = "岗位管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated Business business)
    {
        business.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(businessService.updateBusiness(business));
    }

}
