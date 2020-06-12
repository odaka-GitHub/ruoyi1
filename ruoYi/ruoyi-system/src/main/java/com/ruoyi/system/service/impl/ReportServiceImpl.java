package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.system.domain.Business;
import com.ruoyi.system.domain.Report;
import com.ruoyi.system.mapper.BusinessMapper;
import com.ruoyi.system.mapper.ReportMapper;
import com.ruoyi.system.service.IBusinessService;
import com.ruoyi.system.service.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 岗位信息 服务层处理
 * 
 * @author ruoyi
 */
@Service
public class ReportServiceImpl implements IReportService
{
    @Autowired
    private ReportMapper reportMapper;


    /**
     * 查询岗位信息集合
     * 
     * @param report 岗位信息
     * @return 岗位信息集合
     */
    @Override
    public List<Report> selectReportList(Report report)
    {
        return reportMapper.selectReportList(report);
    }

    /**
     * 查询所有岗位
     * 
     * @return 岗位列表
     */
    @Override
    public List<Report> selectReportAll()
    {
        return reportMapper.selectReportAll();
    }

    /**
     * 通过岗位ID查询岗位信息
     * 
     * @param id 岗位ID
     * @return 角色对象信息
     */
    @Override
    public Report selectReportById(Long id)
    {
        return reportMapper.selectReportById(id);
    }

    /**
     * 批量删除岗位信息
     * 
     * @param ids 需要删除的数据ID
     * @throws Exception
     */
    @Override
    public int deleteReportByIds(String ids) throws Exception
    {
        Long[] budgetIds = Convert.toLongArray(ids);
        for (Long id : budgetIds)
        {
            Report business = selectReportById(id);
        }
        return reportMapper.deleteReportByIds(budgetIds);
    }

    /**
     * 新增保存岗位信息
     * 
     * @param report 岗位信息
     * @return 结果
     */
    @Override
    public int insertReport(Report report)
    {
        return reportMapper.insertReport(report);
    }

    /**
     * 修改保存岗位信息
     * 
     * @param report 岗位信息
     * @return 结果
     */
    @Override
    public int updateReport(Report report)
    {
        return reportMapper.updateReport(report);
    }


}
