package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

public class Statistics extends BaseEntity {
    /*id int AUTO_INCREMENT primary key,	-- 序号 自增1
unit varchar(20) not null, -- 单位
manageContent varchar(20) not null, -- 管理内容
reportName varchar(20) not null, -- 报表名称
reportPeriod varchar(20) not null, 	-- 报表周期
reportTime date not null,						-- 报表时间
status varchar(20) not null  				-- 报表状态*/

    private static final long serialVersionUID = 1L;
    @Excel(name = "序号", cellType = Excel.ColumnType.NUMERIC)
    private Long id;
    @Excel(name = "单位")
    private String unit;
    @Excel(name = "管理内容")
    private String manageContent;
    @Excel(name = "报表名称")
    private String reportName;
    @Excel(name = "报表周期")
    private String reportPeriod;
    @Excel(name = "报表时间")
    private Date reportTime;
    @Excel(name = "报表状态")
    private String status;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getManageContent() {
        return manageContent;
    }

    public void setManageContent(String manageContent) {
        this.manageContent = manageContent;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getReportPeriod() {
        return reportPeriod;
    }

    public void setReportPeriod(String reportPeriod) {
        this.reportPeriod = reportPeriod;
    }

    public Date getReportTime() {
        return reportTime;
    }

    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
