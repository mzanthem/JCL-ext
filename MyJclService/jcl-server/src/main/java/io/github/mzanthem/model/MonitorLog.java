package io.github.mzanthem.model;

import java.util.Date;

public class MonitorLog {
    private Long id;

    private String appId;

    private String bzCode;

    private Integer logOwner;

    private String operator;

    private String operation;

    private Date opTime;

    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getLogOwner() {
        return logOwner;
    }

    public void setLogOwner(Integer logOwner) {
        this.logOwner = logOwner;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation == null ? null : operation.trim();
    }

    public Date getOpTime() {
        return opTime;
    }

    public void setOpTime(Date opTime) {
        this.opTime = opTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}