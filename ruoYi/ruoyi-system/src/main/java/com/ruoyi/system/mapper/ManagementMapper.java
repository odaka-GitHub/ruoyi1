package com.ruoyi.system.mapper;


import com.ruoyi.system.domain.Management;

import java.util.List;

/**
 * 岗位信息 数据层
 * 
 * @author ruoyi
 */
public interface ManagementMapper
{
    /**
     * 查询预算数据集合
     * 
     * @param management 预算信息
     * @return 岗位数据集合
     */
    public List<Management> selectManagementList(Management management);

    /**
     * 查询所有预算
     * 
     * @return 预算列表
     */
    public List<Management> selectManagementAll();

    /**
     * 通过预算ID查询预算信息
     * 
     * @param  id
     * @return 角色对象信息
     */
    public Management selectManagementById(Long id);

    /**
     * 批量删除岗位信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteManagementByIds(Long[] ids);

    /**
     * 修改岗位信息
     * 
     * @param management 岗位信息
     * @return 结果
     */
    public int updateManagement(Management management);

    /**
     * 新增岗位信息
     * 
     * @param management 岗位信息
     * @return 结果
     */
    public int insertManagement(Management management);

}
