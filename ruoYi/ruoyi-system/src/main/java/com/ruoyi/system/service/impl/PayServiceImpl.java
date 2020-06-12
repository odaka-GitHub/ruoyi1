package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.system.domain.Pay;
import com.ruoyi.system.mapper.PayMapper;
import com.ruoyi.system.service.IPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 岗位信息 服务层处理
 * 
 * @author ruoyi
 */
@Service
public class PayServiceImpl implements IPayService
{
    @Autowired
    private PayMapper payMapper;


    /**
     * 查询岗位信息集合
     * 
     * @param pay 岗位信息
     * @return 岗位信息集合
     */
    @Override
    public List<Pay> selectPayList(Pay pay)
    {
        return payMapper.selectPayList(pay);
    }

    /**
     * 查询所有岗位
     * 
     * @return 岗位列表
     */
    @Override
    public List<Pay> selectPayAll()
    {
        return payMapper.selectPayAll();
    }

    /**
     * 通过岗位ID查询岗位信息
     * 
     * @param id 岗位ID
     * @return 角色对象信息
     */
    @Override
    public Pay selectPayById(Long id)
    {
        return payMapper.selectPayById(id);
    }

    /**
     * 批量删除岗位信息
     * 
     * @param ids 需要删除的数据ID
     * @throws Exception
     */
    @Override
    public int deletePayByIds(String ids) throws BusinessException
    {
        Long[] budgetIds = Convert.toLongArray(ids);
        for (Long id : budgetIds)
        {
            Pay pay = selectPayById(id);
        }
        return payMapper.deletePayByIds(budgetIds);
    }

    /**
     * 新增保存岗位信息
     * 
     * @param pay 岗位信息
     * @return 结果
     */
    @Override
    public int insertPay(Pay pay)
    {
        return payMapper.insertPay(pay);
    }

    /**
     * 修改保存岗位信息
     * 
     * @param pay 岗位信息
     * @return 结果
     */
    @Override
    public int updatePay(Pay pay)
    {
        return payMapper.updatePay(pay);
    }


}
