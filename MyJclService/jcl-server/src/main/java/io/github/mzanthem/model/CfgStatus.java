package io.github.mzanthem.model;

import java.util.Date;

public class CfgStatus {
    private Long id;

    private String cfgVersion;

    private String cfgStatus;

    private String releaseTime;

    private String syncResult;

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

    public String getCfgVersion() {
        return cfgVersion;
    }

    public void setCfgVersion(String cfgVersion) {
        this.cfgVersion = cfgVersion == null ? null : cfgVersion.trim();
    }

    public String getCfgStatus() {
        return cfgStatus;
    }

    public void setCfgStatus(String cfgStatus) {
        this.cfgStatus = cfgStatus == null ? null : cfgStatus.trim();
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime == null ? null : releaseTime.trim();
    }

    public String getSyncResult() {
        return syncResult;
    }

    public void setSyncResult(String syncResult) {
        this.syncResult = syncResult == null ? null : syncResult.trim();
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