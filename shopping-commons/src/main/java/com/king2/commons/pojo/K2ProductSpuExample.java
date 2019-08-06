package com.king2.commons.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class K2ProductSpuExample {
    /**
     * k2_product_spu
     */
    protected String orderByClause;

    /**
     * k2_product_spu
     */
    protected boolean distinct;

    /**
     * k2_product_spu
     */
    protected List<Criteria> oredCriteria;

    public K2ProductSpuExample() {
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
     * k2_product_spu 2019-08-06
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

        public Criteria andProductSpuIdIsNull() {
            addCriterion("product_spu_id is null");
            return (Criteria) this;
        }

        public Criteria andProductSpuIdIsNotNull() {
            addCriterion("product_spu_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductSpuIdEqualTo(Integer value) {
            addCriterion("product_spu_id =", value, "productSpuId");
            return (Criteria) this;
        }

        public Criteria andProductSpuIdNotEqualTo(Integer value) {
            addCriterion("product_spu_id <>", value, "productSpuId");
            return (Criteria) this;
        }

        public Criteria andProductSpuIdGreaterThan(Integer value) {
            addCriterion("product_spu_id >", value, "productSpuId");
            return (Criteria) this;
        }

        public Criteria andProductSpuIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_spu_id >=", value, "productSpuId");
            return (Criteria) this;
        }

        public Criteria andProductSpuIdLessThan(Integer value) {
            addCriterion("product_spu_id <", value, "productSpuId");
            return (Criteria) this;
        }

        public Criteria andProductSpuIdLessThanOrEqualTo(Integer value) {
            addCriterion("product_spu_id <=", value, "productSpuId");
            return (Criteria) this;
        }

        public Criteria andProductSpuIdIn(List<Integer> values) {
            addCriterion("product_spu_id in", values, "productSpuId");
            return (Criteria) this;
        }

        public Criteria andProductSpuIdNotIn(List<Integer> values) {
            addCriterion("product_spu_id not in", values, "productSpuId");
            return (Criteria) this;
        }

        public Criteria andProductSpuIdBetween(Integer value1, Integer value2) {
            addCriterion("product_spu_id between", value1, value2, "productSpuId");
            return (Criteria) this;
        }

        public Criteria andProductSpuIdNotBetween(Integer value1, Integer value2) {
            addCriterion("product_spu_id not between", value1, value2, "productSpuId");
            return (Criteria) this;
        }

        public Criteria andProductSpuNameIsNull() {
            addCriterion("product_spu_name is null");
            return (Criteria) this;
        }

        public Criteria andProductSpuNameIsNotNull() {
            addCriterion("product_spu_name is not null");
            return (Criteria) this;
        }

        public Criteria andProductSpuNameEqualTo(String value) {
            addCriterion("product_spu_name =", value, "productSpuName");
            return (Criteria) this;
        }

        public Criteria andProductSpuNameNotEqualTo(String value) {
            addCriterion("product_spu_name <>", value, "productSpuName");
            return (Criteria) this;
        }

        public Criteria andProductSpuNameGreaterThan(String value) {
            addCriterion("product_spu_name >", value, "productSpuName");
            return (Criteria) this;
        }

        public Criteria andProductSpuNameGreaterThanOrEqualTo(String value) {
            addCriterion("product_spu_name >=", value, "productSpuName");
            return (Criteria) this;
        }

        public Criteria andProductSpuNameLessThan(String value) {
            addCriterion("product_spu_name <", value, "productSpuName");
            return (Criteria) this;
        }

        public Criteria andProductSpuNameLessThanOrEqualTo(String value) {
            addCriterion("product_spu_name <=", value, "productSpuName");
            return (Criteria) this;
        }

        public Criteria andProductSpuNameLike(String value) {
            addCriterion("product_spu_name like", value, "productSpuName");
            return (Criteria) this;
        }

        public Criteria andProductSpuNameNotLike(String value) {
            addCriterion("product_spu_name not like", value, "productSpuName");
            return (Criteria) this;
        }

        public Criteria andProductSpuNameIn(List<String> values) {
            addCriterion("product_spu_name in", values, "productSpuName");
            return (Criteria) this;
        }

        public Criteria andProductSpuNameNotIn(List<String> values) {
            addCriterion("product_spu_name not in", values, "productSpuName");
            return (Criteria) this;
        }

        public Criteria andProductSpuNameBetween(String value1, String value2) {
            addCriterion("product_spu_name between", value1, value2, "productSpuName");
            return (Criteria) this;
        }

        public Criteria andProductSpuNameNotBetween(String value1, String value2) {
            addCriterion("product_spu_name not between", value1, value2, "productSpuName");
            return (Criteria) this;
        }

        public Criteria andProductSpuValueIsNull() {
            addCriterion("product_spu_value is null");
            return (Criteria) this;
        }

        public Criteria andProductSpuValueIsNotNull() {
            addCriterion("product_spu_value is not null");
            return (Criteria) this;
        }

        public Criteria andProductSpuValueEqualTo(String value) {
            addCriterion("product_spu_value =", value, "productSpuValue");
            return (Criteria) this;
        }

        public Criteria andProductSpuValueNotEqualTo(String value) {
            addCriterion("product_spu_value <>", value, "productSpuValue");
            return (Criteria) this;
        }

        public Criteria andProductSpuValueGreaterThan(String value) {
            addCriterion("product_spu_value >", value, "productSpuValue");
            return (Criteria) this;
        }

        public Criteria andProductSpuValueGreaterThanOrEqualTo(String value) {
            addCriterion("product_spu_value >=", value, "productSpuValue");
            return (Criteria) this;
        }

        public Criteria andProductSpuValueLessThan(String value) {
            addCriterion("product_spu_value <", value, "productSpuValue");
            return (Criteria) this;
        }

        public Criteria andProductSpuValueLessThanOrEqualTo(String value) {
            addCriterion("product_spu_value <=", value, "productSpuValue");
            return (Criteria) this;
        }

        public Criteria andProductSpuValueLike(String value) {
            addCriterion("product_spu_value like", value, "productSpuValue");
            return (Criteria) this;
        }

        public Criteria andProductSpuValueNotLike(String value) {
            addCriterion("product_spu_value not like", value, "productSpuValue");
            return (Criteria) this;
        }

        public Criteria andProductSpuValueIn(List<String> values) {
            addCriterion("product_spu_value in", values, "productSpuValue");
            return (Criteria) this;
        }

        public Criteria andProductSpuValueNotIn(List<String> values) {
            addCriterion("product_spu_value not in", values, "productSpuValue");
            return (Criteria) this;
        }

        public Criteria andProductSpuValueBetween(String value1, String value2) {
            addCriterion("product_spu_value between", value1, value2, "productSpuValue");
            return (Criteria) this;
        }

        public Criteria andProductSpuValueNotBetween(String value1, String value2) {
            addCriterion("product_spu_value not between", value1, value2, "productSpuValue");
            return (Criteria) this;
        }

        public Criteria andProductSpuOrderIsNull() {
            addCriterion("product_spu_order is null");
            return (Criteria) this;
        }

        public Criteria andProductSpuOrderIsNotNull() {
            addCriterion("product_spu_order is not null");
            return (Criteria) this;
        }

        public Criteria andProductSpuOrderEqualTo(Integer value) {
            addCriterion("product_spu_order =", value, "productSpuOrder");
            return (Criteria) this;
        }

        public Criteria andProductSpuOrderNotEqualTo(Integer value) {
            addCriterion("product_spu_order <>", value, "productSpuOrder");
            return (Criteria) this;
        }

        public Criteria andProductSpuOrderGreaterThan(Integer value) {
            addCriterion("product_spu_order >", value, "productSpuOrder");
            return (Criteria) this;
        }

        public Criteria andProductSpuOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_spu_order >=", value, "productSpuOrder");
            return (Criteria) this;
        }

        public Criteria andProductSpuOrderLessThan(Integer value) {
            addCriterion("product_spu_order <", value, "productSpuOrder");
            return (Criteria) this;
        }

        public Criteria andProductSpuOrderLessThanOrEqualTo(Integer value) {
            addCriterion("product_spu_order <=", value, "productSpuOrder");
            return (Criteria) this;
        }

        public Criteria andProductSpuOrderIn(List<Integer> values) {
            addCriterion("product_spu_order in", values, "productSpuOrder");
            return (Criteria) this;
        }

        public Criteria andProductSpuOrderNotIn(List<Integer> values) {
            addCriterion("product_spu_order not in", values, "productSpuOrder");
            return (Criteria) this;
        }

        public Criteria andProductSpuOrderBetween(Integer value1, Integer value2) {
            addCriterion("product_spu_order between", value1, value2, "productSpuOrder");
            return (Criteria) this;
        }

        public Criteria andProductSpuOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("product_spu_order not between", value1, value2, "productSpuOrder");
            return (Criteria) this;
        }

        public Criteria andProductSpuStateIsNull() {
            addCriterion("product_spu_state is null");
            return (Criteria) this;
        }

        public Criteria andProductSpuStateIsNotNull() {
            addCriterion("product_spu_state is not null");
            return (Criteria) this;
        }

        public Criteria andProductSpuStateEqualTo(Integer value) {
            addCriterion("product_spu_state =", value, "productSpuState");
            return (Criteria) this;
        }

        public Criteria andProductSpuStateNotEqualTo(Integer value) {
            addCriterion("product_spu_state <>", value, "productSpuState");
            return (Criteria) this;
        }

        public Criteria andProductSpuStateGreaterThan(Integer value) {
            addCriterion("product_spu_state >", value, "productSpuState");
            return (Criteria) this;
        }

        public Criteria andProductSpuStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_spu_state >=", value, "productSpuState");
            return (Criteria) this;
        }

        public Criteria andProductSpuStateLessThan(Integer value) {
            addCriterion("product_spu_state <", value, "productSpuState");
            return (Criteria) this;
        }

        public Criteria andProductSpuStateLessThanOrEqualTo(Integer value) {
            addCriterion("product_spu_state <=", value, "productSpuState");
            return (Criteria) this;
        }

        public Criteria andProductSpuStateIn(List<Integer> values) {
            addCriterion("product_spu_state in", values, "productSpuState");
            return (Criteria) this;
        }

        public Criteria andProductSpuStateNotIn(List<Integer> values) {
            addCriterion("product_spu_state not in", values, "productSpuState");
            return (Criteria) this;
        }

        public Criteria andProductSpuStateBetween(Integer value1, Integer value2) {
            addCriterion("product_spu_state between", value1, value2, "productSpuState");
            return (Criteria) this;
        }

        public Criteria andProductSpuStateNotBetween(Integer value1, Integer value2) {
            addCriterion("product_spu_state not between", value1, value2, "productSpuState");
            return (Criteria) this;
        }

        public Criteria andBelongProductIdIsNull() {
            addCriterion("belong_product_id is null");
            return (Criteria) this;
        }

        public Criteria andBelongProductIdIsNotNull() {
            addCriterion("belong_product_id is not null");
            return (Criteria) this;
        }

        public Criteria andBelongProductIdEqualTo(Integer value) {
            addCriterion("belong_product_id =", value, "belongProductId");
            return (Criteria) this;
        }

        public Criteria andBelongProductIdNotEqualTo(Integer value) {
            addCriterion("belong_product_id <>", value, "belongProductId");
            return (Criteria) this;
        }

        public Criteria andBelongProductIdGreaterThan(Integer value) {
            addCriterion("belong_product_id >", value, "belongProductId");
            return (Criteria) this;
        }

        public Criteria andBelongProductIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("belong_product_id >=", value, "belongProductId");
            return (Criteria) this;
        }

        public Criteria andBelongProductIdLessThan(Integer value) {
            addCriterion("belong_product_id <", value, "belongProductId");
            return (Criteria) this;
        }

        public Criteria andBelongProductIdLessThanOrEqualTo(Integer value) {
            addCriterion("belong_product_id <=", value, "belongProductId");
            return (Criteria) this;
        }

        public Criteria andBelongProductIdIn(List<Integer> values) {
            addCriterion("belong_product_id in", values, "belongProductId");
            return (Criteria) this;
        }

        public Criteria andBelongProductIdNotIn(List<Integer> values) {
            addCriterion("belong_product_id not in", values, "belongProductId");
            return (Criteria) this;
        }

        public Criteria andBelongProductIdBetween(Integer value1, Integer value2) {
            addCriterion("belong_product_id between", value1, value2, "belongProductId");
            return (Criteria) this;
        }

        public Criteria andBelongProductIdNotBetween(Integer value1, Integer value2) {
            addCriterion("belong_product_id not between", value1, value2, "belongProductId");
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

        public Criteria andRetain1IsNull() {
            addCriterion("retain1 is null");
            return (Criteria) this;
        }

        public Criteria andRetain1IsNotNull() {
            addCriterion("retain1 is not null");
            return (Criteria) this;
        }

        public Criteria andRetain1EqualTo(String value) {
            addCriterion("retain1 =", value, "retain1");
            return (Criteria) this;
        }

        public Criteria andRetain1NotEqualTo(String value) {
            addCriterion("retain1 <>", value, "retain1");
            return (Criteria) this;
        }

        public Criteria andRetain1GreaterThan(String value) {
            addCriterion("retain1 >", value, "retain1");
            return (Criteria) this;
        }

        public Criteria andRetain1GreaterThanOrEqualTo(String value) {
            addCriterion("retain1 >=", value, "retain1");
            return (Criteria) this;
        }

        public Criteria andRetain1LessThan(String value) {
            addCriterion("retain1 <", value, "retain1");
            return (Criteria) this;
        }

        public Criteria andRetain1LessThanOrEqualTo(String value) {
            addCriterion("retain1 <=", value, "retain1");
            return (Criteria) this;
        }

        public Criteria andRetain1Like(String value) {
            addCriterion("retain1 like", value, "retain1");
            return (Criteria) this;
        }

        public Criteria andRetain1NotLike(String value) {
            addCriterion("retain1 not like", value, "retain1");
            return (Criteria) this;
        }

        public Criteria andRetain1In(List<String> values) {
            addCriterion("retain1 in", values, "retain1");
            return (Criteria) this;
        }

        public Criteria andRetain1NotIn(List<String> values) {
            addCriterion("retain1 not in", values, "retain1");
            return (Criteria) this;
        }

        public Criteria andRetain1Between(String value1, String value2) {
            addCriterion("retain1 between", value1, value2, "retain1");
            return (Criteria) this;
        }

        public Criteria andRetain1NotBetween(String value1, String value2) {
            addCriterion("retain1 not between", value1, value2, "retain1");
            return (Criteria) this;
        }

        public Criteria andRetain2IsNull() {
            addCriterion("retain2 is null");
            return (Criteria) this;
        }

        public Criteria andRetain2IsNotNull() {
            addCriterion("retain2 is not null");
            return (Criteria) this;
        }

        public Criteria andRetain2EqualTo(String value) {
            addCriterion("retain2 =", value, "retain2");
            return (Criteria) this;
        }

        public Criteria andRetain2NotEqualTo(String value) {
            addCriterion("retain2 <>", value, "retain2");
            return (Criteria) this;
        }

        public Criteria andRetain2GreaterThan(String value) {
            addCriterion("retain2 >", value, "retain2");
            return (Criteria) this;
        }

        public Criteria andRetain2GreaterThanOrEqualTo(String value) {
            addCriterion("retain2 >=", value, "retain2");
            return (Criteria) this;
        }

        public Criteria andRetain2LessThan(String value) {
            addCriterion("retain2 <", value, "retain2");
            return (Criteria) this;
        }

        public Criteria andRetain2LessThanOrEqualTo(String value) {
            addCriterion("retain2 <=", value, "retain2");
            return (Criteria) this;
        }

        public Criteria andRetain2Like(String value) {
            addCriterion("retain2 like", value, "retain2");
            return (Criteria) this;
        }

        public Criteria andRetain2NotLike(String value) {
            addCriterion("retain2 not like", value, "retain2");
            return (Criteria) this;
        }

        public Criteria andRetain2In(List<String> values) {
            addCriterion("retain2 in", values, "retain2");
            return (Criteria) this;
        }

        public Criteria andRetain2NotIn(List<String> values) {
            addCriterion("retain2 not in", values, "retain2");
            return (Criteria) this;
        }

        public Criteria andRetain2Between(String value1, String value2) {
            addCriterion("retain2 between", value1, value2, "retain2");
            return (Criteria) this;
        }

        public Criteria andRetain2NotBetween(String value1, String value2) {
            addCriterion("retain2 not between", value1, value2, "retain2");
            return (Criteria) this;
        }

        public Criteria andRetain3IsNull() {
            addCriterion("retain3 is null");
            return (Criteria) this;
        }

        public Criteria andRetain3IsNotNull() {
            addCriterion("retain3 is not null");
            return (Criteria) this;
        }

        public Criteria andRetain3EqualTo(String value) {
            addCriterion("retain3 =", value, "retain3");
            return (Criteria) this;
        }

        public Criteria andRetain3NotEqualTo(String value) {
            addCriterion("retain3 <>", value, "retain3");
            return (Criteria) this;
        }

        public Criteria andRetain3GreaterThan(String value) {
            addCriterion("retain3 >", value, "retain3");
            return (Criteria) this;
        }

        public Criteria andRetain3GreaterThanOrEqualTo(String value) {
            addCriterion("retain3 >=", value, "retain3");
            return (Criteria) this;
        }

        public Criteria andRetain3LessThan(String value) {
            addCriterion("retain3 <", value, "retain3");
            return (Criteria) this;
        }

        public Criteria andRetain3LessThanOrEqualTo(String value) {
            addCriterion("retain3 <=", value, "retain3");
            return (Criteria) this;
        }

        public Criteria andRetain3Like(String value) {
            addCriterion("retain3 like", value, "retain3");
            return (Criteria) this;
        }

        public Criteria andRetain3NotLike(String value) {
            addCriterion("retain3 not like", value, "retain3");
            return (Criteria) this;
        }

        public Criteria andRetain3In(List<String> values) {
            addCriterion("retain3 in", values, "retain3");
            return (Criteria) this;
        }

        public Criteria andRetain3NotIn(List<String> values) {
            addCriterion("retain3 not in", values, "retain3");
            return (Criteria) this;
        }

        public Criteria andRetain3Between(String value1, String value2) {
            addCriterion("retain3 between", value1, value2, "retain3");
            return (Criteria) this;
        }

        public Criteria andRetain3NotBetween(String value1, String value2) {
            addCriterion("retain3 not between", value1, value2, "retain3");
            return (Criteria) this;
        }

        public Criteria andRetain4IsNull() {
            addCriterion("retain4 is null");
            return (Criteria) this;
        }

        public Criteria andRetain4IsNotNull() {
            addCriterion("retain4 is not null");
            return (Criteria) this;
        }

        public Criteria andRetain4EqualTo(String value) {
            addCriterion("retain4 =", value, "retain4");
            return (Criteria) this;
        }

        public Criteria andRetain4NotEqualTo(String value) {
            addCriterion("retain4 <>", value, "retain4");
            return (Criteria) this;
        }

        public Criteria andRetain4GreaterThan(String value) {
            addCriterion("retain4 >", value, "retain4");
            return (Criteria) this;
        }

        public Criteria andRetain4GreaterThanOrEqualTo(String value) {
            addCriterion("retain4 >=", value, "retain4");
            return (Criteria) this;
        }

        public Criteria andRetain4LessThan(String value) {
            addCriterion("retain4 <", value, "retain4");
            return (Criteria) this;
        }

        public Criteria andRetain4LessThanOrEqualTo(String value) {
            addCriterion("retain4 <=", value, "retain4");
            return (Criteria) this;
        }

        public Criteria andRetain4Like(String value) {
            addCriterion("retain4 like", value, "retain4");
            return (Criteria) this;
        }

        public Criteria andRetain4NotLike(String value) {
            addCriterion("retain4 not like", value, "retain4");
            return (Criteria) this;
        }

        public Criteria andRetain4In(List<String> values) {
            addCriterion("retain4 in", values, "retain4");
            return (Criteria) this;
        }

        public Criteria andRetain4NotIn(List<String> values) {
            addCriterion("retain4 not in", values, "retain4");
            return (Criteria) this;
        }

        public Criteria andRetain4Between(String value1, String value2) {
            addCriterion("retain4 between", value1, value2, "retain4");
            return (Criteria) this;
        }

        public Criteria andRetain4NotBetween(String value1, String value2) {
            addCriterion("retain4 not between", value1, value2, "retain4");
            return (Criteria) this;
        }

        public Criteria andRetain5IsNull() {
            addCriterion("retain5 is null");
            return (Criteria) this;
        }

        public Criteria andRetain5IsNotNull() {
            addCriterion("retain5 is not null");
            return (Criteria) this;
        }

        public Criteria andRetain5EqualTo(String value) {
            addCriterion("retain5 =", value, "retain5");
            return (Criteria) this;
        }

        public Criteria andRetain5NotEqualTo(String value) {
            addCriterion("retain5 <>", value, "retain5");
            return (Criteria) this;
        }

        public Criteria andRetain5GreaterThan(String value) {
            addCriterion("retain5 >", value, "retain5");
            return (Criteria) this;
        }

        public Criteria andRetain5GreaterThanOrEqualTo(String value) {
            addCriterion("retain5 >=", value, "retain5");
            return (Criteria) this;
        }

        public Criteria andRetain5LessThan(String value) {
            addCriterion("retain5 <", value, "retain5");
            return (Criteria) this;
        }

        public Criteria andRetain5LessThanOrEqualTo(String value) {
            addCriterion("retain5 <=", value, "retain5");
            return (Criteria) this;
        }

        public Criteria andRetain5Like(String value) {
            addCriterion("retain5 like", value, "retain5");
            return (Criteria) this;
        }

        public Criteria andRetain5NotLike(String value) {
            addCriterion("retain5 not like", value, "retain5");
            return (Criteria) this;
        }

        public Criteria andRetain5In(List<String> values) {
            addCriterion("retain5 in", values, "retain5");
            return (Criteria) this;
        }

        public Criteria andRetain5NotIn(List<String> values) {
            addCriterion("retain5 not in", values, "retain5");
            return (Criteria) this;
        }

        public Criteria andRetain5Between(String value1, String value2) {
            addCriterion("retain5 between", value1, value2, "retain5");
            return (Criteria) this;
        }

        public Criteria andRetain5NotBetween(String value1, String value2) {
            addCriterion("retain5 not between", value1, value2, "retain5");
            return (Criteria) this;
        }
    }

    /**
     * k2_product_spu
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * k2_product_spu 2019-08-06
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