package com.king2.commons.pojo;

import java.util.ArrayList;
import java.util.List;

public class K2ProductSkuValueExample {
    /**
     * k2_product_sku_value
     */
    protected String orderByClause;

    /**
     * k2_product_sku_value
     */
    protected boolean distinct;

    /**
     * k2_product_sku_value
     */
    protected List<Criteria> oredCriteria;

    public K2ProductSkuValueExample() {
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
     * k2_product_sku_value 2019-08-06
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

        public Criteria andProductSkuValueIdIsNull() {
            addCriterion("product_sku_value_id is null");
            return (Criteria) this;
        }

        public Criteria andProductSkuValueIdIsNotNull() {
            addCriterion("product_sku_value_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductSkuValueIdEqualTo(Integer value) {
            addCriterion("product_sku_value_id =", value, "productSkuValueId");
            return (Criteria) this;
        }

        public Criteria andProductSkuValueIdNotEqualTo(Integer value) {
            addCriterion("product_sku_value_id <>", value, "productSkuValueId");
            return (Criteria) this;
        }

        public Criteria andProductSkuValueIdGreaterThan(Integer value) {
            addCriterion("product_sku_value_id >", value, "productSkuValueId");
            return (Criteria) this;
        }

        public Criteria andProductSkuValueIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_sku_value_id >=", value, "productSkuValueId");
            return (Criteria) this;
        }

        public Criteria andProductSkuValueIdLessThan(Integer value) {
            addCriterion("product_sku_value_id <", value, "productSkuValueId");
            return (Criteria) this;
        }

        public Criteria andProductSkuValueIdLessThanOrEqualTo(Integer value) {
            addCriterion("product_sku_value_id <=", value, "productSkuValueId");
            return (Criteria) this;
        }

        public Criteria andProductSkuValueIdIn(List<Integer> values) {
            addCriterion("product_sku_value_id in", values, "productSkuValueId");
            return (Criteria) this;
        }

        public Criteria andProductSkuValueIdNotIn(List<Integer> values) {
            addCriterion("product_sku_value_id not in", values, "productSkuValueId");
            return (Criteria) this;
        }

        public Criteria andProductSkuValueIdBetween(Integer value1, Integer value2) {
            addCriterion("product_sku_value_id between", value1, value2, "productSkuValueId");
            return (Criteria) this;
        }

        public Criteria andProductSkuValueIdNotBetween(Integer value1, Integer value2) {
            addCriterion("product_sku_value_id not between", value1, value2, "productSkuValueId");
            return (Criteria) this;
        }

        public Criteria andSkuValueIsNull() {
            addCriterion("sku_value is null");
            return (Criteria) this;
        }

        public Criteria andSkuValueIsNotNull() {
            addCriterion("sku_value is not null");
            return (Criteria) this;
        }

        public Criteria andSkuValueEqualTo(String value) {
            addCriterion("sku_value =", value, "skuValue");
            return (Criteria) this;
        }

        public Criteria andSkuValueNotEqualTo(String value) {
            addCriterion("sku_value <>", value, "skuValue");
            return (Criteria) this;
        }

        public Criteria andSkuValueGreaterThan(String value) {
            addCriterion("sku_value >", value, "skuValue");
            return (Criteria) this;
        }

        public Criteria andSkuValueGreaterThanOrEqualTo(String value) {
            addCriterion("sku_value >=", value, "skuValue");
            return (Criteria) this;
        }

        public Criteria andSkuValueLessThan(String value) {
            addCriterion("sku_value <", value, "skuValue");
            return (Criteria) this;
        }

        public Criteria andSkuValueLessThanOrEqualTo(String value) {
            addCriterion("sku_value <=", value, "skuValue");
            return (Criteria) this;
        }

        public Criteria andSkuValueLike(String value) {
            addCriterion("sku_value like", value, "skuValue");
            return (Criteria) this;
        }

        public Criteria andSkuValueNotLike(String value) {
            addCriterion("sku_value not like", value, "skuValue");
            return (Criteria) this;
        }

        public Criteria andSkuValueIn(List<String> values) {
            addCriterion("sku_value in", values, "skuValue");
            return (Criteria) this;
        }

        public Criteria andSkuValueNotIn(List<String> values) {
            addCriterion("sku_value not in", values, "skuValue");
            return (Criteria) this;
        }

        public Criteria andSkuValueBetween(String value1, String value2) {
            addCriterion("sku_value between", value1, value2, "skuValue");
            return (Criteria) this;
        }

        public Criteria andSkuValueNotBetween(String value1, String value2) {
            addCriterion("sku_value not between", value1, value2, "skuValue");
            return (Criteria) this;
        }

        public Criteria andSkuKeyIdIsNull() {
            addCriterion("sku_key_id is null");
            return (Criteria) this;
        }

        public Criteria andSkuKeyIdIsNotNull() {
            addCriterion("sku_key_id is not null");
            return (Criteria) this;
        }

        public Criteria andSkuKeyIdEqualTo(Integer value) {
            addCriterion("sku_key_id =", value, "skuKeyId");
            return (Criteria) this;
        }

        public Criteria andSkuKeyIdNotEqualTo(Integer value) {
            addCriterion("sku_key_id <>", value, "skuKeyId");
            return (Criteria) this;
        }

        public Criteria andSkuKeyIdGreaterThan(Integer value) {
            addCriterion("sku_key_id >", value, "skuKeyId");
            return (Criteria) this;
        }

        public Criteria andSkuKeyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sku_key_id >=", value, "skuKeyId");
            return (Criteria) this;
        }

        public Criteria andSkuKeyIdLessThan(Integer value) {
            addCriterion("sku_key_id <", value, "skuKeyId");
            return (Criteria) this;
        }

        public Criteria andSkuKeyIdLessThanOrEqualTo(Integer value) {
            addCriterion("sku_key_id <=", value, "skuKeyId");
            return (Criteria) this;
        }

        public Criteria andSkuKeyIdIn(List<Integer> values) {
            addCriterion("sku_key_id in", values, "skuKeyId");
            return (Criteria) this;
        }

        public Criteria andSkuKeyIdNotIn(List<Integer> values) {
            addCriterion("sku_key_id not in", values, "skuKeyId");
            return (Criteria) this;
        }

        public Criteria andSkuKeyIdBetween(Integer value1, Integer value2) {
            addCriterion("sku_key_id between", value1, value2, "skuKeyId");
            return (Criteria) this;
        }

        public Criteria andSkuKeyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sku_key_id not between", value1, value2, "skuKeyId");
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
     * k2_product_sku_value
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * k2_product_sku_value 2019-08-06
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