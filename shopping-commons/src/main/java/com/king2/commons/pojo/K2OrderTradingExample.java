package com.king2.commons.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class K2OrderTradingExample {
    /**
     * k2_order_trading
     */
    protected String orderByClause;

    /**
     * k2_order_trading
     */
    protected boolean distinct;

    /**
     * k2_order_trading
     */
    protected List<Criteria> oredCriteria;

    public K2OrderTradingExample() {
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
     * k2_order_trading 2019-08-06
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

        public Criteria andTradingIdIsNull() {
            addCriterion("trading_id is null");
            return (Criteria) this;
        }

        public Criteria andTradingIdIsNotNull() {
            addCriterion("trading_id is not null");
            return (Criteria) this;
        }

        public Criteria andTradingIdEqualTo(Integer value) {
            addCriterion("trading_id =", value, "tradingId");
            return (Criteria) this;
        }

        public Criteria andTradingIdNotEqualTo(Integer value) {
            addCriterion("trading_id <>", value, "tradingId");
            return (Criteria) this;
        }

        public Criteria andTradingIdGreaterThan(Integer value) {
            addCriterion("trading_id >", value, "tradingId");
            return (Criteria) this;
        }

        public Criteria andTradingIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("trading_id >=", value, "tradingId");
            return (Criteria) this;
        }

        public Criteria andTradingIdLessThan(Integer value) {
            addCriterion("trading_id <", value, "tradingId");
            return (Criteria) this;
        }

        public Criteria andTradingIdLessThanOrEqualTo(Integer value) {
            addCriterion("trading_id <=", value, "tradingId");
            return (Criteria) this;
        }

        public Criteria andTradingIdIn(List<Integer> values) {
            addCriterion("trading_id in", values, "tradingId");
            return (Criteria) this;
        }

        public Criteria andTradingIdNotIn(List<Integer> values) {
            addCriterion("trading_id not in", values, "tradingId");
            return (Criteria) this;
        }

        public Criteria andTradingIdBetween(Integer value1, Integer value2) {
            addCriterion("trading_id between", value1, value2, "tradingId");
            return (Criteria) this;
        }

        public Criteria andTradingIdNotBetween(Integer value1, Integer value2) {
            addCriterion("trading_id not between", value1, value2, "tradingId");
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

        public Criteria andTradingNumberIsNull() {
            addCriterion("trading_number is null");
            return (Criteria) this;
        }

        public Criteria andTradingNumberIsNotNull() {
            addCriterion("trading_number is not null");
            return (Criteria) this;
        }

        public Criteria andTradingNumberEqualTo(String value) {
            addCriterion("trading_number =", value, "tradingNumber");
            return (Criteria) this;
        }

        public Criteria andTradingNumberNotEqualTo(String value) {
            addCriterion("trading_number <>", value, "tradingNumber");
            return (Criteria) this;
        }

        public Criteria andTradingNumberGreaterThan(String value) {
            addCriterion("trading_number >", value, "tradingNumber");
            return (Criteria) this;
        }

        public Criteria andTradingNumberGreaterThanOrEqualTo(String value) {
            addCriterion("trading_number >=", value, "tradingNumber");
            return (Criteria) this;
        }

        public Criteria andTradingNumberLessThan(String value) {
            addCriterion("trading_number <", value, "tradingNumber");
            return (Criteria) this;
        }

        public Criteria andTradingNumberLessThanOrEqualTo(String value) {
            addCriterion("trading_number <=", value, "tradingNumber");
            return (Criteria) this;
        }

        public Criteria andTradingNumberLike(String value) {
            addCriterion("trading_number like", value, "tradingNumber");
            return (Criteria) this;
        }

        public Criteria andTradingNumberNotLike(String value) {
            addCriterion("trading_number not like", value, "tradingNumber");
            return (Criteria) this;
        }

        public Criteria andTradingNumberIn(List<String> values) {
            addCriterion("trading_number in", values, "tradingNumber");
            return (Criteria) this;
        }

        public Criteria andTradingNumberNotIn(List<String> values) {
            addCriterion("trading_number not in", values, "tradingNumber");
            return (Criteria) this;
        }

        public Criteria andTradingNumberBetween(String value1, String value2) {
            addCriterion("trading_number between", value1, value2, "tradingNumber");
            return (Criteria) this;
        }

        public Criteria andTradingNumberNotBetween(String value1, String value2) {
            addCriterion("trading_number not between", value1, value2, "tradingNumber");
            return (Criteria) this;
        }

        public Criteria andTradingTypeIsNull() {
            addCriterion("trading_type is null");
            return (Criteria) this;
        }

        public Criteria andTradingTypeIsNotNull() {
            addCriterion("trading_type is not null");
            return (Criteria) this;
        }

        public Criteria andTradingTypeEqualTo(Integer value) {
            addCriterion("trading_type =", value, "tradingType");
            return (Criteria) this;
        }

        public Criteria andTradingTypeNotEqualTo(Integer value) {
            addCriterion("trading_type <>", value, "tradingType");
            return (Criteria) this;
        }

        public Criteria andTradingTypeGreaterThan(Integer value) {
            addCriterion("trading_type >", value, "tradingType");
            return (Criteria) this;
        }

        public Criteria andTradingTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("trading_type >=", value, "tradingType");
            return (Criteria) this;
        }

        public Criteria andTradingTypeLessThan(Integer value) {
            addCriterion("trading_type <", value, "tradingType");
            return (Criteria) this;
        }

        public Criteria andTradingTypeLessThanOrEqualTo(Integer value) {
            addCriterion("trading_type <=", value, "tradingType");
            return (Criteria) this;
        }

        public Criteria andTradingTypeIn(List<Integer> values) {
            addCriterion("trading_type in", values, "tradingType");
            return (Criteria) this;
        }

        public Criteria andTradingTypeNotIn(List<Integer> values) {
            addCriterion("trading_type not in", values, "tradingType");
            return (Criteria) this;
        }

        public Criteria andTradingTypeBetween(Integer value1, Integer value2) {
            addCriterion("trading_type between", value1, value2, "tradingType");
            return (Criteria) this;
        }

        public Criteria andTradingTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("trading_type not between", value1, value2, "tradingType");
            return (Criteria) this;
        }

        public Criteria andTradingMemberAccountIsNull() {
            addCriterion("trading_member_account is null");
            return (Criteria) this;
        }

        public Criteria andTradingMemberAccountIsNotNull() {
            addCriterion("trading_member_account is not null");
            return (Criteria) this;
        }

        public Criteria andTradingMemberAccountEqualTo(String value) {
            addCriterion("trading_member_account =", value, "tradingMemberAccount");
            return (Criteria) this;
        }

        public Criteria andTradingMemberAccountNotEqualTo(String value) {
            addCriterion("trading_member_account <>", value, "tradingMemberAccount");
            return (Criteria) this;
        }

        public Criteria andTradingMemberAccountGreaterThan(String value) {
            addCriterion("trading_member_account >", value, "tradingMemberAccount");
            return (Criteria) this;
        }

        public Criteria andTradingMemberAccountGreaterThanOrEqualTo(String value) {
            addCriterion("trading_member_account >=", value, "tradingMemberAccount");
            return (Criteria) this;
        }

        public Criteria andTradingMemberAccountLessThan(String value) {
            addCriterion("trading_member_account <", value, "tradingMemberAccount");
            return (Criteria) this;
        }

        public Criteria andTradingMemberAccountLessThanOrEqualTo(String value) {
            addCriterion("trading_member_account <=", value, "tradingMemberAccount");
            return (Criteria) this;
        }

        public Criteria andTradingMemberAccountLike(String value) {
            addCriterion("trading_member_account like", value, "tradingMemberAccount");
            return (Criteria) this;
        }

        public Criteria andTradingMemberAccountNotLike(String value) {
            addCriterion("trading_member_account not like", value, "tradingMemberAccount");
            return (Criteria) this;
        }

        public Criteria andTradingMemberAccountIn(List<String> values) {
            addCriterion("trading_member_account in", values, "tradingMemberAccount");
            return (Criteria) this;
        }

        public Criteria andTradingMemberAccountNotIn(List<String> values) {
            addCriterion("trading_member_account not in", values, "tradingMemberAccount");
            return (Criteria) this;
        }

        public Criteria andTradingMemberAccountBetween(String value1, String value2) {
            addCriterion("trading_member_account between", value1, value2, "tradingMemberAccount");
            return (Criteria) this;
        }

        public Criteria andTradingMemberAccountNotBetween(String value1, String value2) {
            addCriterion("trading_member_account not between", value1, value2, "tradingMemberAccount");
            return (Criteria) this;
        }

        public Criteria andTradingPriceIsNull() {
            addCriterion("trading_price is null");
            return (Criteria) this;
        }

        public Criteria andTradingPriceIsNotNull() {
            addCriterion("trading_price is not null");
            return (Criteria) this;
        }

        public Criteria andTradingPriceEqualTo(BigDecimal value) {
            addCriterion("trading_price =", value, "tradingPrice");
            return (Criteria) this;
        }

        public Criteria andTradingPriceNotEqualTo(BigDecimal value) {
            addCriterion("trading_price <>", value, "tradingPrice");
            return (Criteria) this;
        }

        public Criteria andTradingPriceGreaterThan(BigDecimal value) {
            addCriterion("trading_price >", value, "tradingPrice");
            return (Criteria) this;
        }

        public Criteria andTradingPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("trading_price >=", value, "tradingPrice");
            return (Criteria) this;
        }

        public Criteria andTradingPriceLessThan(BigDecimal value) {
            addCriterion("trading_price <", value, "tradingPrice");
            return (Criteria) this;
        }

        public Criteria andTradingPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("trading_price <=", value, "tradingPrice");
            return (Criteria) this;
        }

        public Criteria andTradingPriceIn(List<BigDecimal> values) {
            addCriterion("trading_price in", values, "tradingPrice");
            return (Criteria) this;
        }

        public Criteria andTradingPriceNotIn(List<BigDecimal> values) {
            addCriterion("trading_price not in", values, "tradingPrice");
            return (Criteria) this;
        }

        public Criteria andTradingPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("trading_price between", value1, value2, "tradingPrice");
            return (Criteria) this;
        }

        public Criteria andTradingPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("trading_price not between", value1, value2, "tradingPrice");
            return (Criteria) this;
        }

        public Criteria andTradingSourceIsNull() {
            addCriterion("trading_source is null");
            return (Criteria) this;
        }

        public Criteria andTradingSourceIsNotNull() {
            addCriterion("trading_source is not null");
            return (Criteria) this;
        }

        public Criteria andTradingSourceEqualTo(String value) {
            addCriterion("trading_source =", value, "tradingSource");
            return (Criteria) this;
        }

        public Criteria andTradingSourceNotEqualTo(String value) {
            addCriterion("trading_source <>", value, "tradingSource");
            return (Criteria) this;
        }

        public Criteria andTradingSourceGreaterThan(String value) {
            addCriterion("trading_source >", value, "tradingSource");
            return (Criteria) this;
        }

        public Criteria andTradingSourceGreaterThanOrEqualTo(String value) {
            addCriterion("trading_source >=", value, "tradingSource");
            return (Criteria) this;
        }

        public Criteria andTradingSourceLessThan(String value) {
            addCriterion("trading_source <", value, "tradingSource");
            return (Criteria) this;
        }

        public Criteria andTradingSourceLessThanOrEqualTo(String value) {
            addCriterion("trading_source <=", value, "tradingSource");
            return (Criteria) this;
        }

        public Criteria andTradingSourceLike(String value) {
            addCriterion("trading_source like", value, "tradingSource");
            return (Criteria) this;
        }

        public Criteria andTradingSourceNotLike(String value) {
            addCriterion("trading_source not like", value, "tradingSource");
            return (Criteria) this;
        }

        public Criteria andTradingSourceIn(List<String> values) {
            addCriterion("trading_source in", values, "tradingSource");
            return (Criteria) this;
        }

        public Criteria andTradingSourceNotIn(List<String> values) {
            addCriterion("trading_source not in", values, "tradingSource");
            return (Criteria) this;
        }

        public Criteria andTradingSourceBetween(String value1, String value2) {
            addCriterion("trading_source between", value1, value2, "tradingSource");
            return (Criteria) this;
        }

        public Criteria andTradingSourceNotBetween(String value1, String value2) {
            addCriterion("trading_source not between", value1, value2, "tradingSource");
            return (Criteria) this;
        }

        public Criteria andTradingCompletionTimeIsNull() {
            addCriterion("trading_completion_time is null");
            return (Criteria) this;
        }

        public Criteria andTradingCompletionTimeIsNotNull() {
            addCriterion("trading_completion_time is not null");
            return (Criteria) this;
        }

        public Criteria andTradingCompletionTimeEqualTo(Date value) {
            addCriterion("trading_completion_time =", value, "tradingCompletionTime");
            return (Criteria) this;
        }

        public Criteria andTradingCompletionTimeNotEqualTo(Date value) {
            addCriterion("trading_completion_time <>", value, "tradingCompletionTime");
            return (Criteria) this;
        }

        public Criteria andTradingCompletionTimeGreaterThan(Date value) {
            addCriterion("trading_completion_time >", value, "tradingCompletionTime");
            return (Criteria) this;
        }

        public Criteria andTradingCompletionTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("trading_completion_time >=", value, "tradingCompletionTime");
            return (Criteria) this;
        }

        public Criteria andTradingCompletionTimeLessThan(Date value) {
            addCriterion("trading_completion_time <", value, "tradingCompletionTime");
            return (Criteria) this;
        }

        public Criteria andTradingCompletionTimeLessThanOrEqualTo(Date value) {
            addCriterion("trading_completion_time <=", value, "tradingCompletionTime");
            return (Criteria) this;
        }

        public Criteria andTradingCompletionTimeIn(List<Date> values) {
            addCriterion("trading_completion_time in", values, "tradingCompletionTime");
            return (Criteria) this;
        }

        public Criteria andTradingCompletionTimeNotIn(List<Date> values) {
            addCriterion("trading_completion_time not in", values, "tradingCompletionTime");
            return (Criteria) this;
        }

        public Criteria andTradingCompletionTimeBetween(Date value1, Date value2) {
            addCriterion("trading_completion_time between", value1, value2, "tradingCompletionTime");
            return (Criteria) this;
        }

        public Criteria andTradingCompletionTimeNotBetween(Date value1, Date value2) {
            addCriterion("trading_completion_time not between", value1, value2, "tradingCompletionTime");
            return (Criteria) this;
        }

        public Criteria andTradingDescIsNull() {
            addCriterion("trading_desc is null");
            return (Criteria) this;
        }

        public Criteria andTradingDescIsNotNull() {
            addCriterion("trading_desc is not null");
            return (Criteria) this;
        }

        public Criteria andTradingDescEqualTo(String value) {
            addCriterion("trading_desc =", value, "tradingDesc");
            return (Criteria) this;
        }

        public Criteria andTradingDescNotEqualTo(String value) {
            addCriterion("trading_desc <>", value, "tradingDesc");
            return (Criteria) this;
        }

        public Criteria andTradingDescGreaterThan(String value) {
            addCriterion("trading_desc >", value, "tradingDesc");
            return (Criteria) this;
        }

        public Criteria andTradingDescGreaterThanOrEqualTo(String value) {
            addCriterion("trading_desc >=", value, "tradingDesc");
            return (Criteria) this;
        }

        public Criteria andTradingDescLessThan(String value) {
            addCriterion("trading_desc <", value, "tradingDesc");
            return (Criteria) this;
        }

        public Criteria andTradingDescLessThanOrEqualTo(String value) {
            addCriterion("trading_desc <=", value, "tradingDesc");
            return (Criteria) this;
        }

        public Criteria andTradingDescLike(String value) {
            addCriterion("trading_desc like", value, "tradingDesc");
            return (Criteria) this;
        }

        public Criteria andTradingDescNotLike(String value) {
            addCriterion("trading_desc not like", value, "tradingDesc");
            return (Criteria) this;
        }

        public Criteria andTradingDescIn(List<String> values) {
            addCriterion("trading_desc in", values, "tradingDesc");
            return (Criteria) this;
        }

        public Criteria andTradingDescNotIn(List<String> values) {
            addCriterion("trading_desc not in", values, "tradingDesc");
            return (Criteria) this;
        }

        public Criteria andTradingDescBetween(String value1, String value2) {
            addCriterion("trading_desc between", value1, value2, "tradingDesc");
            return (Criteria) this;
        }

        public Criteria andTradingDescNotBetween(String value1, String value2) {
            addCriterion("trading_desc not between", value1, value2, "tradingDesc");
            return (Criteria) this;
        }

        public Criteria andTradingCreateTimeIsNull() {
            addCriterion("trading_create_time is null");
            return (Criteria) this;
        }

        public Criteria andTradingCreateTimeIsNotNull() {
            addCriterion("trading_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andTradingCreateTimeEqualTo(Date value) {
            addCriterion("trading_create_time =", value, "tradingCreateTime");
            return (Criteria) this;
        }

        public Criteria andTradingCreateTimeNotEqualTo(Date value) {
            addCriterion("trading_create_time <>", value, "tradingCreateTime");
            return (Criteria) this;
        }

        public Criteria andTradingCreateTimeGreaterThan(Date value) {
            addCriterion("trading_create_time >", value, "tradingCreateTime");
            return (Criteria) this;
        }

        public Criteria andTradingCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("trading_create_time >=", value, "tradingCreateTime");
            return (Criteria) this;
        }

        public Criteria andTradingCreateTimeLessThan(Date value) {
            addCriterion("trading_create_time <", value, "tradingCreateTime");
            return (Criteria) this;
        }

        public Criteria andTradingCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("trading_create_time <=", value, "tradingCreateTime");
            return (Criteria) this;
        }

        public Criteria andTradingCreateTimeIn(List<Date> values) {
            addCriterion("trading_create_time in", values, "tradingCreateTime");
            return (Criteria) this;
        }

        public Criteria andTradingCreateTimeNotIn(List<Date> values) {
            addCriterion("trading_create_time not in", values, "tradingCreateTime");
            return (Criteria) this;
        }

        public Criteria andTradingCreateTimeBetween(Date value1, Date value2) {
            addCriterion("trading_create_time between", value1, value2, "tradingCreateTime");
            return (Criteria) this;
        }

        public Criteria andTradingCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("trading_create_time not between", value1, value2, "tradingCreateTime");
            return (Criteria) this;
        }

        public Criteria andTradingStatusIsNull() {
            addCriterion("trading_status is null");
            return (Criteria) this;
        }

        public Criteria andTradingStatusIsNotNull() {
            addCriterion("trading_status is not null");
            return (Criteria) this;
        }

        public Criteria andTradingStatusEqualTo(Integer value) {
            addCriterion("trading_status =", value, "tradingStatus");
            return (Criteria) this;
        }

        public Criteria andTradingStatusNotEqualTo(Integer value) {
            addCriterion("trading_status <>", value, "tradingStatus");
            return (Criteria) this;
        }

        public Criteria andTradingStatusGreaterThan(Integer value) {
            addCriterion("trading_status >", value, "tradingStatus");
            return (Criteria) this;
        }

        public Criteria andTradingStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("trading_status >=", value, "tradingStatus");
            return (Criteria) this;
        }

        public Criteria andTradingStatusLessThan(Integer value) {
            addCriterion("trading_status <", value, "tradingStatus");
            return (Criteria) this;
        }

        public Criteria andTradingStatusLessThanOrEqualTo(Integer value) {
            addCriterion("trading_status <=", value, "tradingStatus");
            return (Criteria) this;
        }

        public Criteria andTradingStatusIn(List<Integer> values) {
            addCriterion("trading_status in", values, "tradingStatus");
            return (Criteria) this;
        }

        public Criteria andTradingStatusNotIn(List<Integer> values) {
            addCriterion("trading_status not in", values, "tradingStatus");
            return (Criteria) this;
        }

        public Criteria andTradingStatusBetween(Integer value1, Integer value2) {
            addCriterion("trading_status between", value1, value2, "tradingStatus");
            return (Criteria) this;
        }

        public Criteria andTradingStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("trading_status not between", value1, value2, "tradingStatus");
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
     * k2_order_trading
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * k2_order_trading 2019-08-06
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