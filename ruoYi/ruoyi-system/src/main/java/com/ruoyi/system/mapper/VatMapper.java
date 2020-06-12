package com.ruoyi.system.mapper;


import com.ruoyi.system.domain.Budget;
import com.ruoyi.system.domain.Vat;

import java.util.List;

/**
 * 岗位信息 数据层
 * 
 * @author ruoyi
 */
public interface VatMapper
{
    /**
     * 查询预算数据集合
     * 
     * @param vat 预算信息
     * @return 岗位数据集合
     */
    public List<Vat> selectVatList(Vat vat);

    /**
     * 查询所有预算
     * 
     * @return 预算列表
     */
    public List<Vat> selectVatAll();

    /**
     * 通过预算ID查询预算信息
     * 
     * @param  id
     * @return 角色对象信息
     */
    public Vat selectVatById(Long id);

    /**
     * 批量删除岗位信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteVatByIds(Long[] ids);

    /**
     * 修改岗位信息
     * 
     * @param vat 岗位信息
     * @return 结果
     */
    public int updateVat(Vat vat);

    /**
     * 新增岗位信息
     * 
     * @param vat 岗位信息
     * @return 结果
     */
    public int insertVat(Vat vat);

}
