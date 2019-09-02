package com.king2.commons.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class K2StoreCheckExample {
    /**
     * k2_store_check
     */
    protected String orderByClause;

    /**
     * k2_store_check
     */
    protected boolean distinct;

    /**
     * k2_store_check
     */
    protected List<Criteria> oredCriteria;

    public K2StoreCheckExample() {
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
     * k2_store_check 2019-09-02
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

        public Criteria andStoreCheckIdIsNull() {
            addCriterion("store_check_id is null");
            return (Criteria) this;
        }

        public Criteria andStoreCheckIdIsNotNull() {
            addCriterion("store_check_id is not null");
            return (Criteria) this;
        }

        public Criteria andStoreCheckIdEqualTo(Integer value) {
            addCriterion("store_check_id =", value, "storeCheckId");
            return (Criteria) this;
        }

        public Criteria andStoreCheckIdNotEqualTo(Integer value) {
            addCriterion("store_check_id <>", value, "storeCheckId");
            return (Criteria) this;
        }

        public Criteria andStoreCheckIdGreaterThan(Integer value) {
            addCriterion("store_check_id >", value, "storeCheckId");
            return (Criteria) this;
        }

        public Criteria andStoreCheckIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_check_id >=", value, "storeCheckId");
            return (Criteria) this;
        }

        public Criteria andStoreCheckIdLessThan(Integer value) {
            addCriterion("store_check_id <", value, "storeCheckId");
            return (Criteria) this;
        }

        public Criteria andStoreCheckIdLessThanOrEqualTo(Integer value) {
            addCriterion("store_check_id <=", value, "storeCheckId");
            return (Criteria) this;
        }

        public Criteria andStoreCheckIdIn(List<Integer> values) {
            addCriterion("store_check_id in", values, "storeCheckId");
            return (Criteria) this;
        }

        public Criteria andStoreCheckIdNotIn(List<Integer> values) {
            addCriterion("store_check_id not in", values, "storeCheckId");
            return (Criteria) this;
        }

        public Criteria andStoreCheckIdBetween(Integer value1, Integer value2) {
            addCriterion("store_check_id between", value1, value2, "storeCheckId");
            return (Criteria) this;
        }

        public Criteria andStoreCheckIdNotBetween(Integer value1, Integer value2) {
            addCriterion("store_check_id not between", value1, value2, "storeCheckId");
            return (Criteria) this;
        }

        public Criteria andStoreCheckNumberIsNull() {
            addCriterion("store_check_number is null");
            return (Criteria) this;
        }

        public Criteria andStoreCheckNumberIsNotNull() {
            addCriterion("store_check_number is not null");
            return (Criteria) this;
        }

        public Criteria andStoreCheckNumberEqualTo(String value) {
            addCriterion("store_check_number =", value, "storeCheckNumber");
            return (Criteria) this;
        }

        public Criteria andStoreCheckNumberNotEqualTo(String value) {
            addCriterion("store_check_number <>", value, "storeCheckNumber");
            return (Criteria) this;
        }

        public Criteria andStoreCheckNumberGreaterThan(String value) {
            addCriterion("store_check_number >", value, "storeCheckNumber");
            return (Criteria) this;
        }

        public Criteria andStoreCheckNumberGreaterThanOrEqualTo(String value) {
            addCriterion("store_check_number >=", value, "storeCheckNumber");
            return (Criteria) this;
        }

        public Criteria andStoreCheckNumberLessThan(String value) {
            addCriterion("store_check_number <", value, "storeCheckNumber");
            return (Criteria) this;
        }

        public Criteria andStoreCheckNumberLessThanOrEqualTo(String value) {
            addCriterion("store_check_number <=", value, "storeCheckNumber");
            return (Criteria) this;
        }

        public Criteria andStoreCheckNumberLike(String value) {
            addCriterion("store_check_number like", value, "storeCheckNumber");
            return (Criteria) this;
        }

        public Criteria andStoreCheckNumberNotLike(String value) {
            addCriterion("store_check_number not like", value, "storeCheckNumber");
            return (Criteria) this;
        }

        public Criteria andStoreCheckNumberIn(List<String> values) {
            addCriterion("store_check_number in", values, "storeCheckNumber");
            return (Criteria) this;
        }

        public Criteria andStoreCheckNumberNotIn(List<String> values) {
            addCriterion("store_check_number not in", values, "storeCheckNumber");
            return (Criteria) this;
        }

        public Criteria andStoreCheckNumberBetween(String value1, String value2) {
            addCriterion("store_check_number between", value1, value2, "storeCheckNumber");
            return (Criteria) this;
        }

        public Criteria andStoreCheckNumberNotBetween(String value1, String value2) {
            addCriterion("store_check_number not between", value1, value2, "storeCheckNumber");
            return (Criteria) this;
        }

        public Criteria andStoreCheckStorenameIsNull() {
            addCriterion("store_check_storeName is null");
            return (Criteria) this;
        }

        public Criteria andStoreCheckStorenameIsNotNull() {
            addCriterion("store_check_storeName is not null");
            return (Criteria) this;
        }

        public Criteria andStoreCheckStorenameEqualTo(String value) {
            addCriterion("store_check_storeName =", value, "storeCheckStorename");
            return (Criteria) this;
        }

        public Criteria andStoreCheckStorenameNotEqualTo(String value) {
            addCriterion("store_check_storeName <>", value, "storeCheckStorename");
            return (Criteria) this;
        }

        public Criteria andStoreCheckStorenameGreaterThan(String value) {
            addCriterion("store_check_storeName >", value, "storeCheckStorename");
            return (Criteria) this;
        }

        public Criteria andStoreCheckStorenameGreaterThanOrEqualTo(String value) {
            addCriterion("store_check_storeName >=", value, "storeCheckStorename");
            return (Criteria) this;
        }

        public Criteria andStoreCheckStorenameLessThan(String value) {
            addCriterion("store_check_storeName <", value, "storeCheckStorename");
            return (Criteria) this;
        }

        public Criteria andStoreCheckStorenameLessThanOrEqualTo(String value) {
            addCriterion("store_check_storeName <=", value, "storeCheckStorename");
            return (Criteria) this;
        }

        public Criteria andStoreCheckStorenameLike(String value) {
            addCriterion("store_check_storeName like", value, "storeCheckStorename");
            return (Criteria) this;
        }

        public Criteria andStoreCheckStorenameNotLike(String value) {
            addCriterion("store_check_storeName not like", value, "storeCheckStorename");
            return (Criteria) this;
        }

        public Criteria andStoreCheckStorenameIn(List<String> values) {
            addCriterion("store_check_storeName in", values, "storeCheckStorename");
            return (Criteria) this;
        }

        public Criteria andStoreCheckStorenameNotIn(List<String> values) {
            addCriterion("store_check_storeName not in", values, "storeCheckStorename");
            return (Criteria) this;
        }

        public Criteria andStoreCheckStorenameBetween(String value1, String value2) {
            addCriterion("store_check_storeName between", value1, value2, "storeCheckStorename");
            return (Criteria) this;
        }

        public Criteria andStoreCheckStorenameNotBetween(String value1, String value2) {
            addCriterion("store_check_storeName not between", value1, value2, "storeCheckStorename");
            return (Criteria) this;
        }

        public Criteria andStoreCheckNameIsNull() {
            addCriterion("store_check_name is null");
            return (Criteria) this;
        }

        public Criteria andStoreCheckNameIsNotNull() {
            addCriterion("store_check_name is not null");
            return (Criteria) this;
        }

        public Criteria andStoreCheckNameEqualTo(String value) {
            addCriterion("store_check_name =", value, "storeCheckName");
            return (Criteria) this;
        }

        public Criteria andStoreCheckNameNotEqualTo(String value) {
            addCriterion("store_check_name <>", value, "storeCheckName");
            return (Criteria) this;
        }

        public Criteria andStoreCheckNameGreaterThan(String value) {
            addCriterion("store_check_name >", value, "storeCheckName");
            return (Criteria) this;
        }

        public Criteria andStoreCheckNameGreaterThanOrEqualTo(String value) {
            addCriterion("store_check_name >=", value, "storeCheckName");
            return (Criteria) this;
        }

        public Criteria andStoreCheckNameLessThan(String value) {
            addCriterion("store_check_name <", value, "storeCheckName");
            return (Criteria) this;
        }

        public Criteria andStoreCheckNameLessThanOrEqualTo(String value) {
            addCriterion("store_check_name <=", value, "storeCheckName");
            return (Criteria) this;
        }

        public Criteria andStoreCheckNameLike(String value) {
            addCriterion("store_check_name like", value, "storeCheckName");
            return (Criteria) this;
        }

        public Criteria andStoreCheckNameNotLike(String value) {
            addCriterion("store_check_name not like", value, "storeCheckName");
            return (Criteria) this;
        }

        public Criteria andStoreCheckNameIn(List<String> values) {
            addCriterion("store_check_name in", values, "storeCheckName");
            return (Criteria) this;
        }

        public Criteria andStoreCheckNameNotIn(List<String> values) {
            addCriterion("store_check_name not in", values, "storeCheckName");
            return (Criteria) this;
        }

        public Criteria andStoreCheckNameBetween(String value1, String value2) {
            addCriterion("store_check_name between", value1, value2, "storeCheckName");
            return (Criteria) this;
        }

        public Criteria andStoreCheckNameNotBetween(String value1, String value2) {
            addCriterion("store_check_name not between", value1, value2, "storeCheckName");
            return (Criteria) this;
        }

        public Criteria andStoreCheckPhoneIsNull() {
            addCriterion("store_check_phone is null");
            return (Criteria) this;
        }

        public Criteria andStoreCheckPhoneIsNotNull() {
            addCriterion("store_check_phone is not null");
            return (Criteria) this;
        }

        public Criteria andStoreCheckPhoneEqualTo(String value) {
            addCriterion("store_check_phone =", value, "storeCheckPhone");
            return (Criteria) this;
        }

        public Criteria andStoreCheckPhoneNotEqualTo(String value) {
            addCriterion("store_check_phone <>", value, "storeCheckPhone");
            return (Criteria) this;
        }

        public Criteria andStoreCheckPhoneGreaterThan(String value) {
            addCriterion("store_check_phone >", value, "storeCheckPhone");
            return (Criteria) this;
        }

        public Criteria andStoreCheckPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("store_check_phone >=", value, "storeCheckPhone");
            return (Criteria) this;
        }

        public Criteria andStoreCheckPhoneLessThan(String value) {
            addCriterion("store_check_phone <", value, "storeCheckPhone");
            return (Criteria) this;
        }

        public Criteria andStoreCheckPhoneLessThanOrEqualTo(String value) {
            addCriterion("store_check_phone <=", value, "storeCheckPhone");
            return (Criteria) this;
        }

        public Criteria andStoreCheckPhoneLike(String value) {
            addCriterion("store_check_phone like", value, "storeCheckPhone");
            return (Criteria) this;
        }

        public Criteria andStoreCheckPhoneNotLike(String value) {
            addCriterion("store_check_phone not like", value, "storeCheckPhone");
            return (Criteria) this;
        }

        public Criteria andStoreCheckPhoneIn(List<String> values) {
            addCriterion("store_check_phone in", values, "storeCheckPhone");
            return (Criteria) this;
        }

        public Criteria andStoreCheckPhoneNotIn(List<String> values) {
            addCriterion("store_check_phone not in", values, "storeCheckPhone");
            return (Criteria) this;
        }

        public Criteria andStoreCheckPhoneBetween(String value1, String value2) {
            addCriterion("store_check_phone between", value1, value2, "storeCheckPhone");
            return (Criteria) this;
        }

        public Criteria andStoreCheckPhoneNotBetween(String value1, String value2) {
            addCriterion("store_check_phone not between", value1, value2, "storeCheckPhone");
            return (Criteria) this;
        }

        public Criteria andStoreCheckCardIsNull() {
            addCriterion("store_check_card is null");
            return (Criteria) this;
        }

        public Criteria andStoreCheckCardIsNotNull() {
            addCriterion("store_check_card is not null");
            return (Criteria) this;
        }

        public Criteria andStoreCheckCardEqualTo(String value) {
            addCriterion("store_check_card =", value, "storeCheckCard");
            return (Criteria) this;
        }

        public Criteria andStoreCheckCardNotEqualTo(String value) {
            addCriterion("store_check_card <>", value, "storeCheckCard");
            return (Criteria) this;
        }

        public Criteria andStoreCheckCardGreaterThan(String value) {
            addCriterion("store_check_card >", value, "storeCheckCard");
            return (Criteria) this;
        }

        public Criteria andStoreCheckCardGreaterThanOrEqualTo(String value) {
            addCriterion("store_check_card >=", value, "storeCheckCard");
            return (Criteria) this;
        }

        public Criteria andStoreCheckCardLessThan(String value) {
            addCriterion("store_check_card <", value, "storeCheckCard");
            return (Criteria) this;
        }

        public Criteria andStoreCheckCardLessThanOrEqualTo(String value) {
            addCriterion("store_check_card <=", value, "storeCheckCard");
            return (Criteria) this;
        }

        public Criteria andStoreCheckCardLike(String value) {
            addCriterion("store_check_card like", value, "storeCheckCard");
            return (Criteria) this;
        }

        public Criteria andStoreCheckCardNotLike(String value) {
            addCriterion("store_check_card not like", value, "storeCheckCard");
            return (Criteria) this;
        }

        public Criteria andStoreCheckCardIn(List<String> values) {
            addCriterion("store_check_card in", values, "storeCheckCard");
            return (Criteria) this;
        }

        public Criteria andStoreCheckCardNotIn(List<String> values) {
            addCriterion("store_check_card not in", values, "storeCheckCard");
            return (Criteria) this;
        }

        public Criteria andStoreCheckCardBetween(String value1, String value2) {
            addCriterion("store_check_card between", value1, value2, "storeCheckCard");
            return (Criteria) this;
        }

        public Criteria andStoreCheckCardNotBetween(String value1, String value2) {
            addCriterion("store_check_card not between", value1, value2, "storeCheckCard");
            return (Criteria) this;
        }

        public Criteria andStoreCheckZfbIsNull() {
            addCriterion("store_check_zfb is null");
            return (Criteria) this;
        }

        public Criteria andStoreCheckZfbIsNotNull() {
            addCriterion("store_check_zfb is not null");
            return (Criteria) this;
        }

        public Criteria andStoreCheckZfbEqualTo(String value) {
            addCriterion("store_check_zfb =", value, "storeCheckZfb");
            return (Criteria) this;
        }

        public Criteria andStoreCheckZfbNotEqualTo(String value) {
            addCriterion("store_check_zfb <>", value, "storeCheckZfb");
            return (Criteria) this;
        }

        public Criteria andStoreCheckZfbGreaterThan(String value) {
            addCriterion("store_check_zfb >", value, "storeCheckZfb");
            return (Criteria) this;
        }

        public Criteria andStoreCheckZfbGreaterThanOrEqualTo(String value) {
            addCriterion("store_check_zfb >=", value, "storeCheckZfb");
            return (Criteria) this;
        }

        public Criteria andStoreCheckZfbLessThan(String value) {
            addCriterion("store_check_zfb <", value, "storeCheckZfb");
            return (Criteria) this;
        }

        public Criteria andStoreCheckZfbLessThanOrEqualTo(String value) {
            addCriterion("store_check_zfb <=", value, "storeCheckZfb");
            return (Criteria) this;
        }

        public Criteria andStoreCheckZfbLike(String value) {
            addCriterion("store_check_zfb like", value, "storeCheckZfb");
            return (Criteria) this;
        }

        public Criteria andStoreCheckZfbNotLike(String value) {
            addCriterion("store_check_zfb not like", value, "storeCheckZfb");
            return (Criteria) this;
        }

        public Criteria andStoreCheckZfbIn(List<String> values) {
            addCriterion("store_check_zfb in", values, "storeCheckZfb");
            return (Criteria) this;
        }

        public Criteria andStoreCheckZfbNotIn(List<String> values) {
            addCriterion("store_check_zfb not in", values, "storeCheckZfb");
            return (Criteria) this;
        }

        public Criteria andStoreCheckZfbBetween(String value1, String value2) {
            addCriterion("store_check_zfb between", value1, value2, "storeCheckZfb");
            return (Criteria) this;
        }

        public Criteria andStoreCheckZfbNotBetween(String value1, String value2) {
            addCriterion("store_check_zfb not between", value1, value2, "storeCheckZfb");
            return (Criteria) this;
        }

        public Criteria andStoreCheckUserIdIsNull() {
            addCriterion("store_check_user_id is null");
            return (Criteria) this;
        }

        public Criteria andStoreCheckUserIdIsNotNull() {
            addCriterion("store_check_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andStoreCheckUserIdEqualTo(Integer value) {
            addCriterion("store_check_user_id =", value, "storeCheckUserId");
            return (Criteria) this;
        }

        public Criteria andStoreCheckUserIdNotEqualTo(Integer value) {
            addCriterion("store_check_user_id <>", value, "storeCheckUserId");
            return (Criteria) this;
        }

        public Criteria andStoreCheckUserIdGreaterThan(Integer value) {
            addCriterion("store_check_user_id >", value, "storeCheckUserId");
            return (Criteria) this;
        }

        public Criteria andStoreCheckUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_check_user_id >=", value, "storeCheckUserId");
            return (Criteria) this;
        }

        public Criteria andStoreCheckUserIdLessThan(Integer value) {
            addCriterion("store_check_user_id <", value, "storeCheckUserId");
            return (Criteria) this;
        }

        public Criteria andStoreCheckUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("store_check_user_id <=", value, "storeCheckUserId");
            return (Criteria) this;
        }

        public Criteria andStoreCheckUserIdIn(List<Integer> values) {
            addCriterion("store_check_user_id in", values, "storeCheckUserId");
            return (Criteria) this;
        }

        public Criteria andStoreCheckUserIdNotIn(List<Integer> values) {
            addCriterion("store_check_user_id not in", values, "storeCheckUserId");
            return (Criteria) this;
        }

        public Criteria andStoreCheckUserIdBetween(Integer value1, Integer value2) {
            addCriterion("store_check_user_id between", value1, value2, "storeCheckUserId");
            return (Criteria) this;
        }

        public Criteria andStoreCheckUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("store_check_user_id not between", value1, value2, "storeCheckUserId");
            return (Criteria) this;
        }

        public Criteria andStoreCheckUsernameIsNull() {
            addCriterion("store_check_username is null");
            return (Criteria) this;
        }

        public Criteria andStoreCheckUsernameIsNotNull() {
            addCriterion("store_check_username is not null");
            return (Criteria) this;
        }

        public Criteria andStoreCheckUsernameEqualTo(String value) {
            addCriterion("store_check_username =", value, "storeCheckUsername");
            return (Criteria) this;
        }

        public Criteria andStoreCheckUsernameNotEqualTo(String value) {
            addCriterion("store_check_username <>", value, "storeCheckUsername");
            return (Criteria) this;
        }

        public Criteria andStoreCheckUsernameGreaterThan(String value) {
            addCriterion("store_check_username >", value, "storeCheckUsername");
            return (Criteria) this;
        }

        public Criteria andStoreCheckUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("store_check_username >=", value, "storeCheckUsername");
            return (Criteria) this;
        }

        public Criteria andStoreCheckUsernameLessThan(String value) {
            addCriterion("store_check_username <", value, "storeCheckUsername");
            return (Criteria) this;
        }

        public Criteria andStoreCheckUsernameLessThanOrEqualTo(String value) {
            addCriterion("store_check_username <=", value, "storeCheckUsername");
            return (Criteria) this;
        }

        public Criteria andStoreCheckUsernameLike(String value) {
            addCriterion("store_check_username like", value, "storeCheckUsername");
            return (Criteria) this;
        }

        public Criteria andStoreCheckUsernameNotLike(String value) {
            addCriterion("store_check_username not like", value, "storeCheckUsername");
            return (Criteria) this;
        }

        public Criteria andStoreCheckUsernameIn(List<String> values) {
            addCriterion("store_check_username in", values, "storeCheckUsername");
            return (Criteria) this;
        }

        public Criteria andStoreCheckUsernameNotIn(List<String> values) {
            addCriterion("store_check_username not in", values, "storeCheckUsername");
            return (Criteria) this;
        }

        public Criteria andStoreCheckUsernameBetween(String value1, String value2) {
            addCriterion("store_check_username between", value1, value2, "storeCheckUsername");
            return (Criteria) this;
        }

        public Criteria andStoreCheckUsernameNotBetween(String value1, String value2) {
            addCriterion("store_check_username not between", value1, value2, "storeCheckUsername");
            return (Criteria) this;
        }

        public Criteria andStoreCheckStateIsNull() {
            addCriterion("store_check_state is null");
            return (Criteria) this;
        }

        public Criteria andStoreCheckStateIsNotNull() {
            addCriterion("store_check_state is not null");
            return (Criteria) this;
        }

        public Criteria andStoreCheckStateEqualTo(Integer value) {
            addCriterion("store_check_state =", value, "storeCheckState");
            return (Criteria) this;
        }

        public Criteria andStoreCheckStateNotEqualTo(Integer value) {
            addCriterion("store_check_state <>", value, "storeCheckState");
            return (Criteria) this;
        }

        public Criteria andStoreCheckStateGreaterThan(Integer value) {
            addCriterion("store_check_state >", value, "storeCheckState");
            return (Criteria) this;
        }

        public Criteria andStoreCheckStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_check_state >=", value, "storeCheckState");
            return (Criteria) this;
        }

        public Criteria andStoreCheckStateLessThan(Integer value) {
            addCriterion("store_check_state <", value, "storeCheckState");
            return (Criteria) this;
        }

        public Criteria andStoreCheckStateLessThanOrEqualTo(Integer value) {
            addCriterion("store_check_state <=", value, "storeCheckState");
            return (Criteria) this;
        }

        public Criteria andStoreCheckStateIn(List<Integer> values) {
            addCriterion("store_check_state in", values, "storeCheckState");
            return (Criteria) this;
        }

        public Criteria andStoreCheckStateNotIn(List<Integer> values) {
            addCriterion("store_check_state not in", values, "storeCheckState");
            return (Criteria) this;
        }

        public Criteria andStoreCheckStateBetween(Integer value1, Integer value2) {
            addCriterion("store_check_state between", value1, value2, "storeCheckState");
            return (Criteria) this;
        }

        public Criteria andStoreCheckStateNotBetween(Integer value1, Integer value2) {
            addCriterion("store_check_state not between", value1, value2, "storeCheckState");
            return (Criteria) this;
        }

        public Criteria andStoreCheckDisposeIdIsNull() {
            addCriterion("store_check_dispose_id is null");
            return (Criteria) this;
        }

        public Criteria andStoreCheckDisposeIdIsNotNull() {
            addCriterion("store_check_dispose_id is not null");
            return (Criteria) this;
        }

        public Criteria andStoreCheckDisposeIdEqualTo(Integer value) {
            addCriterion("store_check_dispose_id =", value, "storeCheckDisposeId");
            return (Criteria) this;
        }

        public Criteria andStoreCheckDisposeIdNotEqualTo(Integer value) {
            addCriterion("store_check_dispose_id <>", value, "storeCheckDisposeId");
            return (Criteria) this;
        }

        public Criteria andStoreCheckDisposeIdGreaterThan(Integer value) {
            addCriterion("store_check_dispose_id >", value, "storeCheckDisposeId");
            return (Criteria) this;
        }

        public Criteria andStoreCheckDisposeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_check_dispose_id >=", value, "storeCheckDisposeId");
            return (Criteria) this;
        }

        public Criteria andStoreCheckDisposeIdLessThan(Integer value) {
            addCriterion("store_check_dispose_id <", value, "storeCheckDisposeId");
            return (Criteria) this;
        }

        public Criteria andStoreCheckDisposeIdLessThanOrEqualTo(Integer value) {
            addCriterion("store_check_dispose_id <=", value, "storeCheckDisposeId");
            return (Criteria) this;
        }

        public Criteria andStoreCheckDisposeIdIn(List<Integer> values) {
            addCriterion("store_check_dispose_id in", values, "storeCheckDisposeId");
            return (Criteria) this;
        }

        public Criteria andStoreCheckDisposeIdNotIn(List<Integer> values) {
            addCriterion("store_check_dispose_id not in", values, "storeCheckDisposeId");
            return (Criteria) this;
        }

        public Criteria andStoreCheckDisposeIdBetween(Integer value1, Integer value2) {
            addCriterion("store_check_dispose_id between", value1, value2, "storeCheckDisposeId");
            return (Criteria) this;
        }

        public Criteria andStoreCheckDisposeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("store_check_dispose_id not between", value1, value2, "storeCheckDisposeId");
            return (Criteria) this;
        }

        public Criteria andStoreCheckDisposeNameIsNull() {
            addCriterion("store_check_dispose_name is null");
            return (Criteria) this;
        }

        public Criteria andStoreCheckDisposeNameIsNotNull() {
            addCriterion("store_check_dispose_name is not null");
            return (Criteria) this;
        }

        public Criteria andStoreCheckDisposeNameEqualTo(String value) {
            addCriterion("store_check_dispose_name =", value, "storeCheckDisposeName");
            return (Criteria) this;
        }

        public Criteria andStoreCheckDisposeNameNotEqualTo(String value) {
            addCriterion("store_check_dispose_name <>", value, "storeCheckDisposeName");
            return (Criteria) this;
        }

        public Criteria andStoreCheckDisposeNameGreaterThan(String value) {
            addCriterion("store_check_dispose_name >", value, "storeCheckDisposeName");
            return (Criteria) this;
        }

        public Criteria andStoreCheckDisposeNameGreaterThanOrEqualTo(String value) {
            addCriterion("store_check_dispose_name >=", value, "storeCheckDisposeName");
            return (Criteria) this;
        }

        public Criteria andStoreCheckDisposeNameLessThan(String value) {
            addCriterion("store_check_dispose_name <", value, "storeCheckDisposeName");
            return (Criteria) this;
        }

        public Criteria andStoreCheckDisposeNameLessThanOrEqualTo(String value) {
            addCriterion("store_check_dispose_name <=", value, "storeCheckDisposeName");
            return (Criteria) this;
        }

        public Criteria andStoreCheckDisposeNameLike(String value) {
            addCriterion("store_check_dispose_name like", value, "storeCheckDisposeName");
            return (Criteria) this;
        }

        public Criteria andStoreCheckDisposeNameNotLike(String value) {
            addCriterion("store_check_dispose_name not like", value, "storeCheckDisposeName");
            return (Criteria) this;
        }

        public Criteria andStoreCheckDisposeNameIn(List<String> values) {
            addCriterion("store_check_dispose_name in", values, "storeCheckDisposeName");
            return (Criteria) this;
        }

        public Criteria andStoreCheckDisposeNameNotIn(List<String> values) {
            addCriterion("store_check_dispose_name not in", values, "storeCheckDisposeName");
            return (Criteria) this;
        }

        public Criteria andStoreCheckDisposeNameBetween(String value1, String value2) {
            addCriterion("store_check_dispose_name between", value1, value2, "storeCheckDisposeName");
            return (Criteria) this;
        }

        public Criteria andStoreCheckDisposeNameNotBetween(String value1, String value2) {
            addCriterion("store_check_dispose_name not between", value1, value2, "storeCheckDisposeName");
            return (Criteria) this;
        }

        public Criteria andStoreCheckCreateTimeIsNull() {
            addCriterion("store_check_create_time is null");
            return (Criteria) this;
        }

        public Criteria andStoreCheckCreateTimeIsNotNull() {
            addCriterion("store_check_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andStoreCheckCreateTimeEqualTo(Date value) {
            addCriterion("store_check_create_time =", value, "storeCheckCreateTime");
            return (Criteria) this;
        }

        public Criteria andStoreCheckCreateTimeNotEqualTo(Date value) {
            addCriterion("store_check_create_time <>", value, "storeCheckCreateTime");
            return (Criteria) this;
        }

        public Criteria andStoreCheckCreateTimeGreaterThan(Date value) {
            addCriterion("store_check_create_time >", value, "storeCheckCreateTime");
            return (Criteria) this;
        }

        public Criteria andStoreCheckCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("store_check_create_time >=", value, "storeCheckCreateTime");
            return (Criteria) this;
        }

        public Criteria andStoreCheckCreateTimeLessThan(Date value) {
            addCriterion("store_check_create_time <", value, "storeCheckCreateTime");
            return (Criteria) this;
        }

        public Criteria andStoreCheckCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("store_check_create_time <=", value, "storeCheckCreateTime");
            return (Criteria) this;
        }

        public Criteria andStoreCheckCreateTimeIn(List<Date> values) {
            addCriterion("store_check_create_time in", values, "storeCheckCreateTime");
            return (Criteria) this;
        }

        public Criteria andStoreCheckCreateTimeNotIn(List<Date> values) {
            addCriterion("store_check_create_time not in", values, "storeCheckCreateTime");
            return (Criteria) this;
        }

        public Criteria andStoreCheckCreateTimeBetween(Date value1, Date value2) {
            addCriterion("store_check_create_time between", value1, value2, "storeCheckCreateTime");
            return (Criteria) this;
        }

        public Criteria andStoreCheckCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("store_check_create_time not between", value1, value2, "storeCheckCreateTime");
            return (Criteria) this;
        }

        public Criteria andStoreCheckHandleTimeIsNull() {
            addCriterion("store_check_handle_time is null");
            return (Criteria) this;
        }

        public Criteria andStoreCheckHandleTimeIsNotNull() {
            addCriterion("store_check_handle_time is not null");
            return (Criteria) this;
        }

        public Criteria andStoreCheckHandleTimeEqualTo(Date value) {
            addCriterion("store_check_handle_time =", value, "storeCheckHandleTime");
            return (Criteria) this;
        }

        public Criteria andStoreCheckHandleTimeNotEqualTo(Date value) {
            addCriterion("store_check_handle_time <>", value, "storeCheckHandleTime");
            return (Criteria) this;
        }

        public Criteria andStoreCheckHandleTimeGreaterThan(Date value) {
            addCriterion("store_check_handle_time >", value, "storeCheckHandleTime");
            return (Criteria) this;
        }

        public Criteria andStoreCheckHandleTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("store_check_handle_time >=", value, "storeCheckHandleTime");
            return (Criteria) this;
        }

        public Criteria andStoreCheckHandleTimeLessThan(Date value) {
            addCriterion("store_check_handle_time <", value, "storeCheckHandleTime");
            return (Criteria) this;
        }

        public Criteria andStoreCheckHandleTimeLessThanOrEqualTo(Date value) {
            addCriterion("store_check_handle_time <=", value, "storeCheckHandleTime");
            return (Criteria) this;
        }

        public Criteria andStoreCheckHandleTimeIn(List<Date> values) {
            addCriterion("store_check_handle_time in", values, "storeCheckHandleTime");
            return (Criteria) this;
        }

        public Criteria andStoreCheckHandleTimeNotIn(List<Date> values) {
            addCriterion("store_check_handle_time not in", values, "storeCheckHandleTime");
            return (Criteria) this;
        }

        public Criteria andStoreCheckHandleTimeBetween(Date value1, Date value2) {
            addCriterion("store_check_handle_time between", value1, value2, "storeCheckHandleTime");
            return (Criteria) this;
        }

        public Criteria andStoreCheckHandleTimeNotBetween(Date value1, Date value2) {
            addCriterion("store_check_handle_time not between", value1, value2, "storeCheckHandleTime");
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
     * k2_store_check
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * k2_store_check 2019-09-02
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