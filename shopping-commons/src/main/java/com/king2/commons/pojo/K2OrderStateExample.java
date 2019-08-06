package com.king2.commons.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class K2OrderStateExample {
    /**
     * k2_order_state
     */
    protected String orderByClause;

    /**
     * k2_order_state
     */
    protected boolean distinct;

    /**
     * k2_order_state
     */
    protected List<Criteria> oredCriteria;

    public K2OrderStateExample() {
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
     * k2_order_state 2019-08-06
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

        public Criteria andOsIdIsNull() {
            addCriterion("os_id is null");
            return (Criteria) this;
        }

        public Criteria andOsIdIsNotNull() {
            addCriterion("os_id is not null");
            return (Criteria) this;
        }

        public Criteria andOsIdEqualTo(String value) {
            addCriterion("os_id =", value, "osId");
            return (Criteria) this;
        }

        public Criteria andOsIdNotEqualTo(String value) {
            addCriterion("os_id <>", value, "osId");
            return (Criteria) this;
        }

        public Criteria andOsIdGreaterThan(String value) {
            addCriterion("os_id >", value, "osId");
            return (Criteria) this;
        }

        public Criteria andOsIdGreaterThanOrEqualTo(String value) {
            addCriterion("os_id >=", value, "osId");
            return (Criteria) this;
        }

        public Criteria andOsIdLessThan(String value) {
            addCriterion("os_id <", value, "osId");
            return (Criteria) this;
        }

        public Criteria andOsIdLessThanOrEqualTo(String value) {
            addCriterion("os_id <=", value, "osId");
            return (Criteria) this;
        }

        public Criteria andOsIdLike(String value) {
            addCriterion("os_id like", value, "osId");
            return (Criteria) this;
        }

        public Criteria andOsIdNotLike(String value) {
            addCriterion("os_id not like", value, "osId");
            return (Criteria) this;
        }

        public Criteria andOsIdIn(List<String> values) {
            addCriterion("os_id in", values, "osId");
            return (Criteria) this;
        }

        public Criteria andOsIdNotIn(List<String> values) {
            addCriterion("os_id not in", values, "osId");
            return (Criteria) this;
        }

        public Criteria andOsIdBetween(String value1, String value2) {
            addCriterion("os_id between", value1, value2, "osId");
            return (Criteria) this;
        }

        public Criteria andOsIdNotBetween(String value1, String value2) {
            addCriterion("os_id not between", value1, value2, "osId");
            return (Criteria) this;
        }

        public Criteria andOsNumberIsNull() {
            addCriterion("os_number is null");
            return (Criteria) this;
        }

        public Criteria andOsNumberIsNotNull() {
            addCriterion("os_number is not null");
            return (Criteria) this;
        }

        public Criteria andOsNumberEqualTo(String value) {
            addCriterion("os_number =", value, "osNumber");
            return (Criteria) this;
        }

        public Criteria andOsNumberNotEqualTo(String value) {
            addCriterion("os_number <>", value, "osNumber");
            return (Criteria) this;
        }

        public Criteria andOsNumberGreaterThan(String value) {
            addCriterion("os_number >", value, "osNumber");
            return (Criteria) this;
        }

        public Criteria andOsNumberGreaterThanOrEqualTo(String value) {
            addCriterion("os_number >=", value, "osNumber");
            return (Criteria) this;
        }

        public Criteria andOsNumberLessThan(String value) {
            addCriterion("os_number <", value, "osNumber");
            return (Criteria) this;
        }

        public Criteria andOsNumberLessThanOrEqualTo(String value) {
            addCriterion("os_number <=", value, "osNumber");
            return (Criteria) this;
        }

        public Criteria andOsNumberLike(String value) {
            addCriterion("os_number like", value, "osNumber");
            return (Criteria) this;
        }

        public Criteria andOsNumberNotLike(String value) {
            addCriterion("os_number not like", value, "osNumber");
            return (Criteria) this;
        }

        public Criteria andOsNumberIn(List<String> values) {
            addCriterion("os_number in", values, "osNumber");
            return (Criteria) this;
        }

        public Criteria andOsNumberNotIn(List<String> values) {
            addCriterion("os_number not in", values, "osNumber");
            return (Criteria) this;
        }

        public Criteria andOsNumberBetween(String value1, String value2) {
            addCriterion("os_number between", value1, value2, "osNumber");
            return (Criteria) this;
        }

        public Criteria andOsNumberNotBetween(String value1, String value2) {
            addCriterion("os_number not between", value1, value2, "osNumber");
            return (Criteria) this;
        }

        public Criteria andOsNameIsNull() {
            addCriterion("os_name is null");
            return (Criteria) this;
        }

        public Criteria andOsNameIsNotNull() {
            addCriterion("os_name is not null");
            return (Criteria) this;
        }

        public Criteria andOsNameEqualTo(String value) {
            addCriterion("os_name =", value, "osName");
            return (Criteria) this;
        }

        public Criteria andOsNameNotEqualTo(String value) {
            addCriterion("os_name <>", value, "osName");
            return (Criteria) this;
        }

        public Criteria andOsNameGreaterThan(String value) {
            addCriterion("os_name >", value, "osName");
            return (Criteria) this;
        }

        public Criteria andOsNameGreaterThanOrEqualTo(String value) {
            addCriterion("os_name >=", value, "osName");
            return (Criteria) this;
        }

        public Criteria andOsNameLessThan(String value) {
            addCriterion("os_name <", value, "osName");
            return (Criteria) this;
        }

        public Criteria andOsNameLessThanOrEqualTo(String value) {
            addCriterion("os_name <=", value, "osName");
            return (Criteria) this;
        }

        public Criteria andOsNameLike(String value) {
            addCriterion("os_name like", value, "osName");
            return (Criteria) this;
        }

        public Criteria andOsNameNotLike(String value) {
            addCriterion("os_name not like", value, "osName");
            return (Criteria) this;
        }

        public Criteria andOsNameIn(List<String> values) {
            addCriterion("os_name in", values, "osName");
            return (Criteria) this;
        }

        public Criteria andOsNameNotIn(List<String> values) {
            addCriterion("os_name not in", values, "osName");
            return (Criteria) this;
        }

        public Criteria andOsNameBetween(String value1, String value2) {
            addCriterion("os_name between", value1, value2, "osName");
            return (Criteria) this;
        }

        public Criteria andOsNameNotBetween(String value1, String value2) {
            addCriterion("os_name not between", value1, value2, "osName");
            return (Criteria) this;
        }

        public Criteria andOsDelFlagIsNull() {
            addCriterion("os_del_flag is null");
            return (Criteria) this;
        }

        public Criteria andOsDelFlagIsNotNull() {
            addCriterion("os_del_flag is not null");
            return (Criteria) this;
        }

        public Criteria andOsDelFlagEqualTo(Integer value) {
            addCriterion("os_del_flag =", value, "osDelFlag");
            return (Criteria) this;
        }

        public Criteria andOsDelFlagNotEqualTo(Integer value) {
            addCriterion("os_del_flag <>", value, "osDelFlag");
            return (Criteria) this;
        }

        public Criteria andOsDelFlagGreaterThan(Integer value) {
            addCriterion("os_del_flag >", value, "osDelFlag");
            return (Criteria) this;
        }

        public Criteria andOsDelFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("os_del_flag >=", value, "osDelFlag");
            return (Criteria) this;
        }

        public Criteria andOsDelFlagLessThan(Integer value) {
            addCriterion("os_del_flag <", value, "osDelFlag");
            return (Criteria) this;
        }

        public Criteria andOsDelFlagLessThanOrEqualTo(Integer value) {
            addCriterion("os_del_flag <=", value, "osDelFlag");
            return (Criteria) this;
        }

        public Criteria andOsDelFlagIn(List<Integer> values) {
            addCriterion("os_del_flag in", values, "osDelFlag");
            return (Criteria) this;
        }

        public Criteria andOsDelFlagNotIn(List<Integer> values) {
            addCriterion("os_del_flag not in", values, "osDelFlag");
            return (Criteria) this;
        }

        public Criteria andOsDelFlagBetween(Integer value1, Integer value2) {
            addCriterion("os_del_flag between", value1, value2, "osDelFlag");
            return (Criteria) this;
        }

        public Criteria andOsDelFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("os_del_flag not between", value1, value2, "osDelFlag");
            return (Criteria) this;
        }

        public Criteria andOsCreateTimeIsNull() {
            addCriterion("os_create_time is null");
            return (Criteria) this;
        }

        public Criteria andOsCreateTimeIsNotNull() {
            addCriterion("os_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andOsCreateTimeEqualTo(Date value) {
            addCriterion("os_create_time =", value, "osCreateTime");
            return (Criteria) this;
        }

        public Criteria andOsCreateTimeNotEqualTo(Date value) {
            addCriterion("os_create_time <>", value, "osCreateTime");
            return (Criteria) this;
        }

        public Criteria andOsCreateTimeGreaterThan(Date value) {
            addCriterion("os_create_time >", value, "osCreateTime");
            return (Criteria) this;
        }

        public Criteria andOsCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("os_create_time >=", value, "osCreateTime");
            return (Criteria) this;
        }

        public Criteria andOsCreateTimeLessThan(Date value) {
            addCriterion("os_create_time <", value, "osCreateTime");
            return (Criteria) this;
        }

        public Criteria andOsCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("os_create_time <=", value, "osCreateTime");
            return (Criteria) this;
        }

        public Criteria andOsCreateTimeIn(List<Date> values) {
            addCriterion("os_create_time in", values, "osCreateTime");
            return (Criteria) this;
        }

        public Criteria andOsCreateTimeNotIn(List<Date> values) {
            addCriterion("os_create_time not in", values, "osCreateTime");
            return (Criteria) this;
        }

        public Criteria andOsCreateTimeBetween(Date value1, Date value2) {
            addCriterion("os_create_time between", value1, value2, "osCreateTime");
            return (Criteria) this;
        }

        public Criteria andOsCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("os_create_time not between", value1, value2, "osCreateTime");
            return (Criteria) this;
        }

        public Criteria andOsMemberAccountIsNull() {
            addCriterion("os_member_account is null");
            return (Criteria) this;
        }

        public Criteria andOsMemberAccountIsNotNull() {
            addCriterion("os_member_account is not null");
            return (Criteria) this;
        }

        public Criteria andOsMemberAccountEqualTo(String value) {
            addCriterion("os_member_account =", value, "osMemberAccount");
            return (Criteria) this;
        }

        public Criteria andOsMemberAccountNotEqualTo(String value) {
            addCriterion("os_member_account <>", value, "osMemberAccount");
            return (Criteria) this;
        }

        public Criteria andOsMemberAccountGreaterThan(String value) {
            addCriterion("os_member_account >", value, "osMemberAccount");
            return (Criteria) this;
        }

        public Criteria andOsMemberAccountGreaterThanOrEqualTo(String value) {
            addCriterion("os_member_account >=", value, "osMemberAccount");
            return (Criteria) this;
        }

        public Criteria andOsMemberAccountLessThan(String value) {
            addCriterion("os_member_account <", value, "osMemberAccount");
            return (Criteria) this;
        }

        public Criteria andOsMemberAccountLessThanOrEqualTo(String value) {
            addCriterion("os_member_account <=", value, "osMemberAccount");
            return (Criteria) this;
        }

        public Criteria andOsMemberAccountLike(String value) {
            addCriterion("os_member_account like", value, "osMemberAccount");
            return (Criteria) this;
        }

        public Criteria andOsMemberAccountNotLike(String value) {
            addCriterion("os_member_account not like", value, "osMemberAccount");
            return (Criteria) this;
        }

        public Criteria andOsMemberAccountIn(List<String> values) {
            addCriterion("os_member_account in", values, "osMemberAccount");
            return (Criteria) this;
        }

        public Criteria andOsMemberAccountNotIn(List<String> values) {
            addCriterion("os_member_account not in", values, "osMemberAccount");
            return (Criteria) this;
        }

        public Criteria andOsMemberAccountBetween(String value1, String value2) {
            addCriterion("os_member_account between", value1, value2, "osMemberAccount");
            return (Criteria) this;
        }

        public Criteria andOsMemberAccountNotBetween(String value1, String value2) {
            addCriterion("os_member_account not between", value1, value2, "osMemberAccount");
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
     * k2_order_state
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * k2_order_state 2019-08-06
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