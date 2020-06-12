package com.ruoyi.system.mapper;


import com.ruoyi.system.domain.Centralization;

import java.util.List;

/**
 * 岗位信息 数据层
 * 
 * @author ruoyi
 */
public interface CentralizationMapper
{
    /**
     * 查询预算数据集合
     * 
     * @param centralization 预算信息
     * @return 岗位数据集合
     */
    public List<Centralization> selectCentralizationList(Centralization centralization);

    /**
     * 查询所有预算
     * 
     * @return 预算列表
     */
    public List<Centralization> selectCentralizationAll();

    /**
     * 通过预算ID查询预算信息
     * 
     * @param  id
     * @return 角色对象信息
     */
    public Centralization selectCentralizationById(Long id);

    /**
     * 批量删除岗位信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCentralizationByIds(Long[] ids);

    /**
     * 修改岗位信息
     * 
     * @param centralization 岗位信息
     * @return 结果
     */
    public int updateCentralization(Centralization centralization);

    /**
     * 新增岗位信息
     * 
     * @param centralization 岗位信息
     * @return 结果
     */
    public int insertCentralization(Centralization centralization);

}
