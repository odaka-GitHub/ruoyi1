package com.ruoyi.system.mapper;


import com.ruoyi.system.domain.Assess;

import java.util.List;

/**
 * 岗位信息 数据层
 * 
 * @author ruoyi
 */
public interface AssessMapper
{
    /**
     * 查询预算数据集合
     * 
     * @param assess 预算信息
     * @return 岗位数据集合
     */
    public List<Assess> selectAssessList(Assess assess);

    /**
     * 查询所有预算
     * 
     * @return 预算列表
     */
    public List<Assess> selectAssessAll();

    /**
     * 通过预算ID查询预算信息
     * 
     * @param  id
     * @return 角色对象信息
     */
    public Assess selectAssessById(Long id);

    /**
     * 批量删除岗位信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteAssessByIds(Long[] ids);

    /**
     * 修改岗位信息
     * 
     * @param assess 岗位信息
     * @return 结果
     */
    public int updateAssess(Assess assess);

    /**
     * 新增岗位信息
     * 
     * @param assess 岗位信息
     * @return 结果
     */
    public int insertAssess(Assess assess);

}
