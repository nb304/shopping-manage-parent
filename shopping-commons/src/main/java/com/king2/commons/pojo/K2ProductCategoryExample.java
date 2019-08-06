package com.king2.commons.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class K2ProductCategoryExample {
    /**
     * k2_product_category
     */
    protected String orderByClause;

    /**
     * k2_product_category
     */
    protected boolean distinct;

    /**
     * k2_product_category
     */
    protected List<Criteria> oredCriteria;

    public K2ProductCategoryExample() {
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
     * k2_product_category 2019-08-06
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

        public Criteria andCategoryIdIsNull() {
            addCriterion("category_id is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNotNull() {
            addCriterion("category_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdEqualTo(Integer value) {
            addCriterion("category_id =", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotEqualTo(Integer value) {
            addCriterion("category_id <>", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThan(Integer value) {
            addCriterion("category_id >", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("category_id >=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThan(Integer value) {
            addCriterion("category_id <", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("category_id <=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIn(List<Integer> values) {
            addCriterion("category_id in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotIn(List<Integer> values) {
            addCriterion("category_id not in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("category_id between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("category_id not between", value1, value2, "categoryId");
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

        public Criteria andCategorySeasonIdIsNull() {
            addCriterion("category_season_id is null");
            return (Criteria) this;
        }

        public Criteria andCategorySeasonIdIsNotNull() {
            addCriterion("category_season_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategorySeasonIdEqualTo(String value) {
            addCriterion("category_season_id =", value, "categorySeasonId");
            return (Criteria) this;
        }

        public Criteria andCategorySeasonIdNotEqualTo(String value) {
            addCriterion("category_season_id <>", value, "categorySeasonId");
            return (Criteria) this;
        }

        public Criteria andCategorySeasonIdGreaterThan(String value) {
            addCriterion("category_season_id >", value, "categorySeasonId");
            return (Criteria) this;
        }

        public Criteria andCategorySeasonIdGreaterThanOrEqualTo(String value) {
            addCriterion("category_season_id >=", value, "categorySeasonId");
            return (Criteria) this;
        }

        public Criteria andCategorySeasonIdLessThan(String value) {
            addCriterion("category_season_id <", value, "categorySeasonId");
            return (Criteria) this;
        }

        public Criteria andCategorySeasonIdLessThanOrEqualTo(String value) {
            addCriterion("category_season_id <=", value, "categorySeasonId");
            return (Criteria) this;
        }

        public Criteria andCategorySeasonIdLike(String value) {
            addCriterion("category_season_id like", value, "categorySeasonId");
            return (Criteria) this;
        }

        public Criteria andCategorySeasonIdNotLike(String value) {
            addCriterion("category_season_id not like", value, "categorySeasonId");
            return (Criteria) this;
        }

        public Criteria andCategorySeasonIdIn(List<String> values) {
            addCriterion("category_season_id in", values, "categorySeasonId");
            return (Criteria) this;
        }

        public Criteria andCategorySeasonIdNotIn(List<String> values) {
            addCriterion("category_season_id not in", values, "categorySeasonId");
            return (Criteria) this;
        }

        public Criteria andCategorySeasonIdBetween(String value1, String value2) {
            addCriterion("category_season_id between", value1, value2, "categorySeasonId");
            return (Criteria) this;
        }

        public Criteria andCategorySeasonIdNotBetween(String value1, String value2) {
            addCriterion("category_season_id not between", value1, value2, "categorySeasonId");
            return (Criteria) this;
        }

        public Criteria andCategoryIsParentIsNull() {
            addCriterion("category_is_parent is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIsParentIsNotNull() {
            addCriterion("category_is_parent is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIsParentEqualTo(Integer value) {
            addCriterion("category_is_parent =", value, "categoryIsParent");
            return (Criteria) this;
        }

        public Criteria andCategoryIsParentNotEqualTo(Integer value) {
            addCriterion("category_is_parent <>", value, "categoryIsParent");
            return (Criteria) this;
        }

        public Criteria andCategoryIsParentGreaterThan(Integer value) {
            addCriterion("category_is_parent >", value, "categoryIsParent");
            return (Criteria) this;
        }

        public Criteria andCategoryIsParentGreaterThanOrEqualTo(Integer value) {
            addCriterion("category_is_parent >=", value, "categoryIsParent");
            return (Criteria) this;
        }

        public Criteria andCategoryIsParentLessThan(Integer value) {
            addCriterion("category_is_parent <", value, "categoryIsParent");
            return (Criteria) this;
        }

        public Criteria andCategoryIsParentLessThanOrEqualTo(Integer value) {
            addCriterion("category_is_parent <=", value, "categoryIsParent");
            return (Criteria) this;
        }

        public Criteria andCategoryIsParentIn(List<Integer> values) {
            addCriterion("category_is_parent in", values, "categoryIsParent");
            return (Criteria) this;
        }

        public Criteria andCategoryIsParentNotIn(List<Integer> values) {
            addCriterion("category_is_parent not in", values, "categoryIsParent");
            return (Criteria) this;
        }

        public Criteria andCategoryIsParentBetween(Integer value1, Integer value2) {
            addCriterion("category_is_parent between", value1, value2, "categoryIsParent");
            return (Criteria) this;
        }

        public Criteria andCategoryIsParentNotBetween(Integer value1, Integer value2) {
            addCriterion("category_is_parent not between", value1, value2, "categoryIsParent");
            return (Criteria) this;
        }

        public Criteria andCategoryParentIdIsNull() {
            addCriterion("category_parent_id is null");
            return (Criteria) this;
        }

        public Criteria andCategoryParentIdIsNotNull() {
            addCriterion("category_parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryParentIdEqualTo(Integer value) {
            addCriterion("category_parent_id =", value, "categoryParentId");
            return (Criteria) this;
        }

        public Criteria andCategoryParentIdNotEqualTo(Integer value) {
            addCriterion("category_parent_id <>", value, "categoryParentId");
            return (Criteria) this;
        }

        public Criteria andCategoryParentIdGreaterThan(Integer value) {
            addCriterion("category_parent_id >", value, "categoryParentId");
            return (Criteria) this;
        }

        public Criteria andCategoryParentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("category_parent_id >=", value, "categoryParentId");
            return (Criteria) this;
        }

        public Criteria andCategoryParentIdLessThan(Integer value) {
            addCriterion("category_parent_id <", value, "categoryParentId");
            return (Criteria) this;
        }

        public Criteria andCategoryParentIdLessThanOrEqualTo(Integer value) {
            addCriterion("category_parent_id <=", value, "categoryParentId");
            return (Criteria) this;
        }

        public Criteria andCategoryParentIdIn(List<Integer> values) {
            addCriterion("category_parent_id in", values, "categoryParentId");
            return (Criteria) this;
        }

        public Criteria andCategoryParentIdNotIn(List<Integer> values) {
            addCriterion("category_parent_id not in", values, "categoryParentId");
            return (Criteria) this;
        }

        public Criteria andCategoryParentIdBetween(Integer value1, Integer value2) {
            addCriterion("category_parent_id between", value1, value2, "categoryParentId");
            return (Criteria) this;
        }

        public Criteria andCategoryParentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("category_parent_id not between", value1, value2, "categoryParentId");
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

        public Criteria andCategoryUseridIsNull() {
            addCriterion("category_userid is null");
            return (Criteria) this;
        }

        public Criteria andCategoryUseridIsNotNull() {
            addCriterion("category_userid is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryUseridEqualTo(Integer value) {
            addCriterion("category_userid =", value, "categoryUserid");
            return (Criteria) this;
        }

        public Criteria andCategoryUseridNotEqualTo(Integer value) {
            addCriterion("category_userid <>", value, "categoryUserid");
            return (Criteria) this;
        }

        public Criteria andCategoryUseridGreaterThan(Integer value) {
            addCriterion("category_userid >", value, "categoryUserid");
            return (Criteria) this;
        }

        public Criteria andCategoryUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("category_userid >=", value, "categoryUserid");
            return (Criteria) this;
        }

        public Criteria andCategoryUseridLessThan(Integer value) {
            addCriterion("category_userid <", value, "categoryUserid");
            return (Criteria) this;
        }

        public Criteria andCategoryUseridLessThanOrEqualTo(Integer value) {
            addCriterion("category_userid <=", value, "categoryUserid");
            return (Criteria) this;
        }

        public Criteria andCategoryUseridIn(List<Integer> values) {
            addCriterion("category_userid in", values, "categoryUserid");
            return (Criteria) this;
        }

        public Criteria andCategoryUseridNotIn(List<Integer> values) {
            addCriterion("category_userid not in", values, "categoryUserid");
            return (Criteria) this;
        }

        public Criteria andCategoryUseridBetween(Integer value1, Integer value2) {
            addCriterion("category_userid between", value1, value2, "categoryUserid");
            return (Criteria) this;
        }

        public Criteria andCategoryUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("category_userid not between", value1, value2, "categoryUserid");
            return (Criteria) this;
        }

        public Criteria andCategoryCreateTimeIsNull() {
            addCriterion("category_create_time is null");
            return (Criteria) this;
        }

        public Criteria andCategoryCreateTimeIsNotNull() {
            addCriterion("category_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryCreateTimeEqualTo(Date value) {
            addCriterion("category_create_time =", value, "categoryCreateTime");
            return (Criteria) this;
        }

        public Criteria andCategoryCreateTimeNotEqualTo(Date value) {
            addCriterion("category_create_time <>", value, "categoryCreateTime");
            return (Criteria) this;
        }

        public Criteria andCategoryCreateTimeGreaterThan(Date value) {
            addCriterion("category_create_time >", value, "categoryCreateTime");
            return (Criteria) this;
        }

        public Criteria andCategoryCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("category_create_time >=", value, "categoryCreateTime");
            return (Criteria) this;
        }

        public Criteria andCategoryCreateTimeLessThan(Date value) {
            addCriterion("category_create_time <", value, "categoryCreateTime");
            return (Criteria) this;
        }

        public Criteria andCategoryCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("category_create_time <=", value, "categoryCreateTime");
            return (Criteria) this;
        }

        public Criteria andCategoryCreateTimeIn(List<Date> values) {
            addCriterion("category_create_time in", values, "categoryCreateTime");
            return (Criteria) this;
        }

        public Criteria andCategoryCreateTimeNotIn(List<Date> values) {
            addCriterion("category_create_time not in", values, "categoryCreateTime");
            return (Criteria) this;
        }

        public Criteria andCategoryCreateTimeBetween(Date value1, Date value2) {
            addCriterion("category_create_time between", value1, value2, "categoryCreateTime");
            return (Criteria) this;
        }

        public Criteria andCategoryCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("category_create_time not between", value1, value2, "categoryCreateTime");
            return (Criteria) this;
        }

        public Criteria andCategoryUpdateUseridIsNull() {
            addCriterion("category_update_userid is null");
            return (Criteria) this;
        }

        public Criteria andCategoryUpdateUseridIsNotNull() {
            addCriterion("category_update_userid is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryUpdateUseridEqualTo(Integer value) {
            addCriterion("category_update_userid =", value, "categoryUpdateUserid");
            return (Criteria) this;
        }

        public Criteria andCategoryUpdateUseridNotEqualTo(Integer value) {
            addCriterion("category_update_userid <>", value, "categoryUpdateUserid");
            return (Criteria) this;
        }

        public Criteria andCategoryUpdateUseridGreaterThan(Integer value) {
            addCriterion("category_update_userid >", value, "categoryUpdateUserid");
            return (Criteria) this;
        }

        public Criteria andCategoryUpdateUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("category_update_userid >=", value, "categoryUpdateUserid");
            return (Criteria) this;
        }

        public Criteria andCategoryUpdateUseridLessThan(Integer value) {
            addCriterion("category_update_userid <", value, "categoryUpdateUserid");
            return (Criteria) this;
        }

        public Criteria andCategoryUpdateUseridLessThanOrEqualTo(Integer value) {
            addCriterion("category_update_userid <=", value, "categoryUpdateUserid");
            return (Criteria) this;
        }

        public Criteria andCategoryUpdateUseridIn(List<Integer> values) {
            addCriterion("category_update_userid in", values, "categoryUpdateUserid");
            return (Criteria) this;
        }

        public Criteria andCategoryUpdateUseridNotIn(List<Integer> values) {
            addCriterion("category_update_userid not in", values, "categoryUpdateUserid");
            return (Criteria) this;
        }

        public Criteria andCategoryUpdateUseridBetween(Integer value1, Integer value2) {
            addCriterion("category_update_userid between", value1, value2, "categoryUpdateUserid");
            return (Criteria) this;
        }

        public Criteria andCategoryUpdateUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("category_update_userid not between", value1, value2, "categoryUpdateUserid");
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
     * k2_product_category
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * k2_product_category 2019-08-06
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