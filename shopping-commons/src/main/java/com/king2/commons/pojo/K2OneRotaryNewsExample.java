package com.king2.commons.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class K2OneRotaryNewsExample {
    /**
     * k2_one_rotary_news
     */
    protected String orderByClause;

    /**
     * k2_one_rotary_news
     */
    protected boolean distinct;

    /**
     * k2_one_rotary_news
     */
    protected List<Criteria> oredCriteria;

    public K2OneRotaryNewsExample() {
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
     * k2_one_rotary_news 2019-08-06
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

        public Criteria andOneRotaryNewsIdIsNull() {
            addCriterion("one_rotary_news_id is null");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsIdIsNotNull() {
            addCriterion("one_rotary_news_id is not null");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsIdEqualTo(Integer value) {
            addCriterion("one_rotary_news_id =", value, "oneRotaryNewsId");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsIdNotEqualTo(Integer value) {
            addCriterion("one_rotary_news_id <>", value, "oneRotaryNewsId");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsIdGreaterThan(Integer value) {
            addCriterion("one_rotary_news_id >", value, "oneRotaryNewsId");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("one_rotary_news_id >=", value, "oneRotaryNewsId");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsIdLessThan(Integer value) {
            addCriterion("one_rotary_news_id <", value, "oneRotaryNewsId");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsIdLessThanOrEqualTo(Integer value) {
            addCriterion("one_rotary_news_id <=", value, "oneRotaryNewsId");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsIdIn(List<Integer> values) {
            addCriterion("one_rotary_news_id in", values, "oneRotaryNewsId");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsIdNotIn(List<Integer> values) {
            addCriterion("one_rotary_news_id not in", values, "oneRotaryNewsId");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsIdBetween(Integer value1, Integer value2) {
            addCriterion("one_rotary_news_id between", value1, value2, "oneRotaryNewsId");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("one_rotary_news_id not between", value1, value2, "oneRotaryNewsId");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsNameIsNull() {
            addCriterion("one_rotary_news_name is null");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsNameIsNotNull() {
            addCriterion("one_rotary_news_name is not null");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsNameEqualTo(String value) {
            addCriterion("one_rotary_news_name =", value, "oneRotaryNewsName");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsNameNotEqualTo(String value) {
            addCriterion("one_rotary_news_name <>", value, "oneRotaryNewsName");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsNameGreaterThan(String value) {
            addCriterion("one_rotary_news_name >", value, "oneRotaryNewsName");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsNameGreaterThanOrEqualTo(String value) {
            addCriterion("one_rotary_news_name >=", value, "oneRotaryNewsName");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsNameLessThan(String value) {
            addCriterion("one_rotary_news_name <", value, "oneRotaryNewsName");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsNameLessThanOrEqualTo(String value) {
            addCriterion("one_rotary_news_name <=", value, "oneRotaryNewsName");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsNameLike(String value) {
            addCriterion("one_rotary_news_name like", value, "oneRotaryNewsName");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsNameNotLike(String value) {
            addCriterion("one_rotary_news_name not like", value, "oneRotaryNewsName");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsNameIn(List<String> values) {
            addCriterion("one_rotary_news_name in", values, "oneRotaryNewsName");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsNameNotIn(List<String> values) {
            addCriterion("one_rotary_news_name not in", values, "oneRotaryNewsName");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsNameBetween(String value1, String value2) {
            addCriterion("one_rotary_news_name between", value1, value2, "oneRotaryNewsName");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsNameNotBetween(String value1, String value2) {
            addCriterion("one_rotary_news_name not between", value1, value2, "oneRotaryNewsName");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsSourceIsNull() {
            addCriterion("one_rotary_news_source is null");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsSourceIsNotNull() {
            addCriterion("one_rotary_news_source is not null");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsSourceEqualTo(String value) {
            addCriterion("one_rotary_news_source =", value, "oneRotaryNewsSource");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsSourceNotEqualTo(String value) {
            addCriterion("one_rotary_news_source <>", value, "oneRotaryNewsSource");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsSourceGreaterThan(String value) {
            addCriterion("one_rotary_news_source >", value, "oneRotaryNewsSource");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsSourceGreaterThanOrEqualTo(String value) {
            addCriterion("one_rotary_news_source >=", value, "oneRotaryNewsSource");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsSourceLessThan(String value) {
            addCriterion("one_rotary_news_source <", value, "oneRotaryNewsSource");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsSourceLessThanOrEqualTo(String value) {
            addCriterion("one_rotary_news_source <=", value, "oneRotaryNewsSource");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsSourceLike(String value) {
            addCriterion("one_rotary_news_source like", value, "oneRotaryNewsSource");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsSourceNotLike(String value) {
            addCriterion("one_rotary_news_source not like", value, "oneRotaryNewsSource");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsSourceIn(List<String> values) {
            addCriterion("one_rotary_news_source in", values, "oneRotaryNewsSource");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsSourceNotIn(List<String> values) {
            addCriterion("one_rotary_news_source not in", values, "oneRotaryNewsSource");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsSourceBetween(String value1, String value2) {
            addCriterion("one_rotary_news_source between", value1, value2, "oneRotaryNewsSource");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsSourceNotBetween(String value1, String value2) {
            addCriterion("one_rotary_news_source not between", value1, value2, "oneRotaryNewsSource");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsStartTimeIsNull() {
            addCriterion("one_rotary_news_start_time is null");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsStartTimeIsNotNull() {
            addCriterion("one_rotary_news_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsStartTimeEqualTo(Date value) {
            addCriterion("one_rotary_news_start_time =", value, "oneRotaryNewsStartTime");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsStartTimeNotEqualTo(Date value) {
            addCriterion("one_rotary_news_start_time <>", value, "oneRotaryNewsStartTime");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsStartTimeGreaterThan(Date value) {
            addCriterion("one_rotary_news_start_time >", value, "oneRotaryNewsStartTime");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("one_rotary_news_start_time >=", value, "oneRotaryNewsStartTime");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsStartTimeLessThan(Date value) {
            addCriterion("one_rotary_news_start_time <", value, "oneRotaryNewsStartTime");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("one_rotary_news_start_time <=", value, "oneRotaryNewsStartTime");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsStartTimeIn(List<Date> values) {
            addCriterion("one_rotary_news_start_time in", values, "oneRotaryNewsStartTime");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsStartTimeNotIn(List<Date> values) {
            addCriterion("one_rotary_news_start_time not in", values, "oneRotaryNewsStartTime");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsStartTimeBetween(Date value1, Date value2) {
            addCriterion("one_rotary_news_start_time between", value1, value2, "oneRotaryNewsStartTime");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("one_rotary_news_start_time not between", value1, value2, "oneRotaryNewsStartTime");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsEndTimeIsNull() {
            addCriterion("one_rotary_news_end_time is null");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsEndTimeIsNotNull() {
            addCriterion("one_rotary_news_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsEndTimeEqualTo(Date value) {
            addCriterion("one_rotary_news_end_time =", value, "oneRotaryNewsEndTime");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsEndTimeNotEqualTo(Date value) {
            addCriterion("one_rotary_news_end_time <>", value, "oneRotaryNewsEndTime");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsEndTimeGreaterThan(Date value) {
            addCriterion("one_rotary_news_end_time >", value, "oneRotaryNewsEndTime");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("one_rotary_news_end_time >=", value, "oneRotaryNewsEndTime");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsEndTimeLessThan(Date value) {
            addCriterion("one_rotary_news_end_time <", value, "oneRotaryNewsEndTime");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("one_rotary_news_end_time <=", value, "oneRotaryNewsEndTime");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsEndTimeIn(List<Date> values) {
            addCriterion("one_rotary_news_end_time in", values, "oneRotaryNewsEndTime");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsEndTimeNotIn(List<Date> values) {
            addCriterion("one_rotary_news_end_time not in", values, "oneRotaryNewsEndTime");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsEndTimeBetween(Date value1, Date value2) {
            addCriterion("one_rotary_news_end_time between", value1, value2, "oneRotaryNewsEndTime");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("one_rotary_news_end_time not between", value1, value2, "oneRotaryNewsEndTime");
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

        public Criteria andOneRotaryNewsStateIsNull() {
            addCriterion("one_rotary_news_state is null");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsStateIsNotNull() {
            addCriterion("one_rotary_news_state is not null");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsStateEqualTo(Integer value) {
            addCriterion("one_rotary_news_state =", value, "oneRotaryNewsState");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsStateNotEqualTo(Integer value) {
            addCriterion("one_rotary_news_state <>", value, "oneRotaryNewsState");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsStateGreaterThan(Integer value) {
            addCriterion("one_rotary_news_state >", value, "oneRotaryNewsState");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("one_rotary_news_state >=", value, "oneRotaryNewsState");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsStateLessThan(Integer value) {
            addCriterion("one_rotary_news_state <", value, "oneRotaryNewsState");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsStateLessThanOrEqualTo(Integer value) {
            addCriterion("one_rotary_news_state <=", value, "oneRotaryNewsState");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsStateIn(List<Integer> values) {
            addCriterion("one_rotary_news_state in", values, "oneRotaryNewsState");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsStateNotIn(List<Integer> values) {
            addCriterion("one_rotary_news_state not in", values, "oneRotaryNewsState");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsStateBetween(Integer value1, Integer value2) {
            addCriterion("one_rotary_news_state between", value1, value2, "oneRotaryNewsState");
            return (Criteria) this;
        }

        public Criteria andOneRotaryNewsStateNotBetween(Integer value1, Integer value2) {
            addCriterion("one_rotary_news_state not between", value1, value2, "oneRotaryNewsState");
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
     * k2_one_rotary_news
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * k2_one_rotary_news 2019-08-06
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