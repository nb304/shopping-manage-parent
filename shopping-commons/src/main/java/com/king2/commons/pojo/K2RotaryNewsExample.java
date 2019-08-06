package com.king2.commons.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class K2RotaryNewsExample {
    /**
     * k2_rotary_news
     */
    protected String orderByClause;

    /**
     * k2_rotary_news
     */
    protected boolean distinct;

    /**
     * k2_rotary_news
     */
    protected List<Criteria> oredCriteria;

    public K2RotaryNewsExample() {
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
     * k2_rotary_news 2019-08-06
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

        public Criteria andRotaryIdIsNull() {
            addCriterion("rotary_id is null");
            return (Criteria) this;
        }

        public Criteria andRotaryIdIsNotNull() {
            addCriterion("rotary_id is not null");
            return (Criteria) this;
        }

        public Criteria andRotaryIdEqualTo(Integer value) {
            addCriterion("rotary_id =", value, "rotaryId");
            return (Criteria) this;
        }

        public Criteria andRotaryIdNotEqualTo(Integer value) {
            addCriterion("rotary_id <>", value, "rotaryId");
            return (Criteria) this;
        }

        public Criteria andRotaryIdGreaterThan(Integer value) {
            addCriterion("rotary_id >", value, "rotaryId");
            return (Criteria) this;
        }

        public Criteria andRotaryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("rotary_id >=", value, "rotaryId");
            return (Criteria) this;
        }

        public Criteria andRotaryIdLessThan(Integer value) {
            addCriterion("rotary_id <", value, "rotaryId");
            return (Criteria) this;
        }

        public Criteria andRotaryIdLessThanOrEqualTo(Integer value) {
            addCriterion("rotary_id <=", value, "rotaryId");
            return (Criteria) this;
        }

        public Criteria andRotaryIdIn(List<Integer> values) {
            addCriterion("rotary_id in", values, "rotaryId");
            return (Criteria) this;
        }

        public Criteria andRotaryIdNotIn(List<Integer> values) {
            addCriterion("rotary_id not in", values, "rotaryId");
            return (Criteria) this;
        }

        public Criteria andRotaryIdBetween(Integer value1, Integer value2) {
            addCriterion("rotary_id between", value1, value2, "rotaryId");
            return (Criteria) this;
        }

        public Criteria andRotaryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("rotary_id not between", value1, value2, "rotaryId");
            return (Criteria) this;
        }

        public Criteria andRotaryNumberIsNull() {
            addCriterion("rotary_number is null");
            return (Criteria) this;
        }

        public Criteria andRotaryNumberIsNotNull() {
            addCriterion("rotary_number is not null");
            return (Criteria) this;
        }

        public Criteria andRotaryNumberEqualTo(String value) {
            addCriterion("rotary_number =", value, "rotaryNumber");
            return (Criteria) this;
        }

        public Criteria andRotaryNumberNotEqualTo(String value) {
            addCriterion("rotary_number <>", value, "rotaryNumber");
            return (Criteria) this;
        }

        public Criteria andRotaryNumberGreaterThan(String value) {
            addCriterion("rotary_number >", value, "rotaryNumber");
            return (Criteria) this;
        }

        public Criteria andRotaryNumberGreaterThanOrEqualTo(String value) {
            addCriterion("rotary_number >=", value, "rotaryNumber");
            return (Criteria) this;
        }

        public Criteria andRotaryNumberLessThan(String value) {
            addCriterion("rotary_number <", value, "rotaryNumber");
            return (Criteria) this;
        }

        public Criteria andRotaryNumberLessThanOrEqualTo(String value) {
            addCriterion("rotary_number <=", value, "rotaryNumber");
            return (Criteria) this;
        }

        public Criteria andRotaryNumberLike(String value) {
            addCriterion("rotary_number like", value, "rotaryNumber");
            return (Criteria) this;
        }

        public Criteria andRotaryNumberNotLike(String value) {
            addCriterion("rotary_number not like", value, "rotaryNumber");
            return (Criteria) this;
        }

        public Criteria andRotaryNumberIn(List<String> values) {
            addCriterion("rotary_number in", values, "rotaryNumber");
            return (Criteria) this;
        }

        public Criteria andRotaryNumberNotIn(List<String> values) {
            addCriterion("rotary_number not in", values, "rotaryNumber");
            return (Criteria) this;
        }

        public Criteria andRotaryNumberBetween(String value1, String value2) {
            addCriterion("rotary_number between", value1, value2, "rotaryNumber");
            return (Criteria) this;
        }

        public Criteria andRotaryNumberNotBetween(String value1, String value2) {
            addCriterion("rotary_number not between", value1, value2, "rotaryNumber");
            return (Criteria) this;
        }

        public Criteria andRotaryNameIsNull() {
            addCriterion("rotary_name is null");
            return (Criteria) this;
        }

        public Criteria andRotaryNameIsNotNull() {
            addCriterion("rotary_name is not null");
            return (Criteria) this;
        }

        public Criteria andRotaryNameEqualTo(String value) {
            addCriterion("rotary_name =", value, "rotaryName");
            return (Criteria) this;
        }

        public Criteria andRotaryNameNotEqualTo(String value) {
            addCriterion("rotary_name <>", value, "rotaryName");
            return (Criteria) this;
        }

        public Criteria andRotaryNameGreaterThan(String value) {
            addCriterion("rotary_name >", value, "rotaryName");
            return (Criteria) this;
        }

        public Criteria andRotaryNameGreaterThanOrEqualTo(String value) {
            addCriterion("rotary_name >=", value, "rotaryName");
            return (Criteria) this;
        }

        public Criteria andRotaryNameLessThan(String value) {
            addCriterion("rotary_name <", value, "rotaryName");
            return (Criteria) this;
        }

        public Criteria andRotaryNameLessThanOrEqualTo(String value) {
            addCriterion("rotary_name <=", value, "rotaryName");
            return (Criteria) this;
        }

        public Criteria andRotaryNameLike(String value) {
            addCriterion("rotary_name like", value, "rotaryName");
            return (Criteria) this;
        }

        public Criteria andRotaryNameNotLike(String value) {
            addCriterion("rotary_name not like", value, "rotaryName");
            return (Criteria) this;
        }

        public Criteria andRotaryNameIn(List<String> values) {
            addCriterion("rotary_name in", values, "rotaryName");
            return (Criteria) this;
        }

        public Criteria andRotaryNameNotIn(List<String> values) {
            addCriterion("rotary_name not in", values, "rotaryName");
            return (Criteria) this;
        }

        public Criteria andRotaryNameBetween(String value1, String value2) {
            addCriterion("rotary_name between", value1, value2, "rotaryName");
            return (Criteria) this;
        }

        public Criteria andRotaryNameNotBetween(String value1, String value2) {
            addCriterion("rotary_name not between", value1, value2, "rotaryName");
            return (Criteria) this;
        }

        public Criteria andRotaryStartTimeIsNull() {
            addCriterion("rotary_start_time is null");
            return (Criteria) this;
        }

        public Criteria andRotaryStartTimeIsNotNull() {
            addCriterion("rotary_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andRotaryStartTimeEqualTo(Date value) {
            addCriterion("rotary_start_time =", value, "rotaryStartTime");
            return (Criteria) this;
        }

        public Criteria andRotaryStartTimeNotEqualTo(Date value) {
            addCriterion("rotary_start_time <>", value, "rotaryStartTime");
            return (Criteria) this;
        }

        public Criteria andRotaryStartTimeGreaterThan(Date value) {
            addCriterion("rotary_start_time >", value, "rotaryStartTime");
            return (Criteria) this;
        }

        public Criteria andRotaryStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("rotary_start_time >=", value, "rotaryStartTime");
            return (Criteria) this;
        }

        public Criteria andRotaryStartTimeLessThan(Date value) {
            addCriterion("rotary_start_time <", value, "rotaryStartTime");
            return (Criteria) this;
        }

        public Criteria andRotaryStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("rotary_start_time <=", value, "rotaryStartTime");
            return (Criteria) this;
        }

        public Criteria andRotaryStartTimeIn(List<Date> values) {
            addCriterion("rotary_start_time in", values, "rotaryStartTime");
            return (Criteria) this;
        }

        public Criteria andRotaryStartTimeNotIn(List<Date> values) {
            addCriterion("rotary_start_time not in", values, "rotaryStartTime");
            return (Criteria) this;
        }

        public Criteria andRotaryStartTimeBetween(Date value1, Date value2) {
            addCriterion("rotary_start_time between", value1, value2, "rotaryStartTime");
            return (Criteria) this;
        }

        public Criteria andRotaryStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("rotary_start_time not between", value1, value2, "rotaryStartTime");
            return (Criteria) this;
        }

        public Criteria andRotaryEndTimeIsNull() {
            addCriterion("rotary_end_time is null");
            return (Criteria) this;
        }

        public Criteria andRotaryEndTimeIsNotNull() {
            addCriterion("rotary_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andRotaryEndTimeEqualTo(Date value) {
            addCriterion("rotary_end_time =", value, "rotaryEndTime");
            return (Criteria) this;
        }

        public Criteria andRotaryEndTimeNotEqualTo(Date value) {
            addCriterion("rotary_end_time <>", value, "rotaryEndTime");
            return (Criteria) this;
        }

        public Criteria andRotaryEndTimeGreaterThan(Date value) {
            addCriterion("rotary_end_time >", value, "rotaryEndTime");
            return (Criteria) this;
        }

        public Criteria andRotaryEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("rotary_end_time >=", value, "rotaryEndTime");
            return (Criteria) this;
        }

        public Criteria andRotaryEndTimeLessThan(Date value) {
            addCriterion("rotary_end_time <", value, "rotaryEndTime");
            return (Criteria) this;
        }

        public Criteria andRotaryEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("rotary_end_time <=", value, "rotaryEndTime");
            return (Criteria) this;
        }

        public Criteria andRotaryEndTimeIn(List<Date> values) {
            addCriterion("rotary_end_time in", values, "rotaryEndTime");
            return (Criteria) this;
        }

        public Criteria andRotaryEndTimeNotIn(List<Date> values) {
            addCriterion("rotary_end_time not in", values, "rotaryEndTime");
            return (Criteria) this;
        }

        public Criteria andRotaryEndTimeBetween(Date value1, Date value2) {
            addCriterion("rotary_end_time between", value1, value2, "rotaryEndTime");
            return (Criteria) this;
        }

        public Criteria andRotaryEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("rotary_end_time not between", value1, value2, "rotaryEndTime");
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

        public Criteria andCreateUserIdIsNull() {
            addCriterion("create_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNotNull() {
            addCriterion("create_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdEqualTo(Integer value) {
            addCriterion("create_user_id =", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotEqualTo(Integer value) {
            addCriterion("create_user_id <>", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThan(Integer value) {
            addCriterion("create_user_id >", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_user_id >=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThan(Integer value) {
            addCriterion("create_user_id <", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("create_user_id <=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIn(List<Integer> values) {
            addCriterion("create_user_id in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotIn(List<Integer> values) {
            addCriterion("create_user_id not in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdBetween(Integer value1, Integer value2) {
            addCriterion("create_user_id between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("create_user_id not between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andRotaryStateIsNull() {
            addCriterion("rotary_state is null");
            return (Criteria) this;
        }

        public Criteria andRotaryStateIsNotNull() {
            addCriterion("rotary_state is not null");
            return (Criteria) this;
        }

        public Criteria andRotaryStateEqualTo(Integer value) {
            addCriterion("rotary_state =", value, "rotaryState");
            return (Criteria) this;
        }

        public Criteria andRotaryStateNotEqualTo(Integer value) {
            addCriterion("rotary_state <>", value, "rotaryState");
            return (Criteria) this;
        }

        public Criteria andRotaryStateGreaterThan(Integer value) {
            addCriterion("rotary_state >", value, "rotaryState");
            return (Criteria) this;
        }

        public Criteria andRotaryStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("rotary_state >=", value, "rotaryState");
            return (Criteria) this;
        }

        public Criteria andRotaryStateLessThan(Integer value) {
            addCriterion("rotary_state <", value, "rotaryState");
            return (Criteria) this;
        }

        public Criteria andRotaryStateLessThanOrEqualTo(Integer value) {
            addCriterion("rotary_state <=", value, "rotaryState");
            return (Criteria) this;
        }

        public Criteria andRotaryStateIn(List<Integer> values) {
            addCriterion("rotary_state in", values, "rotaryState");
            return (Criteria) this;
        }

        public Criteria andRotaryStateNotIn(List<Integer> values) {
            addCriterion("rotary_state not in", values, "rotaryState");
            return (Criteria) this;
        }

        public Criteria andRotaryStateBetween(Integer value1, Integer value2) {
            addCriterion("rotary_state between", value1, value2, "rotaryState");
            return (Criteria) this;
        }

        public Criteria andRotaryStateNotBetween(Integer value1, Integer value2) {
            addCriterion("rotary_state not between", value1, value2, "rotaryState");
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
     * k2_rotary_news
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * k2_rotary_news 2019-08-06
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