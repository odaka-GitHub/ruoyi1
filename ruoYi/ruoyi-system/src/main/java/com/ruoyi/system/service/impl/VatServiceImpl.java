package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.system.domain.Budget;
import com.ruoyi.system.domain.Vat;
import com.ruoyi.system.mapper.BudgetMapper;
import com.ruoyi.system.mapper.VatMapper;
import com.ruoyi.system.service.IBudgetService;
import com.ruoyi.system.service.IVatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 岗位信息 服务层处理
 * 
 * @author ruoyi
 */
@Service
public class VatServiceImpl implements IVatService
{
    @Autowired
    private VatMapper vatMapper;


    /**
     * 查询岗位信息集合
     * 
     * @param vat 岗位信息
     * @return 岗位信息集合
     */
    @Override
    public List<Vat> selectVatList(Vat vat)
    {
        return vatMapper.selectVatList(vat);
    }

    /**
     * 查询所有岗位
     * 
     * @return 岗位列表
     */
    @Override
    public List<Vat> selectVatAll()
    {
        return vatMapper.selectVatAll();
    }

    /**
     * 通过岗位ID查询岗位信息
     * 
     * @param id 岗位ID
     * @return 角色对象信息
     */
    @Override
    public Vat selectVatById(Long id)
    {
        return vatMapper.selectVatById(id);
    }

    /**
     * 批量删除岗位信息
     * 
     * @param ids 需要删除的数据ID
     * @throws Exception
     */
    @Override
    public int deleteVatByIds(String ids) throws BusinessException
    {
        Long[] budgetIds = Convert.toLongArray(ids);
        for (Long id : budgetIds)
        {
            Vat vat = selectVatById(id);
        }
        return vatMapper.deleteVatByIds(budgetIds);
    }

    /**
     * 新增保存岗位信息
     * 
     * @param vat 岗位信息
     * @return 结果
     */
    @Override
    public int insertVat(Vat vat)
    {
        return vatMapper.insertVat(vat);
    }

    /**
     * 修改保存岗位信息
     * 
     * @param vat 岗位信息
     * @return 结果
     */
    @Override
    public int updateVat(Vat vat)
    {
        return vatMapper.updateVat(vat);
    }


}
