package com.ruoyi.system.domain;

import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

public class ContentMaintain extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /*id int AUTO_INCREMENT primary key,	-- 序号 自增1
manageContentName varchar(20) not null, -- 管理内容名称
remark varchar(20), 						-- 备注
modifier varchar(20) not null,			-- 修改人
modificationTime date not null,			-- 修改时间
start varchar(20) not null,					-- 是否启用
monthly varchar(20) not null,				-- 按月打包
preserve varchar(20) not null       -- 保存*/
    private Long id;
    private String manageContentName;
    private String remark;
    private String modifier;
    private Date modificationTime;
    private String start;
    private String monthly;
    private String preserve;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManageContentName() {
        return manageContentName;
    }

    public void setManageContentName(String manageContentName) {
        this.manageContentName = manageContentName;
    }

    @Override
    public String getRemark() {
        return remark;
    }

    @Override
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public Date getModificationTime() {
        return modificationTime;
    }

    public void setModificationTime(Date modificationTime) {
        this.modificationTime = modificationTime;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getMonthly() {
        return monthly;
    }

    public void setMonthly(String monthly) {
        this.monthly = monthly;
    }

    public String getPreserve() {
        return preserve;
    }

    public void setPreserve(String preserve) {
        this.preserve = preserve;
    }
}
