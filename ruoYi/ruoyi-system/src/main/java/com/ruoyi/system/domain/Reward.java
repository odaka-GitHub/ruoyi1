package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

public class Reward  extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /*id int AUTO_INCREMENT primary key,	-- 酬金id 自增1
area varchar(20) not null, 					-- 地区
counties varchar(20) not null, 			-- 县市
regional varchar(20) not null,			-- 区域营销
channelType varchar(20) not null,   -- 渠道类型
channelType1 varchar(20) not null,   -- 渠道子类型
merchantId int not null,						-- 代销商编号
merchant varchar(20) not null,			-- 代销商
subjectType varchar(20), 						-- 科目类型
businessType varchar(20) not null,	-- 业务类型
brand varchar(20) not null,					-- 品牌
averagePrice int not null,					-- 平均单价
count int not null,									-- 计算数量
rewardSum float not null,						-- 酬金金额（含税）
paidSum float not null,							-- 实付金额
calculation varchar(20),								-- 计算依据
rewardSum1 float not null						-- 酬金金额（不含税）*/
    @Excel(name = "酬金id", cellType = Excel.ColumnType.NUMERIC, prompt = "酬金id")
    private Long id;
    @Excel(name = "地区")
    private String area;
    @Excel(name = "县市")
    private String counties;
    @Excel(name = "区域营销")
    private String regional;
    @Excel(name = "渠道类型")
    private String channelType;
    @Excel(name = "渠道子类型")
    private String channelType1;
    @Excel(name = "代销商编号")
    private Long merchantId;
    @Excel(name = "代销商")
    private String merchant;
    @Excel(name = "科目类型")
    private String subjectType;
    @Excel(name = "业务类型")
    private String businessType;
    @Excel(name = "品牌")
    private String brand;
    @Excel(name = "平均单价")
    private Long averagePrice;
    @Excel(name = "计算数量")
    private double count;
    @Excel(name = "酬金金额（含税）")
    private double rewardSum;
    @Excel(name = "实付金额")
    private double paidSum;
    @Excel(name = "计算依据")
    private String calculation;
    @Excel(name = "酬金金额（不含税）")
    private double rewardSum1;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCounties() {
        return counties;
    }

    public void setCounties(String counties) {
        this.counties = counties;
    }

    public String getRegional() {
        return regional;
    }

    public void setRegional(String regional) {
        this.regional = regional;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public String getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(String subjectType) {
        this.subjectType = subjectType;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Long getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(Long averagePrice) {
        this.averagePrice = averagePrice;
    }

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }

    public double getRewardSum() {
        return rewardSum;
    }

    public void setRewardSum(double rewardSum) {
        this.rewardSum = rewardSum;
    }

    public double getPaidSum() {
        return paidSum;
    }

    public void setPaidSum(double paidSum) {
        this.paidSum = paidSum;
    }

    public String getCalculation() {
        return calculation;
    }

    public void setCalculation(String calculation) {
        this.calculation = calculation;
    }

    public double getRewardSum1() {
        return rewardSum1;
    }

    public void setRewardSum1(double rewardSum1) {
        this.rewardSum1 = rewardSum1;
    }

    public String getChannelType1() {
        return channelType1;
    }

    public void setChannelType1(String channelType1) {
        this.channelType1 = channelType1;
    }
}
