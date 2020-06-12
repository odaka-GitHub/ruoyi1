package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Report;

import java.util.List;

/**
 * 岗位信息 数据层
 * 
 * @author ruoyi
 */
public interface ReportMapper
{
    /**
     * 查询预算数据集合
     * 
     * @param report 预算信息
     * @return 岗位数据集合
     */
    public List<Report> selectReportList(Report report);

    /**
     * 查询所有预算
     * 
     * @return 预算列表
     */
    public List<Report> selectReportAll();

    /**
     * 通过预算ID查询预算信息
     * 
     * @param  id
     * @return 角色对象信息
     */
    public Report selectReportById(Long id);

    /**
     * 批量删除岗位信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteReportByIds(Long[] ids);

    /**
     * 修改岗位信息
     * 
     * @param report 岗位信息
     * @return 结果
     */
    public int updateReport(Report report);

    /**
     * 新增岗位信息
     * 
     * @param report 岗位信息
     * @return 结果
     */
    public int insertReport(Report report);

}
