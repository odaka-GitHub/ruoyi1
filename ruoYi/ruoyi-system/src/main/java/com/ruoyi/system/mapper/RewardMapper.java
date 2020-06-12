package com.ruoyi.system.mapper;



import com.ruoyi.system.domain.Reward;

import java.util.List;

/**
 * 岗位信息 数据层
 * 
 * @author ruoyi
 */
public interface RewardMapper
{
    /**
     * 查询预算数据集合
     * 
     * @param reward 预算信息
     * @return 岗位数据集合
     */
    public List<Reward> selectRewardList(Reward reward);

    /**
     * 查询所有预算
     * 
     * @return 预算列表
     */
    public List<Reward> selectRewardAll();

    /**
     * 通过预算ID查询预算信息
     * 
     * @param  id
     * @return 角色对象信息
     */
    public Reward selectRewardById(Long id);

    /**
     * 批量删除岗位信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteRewardByIds(Long[] ids);

    /**
     * 修改岗位信息
     * 
     * @param reward 岗位信息
     * @return 结果
     */
    public int updateReward(Reward reward);

    /**
     * 新增岗位信息
     * 
     * @param reward 岗位信息
     * @return 结果
     */
    public int insertReward(Reward reward);

}
