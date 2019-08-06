package com.king2.commons.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class K2OrderAfterSalesExample {
    /**
     * k2_order_after_sales
     */
    protected String orderByClause;

    /**
     * k2_order_after_sales
     */
    protected boolean distinct;

    /**
     * k2_order_after_sales
     */
    protected List<Criteria> oredCriteria;

    public K2OrderAfterSalesExample() {
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
     * k2_order_after_sales 2019-08-06
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

        public Criteria andAsIdIsNull() {
            addCriterion("as_id is null");
            return (Criteria) this;
        }

        public Criteria andAsIdIsNotNull() {
            addCriterion("as_id is not null");
            return (Criteria) this;
        }

        public Criteria andAsIdEqualTo(Integer value) {
            addCriterion("as_id =", value, "asId");
            return (Criteria) this;
        }

        public Criteria andAsIdNotEqualTo(Integer value) {
            addCriterion("as_id <>", value, "asId");
            return (Criteria) this;
        }

        public Criteria andAsIdGreaterThan(Integer value) {
            addCriterion("as_id >", value, "asId");
            return (Criteria) this;
        }

        public Criteria andAsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("as_id >=", value, "asId");
            return (Criteria) this;
        }

        public Criteria andAsIdLessThan(Integer value) {
            addCriterion("as_id <", value, "asId");
            return (Criteria) this;
        }

        public Criteria andAsIdLessThanOrEqualTo(Integer value) {
            addCriterion("as_id <=", value, "asId");
            return (Criteria) this;
        }

        public Criteria andAsIdIn(List<Integer> values) {
            addCriterion("as_id in", values, "asId");
            return (Criteria) this;
        }

        public Criteria andAsIdNotIn(List<Integer> values) {
            addCriterion("as_id not in", values, "asId");
            return (Criteria) this;
        }

        public Criteria andAsIdBetween(Integer value1, Integer value2) {
            addCriterion("as_id between", value1, value2, "asId");
            return (Criteria) this;
        }

        public Criteria andAsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("as_id not between", value1, value2, "asId");
            return (Criteria) this;
        }

        public Criteria andAsTypeIsNull() {
            addCriterion("as_type is null");
            return (Criteria) this;
        }

        public Criteria andAsTypeIsNotNull() {
            addCriterion("as_type is not null");
            return (Criteria) this;
        }

        public Criteria andAsTypeEqualTo(String value) {
            addCriterion("as_type =", value, "asType");
            return (Criteria) this;
        }

        public Criteria andAsTypeNotEqualTo(String value) {
            addCriterion("as_type <>", value, "asType");
            return (Criteria) this;
        }

        public Criteria andAsTypeGreaterThan(String value) {
            addCriterion("as_type >", value, "asType");
            return (Criteria) this;
        }

        public Criteria andAsTypeGreaterThanOrEqualTo(String value) {
            addCriterion("as_type >=", value, "asType");
            return (Criteria) this;
        }

        public Criteria andAsTypeLessThan(String value) {
            addCriterion("as_type <", value, "asType");
            return (Criteria) this;
        }

        public Criteria andAsTypeLessThanOrEqualTo(String value) {
            addCriterion("as_type <=", value, "asType");
            return (Criteria) this;
        }

        public Criteria andAsTypeLike(String value) {
            addCriterion("as_type like", value, "asType");
            return (Criteria) this;
        }

        public Criteria andAsTypeNotLike(String value) {
            addCriterion("as_type not like", value, "asType");
            return (Criteria) this;
        }

        public Criteria andAsTypeIn(List<String> values) {
            addCriterion("as_type in", values, "asType");
            return (Criteria) this;
        }

        public Criteria andAsTypeNotIn(List<String> values) {
            addCriterion("as_type not in", values, "asType");
            return (Criteria) this;
        }

        public Criteria andAsTypeBetween(String value1, String value2) {
            addCriterion("as_type between", value1, value2, "asType");
            return (Criteria) this;
        }

        public Criteria andAsTypeNotBetween(String value1, String value2) {
            addCriterion("as_type not between", value1, value2, "asType");
            return (Criteria) this;
        }

        public Criteria andAsDescIsNull() {
            addCriterion("as_desc is null");
            return (Criteria) this;
        }

        public Criteria andAsDescIsNotNull() {
            addCriterion("as_desc is not null");
            return (Criteria) this;
        }

        public Criteria andAsDescEqualTo(String value) {
            addCriterion("as_desc =", value, "asDesc");
            return (Criteria) this;
        }

        public Criteria andAsDescNotEqualTo(String value) {
            addCriterion("as_desc <>", value, "asDesc");
            return (Criteria) this;
        }

        public Criteria andAsDescGreaterThan(String value) {
            addCriterion("as_desc >", value, "asDesc");
            return (Criteria) this;
        }

        public Criteria andAsDescGreaterThanOrEqualTo(String value) {
            addCriterion("as_desc >=", value, "asDesc");
            return (Criteria) this;
        }

        public Criteria andAsDescLessThan(String value) {
            addCriterion("as_desc <", value, "asDesc");
            return (Criteria) this;
        }

        public Criteria andAsDescLessThanOrEqualTo(String value) {
            addCriterion("as_desc <=", value, "asDesc");
            return (Criteria) this;
        }

        public Criteria andAsDescLike(String value) {
            addCriterion("as_desc like", value, "asDesc");
            return (Criteria) this;
        }

        public Criteria andAsDescNotLike(String value) {
            addCriterion("as_desc not like", value, "asDesc");
            return (Criteria) this;
        }

        public Criteria andAsDescIn(List<String> values) {
            addCriterion("as_desc in", values, "asDesc");
            return (Criteria) this;
        }

        public Criteria andAsDescNotIn(List<String> values) {
            addCriterion("as_desc not in", values, "asDesc");
            return (Criteria) this;
        }

        public Criteria andAsDescBetween(String value1, String value2) {
            addCriterion("as_desc between", value1, value2, "asDesc");
            return (Criteria) this;
        }

        public Criteria andAsDescNotBetween(String value1, String value2) {
            addCriterion("as_desc not between", value1, value2, "asDesc");
            return (Criteria) this;
        }

        public Criteria andMemberIdIsNull() {
            addCriterion("member_id is null");
            return (Criteria) this;
        }

        public Criteria andMemberIdIsNotNull() {
            addCriterion("member_id is not null");
            return (Criteria) this;
        }

        public Criteria andMemberIdEqualTo(Integer value) {
            addCriterion("member_id =", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotEqualTo(Integer value) {
            addCriterion("member_id <>", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThan(Integer value) {
            addCriterion("member_id >", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("member_id >=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThan(Integer value) {
            addCriterion("member_id <", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThanOrEqualTo(Integer value) {
            addCriterion("member_id <=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdIn(List<Integer> values) {
            addCriterion("member_id in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotIn(List<Integer> values) {
            addCriterion("member_id not in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdBetween(Integer value1, Integer value2) {
            addCriterion("member_id between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotBetween(Integer value1, Integer value2) {
            addCriterion("member_id not between", value1, value2, "memberId");
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

        public Criteria andAsDealwithTimeIsNull() {
            addCriterion("as_dealWith_time is null");
            return (Criteria) this;
        }

        public Criteria andAsDealwithTimeIsNotNull() {
            addCriterion("as_dealWith_time is not null");
            return (Criteria) this;
        }

        public Criteria andAsDealwithTimeEqualTo(Date value) {
            addCriterion("as_dealWith_time =", value, "asDealwithTime");
            return (Criteria) this;
        }

        public Criteria andAsDealwithTimeNotEqualTo(Date value) {
            addCriterion("as_dealWith_time <>", value, "asDealwithTime");
            return (Criteria) this;
        }

        public Criteria andAsDealwithTimeGreaterThan(Date value) {
            addCriterion("as_dealWith_time >", value, "asDealwithTime");
            return (Criteria) this;
        }

        public Criteria andAsDealwithTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("as_dealWith_time >=", value, "asDealwithTime");
            return (Criteria) this;
        }

        public Criteria andAsDealwithTimeLessThan(Date value) {
            addCriterion("as_dealWith_time <", value, "asDealwithTime");
            return (Criteria) this;
        }

        public Criteria andAsDealwithTimeLessThanOrEqualTo(Date value) {
            addCriterion("as_dealWith_time <=", value, "asDealwithTime");
            return (Criteria) this;
        }

        public Criteria andAsDealwithTimeIn(List<Date> values) {
            addCriterion("as_dealWith_time in", values, "asDealwithTime");
            return (Criteria) this;
        }

        public Criteria andAsDealwithTimeNotIn(List<Date> values) {
            addCriterion("as_dealWith_time not in", values, "asDealwithTime");
            return (Criteria) this;
        }

        public Criteria andAsDealwithTimeBetween(Date value1, Date value2) {
            addCriterion("as_dealWith_time between", value1, value2, "asDealwithTime");
            return (Criteria) this;
        }

        public Criteria andAsDealwithTimeNotBetween(Date value1, Date value2) {
            addCriterion("as_dealWith_time not between", value1, value2, "asDealwithTime");
            return (Criteria) this;
        }

        public Criteria andAsDealwithDescIsNull() {
            addCriterion("as_dealWith_desc is null");
            return (Criteria) this;
        }

        public Criteria andAsDealwithDescIsNotNull() {
            addCriterion("as_dealWith_desc is not null");
            return (Criteria) this;
        }

        public Criteria andAsDealwithDescEqualTo(String value) {
            addCriterion("as_dealWith_desc =", value, "asDealwithDesc");
            return (Criteria) this;
        }

        public Criteria andAsDealwithDescNotEqualTo(String value) {
            addCriterion("as_dealWith_desc <>", value, "asDealwithDesc");
            return (Criteria) this;
        }

        public Criteria andAsDealwithDescGreaterThan(String value) {
            addCriterion("as_dealWith_desc >", value, "asDealwithDesc");
            return (Criteria) this;
        }

        public Criteria andAsDealwithDescGreaterThanOrEqualTo(String value) {
            addCriterion("as_dealWith_desc >=", value, "asDealwithDesc");
            return (Criteria) this;
        }

        public Criteria andAsDealwithDescLessThan(String value) {
            addCriterion("as_dealWith_desc <", value, "asDealwithDesc");
            return (Criteria) this;
        }

        public Criteria andAsDealwithDescLessThanOrEqualTo(String value) {
            addCriterion("as_dealWith_desc <=", value, "asDealwithDesc");
            return (Criteria) this;
        }

        public Criteria andAsDealwithDescLike(String value) {
            addCriterion("as_dealWith_desc like", value, "asDealwithDesc");
            return (Criteria) this;
        }

        public Criteria andAsDealwithDescNotLike(String value) {
            addCriterion("as_dealWith_desc not like", value, "asDealwithDesc");
            return (Criteria) this;
        }

        public Criteria andAsDealwithDescIn(List<String> values) {
            addCriterion("as_dealWith_desc in", values, "asDealwithDesc");
            return (Criteria) this;
        }

        public Criteria andAsDealwithDescNotIn(List<String> values) {
            addCriterion("as_dealWith_desc not in", values, "asDealwithDesc");
            return (Criteria) this;
        }

        public Criteria andAsDealwithDescBetween(String value1, String value2) {
            addCriterion("as_dealWith_desc between", value1, value2, "asDealwithDesc");
            return (Criteria) this;
        }

        public Criteria andAsDealwithDescNotBetween(String value1, String value2) {
            addCriterion("as_dealWith_desc not between", value1, value2, "asDealwithDesc");
            return (Criteria) this;
        }

        public Criteria andAsDealwithFlagIsNull() {
            addCriterion("as_dealWith_flag is null");
            return (Criteria) this;
        }

        public Criteria andAsDealwithFlagIsNotNull() {
            addCriterion("as_dealWith_flag is not null");
            return (Criteria) this;
        }

        public Criteria andAsDealwithFlagEqualTo(Integer value) {
            addCriterion("as_dealWith_flag =", value, "asDealwithFlag");
            return (Criteria) this;
        }

        public Criteria andAsDealwithFlagNotEqualTo(Integer value) {
            addCriterion("as_dealWith_flag <>", value, "asDealwithFlag");
            return (Criteria) this;
        }

        public Criteria andAsDealwithFlagGreaterThan(Integer value) {
            addCriterion("as_dealWith_flag >", value, "asDealwithFlag");
            return (Criteria) this;
        }

        public Criteria andAsDealwithFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("as_dealWith_flag >=", value, "asDealwithFlag");
            return (Criteria) this;
        }

        public Criteria andAsDealwithFlagLessThan(Integer value) {
            addCriterion("as_dealWith_flag <", value, "asDealwithFlag");
            return (Criteria) this;
        }

        public Criteria andAsDealwithFlagLessThanOrEqualTo(Integer value) {
            addCriterion("as_dealWith_flag <=", value, "asDealwithFlag");
            return (Criteria) this;
        }

        public Criteria andAsDealwithFlagIn(List<Integer> values) {
            addCriterion("as_dealWith_flag in", values, "asDealwithFlag");
            return (Criteria) this;
        }

        public Criteria andAsDealwithFlagNotIn(List<Integer> values) {
            addCriterion("as_dealWith_flag not in", values, "asDealwithFlag");
            return (Criteria) this;
        }

        public Criteria andAsDealwithFlagBetween(Integer value1, Integer value2) {
            addCriterion("as_dealWith_flag between", value1, value2, "asDealwithFlag");
            return (Criteria) this;
        }

        public Criteria andAsDealwithFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("as_dealWith_flag not between", value1, value2, "asDealwithFlag");
            return (Criteria) this;
        }

        public Criteria andAsDealwithAccountIsNull() {
            addCriterion("as_dealWith_account is null");
            return (Criteria) this;
        }

        public Criteria andAsDealwithAccountIsNotNull() {
            addCriterion("as_dealWith_account is not null");
            return (Criteria) this;
        }

        public Criteria andAsDealwithAccountEqualTo(String value) {
            addCriterion("as_dealWith_account =", value, "asDealwithAccount");
            return (Criteria) this;
        }

        public Criteria andAsDealwithAccountNotEqualTo(String value) {
            addCriterion("as_dealWith_account <>", value, "asDealwithAccount");
            return (Criteria) this;
        }

        public Criteria andAsDealwithAccountGreaterThan(String value) {
            addCriterion("as_dealWith_account >", value, "asDealwithAccount");
            return (Criteria) this;
        }

        public Criteria andAsDealwithAccountGreaterThanOrEqualTo(String value) {
            addCriterion("as_dealWith_account >=", value, "asDealwithAccount");
            return (Criteria) this;
        }

        public Criteria andAsDealwithAccountLessThan(String value) {
            addCriterion("as_dealWith_account <", value, "asDealwithAccount");
            return (Criteria) this;
        }

        public Criteria andAsDealwithAccountLessThanOrEqualTo(String value) {
            addCriterion("as_dealWith_account <=", value, "asDealwithAccount");
            return (Criteria) this;
        }

        public Criteria andAsDealwithAccountLike(String value) {
            addCriterion("as_dealWith_account like", value, "asDealwithAccount");
            return (Criteria) this;
        }

        public Criteria andAsDealwithAccountNotLike(String value) {
            addCriterion("as_dealWith_account not like", value, "asDealwithAccount");
            return (Criteria) this;
        }

        public Criteria andAsDealwithAccountIn(List<String> values) {
            addCriterion("as_dealWith_account in", values, "asDealwithAccount");
            return (Criteria) this;
        }

        public Criteria andAsDealwithAccountNotIn(List<String> values) {
            addCriterion("as_dealWith_account not in", values, "asDealwithAccount");
            return (Criteria) this;
        }

        public Criteria andAsDealwithAccountBetween(String value1, String value2) {
            addCriterion("as_dealWith_account between", value1, value2, "asDealwithAccount");
            return (Criteria) this;
        }

        public Criteria andAsDealwithAccountNotBetween(String value1, String value2) {
            addCriterion("as_dealWith_account not between", value1, value2, "asDealwithAccount");
            return (Criteria) this;
        }

        public Criteria andAsCreateTimeIsNull() {
            addCriterion("as_create_time is null");
            return (Criteria) this;
        }

        public Criteria andAsCreateTimeIsNotNull() {
            addCriterion("as_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andAsCreateTimeEqualTo(Date value) {
            addCriterion("as_create_time =", value, "asCreateTime");
            return (Criteria) this;
        }

        public Criteria andAsCreateTimeNotEqualTo(Date value) {
            addCriterion("as_create_time <>", value, "asCreateTime");
            return (Criteria) this;
        }

        public Criteria andAsCreateTimeGreaterThan(Date value) {
            addCriterion("as_create_time >", value, "asCreateTime");
            return (Criteria) this;
        }

        public Criteria andAsCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("as_create_time >=", value, "asCreateTime");
            return (Criteria) this;
        }

        public Criteria andAsCreateTimeLessThan(Date value) {
            addCriterion("as_create_time <", value, "asCreateTime");
            return (Criteria) this;
        }

        public Criteria andAsCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("as_create_time <=", value, "asCreateTime");
            return (Criteria) this;
        }

        public Criteria andAsCreateTimeIn(List<Date> values) {
            addCriterion("as_create_time in", values, "asCreateTime");
            return (Criteria) this;
        }

        public Criteria andAsCreateTimeNotIn(List<Date> values) {
            addCriterion("as_create_time not in", values, "asCreateTime");
            return (Criteria) this;
        }

        public Criteria andAsCreateTimeBetween(Date value1, Date value2) {
            addCriterion("as_create_time between", value1, value2, "asCreateTime");
            return (Criteria) this;
        }

        public Criteria andAsCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("as_create_time not between", value1, value2, "asCreateTime");
            return (Criteria) this;
        }

        public Criteria andAsDelFlagIsNull() {
            addCriterion("as_del_flag is null");
            return (Criteria) this;
        }

        public Criteria andAsDelFlagIsNotNull() {
            addCriterion("as_del_flag is not null");
            return (Criteria) this;
        }

        public Criteria andAsDelFlagEqualTo(Integer value) {
            addCriterion("as_del_flag =", value, "asDelFlag");
            return (Criteria) this;
        }

        public Criteria andAsDelFlagNotEqualTo(Integer value) {
            addCriterion("as_del_flag <>", value, "asDelFlag");
            return (Criteria) this;
        }

        public Criteria andAsDelFlagGreaterThan(Integer value) {
            addCriterion("as_del_flag >", value, "asDelFlag");
            return (Criteria) this;
        }

        public Criteria andAsDelFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("as_del_flag >=", value, "asDelFlag");
            return (Criteria) this;
        }

        public Criteria andAsDelFlagLessThan(Integer value) {
            addCriterion("as_del_flag <", value, "asDelFlag");
            return (Criteria) this;
        }

        public Criteria andAsDelFlagLessThanOrEqualTo(Integer value) {
            addCriterion("as_del_flag <=", value, "asDelFlag");
            return (Criteria) this;
        }

        public Criteria andAsDelFlagIn(List<Integer> values) {
            addCriterion("as_del_flag in", values, "asDelFlag");
            return (Criteria) this;
        }

        public Criteria andAsDelFlagNotIn(List<Integer> values) {
            addCriterion("as_del_flag not in", values, "asDelFlag");
            return (Criteria) this;
        }

        public Criteria andAsDelFlagBetween(Integer value1, Integer value2) {
            addCriterion("as_del_flag between", value1, value2, "asDelFlag");
            return (Criteria) this;
        }

        public Criteria andAsDelFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("as_del_flag not between", value1, value2, "asDelFlag");
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
     * k2_order_after_sales
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * k2_order_after_sales 2019-08-06
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