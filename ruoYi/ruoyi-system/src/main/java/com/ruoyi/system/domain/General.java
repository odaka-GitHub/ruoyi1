package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

public class General  extends BaseEntity {
    private static final long serialVersionUID = 1L;
    /*id int AUTO_INCREMENT primary key,	-- 序号 自增1
invoiceTypeCode bigint not null,				-- 发票种类代码
invoiceCode bigint not null,						-- 发票代码
invoiceDate date not null,					-- 开票日期
notate varchar(20) not null,				-- 是否注明旅客身份（填写Y/N：Y-注明旅客身份、N-未注明旅客身份；23-航空电子客票行程单、24-火车票、25-其他车票船票必输）
international varchar(20) not null,	-- 国内/国际（填写IN/OUT：IN-国内旅客运输服务、OUT-国外旅客运输服务；23-航空电子客票行程单、24-火车票、25-其他车票船票必输）
subsidy float not null,			-- 不含税金额（21-代扣代缴税收缴款凭证、22-其他可抵扣发票、26-试报账虚拟发票必输）
taxCode varchar(20) not null,		-- 税码（21-代扣代缴税收缴款凭证、22-其他可抵扣发票、26-试报账虚拟发票必输；范围：0、0.015、0.03、0.05、0.06、0.09、0.1、0.11、0.13、0.16、0.17；）
fares float not null,		-- 票价（23-航空电子客票行程单必输）
civilAviation varchar(20) not null,	-- 民航发展基金（23-航空电子客票行程单必输）
fuelSurcharge varchar(20) not null,	-- 燃油附加费（23-航空电子客票行程单必输）
taxFee varchar(20) not null,				-- 其他税费
sum float not null,									-- 金额（13-桥闸通行费、 14-一二级公路通行费、16-其他不可抵扣发票、 23-航空电子客票行程单、24-火车票、25-其他车票船票必输）
sum1 float not null,		-- 可报账金额（24-火车票必输）
taxNum varchar(20) not null,				-- 购方税号
taxName varchar(20) not null,				-- 购买方名称
saleNum varchar(20) not null,				-- 销售方税号
saleName varchar(20) not null			-- 销售方名称*/
    @Excel(name = "序号", cellType = Excel.ColumnType.NUMERIC)
    private Long id;
    @Excel(name = "发票种类代码")
    private Long invoiceTypeCode;
    @Excel(name = "发票代码")
    private Long invoiceCode;
    @Excel(name = "开票日期")
    private Date invoiceDate;
    @Excel(name = "是否注明旅客身份（填写Y/N：Y-注明旅客身份、N-未注明旅客身份；23-航空电子客票行程单、24-火车票、25-其他车票船票必输）")
    private String notate;
    @Excel(name = "国内/国际（填写IN/OUT：IN-国内旅客运输服务、OUT-国外旅客运输服务；23-航空电子客票行程单、24-火车票、25-其他车票船票必输）")
    private String international;
    @Excel(name = "不含税金额（21-代扣代缴税收缴款凭证、22-其他可抵扣发票、26-试报账虚拟发票必输）")
    private double subsidy;
    @Excel(name = "税码（21-代扣代缴税收缴款凭证、22-其他可抵扣发票、26-试报账虚拟发票必输；范围：0、0.015、0.03、0.05、0.06、0.09、0.1、0.11、0.13、0.16、0.17；）")
    private String taxCode;
    @Excel(name = "票价（23-航空电子客票行程单必输）")
    private double fares;
    @Excel(name = "民航发展基金（23-航空电子客票行程单必输）")
    private String civilAviation;
    @Excel(name = "燃油附加费（23-航空电子客票行程单必输）")
    private String fuelSurcharge;
    @Excel(name = "其他税费")
    private String taxFee;
    @Excel(name = "金额（13-桥闸通行费、 14-一二级公路通行费、16-其他不可抵扣发票、 23-航空电子客票行程单、24-火车票、25-其他车票船票必输）")
    private double sum;
    @Excel(name = "可报账金额（24-火车票必输）")
    private double sum1;
    @Excel(name = "购方税号")
    private String taxNum;
    @Excel(name = "购买方名称")
    private String taxName;
    @Excel(name = "销售方税号")
    private String saleNum;
    @Excel(name = "销售方名称")
    private String saleName;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInvoiceTypeCode() {
        return invoiceTypeCode;
    }

    public void setInvoiceTypeCode(Long invoiceTypeCode) {
        this.invoiceTypeCode = invoiceTypeCode;
    }

    public Long getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(Long invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getNotate() {
        return notate;
    }

    public void setNotate(String notate) {
        this.notate = notate;
    }

    public String getInternational() {
        return international;
    }

    public void setInternational(String international) {
        this.international = international;
    }

    public double getSubsidy() {
        return subsidy;
    }

    public void setSubsidy(double subsidy) {
        this.subsidy = subsidy;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public double getFares() {
        return fares;
    }

    public void setFares(double fares) {
        this.fares = fares;
    }

    public String getCivilAviation() {
        return civilAviation;
    }

    public void setCivilAviation(String civilAviation) {
        this.civilAviation = civilAviation;
    }

    public String getFuelSurcharge() {
        return fuelSurcharge;
    }

    public void setFuelSurcharge(String fuelSurcharge) {
        this.fuelSurcharge = fuelSurcharge;
    }

    public String getTaxFee() {
        return taxFee;
    }

    public void setTaxFee(String taxFee) {
        this.taxFee = taxFee;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public double getSum1() {
        return sum1;
    }

    public void setSum1(double sum1) {
        this.sum1 = sum1;
    }

    public String getTaxNum() {
        return taxNum;
    }

    public void setTaxNum(String taxNum) {
        this.taxNum = taxNum;
    }

    public String getTaxName() {
        return taxName;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }

    public String getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(String saleNum) {
        this.saleNum = saleNum;
    }

    public String getSaleName() {
        return saleName;
    }

    public void setSaleName(String saleName) {
        this.saleName = saleName;
    }
}
