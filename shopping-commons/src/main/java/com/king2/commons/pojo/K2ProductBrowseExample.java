package com.king2.commons.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class K2ProductBrowseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public K2ProductBrowseExample() {
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

        public Criteria andProductBrowseIdIsNull() {
            addCriterion("product_browse_id is null");
            return (Criteria) this;
        }

        public Criteria andProductBrowseIdIsNotNull() {
            addCriterion("product_browse_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductBrowseIdEqualTo(Integer value) {
            addCriterion("product_browse_id =", value, "productBrowseId");
            return (Criteria) this;
        }

        public Criteria andProductBrowseIdNotEqualTo(Integer value) {
            addCriterion("product_browse_id <>", value, "productBrowseId");
            return (Criteria) this;
        }

        public Criteria andProductBrowseIdGreaterThan(Integer value) {
            addCriterion("product_browse_id >", value, "productBrowseId");
            return (Criteria) this;
        }

        public Criteria andProductBrowseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_browse_id >=", value, "productBrowseId");
            return (Criteria) this;
        }

        public Criteria andProductBrowseIdLessThan(Integer value) {
            addCriterion("product_browse_id <", value, "productBrowseId");
            return (Criteria) this;
        }

        public Criteria andProductBrowseIdLessThanOrEqualTo(Integer value) {
            addCriterion("product_browse_id <=", value, "productBrowseId");
            return (Criteria) this;
        }

        public Criteria andProductBrowseIdIn(List<Integer> values) {
            addCriterion("product_browse_id in", values, "productBrowseId");
            return (Criteria) this;
        }

        public Criteria andProductBrowseIdNotIn(List<Integer> values) {
            addCriterion("product_browse_id not in", values, "productBrowseId");
            return (Criteria) this;
        }

        public Criteria andProductBrowseIdBetween(Integer value1, Integer value2) {
            addCriterion("product_browse_id between", value1, value2, "productBrowseId");
            return (Criteria) this;
        }

        public Criteria andProductBrowseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("product_browse_id not between", value1, value2, "productBrowseId");
            return (Criteria) this;
        }

        public Criteria andBrowseUserIdIsNull() {
            addCriterion("browse_user_id is null");
            return (Criteria) this;
        }

        public Criteria andBrowseUserIdIsNotNull() {
            addCriterion("browse_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andBrowseUserIdEqualTo(Integer value) {
            addCriterion("browse_user_id =", value, "browseUserId");
            return (Criteria) this;
        }

        public Criteria andBrowseUserIdNotEqualTo(Integer value) {
            addCriterion("browse_user_id <>", value, "browseUserId");
            return (Criteria) this;
        }

        public Criteria andBrowseUserIdGreaterThan(Integer value) {
            addCriterion("browse_user_id >", value, "browseUserId");
            return (Criteria) this;
        }

        public Criteria andBrowseUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("browse_user_id >=", value, "browseUserId");
            return (Criteria) this;
        }

        public Criteria andBrowseUserIdLessThan(Integer value) {
            addCriterion("browse_user_id <", value, "browseUserId");
            return (Criteria) this;
        }

        public Criteria andBrowseUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("browse_user_id <=", value, "browseUserId");
            return (Criteria) this;
        }

        public Criteria andBrowseUserIdIn(List<Integer> values) {
            addCriterion("browse_user_id in", values, "browseUserId");
            return (Criteria) this;
        }

        public Criteria andBrowseUserIdNotIn(List<Integer> values) {
            addCriterion("browse_user_id not in", values, "browseUserId");
            return (Criteria) this;
        }

        public Criteria andBrowseUserIdBetween(Integer value1, Integer value2) {
            addCriterion("browse_user_id between", value1, value2, "browseUserId");
            return (Criteria) this;
        }

        public Criteria andBrowseUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("browse_user_id not between", value1, value2, "browseUserId");
            return (Criteria) this;
        }

        public Criteria andBrowseProductIdIsNull() {
            addCriterion("browse_product_id is null");
            return (Criteria) this;
        }

        public Criteria andBrowseProductIdIsNotNull() {
            addCriterion("browse_product_id is not null");
            return (Criteria) this;
        }

        public Criteria andBrowseProductIdEqualTo(Integer value) {
            addCriterion("browse_product_id =", value, "browseProductId");
            return (Criteria) this;
        }

        public Criteria andBrowseProductIdNotEqualTo(Integer value) {
            addCriterion("browse_product_id <>", value, "browseProductId");
            return (Criteria) this;
        }

        public Criteria andBrowseProductIdGreaterThan(Integer value) {
            addCriterion("browse_product_id >", value, "browseProductId");
            return (Criteria) this;
        }

        public Criteria andBrowseProductIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("browse_product_id >=", value, "browseProductId");
            return (Criteria) this;
        }

        public Criteria andBrowseProductIdLessThan(Integer value) {
            addCriterion("browse_product_id <", value, "browseProductId");
            return (Criteria) this;
        }

        public Criteria andBrowseProductIdLessThanOrEqualTo(Integer value) {
            addCriterion("browse_product_id <=", value, "browseProductId");
            return (Criteria) this;
        }

        public Criteria andBrowseProductIdIn(List<Integer> values) {
            addCriterion("browse_product_id in", values, "browseProductId");
            return (Criteria) this;
        }

        public Criteria andBrowseProductIdNotIn(List<Integer> values) {
            addCriterion("browse_product_id not in", values, "browseProductId");
            return (Criteria) this;
        }

        public Criteria andBrowseProductIdBetween(Integer value1, Integer value2) {
            addCriterion("browse_product_id between", value1, value2, "browseProductId");
            return (Criteria) this;
        }

        public Criteria andBrowseProductIdNotBetween(Integer value1, Integer value2) {
            addCriterion("browse_product_id not between", value1, value2, "browseProductId");
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

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
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