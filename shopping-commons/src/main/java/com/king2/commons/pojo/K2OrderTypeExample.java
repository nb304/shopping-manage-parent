package com.king2.commons.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class K2OrderTypeExample {
    /**
     * k2_order_type
     */
    protected String orderByClause;

    /**
     * k2_order_type
     */
    protected boolean distinct;

    /**
     * k2_order_type
     */
    protected List<Criteria> oredCriteria;

    public K2OrderTypeExample() {
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
     * k2_order_type 2019-08-06
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

        public Criteria andOyIdIsNull() {
            addCriterion("oy_id is null");
            return (Criteria) this;
        }

        public Criteria andOyIdIsNotNull() {
            addCriterion("oy_id is not null");
            return (Criteria) this;
        }

        public Criteria andOyIdEqualTo(Integer value) {
            addCriterion("oy_id =", value, "oyId");
            return (Criteria) this;
        }

        public Criteria andOyIdNotEqualTo(Integer value) {
            addCriterion("oy_id <>", value, "oyId");
            return (Criteria) this;
        }

        public Criteria andOyIdGreaterThan(Integer value) {
            addCriterion("oy_id >", value, "oyId");
            return (Criteria) this;
        }

        public Criteria andOyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("oy_id >=", value, "oyId");
            return (Criteria) this;
        }

        public Criteria andOyIdLessThan(Integer value) {
            addCriterion("oy_id <", value, "oyId");
            return (Criteria) this;
        }

        public Criteria andOyIdLessThanOrEqualTo(Integer value) {
            addCriterion("oy_id <=", value, "oyId");
            return (Criteria) this;
        }

        public Criteria andOyIdIn(List<Integer> values) {
            addCriterion("oy_id in", values, "oyId");
            return (Criteria) this;
        }

        public Criteria andOyIdNotIn(List<Integer> values) {
            addCriterion("oy_id not in", values, "oyId");
            return (Criteria) this;
        }

        public Criteria andOyIdBetween(Integer value1, Integer value2) {
            addCriterion("oy_id between", value1, value2, "oyId");
            return (Criteria) this;
        }

        public Criteria andOyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("oy_id not between", value1, value2, "oyId");
            return (Criteria) this;
        }

        public Criteria andOyNumberIsNull() {
            addCriterion("oy_number is null");
            return (Criteria) this;
        }

        public Criteria andOyNumberIsNotNull() {
            addCriterion("oy_number is not null");
            return (Criteria) this;
        }

        public Criteria andOyNumberEqualTo(String value) {
            addCriterion("oy_number =", value, "oyNumber");
            return (Criteria) this;
        }

        public Criteria andOyNumberNotEqualTo(String value) {
            addCriterion("oy_number <>", value, "oyNumber");
            return (Criteria) this;
        }

        public Criteria andOyNumberGreaterThan(String value) {
            addCriterion("oy_number >", value, "oyNumber");
            return (Criteria) this;
        }

        public Criteria andOyNumberGreaterThanOrEqualTo(String value) {
            addCriterion("oy_number >=", value, "oyNumber");
            return (Criteria) this;
        }

        public Criteria andOyNumberLessThan(String value) {
            addCriterion("oy_number <", value, "oyNumber");
            return (Criteria) this;
        }

        public Criteria andOyNumberLessThanOrEqualTo(String value) {
            addCriterion("oy_number <=", value, "oyNumber");
            return (Criteria) this;
        }

        public Criteria andOyNumberLike(String value) {
            addCriterion("oy_number like", value, "oyNumber");
            return (Criteria) this;
        }

        public Criteria andOyNumberNotLike(String value) {
            addCriterion("oy_number not like", value, "oyNumber");
            return (Criteria) this;
        }

        public Criteria andOyNumberIn(List<String> values) {
            addCriterion("oy_number in", values, "oyNumber");
            return (Criteria) this;
        }

        public Criteria andOyNumberNotIn(List<String> values) {
            addCriterion("oy_number not in", values, "oyNumber");
            return (Criteria) this;
        }

        public Criteria andOyNumberBetween(String value1, String value2) {
            addCriterion("oy_number between", value1, value2, "oyNumber");
            return (Criteria) this;
        }

        public Criteria andOyNumberNotBetween(String value1, String value2) {
            addCriterion("oy_number not between", value1, value2, "oyNumber");
            return (Criteria) this;
        }

        public Criteria andOyNameIsNull() {
            addCriterion("oy_name is null");
            return (Criteria) this;
        }

        public Criteria andOyNameIsNotNull() {
            addCriterion("oy_name is not null");
            return (Criteria) this;
        }

        public Criteria andOyNameEqualTo(String value) {
            addCriterion("oy_name =", value, "oyName");
            return (Criteria) this;
        }

        public Criteria andOyNameNotEqualTo(String value) {
            addCriterion("oy_name <>", value, "oyName");
            return (Criteria) this;
        }

        public Criteria andOyNameGreaterThan(String value) {
            addCriterion("oy_name >", value, "oyName");
            return (Criteria) this;
        }

        public Criteria andOyNameGreaterThanOrEqualTo(String value) {
            addCriterion("oy_name >=", value, "oyName");
            return (Criteria) this;
        }

        public Criteria andOyNameLessThan(String value) {
            addCriterion("oy_name <", value, "oyName");
            return (Criteria) this;
        }

        public Criteria andOyNameLessThanOrEqualTo(String value) {
            addCriterion("oy_name <=", value, "oyName");
            return (Criteria) this;
        }

        public Criteria andOyNameLike(String value) {
            addCriterion("oy_name like", value, "oyName");
            return (Criteria) this;
        }

        public Criteria andOyNameNotLike(String value) {
            addCriterion("oy_name not like", value, "oyName");
            return (Criteria) this;
        }

        public Criteria andOyNameIn(List<String> values) {
            addCriterion("oy_name in", values, "oyName");
            return (Criteria) this;
        }

        public Criteria andOyNameNotIn(List<String> values) {
            addCriterion("oy_name not in", values, "oyName");
            return (Criteria) this;
        }

        public Criteria andOyNameBetween(String value1, String value2) {
            addCriterion("oy_name between", value1, value2, "oyName");
            return (Criteria) this;
        }

        public Criteria andOyNameNotBetween(String value1, String value2) {
            addCriterion("oy_name not between", value1, value2, "oyName");
            return (Criteria) this;
        }

        public Criteria andOyMemberIsNull() {
            addCriterion("oy_member is null");
            return (Criteria) this;
        }

        public Criteria andOyMemberIsNotNull() {
            addCriterion("oy_member is not null");
            return (Criteria) this;
        }

        public Criteria andOyMemberEqualTo(String value) {
            addCriterion("oy_member =", value, "oyMember");
            return (Criteria) this;
        }

        public Criteria andOyMemberNotEqualTo(String value) {
            addCriterion("oy_member <>", value, "oyMember");
            return (Criteria) this;
        }

        public Criteria andOyMemberGreaterThan(String value) {
            addCriterion("oy_member >", value, "oyMember");
            return (Criteria) this;
        }

        public Criteria andOyMemberGreaterThanOrEqualTo(String value) {
            addCriterion("oy_member >=", value, "oyMember");
            return (Criteria) this;
        }

        public Criteria andOyMemberLessThan(String value) {
            addCriterion("oy_member <", value, "oyMember");
            return (Criteria) this;
        }

        public Criteria andOyMemberLessThanOrEqualTo(String value) {
            addCriterion("oy_member <=", value, "oyMember");
            return (Criteria) this;
        }

        public Criteria andOyMemberLike(String value) {
            addCriterion("oy_member like", value, "oyMember");
            return (Criteria) this;
        }

        public Criteria andOyMemberNotLike(String value) {
            addCriterion("oy_member not like", value, "oyMember");
            return (Criteria) this;
        }

        public Criteria andOyMemberIn(List<String> values) {
            addCriterion("oy_member in", values, "oyMember");
            return (Criteria) this;
        }

        public Criteria andOyMemberNotIn(List<String> values) {
            addCriterion("oy_member not in", values, "oyMember");
            return (Criteria) this;
        }

        public Criteria andOyMemberBetween(String value1, String value2) {
            addCriterion("oy_member between", value1, value2, "oyMember");
            return (Criteria) this;
        }

        public Criteria andOyMemberNotBetween(String value1, String value2) {
            addCriterion("oy_member not between", value1, value2, "oyMember");
            return (Criteria) this;
        }

        public Criteria andOyCreateTimeIsNull() {
            addCriterion("oy_create_time is null");
            return (Criteria) this;
        }

        public Criteria andOyCreateTimeIsNotNull() {
            addCriterion("oy_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andOyCreateTimeEqualTo(Date value) {
            addCriterion("oy_create_time =", value, "oyCreateTime");
            return (Criteria) this;
        }

        public Criteria andOyCreateTimeNotEqualTo(Date value) {
            addCriterion("oy_create_time <>", value, "oyCreateTime");
            return (Criteria) this;
        }

        public Criteria andOyCreateTimeGreaterThan(Date value) {
            addCriterion("oy_create_time >", value, "oyCreateTime");
            return (Criteria) this;
        }

        public Criteria andOyCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("oy_create_time >=", value, "oyCreateTime");
            return (Criteria) this;
        }

        public Criteria andOyCreateTimeLessThan(Date value) {
            addCriterion("oy_create_time <", value, "oyCreateTime");
            return (Criteria) this;
        }

        public Criteria andOyCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("oy_create_time <=", value, "oyCreateTime");
            return (Criteria) this;
        }

        public Criteria andOyCreateTimeIn(List<Date> values) {
            addCriterion("oy_create_time in", values, "oyCreateTime");
            return (Criteria) this;
        }

        public Criteria andOyCreateTimeNotIn(List<Date> values) {
            addCriterion("oy_create_time not in", values, "oyCreateTime");
            return (Criteria) this;
        }

        public Criteria andOyCreateTimeBetween(Date value1, Date value2) {
            addCriterion("oy_create_time between", value1, value2, "oyCreateTime");
            return (Criteria) this;
        }

        public Criteria andOyCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("oy_create_time not between", value1, value2, "oyCreateTime");
            return (Criteria) this;
        }

        public Criteria andOyDelFlagIsNull() {
            addCriterion("oy_del_flag is null");
            return (Criteria) this;
        }

        public Criteria andOyDelFlagIsNotNull() {
            addCriterion("oy_del_flag is not null");
            return (Criteria) this;
        }

        public Criteria andOyDelFlagEqualTo(Integer value) {
            addCriterion("oy_del_flag =", value, "oyDelFlag");
            return (Criteria) this;
        }

        public Criteria andOyDelFlagNotEqualTo(Integer value) {
            addCriterion("oy_del_flag <>", value, "oyDelFlag");
            return (Criteria) this;
        }

        public Criteria andOyDelFlagGreaterThan(Integer value) {
            addCriterion("oy_del_flag >", value, "oyDelFlag");
            return (Criteria) this;
        }

        public Criteria andOyDelFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("oy_del_flag >=", value, "oyDelFlag");
            return (Criteria) this;
        }

        public Criteria andOyDelFlagLessThan(Integer value) {
            addCriterion("oy_del_flag <", value, "oyDelFlag");
            return (Criteria) this;
        }

        public Criteria andOyDelFlagLessThanOrEqualTo(Integer value) {
            addCriterion("oy_del_flag <=", value, "oyDelFlag");
            return (Criteria) this;
        }

        public Criteria andOyDelFlagIn(List<Integer> values) {
            addCriterion("oy_del_flag in", values, "oyDelFlag");
            return (Criteria) this;
        }

        public Criteria andOyDelFlagNotIn(List<Integer> values) {
            addCriterion("oy_del_flag not in", values, "oyDelFlag");
            return (Criteria) this;
        }

        public Criteria andOyDelFlagBetween(Integer value1, Integer value2) {
            addCriterion("oy_del_flag between", value1, value2, "oyDelFlag");
            return (Criteria) this;
        }

        public Criteria andOyDelFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("oy_del_flag not between", value1, value2, "oyDelFlag");
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
     * k2_order_type
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * k2_order_type 2019-08-06
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