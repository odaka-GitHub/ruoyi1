package com.ruoyi.system.service;

import com.ruoyi.system.domain.Business;

import java.util.List;

/**
 * 岗位信息 服务层
 * 
 * @author ruoyi
 */
public interface IBusinessService
{
    /**
     * 查询岗位信息集合
     * 
     * @param business 岗位信息
     * @return 岗位信息集合
     */
    public List<Business> selectBusinessList(Business business);

    /**
     * 查询所有岗位
     * 
     * @return 岗位列表
     */
    public List<Business> selectBusinessAll();


    /**
     * 通过岗位ID查询岗位信息
     * 
     * @param id 岗位ID
     * @return 角色对象信息
     */
    public Business selectBusinessById(Long id);

    /**
     * 批量删除岗位信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     * @throws Exception 异常
     */
    public int deleteBusinessByIds(String ids) throws Exception;

    /**
     * 新增保存岗位信息
     * 
     * @param business 岗位信息
     * @return 结果
     */
    public int insertBusiness(Business business);

    /**
     * 修改保存岗位信息
     * 
     * @param business 岗位信息
     * @return 结果
     */
    public int updateBusiness(Business business);

    /**
     * 导入用户数据
     *
     * @param businessList 用户数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    public String importBusiness(List<Business> businessList, Boolean isUpdateSupport, String operName);
}
