package com.king2.commons.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class K2ProductSkuPriceandkcExample {
    /**
     * k2_product_sku_priceandkc
     */
    protected String orderByClause;

    /**
     * k2_product_sku_priceandkc
     */
    protected boolean distinct;

    /**
     * k2_product_sku_priceandkc
     */
    protected List<Criteria> oredCriteria;

    public K2ProductSkuPriceandkcExample() {
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
     * k2_product_sku_priceandkc 2019-08-06
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

        public Criteria andSkuPriceandkcIdIsNull() {
            addCriterion("sku_priceandkc_id is null");
            return (Criteria) this;
        }

        public Criteria andSkuPriceandkcIdIsNotNull() {
            addCriterion("sku_priceandkc_id is not null");
            return (Criteria) this;
        }

        public Criteria andSkuPriceandkcIdEqualTo(Integer value) {
            addCriterion("sku_priceandkc_id =", value, "skuPriceandkcId");
            return (Criteria) this;
        }

        public Criteria andSkuPriceandkcIdNotEqualTo(Integer value) {
            addCriterion("sku_priceandkc_id <>", value, "skuPriceandkcId");
            return (Criteria) this;
        }

        public Criteria andSkuPriceandkcIdGreaterThan(Integer value) {
            addCriterion("sku_priceandkc_id >", value, "skuPriceandkcId");
            return (Criteria) this;
        }

        public Criteria andSkuPriceandkcIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sku_priceandkc_id >=", value, "skuPriceandkcId");
            return (Criteria) this;
        }

        public Criteria andSkuPriceandkcIdLessThan(Integer value) {
            addCriterion("sku_priceandkc_id <", value, "skuPriceandkcId");
            return (Criteria) this;
        }

        public Criteria andSkuPriceandkcIdLessThanOrEqualTo(Integer value) {
            addCriterion("sku_priceandkc_id <=", value, "skuPriceandkcId");
            return (Criteria) this;
        }

        public Criteria andSkuPriceandkcIdIn(List<Integer> values) {
            addCriterion("sku_priceandkc_id in", values, "skuPriceandkcId");
            return (Criteria) this;
        }

        public Criteria andSkuPriceandkcIdNotIn(List<Integer> values) {
            addCriterion("sku_priceandkc_id not in", values, "skuPriceandkcId");
            return (Criteria) this;
        }

        public Criteria andSkuPriceandkcIdBetween(Integer value1, Integer value2) {
            addCriterion("sku_priceandkc_id between", value1, value2, "skuPriceandkcId");
            return (Criteria) this;
        }

        public Criteria andSkuPriceandkcIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sku_priceandkc_id not between", value1, value2, "skuPriceandkcId");
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

        public Criteria andProductSkuPriceIsNull() {
            addCriterion("product_sku_price is null");
            return (Criteria) this;
        }

        public Criteria andProductSkuPriceIsNotNull() {
            addCriterion("product_sku_price is not null");
            return (Criteria) this;
        }

        public Criteria andProductSkuPriceEqualTo(BigDecimal value) {
            addCriterion("product_sku_price =", value, "productSkuPrice");
            return (Criteria) this;
        }

        public Criteria andProductSkuPriceNotEqualTo(BigDecimal value) {
            addCriterion("product_sku_price <>", value, "productSkuPrice");
            return (Criteria) this;
        }

        public Criteria andProductSkuPriceGreaterThan(BigDecimal value) {
            addCriterion("product_sku_price >", value, "productSkuPrice");
            return (Criteria) this;
        }

        public Criteria andProductSkuPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("product_sku_price >=", value, "productSkuPrice");
            return (Criteria) this;
        }

        public Criteria andProductSkuPriceLessThan(BigDecimal value) {
            addCriterion("product_sku_price <", value, "productSkuPrice");
            return (Criteria) this;
        }

        public Criteria andProductSkuPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("product_sku_price <=", value, "productSkuPrice");
            return (Criteria) this;
        }

        public Criteria andProductSkuPriceIn(List<BigDecimal> values) {
            addCriterion("product_sku_price in", values, "productSkuPrice");
            return (Criteria) this;
        }

        public Criteria andProductSkuPriceNotIn(List<BigDecimal> values) {
            addCriterion("product_sku_price not in", values, "productSkuPrice");
            return (Criteria) this;
        }

        public Criteria andProductSkuPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("product_sku_price between", value1, value2, "productSkuPrice");
            return (Criteria) this;
        }

        public Criteria andProductSkuPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("product_sku_price not between", value1, value2, "productSkuPrice");
            return (Criteria) this;
        }

        public Criteria andProductSkuKcIsNull() {
            addCriterion("product_sku_kc is null");
            return (Criteria) this;
        }

        public Criteria andProductSkuKcIsNotNull() {
            addCriterion("product_sku_kc is not null");
            return (Criteria) this;
        }

        public Criteria andProductSkuKcEqualTo(Integer value) {
            addCriterion("product_sku_kc =", value, "productSkuKc");
            return (Criteria) this;
        }

        public Criteria andProductSkuKcNotEqualTo(Integer value) {
            addCriterion("product_sku_kc <>", value, "productSkuKc");
            return (Criteria) this;
        }

        public Criteria andProductSkuKcGreaterThan(Integer value) {
            addCriterion("product_sku_kc >", value, "productSkuKc");
            return (Criteria) this;
        }

        public Criteria andProductSkuKcGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_sku_kc >=", value, "productSkuKc");
            return (Criteria) this;
        }

        public Criteria andProductSkuKcLessThan(Integer value) {
            addCriterion("product_sku_kc <", value, "productSkuKc");
            return (Criteria) this;
        }

        public Criteria andProductSkuKcLessThanOrEqualTo(Integer value) {
            addCriterion("product_sku_kc <=", value, "productSkuKc");
            return (Criteria) this;
        }

        public Criteria andProductSkuKcIn(List<Integer> values) {
            addCriterion("product_sku_kc in", values, "productSkuKc");
            return (Criteria) this;
        }

        public Criteria andProductSkuKcNotIn(List<Integer> values) {
            addCriterion("product_sku_kc not in", values, "productSkuKc");
            return (Criteria) this;
        }

        public Criteria andProductSkuKcBetween(Integer value1, Integer value2) {
            addCriterion("product_sku_kc between", value1, value2, "productSkuKc");
            return (Criteria) this;
        }

        public Criteria andProductSkuKcNotBetween(Integer value1, Integer value2) {
            addCriterion("product_sku_kc not between", value1, value2, "productSkuKc");
            return (Criteria) this;
        }

        public Criteria andProductSkuValueIdsIsNull() {
            addCriterion("product_sku_value_ids is null");
            return (Criteria) this;
        }

        public Criteria andProductSkuValueIdsIsNotNull() {
            addCriterion("product_sku_value_ids is not null");
            return (Criteria) this;
        }

        public Criteria andProductSkuValueIdsEqualTo(String value) {
            addCriterion("product_sku_value_ids =", value, "productSkuValueIds");
            return (Criteria) this;
        }

        public Criteria andProductSkuValueIdsNotEqualTo(String value) {
            addCriterion("product_sku_value_ids <>", value, "productSkuValueIds");
            return (Criteria) this;
        }

        public Criteria andProductSkuValueIdsGreaterThan(String value) {
            addCriterion("product_sku_value_ids >", value, "productSkuValueIds");
            return (Criteria) this;
        }

        public Criteria andProductSkuValueIdsGreaterThanOrEqualTo(String value) {
            addCriterion("product_sku_value_ids >=", value, "productSkuValueIds");
            return (Criteria) this;
        }

        public Criteria andProductSkuValueIdsLessThan(String value) {
            addCriterion("product_sku_value_ids <", value, "productSkuValueIds");
            return (Criteria) this;
        }

        public Criteria andProductSkuValueIdsLessThanOrEqualTo(String value) {
            addCriterion("product_sku_value_ids <=", value, "productSkuValueIds");
            return (Criteria) this;
        }

        public Criteria andProductSkuValueIdsLike(String value) {
            addCriterion("product_sku_value_ids like", value, "productSkuValueIds");
            return (Criteria) this;
        }

        public Criteria andProductSkuValueIdsNotLike(String value) {
            addCriterion("product_sku_value_ids not like", value, "productSkuValueIds");
            return (Criteria) this;
        }

        public Criteria andProductSkuValueIdsIn(List<String> values) {
            addCriterion("product_sku_value_ids in", values, "productSkuValueIds");
            return (Criteria) this;
        }

        public Criteria andProductSkuValueIdsNotIn(List<String> values) {
            addCriterion("product_sku_value_ids not in", values, "productSkuValueIds");
            return (Criteria) this;
        }

        public Criteria andProductSkuValueIdsBetween(String value1, String value2) {
            addCriterion("product_sku_value_ids between", value1, value2, "productSkuValueIds");
            return (Criteria) this;
        }

        public Criteria andProductSkuValueIdsNotBetween(String value1, String value2) {
            addCriterion("product_sku_value_ids not between", value1, value2, "productSkuValueIds");
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
     * k2_product_sku_priceandkc
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * k2_product_sku_priceandkc 2019-08-06
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