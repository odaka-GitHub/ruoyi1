package com.ruoyi.system.service;

import com.ruoyi.system.domain.User;

import java.util.List;

/**
 * 岗位信息 服务层
 * 
 * @author ruoyi
 */
public interface IUserService
{
    /**
     * 查询岗位信息集合
     * 
     * @param user 岗位信息
     * @return 岗位信息集合
     */
    public List<User> selectUserList(User user);

    /**
     * 查询所有岗位
     * 
     * @return 岗位列表
     */
    public List<User> selectUserAll();


    /**
     * 通过岗位ID查询岗位信息
     * 
     * @param id 岗位ID
     * @return 角色对象信息
     */
    public User selectUserById(Long id);

    /**
     * 批量删除岗位信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     * @throws Exception 异常
     */
    public int deleteUserByIds(String ids) throws Exception;

    /**
     * 新增保存岗位信息
     * 
     * @param user 岗位信息
     * @return 结果
     */
    public int insertUser(User user);

    /**
     * 修改保存岗位信息
     * 
     * @param user 岗位信息
     * @return 结果
     */
    public int updateUser(User user);

    /*登录验证*/
    public List<User> login(User user);
}
