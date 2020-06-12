package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.ReportManage;

import java.util.List;

/**
 * 岗位信息 数据层
 * 
 * @author ruoyi
 */
public interface ReportManageMapper
{
    /**
     * 查询预算数据集合
     * 
     * @param reportManage 预算信息
     * @return 岗位数据集合
     */
    public List<ReportManage> selectReportManageList(ReportManage reportManage);

    /**
     * 查询所有预算
     * 
     * @return 预算列表
     */
    public List<ReportManage> selectReportManageAll();

    /**
     * 通过预算ID查询预算信息
     * 
     * @param  id
     * @return 角色对象信息
     */
    public ReportManage selectReportManageById(Long id);

    /**
     * 批量删除岗位信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteReportManageByIds(Long[] ids);

    /**
     * 修改岗位信息
     * 
     * @param reportManage 岗位信息
     * @return 结果
     */
    public int updateReportManage(ReportManage reportManage);

    /**
     * 新增岗位信息
     * 
     * @param reportManage 岗位信息
     * @return 结果
     */
    public int insertReportManage(ReportManage reportManage);

}
