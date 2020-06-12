package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Statistics;

import java.util.List;

/**
 * 岗位信息 数据层
 * 
 * @author ruoyi
 */
public interface StatisticsMapper
{
    /**
     * 查询预算数据集合
     * 
     * @param statistics 预算信息
     * @return 岗位数据集合
     */
    public List<Statistics> selectStatisticsList(Statistics statistics);

    /**
     * 查询所有预算
     * 
     * @return 预算列表
     */
    public List<Statistics> selectStatisticsAll();

    /**
     * 通过预算ID查询预算信息
     * 
     * @param  id
     * @return 角色对象信息
     */
    public Statistics selectStatisticsById(Long id);

    /**
     * 批量删除岗位信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteStatisticsByIds(Long[] ids);

    /**
     * 修改岗位信息
     * 
     * @param statistics 岗位信息
     * @return 结果
     */
    public int updateStatistics(Statistics statistics);

    /**
     * 新增岗位信息
     * 
     * @param statistics 岗位信息
     * @return 结果
     */
    public int insertStatistics(Statistics statistics);

}
