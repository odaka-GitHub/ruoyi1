package com.ruoyi.system.mapper;


import com.ruoyi.system.domain.Business;

import java.util.List;

/**
 * 岗位信息 数据层
 * 
 * @author ruoyi
 */
public interface BusinessMapper
{
    /**
     * 查询预算数据集合
     * 
     * @param business 预算信息
     * @return 岗位数据集合
     */
    public List<Business> selectBusinessList(Business business);

    /**
     * 查询所有预算
     * 
     * @return 预算列表
     */
    public List<Business> selectBusinessAll();

    /**
     * 通过预算ID查询预算信息
     * 
     * @param  id
     * @return 角色对象信息
     */
    public Business selectBusinessById(Long id);

    /**
     * 批量删除岗位信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusinessByIds(Long[] ids);

    /**
     * 修改岗位信息
     * 
     * @param business 岗位信息
     * @return 结果
     */
    public int updateBusiness(Business business);

    /**
     * 新增岗位信息
     * 
     * @param business 岗位信息
     * @return 结果
     */
    public int insertBusiness(Business business);

}
