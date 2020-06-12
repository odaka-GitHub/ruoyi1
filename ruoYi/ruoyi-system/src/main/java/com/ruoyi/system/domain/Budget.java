package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

public class Budget extends BaseEntity {

    private static final long serialVersionUID = 1L;


/*
* id int primary key not null,	-- 预算id
subject varchar(20) not null, -- 预算科目
unit varchar(20) not null,    -- 计量单位
budgetValue int not null,			-- 去年预算值
accomplishValue int not null, -- 去年完成值
budgetValue2 varchar(20) not null,  -- 本年预算值
remark varchar(20) 						-- 备注*/
    @Excel(name = "序号", cellType = Excel.ColumnType.NUMERIC)
    private Long id;
    @Excel(name = "预算科目")
    private String subject;
    @Excel(name = "计量单位")
    private String unit;
    @Excel(name = "去年预算值")
    private Long budgetValue;
    @Excel(name = "去年完成值")
    private Long accomplishValue;
    @Excel(name = "本年预算值")
    private String budgetValue2;
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

    public Long getBudgetValue() {
        return budgetValue;
    }

    public void setBudgetValue(Long budgetValue) {
        this.budgetValue = budgetValue;
    }

    public Long getAccomplishValue() {
        return accomplishValue;
    }

    public void setAccomplishValue(Long accomplishValue) {
        this.accomplishValue = accomplishValue;
    }

    public String getBudgetValue2() {
        return budgetValue2;
    }

    public void setBudgetValue2(String budgetValue2) {
        this.budgetValue2 = budgetValue2;
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
