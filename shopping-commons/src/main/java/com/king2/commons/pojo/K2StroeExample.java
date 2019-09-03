package com.king2.commons.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class K2StroeExample {
    /**
     * k2_stroe
     */
    protected String orderByClause;

    /**
     * k2_stroe
     */
    protected boolean distinct;

    /**
     * k2_stroe
     */
    protected List<Criteria> oredCriteria;

    public K2StroeExample() {
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
     * k2_stroe 2019-09-02
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

        public Criteria andStroeIdIsNull() {
            addCriterion("stroe_id is null");
            return (Criteria) this;
        }

        public Criteria andStroeIdIsNotNull() {
            addCriterion("stroe_id is not null");
            return (Criteria) this;
        }

        public Criteria andStroeIdEqualTo(Integer value) {
            addCriterion("stroe_id =", value, "stroeId");
            return (Criteria) this;
        }

        public Criteria andStroeIdNotEqualTo(Integer value) {
            addCriterion("stroe_id <>", value, "stroeId");
            return (Criteria) this;
        }

        public Criteria andStroeIdGreaterThan(Integer value) {
            addCriterion("stroe_id >", value, "stroeId");
            return (Criteria) this;
        }

        public Criteria andStroeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("stroe_id >=", value, "stroeId");
            return (Criteria) this;
        }

        public Criteria andStroeIdLessThan(Integer value) {
            addCriterion("stroe_id <", value, "stroeId");
            return (Criteria) this;
        }

        public Criteria andStroeIdLessThanOrEqualTo(Integer value) {
            addCriterion("stroe_id <=", value, "stroeId");
            return (Criteria) this;
        }

        public Criteria andStroeIdIn(List<Integer> values) {
            addCriterion("stroe_id in", values, "stroeId");
            return (Criteria) this;
        }

        public Criteria andStroeIdNotIn(List<Integer> values) {
            addCriterion("stroe_id not in", values, "stroeId");
            return (Criteria) this;
        }

        public Criteria andStroeIdBetween(Integer value1, Integer value2) {
            addCriterion("stroe_id between", value1, value2, "stroeId");
            return (Criteria) this;
        }

        public Criteria andStroeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("stroe_id not between", value1, value2, "stroeId");
            return (Criteria) this;
        }

        public Criteria andStroeNameIsNull() {
            addCriterion("stroe_name is null");
            return (Criteria) this;
        }

        public Criteria andStroeNameIsNotNull() {
            addCriterion("stroe_name is not null");
            return (Criteria) this;
        }

        public Criteria andStroeNameEqualTo(String value) {
            addCriterion("stroe_name =", value, "stroeName");
            return (Criteria) this;
        }

        public Criteria andStroeNameNotEqualTo(String value) {
            addCriterion("stroe_name <>", value, "stroeName");
            return (Criteria) this;
        }

        public Criteria andStroeNameGreaterThan(String value) {
            addCriterion("stroe_name >", value, "stroeName");
            return (Criteria) this;
        }

        public Criteria andStroeNameGreaterThanOrEqualTo(String value) {
            addCriterion("stroe_name >=", value, "stroeName");
            return (Criteria) this;
        }

        public Criteria andStroeNameLessThan(String value) {
            addCriterion("stroe_name <", value, "stroeName");
            return (Criteria) this;
        }

        public Criteria andStroeNameLessThanOrEqualTo(String value) {
            addCriterion("stroe_name <=", value, "stroeName");
            return (Criteria) this;
        }

        public Criteria andStroeNameLike(String value) {
            addCriterion("stroe_name like", value, "stroeName");
            return (Criteria) this;
        }

        public Criteria andStroeNameNotLike(String value) {
            addCriterion("stroe_name not like", value, "stroeName");
            return (Criteria) this;
        }

        public Criteria andStroeNameIn(List<String> values) {
            addCriterion("stroe_name in", values, "stroeName");
            return (Criteria) this;
        }

        public Criteria andStroeNameNotIn(List<String> values) {
            addCriterion("stroe_name not in", values, "stroeName");
            return (Criteria) this;
        }

        public Criteria andStroeNameBetween(String value1, String value2) {
            addCriterion("stroe_name between", value1, value2, "stroeName");
            return (Criteria) this;
        }

        public Criteria andStroeNameNotBetween(String value1, String value2) {
            addCriterion("stroe_name not between", value1, value2, "stroeName");
            return (Criteria) this;
        }

        public Criteria andStoreImageIsNull() {
            addCriterion("store_image is null");
            return (Criteria) this;
        }

        public Criteria andStoreImageIsNotNull() {
            addCriterion("store_image is not null");
            return (Criteria) this;
        }

        public Criteria andStoreImageEqualTo(String value) {
            addCriterion("store_image =", value, "storeImage");
            return (Criteria) this;
        }

        public Criteria andStoreImageNotEqualTo(String value) {
            addCriterion("store_image <>", value, "storeImage");
            return (Criteria) this;
        }

        public Criteria andStoreImageGreaterThan(String value) {
            addCriterion("store_image >", value, "storeImage");
            return (Criteria) this;
        }

        public Criteria andStoreImageGreaterThanOrEqualTo(String value) {
            addCriterion("store_image >=", value, "storeImage");
            return (Criteria) this;
        }

        public Criteria andStoreImageLessThan(String value) {
            addCriterion("store_image <", value, "storeImage");
            return (Criteria) this;
        }

        public Criteria andStoreImageLessThanOrEqualTo(String value) {
            addCriterion("store_image <=", value, "storeImage");
            return (Criteria) this;
        }

        public Criteria andStoreImageLike(String value) {
            addCriterion("store_image like", value, "storeImage");
            return (Criteria) this;
        }

        public Criteria andStoreImageNotLike(String value) {
            addCriterion("store_image not like", value, "storeImage");
            return (Criteria) this;
        }

        public Criteria andStoreImageIn(List<String> values) {
            addCriterion("store_image in", values, "storeImage");
            return (Criteria) this;
        }

        public Criteria andStoreImageNotIn(List<String> values) {
            addCriterion("store_image not in", values, "storeImage");
            return (Criteria) this;
        }

        public Criteria andStoreImageBetween(String value1, String value2) {
            addCriterion("store_image between", value1, value2, "storeImage");
            return (Criteria) this;
        }

        public Criteria andStoreImageNotBetween(String value1, String value2) {
            addCriterion("store_image not between", value1, value2, "storeImage");
            return (Criteria) this;
        }

        public Criteria andStoreLogoImageIsNull() {
            addCriterion("store_logo_image is null");
            return (Criteria) this;
        }

        public Criteria andStoreLogoImageIsNotNull() {
            addCriterion("store_logo_image is not null");
            return (Criteria) this;
        }

        public Criteria andStoreLogoImageEqualTo(String value) {
            addCriterion("store_logo_image =", value, "storeLogoImage");
            return (Criteria) this;
        }

        public Criteria andStoreLogoImageNotEqualTo(String value) {
            addCriterion("store_logo_image <>", value, "storeLogoImage");
            return (Criteria) this;
        }

        public Criteria andStoreLogoImageGreaterThan(String value) {
            addCriterion("store_logo_image >", value, "storeLogoImage");
            return (Criteria) this;
        }

        public Criteria andStoreLogoImageGreaterThanOrEqualTo(String value) {
            addCriterion("store_logo_image >=", value, "storeLogoImage");
            return (Criteria) this;
        }

        public Criteria andStoreLogoImageLessThan(String value) {
            addCriterion("store_logo_image <", value, "storeLogoImage");
            return (Criteria) this;
        }

        public Criteria andStoreLogoImageLessThanOrEqualTo(String value) {
            addCriterion("store_logo_image <=", value, "storeLogoImage");
            return (Criteria) this;
        }

        public Criteria andStoreLogoImageLike(String value) {
            addCriterion("store_logo_image like", value, "storeLogoImage");
            return (Criteria) this;
        }

        public Criteria andStoreLogoImageNotLike(String value) {
            addCriterion("store_logo_image not like", value, "storeLogoImage");
            return (Criteria) this;
        }

        public Criteria andStoreLogoImageIn(List<String> values) {
            addCriterion("store_logo_image in", values, "storeLogoImage");
            return (Criteria) this;
        }

        public Criteria andStoreLogoImageNotIn(List<String> values) {
            addCriterion("store_logo_image not in", values, "storeLogoImage");
            return (Criteria) this;
        }

        public Criteria andStoreLogoImageBetween(String value1, String value2) {
            addCriterion("store_logo_image between", value1, value2, "storeLogoImage");
            return (Criteria) this;
        }

        public Criteria andStoreLogoImageNotBetween(String value1, String value2) {
            addCriterion("store_logo_image not between", value1, value2, "storeLogoImage");
            return (Criteria) this;
        }

        public Criteria andBelongUserIdIsNull() {
            addCriterion("belong_user_id is null");
            return (Criteria) this;
        }

        public Criteria andBelongUserIdIsNotNull() {
            addCriterion("belong_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andBelongUserIdEqualTo(Integer value) {
            addCriterion("belong_user_id =", value, "belongUserId");
            return (Criteria) this;
        }

        public Criteria andBelongUserIdNotEqualTo(Integer value) {
            addCriterion("belong_user_id <>", value, "belongUserId");
            return (Criteria) this;
        }

        public Criteria andBelongUserIdGreaterThan(Integer value) {
            addCriterion("belong_user_id >", value, "belongUserId");
            return (Criteria) this;
        }

        public Criteria andBelongUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("belong_user_id >=", value, "belongUserId");
            return (Criteria) this;
        }

        public Criteria andBelongUserIdLessThan(Integer value) {
            addCriterion("belong_user_id <", value, "belongUserId");
            return (Criteria) this;
        }

        public Criteria andBelongUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("belong_user_id <=", value, "belongUserId");
            return (Criteria) this;
        }

        public Criteria andBelongUserIdIn(List<Integer> values) {
            addCriterion("belong_user_id in", values, "belongUserId");
            return (Criteria) this;
        }

        public Criteria andBelongUserIdNotIn(List<Integer> values) {
            addCriterion("belong_user_id not in", values, "belongUserId");
            return (Criteria) this;
        }

        public Criteria andBelongUserIdBetween(Integer value1, Integer value2) {
            addCriterion("belong_user_id between", value1, value2, "belongUserId");
            return (Criteria) this;
        }

        public Criteria andBelongUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("belong_user_id not between", value1, value2, "belongUserId");
            return (Criteria) this;
        }

        public Criteria andStoreProceedsZfbIsNull() {
            addCriterion("store_proceeds_zfb is null");
            return (Criteria) this;
        }

        public Criteria andStoreProceedsZfbIsNotNull() {
            addCriterion("store_proceeds_zfb is not null");
            return (Criteria) this;
        }

        public Criteria andStoreProceedsZfbEqualTo(String value) {
            addCriterion("store_proceeds_zfb =", value, "storeProceedsZfb");
            return (Criteria) this;
        }

        public Criteria andStoreProceedsZfbNotEqualTo(String value) {
            addCriterion("store_proceeds_zfb <>", value, "storeProceedsZfb");
            return (Criteria) this;
        }

        public Criteria andStoreProceedsZfbGreaterThan(String value) {
            addCriterion("store_proceeds_zfb >", value, "storeProceedsZfb");
            return (Criteria) this;
        }

        public Criteria andStoreProceedsZfbGreaterThanOrEqualTo(String value) {
            addCriterion("store_proceeds_zfb >=", value, "storeProceedsZfb");
            return (Criteria) this;
        }

        public Criteria andStoreProceedsZfbLessThan(String value) {
            addCriterion("store_proceeds_zfb <", value, "storeProceedsZfb");
            return (Criteria) this;
        }

        public Criteria andStoreProceedsZfbLessThanOrEqualTo(String value) {
            addCriterion("store_proceeds_zfb <=", value, "storeProceedsZfb");
            return (Criteria) this;
        }

        public Criteria andStoreProceedsZfbLike(String value) {
            addCriterion("store_proceeds_zfb like", value, "storeProceedsZfb");
            return (Criteria) this;
        }

        public Criteria andStoreProceedsZfbNotLike(String value) {
            addCriterion("store_proceeds_zfb not like", value, "storeProceedsZfb");
            return (Criteria) this;
        }

        public Criteria andStoreProceedsZfbIn(List<String> values) {
            addCriterion("store_proceeds_zfb in", values, "storeProceedsZfb");
            return (Criteria) this;
        }

        public Criteria andStoreProceedsZfbNotIn(List<String> values) {
            addCriterion("store_proceeds_zfb not in", values, "storeProceedsZfb");
            return (Criteria) this;
        }

        public Criteria andStoreProceedsZfbBetween(String value1, String value2) {
            addCriterion("store_proceeds_zfb between", value1, value2, "storeProceedsZfb");
            return (Criteria) this;
        }

        public Criteria andStoreProceedsZfbNotBetween(String value1, String value2) {
            addCriterion("store_proceeds_zfb not between", value1, value2, "storeProceedsZfb");
            return (Criteria) this;
        }

        public Criteria andStoreDescribeIsNull() {
            addCriterion("store_describe is null");
            return (Criteria) this;
        }

        public Criteria andStoreDescribeIsNotNull() {
            addCriterion("store_describe is not null");
            return (Criteria) this;
        }

        public Criteria andStoreDescribeEqualTo(String value) {
            addCriterion("store_describe =", value, "storeDescribe");
            return (Criteria) this;
        }

        public Criteria andStoreDescribeNotEqualTo(String value) {
            addCriterion("store_describe <>", value, "storeDescribe");
            return (Criteria) this;
        }

        public Criteria andStoreDescribeGreaterThan(String value) {
            addCriterion("store_describe >", value, "storeDescribe");
            return (Criteria) this;
        }

        public Criteria andStoreDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("store_describe >=", value, "storeDescribe");
            return (Criteria) this;
        }

        public Criteria andStoreDescribeLessThan(String value) {
            addCriterion("store_describe <", value, "storeDescribe");
            return (Criteria) this;
        }

        public Criteria andStoreDescribeLessThanOrEqualTo(String value) {
            addCriterion("store_describe <=", value, "storeDescribe");
            return (Criteria) this;
        }

        public Criteria andStoreDescribeLike(String value) {
            addCriterion("store_describe like", value, "storeDescribe");
            return (Criteria) this;
        }

        public Criteria andStoreDescribeNotLike(String value) {
            addCriterion("store_describe not like", value, "storeDescribe");
            return (Criteria) this;
        }

        public Criteria andStoreDescribeIn(List<String> values) {
            addCriterion("store_describe in", values, "storeDescribe");
            return (Criteria) this;
        }

        public Criteria andStoreDescribeNotIn(List<String> values) {
            addCriterion("store_describe not in", values, "storeDescribe");
            return (Criteria) this;
        }

        public Criteria andStoreDescribeBetween(String value1, String value2) {
            addCriterion("store_describe between", value1, value2, "storeDescribe");
            return (Criteria) this;
        }

        public Criteria andStoreDescribeNotBetween(String value1, String value2) {
            addCriterion("store_describe not between", value1, value2, "storeDescribe");
            return (Criteria) this;
        }

        public Criteria andStorePhoneIsNull() {
            addCriterion("store_phone is null");
            return (Criteria) this;
        }

        public Criteria andStorePhoneIsNotNull() {
            addCriterion("store_phone is not null");
            return (Criteria) this;
        }

        public Criteria andStorePhoneEqualTo(String value) {
            addCriterion("store_phone =", value, "storePhone");
            return (Criteria) this;
        }

        public Criteria andStorePhoneNotEqualTo(String value) {
            addCriterion("store_phone <>", value, "storePhone");
            return (Criteria) this;
        }

        public Criteria andStorePhoneGreaterThan(String value) {
            addCriterion("store_phone >", value, "storePhone");
            return (Criteria) this;
        }

        public Criteria andStorePhoneGreaterThanOrEqualTo(String value) {
            addCriterion("store_phone >=", value, "storePhone");
            return (Criteria) this;
        }

        public Criteria andStorePhoneLessThan(String value) {
            addCriterion("store_phone <", value, "storePhone");
            return (Criteria) this;
        }

        public Criteria andStorePhoneLessThanOrEqualTo(String value) {
            addCriterion("store_phone <=", value, "storePhone");
            return (Criteria) this;
        }

        public Criteria andStorePhoneLike(String value) {
            addCriterion("store_phone like", value, "storePhone");
            return (Criteria) this;
        }

        public Criteria andStorePhoneNotLike(String value) {
            addCriterion("store_phone not like", value, "storePhone");
            return (Criteria) this;
        }

        public Criteria andStorePhoneIn(List<String> values) {
            addCriterion("store_phone in", values, "storePhone");
            return (Criteria) this;
        }

        public Criteria andStorePhoneNotIn(List<String> values) {
            addCriterion("store_phone not in", values, "storePhone");
            return (Criteria) this;
        }

        public Criteria andStorePhoneBetween(String value1, String value2) {
            addCriterion("store_phone between", value1, value2, "storePhone");
            return (Criteria) this;
        }

        public Criteria andStorePhoneNotBetween(String value1, String value2) {
            addCriterion("store_phone not between", value1, value2, "storePhone");
            return (Criteria) this;
        }

        public Criteria andStoreStateIsNull() {
            addCriterion("store_state is null");
            return (Criteria) this;
        }

        public Criteria andStoreStateIsNotNull() {
            addCriterion("store_state is not null");
            return (Criteria) this;
        }

        public Criteria andStoreStateEqualTo(Integer value) {
            addCriterion("store_state =", value, "storeState");
            return (Criteria) this;
        }

        public Criteria andStoreStateNotEqualTo(Integer value) {
            addCriterion("store_state <>", value, "storeState");
            return (Criteria) this;
        }

        public Criteria andStoreStateGreaterThan(Integer value) {
            addCriterion("store_state >", value, "storeState");
            return (Criteria) this;
        }

        public Criteria andStoreStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_state >=", value, "storeState");
            return (Criteria) this;
        }

        public Criteria andStoreStateLessThan(Integer value) {
            addCriterion("store_state <", value, "storeState");
            return (Criteria) this;
        }

        public Criteria andStoreStateLessThanOrEqualTo(Integer value) {
            addCriterion("store_state <=", value, "storeState");
            return (Criteria) this;
        }

        public Criteria andStoreStateIn(List<Integer> values) {
            addCriterion("store_state in", values, "storeState");
            return (Criteria) this;
        }

        public Criteria andStoreStateNotIn(List<Integer> values) {
            addCriterion("store_state not in", values, "storeState");
            return (Criteria) this;
        }

        public Criteria andStoreStateBetween(Integer value1, Integer value2) {
            addCriterion("store_state between", value1, value2, "storeState");
            return (Criteria) this;
        }

        public Criteria andStoreStateNotBetween(Integer value1, Integer value2) {
            addCriterion("store_state not between", value1, value2, "storeState");
            return (Criteria) this;
        }

        public Criteria andStoreLevenIsNull() {
            addCriterion("store_leven is null");
            return (Criteria) this;
        }

        public Criteria andStoreLevenIsNotNull() {
            addCriterion("store_leven is not null");
            return (Criteria) this;
        }

        public Criteria andStoreLevenEqualTo(Integer value) {
            addCriterion("store_leven =", value, "storeLeven");
            return (Criteria) this;
        }

        public Criteria andStoreLevenNotEqualTo(Integer value) {
            addCriterion("store_leven <>", value, "storeLeven");
            return (Criteria) this;
        }

        public Criteria andStoreLevenGreaterThan(Integer value) {
            addCriterion("store_leven >", value, "storeLeven");
            return (Criteria) this;
        }

        public Criteria andStoreLevenGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_leven >=", value, "storeLeven");
            return (Criteria) this;
        }

        public Criteria andStoreLevenLessThan(Integer value) {
            addCriterion("store_leven <", value, "storeLeven");
            return (Criteria) this;
        }

        public Criteria andStoreLevenLessThanOrEqualTo(Integer value) {
            addCriterion("store_leven <=", value, "storeLeven");
            return (Criteria) this;
        }

        public Criteria andStoreLevenIn(List<Integer> values) {
            addCriterion("store_leven in", values, "storeLeven");
            return (Criteria) this;
        }

        public Criteria andStoreLevenNotIn(List<Integer> values) {
            addCriterion("store_leven not in", values, "storeLeven");
            return (Criteria) this;
        }

        public Criteria andStoreLevenBetween(Integer value1, Integer value2) {
            addCriterion("store_leven between", value1, value2, "storeLeven");
            return (Criteria) this;
        }

        public Criteria andStoreLevenNotBetween(Integer value1, Integer value2) {
            addCriterion("store_leven not between", value1, value2, "storeLeven");
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

        public Criteria andGointoTimeIsNull() {
            addCriterion("gointo_time is null");
            return (Criteria) this;
        }

        public Criteria andGointoTimeIsNotNull() {
            addCriterion("gointo_time is not null");
            return (Criteria) this;
        }

        public Criteria andGointoTimeEqualTo(Date value) {
            addCriterion("gointo_time =", value, "gointoTime");
            return (Criteria) this;
        }

        public Criteria andGointoTimeNotEqualTo(Date value) {
            addCriterion("gointo_time <>", value, "gointoTime");
            return (Criteria) this;
        }

        public Criteria andGointoTimeGreaterThan(Date value) {
            addCriterion("gointo_time >", value, "gointoTime");
            return (Criteria) this;
        }

        public Criteria andGointoTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("gointo_time >=", value, "gointoTime");
            return (Criteria) this;
        }

        public Criteria andGointoTimeLessThan(Date value) {
            addCriterion("gointo_time <", value, "gointoTime");
            return (Criteria) this;
        }

        public Criteria andGointoTimeLessThanOrEqualTo(Date value) {
            addCriterion("gointo_time <=", value, "gointoTime");
            return (Criteria) this;
        }

        public Criteria andGointoTimeIn(List<Date> values) {
            addCriterion("gointo_time in", values, "gointoTime");
            return (Criteria) this;
        }

        public Criteria andGointoTimeNotIn(List<Date> values) {
            addCriterion("gointo_time not in", values, "gointoTime");
            return (Criteria) this;
        }

        public Criteria andGointoTimeBetween(Date value1, Date value2) {
            addCriterion("gointo_time between", value1, value2, "gointoTime");
            return (Criteria) this;
        }

        public Criteria andGointoTimeNotBetween(Date value1, Date value2) {
            addCriterion("gointo_time not between", value1, value2, "gointoTime");
            return (Criteria) this;
        }

        public Criteria andStoreCashIsNull() {
            addCriterion("store_cash is null");
            return (Criteria) this;
        }

        public Criteria andStoreCashIsNotNull() {
            addCriterion("store_cash is not null");
            return (Criteria) this;
        }

        public Criteria andStoreCashEqualTo(Integer value) {
            addCriterion("store_cash =", value, "storeCash");
            return (Criteria) this;
        }

        public Criteria andStoreCashNotEqualTo(Integer value) {
            addCriterion("store_cash <>", value, "storeCash");
            return (Criteria) this;
        }

        public Criteria andStoreCashGreaterThan(Integer value) {
            addCriterion("store_cash >", value, "storeCash");
            return (Criteria) this;
        }

        public Criteria andStoreCashGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_cash >=", value, "storeCash");
            return (Criteria) this;
        }

        public Criteria andStoreCashLessThan(Integer value) {
            addCriterion("store_cash <", value, "storeCash");
            return (Criteria) this;
        }

        public Criteria andStoreCashLessThanOrEqualTo(Integer value) {
            addCriterion("store_cash <=", value, "storeCash");
            return (Criteria) this;
        }

        public Criteria andStoreCashIn(List<Integer> values) {
            addCriterion("store_cash in", values, "storeCash");
            return (Criteria) this;
        }

        public Criteria andStoreCashNotIn(List<Integer> values) {
            addCriterion("store_cash not in", values, "storeCash");
            return (Criteria) this;
        }

        public Criteria andStoreCashBetween(Integer value1, Integer value2) {
            addCriterion("store_cash between", value1, value2, "storeCash");
            return (Criteria) this;
        }

        public Criteria andStoreCashNotBetween(Integer value1, Integer value2) {
            addCriterion("store_cash not between", value1, value2, "storeCash");
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
     * k2_stroe
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * k2_stroe 2019-09-02
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