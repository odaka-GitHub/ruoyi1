package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.sql.Date;

public class ReportManage extends BaseEntity {

    private static final long serialVersionUID = 1L;


/*
* id int AUTO_INCREMENT primary key,	-- 物id 自增1
associativeName varchar(50) not null, -- 关联单名称
business varchar(20) not null,  	-- 有无业务
manageContent varchar(20) not null, -- 管理内容
reportName varchar(20) not null, -- 报表名称
reportPeriod varchar(20) not null, 	-- 报表周期
creator varchar(20) not null, -- 创建人
creatorTime date not null,   -- 创建时间
status varchar(20) not null  -- 流程状态*/
    @Excel(name = "id", cellType = Excel.ColumnType.NUMERIC, prompt = "id")
    private Long id;
    @Excel(name = "关联单名称")
    private String associativeName;
    @Excel(name = "有无业务")
    private String business;
    @Excel(name = "管理内容")
    private String manageContent;
    @Excel(name = "报表名称")
    private String reportName;
    @Excel(name = "报表周期")
    private String reportPeriod;
    @Excel(name = "创建人")
    private String creator;
    @Excel(name = "创建时间")
    private Date creatorTime;
    @Excel(name = "流程状态")
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

    public String getAssociativeName() {
        return associativeName;
    }

    public void setAssociativeName(String associativeName) {
        this.associativeName = associativeName;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreatorTime() {
        return creatorTime;
    }

    public void setCreatorTime(Date creatorTime) {
        this.creatorTime = creatorTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
