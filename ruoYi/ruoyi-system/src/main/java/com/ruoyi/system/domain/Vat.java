package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Vat extends BaseEntity {
    private static final long serialVersionUID = 1L;
    /*id int primary key,	-- 行号(必输)
invoiceTypeCode int not null,				-- 发票种类代码
invoiceCode int not null,						-- 发票代码
invoiceNum int not null,						-- 发票号码
invoicePagination int not null,			-- 发票页码
invoiceDate date not null,					-- 发票日期
checkCode int not null,							-- 校验码后6位
taxNum varchar(20) not null,				-- 购方税号
redMessage varchar(20) not null			-- 红色信息表号*/
    @Excel(name = "行号(必输)", cellType = Excel.ColumnType.NUMERIC)
    private Long id;
    @Excel(name = "发票种类代码")
    private Long invoiceTypeCode;
    @Excel(name = "发票代码")
    private Long invoiceCode;
    @Excel(name = "发票号码")
    private Long invoiceNum;
    @Excel(name = "发票页码")
    private Long invoicePagination;
    @Excel(name = "发票日期")
    private Date invoiceDate;
    @Excel(name = "校验码后6位")
    private Long checkCode;
    @Excel(name = "购方税号")
    private String taxNum;
    @Excel(name = "红色信息表号")
    private String redMessage;


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

    public Long getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(Long invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public Long getInvoicePagination() {
        return invoicePagination;
    }

    public void setInvoicePagination(Long invoicePagination) {
        this.invoicePagination = invoicePagination;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Long getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(Long checkCode) {
        this.checkCode = checkCode;
    }

    public String getTaxNum() {
        return taxNum;
    }

    public void setTaxNum(String taxNum) {
        this.taxNum = taxNum;
    }

    public String getRedMessage() {
        return redMessage;
    }

    public void setRedMessage(String redMessage) {
        this.redMessage = redMessage;
    }
}
