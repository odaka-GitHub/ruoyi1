package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.system.domain.Statistics;
import com.ruoyi.system.mapper.StatisticsMapper;
import com.ruoyi.system.service.IStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 岗位信息 服务层处理
 * 
 * @author ruoyi
 */
@Service
public class StatisticsServiceImpl implements IStatisticsService
{
    @Autowired
    private StatisticsMapper statisticsMapper;


    /**
     * 查询岗位信息集合
     * 
     * @param statistics 岗位信息
     * @return 岗位信息集合
     */
    @Override
    public List<Statistics> selectStatisticsList(Statistics statistics)
    {
        return statisticsMapper.selectStatisticsList(statistics);
    }

    /**
     * 查询所有岗位
     * 
     * @return 岗位列表
     */
    @Override
    public List<Statistics> selectStatisticsAll()
    {
        return statisticsMapper.selectStatisticsAll();
    }

    /**
     * 通过岗位ID查询岗位信息
     * 
     * @param id 岗位ID
     * @return 角色对象信息
     */
    @Override
    public Statistics selectStatisticsById(Long id)
    {
        return statisticsMapper.selectStatisticsById(id);
    }

    /**
     * 批量删除岗位信息
     * 
     * @param ids 需要删除的数据ID
     * @throws Exception
     */
    @Override
    public int deleteStatisticsByIds(String ids) throws BusinessException
    {
        Long[] budgetIds = Convert.toLongArray(ids);
        for (Long id : budgetIds)
        {
            Statistics statistics = selectStatisticsById(id);
        }
        return statisticsMapper.deleteStatisticsByIds(budgetIds);
    }

    /**
     * 新增保存岗位信息
     * 
     * @param statistics 岗位信息
     * @return 结果
     */
    @Override
    public int insertStatistics(Statistics statistics)
    {
        return statisticsMapper.insertStatistics(statistics);
    }

    /**
     * 修改保存岗位信息
     * 
     * @param statistics 岗位信息
     * @return 结果
     */
    @Override
    public int updateStatistics(Statistics statistics)
    {
        return statisticsMapper.updateStatistics(statistics);
    }


}
