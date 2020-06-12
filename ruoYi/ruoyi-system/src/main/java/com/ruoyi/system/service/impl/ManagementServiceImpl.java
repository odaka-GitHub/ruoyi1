package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.system.domain.Management;
import com.ruoyi.system.mapper.ManagementMapper;
import com.ruoyi.system.service.IManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 岗位信息 服务层处理
 * 
 * @author ruoyi
 */
@Service
public class ManagementServiceImpl implements IManagementService
{
    @Autowired
    private ManagementMapper managementMapper;


    /**
     * 查询岗位信息集合
     * 
     * @param management 岗位信息
     * @return 岗位信息集合
     */
    @Override
    public List<Management> selectManagementList(Management management)
    {
        return managementMapper.selectManagementList(management);
    }

    /**
     * 查询所有岗位
     * 
     * @return 岗位列表
     */
    @Override
    public List<Management> selectManagementAll()
    {
        return managementMapper.selectManagementAll();
    }

    /**
     * 通过岗位ID查询岗位信息
     * 
     * @param id 岗位ID
     * @return 角色对象信息
     */
    @Override
    public Management selectManagementById(Long id)
    {
        return managementMapper.selectManagementById(id);
    }

    /**
     * 批量删除岗位信息
     * 
     * @param ids 需要删除的数据ID
     * @throws Exception
     */
    @Override
    public int deleteManagementByIds(String ids) throws BusinessException
    {
        Long[] budgetIds = Convert.toLongArray(ids);
        for (Long id : budgetIds)
        {
            Management management = selectManagementById(id);
        }
        return managementMapper.deleteManagementByIds(budgetIds);
    }

    /**
     * 新增保存岗位信息
     * 
     * @param management 岗位信息
     * @return 结果
     */
    @Override
    public int insertManagement(Management management)
    {
        return managementMapper.insertManagement(management);
    }

    /**
     * 修改保存岗位信息
     * 
     * @param management 岗位信息
     * @return 结果
     */
    @Override
    public int updateManagement(Management management)
    {
        return managementMapper.updateManagement(management);
    }


}
