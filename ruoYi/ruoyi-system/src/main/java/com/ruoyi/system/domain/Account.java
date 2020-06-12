package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

public class Account extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /*filiale varchar(20) not null,				-- 分公司
channelId int AUTO_INCREMENT primary key,	-- 渠道id 自增1
channelName varchar(20) not null,		-- 渠道名称
fee float not null,			-- 业务酬金(上月余额)
subsidy float not null,							-- 综合补贴(上月余额)
fee1 float not null,			-- 业务酬金(本月增加)不含税金额
fee2 float not null,							-- 业务酬金(本月增加)税额
subsidy1 float not null,			-- 综合补贴(本月增加)不含税金额
subsidy2 float not null,							-- 综合补贴(本月增加)税额
fee3 float not null,			-- 业务酬金(本月减少)不含税金额
fee4 float not null,							-- 业务酬金(本月减少)进项税转出税额
subsidy3 float not null,			-- 综合补贴(本月减少)不含税金额
subsidy4 float not null,							-- 综合补贴(本月减少)进项税转出税额
fee5 float not null,			-- 业务酬金(本月金额)
subsidy5 float not null,							-- 综合补贴(本月金额)
subtotal float not null,							-- 小计
channelManager varchar(20) 						-- 渠道负责人*/
    @Excel(name = "分公司")
    private String filiale;
    @Excel(name = "渠道编号", cellType = Excel.ColumnType.NUMERIC, prompt = "渠道编号")
    private Long channelId;
    @Excel(name = "渠道名称")
    private String channelName;
    @Excel(name = "业务酬金(上月余额)")
    private double fee;
    @Excel(name = "综合补贴(上月余额)")
    private double subsidy;
    @Excel(name = "业务酬金(本月增加)不含税金额")
    private double fee1;
    @Excel(name = "业务酬金(本月增加)税额")
    private double fee2;
    @Excel(name = "综合补贴(本月增加)不含税金额")
    private double subsidy1;
    @Excel(name = "综合补贴(本月增加)税额")
    private double subsidy2;
    @Excel(name = "业务酬金(本月减少)不含税金额")
    private double fee3;
    @Excel(name = "业务酬金(本月减少)进项税转出税额")
    private double fee4;
    @Excel(name = "综合补贴(本月减少)不含税金额")
    private double subsidy3;
    @Excel(name = "综合补贴(本月减少)进项税转出税额")
    private double subsidy4;
    @Excel(name = "业务酬金(本月金额)")
    private double fee5;
    @Excel(name = "综合补贴(本月金额)")
    private double subsidy5;
    @Excel(name = "小计")
    private double subtotal;
    @Excel(name = "渠道负责人")
    private String channelManager;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getFiliale() {
        return filiale;
    }

    public void setFiliale(String filiale) {
        this.filiale = filiale;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public double getSubsidy() {
        return subsidy;
    }

    public void setSubsidy(double subsidy) {
        this.subsidy = subsidy;
    }

    public double getFee1() {
        return fee1;
    }

    public void setFee1(double fee1) {
        this.fee1 = fee1;
    }

    public double getFee2() {
        return fee2;
    }

    public void setFee2(double fee2) {
        this.fee2 = fee2;
    }

    public double getSubsidy1() {
        return subsidy1;
    }

    public void setSubsidy1(double subsidy1) {
        this.subsidy1 = subsidy1;
    }

    public double getSubsidy2() {
        return subsidy2;
    }

    public void setSubsidy2(double subsidy2) {
        this.subsidy2 = subsidy2;
    }

    public double getFee3() {
        return fee3;
    }

    public void setFee3(double fee3) {
        this.fee3 = fee3;
    }

    public double getFee4() {
        return fee4;
    }

    public void setFee4(double fee4) {
        this.fee4 = fee4;
    }

    public double getSubsidy3() {
        return subsidy3;
    }

    public void setSubsidy3(double subsidy3) {
        this.subsidy3 = subsidy3;
    }

    public double getSubsidy4() {
        return subsidy4;
    }

    public void setSubsidy4(double subsidy4) {
        this.subsidy4 = subsidy4;
    }

    public double getFee5() {
        return fee5;
    }

    public void setFee5(double fee5) {
        this.fee5 = fee5;
    }

    public double getSubsidy5() {
        return subsidy5;
    }

    public void setSubsidy5(double subsidy5) {
        this.subsidy5 = subsidy5;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public String getChannelManager() {
        return channelManager;
    }

    public void setChannelManager(String channelManager) {
        this.channelManager = channelManager;
    }
}
