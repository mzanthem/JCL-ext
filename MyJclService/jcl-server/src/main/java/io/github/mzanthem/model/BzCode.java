package io.github.mzanthem.model;

import java.util.Date;
/**
 * BusinessCode
 */
public class BzCode {
    private Long id;

    private String bzCode;

    private String bzName;

    private String bzDesc;

    private String bzMode;

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

    public String getBzCode() {
        return bzCode;
    }

    public void setBzCode(String bzCode) {
        this.bzCode = bzCode == null ? null : bzCode.trim();
    }

    public String getBzName() {
        return bzName;
    }

    public void setBzName(String bzName) {
        this.bzName = bzName == null ? null : bzName.trim();
    }

    public String getBzDesc() {
        return bzDesc;
    }

    public void setBzDesc(String bzDesc) {
        this.bzDesc = bzDesc == null ? null : bzDesc.trim();
    }

    public String getBzMode() {
        return bzMode;
    }

    public void setBzMode(String bzMode) {
        this.bzMode = bzMode == null ? null : bzMode.trim();
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