package com.king2.commons.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class K2StoreCategoryExample {
    /**
     * k2_store_category
     */
    protected String orderByClause;

    /**
     * k2_store_category
     */
    protected boolean distinct;

    /**
     * k2_store_category
     */
    protected List<Criteria> oredCriteria;

    public K2StoreCategoryExample() {
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
     * k2_store_category 2019-08-06
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

        public Criteria andStoreCategoryIdIsNull() {
            addCriterion("store_category_id is null");
            return (Criteria) this;
        }

        public Criteria andStoreCategoryIdIsNotNull() {
            addCriterion("store_category_id is not null");
            return (Criteria) this;
        }

        public Criteria andStoreCategoryIdEqualTo(Integer value) {
            addCriterion("store_category_id =", value, "storeCategoryId");
            return (Criteria) this;
        }

        public Criteria andStoreCategoryIdNotEqualTo(Integer value) {
            addCriterion("store_category_id <>", value, "storeCategoryId");
            return (Criteria) this;
        }

        public Criteria andStoreCategoryIdGreaterThan(Integer value) {
            addCriterion("store_category_id >", value, "storeCategoryId");
            return (Criteria) this;
        }

        public Criteria andStoreCategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_category_id >=", value, "storeCategoryId");
            return (Criteria) this;
        }

        public Criteria andStoreCategoryIdLessThan(Integer value) {
            addCriterion("store_category_id <", value, "storeCategoryId");
            return (Criteria) this;
        }

        public Criteria andStoreCategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("store_category_id <=", value, "storeCategoryId");
            return (Criteria) this;
        }

        public Criteria andStoreCategoryIdIn(List<Integer> values) {
            addCriterion("store_category_id in", values, "storeCategoryId");
            return (Criteria) this;
        }

        public Criteria andStoreCategoryIdNotIn(List<Integer> values) {
            addCriterion("store_category_id not in", values, "storeCategoryId");
            return (Criteria) this;
        }

        public Criteria andStoreCategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("store_category_id between", value1, value2, "storeCategoryId");
            return (Criteria) this;
        }

        public Criteria andStoreCategoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("store_category_id not between", value1, value2, "storeCategoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryNameIsNull() {
            addCriterion("category_name is null");
            return (Criteria) this;
        }

        public Criteria andCategoryNameIsNotNull() {
            addCriterion("category_name is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryNameEqualTo(String value) {
            addCriterion("category_name =", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotEqualTo(String value) {
            addCriterion("category_name <>", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameGreaterThan(String value) {
            addCriterion("category_name >", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameGreaterThanOrEqualTo(String value) {
            addCriterion("category_name >=", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameLessThan(String value) {
            addCriterion("category_name <", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameLessThanOrEqualTo(String value) {
            addCriterion("category_name <=", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameLike(String value) {
            addCriterion("category_name like", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotLike(String value) {
            addCriterion("category_name not like", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameIn(List<String> values) {
            addCriterion("category_name in", values, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotIn(List<String> values) {
            addCriterion("category_name not in", values, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameBetween(String value1, String value2) {
            addCriterion("category_name between", value1, value2, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotBetween(String value1, String value2) {
            addCriterion("category_name not between", value1, value2, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryImageIsNull() {
            addCriterion("category_image is null");
            return (Criteria) this;
        }

        public Criteria andCategoryImageIsNotNull() {
            addCriterion("category_image is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryImageEqualTo(String value) {
            addCriterion("category_image =", value, "categoryImage");
            return (Criteria) this;
        }

        public Criteria andCategoryImageNotEqualTo(String value) {
            addCriterion("category_image <>", value, "categoryImage");
            return (Criteria) this;
        }

        public Criteria andCategoryImageGreaterThan(String value) {
            addCriterion("category_image >", value, "categoryImage");
            return (Criteria) this;
        }

        public Criteria andCategoryImageGreaterThanOrEqualTo(String value) {
            addCriterion("category_image >=", value, "categoryImage");
            return (Criteria) this;
        }

        public Criteria andCategoryImageLessThan(String value) {
            addCriterion("category_image <", value, "categoryImage");
            return (Criteria) this;
        }

        public Criteria andCategoryImageLessThanOrEqualTo(String value) {
            addCriterion("category_image <=", value, "categoryImage");
            return (Criteria) this;
        }

        public Criteria andCategoryImageLike(String value) {
            addCriterion("category_image like", value, "categoryImage");
            return (Criteria) this;
        }

        public Criteria andCategoryImageNotLike(String value) {
            addCriterion("category_image not like", value, "categoryImage");
            return (Criteria) this;
        }

        public Criteria andCategoryImageIn(List<String> values) {
            addCriterion("category_image in", values, "categoryImage");
            return (Criteria) this;
        }

        public Criteria andCategoryImageNotIn(List<String> values) {
            addCriterion("category_image not in", values, "categoryImage");
            return (Criteria) this;
        }

        public Criteria andCategoryImageBetween(String value1, String value2) {
            addCriterion("category_image between", value1, value2, "categoryImage");
            return (Criteria) this;
        }

        public Criteria andCategoryImageNotBetween(String value1, String value2) {
            addCriterion("category_image not between", value1, value2, "categoryImage");
            return (Criteria) this;
        }

        public Criteria andCategoryReachTotalSizeIsNull() {
            addCriterion("category_reach_total_size is null");
            return (Criteria) this;
        }

        public Criteria andCategoryReachTotalSizeIsNotNull() {
            addCriterion("category_reach_total_size is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryReachTotalSizeEqualTo(Integer value) {
            addCriterion("category_reach_total_size =", value, "categoryReachTotalSize");
            return (Criteria) this;
        }

        public Criteria andCategoryReachTotalSizeNotEqualTo(Integer value) {
            addCriterion("category_reach_total_size <>", value, "categoryReachTotalSize");
            return (Criteria) this;
        }

        public Criteria andCategoryReachTotalSizeGreaterThan(Integer value) {
            addCriterion("category_reach_total_size >", value, "categoryReachTotalSize");
            return (Criteria) this;
        }

        public Criteria andCategoryReachTotalSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("category_reach_total_size >=", value, "categoryReachTotalSize");
            return (Criteria) this;
        }

        public Criteria andCategoryReachTotalSizeLessThan(Integer value) {
            addCriterion("category_reach_total_size <", value, "categoryReachTotalSize");
            return (Criteria) this;
        }

        public Criteria andCategoryReachTotalSizeLessThanOrEqualTo(Integer value) {
            addCriterion("category_reach_total_size <=", value, "categoryReachTotalSize");
            return (Criteria) this;
        }

        public Criteria andCategoryReachTotalSizeIn(List<Integer> values) {
            addCriterion("category_reach_total_size in", values, "categoryReachTotalSize");
            return (Criteria) this;
        }

        public Criteria andCategoryReachTotalSizeNotIn(List<Integer> values) {
            addCriterion("category_reach_total_size not in", values, "categoryReachTotalSize");
            return (Criteria) this;
        }

        public Criteria andCategoryReachTotalSizeBetween(Integer value1, Integer value2) {
            addCriterion("category_reach_total_size between", value1, value2, "categoryReachTotalSize");
            return (Criteria) this;
        }

        public Criteria andCategoryReachTotalSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("category_reach_total_size not between", value1, value2, "categoryReachTotalSize");
            return (Criteria) this;
        }

        public Criteria andCategoryReachMonthSizeIsNull() {
            addCriterion("category_reach_month_size is null");
            return (Criteria) this;
        }

        public Criteria andCategoryReachMonthSizeIsNotNull() {
            addCriterion("category_reach_month_size is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryReachMonthSizeEqualTo(Integer value) {
            addCriterion("category_reach_month_size =", value, "categoryReachMonthSize");
            return (Criteria) this;
        }

        public Criteria andCategoryReachMonthSizeNotEqualTo(Integer value) {
            addCriterion("category_reach_month_size <>", value, "categoryReachMonthSize");
            return (Criteria) this;
        }

        public Criteria andCategoryReachMonthSizeGreaterThan(Integer value) {
            addCriterion("category_reach_month_size >", value, "categoryReachMonthSize");
            return (Criteria) this;
        }

        public Criteria andCategoryReachMonthSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("category_reach_month_size >=", value, "categoryReachMonthSize");
            return (Criteria) this;
        }

        public Criteria andCategoryReachMonthSizeLessThan(Integer value) {
            addCriterion("category_reach_month_size <", value, "categoryReachMonthSize");
            return (Criteria) this;
        }

        public Criteria andCategoryReachMonthSizeLessThanOrEqualTo(Integer value) {
            addCriterion("category_reach_month_size <=", value, "categoryReachMonthSize");
            return (Criteria) this;
        }

        public Criteria andCategoryReachMonthSizeIn(List<Integer> values) {
            addCriterion("category_reach_month_size in", values, "categoryReachMonthSize");
            return (Criteria) this;
        }

        public Criteria andCategoryReachMonthSizeNotIn(List<Integer> values) {
            addCriterion("category_reach_month_size not in", values, "categoryReachMonthSize");
            return (Criteria) this;
        }

        public Criteria andCategoryReachMonthSizeBetween(Integer value1, Integer value2) {
            addCriterion("category_reach_month_size between", value1, value2, "categoryReachMonthSize");
            return (Criteria) this;
        }

        public Criteria andCategoryReachMonthSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("category_reach_month_size not between", value1, value2, "categoryReachMonthSize");
            return (Criteria) this;
        }

        public Criteria andCategoryReachGoodIsNull() {
            addCriterion("category_reach_good is null");
            return (Criteria) this;
        }

        public Criteria andCategoryReachGoodIsNotNull() {
            addCriterion("category_reach_good is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryReachGoodEqualTo(BigDecimal value) {
            addCriterion("category_reach_good =", value, "categoryReachGood");
            return (Criteria) this;
        }

        public Criteria andCategoryReachGoodNotEqualTo(BigDecimal value) {
            addCriterion("category_reach_good <>", value, "categoryReachGood");
            return (Criteria) this;
        }

        public Criteria andCategoryReachGoodGreaterThan(BigDecimal value) {
            addCriterion("category_reach_good >", value, "categoryReachGood");
            return (Criteria) this;
        }

        public Criteria andCategoryReachGoodGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("category_reach_good >=", value, "categoryReachGood");
            return (Criteria) this;
        }

        public Criteria andCategoryReachGoodLessThan(BigDecimal value) {
            addCriterion("category_reach_good <", value, "categoryReachGood");
            return (Criteria) this;
        }

        public Criteria andCategoryReachGoodLessThanOrEqualTo(BigDecimal value) {
            addCriterion("category_reach_good <=", value, "categoryReachGood");
            return (Criteria) this;
        }

        public Criteria andCategoryReachGoodIn(List<BigDecimal> values) {
            addCriterion("category_reach_good in", values, "categoryReachGood");
            return (Criteria) this;
        }

        public Criteria andCategoryReachGoodNotIn(List<BigDecimal> values) {
            addCriterion("category_reach_good not in", values, "categoryReachGood");
            return (Criteria) this;
        }

        public Criteria andCategoryReachGoodBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("category_reach_good between", value1, value2, "categoryReachGood");
            return (Criteria) this;
        }

        public Criteria andCategoryReachGoodNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("category_reach_good not between", value1, value2, "categoryReachGood");
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

        public Criteria andCreateUserNameIsNull() {
            addCriterion("create_user_name is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameIsNotNull() {
            addCriterion("create_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameEqualTo(String value) {
            addCriterion("create_user_name =", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotEqualTo(String value) {
            addCriterion("create_user_name <>", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameGreaterThan(String value) {
            addCriterion("create_user_name >", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("create_user_name >=", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameLessThan(String value) {
            addCriterion("create_user_name <", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameLessThanOrEqualTo(String value) {
            addCriterion("create_user_name <=", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameLike(String value) {
            addCriterion("create_user_name like", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotLike(String value) {
            addCriterion("create_user_name not like", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameIn(List<String> values) {
            addCriterion("create_user_name in", values, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotIn(List<String> values) {
            addCriterion("create_user_name not in", values, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameBetween(String value1, String value2) {
            addCriterion("create_user_name between", value1, value2, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotBetween(String value1, String value2) {
            addCriterion("create_user_name not between", value1, value2, "createUserName");
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

        public Criteria andCategoryStateIsNull() {
            addCriterion("category_state is null");
            return (Criteria) this;
        }

        public Criteria andCategoryStateIsNotNull() {
            addCriterion("category_state is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryStateEqualTo(Integer value) {
            addCriterion("category_state =", value, "categoryState");
            return (Criteria) this;
        }

        public Criteria andCategoryStateNotEqualTo(Integer value) {
            addCriterion("category_state <>", value, "categoryState");
            return (Criteria) this;
        }

        public Criteria andCategoryStateGreaterThan(Integer value) {
            addCriterion("category_state >", value, "categoryState");
            return (Criteria) this;
        }

        public Criteria andCategoryStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("category_state >=", value, "categoryState");
            return (Criteria) this;
        }

        public Criteria andCategoryStateLessThan(Integer value) {
            addCriterion("category_state <", value, "categoryState");
            return (Criteria) this;
        }

        public Criteria andCategoryStateLessThanOrEqualTo(Integer value) {
            addCriterion("category_state <=", value, "categoryState");
            return (Criteria) this;
        }

        public Criteria andCategoryStateIn(List<Integer> values) {
            addCriterion("category_state in", values, "categoryState");
            return (Criteria) this;
        }

        public Criteria andCategoryStateNotIn(List<Integer> values) {
            addCriterion("category_state not in", values, "categoryState");
            return (Criteria) this;
        }

        public Criteria andCategoryStateBetween(Integer value1, Integer value2) {
            addCriterion("category_state between", value1, value2, "categoryState");
            return (Criteria) this;
        }

        public Criteria andCategoryStateNotBetween(Integer value1, Integer value2) {
            addCriterion("category_state not between", value1, value2, "categoryState");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIsNull() {
            addCriterion("update_user_id is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIsNotNull() {
            addCriterion("update_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdEqualTo(Integer value) {
            addCriterion("update_user_id =", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotEqualTo(Integer value) {
            addCriterion("update_user_id <>", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdGreaterThan(Integer value) {
            addCriterion("update_user_id >", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("update_user_id >=", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdLessThan(Integer value) {
            addCriterion("update_user_id <", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("update_user_id <=", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIn(List<Integer> values) {
            addCriterion("update_user_id in", values, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotIn(List<Integer> values) {
            addCriterion("update_user_id not in", values, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdBetween(Integer value1, Integer value2) {
            addCriterion("update_user_id between", value1, value2, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("update_user_id not between", value1, value2, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameIsNull() {
            addCriterion("update_user_name is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameIsNotNull() {
            addCriterion("update_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameEqualTo(String value) {
            addCriterion("update_user_name =", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameNotEqualTo(String value) {
            addCriterion("update_user_name <>", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameGreaterThan(String value) {
            addCriterion("update_user_name >", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("update_user_name >=", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameLessThan(String value) {
            addCriterion("update_user_name <", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameLessThanOrEqualTo(String value) {
            addCriterion("update_user_name <=", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameLike(String value) {
            addCriterion("update_user_name like", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameNotLike(String value) {
            addCriterion("update_user_name not like", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameIn(List<String> values) {
            addCriterion("update_user_name in", values, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameNotIn(List<String> values) {
            addCriterion("update_user_name not in", values, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameBetween(String value1, String value2) {
            addCriterion("update_user_name between", value1, value2, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameNotBetween(String value1, String value2) {
            addCriterion("update_user_name not between", value1, value2, "updateUserName");
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
     * k2_store_category
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * k2_store_category 2019-08-06
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