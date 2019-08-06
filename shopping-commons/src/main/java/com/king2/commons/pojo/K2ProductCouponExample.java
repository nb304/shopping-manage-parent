package com.king2.commons.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class K2ProductCouponExample {
    /**
     * k2_product_coupon
     */
    protected String orderByClause;

    /**
     * k2_product_coupon
     */
    protected boolean distinct;

    /**
     * k2_product_coupon
     */
    protected List<Criteria> oredCriteria;

    public K2ProductCouponExample() {
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
     * k2_product_coupon 2019-08-06
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

        public Criteria andProductCouponIdIsNull() {
            addCriterion("product_coupon_id is null");
            return (Criteria) this;
        }

        public Criteria andProductCouponIdIsNotNull() {
            addCriterion("product_coupon_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductCouponIdEqualTo(Integer value) {
            addCriterion("product_coupon_id =", value, "productCouponId");
            return (Criteria) this;
        }

        public Criteria andProductCouponIdNotEqualTo(Integer value) {
            addCriterion("product_coupon_id <>", value, "productCouponId");
            return (Criteria) this;
        }

        public Criteria andProductCouponIdGreaterThan(Integer value) {
            addCriterion("product_coupon_id >", value, "productCouponId");
            return (Criteria) this;
        }

        public Criteria andProductCouponIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_coupon_id >=", value, "productCouponId");
            return (Criteria) this;
        }

        public Criteria andProductCouponIdLessThan(Integer value) {
            addCriterion("product_coupon_id <", value, "productCouponId");
            return (Criteria) this;
        }

        public Criteria andProductCouponIdLessThanOrEqualTo(Integer value) {
            addCriterion("product_coupon_id <=", value, "productCouponId");
            return (Criteria) this;
        }

        public Criteria andProductCouponIdIn(List<Integer> values) {
            addCriterion("product_coupon_id in", values, "productCouponId");
            return (Criteria) this;
        }

        public Criteria andProductCouponIdNotIn(List<Integer> values) {
            addCriterion("product_coupon_id not in", values, "productCouponId");
            return (Criteria) this;
        }

        public Criteria andProductCouponIdBetween(Integer value1, Integer value2) {
            addCriterion("product_coupon_id between", value1, value2, "productCouponId");
            return (Criteria) this;
        }

        public Criteria andProductCouponIdNotBetween(Integer value1, Integer value2) {
            addCriterion("product_coupon_id not between", value1, value2, "productCouponId");
            return (Criteria) this;
        }

        public Criteria andProductCouponNameIsNull() {
            addCriterion("product_coupon_name is null");
            return (Criteria) this;
        }

        public Criteria andProductCouponNameIsNotNull() {
            addCriterion("product_coupon_name is not null");
            return (Criteria) this;
        }

        public Criteria andProductCouponNameEqualTo(String value) {
            addCriterion("product_coupon_name =", value, "productCouponName");
            return (Criteria) this;
        }

        public Criteria andProductCouponNameNotEqualTo(String value) {
            addCriterion("product_coupon_name <>", value, "productCouponName");
            return (Criteria) this;
        }

        public Criteria andProductCouponNameGreaterThan(String value) {
            addCriterion("product_coupon_name >", value, "productCouponName");
            return (Criteria) this;
        }

        public Criteria andProductCouponNameGreaterThanOrEqualTo(String value) {
            addCriterion("product_coupon_name >=", value, "productCouponName");
            return (Criteria) this;
        }

        public Criteria andProductCouponNameLessThan(String value) {
            addCriterion("product_coupon_name <", value, "productCouponName");
            return (Criteria) this;
        }

        public Criteria andProductCouponNameLessThanOrEqualTo(String value) {
            addCriterion("product_coupon_name <=", value, "productCouponName");
            return (Criteria) this;
        }

        public Criteria andProductCouponNameLike(String value) {
            addCriterion("product_coupon_name like", value, "productCouponName");
            return (Criteria) this;
        }

        public Criteria andProductCouponNameNotLike(String value) {
            addCriterion("product_coupon_name not like", value, "productCouponName");
            return (Criteria) this;
        }

        public Criteria andProductCouponNameIn(List<String> values) {
            addCriterion("product_coupon_name in", values, "productCouponName");
            return (Criteria) this;
        }

        public Criteria andProductCouponNameNotIn(List<String> values) {
            addCriterion("product_coupon_name not in", values, "productCouponName");
            return (Criteria) this;
        }

        public Criteria andProductCouponNameBetween(String value1, String value2) {
            addCriterion("product_coupon_name between", value1, value2, "productCouponName");
            return (Criteria) this;
        }

        public Criteria andProductCouponNameNotBetween(String value1, String value2) {
            addCriterion("product_coupon_name not between", value1, value2, "productCouponName");
            return (Criteria) this;
        }

        public Criteria andProductCouponTypeIsNull() {
            addCriterion("product_coupon_type is null");
            return (Criteria) this;
        }

        public Criteria andProductCouponTypeIsNotNull() {
            addCriterion("product_coupon_type is not null");
            return (Criteria) this;
        }

        public Criteria andProductCouponTypeEqualTo(Integer value) {
            addCriterion("product_coupon_type =", value, "productCouponType");
            return (Criteria) this;
        }

        public Criteria andProductCouponTypeNotEqualTo(Integer value) {
            addCriterion("product_coupon_type <>", value, "productCouponType");
            return (Criteria) this;
        }

        public Criteria andProductCouponTypeGreaterThan(Integer value) {
            addCriterion("product_coupon_type >", value, "productCouponType");
            return (Criteria) this;
        }

        public Criteria andProductCouponTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_coupon_type >=", value, "productCouponType");
            return (Criteria) this;
        }

        public Criteria andProductCouponTypeLessThan(Integer value) {
            addCriterion("product_coupon_type <", value, "productCouponType");
            return (Criteria) this;
        }

        public Criteria andProductCouponTypeLessThanOrEqualTo(Integer value) {
            addCriterion("product_coupon_type <=", value, "productCouponType");
            return (Criteria) this;
        }

        public Criteria andProductCouponTypeIn(List<Integer> values) {
            addCriterion("product_coupon_type in", values, "productCouponType");
            return (Criteria) this;
        }

        public Criteria andProductCouponTypeNotIn(List<Integer> values) {
            addCriterion("product_coupon_type not in", values, "productCouponType");
            return (Criteria) this;
        }

        public Criteria andProductCouponTypeBetween(Integer value1, Integer value2) {
            addCriterion("product_coupon_type between", value1, value2, "productCouponType");
            return (Criteria) this;
        }

        public Criteria andProductCouponTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("product_coupon_type not between", value1, value2, "productCouponType");
            return (Criteria) this;
        }

        public Criteria andProductCouponDoorsillIsNull() {
            addCriterion("product_coupon_doorsill is null");
            return (Criteria) this;
        }

        public Criteria andProductCouponDoorsillIsNotNull() {
            addCriterion("product_coupon_doorsill is not null");
            return (Criteria) this;
        }

        public Criteria andProductCouponDoorsillEqualTo(BigDecimal value) {
            addCriterion("product_coupon_doorsill =", value, "productCouponDoorsill");
            return (Criteria) this;
        }

        public Criteria andProductCouponDoorsillNotEqualTo(BigDecimal value) {
            addCriterion("product_coupon_doorsill <>", value, "productCouponDoorsill");
            return (Criteria) this;
        }

        public Criteria andProductCouponDoorsillGreaterThan(BigDecimal value) {
            addCriterion("product_coupon_doorsill >", value, "productCouponDoorsill");
            return (Criteria) this;
        }

        public Criteria andProductCouponDoorsillGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("product_coupon_doorsill >=", value, "productCouponDoorsill");
            return (Criteria) this;
        }

        public Criteria andProductCouponDoorsillLessThan(BigDecimal value) {
            addCriterion("product_coupon_doorsill <", value, "productCouponDoorsill");
            return (Criteria) this;
        }

        public Criteria andProductCouponDoorsillLessThanOrEqualTo(BigDecimal value) {
            addCriterion("product_coupon_doorsill <=", value, "productCouponDoorsill");
            return (Criteria) this;
        }

        public Criteria andProductCouponDoorsillIn(List<BigDecimal> values) {
            addCriterion("product_coupon_doorsill in", values, "productCouponDoorsill");
            return (Criteria) this;
        }

        public Criteria andProductCouponDoorsillNotIn(List<BigDecimal> values) {
            addCriterion("product_coupon_doorsill not in", values, "productCouponDoorsill");
            return (Criteria) this;
        }

        public Criteria andProductCouponDoorsillBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("product_coupon_doorsill between", value1, value2, "productCouponDoorsill");
            return (Criteria) this;
        }

        public Criteria andProductCouponDoorsillNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("product_coupon_doorsill not between", value1, value2, "productCouponDoorsill");
            return (Criteria) this;
        }

        public Criteria andProductCouponPriceIsNull() {
            addCriterion("product_coupon_price is null");
            return (Criteria) this;
        }

        public Criteria andProductCouponPriceIsNotNull() {
            addCriterion("product_coupon_price is not null");
            return (Criteria) this;
        }

        public Criteria andProductCouponPriceEqualTo(BigDecimal value) {
            addCriterion("product_coupon_price =", value, "productCouponPrice");
            return (Criteria) this;
        }

        public Criteria andProductCouponPriceNotEqualTo(BigDecimal value) {
            addCriterion("product_coupon_price <>", value, "productCouponPrice");
            return (Criteria) this;
        }

        public Criteria andProductCouponPriceGreaterThan(BigDecimal value) {
            addCriterion("product_coupon_price >", value, "productCouponPrice");
            return (Criteria) this;
        }

        public Criteria andProductCouponPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("product_coupon_price >=", value, "productCouponPrice");
            return (Criteria) this;
        }

        public Criteria andProductCouponPriceLessThan(BigDecimal value) {
            addCriterion("product_coupon_price <", value, "productCouponPrice");
            return (Criteria) this;
        }

        public Criteria andProductCouponPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("product_coupon_price <=", value, "productCouponPrice");
            return (Criteria) this;
        }

        public Criteria andProductCouponPriceIn(List<BigDecimal> values) {
            addCriterion("product_coupon_price in", values, "productCouponPrice");
            return (Criteria) this;
        }

        public Criteria andProductCouponPriceNotIn(List<BigDecimal> values) {
            addCriterion("product_coupon_price not in", values, "productCouponPrice");
            return (Criteria) this;
        }

        public Criteria andProductCouponPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("product_coupon_price between", value1, value2, "productCouponPrice");
            return (Criteria) this;
        }

        public Criteria andProductCouponPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("product_coupon_price not between", value1, value2, "productCouponPrice");
            return (Criteria) this;
        }

        public Criteria andProductCouponSizeIsNull() {
            addCriterion("product_coupon_size is null");
            return (Criteria) this;
        }

        public Criteria andProductCouponSizeIsNotNull() {
            addCriterion("product_coupon_size is not null");
            return (Criteria) this;
        }

        public Criteria andProductCouponSizeEqualTo(Integer value) {
            addCriterion("product_coupon_size =", value, "productCouponSize");
            return (Criteria) this;
        }

        public Criteria andProductCouponSizeNotEqualTo(Integer value) {
            addCriterion("product_coupon_size <>", value, "productCouponSize");
            return (Criteria) this;
        }

        public Criteria andProductCouponSizeGreaterThan(Integer value) {
            addCriterion("product_coupon_size >", value, "productCouponSize");
            return (Criteria) this;
        }

        public Criteria andProductCouponSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_coupon_size >=", value, "productCouponSize");
            return (Criteria) this;
        }

        public Criteria andProductCouponSizeLessThan(Integer value) {
            addCriterion("product_coupon_size <", value, "productCouponSize");
            return (Criteria) this;
        }

        public Criteria andProductCouponSizeLessThanOrEqualTo(Integer value) {
            addCriterion("product_coupon_size <=", value, "productCouponSize");
            return (Criteria) this;
        }

        public Criteria andProductCouponSizeIn(List<Integer> values) {
            addCriterion("product_coupon_size in", values, "productCouponSize");
            return (Criteria) this;
        }

        public Criteria andProductCouponSizeNotIn(List<Integer> values) {
            addCriterion("product_coupon_size not in", values, "productCouponSize");
            return (Criteria) this;
        }

        public Criteria andProductCouponSizeBetween(Integer value1, Integer value2) {
            addCriterion("product_coupon_size between", value1, value2, "productCouponSize");
            return (Criteria) this;
        }

        public Criteria andProductCouponSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("product_coupon_size not between", value1, value2, "productCouponSize");
            return (Criteria) this;
        }

        public Criteria andProductCouponStartTimeIsNull() {
            addCriterion("product_coupon_start_time is null");
            return (Criteria) this;
        }

        public Criteria andProductCouponStartTimeIsNotNull() {
            addCriterion("product_coupon_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andProductCouponStartTimeEqualTo(Date value) {
            addCriterion("product_coupon_start_time =", value, "productCouponStartTime");
            return (Criteria) this;
        }

        public Criteria andProductCouponStartTimeNotEqualTo(Date value) {
            addCriterion("product_coupon_start_time <>", value, "productCouponStartTime");
            return (Criteria) this;
        }

        public Criteria andProductCouponStartTimeGreaterThan(Date value) {
            addCriterion("product_coupon_start_time >", value, "productCouponStartTime");
            return (Criteria) this;
        }

        public Criteria andProductCouponStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("product_coupon_start_time >=", value, "productCouponStartTime");
            return (Criteria) this;
        }

        public Criteria andProductCouponStartTimeLessThan(Date value) {
            addCriterion("product_coupon_start_time <", value, "productCouponStartTime");
            return (Criteria) this;
        }

        public Criteria andProductCouponStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("product_coupon_start_time <=", value, "productCouponStartTime");
            return (Criteria) this;
        }

        public Criteria andProductCouponStartTimeIn(List<Date> values) {
            addCriterion("product_coupon_start_time in", values, "productCouponStartTime");
            return (Criteria) this;
        }

        public Criteria andProductCouponStartTimeNotIn(List<Date> values) {
            addCriterion("product_coupon_start_time not in", values, "productCouponStartTime");
            return (Criteria) this;
        }

        public Criteria andProductCouponStartTimeBetween(Date value1, Date value2) {
            addCriterion("product_coupon_start_time between", value1, value2, "productCouponStartTime");
            return (Criteria) this;
        }

        public Criteria andProductCouponStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("product_coupon_start_time not between", value1, value2, "productCouponStartTime");
            return (Criteria) this;
        }

        public Criteria andProductCouponEndTimeIsNull() {
            addCriterion("product_coupon_end_time is null");
            return (Criteria) this;
        }

        public Criteria andProductCouponEndTimeIsNotNull() {
            addCriterion("product_coupon_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andProductCouponEndTimeEqualTo(Date value) {
            addCriterion("product_coupon_end_time =", value, "productCouponEndTime");
            return (Criteria) this;
        }

        public Criteria andProductCouponEndTimeNotEqualTo(Date value) {
            addCriterion("product_coupon_end_time <>", value, "productCouponEndTime");
            return (Criteria) this;
        }

        public Criteria andProductCouponEndTimeGreaterThan(Date value) {
            addCriterion("product_coupon_end_time >", value, "productCouponEndTime");
            return (Criteria) this;
        }

        public Criteria andProductCouponEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("product_coupon_end_time >=", value, "productCouponEndTime");
            return (Criteria) this;
        }

        public Criteria andProductCouponEndTimeLessThan(Date value) {
            addCriterion("product_coupon_end_time <", value, "productCouponEndTime");
            return (Criteria) this;
        }

        public Criteria andProductCouponEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("product_coupon_end_time <=", value, "productCouponEndTime");
            return (Criteria) this;
        }

        public Criteria andProductCouponEndTimeIn(List<Date> values) {
            addCriterion("product_coupon_end_time in", values, "productCouponEndTime");
            return (Criteria) this;
        }

        public Criteria andProductCouponEndTimeNotIn(List<Date> values) {
            addCriterion("product_coupon_end_time not in", values, "productCouponEndTime");
            return (Criteria) this;
        }

        public Criteria andProductCouponEndTimeBetween(Date value1, Date value2) {
            addCriterion("product_coupon_end_time between", value1, value2, "productCouponEndTime");
            return (Criteria) this;
        }

        public Criteria andProductCouponEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("product_coupon_end_time not between", value1, value2, "productCouponEndTime");
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

        public Criteria andProductCouponStateIsNull() {
            addCriterion("product_coupon_state is null");
            return (Criteria) this;
        }

        public Criteria andProductCouponStateIsNotNull() {
            addCriterion("product_coupon_state is not null");
            return (Criteria) this;
        }

        public Criteria andProductCouponStateEqualTo(Integer value) {
            addCriterion("product_coupon_state =", value, "productCouponState");
            return (Criteria) this;
        }

        public Criteria andProductCouponStateNotEqualTo(Integer value) {
            addCriterion("product_coupon_state <>", value, "productCouponState");
            return (Criteria) this;
        }

        public Criteria andProductCouponStateGreaterThan(Integer value) {
            addCriterion("product_coupon_state >", value, "productCouponState");
            return (Criteria) this;
        }

        public Criteria andProductCouponStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_coupon_state >=", value, "productCouponState");
            return (Criteria) this;
        }

        public Criteria andProductCouponStateLessThan(Integer value) {
            addCriterion("product_coupon_state <", value, "productCouponState");
            return (Criteria) this;
        }

        public Criteria andProductCouponStateLessThanOrEqualTo(Integer value) {
            addCriterion("product_coupon_state <=", value, "productCouponState");
            return (Criteria) this;
        }

        public Criteria andProductCouponStateIn(List<Integer> values) {
            addCriterion("product_coupon_state in", values, "productCouponState");
            return (Criteria) this;
        }

        public Criteria andProductCouponStateNotIn(List<Integer> values) {
            addCriterion("product_coupon_state not in", values, "productCouponState");
            return (Criteria) this;
        }

        public Criteria andProductCouponStateBetween(Integer value1, Integer value2) {
            addCriterion("product_coupon_state between", value1, value2, "productCouponState");
            return (Criteria) this;
        }

        public Criteria andProductCouponStateNotBetween(Integer value1, Integer value2) {
            addCriterion("product_coupon_state not between", value1, value2, "productCouponState");
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
     * k2_product_coupon
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * k2_product_coupon 2019-08-06
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