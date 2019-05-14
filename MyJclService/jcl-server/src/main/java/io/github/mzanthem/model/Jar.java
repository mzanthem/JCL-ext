package io.github.mzanthem.model;

import java.util.Date;

public class Jar {
    private Long id;

    private String jarName;

    private String jarVersion;

    private String jarUrl;

    private String jarDesc;

    private String appId;

    private Integer version;

    private Integer lifecycle;

    private String operator;

    private Date createTime;

    private Date modifiedTime;

    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJarName() {
        return jarName;
    }

    public void setJarName(String jarName) {
        this.jarName = jarName == null ? null : jarName.trim();
    }

    public String getJarVersion() {
        return jarVersion;
    }

    public void setJarVersion(String jarVersion) {
        this.jarVersion = jarVersion == null ? null : jarVersion.trim();
    }

    public String getJarUrl() {
        return jarUrl;
    }

    public void setJarUrl(String jarUrl) {
        this.jarUrl = jarUrl == null ? null : jarUrl.trim();
    }

    public String getJarDesc() {
        return jarDesc;
    }

    public void setJarDesc(String jarDesc) {
        this.jarDesc = jarDesc == null ? null : jarDesc.trim();
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getLifecycle() {
        return lifecycle;
    }

    public void setLifecycle(Integer lifecycle) {
        this.lifecycle = lifecycle;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}