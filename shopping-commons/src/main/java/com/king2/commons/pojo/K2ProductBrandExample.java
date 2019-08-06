package com.king2.commons.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class K2ProductBrandExample {
    /**
     * k2_product_brand
     */
    protected String orderByClause;

    /**
     * k2_product_brand
     */
    protected boolean distinct;

    /**
     * k2_product_brand
     */
    protected List<Criteria> oredCriteria;

    public K2ProductBrandExample() {
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
     * k2_product_brand 2019-08-06
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

        public Criteria andBrandIdIsNull() {
            addCriterion("brand_id is null");
            return (Criteria) this;
        }

        public Criteria andBrandIdIsNotNull() {
            addCriterion("brand_id is not null");
            return (Criteria) this;
        }

        public Criteria andBrandIdEqualTo(Integer value) {
            addCriterion("brand_id =", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotEqualTo(Integer value) {
            addCriterion("brand_id <>", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdGreaterThan(Integer value) {
            addCriterion("brand_id >", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("brand_id >=", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdLessThan(Integer value) {
            addCriterion("brand_id <", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdLessThanOrEqualTo(Integer value) {
            addCriterion("brand_id <=", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdIn(List<Integer> values) {
            addCriterion("brand_id in", values, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotIn(List<Integer> values) {
            addCriterion("brand_id not in", values, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdBetween(Integer value1, Integer value2) {
            addCriterion("brand_id between", value1, value2, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotBetween(Integer value1, Integer value2) {
            addCriterion("brand_id not between", value1, value2, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandNumberIsNull() {
            addCriterion("brand_number is null");
            return (Criteria) this;
        }

        public Criteria andBrandNumberIsNotNull() {
            addCriterion("brand_number is not null");
            return (Criteria) this;
        }

        public Criteria andBrandNumberEqualTo(String value) {
            addCriterion("brand_number =", value, "brandNumber");
            return (Criteria) this;
        }

        public Criteria andBrandNumberNotEqualTo(String value) {
            addCriterion("brand_number <>", value, "brandNumber");
            return (Criteria) this;
        }

        public Criteria andBrandNumberGreaterThan(String value) {
            addCriterion("brand_number >", value, "brandNumber");
            return (Criteria) this;
        }

        public Criteria andBrandNumberGreaterThanOrEqualTo(String value) {
            addCriterion("brand_number >=", value, "brandNumber");
            return (Criteria) this;
        }

        public Criteria andBrandNumberLessThan(String value) {
            addCriterion("brand_number <", value, "brandNumber");
            return (Criteria) this;
        }

        public Criteria andBrandNumberLessThanOrEqualTo(String value) {
            addCriterion("brand_number <=", value, "brandNumber");
            return (Criteria) this;
        }

        public Criteria andBrandNumberLike(String value) {
            addCriterion("brand_number like", value, "brandNumber");
            return (Criteria) this;
        }

        public Criteria andBrandNumberNotLike(String value) {
            addCriterion("brand_number not like", value, "brandNumber");
            return (Criteria) this;
        }

        public Criteria andBrandNumberIn(List<String> values) {
            addCriterion("brand_number in", values, "brandNumber");
            return (Criteria) this;
        }

        public Criteria andBrandNumberNotIn(List<String> values) {
            addCriterion("brand_number not in", values, "brandNumber");
            return (Criteria) this;
        }

        public Criteria andBrandNumberBetween(String value1, String value2) {
            addCriterion("brand_number between", value1, value2, "brandNumber");
            return (Criteria) this;
        }

        public Criteria andBrandNumberNotBetween(String value1, String value2) {
            addCriterion("brand_number not between", value1, value2, "brandNumber");
            return (Criteria) this;
        }

        public Criteria andBrandNameIsNull() {
            addCriterion("brand_name is null");
            return (Criteria) this;
        }

        public Criteria andBrandNameIsNotNull() {
            addCriterion("brand_name is not null");
            return (Criteria) this;
        }

        public Criteria andBrandNameEqualTo(String value) {
            addCriterion("brand_name =", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotEqualTo(String value) {
            addCriterion("brand_name <>", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameGreaterThan(String value) {
            addCriterion("brand_name >", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameGreaterThanOrEqualTo(String value) {
            addCriterion("brand_name >=", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLessThan(String value) {
            addCriterion("brand_name <", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLessThanOrEqualTo(String value) {
            addCriterion("brand_name <=", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLike(String value) {
            addCriterion("brand_name like", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotLike(String value) {
            addCriterion("brand_name not like", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameIn(List<String> values) {
            addCriterion("brand_name in", values, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotIn(List<String> values) {
            addCriterion("brand_name not in", values, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameBetween(String value1, String value2) {
            addCriterion("brand_name between", value1, value2, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotBetween(String value1, String value2) {
            addCriterion("brand_name not between", value1, value2, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandImageIsNull() {
            addCriterion("brand_image is null");
            return (Criteria) this;
        }

        public Criteria andBrandImageIsNotNull() {
            addCriterion("brand_image is not null");
            return (Criteria) this;
        }

        public Criteria andBrandImageEqualTo(String value) {
            addCriterion("brand_image =", value, "brandImage");
            return (Criteria) this;
        }

        public Criteria andBrandImageNotEqualTo(String value) {
            addCriterion("brand_image <>", value, "brandImage");
            return (Criteria) this;
        }

        public Criteria andBrandImageGreaterThan(String value) {
            addCriterion("brand_image >", value, "brandImage");
            return (Criteria) this;
        }

        public Criteria andBrandImageGreaterThanOrEqualTo(String value) {
            addCriterion("brand_image >=", value, "brandImage");
            return (Criteria) this;
        }

        public Criteria andBrandImageLessThan(String value) {
            addCriterion("brand_image <", value, "brandImage");
            return (Criteria) this;
        }

        public Criteria andBrandImageLessThanOrEqualTo(String value) {
            addCriterion("brand_image <=", value, "brandImage");
            return (Criteria) this;
        }

        public Criteria andBrandImageLike(String value) {
            addCriterion("brand_image like", value, "brandImage");
            return (Criteria) this;
        }

        public Criteria andBrandImageNotLike(String value) {
            addCriterion("brand_image not like", value, "brandImage");
            return (Criteria) this;
        }

        public Criteria andBrandImageIn(List<String> values) {
            addCriterion("brand_image in", values, "brandImage");
            return (Criteria) this;
        }

        public Criteria andBrandImageNotIn(List<String> values) {
            addCriterion("brand_image not in", values, "brandImage");
            return (Criteria) this;
        }

        public Criteria andBrandImageBetween(String value1, String value2) {
            addCriterion("brand_image between", value1, value2, "brandImage");
            return (Criteria) this;
        }

        public Criteria andBrandImageNotBetween(String value1, String value2) {
            addCriterion("brand_image not between", value1, value2, "brandImage");
            return (Criteria) this;
        }

        public Criteria andBrandCreateUseridIsNull() {
            addCriterion("brand_create_userid is null");
            return (Criteria) this;
        }

        public Criteria andBrandCreateUseridIsNotNull() {
            addCriterion("brand_create_userid is not null");
            return (Criteria) this;
        }

        public Criteria andBrandCreateUseridEqualTo(Integer value) {
            addCriterion("brand_create_userid =", value, "brandCreateUserid");
            return (Criteria) this;
        }

        public Criteria andBrandCreateUseridNotEqualTo(Integer value) {
            addCriterion("brand_create_userid <>", value, "brandCreateUserid");
            return (Criteria) this;
        }

        public Criteria andBrandCreateUseridGreaterThan(Integer value) {
            addCriterion("brand_create_userid >", value, "brandCreateUserid");
            return (Criteria) this;
        }

        public Criteria andBrandCreateUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("brand_create_userid >=", value, "brandCreateUserid");
            return (Criteria) this;
        }

        public Criteria andBrandCreateUseridLessThan(Integer value) {
            addCriterion("brand_create_userid <", value, "brandCreateUserid");
            return (Criteria) this;
        }

        public Criteria andBrandCreateUseridLessThanOrEqualTo(Integer value) {
            addCriterion("brand_create_userid <=", value, "brandCreateUserid");
            return (Criteria) this;
        }

        public Criteria andBrandCreateUseridIn(List<Integer> values) {
            addCriterion("brand_create_userid in", values, "brandCreateUserid");
            return (Criteria) this;
        }

        public Criteria andBrandCreateUseridNotIn(List<Integer> values) {
            addCriterion("brand_create_userid not in", values, "brandCreateUserid");
            return (Criteria) this;
        }

        public Criteria andBrandCreateUseridBetween(Integer value1, Integer value2) {
            addCriterion("brand_create_userid between", value1, value2, "brandCreateUserid");
            return (Criteria) this;
        }

        public Criteria andBrandCreateUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("brand_create_userid not between", value1, value2, "brandCreateUserid");
            return (Criteria) this;
        }

        public Criteria andBrandCreateUsernameIsNull() {
            addCriterion("brand_create_username is null");
            return (Criteria) this;
        }

        public Criteria andBrandCreateUsernameIsNotNull() {
            addCriterion("brand_create_username is not null");
            return (Criteria) this;
        }

        public Criteria andBrandCreateUsernameEqualTo(String value) {
            addCriterion("brand_create_username =", value, "brandCreateUsername");
            return (Criteria) this;
        }

        public Criteria andBrandCreateUsernameNotEqualTo(String value) {
            addCriterion("brand_create_username <>", value, "brandCreateUsername");
            return (Criteria) this;
        }

        public Criteria andBrandCreateUsernameGreaterThan(String value) {
            addCriterion("brand_create_username >", value, "brandCreateUsername");
            return (Criteria) this;
        }

        public Criteria andBrandCreateUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("brand_create_username >=", value, "brandCreateUsername");
            return (Criteria) this;
        }

        public Criteria andBrandCreateUsernameLessThan(String value) {
            addCriterion("brand_create_username <", value, "brandCreateUsername");
            return (Criteria) this;
        }

        public Criteria andBrandCreateUsernameLessThanOrEqualTo(String value) {
            addCriterion("brand_create_username <=", value, "brandCreateUsername");
            return (Criteria) this;
        }

        public Criteria andBrandCreateUsernameLike(String value) {
            addCriterion("brand_create_username like", value, "brandCreateUsername");
            return (Criteria) this;
        }

        public Criteria andBrandCreateUsernameNotLike(String value) {
            addCriterion("brand_create_username not like", value, "brandCreateUsername");
            return (Criteria) this;
        }

        public Criteria andBrandCreateUsernameIn(List<String> values) {
            addCriterion("brand_create_username in", values, "brandCreateUsername");
            return (Criteria) this;
        }

        public Criteria andBrandCreateUsernameNotIn(List<String> values) {
            addCriterion("brand_create_username not in", values, "brandCreateUsername");
            return (Criteria) this;
        }

        public Criteria andBrandCreateUsernameBetween(String value1, String value2) {
            addCriterion("brand_create_username between", value1, value2, "brandCreateUsername");
            return (Criteria) this;
        }

        public Criteria andBrandCreateUsernameNotBetween(String value1, String value2) {
            addCriterion("brand_create_username not between", value1, value2, "brandCreateUsername");
            return (Criteria) this;
        }

        public Criteria andBrandCreateTimeIsNull() {
            addCriterion("brand_create_time is null");
            return (Criteria) this;
        }

        public Criteria andBrandCreateTimeIsNotNull() {
            addCriterion("brand_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andBrandCreateTimeEqualTo(Date value) {
            addCriterion("brand_create_time =", value, "brandCreateTime");
            return (Criteria) this;
        }

        public Criteria andBrandCreateTimeNotEqualTo(Date value) {
            addCriterion("brand_create_time <>", value, "brandCreateTime");
            return (Criteria) this;
        }

        public Criteria andBrandCreateTimeGreaterThan(Date value) {
            addCriterion("brand_create_time >", value, "brandCreateTime");
            return (Criteria) this;
        }

        public Criteria andBrandCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("brand_create_time >=", value, "brandCreateTime");
            return (Criteria) this;
        }

        public Criteria andBrandCreateTimeLessThan(Date value) {
            addCriterion("brand_create_time <", value, "brandCreateTime");
            return (Criteria) this;
        }

        public Criteria andBrandCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("brand_create_time <=", value, "brandCreateTime");
            return (Criteria) this;
        }

        public Criteria andBrandCreateTimeIn(List<Date> values) {
            addCriterion("brand_create_time in", values, "brandCreateTime");
            return (Criteria) this;
        }

        public Criteria andBrandCreateTimeNotIn(List<Date> values) {
            addCriterion("brand_create_time not in", values, "brandCreateTime");
            return (Criteria) this;
        }

        public Criteria andBrandCreateTimeBetween(Date value1, Date value2) {
            addCriterion("brand_create_time between", value1, value2, "brandCreateTime");
            return (Criteria) this;
        }

        public Criteria andBrandCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("brand_create_time not between", value1, value2, "brandCreateTime");
            return (Criteria) this;
        }

        public Criteria andBrandUpdateUseridIsNull() {
            addCriterion("brand_update_userid is null");
            return (Criteria) this;
        }

        public Criteria andBrandUpdateUseridIsNotNull() {
            addCriterion("brand_update_userid is not null");
            return (Criteria) this;
        }

        public Criteria andBrandUpdateUseridEqualTo(Integer value) {
            addCriterion("brand_update_userid =", value, "brandUpdateUserid");
            return (Criteria) this;
        }

        public Criteria andBrandUpdateUseridNotEqualTo(Integer value) {
            addCriterion("brand_update_userid <>", value, "brandUpdateUserid");
            return (Criteria) this;
        }

        public Criteria andBrandUpdateUseridGreaterThan(Integer value) {
            addCriterion("brand_update_userid >", value, "brandUpdateUserid");
            return (Criteria) this;
        }

        public Criteria andBrandUpdateUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("brand_update_userid >=", value, "brandUpdateUserid");
            return (Criteria) this;
        }

        public Criteria andBrandUpdateUseridLessThan(Integer value) {
            addCriterion("brand_update_userid <", value, "brandUpdateUserid");
            return (Criteria) this;
        }

        public Criteria andBrandUpdateUseridLessThanOrEqualTo(Integer value) {
            addCriterion("brand_update_userid <=", value, "brandUpdateUserid");
            return (Criteria) this;
        }

        public Criteria andBrandUpdateUseridIn(List<Integer> values) {
            addCriterion("brand_update_userid in", values, "brandUpdateUserid");
            return (Criteria) this;
        }

        public Criteria andBrandUpdateUseridNotIn(List<Integer> values) {
            addCriterion("brand_update_userid not in", values, "brandUpdateUserid");
            return (Criteria) this;
        }

        public Criteria andBrandUpdateUseridBetween(Integer value1, Integer value2) {
            addCriterion("brand_update_userid between", value1, value2, "brandUpdateUserid");
            return (Criteria) this;
        }

        public Criteria andBrandUpdateUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("brand_update_userid not between", value1, value2, "brandUpdateUserid");
            return (Criteria) this;
        }

        public Criteria andBrandUpdateUsernameIsNull() {
            addCriterion("brand_update_username is null");
            return (Criteria) this;
        }

        public Criteria andBrandUpdateUsernameIsNotNull() {
            addCriterion("brand_update_username is not null");
            return (Criteria) this;
        }

        public Criteria andBrandUpdateUsernameEqualTo(String value) {
            addCriterion("brand_update_username =", value, "brandUpdateUsername");
            return (Criteria) this;
        }

        public Criteria andBrandUpdateUsernameNotEqualTo(String value) {
            addCriterion("brand_update_username <>", value, "brandUpdateUsername");
            return (Criteria) this;
        }

        public Criteria andBrandUpdateUsernameGreaterThan(String value) {
            addCriterion("brand_update_username >", value, "brandUpdateUsername");
            return (Criteria) this;
        }

        public Criteria andBrandUpdateUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("brand_update_username >=", value, "brandUpdateUsername");
            return (Criteria) this;
        }

        public Criteria andBrandUpdateUsernameLessThan(String value) {
            addCriterion("brand_update_username <", value, "brandUpdateUsername");
            return (Criteria) this;
        }

        public Criteria andBrandUpdateUsernameLessThanOrEqualTo(String value) {
            addCriterion("brand_update_username <=", value, "brandUpdateUsername");
            return (Criteria) this;
        }

        public Criteria andBrandUpdateUsernameLike(String value) {
            addCriterion("brand_update_username like", value, "brandUpdateUsername");
            return (Criteria) this;
        }

        public Criteria andBrandUpdateUsernameNotLike(String value) {
            addCriterion("brand_update_username not like", value, "brandUpdateUsername");
            return (Criteria) this;
        }

        public Criteria andBrandUpdateUsernameIn(List<String> values) {
            addCriterion("brand_update_username in", values, "brandUpdateUsername");
            return (Criteria) this;
        }

        public Criteria andBrandUpdateUsernameNotIn(List<String> values) {
            addCriterion("brand_update_username not in", values, "brandUpdateUsername");
            return (Criteria) this;
        }

        public Criteria andBrandUpdateUsernameBetween(String value1, String value2) {
            addCriterion("brand_update_username between", value1, value2, "brandUpdateUsername");
            return (Criteria) this;
        }

        public Criteria andBrandUpdateUsernameNotBetween(String value1, String value2) {
            addCriterion("brand_update_username not between", value1, value2, "brandUpdateUsername");
            return (Criteria) this;
        }

        public Criteria andBrandUpdateTimeIsNull() {
            addCriterion("brand_update_time is null");
            return (Criteria) this;
        }

        public Criteria andBrandUpdateTimeIsNotNull() {
            addCriterion("brand_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andBrandUpdateTimeEqualTo(Date value) {
            addCriterion("brand_update_time =", value, "brandUpdateTime");
            return (Criteria) this;
        }

        public Criteria andBrandUpdateTimeNotEqualTo(Date value) {
            addCriterion("brand_update_time <>", value, "brandUpdateTime");
            return (Criteria) this;
        }

        public Criteria andBrandUpdateTimeGreaterThan(Date value) {
            addCriterion("brand_update_time >", value, "brandUpdateTime");
            return (Criteria) this;
        }

        public Criteria andBrandUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("brand_update_time >=", value, "brandUpdateTime");
            return (Criteria) this;
        }

        public Criteria andBrandUpdateTimeLessThan(Date value) {
            addCriterion("brand_update_time <", value, "brandUpdateTime");
            return (Criteria) this;
        }

        public Criteria andBrandUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("brand_update_time <=", value, "brandUpdateTime");
            return (Criteria) this;
        }

        public Criteria andBrandUpdateTimeIn(List<Date> values) {
            addCriterion("brand_update_time in", values, "brandUpdateTime");
            return (Criteria) this;
        }

        public Criteria andBrandUpdateTimeNotIn(List<Date> values) {
            addCriterion("brand_update_time not in", values, "brandUpdateTime");
            return (Criteria) this;
        }

        public Criteria andBrandUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("brand_update_time between", value1, value2, "brandUpdateTime");
            return (Criteria) this;
        }

        public Criteria andBrandUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("brand_update_time not between", value1, value2, "brandUpdateTime");
            return (Criteria) this;
        }

        public Criteria andBrandStoreIdIsNull() {
            addCriterion("brand_store_id is null");
            return (Criteria) this;
        }

        public Criteria andBrandStoreIdIsNotNull() {
            addCriterion("brand_store_id is not null");
            return (Criteria) this;
        }

        public Criteria andBrandStoreIdEqualTo(Integer value) {
            addCriterion("brand_store_id =", value, "brandStoreId");
            return (Criteria) this;
        }

        public Criteria andBrandStoreIdNotEqualTo(Integer value) {
            addCriterion("brand_store_id <>", value, "brandStoreId");
            return (Criteria) this;
        }

        public Criteria andBrandStoreIdGreaterThan(Integer value) {
            addCriterion("brand_store_id >", value, "brandStoreId");
            return (Criteria) this;
        }

        public Criteria andBrandStoreIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("brand_store_id >=", value, "brandStoreId");
            return (Criteria) this;
        }

        public Criteria andBrandStoreIdLessThan(Integer value) {
            addCriterion("brand_store_id <", value, "brandStoreId");
            return (Criteria) this;
        }

        public Criteria andBrandStoreIdLessThanOrEqualTo(Integer value) {
            addCriterion("brand_store_id <=", value, "brandStoreId");
            return (Criteria) this;
        }

        public Criteria andBrandStoreIdIn(List<Integer> values) {
            addCriterion("brand_store_id in", values, "brandStoreId");
            return (Criteria) this;
        }

        public Criteria andBrandStoreIdNotIn(List<Integer> values) {
            addCriterion("brand_store_id not in", values, "brandStoreId");
            return (Criteria) this;
        }

        public Criteria andBrandStoreIdBetween(Integer value1, Integer value2) {
            addCriterion("brand_store_id between", value1, value2, "brandStoreId");
            return (Criteria) this;
        }

        public Criteria andBrandStoreIdNotBetween(Integer value1, Integer value2) {
            addCriterion("brand_store_id not between", value1, value2, "brandStoreId");
            return (Criteria) this;
        }

        public Criteria andBrandStateIsNull() {
            addCriterion("brand_state is null");
            return (Criteria) this;
        }

        public Criteria andBrandStateIsNotNull() {
            addCriterion("brand_state is not null");
            return (Criteria) this;
        }

        public Criteria andBrandStateEqualTo(Integer value) {
            addCriterion("brand_state =", value, "brandState");
            return (Criteria) this;
        }

        public Criteria andBrandStateNotEqualTo(Integer value) {
            addCriterion("brand_state <>", value, "brandState");
            return (Criteria) this;
        }

        public Criteria andBrandStateGreaterThan(Integer value) {
            addCriterion("brand_state >", value, "brandState");
            return (Criteria) this;
        }

        public Criteria andBrandStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("brand_state >=", value, "brandState");
            return (Criteria) this;
        }

        public Criteria andBrandStateLessThan(Integer value) {
            addCriterion("brand_state <", value, "brandState");
            return (Criteria) this;
        }

        public Criteria andBrandStateLessThanOrEqualTo(Integer value) {
            addCriterion("brand_state <=", value, "brandState");
            return (Criteria) this;
        }

        public Criteria andBrandStateIn(List<Integer> values) {
            addCriterion("brand_state in", values, "brandState");
            return (Criteria) this;
        }

        public Criteria andBrandStateNotIn(List<Integer> values) {
            addCriterion("brand_state not in", values, "brandState");
            return (Criteria) this;
        }

        public Criteria andBrandStateBetween(Integer value1, Integer value2) {
            addCriterion("brand_state between", value1, value2, "brandState");
            return (Criteria) this;
        }

        public Criteria andBrandStateNotBetween(Integer value1, Integer value2) {
            addCriterion("brand_state not between", value1, value2, "brandState");
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
     * k2_product_brand
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * k2_product_brand 2019-08-06
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