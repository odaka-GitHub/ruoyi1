package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

public class Management extends BaseEntity {

    private static final long serialVersionUID = 1L;


/*
* id int AUTO_INCREMENT primary key,	-- 物料id 自增1
suppliesName varchar(20) not null,	-- 物料名称
unit varchar(20) not null,    -- 计量单位
applyNum int not null, 		-- 上期申请数量
stockNum int not null, 		-- 库存数量
applyNum2 int not null, 		-- 申请数量
applyNum3 int not null 		-- 修改后申请数量*/
    @Excel(name = "物料id", cellType = Excel.ColumnType.NUMERIC, prompt = "物料id")
    private Long id;
    @Excel(name = "物料名称")
    private String suppliesName;
    @Excel(name = "计量单位")
    private String unit;
    @Excel(name = "上期申请数量")
    private Long applyNum;
    @Excel(name = "库存数量")
    private Long stockNum;
    @Excel(name = "申请数量")
    private Long applyNum2;
    @Excel(name = "修改后申请数量")
    private Long applyNum3;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSuppliesName() {
        return suppliesName;
    }

    public void setSuppliesName(String suppliesName) {
        this.suppliesName = suppliesName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Long getApplyNum() {
        return applyNum;
    }

    public void setApplyNum(Long applyNum) {
        this.applyNum = applyNum;
    }

    public Long getStockNum() {
        return stockNum;
    }

    public void setStockNum(Long stockNum) {
        this.stockNum = stockNum;
    }

    public Long getApplyNum2() {
        return applyNum2;
    }

    public void setApplyNum2(Long applyNum2) {
        this.applyNum2 = applyNum2;
    }

    public Long getApplyNum3() {
        return applyNum3;
    }

    public void setApplyNum3(Long applyNum3) {
        this.applyNum3 = applyNum3;
    }
}
