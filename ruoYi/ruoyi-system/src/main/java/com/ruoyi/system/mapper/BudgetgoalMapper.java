package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Budgetgoal;

import java.util.List;

/**
 * 岗位信息 数据层
 * 
 * @author ruoyi
 */
public interface BudgetgoalMapper
{
    /**
     * 查询预算数据集合
     * 
     * @param budgetgoal 预算信息
     * @return 岗位数据集合
     */
    public List<Budgetgoal> selectBudgetgoalList(Budgetgoal budgetgoal);

    /**
     * 查询所有预算
     * 
     * @return 预算列表
     */
    public List<Budgetgoal> selectBudgetgoalAll();

    /**
     * 通过预算ID查询预算信息
     * 
     * @param  id
     * @return 角色对象信息
     */
    public Budgetgoal selectBudgetgoalById(Long id);

    /**
     * 批量删除岗位信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBudgetgoalByIds(Long[] ids);

    /**
     * 修改岗位信息
     * 
     * @param budgetgoal 岗位信息
     * @return 结果
     */
    public int updateBudgetgoal(Budgetgoal budgetgoal);

    /**
     * 新增岗位信息
     * 
     * @param budgetgoal 岗位信息
     * @return 结果
     */
    public int insertBudgetgoal(Budgetgoal budgetgoal);

}
