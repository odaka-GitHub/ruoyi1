package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

public class Budgetgoal extends BaseEntity {

    private static final long serialVersionUID = 1L;


/*
* id int AUTO_INCREMENT primary key,	-- 预算目标id 自增1
budgetName varchar(20) not null, -- 预算名称
budgetNumber int not null,			-- 预算编号
unit varchar(20) not null, -- 单位
budgetValue int not null,			-- 今年预算值
occupationValue int not null, -- 截止当前占用值
budgetProgress varchar(20) not null,-- 本年预算进度
surplus int not null -- 本年结余*/


    @Excel(name = "预算目标编号", cellType = Excel.ColumnType.NUMERIC, prompt = "预算目标编号")
    private Long id;
    @Excel(name = "预算科目")
    private String budgetName;
    @Excel(name = "预算编号")
    private String budgetNumber;
    @Excel(name = "单位")
    private String unit;
    @Excel(name = "今年预算值")
    private Long budgetValue;
    @Excel(name = "截止当前占用值")
    private Long occupationValue;
    @Excel(name = "本年预算进度")
    private String budgetProgress;
    @Excel(name = "本年结余")
    private Long surplus;


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

    public String getBudgetNumber() {
        return budgetNumber;
    }

    public void setBudgetNumber(String budgetNumber) {
        this.budgetNumber = budgetNumber;
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

    public Long getOccupationValue() {
        return occupationValue;
    }

    public void setOccupationValue(Long occupationValue) {
        this.occupationValue = occupationValue;
    }

    public String getBudgetProgress() {
        return budgetProgress;
    }

    public void setBudgetProgress(String budgetProgress) {
        this.budgetProgress = budgetProgress;
    }

    public Long getSurplus() {
        return surplus;
    }

    public void setSurplus(Long surplus) {
        this.surplus = surplus;
    }
}
