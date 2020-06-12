package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

public class Centralization extends BaseEntity {
    private static final long serialVersionUID = 1L;
/*feeMonth varchar(20) not null,		-- 酬金月份
id int AUTO_INCREMENT primary key,	-- 渠道编号 自增1
thisPayment float not null,					-- 本次支付
taxRate float not null,							-- 税率(%)
payTaxes float not null,						-- 代缴税费(元)
purpose varchar(20) not null,				-- 用途
feeId int not null	-- 酬金发票编号*/
    @Excel(name = "酬金月份")
    private String feeMonth;
    @Excel(name = "渠道编号", cellType = Excel.ColumnType.NUMERIC, prompt = "渠道编号")
    private Long id;
    @Excel(name = "本次支付")
    private double thisPayment;
    @Excel(name = "税率(%)")
    private double taxRate;
    @Excel(name = "代缴税费(元)")
    private double payTaxes;
    @Excel(name = "用途")
    private String purpose;
    @Excel(name = "酬金发票编号")
    private Long feeId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getFeeMonth() {
        return feeMonth;
    }

    public void setFeeMonth(String feeMonth) {
        this.feeMonth = feeMonth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getThisPayment() {
        return thisPayment;
    }

    public void setThisPayment(double thisPayment) {
        this.thisPayment = thisPayment;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public double getPayTaxes() {
        return payTaxes;
    }

    public void setPayTaxes(double payTaxes) {
        this.payTaxes = payTaxes;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public Long getFeeId() {
        return feeId;
    }

    public void setFeeId(Long feeId) {
        this.feeId = feeId;
    }
}
