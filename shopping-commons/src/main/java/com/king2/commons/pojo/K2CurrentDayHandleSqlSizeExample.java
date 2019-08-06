package com.king2.commons.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class K2CurrentDayHandleSqlSizeExample {
    /**
     * k2_current_day_handle_sql_size
     */
    protected String orderByClause;

    /**
     * k2_current_day_handle_sql_size
     */
    protected boolean distinct;

    /**
     * k2_current_day_handle_sql_size
     */
    protected List<Criteria> oredCriteria;

    public K2CurrentDayHandleSqlSizeExample() {
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
     * k2_current_day_handle_sql_size 2019-08-06
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

        public Criteria andSqlSizeIdIsNull() {
            addCriterion("sql_size_id is null");
            return (Criteria) this;
        }

        public Criteria andSqlSizeIdIsNotNull() {
            addCriterion("sql_size_id is not null");
            return (Criteria) this;
        }

        public Criteria andSqlSizeIdEqualTo(Integer value) {
            addCriterion("sql_size_id =", value, "sqlSizeId");
            return (Criteria) this;
        }

        public Criteria andSqlSizeIdNotEqualTo(Integer value) {
            addCriterion("sql_size_id <>", value, "sqlSizeId");
            return (Criteria) this;
        }

        public Criteria andSqlSizeIdGreaterThan(Integer value) {
            addCriterion("sql_size_id >", value, "sqlSizeId");
            return (Criteria) this;
        }

        public Criteria andSqlSizeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sql_size_id >=", value, "sqlSizeId");
            return (Criteria) this;
        }

        public Criteria andSqlSizeIdLessThan(Integer value) {
            addCriterion("sql_size_id <", value, "sqlSizeId");
            return (Criteria) this;
        }

        public Criteria andSqlSizeIdLessThanOrEqualTo(Integer value) {
            addCriterion("sql_size_id <=", value, "sqlSizeId");
            return (Criteria) this;
        }

        public Criteria andSqlSizeIdIn(List<Integer> values) {
            addCriterion("sql_size_id in", values, "sqlSizeId");
            return (Criteria) this;
        }

        public Criteria andSqlSizeIdNotIn(List<Integer> values) {
            addCriterion("sql_size_id not in", values, "sqlSizeId");
            return (Criteria) this;
        }

        public Criteria andSqlSizeIdBetween(Integer value1, Integer value2) {
            addCriterion("sql_size_id between", value1, value2, "sqlSizeId");
            return (Criteria) this;
        }

        public Criteria andSqlSizeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sql_size_id not between", value1, value2, "sqlSizeId");
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

        public Criteria andAddProductSizeIsNull() {
            addCriterion("add_product_size is null");
            return (Criteria) this;
        }

        public Criteria andAddProductSizeIsNotNull() {
            addCriterion("add_product_size is not null");
            return (Criteria) this;
        }

        public Criteria andAddProductSizeEqualTo(Integer value) {
            addCriterion("add_product_size =", value, "addProductSize");
            return (Criteria) this;
        }

        public Criteria andAddProductSizeNotEqualTo(Integer value) {
            addCriterion("add_product_size <>", value, "addProductSize");
            return (Criteria) this;
        }

        public Criteria andAddProductSizeGreaterThan(Integer value) {
            addCriterion("add_product_size >", value, "addProductSize");
            return (Criteria) this;
        }

        public Criteria andAddProductSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("add_product_size >=", value, "addProductSize");
            return (Criteria) this;
        }

        public Criteria andAddProductSizeLessThan(Integer value) {
            addCriterion("add_product_size <", value, "addProductSize");
            return (Criteria) this;
        }

        public Criteria andAddProductSizeLessThanOrEqualTo(Integer value) {
            addCriterion("add_product_size <=", value, "addProductSize");
            return (Criteria) this;
        }

        public Criteria andAddProductSizeIn(List<Integer> values) {
            addCriterion("add_product_size in", values, "addProductSize");
            return (Criteria) this;
        }

        public Criteria andAddProductSizeNotIn(List<Integer> values) {
            addCriterion("add_product_size not in", values, "addProductSize");
            return (Criteria) this;
        }

        public Criteria andAddProductSizeBetween(Integer value1, Integer value2) {
            addCriterion("add_product_size between", value1, value2, "addProductSize");
            return (Criteria) this;
        }

        public Criteria andAddProductSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("add_product_size not between", value1, value2, "addProductSize");
            return (Criteria) this;
        }

        public Criteria andAddBrandSizeIsNull() {
            addCriterion("add_brand__size is null");
            return (Criteria) this;
        }

        public Criteria andAddBrandSizeIsNotNull() {
            addCriterion("add_brand__size is not null");
            return (Criteria) this;
        }

        public Criteria andAddBrandSizeEqualTo(Integer value) {
            addCriterion("add_brand__size =", value, "addBrandSize");
            return (Criteria) this;
        }

        public Criteria andAddBrandSizeNotEqualTo(Integer value) {
            addCriterion("add_brand__size <>", value, "addBrandSize");
            return (Criteria) this;
        }

        public Criteria andAddBrandSizeGreaterThan(Integer value) {
            addCriterion("add_brand__size >", value, "addBrandSize");
            return (Criteria) this;
        }

        public Criteria andAddBrandSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("add_brand__size >=", value, "addBrandSize");
            return (Criteria) this;
        }

        public Criteria andAddBrandSizeLessThan(Integer value) {
            addCriterion("add_brand__size <", value, "addBrandSize");
            return (Criteria) this;
        }

        public Criteria andAddBrandSizeLessThanOrEqualTo(Integer value) {
            addCriterion("add_brand__size <=", value, "addBrandSize");
            return (Criteria) this;
        }

        public Criteria andAddBrandSizeIn(List<Integer> values) {
            addCriterion("add_brand__size in", values, "addBrandSize");
            return (Criteria) this;
        }

        public Criteria andAddBrandSizeNotIn(List<Integer> values) {
            addCriterion("add_brand__size not in", values, "addBrandSize");
            return (Criteria) this;
        }

        public Criteria andAddBrandSizeBetween(Integer value1, Integer value2) {
            addCriterion("add_brand__size between", value1, value2, "addBrandSize");
            return (Criteria) this;
        }

        public Criteria andAddBrandSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("add_brand__size not between", value1, value2, "addBrandSize");
            return (Criteria) this;
        }

        public Criteria andAddCategorySizeIsNull() {
            addCriterion("add_category_size is null");
            return (Criteria) this;
        }

        public Criteria andAddCategorySizeIsNotNull() {
            addCriterion("add_category_size is not null");
            return (Criteria) this;
        }

        public Criteria andAddCategorySizeEqualTo(Integer value) {
            addCriterion("add_category_size =", value, "addCategorySize");
            return (Criteria) this;
        }

        public Criteria andAddCategorySizeNotEqualTo(Integer value) {
            addCriterion("add_category_size <>", value, "addCategorySize");
            return (Criteria) this;
        }

        public Criteria andAddCategorySizeGreaterThan(Integer value) {
            addCriterion("add_category_size >", value, "addCategorySize");
            return (Criteria) this;
        }

        public Criteria andAddCategorySizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("add_category_size >=", value, "addCategorySize");
            return (Criteria) this;
        }

        public Criteria andAddCategorySizeLessThan(Integer value) {
            addCriterion("add_category_size <", value, "addCategorySize");
            return (Criteria) this;
        }

        public Criteria andAddCategorySizeLessThanOrEqualTo(Integer value) {
            addCriterion("add_category_size <=", value, "addCategorySize");
            return (Criteria) this;
        }

        public Criteria andAddCategorySizeIn(List<Integer> values) {
            addCriterion("add_category_size in", values, "addCategorySize");
            return (Criteria) this;
        }

        public Criteria andAddCategorySizeNotIn(List<Integer> values) {
            addCriterion("add_category_size not in", values, "addCategorySize");
            return (Criteria) this;
        }

        public Criteria andAddCategorySizeBetween(Integer value1, Integer value2) {
            addCriterion("add_category_size between", value1, value2, "addCategorySize");
            return (Criteria) this;
        }

        public Criteria andAddCategorySizeNotBetween(Integer value1, Integer value2) {
            addCriterion("add_category_size not between", value1, value2, "addCategorySize");
            return (Criteria) this;
        }

        public Criteria andAddFeedbackSizeIsNull() {
            addCriterion("add_feedback_size is null");
            return (Criteria) this;
        }

        public Criteria andAddFeedbackSizeIsNotNull() {
            addCriterion("add_feedback_size is not null");
            return (Criteria) this;
        }

        public Criteria andAddFeedbackSizeEqualTo(Integer value) {
            addCriterion("add_feedback_size =", value, "addFeedbackSize");
            return (Criteria) this;
        }

        public Criteria andAddFeedbackSizeNotEqualTo(Integer value) {
            addCriterion("add_feedback_size <>", value, "addFeedbackSize");
            return (Criteria) this;
        }

        public Criteria andAddFeedbackSizeGreaterThan(Integer value) {
            addCriterion("add_feedback_size >", value, "addFeedbackSize");
            return (Criteria) this;
        }

        public Criteria andAddFeedbackSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("add_feedback_size >=", value, "addFeedbackSize");
            return (Criteria) this;
        }

        public Criteria andAddFeedbackSizeLessThan(Integer value) {
            addCriterion("add_feedback_size <", value, "addFeedbackSize");
            return (Criteria) this;
        }

        public Criteria andAddFeedbackSizeLessThanOrEqualTo(Integer value) {
            addCriterion("add_feedback_size <=", value, "addFeedbackSize");
            return (Criteria) this;
        }

        public Criteria andAddFeedbackSizeIn(List<Integer> values) {
            addCriterion("add_feedback_size in", values, "addFeedbackSize");
            return (Criteria) this;
        }

        public Criteria andAddFeedbackSizeNotIn(List<Integer> values) {
            addCriterion("add_feedback_size not in", values, "addFeedbackSize");
            return (Criteria) this;
        }

        public Criteria andAddFeedbackSizeBetween(Integer value1, Integer value2) {
            addCriterion("add_feedback_size between", value1, value2, "addFeedbackSize");
            return (Criteria) this;
        }

        public Criteria andAddFeedbackSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("add_feedback_size not between", value1, value2, "addFeedbackSize");
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
     * k2_current_day_handle_sql_size
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * k2_current_day_handle_sql_size 2019-08-06
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