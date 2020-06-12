package com.ruoyi.system.mapper;


import com.ruoyi.system.domain.General;

import java.util.List;

/**
 * 岗位信息 数据层
 * 
 * @author ruoyi
 */
public interface GeneralMapper
{
    /**
     * 查询预算数据集合
     * 
     * @param general 预算信息
     * @return 岗位数据集合
     */
    public List<General> selectGeneralList(General general);

    /**
     * 查询所有预算
     * 
     * @return 预算列表
     */
    public List<General> selectGeneralAll();

    /**
     * 通过预算ID查询预算信息
     * 
     * @param  id
     * @return 角色对象信息
     */
    public General selectGeneralById(Long id);

    /**
     * 批量删除岗位信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteGeneralByIds(Long[] ids);

    /**
     * 修改岗位信息
     * 
     * @param general 岗位信息
     * @return 结果
     */
    public int updateGeneral(General general);

    /**
     * 新增岗位信息
     * 
     * @param general 岗位信息
     * @return 结果
     */
    public int insertGeneral(General general);

}
