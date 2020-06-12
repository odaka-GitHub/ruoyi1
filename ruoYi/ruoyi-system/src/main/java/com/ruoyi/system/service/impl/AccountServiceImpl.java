package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.system.domain.Account;
import com.ruoyi.system.domain.Pay;
import com.ruoyi.system.mapper.AccountMapper;
import com.ruoyi.system.mapper.PayMapper;
import com.ruoyi.system.service.IAccountService;
import com.ruoyi.system.service.IPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 岗位信息 服务层处理
 * 
 * @author ruoyi
 */
@Service
public class AccountServiceImpl implements IAccountService
{
    @Autowired
    private AccountMapper accountMapper;


    /**
     * 查询岗位信息集合
     * 
     * @param account 岗位信息
     * @return 岗位信息集合
     */
    @Override
    public List<Account> selectAccountList(Account account)
    {
        return accountMapper.selectAccountList(account);
    }

    /**
     * 查询所有岗位
     * 
     * @return 岗位列表
     */
    @Override
    public List<Account> selectAccountAll()
    {
        return accountMapper.selectAccountAll();
    }

    /**
     * 通过岗位ID查询岗位信息
     * 
     * @param channelId 岗位ID
     * @return 角色对象信息
     */
    @Override
    public Account selectAccountById(Long channelId)
    {
        return accountMapper.selectAccountById(channelId);
    }

    /**
     * 批量删除岗位信息
     * 
     * @param ids 需要删除的数据ID
     * @throws Exception
     */
    @Override
    public int deleteAccountByIds(String ids) throws BusinessException
    {
        Long[] budgetIds = Convert.toLongArray(ids);
        for (Long channelId : budgetIds)
        {
            Account account = selectAccountById(channelId);
        }
        return accountMapper.deleteAccountByIds(budgetIds);
    }

    /**
     * 新增保存岗位信息
     * 
     * @param account 岗位信息
     * @return 结果
     */
    @Override
    public int insertAccount(Account account)
    {
        return accountMapper.insertAccount(account);
    }

    /**
     * 修改保存岗位信息
     * 
     * @param account 岗位信息
     * @return 结果
     */
    @Override
    public int updateAccount(Account account)
    {
        return accountMapper.updateAccount(account);
    }


}
