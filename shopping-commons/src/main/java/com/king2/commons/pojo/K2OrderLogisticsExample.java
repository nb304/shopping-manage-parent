package com.king2.commons.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class K2OrderLogisticsExample {
    /**
     * k2_order_logistics
     */
    protected String orderByClause;

    /**
     * k2_order_logistics
     */
    protected boolean distinct;

    /**
     * k2_order_logistics
     */
    protected List<Criteria> oredCriteria;

    public K2OrderLogisticsExample() {
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
     * k2_order_logistics 2019-08-06
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

        public Criteria andOlIdIsNull() {
            addCriterion("ol_id is null");
            return (Criteria) this;
        }

        public Criteria andOlIdIsNotNull() {
            addCriterion("ol_id is not null");
            return (Criteria) this;
        }

        public Criteria andOlIdEqualTo(Integer value) {
            addCriterion("ol_id =", value, "olId");
            return (Criteria) this;
        }

        public Criteria andOlIdNotEqualTo(Integer value) {
            addCriterion("ol_id <>", value, "olId");
            return (Criteria) this;
        }

        public Criteria andOlIdGreaterThan(Integer value) {
            addCriterion("ol_id >", value, "olId");
            return (Criteria) this;
        }

        public Criteria andOlIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ol_id >=", value, "olId");
            return (Criteria) this;
        }

        public Criteria andOlIdLessThan(Integer value) {
            addCriterion("ol_id <", value, "olId");
            return (Criteria) this;
        }

        public Criteria andOlIdLessThanOrEqualTo(Integer value) {
            addCriterion("ol_id <=", value, "olId");
            return (Criteria) this;
        }

        public Criteria andOlIdIn(List<Integer> values) {
            addCriterion("ol_id in", values, "olId");
            return (Criteria) this;
        }

        public Criteria andOlIdNotIn(List<Integer> values) {
            addCriterion("ol_id not in", values, "olId");
            return (Criteria) this;
        }

        public Criteria andOlIdBetween(Integer value1, Integer value2) {
            addCriterion("ol_id between", value1, value2, "olId");
            return (Criteria) this;
        }

        public Criteria andOlIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ol_id not between", value1, value2, "olId");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIsNull() {
            addCriterion("order_number is null");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIsNotNull() {
            addCriterion("order_number is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNumberEqualTo(String value) {
            addCriterion("order_number =", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotEqualTo(String value) {
            addCriterion("order_number <>", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThan(String value) {
            addCriterion("order_number >", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThanOrEqualTo(String value) {
            addCriterion("order_number >=", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThan(String value) {
            addCriterion("order_number <", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThanOrEqualTo(String value) {
            addCriterion("order_number <=", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLike(String value) {
            addCriterion("order_number like", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotLike(String value) {
            addCriterion("order_number not like", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIn(List<String> values) {
            addCriterion("order_number in", values, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotIn(List<String> values) {
            addCriterion("order_number not in", values, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberBetween(String value1, String value2) {
            addCriterion("order_number between", value1, value2, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotBetween(String value1, String value2) {
            addCriterion("order_number not between", value1, value2, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOlNumberIsNull() {
            addCriterion("ol_number is null");
            return (Criteria) this;
        }

        public Criteria andOlNumberIsNotNull() {
            addCriterion("ol_number is not null");
            return (Criteria) this;
        }

        public Criteria andOlNumberEqualTo(String value) {
            addCriterion("ol_number =", value, "olNumber");
            return (Criteria) this;
        }

        public Criteria andOlNumberNotEqualTo(String value) {
            addCriterion("ol_number <>", value, "olNumber");
            return (Criteria) this;
        }

        public Criteria andOlNumberGreaterThan(String value) {
            addCriterion("ol_number >", value, "olNumber");
            return (Criteria) this;
        }

        public Criteria andOlNumberGreaterThanOrEqualTo(String value) {
            addCriterion("ol_number >=", value, "olNumber");
            return (Criteria) this;
        }

        public Criteria andOlNumberLessThan(String value) {
            addCriterion("ol_number <", value, "olNumber");
            return (Criteria) this;
        }

        public Criteria andOlNumberLessThanOrEqualTo(String value) {
            addCriterion("ol_number <=", value, "olNumber");
            return (Criteria) this;
        }

        public Criteria andOlNumberLike(String value) {
            addCriterion("ol_number like", value, "olNumber");
            return (Criteria) this;
        }

        public Criteria andOlNumberNotLike(String value) {
            addCriterion("ol_number not like", value, "olNumber");
            return (Criteria) this;
        }

        public Criteria andOlNumberIn(List<String> values) {
            addCriterion("ol_number in", values, "olNumber");
            return (Criteria) this;
        }

        public Criteria andOlNumberNotIn(List<String> values) {
            addCriterion("ol_number not in", values, "olNumber");
            return (Criteria) this;
        }

        public Criteria andOlNumberBetween(String value1, String value2) {
            addCriterion("ol_number between", value1, value2, "olNumber");
            return (Criteria) this;
        }

        public Criteria andOlNumberNotBetween(String value1, String value2) {
            addCriterion("ol_number not between", value1, value2, "olNumber");
            return (Criteria) this;
        }

        public Criteria andOlNameIsNull() {
            addCriterion("ol_name is null");
            return (Criteria) this;
        }

        public Criteria andOlNameIsNotNull() {
            addCriterion("ol_name is not null");
            return (Criteria) this;
        }

        public Criteria andOlNameEqualTo(String value) {
            addCriterion("ol_name =", value, "olName");
            return (Criteria) this;
        }

        public Criteria andOlNameNotEqualTo(String value) {
            addCriterion("ol_name <>", value, "olName");
            return (Criteria) this;
        }

        public Criteria andOlNameGreaterThan(String value) {
            addCriterion("ol_name >", value, "olName");
            return (Criteria) this;
        }

        public Criteria andOlNameGreaterThanOrEqualTo(String value) {
            addCriterion("ol_name >=", value, "olName");
            return (Criteria) this;
        }

        public Criteria andOlNameLessThan(String value) {
            addCriterion("ol_name <", value, "olName");
            return (Criteria) this;
        }

        public Criteria andOlNameLessThanOrEqualTo(String value) {
            addCriterion("ol_name <=", value, "olName");
            return (Criteria) this;
        }

        public Criteria andOlNameLike(String value) {
            addCriterion("ol_name like", value, "olName");
            return (Criteria) this;
        }

        public Criteria andOlNameNotLike(String value) {
            addCriterion("ol_name not like", value, "olName");
            return (Criteria) this;
        }

        public Criteria andOlNameIn(List<String> values) {
            addCriterion("ol_name in", values, "olName");
            return (Criteria) this;
        }

        public Criteria andOlNameNotIn(List<String> values) {
            addCriterion("ol_name not in", values, "olName");
            return (Criteria) this;
        }

        public Criteria andOlNameBetween(String value1, String value2) {
            addCriterion("ol_name between", value1, value2, "olName");
            return (Criteria) this;
        }

        public Criteria andOlNameNotBetween(String value1, String value2) {
            addCriterion("ol_name not between", value1, value2, "olName");
            return (Criteria) this;
        }

        public Criteria andOlCreateTimeIsNull() {
            addCriterion("ol_create_time is null");
            return (Criteria) this;
        }

        public Criteria andOlCreateTimeIsNotNull() {
            addCriterion("ol_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andOlCreateTimeEqualTo(Date value) {
            addCriterion("ol_create_time =", value, "olCreateTime");
            return (Criteria) this;
        }

        public Criteria andOlCreateTimeNotEqualTo(Date value) {
            addCriterion("ol_create_time <>", value, "olCreateTime");
            return (Criteria) this;
        }

        public Criteria andOlCreateTimeGreaterThan(Date value) {
            addCriterion("ol_create_time >", value, "olCreateTime");
            return (Criteria) this;
        }

        public Criteria andOlCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ol_create_time >=", value, "olCreateTime");
            return (Criteria) this;
        }

        public Criteria andOlCreateTimeLessThan(Date value) {
            addCriterion("ol_create_time <", value, "olCreateTime");
            return (Criteria) this;
        }

        public Criteria andOlCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("ol_create_time <=", value, "olCreateTime");
            return (Criteria) this;
        }

        public Criteria andOlCreateTimeIn(List<Date> values) {
            addCriterion("ol_create_time in", values, "olCreateTime");
            return (Criteria) this;
        }

        public Criteria andOlCreateTimeNotIn(List<Date> values) {
            addCriterion("ol_create_time not in", values, "olCreateTime");
            return (Criteria) this;
        }

        public Criteria andOlCreateTimeBetween(Date value1, Date value2) {
            addCriterion("ol_create_time between", value1, value2, "olCreateTime");
            return (Criteria) this;
        }

        public Criteria andOlCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("ol_create_time not between", value1, value2, "olCreateTime");
            return (Criteria) this;
        }

        public Criteria andOlDeliveryTimeIsNull() {
            addCriterion("ol_delivery_time is null");
            return (Criteria) this;
        }

        public Criteria andOlDeliveryTimeIsNotNull() {
            addCriterion("ol_delivery_time is not null");
            return (Criteria) this;
        }

        public Criteria andOlDeliveryTimeEqualTo(Date value) {
            addCriterion("ol_delivery_time =", value, "olDeliveryTime");
            return (Criteria) this;
        }

        public Criteria andOlDeliveryTimeNotEqualTo(Date value) {
            addCriterion("ol_delivery_time <>", value, "olDeliveryTime");
            return (Criteria) this;
        }

        public Criteria andOlDeliveryTimeGreaterThan(Date value) {
            addCriterion("ol_delivery_time >", value, "olDeliveryTime");
            return (Criteria) this;
        }

        public Criteria andOlDeliveryTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ol_delivery_time >=", value, "olDeliveryTime");
            return (Criteria) this;
        }

        public Criteria andOlDeliveryTimeLessThan(Date value) {
            addCriterion("ol_delivery_time <", value, "olDeliveryTime");
            return (Criteria) this;
        }

        public Criteria andOlDeliveryTimeLessThanOrEqualTo(Date value) {
            addCriterion("ol_delivery_time <=", value, "olDeliveryTime");
            return (Criteria) this;
        }

        public Criteria andOlDeliveryTimeIn(List<Date> values) {
            addCriterion("ol_delivery_time in", values, "olDeliveryTime");
            return (Criteria) this;
        }

        public Criteria andOlDeliveryTimeNotIn(List<Date> values) {
            addCriterion("ol_delivery_time not in", values, "olDeliveryTime");
            return (Criteria) this;
        }

        public Criteria andOlDeliveryTimeBetween(Date value1, Date value2) {
            addCriterion("ol_delivery_time between", value1, value2, "olDeliveryTime");
            return (Criteria) this;
        }

        public Criteria andOlDeliveryTimeNotBetween(Date value1, Date value2) {
            addCriterion("ol_delivery_time not between", value1, value2, "olDeliveryTime");
            return (Criteria) this;
        }

        public Criteria andOlTypeIsNull() {
            addCriterion("ol_type is null");
            return (Criteria) this;
        }

        public Criteria andOlTypeIsNotNull() {
            addCriterion("ol_type is not null");
            return (Criteria) this;
        }

        public Criteria andOlTypeEqualTo(Integer value) {
            addCriterion("ol_type =", value, "olType");
            return (Criteria) this;
        }

        public Criteria andOlTypeNotEqualTo(Integer value) {
            addCriterion("ol_type <>", value, "olType");
            return (Criteria) this;
        }

        public Criteria andOlTypeGreaterThan(Integer value) {
            addCriterion("ol_type >", value, "olType");
            return (Criteria) this;
        }

        public Criteria andOlTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("ol_type >=", value, "olType");
            return (Criteria) this;
        }

        public Criteria andOlTypeLessThan(Integer value) {
            addCriterion("ol_type <", value, "olType");
            return (Criteria) this;
        }

        public Criteria andOlTypeLessThanOrEqualTo(Integer value) {
            addCriterion("ol_type <=", value, "olType");
            return (Criteria) this;
        }

        public Criteria andOlTypeIn(List<Integer> values) {
            addCriterion("ol_type in", values, "olType");
            return (Criteria) this;
        }

        public Criteria andOlTypeNotIn(List<Integer> values) {
            addCriterion("ol_type not in", values, "olType");
            return (Criteria) this;
        }

        public Criteria andOlTypeBetween(Integer value1, Integer value2) {
            addCriterion("ol_type between", value1, value2, "olType");
            return (Criteria) this;
        }

        public Criteria andOlTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("ol_type not between", value1, value2, "olType");
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
     * k2_order_logistics
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * k2_order_logistics 2019-08-06
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