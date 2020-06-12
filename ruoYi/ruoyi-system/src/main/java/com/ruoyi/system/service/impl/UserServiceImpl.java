package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.system.domain.User;
import com.ruoyi.system.domain.Vat;
import com.ruoyi.system.mapper.UserMapper;
import com.ruoyi.system.mapper.VatMapper;
import com.ruoyi.system.service.IUserService;
import com.ruoyi.system.service.IVatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 岗位信息 服务层处理
 * 
 * @author ruoyi
 */
@Service
public class UserServiceImpl implements IUserService
{
    @Autowired
    private UserMapper userMapper;


    /**
     * 查询岗位信息集合
     * 
     * @param user 岗位信息
     * @return 岗位信息集合
     */
    @Override
    public List<User> selectUserList(User user)
    {
        return userMapper.selectUserList(user);
    }

    /**
     * 查询所有岗位
     * 
     * @return 岗位列表
     */
    @Override
    public List<User> selectUserAll()
    {
        return userMapper.selectUserAll();
    }

    /**
     * 通过岗位ID查询岗位信息
     * 
     * @param id 岗位ID
     * @return 角色对象信息
     */
    @Override
    public User selectUserById(Long id)
    {
        return userMapper.selectUserById(id);
    }

    /**
     * 批量删除岗位信息
     * 
     * @param ids 需要删除的数据ID
     * @throws Exception
     */
    @Override
    public int deleteUserByIds(String ids) throws BusinessException
    {
        Long[] budgetIds = Convert.toLongArray(ids);
        for (Long id : budgetIds)
        {
            User user = selectUserById(id);
        }
        return userMapper.deleteUserByIds(budgetIds);
    }

    /**
     * 新增保存岗位信息
     * 
     * @param user 岗位信息
     * @return 结果
     */
    @Override
    public int insertUser(User user)
    {
        return userMapper.insertUser(user);
    }

    /**
     * 修改保存岗位信息
     * 
     * @param user 岗位信息
     * @return 结果
     */
    @Override
    public int updateUser(User user)
    {
        return userMapper.updateUser(user);
    }

    /*登录验证*/
    @Override
    public List<User> login(User user) {
        return userMapper.login(user);
    }


}
