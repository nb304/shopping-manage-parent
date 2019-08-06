package com.king2.commons.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class K2ProductEvaluateExample {
    /**
     * k2_product_evaluate
     */
    protected String orderByClause;

    /**
     * k2_product_evaluate
     */
    protected boolean distinct;

    /**
     * k2_product_evaluate
     */
    protected List<Criteria> oredCriteria;

    public K2ProductEvaluateExample() {
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
     * k2_product_evaluate 2019-08-06
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

        public Criteria andProductEvaluateIdIsNull() {
            addCriterion("product_evaluate_id is null");
            return (Criteria) this;
        }

        public Criteria andProductEvaluateIdIsNotNull() {
            addCriterion("product_evaluate_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductEvaluateIdEqualTo(Integer value) {
            addCriterion("product_evaluate_id =", value, "productEvaluateId");
            return (Criteria) this;
        }

        public Criteria andProductEvaluateIdNotEqualTo(Integer value) {
            addCriterion("product_evaluate_id <>", value, "productEvaluateId");
            return (Criteria) this;
        }

        public Criteria andProductEvaluateIdGreaterThan(Integer value) {
            addCriterion("product_evaluate_id >", value, "productEvaluateId");
            return (Criteria) this;
        }

        public Criteria andProductEvaluateIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_evaluate_id >=", value, "productEvaluateId");
            return (Criteria) this;
        }

        public Criteria andProductEvaluateIdLessThan(Integer value) {
            addCriterion("product_evaluate_id <", value, "productEvaluateId");
            return (Criteria) this;
        }

        public Criteria andProductEvaluateIdLessThanOrEqualTo(Integer value) {
            addCriterion("product_evaluate_id <=", value, "productEvaluateId");
            return (Criteria) this;
        }

        public Criteria andProductEvaluateIdIn(List<Integer> values) {
            addCriterion("product_evaluate_id in", values, "productEvaluateId");
            return (Criteria) this;
        }

        public Criteria andProductEvaluateIdNotIn(List<Integer> values) {
            addCriterion("product_evaluate_id not in", values, "productEvaluateId");
            return (Criteria) this;
        }

        public Criteria andProductEvaluateIdBetween(Integer value1, Integer value2) {
            addCriterion("product_evaluate_id between", value1, value2, "productEvaluateId");
            return (Criteria) this;
        }

        public Criteria andProductEvaluateIdNotBetween(Integer value1, Integer value2) {
            addCriterion("product_evaluate_id not between", value1, value2, "productEvaluateId");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIsNull() {
            addCriterion("order_number is null");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIsNotNull() {
            addCriterion("order_number is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNumberEqualTo(String value) {
            addCriterion("order_number =", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotEqualTo(String value) {
            addCriterion("order_number <>", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThan(String value) {
            addCriterion("order_number >", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThanOrEqualTo(String value) {
            addCriterion("order_number >=", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThan(String value) {
            addCriterion("order_number <", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThanOrEqualTo(String value) {
            addCriterion("order_number <=", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLike(String value) {
            addCriterion("order_number like", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotLike(String value) {
            addCriterion("order_number not like", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIn(List<String> values) {
            addCriterion("order_number in", values, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotIn(List<String> values) {
            addCriterion("order_number not in", values, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberBetween(String value1, String value2) {
            addCriterion("order_number between", value1, value2, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotBetween(String value1, String value2) {
            addCriterion("order_number not between", value1, value2, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andProductEvaluateUseridIsNull() {
            addCriterion("product_evaluate_userid is null");
            return (Criteria) this;
        }

        public Criteria andProductEvaluateUseridIsNotNull() {
            addCriterion("product_evaluate_userid is not null");
            return (Criteria) this;
        }

        public Criteria andProductEvaluateUseridEqualTo(Integer value) {
            addCriterion("product_evaluate_userid =", value, "productEvaluateUserid");
            return (Criteria) this;
        }

        public Criteria andProductEvaluateUseridNotEqualTo(Integer value) {
            addCriterion("product_evaluate_userid <>", value, "productEvaluateUserid");
            return (Criteria) this;
        }

        public Criteria andProductEvaluateUseridGreaterThan(Integer value) {
            addCriterion("product_evaluate_userid >", value, "productEvaluateUserid");
            return (Criteria) this;
        }

        public Criteria andProductEvaluateUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_evaluate_userid >=", value, "productEvaluateUserid");
            return (Criteria) this;
        }

        public Criteria andProductEvaluateUseridLessThan(Integer value) {
            addCriterion("product_evaluate_userid <", value, "productEvaluateUserid");
            return (Criteria) this;
        }

        public Criteria andProductEvaluateUseridLessThanOrEqualTo(Integer value) {
            addCriterion("product_evaluate_userid <=", value, "productEvaluateUserid");
            return (Criteria) this;
        }

        public Criteria andProductEvaluateUseridIn(List<Integer> values) {
            addCriterion("product_evaluate_userid in", values, "productEvaluateUserid");
            return (Criteria) this;
        }

        public Criteria andProductEvaluateUseridNotIn(List<Integer> values) {
            addCriterion("product_evaluate_userid not in", values, "productEvaluateUserid");
            return (Criteria) this;
        }

        public Criteria andProductEvaluateUseridBetween(Integer value1, Integer value2) {
            addCriterion("product_evaluate_userid between", value1, value2, "productEvaluateUserid");
            return (Criteria) this;
        }

        public Criteria andProductEvaluateUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("product_evaluate_userid not between", value1, value2, "productEvaluateUserid");
            return (Criteria) this;
        }

        public Criteria andProductEvaluateUsernameIsNull() {
            addCriterion("product_evaluate_username is null");
            return (Criteria) this;
        }

        public Criteria andProductEvaluateUsernameIsNotNull() {
            addCriterion("product_evaluate_username is not null");
            return (Criteria) this;
        }

        public Criteria andProductEvaluateUsernameEqualTo(String value) {
            addCriterion("product_evaluate_username =", value, "productEvaluateUsername");
            return (Criteria) this;
        }

        public Criteria andProductEvaluateUsernameNotEqualTo(String value) {
            addCriterion("product_evaluate_username <>", value, "productEvaluateUsername");
            return (Criteria) this;
        }

        public Criteria andProductEvaluateUsernameGreaterThan(String value) {
            addCriterion("product_evaluate_username >", value, "productEvaluateUsername");
            return (Criteria) this;
        }

        public Criteria andProductEvaluateUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("product_evaluate_username >=", value, "productEvaluateUsername");
            return (Criteria) this;
        }

        public Criteria andProductEvaluateUsernameLessThan(String value) {
            addCriterion("product_evaluate_username <", value, "productEvaluateUsername");
            return (Criteria) this;
        }

        public Criteria andProductEvaluateUsernameLessThanOrEqualTo(String value) {
            addCriterion("product_evaluate_username <=", value, "productEvaluateUsername");
            return (Criteria) this;
        }

        public Criteria andProductEvaluateUsernameLike(String value) {
            addCriterion("product_evaluate_username like", value, "productEvaluateUsername");
            return (Criteria) this;
        }

        public Criteria andProductEvaluateUsernameNotLike(String value) {
            addCriterion("product_evaluate_username not like", value, "productEvaluateUsername");
            return (Criteria) this;
        }

        public Criteria andProductEvaluateUsernameIn(List<String> values) {
            addCriterion("product_evaluate_username in", values, "productEvaluateUsername");
            return (Criteria) this;
        }

        public Criteria andProductEvaluateUsernameNotIn(List<String> values) {
            addCriterion("product_evaluate_username not in", values, "productEvaluateUsername");
            return (Criteria) this;
        }

        public Criteria andProductEvaluateUsernameBetween(String value1, String value2) {
            addCriterion("product_evaluate_username between", value1, value2, "productEvaluateUsername");
            return (Criteria) this;
        }

        public Criteria andProductEvaluateUsernameNotBetween(String value1, String value2) {
            addCriterion("product_evaluate_username not between", value1, value2, "productEvaluateUsername");
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

        public Criteria andBelongProductNameIsNull() {
            addCriterion("belong_product_name is null");
            return (Criteria) this;
        }

        public Criteria andBelongProductNameIsNotNull() {
            addCriterion("belong_product_name is not null");
            return (Criteria) this;
        }

        public Criteria andBelongProductNameEqualTo(String value) {
            addCriterion("belong_product_name =", value, "belongProductName");
            return (Criteria) this;
        }

        public Criteria andBelongProductNameNotEqualTo(String value) {
            addCriterion("belong_product_name <>", value, "belongProductName");
            return (Criteria) this;
        }

        public Criteria andBelongProductNameGreaterThan(String value) {
            addCriterion("belong_product_name >", value, "belongProductName");
            return (Criteria) this;
        }

        public Criteria andBelongProductNameGreaterThanOrEqualTo(String value) {
            addCriterion("belong_product_name >=", value, "belongProductName");
            return (Criteria) this;
        }

        public Criteria andBelongProductNameLessThan(String value) {
            addCriterion("belong_product_name <", value, "belongProductName");
            return (Criteria) this;
        }

        public Criteria andBelongProductNameLessThanOrEqualTo(String value) {
            addCriterion("belong_product_name <=", value, "belongProductName");
            return (Criteria) this;
        }

        public Criteria andBelongProductNameLike(String value) {
            addCriterion("belong_product_name like", value, "belongProductName");
            return (Criteria) this;
        }

        public Criteria andBelongProductNameNotLike(String value) {
            addCriterion("belong_product_name not like", value, "belongProductName");
            return (Criteria) this;
        }

        public Criteria andBelongProductNameIn(List<String> values) {
            addCriterion("belong_product_name in", values, "belongProductName");
            return (Criteria) this;
        }

        public Criteria andBelongProductNameNotIn(List<String> values) {
            addCriterion("belong_product_name not in", values, "belongProductName");
            return (Criteria) this;
        }

        public Criteria andBelongProductNameBetween(String value1, String value2) {
            addCriterion("belong_product_name between", value1, value2, "belongProductName");
            return (Criteria) this;
        }

        public Criteria andBelongProductNameNotBetween(String value1, String value2) {
            addCriterion("belong_product_name not between", value1, value2, "belongProductName");
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

        public Criteria andProductEvaluateStateIsNull() {
            addCriterion("product_evaluate_state is null");
            return (Criteria) this;
        }

        public Criteria andProductEvaluateStateIsNotNull() {
            addCriterion("product_evaluate_state is not null");
            return (Criteria) this;
        }

        public Criteria andProductEvaluateStateEqualTo(Integer value) {
            addCriterion("product_evaluate_state =", value, "productEvaluateState");
            return (Criteria) this;
        }

        public Criteria andProductEvaluateStateNotEqualTo(Integer value) {
            addCriterion("product_evaluate_state <>", value, "productEvaluateState");
            return (Criteria) this;
        }

        public Criteria andProductEvaluateStateGreaterThan(Integer value) {
            addCriterion("product_evaluate_state >", value, "productEvaluateState");
            return (Criteria) this;
        }

        public Criteria andProductEvaluateStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_evaluate_state >=", value, "productEvaluateState");
            return (Criteria) this;
        }

        public Criteria andProductEvaluateStateLessThan(Integer value) {
            addCriterion("product_evaluate_state <", value, "productEvaluateState");
            return (Criteria) this;
        }

        public Criteria andProductEvaluateStateLessThanOrEqualTo(Integer value) {
            addCriterion("product_evaluate_state <=", value, "productEvaluateState");
            return (Criteria) this;
        }

        public Criteria andProductEvaluateStateIn(List<Integer> values) {
            addCriterion("product_evaluate_state in", values, "productEvaluateState");
            return (Criteria) this;
        }

        public Criteria andProductEvaluateStateNotIn(List<Integer> values) {
            addCriterion("product_evaluate_state not in", values, "productEvaluateState");
            return (Criteria) this;
        }

        public Criteria andProductEvaluateStateBetween(Integer value1, Integer value2) {
            addCriterion("product_evaluate_state between", value1, value2, "productEvaluateState");
            return (Criteria) this;
        }

        public Criteria andProductEvaluateStateNotBetween(Integer value1, Integer value2) {
            addCriterion("product_evaluate_state not between", value1, value2, "productEvaluateState");
            return (Criteria) this;
        }

        public Criteria andIsReadIsNull() {
            addCriterion("is_read is null");
            return (Criteria) this;
        }

        public Criteria andIsReadIsNotNull() {
            addCriterion("is_read is not null");
            return (Criteria) this;
        }

        public Criteria andIsReadEqualTo(Integer value) {
            addCriterion("is_read =", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadNotEqualTo(Integer value) {
            addCriterion("is_read <>", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadGreaterThan(Integer value) {
            addCriterion("is_read >", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_read >=", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadLessThan(Integer value) {
            addCriterion("is_read <", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadLessThanOrEqualTo(Integer value) {
            addCriterion("is_read <=", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadIn(List<Integer> values) {
            addCriterion("is_read in", values, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadNotIn(List<Integer> values) {
            addCriterion("is_read not in", values, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadBetween(Integer value1, Integer value2) {
            addCriterion("is_read between", value1, value2, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadNotBetween(Integer value1, Integer value2) {
            addCriterion("is_read not between", value1, value2, "isRead");
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
     * k2_product_evaluate
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * k2_product_evaluate 2019-08-06
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