package com.ruoyi.system.mapper;


import com.ruoyi.system.domain.Pay;

import java.util.List;

/**
 * 岗位信息 数据层
 * 
 * @author ruoyi
 */
public interface PayMapper
{
    /**
     * 查询预算数据集合
     * 
     * @param pay 预算信息
     * @return 岗位数据集合
     */
    public List<Pay> selectPayList(Pay pay);

    /**
     * 查询所有预算
     * 
     * @return 预算列表
     */
    public List<Pay> selectPayAll();

    /**
     * 通过预算ID查询预算信息
     * 
     * @param  id
     * @return 角色对象信息
     */
    public Pay selectPayById(Long id);

    /**
     * 批量删除岗位信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePayByIds(Long[] ids);

    /**
     * 修改岗位信息
     * 
     * @param pay 岗位信息
     * @return 结果
     */
    public int updatePay(Pay pay);

    /**
     * 新增岗位信息
     * 
     * @param pay 岗位信息
     * @return 结果
     */
    public int insertPay(Pay pay);

}
