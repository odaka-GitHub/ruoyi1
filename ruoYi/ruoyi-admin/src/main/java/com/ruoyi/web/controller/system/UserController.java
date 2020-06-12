package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.User;
import com.ruoyi.system.service.IUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 岗位信息操作处理
 * 
 * @author ruoyi
 */
@Controller
@RequestMapping("/system/users")
public class UserController extends BaseController
{
    private String prefix = "system/users";

    @Autowired
    private IUserService userService;

    @RequiresPermissions("system:users:view")
    @GetMapping()
    public String operlog()
    {
        return prefix + "/users";
    }

    @RequiresPermissions("system:users:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(User users)
    {
        startPage();
        List<User> list = userService.selectUserList(users);
        return getDataTable(list);
    }

    @Log(title = "普票管理", businessType = BusinessType.EXPORT)
    @RequiresPermissions("system:users:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(User users)
    {
        List<User> list = userService.selectUserList(users);
        ExcelUtil<User> util = new ExcelUtil<User>(User.class);
        return util.exportExcel(list, "普票数据");
    }

    @RequiresPermissions("system:users:remove")
    @Log(title = "普票管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        try
        {
            return toAjax(userService.deleteUserByIds(ids));
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
    @RequiresPermissions("system:users:add")
    @Log(title = "普票管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated User users)
    {
        users.setCreateBy(ShiroUtils.getLoginName());
        return toAjax(userService.insertUser(users));
    }

    /**
     * 修改岗位
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        mmap.put("users", userService.selectUserById(id));
        return prefix + "/edit";
    }

    /**
     * 修改保存岗位
     */
    @RequiresPermissions("system:users:edit")
    @Log(title = "岗位管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated User users)
    {
        users.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(userService.updateUser(users));
    }
    /*登录验证*/
    @RequestMapping("/login")
    public String login(User user, HttpSession session){
        String forword="success";
        user = (User) userService.login(user);
        if (user!=null){
            session.setAttribute("LOGIN_USER",user);
            logger.debug(user.getUserName()+"登录成功！");
        }else {
            forword="redirect:/index";
            logger.debug("登录失败!");
        }
        return forword;
    }
}
