package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

public class Business extends BaseEntity {

    private static final long serialVersionUID = 1L;


/*
* id int AUTO_INCREMENT primary key,	-- 预算业务id 自增1
subject varchar(20) not null, -- 预算科目
unit varchar(20) not null,    -- 计量单位
adjustBudget varchar(20),			-- 调整前预算值
adjustBudget2 varchar(20),			-- 调整后预算值
balance varchar(20),					-- 差额
remark varchar(20) 						-- 备注*/
    @Excel(name = "预算业务编号", cellType = Excel.ColumnType.NUMERIC, prompt = "预算业务id")
    private Long id;
    @Excel(name = "预算科目")
    private String subject;
    @Excel(name = "计量单位")
    private String unit;
    @Excel(name = "调整前预算值")
    private String adjustBudget;
    @Excel(name = "调整后预算值")
    private String adjustBudget2;
    @Excel(name = "差额")
    private String balance;
    @Excel(name = "备注")
    private String remark;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getAdjustBudget() {
        return adjustBudget;
    }

    public void setAdjustBudget(String adjustBudget) {
        this.adjustBudget = adjustBudget;
    }

    public String getAdjustBudget2() {
        return adjustBudget2;
    }

    public void setAdjustBudget2(String adjustBudget2) {
        this.adjustBudget2 = adjustBudget2;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    @Override
    public String getRemark() {
        return remark;
    }

    @Override
    public void setRemark(String remark) {
        this.remark = remark;
    }
}
