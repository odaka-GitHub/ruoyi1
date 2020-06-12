package com.ruoyi.system.service;

import com.ruoyi.system.domain.General;

import java.util.List;

/**
 * 岗位信息 服务层
 * 
 * @author ruoyi
 */
public interface IGeneralService
{
    /**
     * 查询岗位信息集合
     * 
     * @param general 岗位信息
     * @return 岗位信息集合
     */
    public List<General> selectGeneralList(General general);

    /**
     * 查询所有岗位
     * 
     * @return 岗位列表
     */
    public List<General> selectGeneralAll();


    /**
     * 通过岗位ID查询岗位信息
     * 
     * @param id 岗位ID
     * @return 角色对象信息
     */
    public General selectGeneralById(Long id);

    /**
     * 批量删除岗位信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     * @throws Exception 异常
     */
    public int deleteGeneralByIds(String ids) throws Exception;

    /**
     * 新增保存岗位信息
     * 
     * @param general 岗位信息
     * @return 结果
     */
    public int insertGeneral(General general);

    /**
     * 修改保存岗位信息
     * 
     * @param general 岗位信息
     * @return 结果
     */
    public int updateGeneral(General general);
}
