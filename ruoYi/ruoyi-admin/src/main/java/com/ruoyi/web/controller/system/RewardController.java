package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.Budget;
import com.ruoyi.system.domain.Reward;
import com.ruoyi.system.service.IBudgetService;
import com.ruoyi.system.service.IRewardService;
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
@RequestMapping("/system/reward")
public class RewardController extends BaseController
{
    private String prefix = "system/reward";

    @Autowired
    private IRewardService rewardService;

    @RequiresPermissions("system:reward:view")
    @GetMapping()
    public String operlog()
    {
        return prefix + "/reward";
    }

    @RequiresPermissions("system:reward:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Reward reward)
    {
        startPage();
        List<Reward> list = rewardService.selectRewardList(reward);
        return getDataTable(list);
    }

    @Log(title = "岗位管理", businessType = BusinessType.EXPORT)
    @RequiresPermissions("system:reward:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Reward reward)
    {
        List<Reward> list = rewardService.selectRewardList(reward);
        ExcelUtil<Reward> util = new ExcelUtil<Reward>(Reward.class);
        return util.exportExcel(list, "预算数据");
    }

    @RequiresPermissions("system:reward:remove")
    @Log(title = "预算管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        try
        {
            return toAjax(rewardService.deleteRewardByIds(ids));
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
    @RequiresPermissions("system:reward:add")
    @Log(title = "预算管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated Reward reward)
    {
        reward.setCreateBy(ShiroUtils.getLoginName());
        return toAjax(rewardService.insertReward(reward));
    }

    /**
     * 修改岗位
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        mmap.put("reward", rewardService.selectRewardById(id));
        return prefix + "/edit";
    }

    /**
     * 修改保存岗位
     */
    @RequiresPermissions("system:reward:edit")
    @Log(title = "岗位管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated Reward reward)
    {
        reward.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(rewardService.updateReward(reward));
    }

}
