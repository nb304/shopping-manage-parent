package com.king2.commons.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class K2RoleParallelismJurisdictionExample {
    /**
     * k2_role_parallelism_jurisdiction
     */
    protected String orderByClause;

    /**
     * k2_role_parallelism_jurisdiction
     */
    protected boolean distinct;

    /**
     * k2_role_parallelism_jurisdiction
     */
    protected List<Criteria> oredCriteria;

    public K2RoleParallelismJurisdictionExample() {
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

    /**
     * k2_role_parallelism_jurisdiction 2019-08-06
     */
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

        public Criteria andParallelismJurisdictionIdIsNull() {
            addCriterion("parallelism_jurisdiction_id is null");
            return (Criteria) this;
        }

        public Criteria andParallelismJurisdictionIdIsNotNull() {
            addCriterion("parallelism_jurisdiction_id is not null");
            return (Criteria) this;
        }

        public Criteria andParallelismJurisdictionIdEqualTo(Integer value) {
            addCriterion("parallelism_jurisdiction_id =", value, "parallelismJurisdictionId");
            return (Criteria) this;
        }

        public Criteria andParallelismJurisdictionIdNotEqualTo(Integer value) {
            addCriterion("parallelism_jurisdiction_id <>", value, "parallelismJurisdictionId");
            return (Criteria) this;
        }

        public Criteria andParallelismJurisdictionIdGreaterThan(Integer value) {
            addCriterion("parallelism_jurisdiction_id >", value, "parallelismJurisdictionId");
            return (Criteria) this;
        }

        public Criteria andParallelismJurisdictionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("parallelism_jurisdiction_id >=", value, "parallelismJurisdictionId");
            return (Criteria) this;
        }

        public Criteria andParallelismJurisdictionIdLessThan(Integer value) {
            addCriterion("parallelism_jurisdiction_id <", value, "parallelismJurisdictionId");
            return (Criteria) this;
        }

        public Criteria andParallelismJurisdictionIdLessThanOrEqualTo(Integer value) {
            addCriterion("parallelism_jurisdiction_id <=", value, "parallelismJurisdictionId");
            return (Criteria) this;
        }

        public Criteria andParallelismJurisdictionIdIn(List<Integer> values) {
            addCriterion("parallelism_jurisdiction_id in", values, "parallelismJurisdictionId");
            return (Criteria) this;
        }

        public Criteria andParallelismJurisdictionIdNotIn(List<Integer> values) {
            addCriterion("parallelism_jurisdiction_id not in", values, "parallelismJurisdictionId");
            return (Criteria) this;
        }

        public Criteria andParallelismJurisdictionIdBetween(Integer value1, Integer value2) {
            addCriterion("parallelism_jurisdiction_id between", value1, value2, "parallelismJurisdictionId");
            return (Criteria) this;
        }

        public Criteria andParallelismJurisdictionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("parallelism_jurisdiction_id not between", value1, value2, "parallelismJurisdictionId");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNull() {
            addCriterion("role_id is null");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNotNull() {
            addCriterion("role_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoleIdEqualTo(Integer value) {
            addCriterion("role_id =", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotEqualTo(Integer value) {
            addCriterion("role_id <>", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThan(Integer value) {
            addCriterion("role_id >", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("role_id >=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThan(Integer value) {
            addCriterion("role_id <", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThanOrEqualTo(Integer value) {
            addCriterion("role_id <=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdIn(List<Integer> values) {
            addCriterion("role_id in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotIn(List<Integer> values) {
            addCriterion("role_id not in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdBetween(Integer value1, Integer value2) {
            addCriterion("role_id between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("role_id not between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andJurisdictionIdIsNull() {
            addCriterion("jurisdiction_id is null");
            return (Criteria) this;
        }

        public Criteria andJurisdictionIdIsNotNull() {
            addCriterion("jurisdiction_id is not null");
            return (Criteria) this;
        }

        public Criteria andJurisdictionIdEqualTo(Integer value) {
            addCriterion("jurisdiction_id =", value, "jurisdictionId");
            return (Criteria) this;
        }

        public Criteria andJurisdictionIdNotEqualTo(Integer value) {
            addCriterion("jurisdiction_id <>", value, "jurisdictionId");
            return (Criteria) this;
        }

        public Criteria andJurisdictionIdGreaterThan(Integer value) {
            addCriterion("jurisdiction_id >", value, "jurisdictionId");
            return (Criteria) this;
        }

        public Criteria andJurisdictionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("jurisdiction_id >=", value, "jurisdictionId");
            return (Criteria) this;
        }

        public Criteria andJurisdictionIdLessThan(Integer value) {
            addCriterion("jurisdiction_id <", value, "jurisdictionId");
            return (Criteria) this;
        }

        public Criteria andJurisdictionIdLessThanOrEqualTo(Integer value) {
            addCriterion("jurisdiction_id <=", value, "jurisdictionId");
            return (Criteria) this;
        }

        public Criteria andJurisdictionIdIn(List<Integer> values) {
            addCriterion("jurisdiction_id in", values, "jurisdictionId");
            return (Criteria) this;
        }

        public Criteria andJurisdictionIdNotIn(List<Integer> values) {
            addCriterion("jurisdiction_id not in", values, "jurisdictionId");
            return (Criteria) this;
        }

        public Criteria andJurisdictionIdBetween(Integer value1, Integer value2) {
            addCriterion("jurisdiction_id between", value1, value2, "jurisdictionId");
            return (Criteria) this;
        }

        public Criteria andJurisdictionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("jurisdiction_id not between", value1, value2, "jurisdictionId");
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
    }

    /**
     * k2_role_parallelism_jurisdiction
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * k2_role_parallelism_jurisdiction 2019-08-06
     */
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