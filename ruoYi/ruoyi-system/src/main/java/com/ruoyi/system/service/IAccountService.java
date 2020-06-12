package com.ruoyi.system.service;


import com.ruoyi.system.domain.Account;

import java.util.List;

/**
 * 岗位信息 服务层
 * 
 * @author ruoyi
 */
public interface IAccountService
{
    /**
     * 查询岗位信息集合
     * 
     * @param account 岗位信息
     * @return 岗位信息集合
     */
    public List<Account> selectAccountList(Account account);

    /**
     * 查询所有岗位
     * 
     * @return 岗位列表
     */
    public List<Account> selectAccountAll();


    /**
     * 通过岗位ID查询岗位信息
     * 
     * @param channelId 岗位ID
     * @return 角色对象信息
     */
    public Account selectAccountById(Long channelId);

    /**
     * 批量删除岗位信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     * @throws Exception 异常
     */
    public int deleteAccountByIds(String ids) throws Exception;

    /**
     * 新增保存岗位信息
     * 
     * @param account 岗位信息
     * @return 结果
     */
    public int insertAccount(Account account);

    /**
     * 修改保存岗位信息
     * 
     * @param account 岗位信息
     * @return 结果
     */
    public int updateAccount(Account account);
}
