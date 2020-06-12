package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

public class Pay extends BaseEntity{
    private static final long serialVersionUID = 1L;

    /*id int AUTO_INCREMENT primary key,	-- 支付id 自增1
principal varchar(20) not null,			-- 负责人
withhold varchar(20),								-- 代扣代缴
paymentName varchar(20) not null,		-- 付款名称
openingBank varchar(20) not null,		-- 开户行
openingBank1 varchar(20) not null,		-- 开户支行
bankNum bigint not null,						-- 银行账号
fee float not null,									-- 酬金
cope float not null,								-- 应付
status varchar(20) not null,				-- 状态
rewardNum int not null,							-- 酬金发票编号
purpose varchar(20) not NULL				-- 用途*/

    @Excel(name = "支付编号", cellType = Excel.ColumnType.NUMERIC, prompt = "支付编号")
    private Long id;
    @Excel(name = "负责人")
    private String principal;
    @Excel(name = "代扣代缴")
    private String withhold;
    @Excel(name = "付款名称")
    private String paymentName;
    @Excel(name = "开户行")
    private String openingBank;
    @Excel(name = "开户支行")
    private String openingBank1;
    @Excel(name = "银行账号")
    private Long bankNum;
    @Excel(name = "酬金")
    private double fee;
    @Excel(name = "应付")
    private double cope;
    @Excel(name = "状态")
    private String status;
    @Excel(name = "酬金发票编号")
    private Long rewardNum;
    @Excel(name = "用途")
    private String purpose;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getWithhold() {
        return withhold;
    }

    public void setWithhold(String withhold) {
        this.withhold = withhold;
    }

    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }

    public String getOpeningBank() {
        return openingBank;
    }

    public void setOpeningBank(String openingBank) {
        this.openingBank = openingBank;
    }

    public String getOpeningBank1() {
        return openingBank1;
    }

    public void setOpeningBank1(String openingBank1) {
        this.openingBank1 = openingBank1;
    }

    public Long getBankNum() {
        return bankNum;
    }

    public void setBankNum(Long bankNum) {
        this.bankNum = bankNum;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public double getCope() {
        return cope;
    }

    public void setCope(double cope) {
        this.cope = cope;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getRewardNum() {
        return rewardNum;
    }

    public void setRewardNum(Long rewardNum) {
        this.rewardNum = rewardNum;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
}
