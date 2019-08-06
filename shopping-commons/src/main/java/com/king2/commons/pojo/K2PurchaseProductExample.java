package com.king2.commons.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class K2PurchaseProductExample {
    /**
     * k2_purchase_product
     */
    protected String orderByClause;

    /**
     * k2_purchase_product
     */
    protected boolean distinct;

    /**
     * k2_purchase_product
     */
    protected List<Criteria> oredCriteria;

    public K2PurchaseProductExample() {
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
     * k2_purchase_product 2019-08-06
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

        public Criteria andPpIdIsNull() {
            addCriterion("pp_id is null");
            return (Criteria) this;
        }

        public Criteria andPpIdIsNotNull() {
            addCriterion("pp_id is not null");
            return (Criteria) this;
        }

        public Criteria andPpIdEqualTo(Integer value) {
            addCriterion("pp_id =", value, "ppId");
            return (Criteria) this;
        }

        public Criteria andPpIdNotEqualTo(Integer value) {
            addCriterion("pp_id <>", value, "ppId");
            return (Criteria) this;
        }

        public Criteria andPpIdGreaterThan(Integer value) {
            addCriterion("pp_id >", value, "ppId");
            return (Criteria) this;
        }

        public Criteria andPpIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pp_id >=", value, "ppId");
            return (Criteria) this;
        }

        public Criteria andPpIdLessThan(Integer value) {
            addCriterion("pp_id <", value, "ppId");
            return (Criteria) this;
        }

        public Criteria andPpIdLessThanOrEqualTo(Integer value) {
            addCriterion("pp_id <=", value, "ppId");
            return (Criteria) this;
        }

        public Criteria andPpIdIn(List<Integer> values) {
            addCriterion("pp_id in", values, "ppId");
            return (Criteria) this;
        }

        public Criteria andPpIdNotIn(List<Integer> values) {
            addCriterion("pp_id not in", values, "ppId");
            return (Criteria) this;
        }

        public Criteria andPpIdBetween(Integer value1, Integer value2) {
            addCriterion("pp_id between", value1, value2, "ppId");
            return (Criteria) this;
        }

        public Criteria andPpIdNotBetween(Integer value1, Integer value2) {
            addCriterion("pp_id not between", value1, value2, "ppId");
            return (Criteria) this;
        }

        public Criteria andPpProductNameIsNull() {
            addCriterion("pp_product_name is null");
            return (Criteria) this;
        }

        public Criteria andPpProductNameIsNotNull() {
            addCriterion("pp_product_name is not null");
            return (Criteria) this;
        }

        public Criteria andPpProductNameEqualTo(String value) {
            addCriterion("pp_product_name =", value, "ppProductName");
            return (Criteria) this;
        }

        public Criteria andPpProductNameNotEqualTo(String value) {
            addCriterion("pp_product_name <>", value, "ppProductName");
            return (Criteria) this;
        }

        public Criteria andPpProductNameGreaterThan(String value) {
            addCriterion("pp_product_name >", value, "ppProductName");
            return (Criteria) this;
        }

        public Criteria andPpProductNameGreaterThanOrEqualTo(String value) {
            addCriterion("pp_product_name >=", value, "ppProductName");
            return (Criteria) this;
        }

        public Criteria andPpProductNameLessThan(String value) {
            addCriterion("pp_product_name <", value, "ppProductName");
            return (Criteria) this;
        }

        public Criteria andPpProductNameLessThanOrEqualTo(String value) {
            addCriterion("pp_product_name <=", value, "ppProductName");
            return (Criteria) this;
        }

        public Criteria andPpProductNameLike(String value) {
            addCriterion("pp_product_name like", value, "ppProductName");
            return (Criteria) this;
        }

        public Criteria andPpProductNameNotLike(String value) {
            addCriterion("pp_product_name not like", value, "ppProductName");
            return (Criteria) this;
        }

        public Criteria andPpProductNameIn(List<String> values) {
            addCriterion("pp_product_name in", values, "ppProductName");
            return (Criteria) this;
        }

        public Criteria andPpProductNameNotIn(List<String> values) {
            addCriterion("pp_product_name not in", values, "ppProductName");
            return (Criteria) this;
        }

        public Criteria andPpProductNameBetween(String value1, String value2) {
            addCriterion("pp_product_name between", value1, value2, "ppProductName");
            return (Criteria) this;
        }

        public Criteria andPpProductNameNotBetween(String value1, String value2) {
            addCriterion("pp_product_name not between", value1, value2, "ppProductName");
            return (Criteria) this;
        }

        public Criteria andPpProductDescIsNull() {
            addCriterion("pp_product_desc is null");
            return (Criteria) this;
        }

        public Criteria andPpProductDescIsNotNull() {
            addCriterion("pp_product_desc is not null");
            return (Criteria) this;
        }

        public Criteria andPpProductDescEqualTo(String value) {
            addCriterion("pp_product_desc =", value, "ppProductDesc");
            return (Criteria) this;
        }

        public Criteria andPpProductDescNotEqualTo(String value) {
            addCriterion("pp_product_desc <>", value, "ppProductDesc");
            return (Criteria) this;
        }

        public Criteria andPpProductDescGreaterThan(String value) {
            addCriterion("pp_product_desc >", value, "ppProductDesc");
            return (Criteria) this;
        }

        public Criteria andPpProductDescGreaterThanOrEqualTo(String value) {
            addCriterion("pp_product_desc >=", value, "ppProductDesc");
            return (Criteria) this;
        }

        public Criteria andPpProductDescLessThan(String value) {
            addCriterion("pp_product_desc <", value, "ppProductDesc");
            return (Criteria) this;
        }

        public Criteria andPpProductDescLessThanOrEqualTo(String value) {
            addCriterion("pp_product_desc <=", value, "ppProductDesc");
            return (Criteria) this;
        }

        public Criteria andPpProductDescLike(String value) {
            addCriterion("pp_product_desc like", value, "ppProductDesc");
            return (Criteria) this;
        }

        public Criteria andPpProductDescNotLike(String value) {
            addCriterion("pp_product_desc not like", value, "ppProductDesc");
            return (Criteria) this;
        }

        public Criteria andPpProductDescIn(List<String> values) {
            addCriterion("pp_product_desc in", values, "ppProductDesc");
            return (Criteria) this;
        }

        public Criteria andPpProductDescNotIn(List<String> values) {
            addCriterion("pp_product_desc not in", values, "ppProductDesc");
            return (Criteria) this;
        }

        public Criteria andPpProductDescBetween(String value1, String value2) {
            addCriterion("pp_product_desc between", value1, value2, "ppProductDesc");
            return (Criteria) this;
        }

        public Criteria andPpProductDescNotBetween(String value1, String value2) {
            addCriterion("pp_product_desc not between", value1, value2, "ppProductDesc");
            return (Criteria) this;
        }

        public Criteria andPpProductNumberIsNull() {
            addCriterion("pp_product_number is null");
            return (Criteria) this;
        }

        public Criteria andPpProductNumberIsNotNull() {
            addCriterion("pp_product_number is not null");
            return (Criteria) this;
        }

        public Criteria andPpProductNumberEqualTo(Integer value) {
            addCriterion("pp_product_number =", value, "ppProductNumber");
            return (Criteria) this;
        }

        public Criteria andPpProductNumberNotEqualTo(Integer value) {
            addCriterion("pp_product_number <>", value, "ppProductNumber");
            return (Criteria) this;
        }

        public Criteria andPpProductNumberGreaterThan(Integer value) {
            addCriterion("pp_product_number >", value, "ppProductNumber");
            return (Criteria) this;
        }

        public Criteria andPpProductNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("pp_product_number >=", value, "ppProductNumber");
            return (Criteria) this;
        }

        public Criteria andPpProductNumberLessThan(Integer value) {
            addCriterion("pp_product_number <", value, "ppProductNumber");
            return (Criteria) this;
        }

        public Criteria andPpProductNumberLessThanOrEqualTo(Integer value) {
            addCriterion("pp_product_number <=", value, "ppProductNumber");
            return (Criteria) this;
        }

        public Criteria andPpProductNumberIn(List<Integer> values) {
            addCriterion("pp_product_number in", values, "ppProductNumber");
            return (Criteria) this;
        }

        public Criteria andPpProductNumberNotIn(List<Integer> values) {
            addCriterion("pp_product_number not in", values, "ppProductNumber");
            return (Criteria) this;
        }

        public Criteria andPpProductNumberBetween(Integer value1, Integer value2) {
            addCriterion("pp_product_number between", value1, value2, "ppProductNumber");
            return (Criteria) this;
        }

        public Criteria andPpProductNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("pp_product_number not between", value1, value2, "ppProductNumber");
            return (Criteria) this;
        }

        public Criteria andPpPriceCountIsNull() {
            addCriterion("pp_price_count is null");
            return (Criteria) this;
        }

        public Criteria andPpPriceCountIsNotNull() {
            addCriterion("pp_price_count is not null");
            return (Criteria) this;
        }

        public Criteria andPpPriceCountEqualTo(BigDecimal value) {
            addCriterion("pp_price_count =", value, "ppPriceCount");
            return (Criteria) this;
        }

        public Criteria andPpPriceCountNotEqualTo(BigDecimal value) {
            addCriterion("pp_price_count <>", value, "ppPriceCount");
            return (Criteria) this;
        }

        public Criteria andPpPriceCountGreaterThan(BigDecimal value) {
            addCriterion("pp_price_count >", value, "ppPriceCount");
            return (Criteria) this;
        }

        public Criteria andPpPriceCountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("pp_price_count >=", value, "ppPriceCount");
            return (Criteria) this;
        }

        public Criteria andPpPriceCountLessThan(BigDecimal value) {
            addCriterion("pp_price_count <", value, "ppPriceCount");
            return (Criteria) this;
        }

        public Criteria andPpPriceCountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("pp_price_count <=", value, "ppPriceCount");
            return (Criteria) this;
        }

        public Criteria andPpPriceCountIn(List<BigDecimal> values) {
            addCriterion("pp_price_count in", values, "ppPriceCount");
            return (Criteria) this;
        }

        public Criteria andPpPriceCountNotIn(List<BigDecimal> values) {
            addCriterion("pp_price_count not in", values, "ppPriceCount");
            return (Criteria) this;
        }

        public Criteria andPpPriceCountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pp_price_count between", value1, value2, "ppPriceCount");
            return (Criteria) this;
        }

        public Criteria andPpPriceCountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pp_price_count not between", value1, value2, "ppPriceCount");
            return (Criteria) this;
        }

        public Criteria andPpGoodsQuantityIsNull() {
            addCriterion("pp_goods_quantity is null");
            return (Criteria) this;
        }

        public Criteria andPpGoodsQuantityIsNotNull() {
            addCriterion("pp_goods_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andPpGoodsQuantityEqualTo(Integer value) {
            addCriterion("pp_goods_quantity =", value, "ppGoodsQuantity");
            return (Criteria) this;
        }

        public Criteria andPpGoodsQuantityNotEqualTo(Integer value) {
            addCriterion("pp_goods_quantity <>", value, "ppGoodsQuantity");
            return (Criteria) this;
        }

        public Criteria andPpGoodsQuantityGreaterThan(Integer value) {
            addCriterion("pp_goods_quantity >", value, "ppGoodsQuantity");
            return (Criteria) this;
        }

        public Criteria andPpGoodsQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("pp_goods_quantity >=", value, "ppGoodsQuantity");
            return (Criteria) this;
        }

        public Criteria andPpGoodsQuantityLessThan(Integer value) {
            addCriterion("pp_goods_quantity <", value, "ppGoodsQuantity");
            return (Criteria) this;
        }

        public Criteria andPpGoodsQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("pp_goods_quantity <=", value, "ppGoodsQuantity");
            return (Criteria) this;
        }

        public Criteria andPpGoodsQuantityIn(List<Integer> values) {
            addCriterion("pp_goods_quantity in", values, "ppGoodsQuantity");
            return (Criteria) this;
        }

        public Criteria andPpGoodsQuantityNotIn(List<Integer> values) {
            addCriterion("pp_goods_quantity not in", values, "ppGoodsQuantity");
            return (Criteria) this;
        }

        public Criteria andPpGoodsQuantityBetween(Integer value1, Integer value2) {
            addCriterion("pp_goods_quantity between", value1, value2, "ppGoodsQuantity");
            return (Criteria) this;
        }

        public Criteria andPpGoodsQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("pp_goods_quantity not between", value1, value2, "ppGoodsQuantity");
            return (Criteria) this;
        }

        public Criteria andPpDelFlagIsNull() {
            addCriterion("pp_del_flag is null");
            return (Criteria) this;
        }

        public Criteria andPpDelFlagIsNotNull() {
            addCriterion("pp_del_flag is not null");
            return (Criteria) this;
        }

        public Criteria andPpDelFlagEqualTo(Integer value) {
            addCriterion("pp_del_flag =", value, "ppDelFlag");
            return (Criteria) this;
        }

        public Criteria andPpDelFlagNotEqualTo(Integer value) {
            addCriterion("pp_del_flag <>", value, "ppDelFlag");
            return (Criteria) this;
        }

        public Criteria andPpDelFlagGreaterThan(Integer value) {
            addCriterion("pp_del_flag >", value, "ppDelFlag");
            return (Criteria) this;
        }

        public Criteria andPpDelFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("pp_del_flag >=", value, "ppDelFlag");
            return (Criteria) this;
        }

        public Criteria andPpDelFlagLessThan(Integer value) {
            addCriterion("pp_del_flag <", value, "ppDelFlag");
            return (Criteria) this;
        }

        public Criteria andPpDelFlagLessThanOrEqualTo(Integer value) {
            addCriterion("pp_del_flag <=", value, "ppDelFlag");
            return (Criteria) this;
        }

        public Criteria andPpDelFlagIn(List<Integer> values) {
            addCriterion("pp_del_flag in", values, "ppDelFlag");
            return (Criteria) this;
        }

        public Criteria andPpDelFlagNotIn(List<Integer> values) {
            addCriterion("pp_del_flag not in", values, "ppDelFlag");
            return (Criteria) this;
        }

        public Criteria andPpDelFlagBetween(Integer value1, Integer value2) {
            addCriterion("pp_del_flag between", value1, value2, "ppDelFlag");
            return (Criteria) this;
        }

        public Criteria andPpDelFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("pp_del_flag not between", value1, value2, "ppDelFlag");
            return (Criteria) this;
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
     * k2_purchase_product
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * k2_purchase_product 2019-08-06
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