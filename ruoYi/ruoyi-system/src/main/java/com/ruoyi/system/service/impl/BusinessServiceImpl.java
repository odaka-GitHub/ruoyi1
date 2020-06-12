package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.security.Md5Utils;
import com.ruoyi.system.domain.Business;
import com.ruoyi.system.mapper.BusinessMapper;
import com.ruoyi.system.service.IBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 岗位信息 服务层处理
 * 
 * @author ruoyi
 */
@Service
public class BusinessServiceImpl implements IBusinessService
{
    @Autowired
    private BusinessMapper businessMapper;


    /**
     * 查询岗位信息集合
     * 
     * @param business 岗位信息
     * @return 岗位信息集合
     */
    @Override
    public List<Business> selectBusinessList(Business business)
    {
        return businessMapper.selectBusinessList(business);
    }

    /**
     * 查询所有岗位
     * 
     * @return 岗位列表
     */
    @Override
    public List<Business> selectBusinessAll()
    {
        return businessMapper.selectBusinessAll();
    }

    /**
     * 通过岗位ID查询岗位信息
     * 
     * @param id 岗位ID
     * @return 角色对象信息
     */
    @Override
    public Business selectBusinessById(Long id)
    {
        return businessMapper.selectBusinessById(id);
    }

    /**
     * 批量删除岗位信息
     * 
     * @param ids 需要删除的数据ID
     * @throws Exception
     */
    @Override
    public int deleteBusinessByIds(String ids) throws BusinessException
    {
        Long[] budgetIds = Convert.toLongArray(ids);
        for (Long id : budgetIds)
        {
            Business business = selectBusinessById(id);
        }
        return businessMapper.deleteBusinessByIds(budgetIds);
    }

    /**
     * 新增保存岗位信息
     * 
     * @param business 岗位信息
     * @return 结果
     */
    @Override
    public int insertBusiness(Business business)
    {
        return businessMapper.insertBusiness(business);
    }

    /**
     * 修改保存岗位信息
     * 
     * @param business 岗位信息
     * @return 结果
     */
    @Override
    public int updateBusiness(Business business)
    {
        return businessMapper.updateBusiness(business);
    }

    /**
     * 导入用户数据
     *
     * @param businessList 用户数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    @Override
    public String importBusiness(List<Business> businessList, Boolean isUpdateSupport, String operName)
    {
        if (StringUtils.isNull(businessList) || businessList.size() == 0)
        {
            throw new BusinessException("导入用户数据不能为空！");
        }
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        return successMsg.toString();
    }
}
