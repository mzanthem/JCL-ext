package io.github.mzanthem.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CfgStatusExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CfgStatusExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCfgVersionIsNull() {
            addCriterion("cfg_version is null");
            return (Criteria) this;
        }

        public Criteria andCfgVersionIsNotNull() {
            addCriterion("cfg_version is not null");
            return (Criteria) this;
        }

        public Criteria andCfgVersionEqualTo(String value) {
            addCriterion("cfg_version =", value, "cfgVersion");
            return (Criteria) this;
        }

        public Criteria andCfgVersionNotEqualTo(String value) {
            addCriterion("cfg_version <>", value, "cfgVersion");
            return (Criteria) this;
        }

        public Criteria andCfgVersionGreaterThan(String value) {
            addCriterion("cfg_version >", value, "cfgVersion");
            return (Criteria) this;
        }

        public Criteria andCfgVersionGreaterThanOrEqualTo(String value) {
            addCriterion("cfg_version >=", value, "cfgVersion");
            return (Criteria) this;
        }

        public Criteria andCfgVersionLessThan(String value) {
            addCriterion("cfg_version <", value, "cfgVersion");
            return (Criteria) this;
        }

        public Criteria andCfgVersionLessThanOrEqualTo(String value) {
            addCriterion("cfg_version <=", value, "cfgVersion");
            return (Criteria) this;
        }

        public Criteria andCfgVersionLike(String value) {
            addCriterion("cfg_version like", value, "cfgVersion");
            return (Criteria) this;
        }

        public Criteria andCfgVersionNotLike(String value) {
            addCriterion("cfg_version not like", value, "cfgVersion");
            return (Criteria) this;
        }

        public Criteria andCfgVersionIn(List<String> values) {
            addCriterion("cfg_version in", values, "cfgVersion");
            return (Criteria) this;
        }

        public Criteria andCfgVersionNotIn(List<String> values) {
            addCriterion("cfg_version not in", values, "cfgVersion");
            return (Criteria) this;
        }

        public Criteria andCfgVersionBetween(String value1, String value2) {
            addCriterion("cfg_version between", value1, value2, "cfgVersion");
            return (Criteria) this;
        }

        public Criteria andCfgVersionNotBetween(String value1, String value2) {
            addCriterion("cfg_version not between", value1, value2, "cfgVersion");
            return (Criteria) this;
        }

        public Criteria andCfgStatusIsNull() {
            addCriterion("cfg_status is null");
            return (Criteria) this;
        }

        public Criteria andCfgStatusIsNotNull() {
            addCriterion("cfg_status is not null");
            return (Criteria) this;
        }

        public Criteria andCfgStatusEqualTo(String value) {
            addCriterion("cfg_status =", value, "cfgStatus");
            return (Criteria) this;
        }

        public Criteria andCfgStatusNotEqualTo(String value) {
            addCriterion("cfg_status <>", value, "cfgStatus");
            return (Criteria) this;
        }

        public Criteria andCfgStatusGreaterThan(String value) {
            addCriterion("cfg_status >", value, "cfgStatus");
            return (Criteria) this;
        }

        public Criteria andCfgStatusGreaterThanOrEqualTo(String value) {
            addCriterion("cfg_status >=", value, "cfgStatus");
            return (Criteria) this;
        }

        public Criteria andCfgStatusLessThan(String value) {
            addCriterion("cfg_status <", value, "cfgStatus");
            return (Criteria) this;
        }

        public Criteria andCfgStatusLessThanOrEqualTo(String value) {
            addCriterion("cfg_status <=", value, "cfgStatus");
            return (Criteria) this;
        }

        public Criteria andCfgStatusLike(String value) {
            addCriterion("cfg_status like", value, "cfgStatus");
            return (Criteria) this;
        }

        public Criteria andCfgStatusNotLike(String value) {
            addCriterion("cfg_status not like", value, "cfgStatus");
            return (Criteria) this;
        }

        public Criteria andCfgStatusIn(List<String> values) {
            addCriterion("cfg_status in", values, "cfgStatus");
            return (Criteria) this;
        }

        public Criteria andCfgStatusNotIn(List<String> values) {
            addCriterion("cfg_status not in", values, "cfgStatus");
            return (Criteria) this;
        }

        public Criteria andCfgStatusBetween(String value1, String value2) {
            addCriterion("cfg_status between", value1, value2, "cfgStatus");
            return (Criteria) this;
        }

        public Criteria andCfgStatusNotBetween(String value1, String value2) {
            addCriterion("cfg_status not between", value1, value2, "cfgStatus");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeIsNull() {
            addCriterion("release_time is null");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeIsNotNull() {
            addCriterion("release_time is not null");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeEqualTo(String value) {
            addCriterion("release_time =", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeNotEqualTo(String value) {
            addCriterion("release_time <>", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeGreaterThan(String value) {
            addCriterion("release_time >", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeGreaterThanOrEqualTo(String value) {
            addCriterion("release_time >=", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeLessThan(String value) {
            addCriterion("release_time <", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeLessThanOrEqualTo(String value) {
            addCriterion("release_time <=", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeLike(String value) {
            addCriterion("release_time like", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeNotLike(String value) {
            addCriterion("release_time not like", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeIn(List<String> values) {
            addCriterion("release_time in", values, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeNotIn(List<String> values) {
            addCriterion("release_time not in", values, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeBetween(String value1, String value2) {
            addCriterion("release_time between", value1, value2, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeNotBetween(String value1, String value2) {
            addCriterion("release_time not between", value1, value2, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andSyncResultIsNull() {
            addCriterion("sync_result is null");
            return (Criteria) this;
        }

        public Criteria andSyncResultIsNotNull() {
            addCriterion("sync_result is not null");
            return (Criteria) this;
        }

        public Criteria andSyncResultEqualTo(String value) {
            addCriterion("sync_result =", value, "syncResult");
            return (Criteria) this;
        }

        public Criteria andSyncResultNotEqualTo(String value) {
            addCriterion("sync_result <>", value, "syncResult");
            return (Criteria) this;
        }

        public Criteria andSyncResultGreaterThan(String value) {
            addCriterion("sync_result >", value, "syncResult");
            return (Criteria) this;
        }

        public Criteria andSyncResultGreaterThanOrEqualTo(String value) {
            addCriterion("sync_result >=", value, "syncResult");
            return (Criteria) this;
        }

        public Criteria andSyncResultLessThan(String value) {
            addCriterion("sync_result <", value, "syncResult");
            return (Criteria) this;
        }

        public Criteria andSyncResultLessThanOrEqualTo(String value) {
            addCriterion("sync_result <=", value, "syncResult");
            return (Criteria) this;
        }

        public Criteria andSyncResultLike(String value) {
            addCriterion("sync_result like", value, "syncResult");
            return (Criteria) this;
        }

        public Criteria andSyncResultNotLike(String value) {
            addCriterion("sync_result not like", value, "syncResult");
            return (Criteria) this;
        }

        public Criteria andSyncResultIn(List<String> values) {
            addCriterion("sync_result in", values, "syncResult");
            return (Criteria) this;
        }

        public Criteria andSyncResultNotIn(List<String> values) {
            addCriterion("sync_result not in", values, "syncResult");
            return (Criteria) this;
        }

        public Criteria andSyncResultBetween(String value1, String value2) {
            addCriterion("sync_result between", value1, value2, "syncResult");
            return (Criteria) this;
        }

        public Criteria andSyncResultNotBetween(String value1, String value2) {
            addCriterion("sync_result not between", value1, value2, "syncResult");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNull() {
            addCriterion("app_id is null");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNotNull() {
            addCriterion("app_id is not null");
            return (Criteria) this;
        }

        public Criteria andAppIdEqualTo(String value) {
            addCriterion("app_id =", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotEqualTo(String value) {
            addCriterion("app_id <>", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThan(String value) {
            addCriterion("app_id >", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThanOrEqualTo(String value) {
            addCriterion("app_id >=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThan(String value) {
            addCriterion("app_id <", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThanOrEqualTo(String value) {
            addCriterion("app_id <=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLike(String value) {
            addCriterion("app_id like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotLike(String value) {
            addCriterion("app_id not like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdIn(List<String> values) {
            addCriterion("app_id in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotIn(List<String> values) {
            addCriterion("app_id not in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdBetween(String value1, String value2) {
            addCriterion("app_id between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotBetween(String value1, String value2) {
            addCriterion("app_id not between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Integer value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Integer value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Integer value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Integer value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Integer value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Integer> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Integer> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Integer value1, Integer value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("version not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andLifecycleIsNull() {
            addCriterion("lifecycle is null");
            return (Criteria) this;
        }

        public Criteria andLifecycleIsNotNull() {
            addCriterion("lifecycle is not null");
            return (Criteria) this;
        }

        public Criteria andLifecycleEqualTo(Integer value) {
            addCriterion("lifecycle =", value, "lifecycle");
            return (Criteria) this;
        }

        public Criteria andLifecycleNotEqualTo(Integer value) {
            addCriterion("lifecycle <>", value, "lifecycle");
            return (Criteria) this;
        }

        public Criteria andLifecycleGreaterThan(Integer value) {
            addCriterion("lifecycle >", value, "lifecycle");
            return (Criteria) this;
        }

        public Criteria andLifecycleGreaterThanOrEqualTo(Integer value) {
            addCriterion("lifecycle >=", value, "lifecycle");
            return (Criteria) this;
        }

        public Criteria andLifecycleLessThan(Integer value) {
            addCriterion("lifecycle <", value, "lifecycle");
            return (Criteria) this;
        }

        public Criteria andLifecycleLessThanOrEqualTo(Integer value) {
            addCriterion("lifecycle <=", value, "lifecycle");
            return (Criteria) this;
        }

        public Criteria andLifecycleIn(List<Integer> values) {
            addCriterion("lifecycle in", values, "lifecycle");
            return (Criteria) this;
        }

        public Criteria andLifecycleNotIn(List<Integer> values) {
            addCriterion("lifecycle not in", values, "lifecycle");
            return (Criteria) this;
        }

        public Criteria andLifecycleBetween(Integer value1, Integer value2) {
            addCriterion("lifecycle between", value1, value2, "lifecycle");
            return (Criteria) this;
        }

        public Criteria andLifecycleNotBetween(Integer value1, Integer value2) {
            addCriterion("lifecycle not between", value1, value2, "lifecycle");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNull() {
            addCriterion("operator is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNotNull() {
            addCriterion("operator is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorEqualTo(String value) {
            addCriterion("operator =", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotEqualTo(String value) {
            addCriterion("operator <>", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThan(String value) {
            addCriterion("operator >", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThanOrEqualTo(String value) {
            addCriterion("operator >=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThan(String value) {
            addCriterion("operator <", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThanOrEqualTo(String value) {
            addCriterion("operator <=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLike(String value) {
            addCriterion("operator like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotLike(String value) {
            addCriterion("operator not like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorIn(List<String> values) {
            addCriterion("operator in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotIn(List<String> values) {
            addCriterion("operator not in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorBetween(String value1, String value2) {
            addCriterion("operator between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotBetween(String value1, String value2) {
            addCriterion("operator not between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIsNull() {
            addCriterion("modified_time is null");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIsNotNull() {
            addCriterion("modified_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeEqualTo(Date value) {
            addCriterion("modified_time =", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotEqualTo(Date value) {
            addCriterion("modified_time <>", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeGreaterThan(Date value) {
            addCriterion("modified_time >", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modified_time >=", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeLessThan(Date value) {
            addCriterion("modified_time <", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeLessThanOrEqualTo(Date value) {
            addCriterion("modified_time <=", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIn(List<Date> values) {
            addCriterion("modified_time in", values, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotIn(List<Date> values) {
            addCriterion("modified_time not in", values, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeBetween(Date value1, Date value2) {
            addCriterion("modified_time between", value1, value2, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotBetween(Date value1, Date value2) {
            addCriterion("modified_time not between", value1, value2, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}