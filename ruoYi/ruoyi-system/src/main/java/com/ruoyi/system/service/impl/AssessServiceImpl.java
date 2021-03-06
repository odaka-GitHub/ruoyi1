package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.system.domain.Assess;
import com.ruoyi.system.mapper.AssessMapper;
import com.ruoyi.system.service.IAssessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 岗位信息 服务层处理
 * 
 * @author ruoyi
 */
@Service
public class AssessServiceImpl implements IAssessService
{
    @Autowired
    private AssessMapper assessMapper;


    /**
     * 查询岗位信息集合
     * 
     * @param assess 岗位信息
     * @return 岗位信息集合
     */
    @Override
    public List<Assess> selectAssessList(Assess assess)
    {
        return assessMapper.selectAssessList(assess);
    }

    /**
     * 查询所有岗位
     * 
     * @return 岗位列表
     */
    @Override
    public List<Assess> selectAssessAll()
    {
        return assessMapper.selectAssessAll();
    }

    /**
     * 通过岗位ID查询岗位信息
     * 
     * @param id 岗位ID
     * @return 角色对象信息
     */
    @Override
    public Assess selectAssessById(Long id)
    {
        return assessMapper.selectAssessById(id);
    }

    /**
     * 批量删除岗位信息
     * 
     * @param ids 需要删除的数据ID
     * @throws Exception
     */
    @Override
    public int deleteAssessByIds(String ids) throws Exception
    {
        Long[] budgetIds = Convert.toLongArray(ids);
        for (Long id : budgetIds)
        {
            Assess assess = selectAssessById(id);
        }
        return assessMapper.deleteAssessByIds(budgetIds);
    }

    /**
     * 新增保存岗位信息
     * 
     * @param assess 岗位信息
     * @return 结果
     */
    @Override
    public int insertAssess(Assess assess)
    {
        return assessMapper.insertAssess(assess);
    }

    /**
     * 修改保存岗位信息
     * 
     * @param assess 岗位信息
     * @return 结果
     */
    @Override
    public int updateAssess(Assess assess)
    {
        return assessMapper.updateAssess(assess);
    }


}
