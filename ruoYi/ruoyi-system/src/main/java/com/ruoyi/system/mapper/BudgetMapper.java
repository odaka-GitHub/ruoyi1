package com.ruoyi.system.mapper;


import com.ruoyi.system.domain.Budget;

import java.util.List;

/**
 * 岗位信息 数据层
 * 
 * @author ruoyi
 */
public interface BudgetMapper
{
    /**
     * 查询预算数据集合
     * 
     * @param budget 预算信息
     * @return 岗位数据集合
     */
    public List<Budget> selectBudgetList(Budget budget);

    /**
     * 查询所有预算
     * 
     * @return 预算列表
     */
    public List<Budget> selectBudgetAll();

    /**
     * 通过预算ID查询预算信息
     * 
     * @param  id
     * @return 角色对象信息
     */
    public Budget selectBudgetById(Long id);

    /**
     * 批量删除岗位信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBudgetByIds(Long[] ids);

    /**
     * 修改岗位信息
     * 
     * @param budget 岗位信息
     * @return 结果
     */
    public int updateBudget(Budget budget);

    /**
     * 新增岗位信息
     * 
     * @param budget 岗位信息
     * @return 结果
     */
    public int insertBudget(Budget budget);

}
