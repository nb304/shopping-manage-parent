package com.king2.commons.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class K2ProductSkuKeyExample {
    /**
     * k2_product_sku_key
     */
    protected String orderByClause;

    /**
     * k2_product_sku_key
     */
    protected boolean distinct;

    /**
     * k2_product_sku_key
     */
    protected List<Criteria> oredCriteria;

    public K2ProductSkuKeyExample() {
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
     * k2_product_sku_key 2019-08-07
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

        public Criteria andProductSkuKeyIdIsNull() {
            addCriterion("product_sku_key_id is null");
            return (Criteria) this;
        }

        public Criteria andProductSkuKeyIdIsNotNull() {
            addCriterion("product_sku_key_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductSkuKeyIdEqualTo(Integer value) {
            addCriterion("product_sku_key_id =", value, "productSkuKeyId");
            return (Criteria) this;
        }

        public Criteria andProductSkuKeyIdNotEqualTo(Integer value) {
            addCriterion("product_sku_key_id <>", value, "productSkuKeyId");
            return (Criteria) this;
        }

        public Criteria andProductSkuKeyIdGreaterThan(Integer value) {
            addCriterion("product_sku_key_id >", value, "productSkuKeyId");
            return (Criteria) this;
        }

        public Criteria andProductSkuKeyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_sku_key_id >=", value, "productSkuKeyId");
            return (Criteria) this;
        }

        public Criteria andProductSkuKeyIdLessThan(Integer value) {
            addCriterion("product_sku_key_id <", value, "productSkuKeyId");
            return (Criteria) this;
        }

        public Criteria andProductSkuKeyIdLessThanOrEqualTo(Integer value) {
            addCriterion("product_sku_key_id <=", value, "productSkuKeyId");
            return (Criteria) this;
        }

        public Criteria andProductSkuKeyIdIn(List<Integer> values) {
            addCriterion("product_sku_key_id in", values, "productSkuKeyId");
            return (Criteria) this;
        }

        public Criteria andProductSkuKeyIdNotIn(List<Integer> values) {
            addCriterion("product_sku_key_id not in", values, "productSkuKeyId");
            return (Criteria) this;
        }

        public Criteria andProductSkuKeyIdBetween(Integer value1, Integer value2) {
            addCriterion("product_sku_key_id between", value1, value2, "productSkuKeyId");
            return (Criteria) this;
        }

        public Criteria andProductSkuKeyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("product_sku_key_id not between", value1, value2, "productSkuKeyId");
            return (Criteria) this;
        }

        public Criteria andProductSkuKeyNameIsNull() {
            addCriterion("product_sku_key_name is null");
            return (Criteria) this;
        }

        public Criteria andProductSkuKeyNameIsNotNull() {
            addCriterion("product_sku_key_name is not null");
            return (Criteria) this;
        }

        public Criteria andProductSkuKeyNameEqualTo(String value) {
            addCriterion("product_sku_key_name =", value, "productSkuKeyName");
            return (Criteria) this;
        }

        public Criteria andProductSkuKeyNameNotEqualTo(String value) {
            addCriterion("product_sku_key_name <>", value, "productSkuKeyName");
            return (Criteria) this;
        }

        public Criteria andProductSkuKeyNameGreaterThan(String value) {
            addCriterion("product_sku_key_name >", value, "productSkuKeyName");
            return (Criteria) this;
        }

        public Criteria andProductSkuKeyNameGreaterThanOrEqualTo(String value) {
            addCriterion("product_sku_key_name >=", value, "productSkuKeyName");
            return (Criteria) this;
        }

        public Criteria andProductSkuKeyNameLessThan(String value) {
            addCriterion("product_sku_key_name <", value, "productSkuKeyName");
            return (Criteria) this;
        }

        public Criteria andProductSkuKeyNameLessThanOrEqualTo(String value) {
            addCriterion("product_sku_key_name <=", value, "productSkuKeyName");
            return (Criteria) this;
        }

        public Criteria andProductSkuKeyNameLike(String value) {
            addCriterion("product_sku_key_name like", value, "productSkuKeyName");
            return (Criteria) this;
        }

        public Criteria andProductSkuKeyNameNotLike(String value) {
            addCriterion("product_sku_key_name not like", value, "productSkuKeyName");
            return (Criteria) this;
        }

        public Criteria andProductSkuKeyNameIn(List<String> values) {
            addCriterion("product_sku_key_name in", values, "productSkuKeyName");
            return (Criteria) this;
        }

        public Criteria andProductSkuKeyNameNotIn(List<String> values) {
            addCriterion("product_sku_key_name not in", values, "productSkuKeyName");
            return (Criteria) this;
        }

        public Criteria andProductSkuKeyNameBetween(String value1, String value2) {
            addCriterion("product_sku_key_name between", value1, value2, "productSkuKeyName");
            return (Criteria) this;
        }

        public Criteria andProductSkuKeyNameNotBetween(String value1, String value2) {
            addCriterion("product_sku_key_name not between", value1, value2, "productSkuKeyName");
            return (Criteria) this;
        }

        public Criteria andBelongProductIdIsNull() {
            addCriterion("belong_product_id is null");
            return (Criteria) this;
        }

        public Criteria andBelongProductIdIsNotNull() {
            addCriterion("belong_product_id is not null");
            return (Criteria) this;
        }

        public Criteria andBelongProductIdEqualTo(Integer value) {
            addCriterion("belong_product_id =", value, "belongProductId");
            return (Criteria) this;
        }

        public Criteria andBelongProductIdNotEqualTo(Integer value) {
            addCriterion("belong_product_id <>", value, "belongProductId");
            return (Criteria) this;
        }

        public Criteria andBelongProductIdGreaterThan(Integer value) {
            addCriterion("belong_product_id >", value, "belongProductId");
            return (Criteria) this;
        }

        public Criteria andBelongProductIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("belong_product_id >=", value, "belongProductId");
            return (Criteria) this;
        }

        public Criteria andBelongProductIdLessThan(Integer value) {
            addCriterion("belong_product_id <", value, "belongProductId");
            return (Criteria) this;
        }

        public Criteria andBelongProductIdLessThanOrEqualTo(Integer value) {
            addCriterion("belong_product_id <=", value, "belongProductId");
            return (Criteria) this;
        }

        public Criteria andBelongProductIdIn(List<Integer> values) {
            addCriterion("belong_product_id in", values, "belongProductId");
            return (Criteria) this;
        }

        public Criteria andBelongProductIdNotIn(List<Integer> values) {
            addCriterion("belong_product_id not in", values, "belongProductId");
            return (Criteria) this;
        }

        public Criteria andBelongProductIdBetween(Integer value1, Integer value2) {
            addCriterion("belong_product_id between", value1, value2, "belongProductId");
            return (Criteria) this;
        }

        public Criteria andBelongProductIdNotBetween(Integer value1, Integer value2) {
            addCriterion("belong_product_id not between", value1, value2, "belongProductId");
            return (Criteria) this;
        }

        public Criteria andBelongCategoryIdIsNull() {
            addCriterion("belong_category_id is null");
            return (Criteria) this;
        }

        public Criteria andBelongCategoryIdIsNotNull() {
            addCriterion("belong_category_id is not null");
            return (Criteria) this;
        }

        public Criteria andBelongCategoryIdEqualTo(Integer value) {
            addCriterion("belong_category_id =", value, "belongCategoryId");
            return (Criteria) this;
        }

        public Criteria andBelongCategoryIdNotEqualTo(Integer value) {
            addCriterion("belong_category_id <>", value, "belongCategoryId");
            return (Criteria) this;
        }

        public Criteria andBelongCategoryIdGreaterThan(Integer value) {
            addCriterion("belong_category_id >", value, "belongCategoryId");
            return (Criteria) this;
        }

        public Criteria andBelongCategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("belong_category_id >=", value, "belongCategoryId");
            return (Criteria) this;
        }

        public Criteria andBelongCategoryIdLessThan(Integer value) {
            addCriterion("belong_category_id <", value, "belongCategoryId");
            return (Criteria) this;
        }

        public Criteria andBelongCategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("belong_category_id <=", value, "belongCategoryId");
            return (Criteria) this;
        }

        public Criteria andBelongCategoryIdIn(List<Integer> values) {
            addCriterion("belong_category_id in", values, "belongCategoryId");
            return (Criteria) this;
        }

        public Criteria andBelongCategoryIdNotIn(List<Integer> values) {
            addCriterion("belong_category_id not in", values, "belongCategoryId");
            return (Criteria) this;
        }

        public Criteria andBelongCategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("belong_category_id between", value1, value2, "belongCategoryId");
            return (Criteria) this;
        }

        public Criteria andBelongCategoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("belong_category_id not between", value1, value2, "belongCategoryId");
            return (Criteria) this;
        }

        public Criteria andIsSystemCreateIsNull() {
            addCriterion("is_system_create is null");
            return (Criteria) this;
        }

        public Criteria andIsSystemCreateIsNotNull() {
            addCriterion("is_system_create is not null");
            return (Criteria) this;
        }

        public Criteria andIsSystemCreateEqualTo(Integer value) {
            addCriterion("is_system_create =", value, "isSystemCreate");
            return (Criteria) this;
        }

        public Criteria andIsSystemCreateNotEqualTo(Integer value) {
            addCriterion("is_system_create <>", value, "isSystemCreate");
            return (Criteria) this;
        }

        public Criteria andIsSystemCreateGreaterThan(Integer value) {
            addCriterion("is_system_create >", value, "isSystemCreate");
            return (Criteria) this;
        }

        public Criteria andIsSystemCreateGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_system_create >=", value, "isSystemCreate");
            return (Criteria) this;
        }

        public Criteria andIsSystemCreateLessThan(Integer value) {
            addCriterion("is_system_create <", value, "isSystemCreate");
            return (Criteria) this;
        }

        public Criteria andIsSystemCreateLessThanOrEqualTo(Integer value) {
            addCriterion("is_system_create <=", value, "isSystemCreate");
            return (Criteria) this;
        }

        public Criteria andIsSystemCreateIn(List<Integer> values) {
            addCriterion("is_system_create in", values, "isSystemCreate");
            return (Criteria) this;
        }

        public Criteria andIsSystemCreateNotIn(List<Integer> values) {
            addCriterion("is_system_create not in", values, "isSystemCreate");
            return (Criteria) this;
        }

        public Criteria andIsSystemCreateBetween(Integer value1, Integer value2) {
            addCriterion("is_system_create between", value1, value2, "isSystemCreate");
            return (Criteria) this;
        }

        public Criteria andIsSystemCreateNotBetween(Integer value1, Integer value2) {
            addCriterion("is_system_create not between", value1, value2, "isSystemCreate");
            return (Criteria) this;
        }

        public Criteria andCreateUseridIsNull() {
            addCriterion("create_userid is null");
            return (Criteria) this;
        }

        public Criteria andCreateUseridIsNotNull() {
            addCriterion("create_userid is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUseridEqualTo(Integer value) {
            addCriterion("create_userid =", value, "createUserid");
            return (Criteria) this;
        }

        public Criteria andCreateUseridNotEqualTo(Integer value) {
            addCriterion("create_userid <>", value, "createUserid");
            return (Criteria) this;
        }

        public Criteria andCreateUseridGreaterThan(Integer value) {
            addCriterion("create_userid >", value, "createUserid");
            return (Criteria) this;
        }

        public Criteria andCreateUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_userid >=", value, "createUserid");
            return (Criteria) this;
        }

        public Criteria andCreateUseridLessThan(Integer value) {
            addCriterion("create_userid <", value, "createUserid");
            return (Criteria) this;
        }

        public Criteria andCreateUseridLessThanOrEqualTo(Integer value) {
            addCriterion("create_userid <=", value, "createUserid");
            return (Criteria) this;
        }

        public Criteria andCreateUseridIn(List<Integer> values) {
            addCriterion("create_userid in", values, "createUserid");
            return (Criteria) this;
        }

        public Criteria andCreateUseridNotIn(List<Integer> values) {
            addCriterion("create_userid not in", values, "createUserid");
            return (Criteria) this;
        }

        public Criteria andCreateUseridBetween(Integer value1, Integer value2) {
            addCriterion("create_userid between", value1, value2, "createUserid");
            return (Criteria) this;
        }

        public Criteria andCreateUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("create_userid not between", value1, value2, "createUserid");
            return (Criteria) this;
        }

        public Criteria andBelongStoreIdIsNull() {
            addCriterion("belong_store_id is null");
            return (Criteria) this;
        }

        public Criteria andBelongStoreIdIsNotNull() {
            addCriterion("belong_store_id is not null");
            return (Criteria) this;
        }

        public Criteria andBelongStoreIdEqualTo(Integer value) {
            addCriterion("belong_store_id =", value, "belongStoreId");
            return (Criteria) this;
        }

        public Criteria andBelongStoreIdNotEqualTo(Integer value) {
            addCriterion("belong_store_id <>", value, "belongStoreId");
            return (Criteria) this;
        }

        public Criteria andBelongStoreIdGreaterThan(Integer value) {
            addCriterion("belong_store_id >", value, "belongStoreId");
            return (Criteria) this;
        }

        public Criteria andBelongStoreIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("belong_store_id >=", value, "belongStoreId");
            return (Criteria) this;
        }

        public Criteria andBelongStoreIdLessThan(Integer value) {
            addCriterion("belong_store_id <", value, "belongStoreId");
            return (Criteria) this;
        }

        public Criteria andBelongStoreIdLessThanOrEqualTo(Integer value) {
            addCriterion("belong_store_id <=", value, "belongStoreId");
            return (Criteria) this;
        }

        public Criteria andBelongStoreIdIn(List<Integer> values) {
            addCriterion("belong_store_id in", values, "belongStoreId");
            return (Criteria) this;
        }

        public Criteria andBelongStoreIdNotIn(List<Integer> values) {
            addCriterion("belong_store_id not in", values, "belongStoreId");
            return (Criteria) this;
        }

        public Criteria andBelongStoreIdBetween(Integer value1, Integer value2) {
            addCriterion("belong_store_id between", value1, value2, "belongStoreId");
            return (Criteria) this;
        }

        public Criteria andBelongStoreIdNotBetween(Integer value1, Integer value2) {
            addCriterion("belong_store_id not between", value1, value2, "belongStoreId");
            return (Criteria) this;
        }

        public Criteria andSkuKeyStateIsNull() {
            addCriterion("sku_key_state is null");
            return (Criteria) this;
        }

        public Criteria andSkuKeyStateIsNotNull() {
            addCriterion("sku_key_state is not null");
            return (Criteria) this;
        }

        public Criteria andSkuKeyStateEqualTo(Integer value) {
            addCriterion("sku_key_state =", value, "skuKeyState");
            return (Criteria) this;
        }

        public Criteria andSkuKeyStateNotEqualTo(Integer value) {
            addCriterion("sku_key_state <>", value, "skuKeyState");
            return (Criteria) this;
        }

        public Criteria andSkuKeyStateGreaterThan(Integer value) {
            addCriterion("sku_key_state >", value, "skuKeyState");
            return (Criteria) this;
        }

        public Criteria andSkuKeyStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("sku_key_state >=", value, "skuKeyState");
            return (Criteria) this;
        }

        public Criteria andSkuKeyStateLessThan(Integer value) {
            addCriterion("sku_key_state <", value, "skuKeyState");
            return (Criteria) this;
        }

        public Criteria andSkuKeyStateLessThanOrEqualTo(Integer value) {
            addCriterion("sku_key_state <=", value, "skuKeyState");
            return (Criteria) this;
        }

        public Criteria andSkuKeyStateIn(List<Integer> values) {
            addCriterion("sku_key_state in", values, "skuKeyState");
            return (Criteria) this;
        }

        public Criteria andSkuKeyStateNotIn(List<Integer> values) {
            addCriterion("sku_key_state not in", values, "skuKeyState");
            return (Criteria) this;
        }

        public Criteria andSkuKeyStateBetween(Integer value1, Integer value2) {
            addCriterion("sku_key_state between", value1, value2, "skuKeyState");
            return (Criteria) this;
        }

        public Criteria andSkuKeyStateNotBetween(Integer value1, Integer value2) {
            addCriterion("sku_key_state not between", value1, value2, "skuKeyState");
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

        public Criteria andSkuKeyOrderIsNull() {
            addCriterion("sku_key_order is null");
            return (Criteria) this;
        }

        public Criteria andSkuKeyOrderIsNotNull() {
            addCriterion("sku_key_order is not null");
            return (Criteria) this;
        }

        public Criteria andSkuKeyOrderEqualTo(Integer value) {
            addCriterion("sku_key_order =", value, "skuKeyOrder");
            return (Criteria) this;
        }

        public Criteria andSkuKeyOrderNotEqualTo(Integer value) {
            addCriterion("sku_key_order <>", value, "skuKeyOrder");
            return (Criteria) this;
        }

        public Criteria andSkuKeyOrderGreaterThan(Integer value) {
            addCriterion("sku_key_order >", value, "skuKeyOrder");
            return (Criteria) this;
        }

        public Criteria andSkuKeyOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("sku_key_order >=", value, "skuKeyOrder");
            return (Criteria) this;
        }

        public Criteria andSkuKeyOrderLessThan(Integer value) {
            addCriterion("sku_key_order <", value, "skuKeyOrder");
            return (Criteria) this;
        }

        public Criteria andSkuKeyOrderLessThanOrEqualTo(Integer value) {
            addCriterion("sku_key_order <=", value, "skuKeyOrder");
            return (Criteria) this;
        }

        public Criteria andSkuKeyOrderIn(List<Integer> values) {
            addCriterion("sku_key_order in", values, "skuKeyOrder");
            return (Criteria) this;
        }

        public Criteria andSkuKeyOrderNotIn(List<Integer> values) {
            addCriterion("sku_key_order not in", values, "skuKeyOrder");
            return (Criteria) this;
        }

        public Criteria andSkuKeyOrderBetween(Integer value1, Integer value2) {
            addCriterion("sku_key_order between", value1, value2, "skuKeyOrder");
            return (Criteria) this;
        }

        public Criteria andSkuKeyOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("sku_key_order not between", value1, value2, "skuKeyOrder");
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
     * k2_product_sku_key
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * k2_product_sku_key 2019-08-07
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