package io.github.mzanthem.model;

import java.util.Date;

public class CfgVersions {
    private Long id;

    private String cfgVersion;

    private String cfgSrcVer;

    private Long jarId;

    private String appId;

    private String bzCode;

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

    public String getCfgVersion() {
        return cfgVersion;
    }

    public void setCfgVersion(String cfgVersion) {
        this.cfgVersion = cfgVersion == null ? null : cfgVersion.trim();
    }

    public String getCfgSrcVer() {
        return cfgSrcVer;
    }

    public void setCfgSrcVer(String cfgSrcVer) {
        this.cfgSrcVer = cfgSrcVer == null ? null : cfgSrcVer.trim();
    }

    public Long getJarId() {
        return jarId;
    }

    public void setJarId(Long jarId) {
        this.jarId = jarId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    public String getBzCode() {
        return bzCode;
    }

    public void setBzCode(String bzCode) {
        this.bzCode = bzCode == null ? null : bzCode.trim();
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