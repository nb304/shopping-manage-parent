package com.king2.commons.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class K2ProductExample {
    /**
     * k2_product
     */
    protected String orderByClause;

    /**
     * k2_product
     */
    protected boolean distinct;

    /**
     * k2_product
     */
    protected List<Criteria> oredCriteria;

    public K2ProductExample() {
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
     * k2_product 2019-08-06
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

        public Criteria andProductBrandIdIsNull() {
            addCriterion("product_brand_id is null");
            return (Criteria) this;
        }

        public Criteria andProductBrandIdIsNotNull() {
            addCriterion("product_brand_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductBrandIdEqualTo(Integer value) {
            addCriterion("product_brand_id =", value, "productBrandId");
            return (Criteria) this;
        }

        public Criteria andProductBrandIdNotEqualTo(Integer value) {
            addCriterion("product_brand_id <>", value, "productBrandId");
            return (Criteria) this;
        }

        public Criteria andProductBrandIdGreaterThan(Integer value) {
            addCriterion("product_brand_id >", value, "productBrandId");
            return (Criteria) this;
        }

        public Criteria andProductBrandIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_brand_id >=", value, "productBrandId");
            return (Criteria) this;
        }

        public Criteria andProductBrandIdLessThan(Integer value) {
            addCriterion("product_brand_id <", value, "productBrandId");
            return (Criteria) this;
        }

        public Criteria andProductBrandIdLessThanOrEqualTo(Integer value) {
            addCriterion("product_brand_id <=", value, "productBrandId");
            return (Criteria) this;
        }

        public Criteria andProductBrandIdIn(List<Integer> values) {
            addCriterion("product_brand_id in", values, "productBrandId");
            return (Criteria) this;
        }

        public Criteria andProductBrandIdNotIn(List<Integer> values) {
            addCriterion("product_brand_id not in", values, "productBrandId");
            return (Criteria) this;
        }

        public Criteria andProductBrandIdBetween(Integer value1, Integer value2) {
            addCriterion("product_brand_id between", value1, value2, "productBrandId");
            return (Criteria) this;
        }

        public Criteria andProductBrandIdNotBetween(Integer value1, Integer value2) {
            addCriterion("product_brand_id not between", value1, value2, "productBrandId");
            return (Criteria) this;
        }

        public Criteria andProductOneCategoryIdIsNull() {
            addCriterion("product_one_category_id is null");
            return (Criteria) this;
        }

        public Criteria andProductOneCategoryIdIsNotNull() {
            addCriterion("product_one_category_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductOneCategoryIdEqualTo(Integer value) {
            addCriterion("product_one_category_id =", value, "productOneCategoryId");
            return (Criteria) this;
        }

        public Criteria andProductOneCategoryIdNotEqualTo(Integer value) {
            addCriterion("product_one_category_id <>", value, "productOneCategoryId");
            return (Criteria) this;
        }

        public Criteria andProductOneCategoryIdGreaterThan(Integer value) {
            addCriterion("product_one_category_id >", value, "productOneCategoryId");
            return (Criteria) this;
        }

        public Criteria andProductOneCategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_one_category_id >=", value, "productOneCategoryId");
            return (Criteria) this;
        }

        public Criteria andProductOneCategoryIdLessThan(Integer value) {
            addCriterion("product_one_category_id <", value, "productOneCategoryId");
            return (Criteria) this;
        }

        public Criteria andProductOneCategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("product_one_category_id <=", value, "productOneCategoryId");
            return (Criteria) this;
        }

        public Criteria andProductOneCategoryIdIn(List<Integer> values) {
            addCriterion("product_one_category_id in", values, "productOneCategoryId");
            return (Criteria) this;
        }

        public Criteria andProductOneCategoryIdNotIn(List<Integer> values) {
            addCriterion("product_one_category_id not in", values, "productOneCategoryId");
            return (Criteria) this;
        }

        public Criteria andProductOneCategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("product_one_category_id between", value1, value2, "productOneCategoryId");
            return (Criteria) this;
        }

        public Criteria andProductOneCategoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("product_one_category_id not between", value1, value2, "productOneCategoryId");
            return (Criteria) this;
        }

        public Criteria andProductTwoCategoryIdIsNull() {
            addCriterion("product_two_category_id is null");
            return (Criteria) this;
        }

        public Criteria andProductTwoCategoryIdIsNotNull() {
            addCriterion("product_two_category_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductTwoCategoryIdEqualTo(Integer value) {
            addCriterion("product_two_category_id =", value, "productTwoCategoryId");
            return (Criteria) this;
        }

        public Criteria andProductTwoCategoryIdNotEqualTo(Integer value) {
            addCriterion("product_two_category_id <>", value, "productTwoCategoryId");
            return (Criteria) this;
        }

        public Criteria andProductTwoCategoryIdGreaterThan(Integer value) {
            addCriterion("product_two_category_id >", value, "productTwoCategoryId");
            return (Criteria) this;
        }

        public Criteria andProductTwoCategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_two_category_id >=", value, "productTwoCategoryId");
            return (Criteria) this;
        }

        public Criteria andProductTwoCategoryIdLessThan(Integer value) {
            addCriterion("product_two_category_id <", value, "productTwoCategoryId");
            return (Criteria) this;
        }

        public Criteria andProductTwoCategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("product_two_category_id <=", value, "productTwoCategoryId");
            return (Criteria) this;
        }

        public Criteria andProductTwoCategoryIdIn(List<Integer> values) {
            addCriterion("product_two_category_id in", values, "productTwoCategoryId");
            return (Criteria) this;
        }

        public Criteria andProductTwoCategoryIdNotIn(List<Integer> values) {
            addCriterion("product_two_category_id not in", values, "productTwoCategoryId");
            return (Criteria) this;
        }

        public Criteria andProductTwoCategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("product_two_category_id between", value1, value2, "productTwoCategoryId");
            return (Criteria) this;
        }

        public Criteria andProductTwoCategoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("product_two_category_id not between", value1, value2, "productTwoCategoryId");
            return (Criteria) this;
        }

        public Criteria andProductBazaarPriceIsNull() {
            addCriterion("product_bazaar_price is null");
            return (Criteria) this;
        }

        public Criteria andProductBazaarPriceIsNotNull() {
            addCriterion("product_bazaar_price is not null");
            return (Criteria) this;
        }

        public Criteria andProductBazaarPriceEqualTo(BigDecimal value) {
            addCriterion("product_bazaar_price =", value, "productBazaarPrice");
            return (Criteria) this;
        }

        public Criteria andProductBazaarPriceNotEqualTo(BigDecimal value) {
            addCriterion("product_bazaar_price <>", value, "productBazaarPrice");
            return (Criteria) this;
        }

        public Criteria andProductBazaarPriceGreaterThan(BigDecimal value) {
            addCriterion("product_bazaar_price >", value, "productBazaarPrice");
            return (Criteria) this;
        }

        public Criteria andProductBazaarPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("product_bazaar_price >=", value, "productBazaarPrice");
            return (Criteria) this;
        }

        public Criteria andProductBazaarPriceLessThan(BigDecimal value) {
            addCriterion("product_bazaar_price <", value, "productBazaarPrice");
            return (Criteria) this;
        }

        public Criteria andProductBazaarPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("product_bazaar_price <=", value, "productBazaarPrice");
            return (Criteria) this;
        }

        public Criteria andProductBazaarPriceIn(List<BigDecimal> values) {
            addCriterion("product_bazaar_price in", values, "productBazaarPrice");
            return (Criteria) this;
        }

        public Criteria andProductBazaarPriceNotIn(List<BigDecimal> values) {
            addCriterion("product_bazaar_price not in", values, "productBazaarPrice");
            return (Criteria) this;
        }

        public Criteria andProductBazaarPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("product_bazaar_price between", value1, value2, "productBazaarPrice");
            return (Criteria) this;
        }

        public Criteria andProductBazaarPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("product_bazaar_price not between", value1, value2, "productBazaarPrice");
            return (Criteria) this;
        }

        public Criteria andProductSystemPriceIsNull() {
            addCriterion("product_system_price is null");
            return (Criteria) this;
        }

        public Criteria andProductSystemPriceIsNotNull() {
            addCriterion("product_system_price is not null");
            return (Criteria) this;
        }

        public Criteria andProductSystemPriceEqualTo(BigDecimal value) {
            addCriterion("product_system_price =", value, "productSystemPrice");
            return (Criteria) this;
        }

        public Criteria andProductSystemPriceNotEqualTo(BigDecimal value) {
            addCriterion("product_system_price <>", value, "productSystemPrice");
            return (Criteria) this;
        }

        public Criteria andProductSystemPriceGreaterThan(BigDecimal value) {
            addCriterion("product_system_price >", value, "productSystemPrice");
            return (Criteria) this;
        }

        public Criteria andProductSystemPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("product_system_price >=", value, "productSystemPrice");
            return (Criteria) this;
        }

        public Criteria andProductSystemPriceLessThan(BigDecimal value) {
            addCriterion("product_system_price <", value, "productSystemPrice");
            return (Criteria) this;
        }

        public Criteria andProductSystemPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("product_system_price <=", value, "productSystemPrice");
            return (Criteria) this;
        }

        public Criteria andProductSystemPriceIn(List<BigDecimal> values) {
            addCriterion("product_system_price in", values, "productSystemPrice");
            return (Criteria) this;
        }

        public Criteria andProductSystemPriceNotIn(List<BigDecimal> values) {
            addCriterion("product_system_price not in", values, "productSystemPrice");
            return (Criteria) this;
        }

        public Criteria andProductSystemPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("product_system_price between", value1, value2, "productSystemPrice");
            return (Criteria) this;
        }

        public Criteria andProductSystemPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("product_system_price not between", value1, value2, "productSystemPrice");
            return (Criteria) this;
        }

        public Criteria andProductOrderRuleIsNull() {
            addCriterion("product_order_rule is null");
            return (Criteria) this;
        }

        public Criteria andProductOrderRuleIsNotNull() {
            addCriterion("product_order_rule is not null");
            return (Criteria) this;
        }

        public Criteria andProductOrderRuleEqualTo(Integer value) {
            addCriterion("product_order_rule =", value, "productOrderRule");
            return (Criteria) this;
        }

        public Criteria andProductOrderRuleNotEqualTo(Integer value) {
            addCriterion("product_order_rule <>", value, "productOrderRule");
            return (Criteria) this;
        }

        public Criteria andProductOrderRuleGreaterThan(Integer value) {
            addCriterion("product_order_rule >", value, "productOrderRule");
            return (Criteria) this;
        }

        public Criteria andProductOrderRuleGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_order_rule >=", value, "productOrderRule");
            return (Criteria) this;
        }

        public Criteria andProductOrderRuleLessThan(Integer value) {
            addCriterion("product_order_rule <", value, "productOrderRule");
            return (Criteria) this;
        }

        public Criteria andProductOrderRuleLessThanOrEqualTo(Integer value) {
            addCriterion("product_order_rule <=", value, "productOrderRule");
            return (Criteria) this;
        }

        public Criteria andProductOrderRuleIn(List<Integer> values) {
            addCriterion("product_order_rule in", values, "productOrderRule");
            return (Criteria) this;
        }

        public Criteria andProductOrderRuleNotIn(List<Integer> values) {
            addCriterion("product_order_rule not in", values, "productOrderRule");
            return (Criteria) this;
        }

        public Criteria andProductOrderRuleBetween(Integer value1, Integer value2) {
            addCriterion("product_order_rule between", value1, value2, "productOrderRule");
            return (Criteria) this;
        }

        public Criteria andProductOrderRuleNotBetween(Integer value1, Integer value2) {
            addCriterion("product_order_rule not between", value1, value2, "productOrderRule");
            return (Criteria) this;
        }

        public Criteria andProductUnitIsNull() {
            addCriterion("product_unit is null");
            return (Criteria) this;
        }

        public Criteria andProductUnitIsNotNull() {
            addCriterion("product_unit is not null");
            return (Criteria) this;
        }

        public Criteria andProductUnitEqualTo(String value) {
            addCriterion("product_unit =", value, "productUnit");
            return (Criteria) this;
        }

        public Criteria andProductUnitNotEqualTo(String value) {
            addCriterion("product_unit <>", value, "productUnit");
            return (Criteria) this;
        }

        public Criteria andProductUnitGreaterThan(String value) {
            addCriterion("product_unit >", value, "productUnit");
            return (Criteria) this;
        }

        public Criteria andProductUnitGreaterThanOrEqualTo(String value) {
            addCriterion("product_unit >=", value, "productUnit");
            return (Criteria) this;
        }

        public Criteria andProductUnitLessThan(String value) {
            addCriterion("product_unit <", value, "productUnit");
            return (Criteria) this;
        }

        public Criteria andProductUnitLessThanOrEqualTo(String value) {
            addCriterion("product_unit <=", value, "productUnit");
            return (Criteria) this;
        }

        public Criteria andProductUnitLike(String value) {
            addCriterion("product_unit like", value, "productUnit");
            return (Criteria) this;
        }

        public Criteria andProductUnitNotLike(String value) {
            addCriterion("product_unit not like", value, "productUnit");
            return (Criteria) this;
        }

        public Criteria andProductUnitIn(List<String> values) {
            addCriterion("product_unit in", values, "productUnit");
            return (Criteria) this;
        }

        public Criteria andProductUnitNotIn(List<String> values) {
            addCriterion("product_unit not in", values, "productUnit");
            return (Criteria) this;
        }

        public Criteria andProductUnitBetween(String value1, String value2) {
            addCriterion("product_unit between", value1, value2, "productUnit");
            return (Criteria) this;
        }

        public Criteria andProductUnitNotBetween(String value1, String value2) {
            addCriterion("product_unit not between", value1, value2, "productUnit");
            return (Criteria) this;
        }

        public Criteria andProductSketchIdIsNull() {
            addCriterion("product_sketch_id is null");
            return (Criteria) this;
        }

        public Criteria andProductSketchIdIsNotNull() {
            addCriterion("product_sketch_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductSketchIdEqualTo(Integer value) {
            addCriterion("product_sketch_id =", value, "productSketchId");
            return (Criteria) this;
        }

        public Criteria andProductSketchIdNotEqualTo(Integer value) {
            addCriterion("product_sketch_id <>", value, "productSketchId");
            return (Criteria) this;
        }

        public Criteria andProductSketchIdGreaterThan(Integer value) {
            addCriterion("product_sketch_id >", value, "productSketchId");
            return (Criteria) this;
        }

        public Criteria andProductSketchIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_sketch_id >=", value, "productSketchId");
            return (Criteria) this;
        }

        public Criteria andProductSketchIdLessThan(Integer value) {
            addCriterion("product_sketch_id <", value, "productSketchId");
            return (Criteria) this;
        }

        public Criteria andProductSketchIdLessThanOrEqualTo(Integer value) {
            addCriterion("product_sketch_id <=", value, "productSketchId");
            return (Criteria) this;
        }

        public Criteria andProductSketchIdIn(List<Integer> values) {
            addCriterion("product_sketch_id in", values, "productSketchId");
            return (Criteria) this;
        }

        public Criteria andProductSketchIdNotIn(List<Integer> values) {
            addCriterion("product_sketch_id not in", values, "productSketchId");
            return (Criteria) this;
        }

        public Criteria andProductSketchIdBetween(Integer value1, Integer value2) {
            addCriterion("product_sketch_id between", value1, value2, "productSketchId");
            return (Criteria) this;
        }

        public Criteria andProductSketchIdNotBetween(Integer value1, Integer value2) {
            addCriterion("product_sketch_id not between", value1, value2, "productSketchId");
            return (Criteria) this;
        }

        public Criteria andProductIfSupportIsNull() {
            addCriterion("product_if_support is null");
            return (Criteria) this;
        }

        public Criteria andProductIfSupportIsNotNull() {
            addCriterion("product_if_support is not null");
            return (Criteria) this;
        }

        public Criteria andProductIfSupportEqualTo(Integer value) {
            addCriterion("product_if_support =", value, "productIfSupport");
            return (Criteria) this;
        }

        public Criteria andProductIfSupportNotEqualTo(Integer value) {
            addCriterion("product_if_support <>", value, "productIfSupport");
            return (Criteria) this;
        }

        public Criteria andProductIfSupportGreaterThan(Integer value) {
            addCriterion("product_if_support >", value, "productIfSupport");
            return (Criteria) this;
        }

        public Criteria andProductIfSupportGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_if_support >=", value, "productIfSupport");
            return (Criteria) this;
        }

        public Criteria andProductIfSupportLessThan(Integer value) {
            addCriterion("product_if_support <", value, "productIfSupport");
            return (Criteria) this;
        }

        public Criteria andProductIfSupportLessThanOrEqualTo(Integer value) {
            addCriterion("product_if_support <=", value, "productIfSupport");
            return (Criteria) this;
        }

        public Criteria andProductIfSupportIn(List<Integer> values) {
            addCriterion("product_if_support in", values, "productIfSupport");
            return (Criteria) this;
        }

        public Criteria andProductIfSupportNotIn(List<Integer> values) {
            addCriterion("product_if_support not in", values, "productIfSupport");
            return (Criteria) this;
        }

        public Criteria andProductIfSupportBetween(Integer value1, Integer value2) {
            addCriterion("product_if_support between", value1, value2, "productIfSupport");
            return (Criteria) this;
        }

        public Criteria andProductIfSupportNotBetween(Integer value1, Integer value2) {
            addCriterion("product_if_support not between", value1, value2, "productIfSupport");
            return (Criteria) this;
        }

        public Criteria andProductSupportDayIsNull() {
            addCriterion("product_support_day is null");
            return (Criteria) this;
        }

        public Criteria andProductSupportDayIsNotNull() {
            addCriterion("product_support_day is not null");
            return (Criteria) this;
        }

        public Criteria andProductSupportDayEqualTo(Integer value) {
            addCriterion("product_support_day =", value, "productSupportDay");
            return (Criteria) this;
        }

        public Criteria andProductSupportDayNotEqualTo(Integer value) {
            addCriterion("product_support_day <>", value, "productSupportDay");
            return (Criteria) this;
        }

        public Criteria andProductSupportDayGreaterThan(Integer value) {
            addCriterion("product_support_day >", value, "productSupportDay");
            return (Criteria) this;
        }

        public Criteria andProductSupportDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_support_day >=", value, "productSupportDay");
            return (Criteria) this;
        }

        public Criteria andProductSupportDayLessThan(Integer value) {
            addCriterion("product_support_day <", value, "productSupportDay");
            return (Criteria) this;
        }

        public Criteria andProductSupportDayLessThanOrEqualTo(Integer value) {
            addCriterion("product_support_day <=", value, "productSupportDay");
            return (Criteria) this;
        }

        public Criteria andProductSupportDayIn(List<Integer> values) {
            addCriterion("product_support_day in", values, "productSupportDay");
            return (Criteria) this;
        }

        public Criteria andProductSupportDayNotIn(List<Integer> values) {
            addCriterion("product_support_day not in", values, "productSupportDay");
            return (Criteria) this;
        }

        public Criteria andProductSupportDayBetween(Integer value1, Integer value2) {
            addCriterion("product_support_day between", value1, value2, "productSupportDay");
            return (Criteria) this;
        }

        public Criteria andProductSupportDayNotBetween(Integer value1, Integer value2) {
            addCriterion("product_support_day not between", value1, value2, "productSupportDay");
            return (Criteria) this;
        }

        public Criteria andProductStateIsNull() {
            addCriterion("product_state is null");
            return (Criteria) this;
        }

        public Criteria andProductStateIsNotNull() {
            addCriterion("product_state is not null");
            return (Criteria) this;
        }

        public Criteria andProductStateEqualTo(Integer value) {
            addCriterion("product_state =", value, "productState");
            return (Criteria) this;
        }

        public Criteria andProductStateNotEqualTo(Integer value) {
            addCriterion("product_state <>", value, "productState");
            return (Criteria) this;
        }

        public Criteria andProductStateGreaterThan(Integer value) {
            addCriterion("product_state >", value, "productState");
            return (Criteria) this;
        }

        public Criteria andProductStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_state >=", value, "productState");
            return (Criteria) this;
        }

        public Criteria andProductStateLessThan(Integer value) {
            addCriterion("product_state <", value, "productState");
            return (Criteria) this;
        }

        public Criteria andProductStateLessThanOrEqualTo(Integer value) {
            addCriterion("product_state <=", value, "productState");
            return (Criteria) this;
        }

        public Criteria andProductStateIn(List<Integer> values) {
            addCriterion("product_state in", values, "productState");
            return (Criteria) this;
        }

        public Criteria andProductStateNotIn(List<Integer> values) {
            addCriterion("product_state not in", values, "productState");
            return (Criteria) this;
        }

        public Criteria andProductStateBetween(Integer value1, Integer value2) {
            addCriterion("product_state between", value1, value2, "productState");
            return (Criteria) this;
        }

        public Criteria andProductStateNotBetween(Integer value1, Integer value2) {
            addCriterion("product_state not between", value1, value2, "productState");
            return (Criteria) this;
        }

        public Criteria andProductCreateTimeIsNull() {
            addCriterion("product_create_time is null");
            return (Criteria) this;
        }

        public Criteria andProductCreateTimeIsNotNull() {
            addCriterion("product_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andProductCreateTimeEqualTo(Date value) {
            addCriterion("product_create_time =", value, "productCreateTime");
            return (Criteria) this;
        }

        public Criteria andProductCreateTimeNotEqualTo(Date value) {
            addCriterion("product_create_time <>", value, "productCreateTime");
            return (Criteria) this;
        }

        public Criteria andProductCreateTimeGreaterThan(Date value) {
            addCriterion("product_create_time >", value, "productCreateTime");
            return (Criteria) this;
        }

        public Criteria andProductCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("product_create_time >=", value, "productCreateTime");
            return (Criteria) this;
        }

        public Criteria andProductCreateTimeLessThan(Date value) {
            addCriterion("product_create_time <", value, "productCreateTime");
            return (Criteria) this;
        }

        public Criteria andProductCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("product_create_time <=", value, "productCreateTime");
            return (Criteria) this;
        }

        public Criteria andProductCreateTimeIn(List<Date> values) {
            addCriterion("product_create_time in", values, "productCreateTime");
            return (Criteria) this;
        }

        public Criteria andProductCreateTimeNotIn(List<Date> values) {
            addCriterion("product_create_time not in", values, "productCreateTime");
            return (Criteria) this;
        }

        public Criteria andProductCreateTimeBetween(Date value1, Date value2) {
            addCriterion("product_create_time between", value1, value2, "productCreateTime");
            return (Criteria) this;
        }

        public Criteria andProductCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("product_create_time not between", value1, value2, "productCreateTime");
            return (Criteria) this;
        }

        public Criteria andProductCreateUseridIsNull() {
            addCriterion("product_create_userid is null");
            return (Criteria) this;
        }

        public Criteria andProductCreateUseridIsNotNull() {
            addCriterion("product_create_userid is not null");
            return (Criteria) this;
        }

        public Criteria andProductCreateUseridEqualTo(Integer value) {
            addCriterion("product_create_userid =", value, "productCreateUserid");
            return (Criteria) this;
        }

        public Criteria andProductCreateUseridNotEqualTo(Integer value) {
            addCriterion("product_create_userid <>", value, "productCreateUserid");
            return (Criteria) this;
        }

        public Criteria andProductCreateUseridGreaterThan(Integer value) {
            addCriterion("product_create_userid >", value, "productCreateUserid");
            return (Criteria) this;
        }

        public Criteria andProductCreateUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_create_userid >=", value, "productCreateUserid");
            return (Criteria) this;
        }

        public Criteria andProductCreateUseridLessThan(Integer value) {
            addCriterion("product_create_userid <", value, "productCreateUserid");
            return (Criteria) this;
        }

        public Criteria andProductCreateUseridLessThanOrEqualTo(Integer value) {
            addCriterion("product_create_userid <=", value, "productCreateUserid");
            return (Criteria) this;
        }

        public Criteria andProductCreateUseridIn(List<Integer> values) {
            addCriterion("product_create_userid in", values, "productCreateUserid");
            return (Criteria) this;
        }

        public Criteria andProductCreateUseridNotIn(List<Integer> values) {
            addCriterion("product_create_userid not in", values, "productCreateUserid");
            return (Criteria) this;
        }

        public Criteria andProductCreateUseridBetween(Integer value1, Integer value2) {
            addCriterion("product_create_userid between", value1, value2, "productCreateUserid");
            return (Criteria) this;
        }

        public Criteria andProductCreateUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("product_create_userid not between", value1, value2, "productCreateUserid");
            return (Criteria) this;
        }

        public Criteria andProductCreateUsernameIsNull() {
            addCriterion("product_create_username is null");
            return (Criteria) this;
        }

        public Criteria andProductCreateUsernameIsNotNull() {
            addCriterion("product_create_username is not null");
            return (Criteria) this;
        }

        public Criteria andProductCreateUsernameEqualTo(String value) {
            addCriterion("product_create_username =", value, "productCreateUsername");
            return (Criteria) this;
        }

        public Criteria andProductCreateUsernameNotEqualTo(String value) {
            addCriterion("product_create_username <>", value, "productCreateUsername");
            return (Criteria) this;
        }

        public Criteria andProductCreateUsernameGreaterThan(String value) {
            addCriterion("product_create_username >", value, "productCreateUsername");
            return (Criteria) this;
        }

        public Criteria andProductCreateUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("product_create_username >=", value, "productCreateUsername");
            return (Criteria) this;
        }

        public Criteria andProductCreateUsernameLessThan(String value) {
            addCriterion("product_create_username <", value, "productCreateUsername");
            return (Criteria) this;
        }

        public Criteria andProductCreateUsernameLessThanOrEqualTo(String value) {
            addCriterion("product_create_username <=", value, "productCreateUsername");
            return (Criteria) this;
        }

        public Criteria andProductCreateUsernameLike(String value) {
            addCriterion("product_create_username like", value, "productCreateUsername");
            return (Criteria) this;
        }

        public Criteria andProductCreateUsernameNotLike(String value) {
            addCriterion("product_create_username not like", value, "productCreateUsername");
            return (Criteria) this;
        }

        public Criteria andProductCreateUsernameIn(List<String> values) {
            addCriterion("product_create_username in", values, "productCreateUsername");
            return (Criteria) this;
        }

        public Criteria andProductCreateUsernameNotIn(List<String> values) {
            addCriterion("product_create_username not in", values, "productCreateUsername");
            return (Criteria) this;
        }

        public Criteria andProductCreateUsernameBetween(String value1, String value2) {
            addCriterion("product_create_username between", value1, value2, "productCreateUsername");
            return (Criteria) this;
        }

        public Criteria andProductCreateUsernameNotBetween(String value1, String value2) {
            addCriterion("product_create_username not between", value1, value2, "productCreateUsername");
            return (Criteria) this;
        }

        public Criteria andProductUpdateTimeIsNull() {
            addCriterion("product_update_time is null");
            return (Criteria) this;
        }

        public Criteria andProductUpdateTimeIsNotNull() {
            addCriterion("product_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andProductUpdateTimeEqualTo(Date value) {
            addCriterion("product_update_time =", value, "productUpdateTime");
            return (Criteria) this;
        }

        public Criteria andProductUpdateTimeNotEqualTo(Date value) {
            addCriterion("product_update_time <>", value, "productUpdateTime");
            return (Criteria) this;
        }

        public Criteria andProductUpdateTimeGreaterThan(Date value) {
            addCriterion("product_update_time >", value, "productUpdateTime");
            return (Criteria) this;
        }

        public Criteria andProductUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("product_update_time >=", value, "productUpdateTime");
            return (Criteria) this;
        }

        public Criteria andProductUpdateTimeLessThan(Date value) {
            addCriterion("product_update_time <", value, "productUpdateTime");
            return (Criteria) this;
        }

        public Criteria andProductUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("product_update_time <=", value, "productUpdateTime");
            return (Criteria) this;
        }

        public Criteria andProductUpdateTimeIn(List<Date> values) {
            addCriterion("product_update_time in", values, "productUpdateTime");
            return (Criteria) this;
        }

        public Criteria andProductUpdateTimeNotIn(List<Date> values) {
            addCriterion("product_update_time not in", values, "productUpdateTime");
            return (Criteria) this;
        }

        public Criteria andProductUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("product_update_time between", value1, value2, "productUpdateTime");
            return (Criteria) this;
        }

        public Criteria andProductUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("product_update_time not between", value1, value2, "productUpdateTime");
            return (Criteria) this;
        }

        public Criteria andProductUpdateUseridIsNull() {
            addCriterion("product_update_userid is null");
            return (Criteria) this;
        }

        public Criteria andProductUpdateUseridIsNotNull() {
            addCriterion("product_update_userid is not null");
            return (Criteria) this;
        }

        public Criteria andProductUpdateUseridEqualTo(Integer value) {
            addCriterion("product_update_userid =", value, "productUpdateUserid");
            return (Criteria) this;
        }

        public Criteria andProductUpdateUseridNotEqualTo(Integer value) {
            addCriterion("product_update_userid <>", value, "productUpdateUserid");
            return (Criteria) this;
        }

        public Criteria andProductUpdateUseridGreaterThan(Integer value) {
            addCriterion("product_update_userid >", value, "productUpdateUserid");
            return (Criteria) this;
        }

        public Criteria andProductUpdateUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_update_userid >=", value, "productUpdateUserid");
            return (Criteria) this;
        }

        public Criteria andProductUpdateUseridLessThan(Integer value) {
            addCriterion("product_update_userid <", value, "productUpdateUserid");
            return (Criteria) this;
        }

        public Criteria andProductUpdateUseridLessThanOrEqualTo(Integer value) {
            addCriterion("product_update_userid <=", value, "productUpdateUserid");
            return (Criteria) this;
        }

        public Criteria andProductUpdateUseridIn(List<Integer> values) {
            addCriterion("product_update_userid in", values, "productUpdateUserid");
            return (Criteria) this;
        }

        public Criteria andProductUpdateUseridNotIn(List<Integer> values) {
            addCriterion("product_update_userid not in", values, "productUpdateUserid");
            return (Criteria) this;
        }

        public Criteria andProductUpdateUseridBetween(Integer value1, Integer value2) {
            addCriterion("product_update_userid between", value1, value2, "productUpdateUserid");
            return (Criteria) this;
        }

        public Criteria andProductUpdateUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("product_update_userid not between", value1, value2, "productUpdateUserid");
            return (Criteria) this;
        }

        public Criteria andProductUpdateUsernameIsNull() {
            addCriterion("product_update_username is null");
            return (Criteria) this;
        }

        public Criteria andProductUpdateUsernameIsNotNull() {
            addCriterion("product_update_username is not null");
            return (Criteria) this;
        }

        public Criteria andProductUpdateUsernameEqualTo(String value) {
            addCriterion("product_update_username =", value, "productUpdateUsername");
            return (Criteria) this;
        }

        public Criteria andProductUpdateUsernameNotEqualTo(String value) {
            addCriterion("product_update_username <>", value, "productUpdateUsername");
            return (Criteria) this;
        }

        public Criteria andProductUpdateUsernameGreaterThan(String value) {
            addCriterion("product_update_username >", value, "productUpdateUsername");
            return (Criteria) this;
        }

        public Criteria andProductUpdateUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("product_update_username >=", value, "productUpdateUsername");
            return (Criteria) this;
        }

        public Criteria andProductUpdateUsernameLessThan(String value) {
            addCriterion("product_update_username <", value, "productUpdateUsername");
            return (Criteria) this;
        }

        public Criteria andProductUpdateUsernameLessThanOrEqualTo(String value) {
            addCriterion("product_update_username <=", value, "productUpdateUsername");
            return (Criteria) this;
        }

        public Criteria andProductUpdateUsernameLike(String value) {
            addCriterion("product_update_username like", value, "productUpdateUsername");
            return (Criteria) this;
        }

        public Criteria andProductUpdateUsernameNotLike(String value) {
            addCriterion("product_update_username not like", value, "productUpdateUsername");
            return (Criteria) this;
        }

        public Criteria andProductUpdateUsernameIn(List<String> values) {
            addCriterion("product_update_username in", values, "productUpdateUsername");
            return (Criteria) this;
        }

        public Criteria andProductUpdateUsernameNotIn(List<String> values) {
            addCriterion("product_update_username not in", values, "productUpdateUsername");
            return (Criteria) this;
        }

        public Criteria andProductUpdateUsernameBetween(String value1, String value2) {
            addCriterion("product_update_username between", value1, value2, "productUpdateUsername");
            return (Criteria) this;
        }

        public Criteria andProductUpdateUsernameNotBetween(String value1, String value2) {
            addCriterion("product_update_username not between", value1, value2, "productUpdateUsername");
            return (Criteria) this;
        }

        public Criteria andProductStoreIdIsNull() {
            addCriterion("product_store_id is null");
            return (Criteria) this;
        }

        public Criteria andProductStoreIdIsNotNull() {
            addCriterion("product_store_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductStoreIdEqualTo(Integer value) {
            addCriterion("product_store_id =", value, "productStoreId");
            return (Criteria) this;
        }

        public Criteria andProductStoreIdNotEqualTo(Integer value) {
            addCriterion("product_store_id <>", value, "productStoreId");
            return (Criteria) this;
        }

        public Criteria andProductStoreIdGreaterThan(Integer value) {
            addCriterion("product_store_id >", value, "productStoreId");
            return (Criteria) this;
        }

        public Criteria andProductStoreIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_store_id >=", value, "productStoreId");
            return (Criteria) this;
        }

        public Criteria andProductStoreIdLessThan(Integer value) {
            addCriterion("product_store_id <", value, "productStoreId");
            return (Criteria) this;
        }

        public Criteria andProductStoreIdLessThanOrEqualTo(Integer value) {
            addCriterion("product_store_id <=", value, "productStoreId");
            return (Criteria) this;
        }

        public Criteria andProductStoreIdIn(List<Integer> values) {
            addCriterion("product_store_id in", values, "productStoreId");
            return (Criteria) this;
        }

        public Criteria andProductStoreIdNotIn(List<Integer> values) {
            addCriterion("product_store_id not in", values, "productStoreId");
            return (Criteria) this;
        }

        public Criteria andProductStoreIdBetween(Integer value1, Integer value2) {
            addCriterion("product_store_id between", value1, value2, "productStoreId");
            return (Criteria) this;
        }

        public Criteria andProductStoreIdNotBetween(Integer value1, Integer value2) {
            addCriterion("product_store_id not between", value1, value2, "productStoreId");
            return (Criteria) this;
        }

        public Criteria andProductRetain1IsNull() {
            addCriterion("product_retain1 is null");
            return (Criteria) this;
        }

        public Criteria andProductRetain1IsNotNull() {
            addCriterion("product_retain1 is not null");
            return (Criteria) this;
        }

        public Criteria andProductRetain1EqualTo(String value) {
            addCriterion("product_retain1 =", value, "productRetain1");
            return (Criteria) this;
        }

        public Criteria andProductRetain1NotEqualTo(String value) {
            addCriterion("product_retain1 <>", value, "productRetain1");
            return (Criteria) this;
        }

        public Criteria andProductRetain1GreaterThan(String value) {
            addCriterion("product_retain1 >", value, "productRetain1");
            return (Criteria) this;
        }

        public Criteria andProductRetain1GreaterThanOrEqualTo(String value) {
            addCriterion("product_retain1 >=", value, "productRetain1");
            return (Criteria) this;
        }

        public Criteria andProductRetain1LessThan(String value) {
            addCriterion("product_retain1 <", value, "productRetain1");
            return (Criteria) this;
        }

        public Criteria andProductRetain1LessThanOrEqualTo(String value) {
            addCriterion("product_retain1 <=", value, "productRetain1");
            return (Criteria) this;
        }

        public Criteria andProductRetain1Like(String value) {
            addCriterion("product_retain1 like", value, "productRetain1");
            return (Criteria) this;
        }

        public Criteria andProductRetain1NotLike(String value) {
            addCriterion("product_retain1 not like", value, "productRetain1");
            return (Criteria) this;
        }

        public Criteria andProductRetain1In(List<String> values) {
            addCriterion("product_retain1 in", values, "productRetain1");
            return (Criteria) this;
        }

        public Criteria andProductRetain1NotIn(List<String> values) {
            addCriterion("product_retain1 not in", values, "productRetain1");
            return (Criteria) this;
        }

        public Criteria andProductRetain1Between(String value1, String value2) {
            addCriterion("product_retain1 between", value1, value2, "productRetain1");
            return (Criteria) this;
        }

        public Criteria andProductRetain1NotBetween(String value1, String value2) {
            addCriterion("product_retain1 not between", value1, value2, "productRetain1");
            return (Criteria) this;
        }

        public Criteria andProductRetain2IsNull() {
            addCriterion("product_retain2 is null");
            return (Criteria) this;
        }

        public Criteria andProductRetain2IsNotNull() {
            addCriterion("product_retain2 is not null");
            return (Criteria) this;
        }

        public Criteria andProductRetain2EqualTo(String value) {
            addCriterion("product_retain2 =", value, "productRetain2");
            return (Criteria) this;
        }

        public Criteria andProductRetain2NotEqualTo(String value) {
            addCriterion("product_retain2 <>", value, "productRetain2");
            return (Criteria) this;
        }

        public Criteria andProductRetain2GreaterThan(String value) {
            addCriterion("product_retain2 >", value, "productRetain2");
            return (Criteria) this;
        }

        public Criteria andProductRetain2GreaterThanOrEqualTo(String value) {
            addCriterion("product_retain2 >=", value, "productRetain2");
            return (Criteria) this;
        }

        public Criteria andProductRetain2LessThan(String value) {
            addCriterion("product_retain2 <", value, "productRetain2");
            return (Criteria) this;
        }

        public Criteria andProductRetain2LessThanOrEqualTo(String value) {
            addCriterion("product_retain2 <=", value, "productRetain2");
            return (Criteria) this;
        }

        public Criteria andProductRetain2Like(String value) {
            addCriterion("product_retain2 like", value, "productRetain2");
            return (Criteria) this;
        }

        public Criteria andProductRetain2NotLike(String value) {
            addCriterion("product_retain2 not like", value, "productRetain2");
            return (Criteria) this;
        }

        public Criteria andProductRetain2In(List<String> values) {
            addCriterion("product_retain2 in", values, "productRetain2");
            return (Criteria) this;
        }

        public Criteria andProductRetain2NotIn(List<String> values) {
            addCriterion("product_retain2 not in", values, "productRetain2");
            return (Criteria) this;
        }

        public Criteria andProductRetain2Between(String value1, String value2) {
            addCriterion("product_retain2 between", value1, value2, "productRetain2");
            return (Criteria) this;
        }

        public Criteria andProductRetain2NotBetween(String value1, String value2) {
            addCriterion("product_retain2 not between", value1, value2, "productRetain2");
            return (Criteria) this;
        }

        public Criteria andProductRetain3IsNull() {
            addCriterion("product_retain3 is null");
            return (Criteria) this;
        }

        public Criteria andProductRetain3IsNotNull() {
            addCriterion("product_retain3 is not null");
            return (Criteria) this;
        }

        public Criteria andProductRetain3EqualTo(String value) {
            addCriterion("product_retain3 =", value, "productRetain3");
            return (Criteria) this;
        }

        public Criteria andProductRetain3NotEqualTo(String value) {
            addCriterion("product_retain3 <>", value, "productRetain3");
            return (Criteria) this;
        }

        public Criteria andProductRetain3GreaterThan(String value) {
            addCriterion("product_retain3 >", value, "productRetain3");
            return (Criteria) this;
        }

        public Criteria andProductRetain3GreaterThanOrEqualTo(String value) {
            addCriterion("product_retain3 >=", value, "productRetain3");
            return (Criteria) this;
        }

        public Criteria andProductRetain3LessThan(String value) {
            addCriterion("product_retain3 <", value, "productRetain3");
            return (Criteria) this;
        }

        public Criteria andProductRetain3LessThanOrEqualTo(String value) {
            addCriterion("product_retain3 <=", value, "productRetain3");
            return (Criteria) this;
        }

        public Criteria andProductRetain3Like(String value) {
            addCriterion("product_retain3 like", value, "productRetain3");
            return (Criteria) this;
        }

        public Criteria andProductRetain3NotLike(String value) {
            addCriterion("product_retain3 not like", value, "productRetain3");
            return (Criteria) this;
        }

        public Criteria andProductRetain3In(List<String> values) {
            addCriterion("product_retain3 in", values, "productRetain3");
            return (Criteria) this;
        }

        public Criteria andProductRetain3NotIn(List<String> values) {
            addCriterion("product_retain3 not in", values, "productRetain3");
            return (Criteria) this;
        }

        public Criteria andProductRetain3Between(String value1, String value2) {
            addCriterion("product_retain3 between", value1, value2, "productRetain3");
            return (Criteria) this;
        }

        public Criteria andProductRetain3NotBetween(String value1, String value2) {
            addCriterion("product_retain3 not between", value1, value2, "productRetain3");
            return (Criteria) this;
        }

        public Criteria andProductRetain4IsNull() {
            addCriterion("product_retain4 is null");
            return (Criteria) this;
        }

        public Criteria andProductRetain4IsNotNull() {
            addCriterion("product_retain4 is not null");
            return (Criteria) this;
        }

        public Criteria andProductRetain4EqualTo(String value) {
            addCriterion("product_retain4 =", value, "productRetain4");
            return (Criteria) this;
        }

        public Criteria andProductRetain4NotEqualTo(String value) {
            addCriterion("product_retain4 <>", value, "productRetain4");
            return (Criteria) this;
        }

        public Criteria andProductRetain4GreaterThan(String value) {
            addCriterion("product_retain4 >", value, "productRetain4");
            return (Criteria) this;
        }

        public Criteria andProductRetain4GreaterThanOrEqualTo(String value) {
            addCriterion("product_retain4 >=", value, "productRetain4");
            return (Criteria) this;
        }

        public Criteria andProductRetain4LessThan(String value) {
            addCriterion("product_retain4 <", value, "productRetain4");
            return (Criteria) this;
        }

        public Criteria andProductRetain4LessThanOrEqualTo(String value) {
            addCriterion("product_retain4 <=", value, "productRetain4");
            return (Criteria) this;
        }

        public Criteria andProductRetain4Like(String value) {
            addCriterion("product_retain4 like", value, "productRetain4");
            return (Criteria) this;
        }

        public Criteria andProductRetain4NotLike(String value) {
            addCriterion("product_retain4 not like", value, "productRetain4");
            return (Criteria) this;
        }

        public Criteria andProductRetain4In(List<String> values) {
            addCriterion("product_retain4 in", values, "productRetain4");
            return (Criteria) this;
        }

        public Criteria andProductRetain4NotIn(List<String> values) {
            addCriterion("product_retain4 not in", values, "productRetain4");
            return (Criteria) this;
        }

        public Criteria andProductRetain4Between(String value1, String value2) {
            addCriterion("product_retain4 between", value1, value2, "productRetain4");
            return (Criteria) this;
        }

        public Criteria andProductRetain4NotBetween(String value1, String value2) {
            addCriterion("product_retain4 not between", value1, value2, "productRetain4");
            return (Criteria) this;
        }

        public Criteria andProductRetain5IsNull() {
            addCriterion("product_retain5 is null");
            return (Criteria) this;
        }

        public Criteria andProductRetain5IsNotNull() {
            addCriterion("product_retain5 is not null");
            return (Criteria) this;
        }

        public Criteria andProductRetain5EqualTo(String value) {
            addCriterion("product_retain5 =", value, "productRetain5");
            return (Criteria) this;
        }

        public Criteria andProductRetain5NotEqualTo(String value) {
            addCriterion("product_retain5 <>", value, "productRetain5");
            return (Criteria) this;
        }

        public Criteria andProductRetain5GreaterThan(String value) {
            addCriterion("product_retain5 >", value, "productRetain5");
            return (Criteria) this;
        }

        public Criteria andProductRetain5GreaterThanOrEqualTo(String value) {
            addCriterion("product_retain5 >=", value, "productRetain5");
            return (Criteria) this;
        }

        public Criteria andProductRetain5LessThan(String value) {
            addCriterion("product_retain5 <", value, "productRetain5");
            return (Criteria) this;
        }

        public Criteria andProductRetain5LessThanOrEqualTo(String value) {
            addCriterion("product_retain5 <=", value, "productRetain5");
            return (Criteria) this;
        }

        public Criteria andProductRetain5Like(String value) {
            addCriterion("product_retain5 like", value, "productRetain5");
            return (Criteria) this;
        }

        public Criteria andProductRetain5NotLike(String value) {
            addCriterion("product_retain5 not like", value, "productRetain5");
            return (Criteria) this;
        }

        public Criteria andProductRetain5In(List<String> values) {
            addCriterion("product_retain5 in", values, "productRetain5");
            return (Criteria) this;
        }

        public Criteria andProductRetain5NotIn(List<String> values) {
            addCriterion("product_retain5 not in", values, "productRetain5");
            return (Criteria) this;
        }

        public Criteria andProductRetain5Between(String value1, String value2) {
            addCriterion("product_retain5 between", value1, value2, "productRetain5");
            return (Criteria) this;
        }

        public Criteria andProductRetain5NotBetween(String value1, String value2) {
            addCriterion("product_retain5 not between", value1, value2, "productRetain5");
            return (Criteria) this;
        }

        public Criteria andProductRetain6IsNull() {
            addCriterion("product_retain6 is null");
            return (Criteria) this;
        }

        public Criteria andProductRetain6IsNotNull() {
            addCriterion("product_retain6 is not null");
            return (Criteria) this;
        }

        public Criteria andProductRetain6EqualTo(String value) {
            addCriterion("product_retain6 =", value, "productRetain6");
            return (Criteria) this;
        }

        public Criteria andProductRetain6NotEqualTo(String value) {
            addCriterion("product_retain6 <>", value, "productRetain6");
            return (Criteria) this;
        }

        public Criteria andProductRetain6GreaterThan(String value) {
            addCriterion("product_retain6 >", value, "productRetain6");
            return (Criteria) this;
        }

        public Criteria andProductRetain6GreaterThanOrEqualTo(String value) {
            addCriterion("product_retain6 >=", value, "productRetain6");
            return (Criteria) this;
        }

        public Criteria andProductRetain6LessThan(String value) {
            addCriterion("product_retain6 <", value, "productRetain6");
            return (Criteria) this;
        }

        public Criteria andProductRetain6LessThanOrEqualTo(String value) {
            addCriterion("product_retain6 <=", value, "productRetain6");
            return (Criteria) this;
        }

        public Criteria andProductRetain6Like(String value) {
            addCriterion("product_retain6 like", value, "productRetain6");
            return (Criteria) this;
        }

        public Criteria andProductRetain6NotLike(String value) {
            addCriterion("product_retain6 not like", value, "productRetain6");
            return (Criteria) this;
        }

        public Criteria andProductRetain6In(List<String> values) {
            addCriterion("product_retain6 in", values, "productRetain6");
            return (Criteria) this;
        }

        public Criteria andProductRetain6NotIn(List<String> values) {
            addCriterion("product_retain6 not in", values, "productRetain6");
            return (Criteria) this;
        }

        public Criteria andProductRetain6Between(String value1, String value2) {
            addCriterion("product_retain6 between", value1, value2, "productRetain6");
            return (Criteria) this;
        }

        public Criteria andProductRetain6NotBetween(String value1, String value2) {
            addCriterion("product_retain6 not between", value1, value2, "productRetain6");
            return (Criteria) this;
        }

        public Criteria andProductRetain7IsNull() {
            addCriterion("product_retain7 is null");
            return (Criteria) this;
        }

        public Criteria andProductRetain7IsNotNull() {
            addCriterion("product_retain7 is not null");
            return (Criteria) this;
        }

        public Criteria andProductRetain7EqualTo(String value) {
            addCriterion("product_retain7 =", value, "productRetain7");
            return (Criteria) this;
        }

        public Criteria andProductRetain7NotEqualTo(String value) {
            addCriterion("product_retain7 <>", value, "productRetain7");
            return (Criteria) this;
        }

        public Criteria andProductRetain7GreaterThan(String value) {
            addCriterion("product_retain7 >", value, "productRetain7");
            return (Criteria) this;
        }

        public Criteria andProductRetain7GreaterThanOrEqualTo(String value) {
            addCriterion("product_retain7 >=", value, "productRetain7");
            return (Criteria) this;
        }

        public Criteria andProductRetain7LessThan(String value) {
            addCriterion("product_retain7 <", value, "productRetain7");
            return (Criteria) this;
        }

        public Criteria andProductRetain7LessThanOrEqualTo(String value) {
            addCriterion("product_retain7 <=", value, "productRetain7");
            return (Criteria) this;
        }

        public Criteria andProductRetain7Like(String value) {
            addCriterion("product_retain7 like", value, "productRetain7");
            return (Criteria) this;
        }

        public Criteria andProductRetain7NotLike(String value) {
            addCriterion("product_retain7 not like", value, "productRetain7");
            return (Criteria) this;
        }

        public Criteria andProductRetain7In(List<String> values) {
            addCriterion("product_retain7 in", values, "productRetain7");
            return (Criteria) this;
        }

        public Criteria andProductRetain7NotIn(List<String> values) {
            addCriterion("product_retain7 not in", values, "productRetain7");
            return (Criteria) this;
        }

        public Criteria andProductRetain7Between(String value1, String value2) {
            addCriterion("product_retain7 between", value1, value2, "productRetain7");
            return (Criteria) this;
        }

        public Criteria andProductRetain7NotBetween(String value1, String value2) {
            addCriterion("product_retain7 not between", value1, value2, "productRetain7");
            return (Criteria) this;
        }
    }

    /**
     * k2_product
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * k2_product 2019-08-06
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