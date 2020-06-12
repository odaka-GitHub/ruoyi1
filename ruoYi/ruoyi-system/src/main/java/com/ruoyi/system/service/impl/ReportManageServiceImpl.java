package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.Report;
import com.ruoyi.system.domain.ReportManage;
import com.ruoyi.system.mapper.ReportManageMapper;
import com.ruoyi.system.service.IReportManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 岗位信息 服务层处理
 * 
 * @author ruoyi
 */
@Service
public class ReportManageServiceImpl implements IReportManageService
{
    @Autowired
    private ReportManageMapper reportManageMapper;


    /**
     * 查询岗位信息集合
     * 
     * @param reportManage 岗位信息
     * @return 岗位信息集合
     */
    @Override
    public List<ReportManage> selectReportManageList(ReportManage reportManage)
    {
        return reportManageMapper.selectReportManageList(reportManage);
    }

    /**
     * 查询所有岗位
     * 
     * @return 岗位列表
     */
    @Override
    public List<ReportManage> selectReportManageAll()
    {
        return reportManageMapper.selectReportManageAll();
    }

    /**
     * 通过岗位ID查询岗位信息
     * 
     * @param id 岗位ID
     * @return 角色对象信息
     */
    @Override
    public ReportManage selectReportManageById(Long id)
    {
        return reportManageMapper.selectReportManageById(id);
    }

    /**
     * 批量删除岗位信息
     * 
     * @param ids 需要删除的数据ID
     * @throws Exception
     */
    @Override
    public int deleteReportManageByIds(String ids) throws Exception
    {
        Long[] budgetIds = Convert.toLongArray(ids);
        for (Long id : budgetIds)
        {
            ReportManage reportManage = selectReportManageById(id);
        }
        return reportManageMapper.deleteReportManageByIds(budgetIds);
    }

    /**
     * 新增保存岗位信息
     * 
     * @param reportManage 岗位信息
     * @return 结果
     */
    @Override
    public int insertReportManage(ReportManage reportManage)
    {
        return reportManageMapper.insertReportManage(reportManage);
    }

    /**
     * 修改保存岗位信息
     * 
     * @param report 岗位信息
     * @return 结果
     */
    @Override
    public int updateReportManage(ReportManage reportManage)
    {
        return reportManageMapper.updateReportManage(reportManage);
    }


}
