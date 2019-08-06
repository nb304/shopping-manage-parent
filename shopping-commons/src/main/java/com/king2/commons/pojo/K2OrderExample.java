package com.king2.commons.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class K2OrderExample {
    /**
     * k2_order
     */
    protected String orderByClause;

    /**
     * k2_order
     */
    protected boolean distinct;

    /**
     * k2_order
     */
    protected List<Criteria> oredCriteria;

    public K2OrderExample() {
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
     * k2_order 2019-08-06
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Integer value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Integer value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Integer value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Integer value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Integer> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Integer> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
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

        public Criteria andOrderTypeIsNull() {
            addCriterion("order_type is null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNotNull() {
            addCriterion("order_type is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeEqualTo(String value) {
            addCriterion("order_type =", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotEqualTo(String value) {
            addCriterion("order_type <>", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThan(String value) {
            addCriterion("order_type >", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThanOrEqualTo(String value) {
            addCriterion("order_type >=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThan(String value) {
            addCriterion("order_type <", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThanOrEqualTo(String value) {
            addCriterion("order_type <=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLike(String value) {
            addCriterion("order_type like", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotLike(String value) {
            addCriterion("order_type not like", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIn(List<String> values) {
            addCriterion("order_type in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotIn(List<String> values) {
            addCriterion("order_type not in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeBetween(String value1, String value2) {
            addCriterion("order_type between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotBetween(String value1, String value2) {
            addCriterion("order_type not between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderStateIsNull() {
            addCriterion("order_state is null");
            return (Criteria) this;
        }

        public Criteria andOrderStateIsNotNull() {
            addCriterion("order_state is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStateEqualTo(String value) {
            addCriterion("order_state =", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateNotEqualTo(String value) {
            addCriterion("order_state <>", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateGreaterThan(String value) {
            addCriterion("order_state >", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateGreaterThanOrEqualTo(String value) {
            addCriterion("order_state >=", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateLessThan(String value) {
            addCriterion("order_state <", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateLessThanOrEqualTo(String value) {
            addCriterion("order_state <=", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateLike(String value) {
            addCriterion("order_state like", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateNotLike(String value) {
            addCriterion("order_state not like", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateIn(List<String> values) {
            addCriterion("order_state in", values, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateNotIn(List<String> values) {
            addCriterion("order_state not in", values, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateBetween(String value1, String value2) {
            addCriterion("order_state between", value1, value2, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateNotBetween(String value1, String value2) {
            addCriterion("order_state not between", value1, value2, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderSettlementStatusIsNull() {
            addCriterion("order_settlement_status is null");
            return (Criteria) this;
        }

        public Criteria andOrderSettlementStatusIsNotNull() {
            addCriterion("order_settlement_status is not null");
            return (Criteria) this;
        }

        public Criteria andOrderSettlementStatusEqualTo(Integer value) {
            addCriterion("order_settlement_status =", value, "orderSettlementStatus");
            return (Criteria) this;
        }

        public Criteria andOrderSettlementStatusNotEqualTo(Integer value) {
            addCriterion("order_settlement_status <>", value, "orderSettlementStatus");
            return (Criteria) this;
        }

        public Criteria andOrderSettlementStatusGreaterThan(Integer value) {
            addCriterion("order_settlement_status >", value, "orderSettlementStatus");
            return (Criteria) this;
        }

        public Criteria andOrderSettlementStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_settlement_status >=", value, "orderSettlementStatus");
            return (Criteria) this;
        }

        public Criteria andOrderSettlementStatusLessThan(Integer value) {
            addCriterion("order_settlement_status <", value, "orderSettlementStatus");
            return (Criteria) this;
        }

        public Criteria andOrderSettlementStatusLessThanOrEqualTo(Integer value) {
            addCriterion("order_settlement_status <=", value, "orderSettlementStatus");
            return (Criteria) this;
        }

        public Criteria andOrderSettlementStatusIn(List<Integer> values) {
            addCriterion("order_settlement_status in", values, "orderSettlementStatus");
            return (Criteria) this;
        }

        public Criteria andOrderSettlementStatusNotIn(List<Integer> values) {
            addCriterion("order_settlement_status not in", values, "orderSettlementStatus");
            return (Criteria) this;
        }

        public Criteria andOrderSettlementStatusBetween(Integer value1, Integer value2) {
            addCriterion("order_settlement_status between", value1, value2, "orderSettlementStatus");
            return (Criteria) this;
        }

        public Criteria andOrderSettlementStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("order_settlement_status not between", value1, value2, "orderSettlementStatus");
            return (Criteria) this;
        }

        public Criteria andOrderAfterStatusIsNull() {
            addCriterion("order_after_status is null");
            return (Criteria) this;
        }

        public Criteria andOrderAfterStatusIsNotNull() {
            addCriterion("order_after_status is not null");
            return (Criteria) this;
        }

        public Criteria andOrderAfterStatusEqualTo(Integer value) {
            addCriterion("order_after_status =", value, "orderAfterStatus");
            return (Criteria) this;
        }

        public Criteria andOrderAfterStatusNotEqualTo(Integer value) {
            addCriterion("order_after_status <>", value, "orderAfterStatus");
            return (Criteria) this;
        }

        public Criteria andOrderAfterStatusGreaterThan(Integer value) {
            addCriterion("order_after_status >", value, "orderAfterStatus");
            return (Criteria) this;
        }

        public Criteria andOrderAfterStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_after_status >=", value, "orderAfterStatus");
            return (Criteria) this;
        }

        public Criteria andOrderAfterStatusLessThan(Integer value) {
            addCriterion("order_after_status <", value, "orderAfterStatus");
            return (Criteria) this;
        }

        public Criteria andOrderAfterStatusLessThanOrEqualTo(Integer value) {
            addCriterion("order_after_status <=", value, "orderAfterStatus");
            return (Criteria) this;
        }

        public Criteria andOrderAfterStatusIn(List<Integer> values) {
            addCriterion("order_after_status in", values, "orderAfterStatus");
            return (Criteria) this;
        }

        public Criteria andOrderAfterStatusNotIn(List<Integer> values) {
            addCriterion("order_after_status not in", values, "orderAfterStatus");
            return (Criteria) this;
        }

        public Criteria andOrderAfterStatusBetween(Integer value1, Integer value2) {
            addCriterion("order_after_status between", value1, value2, "orderAfterStatus");
            return (Criteria) this;
        }

        public Criteria andOrderAfterStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("order_after_status not between", value1, value2, "orderAfterStatus");
            return (Criteria) this;
        }

        public Criteria andProductAmountTotalIsNull() {
            addCriterion("product_amount_total is null");
            return (Criteria) this;
        }

        public Criteria andProductAmountTotalIsNotNull() {
            addCriterion("product_amount_total is not null");
            return (Criteria) this;
        }

        public Criteria andProductAmountTotalEqualTo(BigDecimal value) {
            addCriterion("product_amount_total =", value, "productAmountTotal");
            return (Criteria) this;
        }

        public Criteria andProductAmountTotalNotEqualTo(BigDecimal value) {
            addCriterion("product_amount_total <>", value, "productAmountTotal");
            return (Criteria) this;
        }

        public Criteria andProductAmountTotalGreaterThan(BigDecimal value) {
            addCriterion("product_amount_total >", value, "productAmountTotal");
            return (Criteria) this;
        }

        public Criteria andProductAmountTotalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("product_amount_total >=", value, "productAmountTotal");
            return (Criteria) this;
        }

        public Criteria andProductAmountTotalLessThan(BigDecimal value) {
            addCriterion("product_amount_total <", value, "productAmountTotal");
            return (Criteria) this;
        }

        public Criteria andProductAmountTotalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("product_amount_total <=", value, "productAmountTotal");
            return (Criteria) this;
        }

        public Criteria andProductAmountTotalIn(List<BigDecimal> values) {
            addCriterion("product_amount_total in", values, "productAmountTotal");
            return (Criteria) this;
        }

        public Criteria andProductAmountTotalNotIn(List<BigDecimal> values) {
            addCriterion("product_amount_total not in", values, "productAmountTotal");
            return (Criteria) this;
        }

        public Criteria andProductAmountTotalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("product_amount_total between", value1, value2, "productAmountTotal");
            return (Criteria) this;
        }

        public Criteria andProductAmountTotalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("product_amount_total not between", value1, value2, "productAmountTotal");
            return (Criteria) this;
        }

        public Criteria andOrderAmountTotalIsNull() {
            addCriterion("order_amount_total is null");
            return (Criteria) this;
        }

        public Criteria andOrderAmountTotalIsNotNull() {
            addCriterion("order_amount_total is not null");
            return (Criteria) this;
        }

        public Criteria andOrderAmountTotalEqualTo(BigDecimal value) {
            addCriterion("order_amount_total =", value, "orderAmountTotal");
            return (Criteria) this;
        }

        public Criteria andOrderAmountTotalNotEqualTo(BigDecimal value) {
            addCriterion("order_amount_total <>", value, "orderAmountTotal");
            return (Criteria) this;
        }

        public Criteria andOrderAmountTotalGreaterThan(BigDecimal value) {
            addCriterion("order_amount_total >", value, "orderAmountTotal");
            return (Criteria) this;
        }

        public Criteria andOrderAmountTotalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("order_amount_total >=", value, "orderAmountTotal");
            return (Criteria) this;
        }

        public Criteria andOrderAmountTotalLessThan(BigDecimal value) {
            addCriterion("order_amount_total <", value, "orderAmountTotal");
            return (Criteria) this;
        }

        public Criteria andOrderAmountTotalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("order_amount_total <=", value, "orderAmountTotal");
            return (Criteria) this;
        }

        public Criteria andOrderAmountTotalIn(List<BigDecimal> values) {
            addCriterion("order_amount_total in", values, "orderAmountTotal");
            return (Criteria) this;
        }

        public Criteria andOrderAmountTotalNotIn(List<BigDecimal> values) {
            addCriterion("order_amount_total not in", values, "orderAmountTotal");
            return (Criteria) this;
        }

        public Criteria andOrderAmountTotalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_amount_total between", value1, value2, "orderAmountTotal");
            return (Criteria) this;
        }

        public Criteria andOrderAmountTotalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_amount_total not between", value1, value2, "orderAmountTotal");
            return (Criteria) this;
        }

        public Criteria andOrderDiscountAmountIsNull() {
            addCriterion("order_discount_amount is null");
            return (Criteria) this;
        }

        public Criteria andOrderDiscountAmountIsNotNull() {
            addCriterion("order_discount_amount is not null");
            return (Criteria) this;
        }

        public Criteria andOrderDiscountAmountEqualTo(BigDecimal value) {
            addCriterion("order_discount_amount =", value, "orderDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andOrderDiscountAmountNotEqualTo(BigDecimal value) {
            addCriterion("order_discount_amount <>", value, "orderDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andOrderDiscountAmountGreaterThan(BigDecimal value) {
            addCriterion("order_discount_amount >", value, "orderDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andOrderDiscountAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("order_discount_amount >=", value, "orderDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andOrderDiscountAmountLessThan(BigDecimal value) {
            addCriterion("order_discount_amount <", value, "orderDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andOrderDiscountAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("order_discount_amount <=", value, "orderDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andOrderDiscountAmountIn(List<BigDecimal> values) {
            addCriterion("order_discount_amount in", values, "orderDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andOrderDiscountAmountNotIn(List<BigDecimal> values) {
            addCriterion("order_discount_amount not in", values, "orderDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andOrderDiscountAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_discount_amount between", value1, value2, "orderDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andOrderDiscountAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_discount_amount not between", value1, value2, "orderDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andOrderLogisticsFeeIsNull() {
            addCriterion("order_logistics_fee is null");
            return (Criteria) this;
        }

        public Criteria andOrderLogisticsFeeIsNotNull() {
            addCriterion("order_logistics_fee is not null");
            return (Criteria) this;
        }

        public Criteria andOrderLogisticsFeeEqualTo(BigDecimal value) {
            addCriterion("order_logistics_fee =", value, "orderLogisticsFee");
            return (Criteria) this;
        }

        public Criteria andOrderLogisticsFeeNotEqualTo(BigDecimal value) {
            addCriterion("order_logistics_fee <>", value, "orderLogisticsFee");
            return (Criteria) this;
        }

        public Criteria andOrderLogisticsFeeGreaterThan(BigDecimal value) {
            addCriterion("order_logistics_fee >", value, "orderLogisticsFee");
            return (Criteria) this;
        }

        public Criteria andOrderLogisticsFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("order_logistics_fee >=", value, "orderLogisticsFee");
            return (Criteria) this;
        }

        public Criteria andOrderLogisticsFeeLessThan(BigDecimal value) {
            addCriterion("order_logistics_fee <", value, "orderLogisticsFee");
            return (Criteria) this;
        }

        public Criteria andOrderLogisticsFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("order_logistics_fee <=", value, "orderLogisticsFee");
            return (Criteria) this;
        }

        public Criteria andOrderLogisticsFeeIn(List<BigDecimal> values) {
            addCriterion("order_logistics_fee in", values, "orderLogisticsFee");
            return (Criteria) this;
        }

        public Criteria andOrderLogisticsFeeNotIn(List<BigDecimal> values) {
            addCriterion("order_logistics_fee not in", values, "orderLogisticsFee");
            return (Criteria) this;
        }

        public Criteria andOrderLogisticsFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_logistics_fee between", value1, value2, "orderLogisticsFee");
            return (Criteria) this;
        }

        public Criteria andOrderLogisticsFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_logistics_fee not between", value1, value2, "orderLogisticsFee");
            return (Criteria) this;
        }

        public Criteria andOrderOtherAmountIsNull() {
            addCriterion("order_other_amount is null");
            return (Criteria) this;
        }

        public Criteria andOrderOtherAmountIsNotNull() {
            addCriterion("order_other_amount is not null");
            return (Criteria) this;
        }

        public Criteria andOrderOtherAmountEqualTo(BigDecimal value) {
            addCriterion("order_other_amount =", value, "orderOtherAmount");
            return (Criteria) this;
        }

        public Criteria andOrderOtherAmountNotEqualTo(BigDecimal value) {
            addCriterion("order_other_amount <>", value, "orderOtherAmount");
            return (Criteria) this;
        }

        public Criteria andOrderOtherAmountGreaterThan(BigDecimal value) {
            addCriterion("order_other_amount >", value, "orderOtherAmount");
            return (Criteria) this;
        }

        public Criteria andOrderOtherAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("order_other_amount >=", value, "orderOtherAmount");
            return (Criteria) this;
        }

        public Criteria andOrderOtherAmountLessThan(BigDecimal value) {
            addCriterion("order_other_amount <", value, "orderOtherAmount");
            return (Criteria) this;
        }

        public Criteria andOrderOtherAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("order_other_amount <=", value, "orderOtherAmount");
            return (Criteria) this;
        }

        public Criteria andOrderOtherAmountIn(List<BigDecimal> values) {
            addCriterion("order_other_amount in", values, "orderOtherAmount");
            return (Criteria) this;
        }

        public Criteria andOrderOtherAmountNotIn(List<BigDecimal> values) {
            addCriterion("order_other_amount not in", values, "orderOtherAmount");
            return (Criteria) this;
        }

        public Criteria andOrderOtherAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_other_amount between", value1, value2, "orderOtherAmount");
            return (Criteria) this;
        }

        public Criteria andOrderOtherAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_other_amount not between", value1, value2, "orderOtherAmount");
            return (Criteria) this;
        }

        public Criteria andOrderOtherDescIsNull() {
            addCriterion("order_other_desc is null");
            return (Criteria) this;
        }

        public Criteria andOrderOtherDescIsNotNull() {
            addCriterion("order_other_desc is not null");
            return (Criteria) this;
        }

        public Criteria andOrderOtherDescEqualTo(String value) {
            addCriterion("order_other_desc =", value, "orderOtherDesc");
            return (Criteria) this;
        }

        public Criteria andOrderOtherDescNotEqualTo(String value) {
            addCriterion("order_other_desc <>", value, "orderOtherDesc");
            return (Criteria) this;
        }

        public Criteria andOrderOtherDescGreaterThan(String value) {
            addCriterion("order_other_desc >", value, "orderOtherDesc");
            return (Criteria) this;
        }

        public Criteria andOrderOtherDescGreaterThanOrEqualTo(String value) {
            addCriterion("order_other_desc >=", value, "orderOtherDesc");
            return (Criteria) this;
        }

        public Criteria andOrderOtherDescLessThan(String value) {
            addCriterion("order_other_desc <", value, "orderOtherDesc");
            return (Criteria) this;
        }

        public Criteria andOrderOtherDescLessThanOrEqualTo(String value) {
            addCriterion("order_other_desc <=", value, "orderOtherDesc");
            return (Criteria) this;
        }

        public Criteria andOrderOtherDescLike(String value) {
            addCriterion("order_other_desc like", value, "orderOtherDesc");
            return (Criteria) this;
        }

        public Criteria andOrderOtherDescNotLike(String value) {
            addCriterion("order_other_desc not like", value, "orderOtherDesc");
            return (Criteria) this;
        }

        public Criteria andOrderOtherDescIn(List<String> values) {
            addCriterion("order_other_desc in", values, "orderOtherDesc");
            return (Criteria) this;
        }

        public Criteria andOrderOtherDescNotIn(List<String> values) {
            addCriterion("order_other_desc not in", values, "orderOtherDesc");
            return (Criteria) this;
        }

        public Criteria andOrderOtherDescBetween(String value1, String value2) {
            addCriterion("order_other_desc between", value1, value2, "orderOtherDesc");
            return (Criteria) this;
        }

        public Criteria andOrderOtherDescNotBetween(String value1, String value2) {
            addCriterion("order_other_desc not between", value1, value2, "orderOtherDesc");
            return (Criteria) this;
        }

        public Criteria andOrderShippingAddressIsNull() {
            addCriterion("order_shipping_address is null");
            return (Criteria) this;
        }

        public Criteria andOrderShippingAddressIsNotNull() {
            addCriterion("order_shipping_address is not null");
            return (Criteria) this;
        }

        public Criteria andOrderShippingAddressEqualTo(String value) {
            addCriterion("order_shipping_address =", value, "orderShippingAddress");
            return (Criteria) this;
        }

        public Criteria andOrderShippingAddressNotEqualTo(String value) {
            addCriterion("order_shipping_address <>", value, "orderShippingAddress");
            return (Criteria) this;
        }

        public Criteria andOrderShippingAddressGreaterThan(String value) {
            addCriterion("order_shipping_address >", value, "orderShippingAddress");
            return (Criteria) this;
        }

        public Criteria andOrderShippingAddressGreaterThanOrEqualTo(String value) {
            addCriterion("order_shipping_address >=", value, "orderShippingAddress");
            return (Criteria) this;
        }

        public Criteria andOrderShippingAddressLessThan(String value) {
            addCriterion("order_shipping_address <", value, "orderShippingAddress");
            return (Criteria) this;
        }

        public Criteria andOrderShippingAddressLessThanOrEqualTo(String value) {
            addCriterion("order_shipping_address <=", value, "orderShippingAddress");
            return (Criteria) this;
        }

        public Criteria andOrderShippingAddressLike(String value) {
            addCriterion("order_shipping_address like", value, "orderShippingAddress");
            return (Criteria) this;
        }

        public Criteria andOrderShippingAddressNotLike(String value) {
            addCriterion("order_shipping_address not like", value, "orderShippingAddress");
            return (Criteria) this;
        }

        public Criteria andOrderShippingAddressIn(List<String> values) {
            addCriterion("order_shipping_address in", values, "orderShippingAddress");
            return (Criteria) this;
        }

        public Criteria andOrderShippingAddressNotIn(List<String> values) {
            addCriterion("order_shipping_address not in", values, "orderShippingAddress");
            return (Criteria) this;
        }

        public Criteria andOrderShippingAddressBetween(String value1, String value2) {
            addCriterion("order_shipping_address between", value1, value2, "orderShippingAddress");
            return (Criteria) this;
        }

        public Criteria andOrderShippingAddressNotBetween(String value1, String value2) {
            addCriterion("order_shipping_address not between", value1, value2, "orderShippingAddress");
            return (Criteria) this;
        }

        public Criteria andStoreIdIsNull() {
            addCriterion("store_id is null");
            return (Criteria) this;
        }

        public Criteria andStoreIdIsNotNull() {
            addCriterion("store_id is not null");
            return (Criteria) this;
        }

        public Criteria andStoreIdEqualTo(Integer value) {
            addCriterion("store_id =", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotEqualTo(Integer value) {
            addCriterion("store_id <>", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdGreaterThan(Integer value) {
            addCriterion("store_id >", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_id >=", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdLessThan(Integer value) {
            addCriterion("store_id <", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdLessThanOrEqualTo(Integer value) {
            addCriterion("store_id <=", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdIn(List<Integer> values) {
            addCriterion("store_id in", values, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotIn(List<Integer> values) {
            addCriterion("store_id not in", values, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdBetween(Integer value1, Integer value2) {
            addCriterion("store_id between", value1, value2, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotBetween(Integer value1, Integer value2) {
            addCriterion("store_id not between", value1, value2, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreNameIsNull() {
            addCriterion("store_name is null");
            return (Criteria) this;
        }

        public Criteria andStoreNameIsNotNull() {
            addCriterion("store_name is not null");
            return (Criteria) this;
        }

        public Criteria andStoreNameEqualTo(String value) {
            addCriterion("store_name =", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotEqualTo(String value) {
            addCriterion("store_name <>", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameGreaterThan(String value) {
            addCriterion("store_name >", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameGreaterThanOrEqualTo(String value) {
            addCriterion("store_name >=", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLessThan(String value) {
            addCriterion("store_name <", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLessThanOrEqualTo(String value) {
            addCriterion("store_name <=", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLike(String value) {
            addCriterion("store_name like", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotLike(String value) {
            addCriterion("store_name not like", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameIn(List<String> values) {
            addCriterion("store_name in", values, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotIn(List<String> values) {
            addCriterion("store_name not in", values, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameBetween(String value1, String value2) {
            addCriterion("store_name between", value1, value2, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotBetween(String value1, String value2) {
            addCriterion("store_name not between", value1, value2, "storeName");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNull() {
            addCriterion("product_id is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("product_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(Integer value) {
            addCriterion("product_id =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(Integer value) {
            addCriterion("product_id <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(Integer value) {
            addCriterion("product_id >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_id >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(Integer value) {
            addCriterion("product_id <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(Integer value) {
            addCriterion("product_id <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<Integer> values) {
            addCriterion("product_id in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<Integer> values) {
            addCriterion("product_id not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(Integer value1, Integer value2) {
            addCriterion("product_id between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(Integer value1, Integer value2) {
            addCriterion("product_id not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductNumberIsNull() {
            addCriterion("product_number is null");
            return (Criteria) this;
        }

        public Criteria andProductNumberIsNotNull() {
            addCriterion("product_number is not null");
            return (Criteria) this;
        }

        public Criteria andProductNumberEqualTo(String value) {
            addCriterion("product_number =", value, "productNumber");
            return (Criteria) this;
        }

        public Criteria andProductNumberNotEqualTo(String value) {
            addCriterion("product_number <>", value, "productNumber");
            return (Criteria) this;
        }

        public Criteria andProductNumberGreaterThan(String value) {
            addCriterion("product_number >", value, "productNumber");
            return (Criteria) this;
        }

        public Criteria andProductNumberGreaterThanOrEqualTo(String value) {
            addCriterion("product_number >=", value, "productNumber");
            return (Criteria) this;
        }

        public Criteria andProductNumberLessThan(String value) {
            addCriterion("product_number <", value, "productNumber");
            return (Criteria) this;
        }

        public Criteria andProductNumberLessThanOrEqualTo(String value) {
            addCriterion("product_number <=", value, "productNumber");
            return (Criteria) this;
        }

        public Criteria andProductNumberLike(String value) {
            addCriterion("product_number like", value, "productNumber");
            return (Criteria) this;
        }

        public Criteria andProductNumberNotLike(String value) {
            addCriterion("product_number not like", value, "productNumber");
            return (Criteria) this;
        }

        public Criteria andProductNumberIn(List<String> values) {
            addCriterion("product_number in", values, "productNumber");
            return (Criteria) this;
        }

        public Criteria andProductNumberNotIn(List<String> values) {
            addCriterion("product_number not in", values, "productNumber");
            return (Criteria) this;
        }

        public Criteria andProductNumberBetween(String value1, String value2) {
            addCriterion("product_number between", value1, value2, "productNumber");
            return (Criteria) this;
        }

        public Criteria andProductNumberNotBetween(String value1, String value2) {
            addCriterion("product_number not between", value1, value2, "productNumber");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNull() {
            addCriterion("product_name is null");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNotNull() {
            addCriterion("product_name is not null");
            return (Criteria) this;
        }

        public Criteria andProductNameEqualTo(String value) {
            addCriterion("product_name =", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotEqualTo(String value) {
            addCriterion("product_name <>", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThan(String value) {
            addCriterion("product_name >", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThanOrEqualTo(String value) {
            addCriterion("product_name >=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThan(String value) {
            addCriterion("product_name <", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThanOrEqualTo(String value) {
            addCriterion("product_name <=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLike(String value) {
            addCriterion("product_name like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotLike(String value) {
            addCriterion("product_name not like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameIn(List<String> values) {
            addCriterion("product_name in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotIn(List<String> values) {
            addCriterion("product_name not in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameBetween(String value1, String value2) {
            addCriterion("product_name between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotBetween(String value1, String value2) {
            addCriterion("product_name not between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andMemberIdIsNull() {
            addCriterion("member_id is null");
            return (Criteria) this;
        }

        public Criteria andMemberIdIsNotNull() {
            addCriterion("member_id is not null");
            return (Criteria) this;
        }

        public Criteria andMemberIdEqualTo(Integer value) {
            addCriterion("member_id =", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotEqualTo(Integer value) {
            addCriterion("member_id <>", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThan(Integer value) {
            addCriterion("member_id >", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("member_id >=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThan(Integer value) {
            addCriterion("member_id <", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThanOrEqualTo(Integer value) {
            addCriterion("member_id <=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdIn(List<Integer> values) {
            addCriterion("member_id in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotIn(List<Integer> values) {
            addCriterion("member_id not in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdBetween(Integer value1, Integer value2) {
            addCriterion("member_id between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotBetween(Integer value1, Integer value2) {
            addCriterion("member_id not between", value1, value2, "memberId");
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

        public Criteria andProductCountIsNull() {
            addCriterion("product_count is null");
            return (Criteria) this;
        }

        public Criteria andProductCountIsNotNull() {
            addCriterion("product_count is not null");
            return (Criteria) this;
        }

        public Criteria andProductCountEqualTo(Integer value) {
            addCriterion("product_count =", value, "productCount");
            return (Criteria) this;
        }

        public Criteria andProductCountNotEqualTo(Integer value) {
            addCriterion("product_count <>", value, "productCount");
            return (Criteria) this;
        }

        public Criteria andProductCountGreaterThan(Integer value) {
            addCriterion("product_count >", value, "productCount");
            return (Criteria) this;
        }

        public Criteria andProductCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_count >=", value, "productCount");
            return (Criteria) this;
        }

        public Criteria andProductCountLessThan(Integer value) {
            addCriterion("product_count <", value, "productCount");
            return (Criteria) this;
        }

        public Criteria andProductCountLessThanOrEqualTo(Integer value) {
            addCriterion("product_count <=", value, "productCount");
            return (Criteria) this;
        }

        public Criteria andProductCountIn(List<Integer> values) {
            addCriterion("product_count in", values, "productCount");
            return (Criteria) this;
        }

        public Criteria andProductCountNotIn(List<Integer> values) {
            addCriterion("product_count not in", values, "productCount");
            return (Criteria) this;
        }

        public Criteria andProductCountBetween(Integer value1, Integer value2) {
            addCriterion("product_count between", value1, value2, "productCount");
            return (Criteria) this;
        }

        public Criteria andProductCountNotBetween(Integer value1, Integer value2) {
            addCriterion("product_count not between", value1, value2, "productCount");
            return (Criteria) this;
        }

        public Criteria andOrderSettlementTimeIsNull() {
            addCriterion("order_settlement_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderSettlementTimeIsNotNull() {
            addCriterion("order_settlement_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderSettlementTimeEqualTo(Date value) {
            addCriterion("order_settlement_time =", value, "orderSettlementTime");
            return (Criteria) this;
        }

        public Criteria andOrderSettlementTimeNotEqualTo(Date value) {
            addCriterion("order_settlement_time <>", value, "orderSettlementTime");
            return (Criteria) this;
        }

        public Criteria andOrderSettlementTimeGreaterThan(Date value) {
            addCriterion("order_settlement_time >", value, "orderSettlementTime");
            return (Criteria) this;
        }

        public Criteria andOrderSettlementTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_settlement_time >=", value, "orderSettlementTime");
            return (Criteria) this;
        }

        public Criteria andOrderSettlementTimeLessThan(Date value) {
            addCriterion("order_settlement_time <", value, "orderSettlementTime");
            return (Criteria) this;
        }

        public Criteria andOrderSettlementTimeLessThanOrEqualTo(Date value) {
            addCriterion("order_settlement_time <=", value, "orderSettlementTime");
            return (Criteria) this;
        }

        public Criteria andOrderSettlementTimeIn(List<Date> values) {
            addCriterion("order_settlement_time in", values, "orderSettlementTime");
            return (Criteria) this;
        }

        public Criteria andOrderSettlementTimeNotIn(List<Date> values) {
            addCriterion("order_settlement_time not in", values, "orderSettlementTime");
            return (Criteria) this;
        }

        public Criteria andOrderSettlementTimeBetween(Date value1, Date value2) {
            addCriterion("order_settlement_time between", value1, value2, "orderSettlementTime");
            return (Criteria) this;
        }

        public Criteria andOrderSettlementTimeNotBetween(Date value1, Date value2) {
            addCriterion("order_settlement_time not between", value1, value2, "orderSettlementTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNull() {
            addCriterion("pay_time is null");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNotNull() {
            addCriterion("pay_time is not null");
            return (Criteria) this;
        }

        public Criteria andPayTimeEqualTo(Date value) {
            addCriterion("pay_time =", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotEqualTo(Date value) {
            addCriterion("pay_time <>", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThan(Date value) {
            addCriterion("pay_time >", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pay_time >=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThan(Date value) {
            addCriterion("pay_time <", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThanOrEqualTo(Date value) {
            addCriterion("pay_time <=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeIn(List<Date> values) {
            addCriterion("pay_time in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotIn(List<Date> values) {
            addCriterion("pay_time not in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeBetween(Date value1, Date value2) {
            addCriterion("pay_time between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotBetween(Date value1, Date value2) {
            addCriterion("pay_time not between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeIsNull() {
            addCriterion("delivery_time is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeIsNotNull() {
            addCriterion("delivery_time is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeEqualTo(Date value) {
            addCriterion("delivery_time =", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeNotEqualTo(Date value) {
            addCriterion("delivery_time <>", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeGreaterThan(Date value) {
            addCriterion("delivery_time >", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("delivery_time >=", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeLessThan(Date value) {
            addCriterion("delivery_time <", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeLessThanOrEqualTo(Date value) {
            addCriterion("delivery_time <=", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeIn(List<Date> values) {
            addCriterion("delivery_time in", values, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeNotIn(List<Date> values) {
            addCriterion("delivery_time not in", values, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeBetween(Date value1, Date value2) {
            addCriterion("delivery_time between", value1, value2, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeNotBetween(Date value1, Date value2) {
            addCriterion("delivery_time not between", value1, value2, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNull() {
            addCriterion("created_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNotNull() {
            addCriterion("created_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeEqualTo(Date value) {
            addCriterion("created_time =", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotEqualTo(Date value) {
            addCriterion("created_time <>", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThan(Date value) {
            addCriterion("created_time >", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("created_time >=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThan(Date value) {
            addCriterion("created_time <", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("created_time <=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIn(List<Date> values) {
            addCriterion("created_time in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotIn(List<Date> values) {
            addCriterion("created_time not in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeBetween(Date value1, Date value2) {
            addCriterion("created_time between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("created_time not between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeIsNull() {
            addCriterion("delete_time is null");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeIsNotNull() {
            addCriterion("delete_time is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeEqualTo(Date value) {
            addCriterion("delete_time =", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeNotEqualTo(Date value) {
            addCriterion("delete_time <>", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeGreaterThan(Date value) {
            addCriterion("delete_time >", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("delete_time >=", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeLessThan(Date value) {
            addCriterion("delete_time <", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeLessThanOrEqualTo(Date value) {
            addCriterion("delete_time <=", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeIn(List<Date> values) {
            addCriterion("delete_time in", values, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeNotIn(List<Date> values) {
            addCriterion("delete_time not in", values, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeBetween(Date value1, Date value2) {
            addCriterion("delete_time between", value1, value2, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeNotBetween(Date value1, Date value2) {
            addCriterion("delete_time not between", value1, value2, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andOrderDelFalgIsNull() {
            addCriterion("order_del_falg is null");
            return (Criteria) this;
        }

        public Criteria andOrderDelFalgIsNotNull() {
            addCriterion("order_del_falg is not null");
            return (Criteria) this;
        }

        public Criteria andOrderDelFalgEqualTo(Integer value) {
            addCriterion("order_del_falg =", value, "orderDelFalg");
            return (Criteria) this;
        }

        public Criteria andOrderDelFalgNotEqualTo(Integer value) {
            addCriterion("order_del_falg <>", value, "orderDelFalg");
            return (Criteria) this;
        }

        public Criteria andOrderDelFalgGreaterThan(Integer value) {
            addCriterion("order_del_falg >", value, "orderDelFalg");
            return (Criteria) this;
        }

        public Criteria andOrderDelFalgGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_del_falg >=", value, "orderDelFalg");
            return (Criteria) this;
        }

        public Criteria andOrderDelFalgLessThan(Integer value) {
            addCriterion("order_del_falg <", value, "orderDelFalg");
            return (Criteria) this;
        }

        public Criteria andOrderDelFalgLessThanOrEqualTo(Integer value) {
            addCriterion("order_del_falg <=", value, "orderDelFalg");
            return (Criteria) this;
        }

        public Criteria andOrderDelFalgIn(List<Integer> values) {
            addCriterion("order_del_falg in", values, "orderDelFalg");
            return (Criteria) this;
        }

        public Criteria andOrderDelFalgNotIn(List<Integer> values) {
            addCriterion("order_del_falg not in", values, "orderDelFalg");
            return (Criteria) this;
        }

        public Criteria andOrderDelFalgBetween(Integer value1, Integer value2) {
            addCriterion("order_del_falg between", value1, value2, "orderDelFalg");
            return (Criteria) this;
        }

        public Criteria andOrderDelFalgNotBetween(Integer value1, Integer value2) {
            addCriterion("order_del_falg not between", value1, value2, "orderDelFalg");
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
     * k2_order
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * k2_order 2019-08-06
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