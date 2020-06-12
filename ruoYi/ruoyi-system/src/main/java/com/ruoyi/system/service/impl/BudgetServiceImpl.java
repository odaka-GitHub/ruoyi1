package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.system.domain.Budget;
import com.ruoyi.system.mapper.BudgetMapper;
import com.ruoyi.system.service.IBudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 岗位信息 服务层处理
 * 
 * @author ruoyi
 */
@Service
public class BudgetServiceImpl implements IBudgetService
{
    @Autowired
    private BudgetMapper budgetMapper;


    /**
     * 查询岗位信息集合
     * 
     * @param budget 岗位信息
     * @return 岗位信息集合
     */
    @Override
    public List<Budget> selectBudgetList(Budget budget)
    {
        return budgetMapper.selectBudgetList(budget);
    }

    /**
     * 查询所有岗位
     * 
     * @return 岗位列表
     */
    @Override
    public List<Budget> selectBudgetAll()
    {
        return budgetMapper.selectBudgetAll();
    }

    /**
     * 通过岗位ID查询岗位信息
     * 
     * @param id 岗位ID
     * @return 角色对象信息
     */
    @Override
    public Budget selectBudgetById(Long id)
    {
        return budgetMapper.selectBudgetById(id);
    }

    /**
     * 批量删除岗位信息
     * 
     * @param ids 需要删除的数据ID
     * @throws Exception
     */
    @Override
    public int deleteBudgetByIds(String ids) throws BusinessException
    {
        Long[] budgetIds = Convert.toLongArray(ids);
        for (Long id : budgetIds)
        {
            Budget budget = selectBudgetById(id);
        }
        return budgetMapper.deleteBudgetByIds(budgetIds);
    }

    /**
     * 新增保存岗位信息
     * 
     * @param budget 岗位信息
     * @return 结果
     */
    @Override
    public int insertBudget(Budget budget)
    {
        return budgetMapper.insertBudget(budget);
    }

    /**
     * 修改保存岗位信息
     * 
     * @param budget 岗位信息
     * @return 结果
     */
    @Override
    public int updateBudget(Budget budget)
    {
        return budgetMapper.updateBudget(budget);
    }


}
