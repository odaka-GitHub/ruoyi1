package com.ruoyi.system.mapper;


import com.ruoyi.system.domain.Account;

import java.util.List;

/**
 * 岗位信息 数据层
 * 
 * @author ruoyi
 */
public interface AccountMapper
{
    /**
     * 查询预算数据集合
     * 
     * @param account 预算信息
     * @return 岗位数据集合
     */
    public List<Account> selectAccountList(Account account);

    /**
     * 查询所有预算
     * 
     * @return 预算列表
     */
    public List<Account> selectAccountAll();

    /**
     * 通过预算ID查询预算信息
     * 
     * @param  channelId
     * @return 角色对象信息
     */
    public Account selectAccountById(Long channelId);

    /**
     * 批量删除岗位信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteAccountByIds(Long[] ids);

    /**
     * 修改岗位信息
     * 
     * @param account 岗位信息
     * @return 结果
     */
    public int updateAccount(Account account);

    /**
     * 新增岗位信息
     * 
     * @param account 岗位信息
     * @return 结果
     */
    public int insertAccount(Account account);

}
