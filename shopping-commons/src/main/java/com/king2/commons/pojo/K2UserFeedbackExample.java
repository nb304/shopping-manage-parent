package com.king2.commons.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class K2UserFeedbackExample {
    /**
     * k2_user_feedback
     */
    protected String orderByClause;

    /**
     * k2_user_feedback
     */
    protected boolean distinct;

    /**
     * k2_user_feedback
     */
    protected List<Criteria> oredCriteria;

    public K2UserFeedbackExample() {
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
     * k2_user_feedback 2019-08-06
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

        public Criteria andUserFeedbackIdIsNull() {
            addCriterion("user_feedback_id is null");
            return (Criteria) this;
        }

        public Criteria andUserFeedbackIdIsNotNull() {
            addCriterion("user_feedback_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserFeedbackIdEqualTo(Integer value) {
            addCriterion("user_feedback_id =", value, "userFeedbackId");
            return (Criteria) this;
        }

        public Criteria andUserFeedbackIdNotEqualTo(Integer value) {
            addCriterion("user_feedback_id <>", value, "userFeedbackId");
            return (Criteria) this;
        }

        public Criteria andUserFeedbackIdGreaterThan(Integer value) {
            addCriterion("user_feedback_id >", value, "userFeedbackId");
            return (Criteria) this;
        }

        public Criteria andUserFeedbackIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_feedback_id >=", value, "userFeedbackId");
            return (Criteria) this;
        }

        public Criteria andUserFeedbackIdLessThan(Integer value) {
            addCriterion("user_feedback_id <", value, "userFeedbackId");
            return (Criteria) this;
        }

        public Criteria andUserFeedbackIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_feedback_id <=", value, "userFeedbackId");
            return (Criteria) this;
        }

        public Criteria andUserFeedbackIdIn(List<Integer> values) {
            addCriterion("user_feedback_id in", values, "userFeedbackId");
            return (Criteria) this;
        }

        public Criteria andUserFeedbackIdNotIn(List<Integer> values) {
            addCriterion("user_feedback_id not in", values, "userFeedbackId");
            return (Criteria) this;
        }

        public Criteria andUserFeedbackIdBetween(Integer value1, Integer value2) {
            addCriterion("user_feedback_id between", value1, value2, "userFeedbackId");
            return (Criteria) this;
        }

        public Criteria andUserFeedbackIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_feedback_id not between", value1, value2, "userFeedbackId");
            return (Criteria) this;
        }

        public Criteria andUserFeedbackNumberIsNull() {
            addCriterion("user_feedback_number is null");
            return (Criteria) this;
        }

        public Criteria andUserFeedbackNumberIsNotNull() {
            addCriterion("user_feedback_number is not null");
            return (Criteria) this;
        }

        public Criteria andUserFeedbackNumberEqualTo(String value) {
            addCriterion("user_feedback_number =", value, "userFeedbackNumber");
            return (Criteria) this;
        }

        public Criteria andUserFeedbackNumberNotEqualTo(String value) {
            addCriterion("user_feedback_number <>", value, "userFeedbackNumber");
            return (Criteria) this;
        }

        public Criteria andUserFeedbackNumberGreaterThan(String value) {
            addCriterion("user_feedback_number >", value, "userFeedbackNumber");
            return (Criteria) this;
        }

        public Criteria andUserFeedbackNumberGreaterThanOrEqualTo(String value) {
            addCriterion("user_feedback_number >=", value, "userFeedbackNumber");
            return (Criteria) this;
        }

        public Criteria andUserFeedbackNumberLessThan(String value) {
            addCriterion("user_feedback_number <", value, "userFeedbackNumber");
            return (Criteria) this;
        }

        public Criteria andUserFeedbackNumberLessThanOrEqualTo(String value) {
            addCriterion("user_feedback_number <=", value, "userFeedbackNumber");
            return (Criteria) this;
        }

        public Criteria andUserFeedbackNumberLike(String value) {
            addCriterion("user_feedback_number like", value, "userFeedbackNumber");
            return (Criteria) this;
        }

        public Criteria andUserFeedbackNumberNotLike(String value) {
            addCriterion("user_feedback_number not like", value, "userFeedbackNumber");
            return (Criteria) this;
        }

        public Criteria andUserFeedbackNumberIn(List<String> values) {
            addCriterion("user_feedback_number in", values, "userFeedbackNumber");
            return (Criteria) this;
        }

        public Criteria andUserFeedbackNumberNotIn(List<String> values) {
            addCriterion("user_feedback_number not in", values, "userFeedbackNumber");
            return (Criteria) this;
        }

        public Criteria andUserFeedbackNumberBetween(String value1, String value2) {
            addCriterion("user_feedback_number between", value1, value2, "userFeedbackNumber");
            return (Criteria) this;
        }

        public Criteria andUserFeedbackNumberNotBetween(String value1, String value2) {
            addCriterion("user_feedback_number not between", value1, value2, "userFeedbackNumber");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
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

        public Criteria andUserConnectionIsNull() {
            addCriterion("user_connection is null");
            return (Criteria) this;
        }

        public Criteria andUserConnectionIsNotNull() {
            addCriterion("user_connection is not null");
            return (Criteria) this;
        }

        public Criteria andUserConnectionEqualTo(String value) {
            addCriterion("user_connection =", value, "userConnection");
            return (Criteria) this;
        }

        public Criteria andUserConnectionNotEqualTo(String value) {
            addCriterion("user_connection <>", value, "userConnection");
            return (Criteria) this;
        }

        public Criteria andUserConnectionGreaterThan(String value) {
            addCriterion("user_connection >", value, "userConnection");
            return (Criteria) this;
        }

        public Criteria andUserConnectionGreaterThanOrEqualTo(String value) {
            addCriterion("user_connection >=", value, "userConnection");
            return (Criteria) this;
        }

        public Criteria andUserConnectionLessThan(String value) {
            addCriterion("user_connection <", value, "userConnection");
            return (Criteria) this;
        }

        public Criteria andUserConnectionLessThanOrEqualTo(String value) {
            addCriterion("user_connection <=", value, "userConnection");
            return (Criteria) this;
        }

        public Criteria andUserConnectionLike(String value) {
            addCriterion("user_connection like", value, "userConnection");
            return (Criteria) this;
        }

        public Criteria andUserConnectionNotLike(String value) {
            addCriterion("user_connection not like", value, "userConnection");
            return (Criteria) this;
        }

        public Criteria andUserConnectionIn(List<String> values) {
            addCriterion("user_connection in", values, "userConnection");
            return (Criteria) this;
        }

        public Criteria andUserConnectionNotIn(List<String> values) {
            addCriterion("user_connection not in", values, "userConnection");
            return (Criteria) this;
        }

        public Criteria andUserConnectionBetween(String value1, String value2) {
            addCriterion("user_connection between", value1, value2, "userConnection");
            return (Criteria) this;
        }

        public Criteria andUserConnectionNotBetween(String value1, String value2) {
            addCriterion("user_connection not between", value1, value2, "userConnection");
            return (Criteria) this;
        }

        public Criteria andUserFeedbackStateIsNull() {
            addCriterion("user_feedback_state is null");
            return (Criteria) this;
        }

        public Criteria andUserFeedbackStateIsNotNull() {
            addCriterion("user_feedback_state is not null");
            return (Criteria) this;
        }

        public Criteria andUserFeedbackStateEqualTo(Integer value) {
            addCriterion("user_feedback_state =", value, "userFeedbackState");
            return (Criteria) this;
        }

        public Criteria andUserFeedbackStateNotEqualTo(Integer value) {
            addCriterion("user_feedback_state <>", value, "userFeedbackState");
            return (Criteria) this;
        }

        public Criteria andUserFeedbackStateGreaterThan(Integer value) {
            addCriterion("user_feedback_state >", value, "userFeedbackState");
            return (Criteria) this;
        }

        public Criteria andUserFeedbackStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_feedback_state >=", value, "userFeedbackState");
            return (Criteria) this;
        }

        public Criteria andUserFeedbackStateLessThan(Integer value) {
            addCriterion("user_feedback_state <", value, "userFeedbackState");
            return (Criteria) this;
        }

        public Criteria andUserFeedbackStateLessThanOrEqualTo(Integer value) {
            addCriterion("user_feedback_state <=", value, "userFeedbackState");
            return (Criteria) this;
        }

        public Criteria andUserFeedbackStateIn(List<Integer> values) {
            addCriterion("user_feedback_state in", values, "userFeedbackState");
            return (Criteria) this;
        }

        public Criteria andUserFeedbackStateNotIn(List<Integer> values) {
            addCriterion("user_feedback_state not in", values, "userFeedbackState");
            return (Criteria) this;
        }

        public Criteria andUserFeedbackStateBetween(Integer value1, Integer value2) {
            addCriterion("user_feedback_state between", value1, value2, "userFeedbackState");
            return (Criteria) this;
        }

        public Criteria andUserFeedbackStateNotBetween(Integer value1, Integer value2) {
            addCriterion("user_feedback_state not between", value1, value2, "userFeedbackState");
            return (Criteria) this;
        }

        public Criteria andUserFeedbackResultIsNull() {
            addCriterion("user_feedback_result is null");
            return (Criteria) this;
        }

        public Criteria andUserFeedbackResultIsNotNull() {
            addCriterion("user_feedback_result is not null");
            return (Criteria) this;
        }

        public Criteria andUserFeedbackResultEqualTo(Integer value) {
            addCriterion("user_feedback_result =", value, "userFeedbackResult");
            return (Criteria) this;
        }

        public Criteria andUserFeedbackResultNotEqualTo(Integer value) {
            addCriterion("user_feedback_result <>", value, "userFeedbackResult");
            return (Criteria) this;
        }

        public Criteria andUserFeedbackResultGreaterThan(Integer value) {
            addCriterion("user_feedback_result >", value, "userFeedbackResult");
            return (Criteria) this;
        }

        public Criteria andUserFeedbackResultGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_feedback_result >=", value, "userFeedbackResult");
            return (Criteria) this;
        }

        public Criteria andUserFeedbackResultLessThan(Integer value) {
            addCriterion("user_feedback_result <", value, "userFeedbackResult");
            return (Criteria) this;
        }

        public Criteria andUserFeedbackResultLessThanOrEqualTo(Integer value) {
            addCriterion("user_feedback_result <=", value, "userFeedbackResult");
            return (Criteria) this;
        }

        public Criteria andUserFeedbackResultIn(List<Integer> values) {
            addCriterion("user_feedback_result in", values, "userFeedbackResult");
            return (Criteria) this;
        }

        public Criteria andUserFeedbackResultNotIn(List<Integer> values) {
            addCriterion("user_feedback_result not in", values, "userFeedbackResult");
            return (Criteria) this;
        }

        public Criteria andUserFeedbackResultBetween(Integer value1, Integer value2) {
            addCriterion("user_feedback_result between", value1, value2, "userFeedbackResult");
            return (Criteria) this;
        }

        public Criteria andUserFeedbackResultNotBetween(Integer value1, Integer value2) {
            addCriterion("user_feedback_result not between", value1, value2, "userFeedbackResult");
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
     * k2_user_feedback
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * k2_user_feedback 2019-08-06
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