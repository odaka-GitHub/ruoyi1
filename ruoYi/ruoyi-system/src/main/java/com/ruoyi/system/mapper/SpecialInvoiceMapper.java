package com.ruoyi.system.mapper;


import com.ruoyi.system.domain.SpecialInvoice;

import java.util.List;

/**
 * 岗位信息 数据层
 * 
 * @author ruoyi
 */
public interface SpecialInvoiceMapper
{
    /**
     * 查询预算数据集合
     * 
     * @param specialInvoice 预算信息
     * @return 岗位数据集合
     */
    public List<SpecialInvoice> selectSpecialInvoiceList(SpecialInvoice specialInvoice);

    /**
     * 查询所有预算
     * 
     * @return 预算列表
     */
    public List<SpecialInvoice> selectSpecialInvoiceAll();

    /**
     * 通过预算ID查询预算信息
     * 
     * @param  id
     * @return 角色对象信息
     */
    public SpecialInvoice selectSpecialInvoiceById(Long id);

    /**
     * 批量删除岗位信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSpecialInvoiceByIds(Long[] ids);

    /**
     * 修改岗位信息
     * 
     * @param specialInvoice 岗位信息
     * @return 结果
     */
    public int updateSpecialInvoice(SpecialInvoice specialInvoice);

    /**
     * 新增岗位信息
     * 
     * @param specialInvoice 岗位信息
     * @return 结果
     */
    public int insertSpecialInvoice(SpecialInvoice specialInvoice);

}
