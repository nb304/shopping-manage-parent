package com.king2.commons.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class K2PurchaseOrderExample {
    /**
     * k2_purchase_order
     */
    protected String orderByClause;

    /**
     * k2_purchase_order
     */
    protected boolean distinct;

    /**
     * k2_purchase_order
     */
    protected List<Criteria> oredCriteria;

    public K2PurchaseOrderExample() {
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
     * k2_purchase_order 2019-08-06
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

        public Criteria andPoIdIsNull() {
            addCriterion("po_id is null");
            return (Criteria) this;
        }

        public Criteria andPoIdIsNotNull() {
            addCriterion("po_id is not null");
            return (Criteria) this;
        }

        public Criteria andPoIdEqualTo(Integer value) {
            addCriterion("po_id =", value, "poId");
            return (Criteria) this;
        }

        public Criteria andPoIdNotEqualTo(Integer value) {
            addCriterion("po_id <>", value, "poId");
            return (Criteria) this;
        }

        public Criteria andPoIdGreaterThan(Integer value) {
            addCriterion("po_id >", value, "poId");
            return (Criteria) this;
        }

        public Criteria andPoIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("po_id >=", value, "poId");
            return (Criteria) this;
        }

        public Criteria andPoIdLessThan(Integer value) {
            addCriterion("po_id <", value, "poId");
            return (Criteria) this;
        }

        public Criteria andPoIdLessThanOrEqualTo(Integer value) {
            addCriterion("po_id <=", value, "poId");
            return (Criteria) this;
        }

        public Criteria andPoIdIn(List<Integer> values) {
            addCriterion("po_id in", values, "poId");
            return (Criteria) this;
        }

        public Criteria andPoIdNotIn(List<Integer> values) {
            addCriterion("po_id not in", values, "poId");
            return (Criteria) this;
        }

        public Criteria andPoIdBetween(Integer value1, Integer value2) {
            addCriterion("po_id between", value1, value2, "poId");
            return (Criteria) this;
        }

        public Criteria andPoIdNotBetween(Integer value1, Integer value2) {
            addCriterion("po_id not between", value1, value2, "poId");
            return (Criteria) this;
        }

        public Criteria andPoNumberIsNull() {
            addCriterion("po_number is null");
            return (Criteria) this;
        }

        public Criteria andPoNumberIsNotNull() {
            addCriterion("po_number is not null");
            return (Criteria) this;
        }

        public Criteria andPoNumberEqualTo(String value) {
            addCriterion("po_number =", value, "poNumber");
            return (Criteria) this;
        }

        public Criteria andPoNumberNotEqualTo(String value) {
            addCriterion("po_number <>", value, "poNumber");
            return (Criteria) this;
        }

        public Criteria andPoNumberGreaterThan(String value) {
            addCriterion("po_number >", value, "poNumber");
            return (Criteria) this;
        }

        public Criteria andPoNumberGreaterThanOrEqualTo(String value) {
            addCriterion("po_number >=", value, "poNumber");
            return (Criteria) this;
        }

        public Criteria andPoNumberLessThan(String value) {
            addCriterion("po_number <", value, "poNumber");
            return (Criteria) this;
        }

        public Criteria andPoNumberLessThanOrEqualTo(String value) {
            addCriterion("po_number <=", value, "poNumber");
            return (Criteria) this;
        }

        public Criteria andPoNumberLike(String value) {
            addCriterion("po_number like", value, "poNumber");
            return (Criteria) this;
        }

        public Criteria andPoNumberNotLike(String value) {
            addCriterion("po_number not like", value, "poNumber");
            return (Criteria) this;
        }

        public Criteria andPoNumberIn(List<String> values) {
            addCriterion("po_number in", values, "poNumber");
            return (Criteria) this;
        }

        public Criteria andPoNumberNotIn(List<String> values) {
            addCriterion("po_number not in", values, "poNumber");
            return (Criteria) this;
        }

        public Criteria andPoNumberBetween(String value1, String value2) {
            addCriterion("po_number between", value1, value2, "poNumber");
            return (Criteria) this;
        }

        public Criteria andPoNumberNotBetween(String value1, String value2) {
            addCriterion("po_number not between", value1, value2, "poNumber");
            return (Criteria) this;
        }

        public Criteria andPoNameIsNull() {
            addCriterion("po_name is null");
            return (Criteria) this;
        }

        public Criteria andPoNameIsNotNull() {
            addCriterion("po_name is not null");
            return (Criteria) this;
        }

        public Criteria andPoNameEqualTo(String value) {
            addCriterion("po_name =", value, "poName");
            return (Criteria) this;
        }

        public Criteria andPoNameNotEqualTo(String value) {
            addCriterion("po_name <>", value, "poName");
            return (Criteria) this;
        }

        public Criteria andPoNameGreaterThan(String value) {
            addCriterion("po_name >", value, "poName");
            return (Criteria) this;
        }

        public Criteria andPoNameGreaterThanOrEqualTo(String value) {
            addCriterion("po_name >=", value, "poName");
            return (Criteria) this;
        }

        public Criteria andPoNameLessThan(String value) {
            addCriterion("po_name <", value, "poName");
            return (Criteria) this;
        }

        public Criteria andPoNameLessThanOrEqualTo(String value) {
            addCriterion("po_name <=", value, "poName");
            return (Criteria) this;
        }

        public Criteria andPoNameLike(String value) {
            addCriterion("po_name like", value, "poName");
            return (Criteria) this;
        }

        public Criteria andPoNameNotLike(String value) {
            addCriterion("po_name not like", value, "poName");
            return (Criteria) this;
        }

        public Criteria andPoNameIn(List<String> values) {
            addCriterion("po_name in", values, "poName");
            return (Criteria) this;
        }

        public Criteria andPoNameNotIn(List<String> values) {
            addCriterion("po_name not in", values, "poName");
            return (Criteria) this;
        }

        public Criteria andPoNameBetween(String value1, String value2) {
            addCriterion("po_name between", value1, value2, "poName");
            return (Criteria) this;
        }

        public Criteria andPoNameNotBetween(String value1, String value2) {
            addCriterion("po_name not between", value1, value2, "poName");
            return (Criteria) this;
        }

        public Criteria andPoDescIsNull() {
            addCriterion("po_desc is null");
            return (Criteria) this;
        }

        public Criteria andPoDescIsNotNull() {
            addCriterion("po_desc is not null");
            return (Criteria) this;
        }

        public Criteria andPoDescEqualTo(String value) {
            addCriterion("po_desc =", value, "poDesc");
            return (Criteria) this;
        }

        public Criteria andPoDescNotEqualTo(String value) {
            addCriterion("po_desc <>", value, "poDesc");
            return (Criteria) this;
        }

        public Criteria andPoDescGreaterThan(String value) {
            addCriterion("po_desc >", value, "poDesc");
            return (Criteria) this;
        }

        public Criteria andPoDescGreaterThanOrEqualTo(String value) {
            addCriterion("po_desc >=", value, "poDesc");
            return (Criteria) this;
        }

        public Criteria andPoDescLessThan(String value) {
            addCriterion("po_desc <", value, "poDesc");
            return (Criteria) this;
        }

        public Criteria andPoDescLessThanOrEqualTo(String value) {
            addCriterion("po_desc <=", value, "poDesc");
            return (Criteria) this;
        }

        public Criteria andPoDescLike(String value) {
            addCriterion("po_desc like", value, "poDesc");
            return (Criteria) this;
        }

        public Criteria andPoDescNotLike(String value) {
            addCriterion("po_desc not like", value, "poDesc");
            return (Criteria) this;
        }

        public Criteria andPoDescIn(List<String> values) {
            addCriterion("po_desc in", values, "poDesc");
            return (Criteria) this;
        }

        public Criteria andPoDescNotIn(List<String> values) {
            addCriterion("po_desc not in", values, "poDesc");
            return (Criteria) this;
        }

        public Criteria andPoDescBetween(String value1, String value2) {
            addCriterion("po_desc between", value1, value2, "poDesc");
            return (Criteria) this;
        }

        public Criteria andPoDescNotBetween(String value1, String value2) {
            addCriterion("po_desc not between", value1, value2, "poDesc");
            return (Criteria) this;
        }

        public Criteria andPoTimeIsNull() {
            addCriterion("po_time is null");
            return (Criteria) this;
        }

        public Criteria andPoTimeIsNotNull() {
            addCriterion("po_time is not null");
            return (Criteria) this;
        }

        public Criteria andPoTimeEqualTo(Date value) {
            addCriterion("po_time =", value, "poTime");
            return (Criteria) this;
        }

        public Criteria andPoTimeNotEqualTo(Date value) {
            addCriterion("po_time <>", value, "poTime");
            return (Criteria) this;
        }

        public Criteria andPoTimeGreaterThan(Date value) {
            addCriterion("po_time >", value, "poTime");
            return (Criteria) this;
        }

        public Criteria andPoTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("po_time >=", value, "poTime");
            return (Criteria) this;
        }

        public Criteria andPoTimeLessThan(Date value) {
            addCriterion("po_time <", value, "poTime");
            return (Criteria) this;
        }

        public Criteria andPoTimeLessThanOrEqualTo(Date value) {
            addCriterion("po_time <=", value, "poTime");
            return (Criteria) this;
        }

        public Criteria andPoTimeIn(List<Date> values) {
            addCriterion("po_time in", values, "poTime");
            return (Criteria) this;
        }

        public Criteria andPoTimeNotIn(List<Date> values) {
            addCriterion("po_time not in", values, "poTime");
            return (Criteria) this;
        }

        public Criteria andPoTimeBetween(Date value1, Date value2) {
            addCriterion("po_time between", value1, value2, "poTime");
            return (Criteria) this;
        }

        public Criteria andPoTimeNotBetween(Date value1, Date value2) {
            addCriterion("po_time not between", value1, value2, "poTime");
            return (Criteria) this;
        }

        public Criteria andPoCountNumberIsNull() {
            addCriterion("po_count_number is null");
            return (Criteria) this;
        }

        public Criteria andPoCountNumberIsNotNull() {
            addCriterion("po_count_number is not null");
            return (Criteria) this;
        }

        public Criteria andPoCountNumberEqualTo(Integer value) {
            addCriterion("po_count_number =", value, "poCountNumber");
            return (Criteria) this;
        }

        public Criteria andPoCountNumberNotEqualTo(Integer value) {
            addCriterion("po_count_number <>", value, "poCountNumber");
            return (Criteria) this;
        }

        public Criteria andPoCountNumberGreaterThan(Integer value) {
            addCriterion("po_count_number >", value, "poCountNumber");
            return (Criteria) this;
        }

        public Criteria andPoCountNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("po_count_number >=", value, "poCountNumber");
            return (Criteria) this;
        }

        public Criteria andPoCountNumberLessThan(Integer value) {
            addCriterion("po_count_number <", value, "poCountNumber");
            return (Criteria) this;
        }

        public Criteria andPoCountNumberLessThanOrEqualTo(Integer value) {
            addCriterion("po_count_number <=", value, "poCountNumber");
            return (Criteria) this;
        }

        public Criteria andPoCountNumberIn(List<Integer> values) {
            addCriterion("po_count_number in", values, "poCountNumber");
            return (Criteria) this;
        }

        public Criteria andPoCountNumberNotIn(List<Integer> values) {
            addCriterion("po_count_number not in", values, "poCountNumber");
            return (Criteria) this;
        }

        public Criteria andPoCountNumberBetween(Integer value1, Integer value2) {
            addCriterion("po_count_number between", value1, value2, "poCountNumber");
            return (Criteria) this;
        }

        public Criteria andPoCountNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("po_count_number not between", value1, value2, "poCountNumber");
            return (Criteria) this;
        }

        public Criteria andPoCountPriceIsNull() {
            addCriterion("po_count_price is null");
            return (Criteria) this;
        }

        public Criteria andPoCountPriceIsNotNull() {
            addCriterion("po_count_price is not null");
            return (Criteria) this;
        }

        public Criteria andPoCountPriceEqualTo(BigDecimal value) {
            addCriterion("po_count_price =", value, "poCountPrice");
            return (Criteria) this;
        }

        public Criteria andPoCountPriceNotEqualTo(BigDecimal value) {
            addCriterion("po_count_price <>", value, "poCountPrice");
            return (Criteria) this;
        }

        public Criteria andPoCountPriceGreaterThan(BigDecimal value) {
            addCriterion("po_count_price >", value, "poCountPrice");
            return (Criteria) this;
        }

        public Criteria andPoCountPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("po_count_price >=", value, "poCountPrice");
            return (Criteria) this;
        }

        public Criteria andPoCountPriceLessThan(BigDecimal value) {
            addCriterion("po_count_price <", value, "poCountPrice");
            return (Criteria) this;
        }

        public Criteria andPoCountPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("po_count_price <=", value, "poCountPrice");
            return (Criteria) this;
        }

        public Criteria andPoCountPriceIn(List<BigDecimal> values) {
            addCriterion("po_count_price in", values, "poCountPrice");
            return (Criteria) this;
        }

        public Criteria andPoCountPriceNotIn(List<BigDecimal> values) {
            addCriterion("po_count_price not in", values, "poCountPrice");
            return (Criteria) this;
        }

        public Criteria andPoCountPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("po_count_price between", value1, value2, "poCountPrice");
            return (Criteria) this;
        }

        public Criteria andPoCountPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("po_count_price not between", value1, value2, "poCountPrice");
            return (Criteria) this;
        }

        public Criteria andPoAddressIsNull() {
            addCriterion("po_address is null");
            return (Criteria) this;
        }

        public Criteria andPoAddressIsNotNull() {
            addCriterion("po_address is not null");
            return (Criteria) this;
        }

        public Criteria andPoAddressEqualTo(String value) {
            addCriterion("po_address =", value, "poAddress");
            return (Criteria) this;
        }

        public Criteria andPoAddressNotEqualTo(String value) {
            addCriterion("po_address <>", value, "poAddress");
            return (Criteria) this;
        }

        public Criteria andPoAddressGreaterThan(String value) {
            addCriterion("po_address >", value, "poAddress");
            return (Criteria) this;
        }

        public Criteria andPoAddressGreaterThanOrEqualTo(String value) {
            addCriterion("po_address >=", value, "poAddress");
            return (Criteria) this;
        }

        public Criteria andPoAddressLessThan(String value) {
            addCriterion("po_address <", value, "poAddress");
            return (Criteria) this;
        }

        public Criteria andPoAddressLessThanOrEqualTo(String value) {
            addCriterion("po_address <=", value, "poAddress");
            return (Criteria) this;
        }

        public Criteria andPoAddressLike(String value) {
            addCriterion("po_address like", value, "poAddress");
            return (Criteria) this;
        }

        public Criteria andPoAddressNotLike(String value) {
            addCriterion("po_address not like", value, "poAddress");
            return (Criteria) this;
        }

        public Criteria andPoAddressIn(List<String> values) {
            addCriterion("po_address in", values, "poAddress");
            return (Criteria) this;
        }

        public Criteria andPoAddressNotIn(List<String> values) {
            addCriterion("po_address not in", values, "poAddress");
            return (Criteria) this;
        }

        public Criteria andPoAddressBetween(String value1, String value2) {
            addCriterion("po_address between", value1, value2, "poAddress");
            return (Criteria) this;
        }

        public Criteria andPoAddressNotBetween(String value1, String value2) {
            addCriterion("po_address not between", value1, value2, "poAddress");
            return (Criteria) this;
        }

        public Criteria andPoFactoryNameIsNull() {
            addCriterion("po_factory_name is null");
            return (Criteria) this;
        }

        public Criteria andPoFactoryNameIsNotNull() {
            addCriterion("po_factory_name is not null");
            return (Criteria) this;
        }

        public Criteria andPoFactoryNameEqualTo(String value) {
            addCriterion("po_factory_name =", value, "poFactoryName");
            return (Criteria) this;
        }

        public Criteria andPoFactoryNameNotEqualTo(String value) {
            addCriterion("po_factory_name <>", value, "poFactoryName");
            return (Criteria) this;
        }

        public Criteria andPoFactoryNameGreaterThan(String value) {
            addCriterion("po_factory_name >", value, "poFactoryName");
            return (Criteria) this;
        }

        public Criteria andPoFactoryNameGreaterThanOrEqualTo(String value) {
            addCriterion("po_factory_name >=", value, "poFactoryName");
            return (Criteria) this;
        }

        public Criteria andPoFactoryNameLessThan(String value) {
            addCriterion("po_factory_name <", value, "poFactoryName");
            return (Criteria) this;
        }

        public Criteria andPoFactoryNameLessThanOrEqualTo(String value) {
            addCriterion("po_factory_name <=", value, "poFactoryName");
            return (Criteria) this;
        }

        public Criteria andPoFactoryNameLike(String value) {
            addCriterion("po_factory_name like", value, "poFactoryName");
            return (Criteria) this;
        }

        public Criteria andPoFactoryNameNotLike(String value) {
            addCriterion("po_factory_name not like", value, "poFactoryName");
            return (Criteria) this;
        }

        public Criteria andPoFactoryNameIn(List<String> values) {
            addCriterion("po_factory_name in", values, "poFactoryName");
            return (Criteria) this;
        }

        public Criteria andPoFactoryNameNotIn(List<String> values) {
            addCriterion("po_factory_name not in", values, "poFactoryName");
            return (Criteria) this;
        }

        public Criteria andPoFactoryNameBetween(String value1, String value2) {
            addCriterion("po_factory_name between", value1, value2, "poFactoryName");
            return (Criteria) this;
        }

        public Criteria andPoFactoryNameNotBetween(String value1, String value2) {
            addCriterion("po_factory_name not between", value1, value2, "poFactoryName");
            return (Criteria) this;
        }

        public Criteria andPoFactoryPhoneIsNull() {
            addCriterion("po_factory_phone is null");
            return (Criteria) this;
        }

        public Criteria andPoFactoryPhoneIsNotNull() {
            addCriterion("po_factory_phone is not null");
            return (Criteria) this;
        }

        public Criteria andPoFactoryPhoneEqualTo(String value) {
            addCriterion("po_factory_phone =", value, "poFactoryPhone");
            return (Criteria) this;
        }

        public Criteria andPoFactoryPhoneNotEqualTo(String value) {
            addCriterion("po_factory_phone <>", value, "poFactoryPhone");
            return (Criteria) this;
        }

        public Criteria andPoFactoryPhoneGreaterThan(String value) {
            addCriterion("po_factory_phone >", value, "poFactoryPhone");
            return (Criteria) this;
        }

        public Criteria andPoFactoryPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("po_factory_phone >=", value, "poFactoryPhone");
            return (Criteria) this;
        }

        public Criteria andPoFactoryPhoneLessThan(String value) {
            addCriterion("po_factory_phone <", value, "poFactoryPhone");
            return (Criteria) this;
        }

        public Criteria andPoFactoryPhoneLessThanOrEqualTo(String value) {
            addCriterion("po_factory_phone <=", value, "poFactoryPhone");
            return (Criteria) this;
        }

        public Criteria andPoFactoryPhoneLike(String value) {
            addCriterion("po_factory_phone like", value, "poFactoryPhone");
            return (Criteria) this;
        }

        public Criteria andPoFactoryPhoneNotLike(String value) {
            addCriterion("po_factory_phone not like", value, "poFactoryPhone");
            return (Criteria) this;
        }

        public Criteria andPoFactoryPhoneIn(List<String> values) {
            addCriterion("po_factory_phone in", values, "poFactoryPhone");
            return (Criteria) this;
        }

        public Criteria andPoFactoryPhoneNotIn(List<String> values) {
            addCriterion("po_factory_phone not in", values, "poFactoryPhone");
            return (Criteria) this;
        }

        public Criteria andPoFactoryPhoneBetween(String value1, String value2) {
            addCriterion("po_factory_phone between", value1, value2, "poFactoryPhone");
            return (Criteria) this;
        }

        public Criteria andPoFactoryPhoneNotBetween(String value1, String value2) {
            addCriterion("po_factory_phone not between", value1, value2, "poFactoryPhone");
            return (Criteria) this;
        }

        public Criteria andMemberAccountIsNull() {
            addCriterion("member_account is null");
            return (Criteria) this;
        }

        public Criteria andMemberAccountIsNotNull() {
            addCriterion("member_account is not null");
            return (Criteria) this;
        }

        public Criteria andMemberAccountEqualTo(String value) {
            addCriterion("member_account =", value, "memberAccount");
            return (Criteria) this;
        }

        public Criteria andMemberAccountNotEqualTo(String value) {
            addCriterion("member_account <>", value, "memberAccount");
            return (Criteria) this;
        }

        public Criteria andMemberAccountGreaterThan(String value) {
            addCriterion("member_account >", value, "memberAccount");
            return (Criteria) this;
        }

        public Criteria andMemberAccountGreaterThanOrEqualTo(String value) {
            addCriterion("member_account >=", value, "memberAccount");
            return (Criteria) this;
        }

        public Criteria andMemberAccountLessThan(String value) {
            addCriterion("member_account <", value, "memberAccount");
            return (Criteria) this;
        }

        public Criteria andMemberAccountLessThanOrEqualTo(String value) {
            addCriterion("member_account <=", value, "memberAccount");
            return (Criteria) this;
        }

        public Criteria andMemberAccountLike(String value) {
            addCriterion("member_account like", value, "memberAccount");
            return (Criteria) this;
        }

        public Criteria andMemberAccountNotLike(String value) {
            addCriterion("member_account not like", value, "memberAccount");
            return (Criteria) this;
        }

        public Criteria andMemberAccountIn(List<String> values) {
            addCriterion("member_account in", values, "memberAccount");
            return (Criteria) this;
        }

        public Criteria andMemberAccountNotIn(List<String> values) {
            addCriterion("member_account not in", values, "memberAccount");
            return (Criteria) this;
        }

        public Criteria andMemberAccountBetween(String value1, String value2) {
            addCriterion("member_account between", value1, value2, "memberAccount");
            return (Criteria) this;
        }

        public Criteria andMemberAccountNotBetween(String value1, String value2) {
            addCriterion("member_account not between", value1, value2, "memberAccount");
            return (Criteria) this;
        }

        public Criteria andMemberNameIsNull() {
            addCriterion("member_name is null");
            return (Criteria) this;
        }

        public Criteria andMemberNameIsNotNull() {
            addCriterion("member_name is not null");
            return (Criteria) this;
        }

        public Criteria andMemberNameEqualTo(String value) {
            addCriterion("member_name =", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameNotEqualTo(String value) {
            addCriterion("member_name <>", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameGreaterThan(String value) {
            addCriterion("member_name >", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameGreaterThanOrEqualTo(String value) {
            addCriterion("member_name >=", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameLessThan(String value) {
            addCriterion("member_name <", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameLessThanOrEqualTo(String value) {
            addCriterion("member_name <=", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameLike(String value) {
            addCriterion("member_name like", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameNotLike(String value) {
            addCriterion("member_name not like", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameIn(List<String> values) {
            addCriterion("member_name in", values, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameNotIn(List<String> values) {
            addCriterion("member_name not in", values, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameBetween(String value1, String value2) {
            addCriterion("member_name between", value1, value2, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameNotBetween(String value1, String value2) {
            addCriterion("member_name not between", value1, value2, "memberName");
            return (Criteria) this;
        }

        public Criteria andPoCreateTimeIsNull() {
            addCriterion("po_create_time is null");
            return (Criteria) this;
        }

        public Criteria andPoCreateTimeIsNotNull() {
            addCriterion("po_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andPoCreateTimeEqualTo(Date value) {
            addCriterion("po_create_time =", value, "poCreateTime");
            return (Criteria) this;
        }

        public Criteria andPoCreateTimeNotEqualTo(Date value) {
            addCriterion("po_create_time <>", value, "poCreateTime");
            return (Criteria) this;
        }

        public Criteria andPoCreateTimeGreaterThan(Date value) {
            addCriterion("po_create_time >", value, "poCreateTime");
            return (Criteria) this;
        }

        public Criteria andPoCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("po_create_time >=", value, "poCreateTime");
            return (Criteria) this;
        }

        public Criteria andPoCreateTimeLessThan(Date value) {
            addCriterion("po_create_time <", value, "poCreateTime");
            return (Criteria) this;
        }

        public Criteria andPoCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("po_create_time <=", value, "poCreateTime");
            return (Criteria) this;
        }

        public Criteria andPoCreateTimeIn(List<Date> values) {
            addCriterion("po_create_time in", values, "poCreateTime");
            return (Criteria) this;
        }

        public Criteria andPoCreateTimeNotIn(List<Date> values) {
            addCriterion("po_create_time not in", values, "poCreateTime");
            return (Criteria) this;
        }

        public Criteria andPoCreateTimeBetween(Date value1, Date value2) {
            addCriterion("po_create_time between", value1, value2, "poCreateTime");
            return (Criteria) this;
        }

        public Criteria andPoCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("po_create_time not between", value1, value2, "poCreateTime");
            return (Criteria) this;
        }

        public Criteria andPoDelFlagIsNull() {
            addCriterion("po_del_flag is null");
            return (Criteria) this;
        }

        public Criteria andPoDelFlagIsNotNull() {
            addCriterion("po_del_flag is not null");
            return (Criteria) this;
        }

        public Criteria andPoDelFlagEqualTo(Integer value) {
            addCriterion("po_del_flag =", value, "poDelFlag");
            return (Criteria) this;
        }

        public Criteria andPoDelFlagNotEqualTo(Integer value) {
            addCriterion("po_del_flag <>", value, "poDelFlag");
            return (Criteria) this;
        }

        public Criteria andPoDelFlagGreaterThan(Integer value) {
            addCriterion("po_del_flag >", value, "poDelFlag");
            return (Criteria) this;
        }

        public Criteria andPoDelFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("po_del_flag >=", value, "poDelFlag");
            return (Criteria) this;
        }

        public Criteria andPoDelFlagLessThan(Integer value) {
            addCriterion("po_del_flag <", value, "poDelFlag");
            return (Criteria) this;
        }

        public Criteria andPoDelFlagLessThanOrEqualTo(Integer value) {
            addCriterion("po_del_flag <=", value, "poDelFlag");
            return (Criteria) this;
        }

        public Criteria andPoDelFlagIn(List<Integer> values) {
            addCriterion("po_del_flag in", values, "poDelFlag");
            return (Criteria) this;
        }

        public Criteria andPoDelFlagNotIn(List<Integer> values) {
            addCriterion("po_del_flag not in", values, "poDelFlag");
            return (Criteria) this;
        }

        public Criteria andPoDelFlagBetween(Integer value1, Integer value2) {
            addCriterion("po_del_flag between", value1, value2, "poDelFlag");
            return (Criteria) this;
        }

        public Criteria andPoDelFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("po_del_flag not between", value1, value2, "poDelFlag");
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
     * k2_purchase_order
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * k2_purchase_order 2019-08-06
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