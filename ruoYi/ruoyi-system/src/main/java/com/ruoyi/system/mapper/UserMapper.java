package com.ruoyi.system.mapper;


import com.ruoyi.system.domain.User;

import java.util.List;

/**
 * 岗位信息 数据层
 *
 * @author ruoyi
 */
public interface UserMapper
{
    /**
     * 查询预算数据集合
     *
     * @param user 预算信息
     * @return 岗位数据集合
     */
    public List<User> selectUserList(User user);

    /**
     * 查询所有预算
     *
     * @return 预算列表
     */
    public List<User> selectUserAll();

    /**
     * 通过预算ID查询预算信息
     *
     * @param  id
     * @return 角色对象信息
     */
    public User selectUserById(Long id);

    /**
     * 批量删除岗位信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteUserByIds(Long[] ids);

    /**
     * 修改岗位信息
     *
     * @param user 岗位信息
     * @return 结果
     */
    public int updateUser(User user);

    /**
     * 新增岗位信息
     *
     * @param user 岗位信息
     * @return 结果
     */
    public int insertUser(User user);
    /*登录验证*/
    public List<User> login(User user);
}
