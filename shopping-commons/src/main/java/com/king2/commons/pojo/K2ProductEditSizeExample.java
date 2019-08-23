package com.king2.commons.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class K2ProductEditSizeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public K2ProductEditSizeExample() {
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

        public Criteria andEditSizeIsNull() {
            addCriterion("edit_size is null");
            return (Criteria) this;
        }

        public Criteria andEditSizeIsNotNull() {
            addCriterion("edit_size is not null");
            return (Criteria) this;
        }

        public Criteria andEditSizeEqualTo(Integer value) {
            addCriterion("edit_size =", value, "editSize");
            return (Criteria) this;
        }

        public Criteria andEditSizeNotEqualTo(Integer value) {
            addCriterion("edit_size <>", value, "editSize");
            return (Criteria) this;
        }

        public Criteria andEditSizeGreaterThan(Integer value) {
            addCriterion("edit_size >", value, "editSize");
            return (Criteria) this;
        }

        public Criteria andEditSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("edit_size >=", value, "editSize");
            return (Criteria) this;
        }

        public Criteria andEditSizeLessThan(Integer value) {
            addCriterion("edit_size <", value, "editSize");
            return (Criteria) this;
        }

        public Criteria andEditSizeLessThanOrEqualTo(Integer value) {
            addCriterion("edit_size <=", value, "editSize");
            return (Criteria) this;
        }

        public Criteria andEditSizeIn(List<Integer> values) {
            addCriterion("edit_size in", values, "editSize");
            return (Criteria) this;
        }

        public Criteria andEditSizeNotIn(List<Integer> values) {
            addCriterion("edit_size not in", values, "editSize");
            return (Criteria) this;
        }

        public Criteria andEditSizeBetween(Integer value1, Integer value2) {
            addCriterion("edit_size between", value1, value2, "editSize");
            return (Criteria) this;
        }

        public Criteria andEditSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("edit_size not between", value1, value2, "editSize");
            return (Criteria) this;
        }

        public Criteria andEditProductIdIsNull() {
            addCriterion("edit_product_id is null");
            return (Criteria) this;
        }

        public Criteria andEditProductIdIsNotNull() {
            addCriterion("edit_product_id is not null");
            return (Criteria) this;
        }

        public Criteria andEditProductIdEqualTo(Integer value) {
            addCriterion("edit_product_id =", value, "editProductId");
            return (Criteria) this;
        }

        public Criteria andEditProductIdNotEqualTo(Integer value) {
            addCriterion("edit_product_id <>", value, "editProductId");
            return (Criteria) this;
        }

        public Criteria andEditProductIdGreaterThan(Integer value) {
            addCriterion("edit_product_id >", value, "editProductId");
            return (Criteria) this;
        }

        public Criteria andEditProductIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("edit_product_id >=", value, "editProductId");
            return (Criteria) this;
        }

        public Criteria andEditProductIdLessThan(Integer value) {
            addCriterion("edit_product_id <", value, "editProductId");
            return (Criteria) this;
        }

        public Criteria andEditProductIdLessThanOrEqualTo(Integer value) {
            addCriterion("edit_product_id <=", value, "editProductId");
            return (Criteria) this;
        }

        public Criteria andEditProductIdIn(List<Integer> values) {
            addCriterion("edit_product_id in", values, "editProductId");
            return (Criteria) this;
        }

        public Criteria andEditProductIdNotIn(List<Integer> values) {
            addCriterion("edit_product_id not in", values, "editProductId");
            return (Criteria) this;
        }

        public Criteria andEditProductIdBetween(Integer value1, Integer value2) {
            addCriterion("edit_product_id between", value1, value2, "editProductId");
            return (Criteria) this;
        }

        public Criteria andEditProductIdNotBetween(Integer value1, Integer value2) {
            addCriterion("edit_product_id not between", value1, value2, "editProductId");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIsNull() {
            addCriterion("last_update_time is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIsNotNull() {
            addCriterion("last_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeEqualTo(Date value) {
            addCriterion("last_update_time =", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotEqualTo(Date value) {
            addCriterion("last_update_time <>", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeGreaterThan(Date value) {
            addCriterion("last_update_time >", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_update_time >=", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLessThan(Date value) {
            addCriterion("last_update_time <", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_update_time <=", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIn(List<Date> values) {
            addCriterion("last_update_time in", values, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotIn(List<Date> values) {
            addCriterion("last_update_time not in", values, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("last_update_time between", value1, value2, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_update_time not between", value1, value2, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andNextUpdateTimeIsNull() {
            addCriterion("next_update_time is null");
            return (Criteria) this;
        }

        public Criteria andNextUpdateTimeIsNotNull() {
            addCriterion("next_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andNextUpdateTimeEqualTo(Date value) {
            addCriterion("next_update_time =", value, "nextUpdateTime");
            return (Criteria) this;
        }

        public Criteria andNextUpdateTimeNotEqualTo(Date value) {
            addCriterion("next_update_time <>", value, "nextUpdateTime");
            return (Criteria) this;
        }

        public Criteria andNextUpdateTimeGreaterThan(Date value) {
            addCriterion("next_update_time >", value, "nextUpdateTime");
            return (Criteria) this;
        }

        public Criteria andNextUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("next_update_time >=", value, "nextUpdateTime");
            return (Criteria) this;
        }

        public Criteria andNextUpdateTimeLessThan(Date value) {
            addCriterion("next_update_time <", value, "nextUpdateTime");
            return (Criteria) this;
        }

        public Criteria andNextUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("next_update_time <=", value, "nextUpdateTime");
            return (Criteria) this;
        }

        public Criteria andNextUpdateTimeIn(List<Date> values) {
            addCriterion("next_update_time in", values, "nextUpdateTime");
            return (Criteria) this;
        }

        public Criteria andNextUpdateTimeNotIn(List<Date> values) {
            addCriterion("next_update_time not in", values, "nextUpdateTime");
            return (Criteria) this;
        }

        public Criteria andNextUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("next_update_time between", value1, value2, "nextUpdateTime");
            return (Criteria) this;
        }

        public Criteria andNextUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("next_update_time not between", value1, value2, "nextUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserIdIsNull() {
            addCriterion("last_update_user_id is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserIdIsNotNull() {
            addCriterion("last_update_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserIdEqualTo(Integer value) {
            addCriterion("last_update_user_id =", value, "lastUpdateUserId");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserIdNotEqualTo(Integer value) {
            addCriterion("last_update_user_id <>", value, "lastUpdateUserId");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserIdGreaterThan(Integer value) {
            addCriterion("last_update_user_id >", value, "lastUpdateUserId");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("last_update_user_id >=", value, "lastUpdateUserId");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserIdLessThan(Integer value) {
            addCriterion("last_update_user_id <", value, "lastUpdateUserId");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("last_update_user_id <=", value, "lastUpdateUserId");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserIdIn(List<Integer> values) {
            addCriterion("last_update_user_id in", values, "lastUpdateUserId");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserIdNotIn(List<Integer> values) {
            addCriterion("last_update_user_id not in", values, "lastUpdateUserId");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserIdBetween(Integer value1, Integer value2) {
            addCriterion("last_update_user_id between", value1, value2, "lastUpdateUserId");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("last_update_user_id not between", value1, value2, "lastUpdateUserId");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserNaemIsNull() {
            addCriterion("last_update_user_naem is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserNaemIsNotNull() {
            addCriterion("last_update_user_naem is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserNaemEqualTo(String value) {
            addCriterion("last_update_user_naem =", value, "lastUpdateUserNaem");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserNaemNotEqualTo(String value) {
            addCriterion("last_update_user_naem <>", value, "lastUpdateUserNaem");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserNaemGreaterThan(String value) {
            addCriterion("last_update_user_naem >", value, "lastUpdateUserNaem");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserNaemGreaterThanOrEqualTo(String value) {
            addCriterion("last_update_user_naem >=", value, "lastUpdateUserNaem");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserNaemLessThan(String value) {
            addCriterion("last_update_user_naem <", value, "lastUpdateUserNaem");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserNaemLessThanOrEqualTo(String value) {
            addCriterion("last_update_user_naem <=", value, "lastUpdateUserNaem");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserNaemLike(String value) {
            addCriterion("last_update_user_naem like", value, "lastUpdateUserNaem");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserNaemNotLike(String value) {
            addCriterion("last_update_user_naem not like", value, "lastUpdateUserNaem");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserNaemIn(List<String> values) {
            addCriterion("last_update_user_naem in", values, "lastUpdateUserNaem");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserNaemNotIn(List<String> values) {
            addCriterion("last_update_user_naem not in", values, "lastUpdateUserNaem");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserNaemBetween(String value1, String value2) {
            addCriterion("last_update_user_naem between", value1, value2, "lastUpdateUserNaem");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserNaemNotBetween(String value1, String value2) {
            addCriterion("last_update_user_naem not between", value1, value2, "lastUpdateUserNaem");
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