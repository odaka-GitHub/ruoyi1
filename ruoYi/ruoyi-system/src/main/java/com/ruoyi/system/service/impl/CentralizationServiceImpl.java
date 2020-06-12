package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.system.domain.Centralization;
import com.ruoyi.system.mapper.CentralizationMapper;
import com.ruoyi.system.service.ICentralizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 岗位信息 服务层处理
 * 
 * @author ruoyi
 */
@Service
public class CentralizationServiceImpl implements ICentralizationService
{
    @Autowired
    private CentralizationMapper centralizationMapper;


    /**
     * 查询岗位信息集合
     * 
     * @param centralization 岗位信息
     * @return 岗位信息集合
     */
    @Override
    public List<Centralization> selectCentralizationList(Centralization centralization)
    {
        return centralizationMapper.selectCentralizationList(centralization);
    }

    /**
     * 查询所有岗位
     * 
     * @return 岗位列表
     */
    @Override
    public List<Centralization> selectCentralizationAll()
    {
        return centralizationMapper.selectCentralizationAll();
    }

    /**
     * 通过岗位ID查询岗位信息
     * 
     * @param id 岗位ID
     * @return 角色对象信息
     */
    @Override
    public Centralization selectCentralizationById(Long id)
    {
        return centralizationMapper.selectCentralizationById(id);
    }

    /**
     * 批量删除岗位信息
     * 
     * @param ids 需要删除的数据ID
     * @throws Exception
     */
    @Override
    public int deleteCentralizationByIds(String ids) throws BusinessException
    {
        Long[] budgetIds = Convert.toLongArray(ids);
        for (Long id : budgetIds)
        {
            Centralization centralization = selectCentralizationById(id);
        }
        return centralizationMapper.deleteCentralizationByIds(budgetIds);
    }

    /**
     * 新增保存岗位信息
     * 
     * @param centralization 岗位信息
     * @return 结果
     */
    @Override
    public int insertCentralization(Centralization centralization)
    {
        return centralizationMapper.insertCentralization(centralization);
    }

    /**
     * 修改保存岗位信息
     * 
     * @param centralization 岗位信息
     * @return 结果
     */
    @Override
    public int updateCentralization(Centralization centralization)
    {
        return centralizationMapper.updateCentralization(centralization);
    }


}
