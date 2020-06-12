package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.sql.Date;

public class Report extends BaseEntity {

    private static final long serialVersionUID = 1L;


/*
* id int primary key, -- 项目签报id
budgetName varchar(20) not null, -- 预算名称
budgetType varchar(20) not null, -- 预算类型
sum int not null, -- 	金额（万元）
itemCost varchar(20) not null, -- 项目成本
addedTax varchar(20) not null, -- 增值税金
unit varchar(20) not null, -- 单位
creator varchar(20) not null, -- 创建人
creatorTime date not null,   -- 创建时间
projectSources varchar(20) not null, -- 项目来源
status varchar(20) not null,  -- 流程状态
process varchar(20) not null -- 发起流程*/
    @Excel(name = "项目签报id", cellType = Excel.ColumnType.NUMERIC, prompt = "项目签报id")
    private Long id;
    @Excel(name = "预算名称")
    private String budgetName;
    @Excel(name = "预算类型")
    private String budgetType;
    @Excel(name = "金额（万元）")
    private int sum;
    @Excel(name = "项目成本")
    private String itemCost;
    @Excel(name = "增值税金")
    private String addedTax;
    @Excel(name = "单位")
    private String unit;
    @Excel(name = "创建人")
    private String creator;
    @Excel(name = "创建时间")
    private Date creatorTime;
    @Excel(name = "项目来源")
    private String projectSources;
    @Excel(name = "流程状态")
    private String status;
    @Excel(name = "发起流程")
    private String process;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBudgetName() {
        return budgetName;
    }

    public void setBudgetName(String budgetName) {
        this.budgetName = budgetName;
    }

    public String getBudgetType() {
        return budgetType;
    }

    public void setBudgetType(String budgetType) {
        this.budgetType = budgetType;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public String getItemCost() {
        return itemCost;
    }

    public void setItemCost(String itemCost) {
        this.itemCost = itemCost;
    }

    public String getAddedTax() {
        return addedTax;
    }

    public void setAddedTax(String addedTax) {
        this.addedTax = addedTax;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
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

    public String getProjectSources() {
        return projectSources;
    }

    public void setProjectSources(String projectSources) {
        this.projectSources = projectSources;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }
}
