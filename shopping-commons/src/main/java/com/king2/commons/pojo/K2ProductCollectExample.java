package com.king2.commons.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class K2ProductCollectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public K2ProductCollectExample() {
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

        public Criteria andProductCollectIdIsNull() {
            addCriterion("product_collect_id is null");
            return (Criteria) this;
        }

        public Criteria andProductCollectIdIsNotNull() {
            addCriterion("product_collect_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductCollectIdEqualTo(Integer value) {
            addCriterion("product_collect_id =", value, "productCollectId");
            return (Criteria) this;
        }

        public Criteria andProductCollectIdNotEqualTo(Integer value) {
            addCriterion("product_collect_id <>", value, "productCollectId");
            return (Criteria) this;
        }

        public Criteria andProductCollectIdGreaterThan(Integer value) {
            addCriterion("product_collect_id >", value, "productCollectId");
            return (Criteria) this;
        }

        public Criteria andProductCollectIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_collect_id >=", value, "productCollectId");
            return (Criteria) this;
        }

        public Criteria andProductCollectIdLessThan(Integer value) {
            addCriterion("product_collect_id <", value, "productCollectId");
            return (Criteria) this;
        }

        public Criteria andProductCollectIdLessThanOrEqualTo(Integer value) {
            addCriterion("product_collect_id <=", value, "productCollectId");
            return (Criteria) this;
        }

        public Criteria andProductCollectIdIn(List<Integer> values) {
            addCriterion("product_collect_id in", values, "productCollectId");
            return (Criteria) this;
        }

        public Criteria andProductCollectIdNotIn(List<Integer> values) {
            addCriterion("product_collect_id not in", values, "productCollectId");
            return (Criteria) this;
        }

        public Criteria andProductCollectIdBetween(Integer value1, Integer value2) {
            addCriterion("product_collect_id between", value1, value2, "productCollectId");
            return (Criteria) this;
        }

        public Criteria andProductCollectIdNotBetween(Integer value1, Integer value2) {
            addCriterion("product_collect_id not between", value1, value2, "productCollectId");
            return (Criteria) this;
        }

        public Criteria andCollectUserIdIsNull() {
            addCriterion("collect_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCollectUserIdIsNotNull() {
            addCriterion("collect_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCollectUserIdEqualTo(Integer value) {
            addCriterion("collect_user_id =", value, "collectUserId");
            return (Criteria) this;
        }

        public Criteria andCollectUserIdNotEqualTo(Integer value) {
            addCriterion("collect_user_id <>", value, "collectUserId");
            return (Criteria) this;
        }

        public Criteria andCollectUserIdGreaterThan(Integer value) {
            addCriterion("collect_user_id >", value, "collectUserId");
            return (Criteria) this;
        }

        public Criteria andCollectUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("collect_user_id >=", value, "collectUserId");
            return (Criteria) this;
        }

        public Criteria andCollectUserIdLessThan(Integer value) {
            addCriterion("collect_user_id <", value, "collectUserId");
            return (Criteria) this;
        }

        public Criteria andCollectUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("collect_user_id <=", value, "collectUserId");
            return (Criteria) this;
        }

        public Criteria andCollectUserIdIn(List<Integer> values) {
            addCriterion("collect_user_id in", values, "collectUserId");
            return (Criteria) this;
        }

        public Criteria andCollectUserIdNotIn(List<Integer> values) {
            addCriterion("collect_user_id not in", values, "collectUserId");
            return (Criteria) this;
        }

        public Criteria andCollectUserIdBetween(Integer value1, Integer value2) {
            addCriterion("collect_user_id between", value1, value2, "collectUserId");
            return (Criteria) this;
        }

        public Criteria andCollectUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("collect_user_id not between", value1, value2, "collectUserId");
            return (Criteria) this;
        }

        public Criteria andCollectProductIdIsNull() {
            addCriterion("collect_product_id is null");
            return (Criteria) this;
        }

        public Criteria andCollectProductIdIsNotNull() {
            addCriterion("collect_product_id is not null");
            return (Criteria) this;
        }

        public Criteria andCollectProductIdEqualTo(Integer value) {
            addCriterion("collect_product_id =", value, "collectProductId");
            return (Criteria) this;
        }

        public Criteria andCollectProductIdNotEqualTo(Integer value) {
            addCriterion("collect_product_id <>", value, "collectProductId");
            return (Criteria) this;
        }

        public Criteria andCollectProductIdGreaterThan(Integer value) {
            addCriterion("collect_product_id >", value, "collectProductId");
            return (Criteria) this;
        }

        public Criteria andCollectProductIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("collect_product_id >=", value, "collectProductId");
            return (Criteria) this;
        }

        public Criteria andCollectProductIdLessThan(Integer value) {
            addCriterion("collect_product_id <", value, "collectProductId");
            return (Criteria) this;
        }

        public Criteria andCollectProductIdLessThanOrEqualTo(Integer value) {
            addCriterion("collect_product_id <=", value, "collectProductId");
            return (Criteria) this;
        }

        public Criteria andCollectProductIdIn(List<Integer> values) {
            addCriterion("collect_product_id in", values, "collectProductId");
            return (Criteria) this;
        }

        public Criteria andCollectProductIdNotIn(List<Integer> values) {
            addCriterion("collect_product_id not in", values, "collectProductId");
            return (Criteria) this;
        }

        public Criteria andCollectProductIdBetween(Integer value1, Integer value2) {
            addCriterion("collect_product_id between", value1, value2, "collectProductId");
            return (Criteria) this;
        }

        public Criteria andCollectProductIdNotBetween(Integer value1, Integer value2) {
            addCriterion("collect_product_id not between", value1, value2, "collectProductId");
            return (Criteria) this;
        }

        public Criteria andCollectStateIsNull() {
            addCriterion("collect_state is null");
            return (Criteria) this;
        }

        public Criteria andCollectStateIsNotNull() {
            addCriterion("collect_state is not null");
            return (Criteria) this;
        }

        public Criteria andCollectStateEqualTo(Integer value) {
            addCriterion("collect_state =", value, "collectState");
            return (Criteria) this;
        }

        public Criteria andCollectStateNotEqualTo(Integer value) {
            addCriterion("collect_state <>", value, "collectState");
            return (Criteria) this;
        }

        public Criteria andCollectStateGreaterThan(Integer value) {
            addCriterion("collect_state >", value, "collectState");
            return (Criteria) this;
        }

        public Criteria andCollectStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("collect_state >=", value, "collectState");
            return (Criteria) this;
        }

        public Criteria andCollectStateLessThan(Integer value) {
            addCriterion("collect_state <", value, "collectState");
            return (Criteria) this;
        }

        public Criteria andCollectStateLessThanOrEqualTo(Integer value) {
            addCriterion("collect_state <=", value, "collectState");
            return (Criteria) this;
        }

        public Criteria andCollectStateIn(List<Integer> values) {
            addCriterion("collect_state in", values, "collectState");
            return (Criteria) this;
        }

        public Criteria andCollectStateNotIn(List<Integer> values) {
            addCriterion("collect_state not in", values, "collectState");
            return (Criteria) this;
        }

        public Criteria andCollectStateBetween(Integer value1, Integer value2) {
            addCriterion("collect_state between", value1, value2, "collectState");
            return (Criteria) this;
        }

        public Criteria andCollectStateNotBetween(Integer value1, Integer value2) {
            addCriterion("collect_state not between", value1, value2, "collectState");
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