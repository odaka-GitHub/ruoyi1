package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

public class Assess extends BaseEntity {

    private static final long serialVersionUID = 1L;


/*
* id int AUTO_INCREMENT primary key,	-- 预算目标id 自增1
subject varchar(20) not null, -- 预算科目
unit varchar(20) not null,    -- 计量单位
budgetValue int,			-- 今年预算值
accomplishValue int, -- 本期调整后完成值
accomplishValue2 int, -- 调整前累计完成值
adjustValue varchar(20),    -- 调整值
adjustValue2 varchar(20),    -- 调整后累计完成值
completion varchar(20) -- 累计完成比例*/
    @Excel(name = "序号", cellType = Excel.ColumnType.NUMERIC)
    private Long id;
    @Excel(name = "预算科目")
    private String subject;
    @Excel(name = "计量单位")
    private String unit;
    @Excel(name = "今年预算值")
    private Long budgetValue;
    @Excel(name = "本期调整后完成值")
    private Long accomplishValue;
    @Excel(name = "调整前累计完成值")
    private Long accomplishValue2;
    @Excel(name = "调整值")
    private String adjustValue;
    @Excel(name = "调整后累计完成值")
    private String adjustValue2;
    @Excel(name = "累计完成比例")
    private String completion;


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

    public Long getAccomplishValue2() {
        return accomplishValue2;
    }

    public void setAccomplishValue2(Long accomplishValue2) {
        this.accomplishValue2 = accomplishValue2;
    }

    public String getAdjustValue() {
        return adjustValue;
    }

    public void setAdjustValue(String adjustValue) {
        this.adjustValue = adjustValue;
    }

    public String getAdjustValue2() {
        return adjustValue2;
    }

    public void setAdjustValue2(String adjustValue2) {
        this.adjustValue2 = adjustValue2;
    }

    public String getCompletion() {
        return completion;
    }

    public void setCompletion(String completion) {
        this.completion = completion;
    }
}
