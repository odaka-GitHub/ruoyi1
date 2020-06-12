package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.system.domain.Account;
import com.ruoyi.system.domain.Reward;
import com.ruoyi.system.mapper.AccountMapper;
import com.ruoyi.system.mapper.RewardMapper;
import com.ruoyi.system.service.IAccountService;
import com.ruoyi.system.service.IRewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 岗位信息 服务层处理
 * 
 * @author ruoyi
 */
@Service
public class RewardServiceImpl implements IRewardService
{
    @Autowired
    private RewardMapper rewardMapper;


    /**
     * 查询岗位信息集合
     * 
     * @param reward 岗位信息
     * @return 岗位信息集合
     */
    @Override
    public List<Reward> selectRewardList(Reward reward)
    {
        return rewardMapper.selectRewardList(reward);
    }

    /**
     * 查询所有岗位
     * 
     * @return 岗位列表
     */
    @Override
    public List<Reward> selectRewardAll()
    {
        return rewardMapper.selectRewardAll();
    }

    /**
     * 通过岗位ID查询岗位信息
     * 
     * @param id 岗位ID
     * @return 角色对象信息
     */
    @Override
    public Reward selectRewardById(Long id)
    {
        return rewardMapper.selectRewardById(id);
    }

    /**
     * 批量删除岗位信息
     * 
     * @param ids 需要删除的数据ID
     * @throws Exception
     */
    @Override
    public int deleteRewardByIds(String ids) throws BusinessException
    {
        Long[] budgetIds = Convert.toLongArray(ids);
        for (Long id : budgetIds)
        {
            Reward reward = selectRewardById(id);
        }
        return rewardMapper.deleteRewardByIds(budgetIds);
    }

    /**
     * 新增保存岗位信息
     * 
     * @param reward 岗位信息
     * @return 结果
     */
    @Override
    public int insertReward(Reward reward)
    {
        return rewardMapper.insertReward(reward);
    }

    /**
     * 修改保存岗位信息
     * 
     * @param reward 岗位信息
     * @return 结果
     */
    @Override
    public int updateReward(Reward reward)
    {
        return rewardMapper.updateReward(reward);
    }


}
