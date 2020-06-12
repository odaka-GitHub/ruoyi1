package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.system.domain.SpecialInvoice;
import com.ruoyi.system.mapper.SpecialInvoiceMapper;
import com.ruoyi.system.service.ISpecialInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 岗位信息 服务层处理
 * 
 * @author ruoyi
 */
@Service
public class SpecialInvoiceServiceImpl implements ISpecialInvoiceService
{
    @Autowired
    private SpecialInvoiceMapper specialInvoiceMapper;


    /**
     * 查询岗位信息集合
     * 
     * @param specialInvoice 岗位信息
     * @return 岗位信息集合
     */
    @Override
    public List<SpecialInvoice> selectSpecialInvoiceList(SpecialInvoice specialInvoice)
    {
        return specialInvoiceMapper.selectSpecialInvoiceList(specialInvoice);
    }

    /**
     * 查询所有岗位
     * 
     * @return 岗位列表
     */
    @Override
    public List<SpecialInvoice> selectSpecialInvoiceAll()
    {
        return specialInvoiceMapper.selectSpecialInvoiceAll();
    }

    /**
     * 通过岗位ID查询岗位信息
     * 
     * @param id 岗位ID
     * @return 角色对象信息
     */
    @Override
    public SpecialInvoice selectSpecialInvoiceById(Long id)
    {
        return specialInvoiceMapper.selectSpecialInvoiceById(id);
    }

    /**
     * 批量删除岗位信息
     * 
     * @param ids 需要删除的数据ID
     * @throws Exception
     */
    @Override
    public int deleteSpecialInvoiceByIds(String ids) throws BusinessException
    {
        Long[] budgetIds = Convert.toLongArray(ids);
        for (Long id : budgetIds)
        {
            SpecialInvoice specialInvoice = selectSpecialInvoiceById(id);
        }
        return specialInvoiceMapper.deleteSpecialInvoiceByIds(budgetIds);
    }

    /**
     * 新增保存岗位信息
     * 
     * @param specialInvoice 岗位信息
     * @return 结果
     */
    @Override
    public int insertSpecialInvoice(SpecialInvoice specialInvoice)
    {
        return specialInvoiceMapper.insertSpecialInvoice(specialInvoice);
    }

    /**
     * 修改保存岗位信息
     * 
     * @param specialInvoice 岗位信息
     * @return 结果
     */
    @Override
    public int updateSpecialInvoice(SpecialInvoice specialInvoice)
    {
        return specialInvoiceMapper.updateSpecialInvoice(specialInvoice);
    }


}
