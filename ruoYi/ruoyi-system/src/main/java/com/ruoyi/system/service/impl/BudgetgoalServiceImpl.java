package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.system.domain.Budgetgoal;
import com.ruoyi.system.mapper.BudgetgoalMapper;
import com.ruoyi.system.service.IBudgetgoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 岗位信息 服务层处理
 * 
 * @author ruoyi
 */
@Service
public class BudgetgoalServiceImpl implements IBudgetgoalService
{
    @Autowired
    private BudgetgoalMapper budgetgoalMapper;


    /**
     * 查询岗位信息集合
     * 
     * @param budgetgoal 岗位信息
     * @return 岗位信息集合
     */
    @Override
    public List<Budgetgoal> selectBudgetgoalList(Budgetgoal budgetgoal)
    {
        return budgetgoalMapper.selectBudgetgoalList(budgetgoal);
    }

    /**
     * 查询所有岗位
     * 
     * @return 岗位列表
     */
    @Override
    public List<Budgetgoal> selectBudgetgoalAll()
    {
        return budgetgoalMapper.selectBudgetgoalAll();
    }

    /**
     * 通过岗位ID查询岗位信息
     * 
     * @param id 岗位ID
     * @return 角色对象信息
     */
    @Override
    public Budgetgoal selectBudgetgoalById(Long id)
    {
        return budgetgoalMapper.selectBudgetgoalById(id);
    }

    /**
     * 批量删除岗位信息
     * 
     * @param ids 需要删除的数据ID
     * @throws Exception
     */
    @Override
    public int deleteBudgetgoalByIds(String ids) throws BusinessException
    {
        Long[] budgetIds = Convert.toLongArray(ids);
        for (Long id : budgetIds)
        {
            Budgetgoal budgetgoal = selectBudgetgoalById(id);
        }
        return budgetgoalMapper.deleteBudgetgoalByIds(budgetIds);
    }

    /**
     * 新增保存岗位信息
     * 
     * @param budgetgoal 岗位信息
     * @return 结果
     */
    @Override
    public int insertBudgetgoal(Budgetgoal budgetgoal)
    {
        return budgetgoalMapper.insertBudgetgoal(budgetgoal);
    }

    /**
     * 修改保存岗位信息
     * 
     * @param budgetgoal 岗位信息
     * @return 结果
     */
    @Override
    public int updateBudgetgoal(Budgetgoal budgetgoal)
    {
        return budgetgoalMapper.updateBudgetgoal(budgetgoal);
    }


}
