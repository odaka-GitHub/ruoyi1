package com.ruoyi.system.domain;

import com.ruoyi.common.core.domain.BaseEntity;

public class User extends BaseEntity {
    private static final long serialVersionUID = 1L;
    /*id int PRIMARY KEY not null, -- 用户id
userName varchar(20) not null,   -- 用户名
loginName varchar(20) not null,   -- 登录名
jobNumber bigint not null,				-- 工号
unit varchar(20) not null,					-- 所属单位
post varchar(20) not null,					-- 职位
revamp varchar(20) not null,				-- 修改
valid varchar(20) not null,					-- 有效
permission varchar(20) not null    	-- 权限*/
    private Long id;
    private String userName;
    private String loginName;
    private Long jobNumber;
    private String unit;
    private String post;
    private String revamp;
    private String valid;
    private String permission;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public Long getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(Long jobNumber) {
        this.jobNumber = jobNumber;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getRevamp() {
        return revamp;
    }

    public void setRevamp(String revamp) {
        this.revamp = revamp;
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
