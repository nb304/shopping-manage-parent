package com.king2.commons.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class K2JurisdictionExample {
    /**
     * k2_jurisdiction
     */
    protected String orderByClause;

    /**
     * k2_jurisdiction
     */
    protected boolean distinct;

    /**
     * k2_jurisdiction
     */
    protected List<Criteria> oredCriteria;

    public K2JurisdictionExample() {
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
     * k2_jurisdiction 2019-08-06
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

        public Criteria andJurIdIsNull() {
            addCriterion("jur_id is null");
            return (Criteria) this;
        }

        public Criteria andJurIdIsNotNull() {
            addCriterion("jur_id is not null");
            return (Criteria) this;
        }

        public Criteria andJurIdEqualTo(String value) {
            addCriterion("jur_id =", value, "jurId");
            return (Criteria) this;
        }

        public Criteria andJurIdNotEqualTo(String value) {
            addCriterion("jur_id <>", value, "jurId");
            return (Criteria) this;
        }

        public Criteria andJurIdGreaterThan(String value) {
            addCriterion("jur_id >", value, "jurId");
            return (Criteria) this;
        }

        public Criteria andJurIdGreaterThanOrEqualTo(String value) {
            addCriterion("jur_id >=", value, "jurId");
            return (Criteria) this;
        }

        public Criteria andJurIdLessThan(String value) {
            addCriterion("jur_id <", value, "jurId");
            return (Criteria) this;
        }

        public Criteria andJurIdLessThanOrEqualTo(String value) {
            addCriterion("jur_id <=", value, "jurId");
            return (Criteria) this;
        }

        public Criteria andJurIdLike(String value) {
            addCriterion("jur_id like", value, "jurId");
            return (Criteria) this;
        }

        public Criteria andJurIdNotLike(String value) {
            addCriterion("jur_id not like", value, "jurId");
            return (Criteria) this;
        }

        public Criteria andJurIdIn(List<String> values) {
            addCriterion("jur_id in", values, "jurId");
            return (Criteria) this;
        }

        public Criteria andJurIdNotIn(List<String> values) {
            addCriterion("jur_id not in", values, "jurId");
            return (Criteria) this;
        }

        public Criteria andJurIdBetween(String value1, String value2) {
            addCriterion("jur_id between", value1, value2, "jurId");
            return (Criteria) this;
        }

        public Criteria andJurIdNotBetween(String value1, String value2) {
            addCriterion("jur_id not between", value1, value2, "jurId");
            return (Criteria) this;
        }

        public Criteria andJurNameIsNull() {
            addCriterion("jur_name is null");
            return (Criteria) this;
        }

        public Criteria andJurNameIsNotNull() {
            addCriterion("jur_name is not null");
            return (Criteria) this;
        }

        public Criteria andJurNameEqualTo(String value) {
            addCriterion("jur_name =", value, "jurName");
            return (Criteria) this;
        }

        public Criteria andJurNameNotEqualTo(String value) {
            addCriterion("jur_name <>", value, "jurName");
            return (Criteria) this;
        }

        public Criteria andJurNameGreaterThan(String value) {
            addCriterion("jur_name >", value, "jurName");
            return (Criteria) this;
        }

        public Criteria andJurNameGreaterThanOrEqualTo(String value) {
            addCriterion("jur_name >=", value, "jurName");
            return (Criteria) this;
        }

        public Criteria andJurNameLessThan(String value) {
            addCriterion("jur_name <", value, "jurName");
            return (Criteria) this;
        }

        public Criteria andJurNameLessThanOrEqualTo(String value) {
            addCriterion("jur_name <=", value, "jurName");
            return (Criteria) this;
        }

        public Criteria andJurNameLike(String value) {
            addCriterion("jur_name like", value, "jurName");
            return (Criteria) this;
        }

        public Criteria andJurNameNotLike(String value) {
            addCriterion("jur_name not like", value, "jurName");
            return (Criteria) this;
        }

        public Criteria andJurNameIn(List<String> values) {
            addCriterion("jur_name in", values, "jurName");
            return (Criteria) this;
        }

        public Criteria andJurNameNotIn(List<String> values) {
            addCriterion("jur_name not in", values, "jurName");
            return (Criteria) this;
        }

        public Criteria andJurNameBetween(String value1, String value2) {
            addCriterion("jur_name between", value1, value2, "jurName");
            return (Criteria) this;
        }

        public Criteria andJurNameNotBetween(String value1, String value2) {
            addCriterion("jur_name not between", value1, value2, "jurName");
            return (Criteria) this;
        }

        public Criteria andJuriUrlIsNull() {
            addCriterion("juri_url is null");
            return (Criteria) this;
        }

        public Criteria andJuriUrlIsNotNull() {
            addCriterion("juri_url is not null");
            return (Criteria) this;
        }

        public Criteria andJuriUrlEqualTo(String value) {
            addCriterion("juri_url =", value, "juriUrl");
            return (Criteria) this;
        }

        public Criteria andJuriUrlNotEqualTo(String value) {
            addCriterion("juri_url <>", value, "juriUrl");
            return (Criteria) this;
        }

        public Criteria andJuriUrlGreaterThan(String value) {
            addCriterion("juri_url >", value, "juriUrl");
            return (Criteria) this;
        }

        public Criteria andJuriUrlGreaterThanOrEqualTo(String value) {
            addCriterion("juri_url >=", value, "juriUrl");
            return (Criteria) this;
        }

        public Criteria andJuriUrlLessThan(String value) {
            addCriterion("juri_url <", value, "juriUrl");
            return (Criteria) this;
        }

        public Criteria andJuriUrlLessThanOrEqualTo(String value) {
            addCriterion("juri_url <=", value, "juriUrl");
            return (Criteria) this;
        }

        public Criteria andJuriUrlLike(String value) {
            addCriterion("juri_url like", value, "juriUrl");
            return (Criteria) this;
        }

        public Criteria andJuriUrlNotLike(String value) {
            addCriterion("juri_url not like", value, "juriUrl");
            return (Criteria) this;
        }

        public Criteria andJuriUrlIn(List<String> values) {
            addCriterion("juri_url in", values, "juriUrl");
            return (Criteria) this;
        }

        public Criteria andJuriUrlNotIn(List<String> values) {
            addCriterion("juri_url not in", values, "juriUrl");
            return (Criteria) this;
        }

        public Criteria andJuriUrlBetween(String value1, String value2) {
            addCriterion("juri_url between", value1, value2, "juriUrl");
            return (Criteria) this;
        }

        public Criteria andJuriUrlNotBetween(String value1, String value2) {
            addCriterion("juri_url not between", value1, value2, "juriUrl");
            return (Criteria) this;
        }

        public Criteria andJurIconIsNull() {
            addCriterion("jur_icon is null");
            return (Criteria) this;
        }

        public Criteria andJurIconIsNotNull() {
            addCriterion("jur_icon is not null");
            return (Criteria) this;
        }

        public Criteria andJurIconEqualTo(String value) {
            addCriterion("jur_icon =", value, "jurIcon");
            return (Criteria) this;
        }

        public Criteria andJurIconNotEqualTo(String value) {
            addCriterion("jur_icon <>", value, "jurIcon");
            return (Criteria) this;
        }

        public Criteria andJurIconGreaterThan(String value) {
            addCriterion("jur_icon >", value, "jurIcon");
            return (Criteria) this;
        }

        public Criteria andJurIconGreaterThanOrEqualTo(String value) {
            addCriterion("jur_icon >=", value, "jurIcon");
            return (Criteria) this;
        }

        public Criteria andJurIconLessThan(String value) {
            addCriterion("jur_icon <", value, "jurIcon");
            return (Criteria) this;
        }

        public Criteria andJurIconLessThanOrEqualTo(String value) {
            addCriterion("jur_icon <=", value, "jurIcon");
            return (Criteria) this;
        }

        public Criteria andJurIconLike(String value) {
            addCriterion("jur_icon like", value, "jurIcon");
            return (Criteria) this;
        }

        public Criteria andJurIconNotLike(String value) {
            addCriterion("jur_icon not like", value, "jurIcon");
            return (Criteria) this;
        }

        public Criteria andJurIconIn(List<String> values) {
            addCriterion("jur_icon in", values, "jurIcon");
            return (Criteria) this;
        }

        public Criteria andJurIconNotIn(List<String> values) {
            addCriterion("jur_icon not in", values, "jurIcon");
            return (Criteria) this;
        }

        public Criteria andJurIconBetween(String value1, String value2) {
            addCriterion("jur_icon between", value1, value2, "jurIcon");
            return (Criteria) this;
        }

        public Criteria andJurIconNotBetween(String value1, String value2) {
            addCriterion("jur_icon not between", value1, value2, "jurIcon");
            return (Criteria) this;
        }

        public Criteria andJurParentIdIsNull() {
            addCriterion("jur_parent_id is null");
            return (Criteria) this;
        }

        public Criteria andJurParentIdIsNotNull() {
            addCriterion("jur_parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andJurParentIdEqualTo(String value) {
            addCriterion("jur_parent_id =", value, "jurParentId");
            return (Criteria) this;
        }

        public Criteria andJurParentIdNotEqualTo(String value) {
            addCriterion("jur_parent_id <>", value, "jurParentId");
            return (Criteria) this;
        }

        public Criteria andJurParentIdGreaterThan(String value) {
            addCriterion("jur_parent_id >", value, "jurParentId");
            return (Criteria) this;
        }

        public Criteria andJurParentIdGreaterThanOrEqualTo(String value) {
            addCriterion("jur_parent_id >=", value, "jurParentId");
            return (Criteria) this;
        }

        public Criteria andJurParentIdLessThan(String value) {
            addCriterion("jur_parent_id <", value, "jurParentId");
            return (Criteria) this;
        }

        public Criteria andJurParentIdLessThanOrEqualTo(String value) {
            addCriterion("jur_parent_id <=", value, "jurParentId");
            return (Criteria) this;
        }

        public Criteria andJurParentIdLike(String value) {
            addCriterion("jur_parent_id like", value, "jurParentId");
            return (Criteria) this;
        }

        public Criteria andJurParentIdNotLike(String value) {
            addCriterion("jur_parent_id not like", value, "jurParentId");
            return (Criteria) this;
        }

        public Criteria andJurParentIdIn(List<String> values) {
            addCriterion("jur_parent_id in", values, "jurParentId");
            return (Criteria) this;
        }

        public Criteria andJurParentIdNotIn(List<String> values) {
            addCriterion("jur_parent_id not in", values, "jurParentId");
            return (Criteria) this;
        }

        public Criteria andJurParentIdBetween(String value1, String value2) {
            addCriterion("jur_parent_id between", value1, value2, "jurParentId");
            return (Criteria) this;
        }

        public Criteria andJurParentIdNotBetween(String value1, String value2) {
            addCriterion("jur_parent_id not between", value1, value2, "jurParentId");
            return (Criteria) this;
        }

        public Criteria andJurComponentIsNull() {
            addCriterion("jur_component is null");
            return (Criteria) this;
        }

        public Criteria andJurComponentIsNotNull() {
            addCriterion("jur_component is not null");
            return (Criteria) this;
        }

        public Criteria andJurComponentEqualTo(String value) {
            addCriterion("jur_component =", value, "jurComponent");
            return (Criteria) this;
        }

        public Criteria andJurComponentNotEqualTo(String value) {
            addCriterion("jur_component <>", value, "jurComponent");
            return (Criteria) this;
        }

        public Criteria andJurComponentGreaterThan(String value) {
            addCriterion("jur_component >", value, "jurComponent");
            return (Criteria) this;
        }

        public Criteria andJurComponentGreaterThanOrEqualTo(String value) {
            addCriterion("jur_component >=", value, "jurComponent");
            return (Criteria) this;
        }

        public Criteria andJurComponentLessThan(String value) {
            addCriterion("jur_component <", value, "jurComponent");
            return (Criteria) this;
        }

        public Criteria andJurComponentLessThanOrEqualTo(String value) {
            addCriterion("jur_component <=", value, "jurComponent");
            return (Criteria) this;
        }

        public Criteria andJurComponentLike(String value) {
            addCriterion("jur_component like", value, "jurComponent");
            return (Criteria) this;
        }

        public Criteria andJurComponentNotLike(String value) {
            addCriterion("jur_component not like", value, "jurComponent");
            return (Criteria) this;
        }

        public Criteria andJurComponentIn(List<String> values) {
            addCriterion("jur_component in", values, "jurComponent");
            return (Criteria) this;
        }

        public Criteria andJurComponentNotIn(List<String> values) {
            addCriterion("jur_component not in", values, "jurComponent");
            return (Criteria) this;
        }

        public Criteria andJurComponentBetween(String value1, String value2) {
            addCriterion("jur_component between", value1, value2, "jurComponent");
            return (Criteria) this;
        }

        public Criteria andJurComponentNotBetween(String value1, String value2) {
            addCriterion("jur_component not between", value1, value2, "jurComponent");
            return (Criteria) this;
        }

        public Criteria andJurCreateTimeIsNull() {
            addCriterion("jur_create_time is null");
            return (Criteria) this;
        }

        public Criteria andJurCreateTimeIsNotNull() {
            addCriterion("jur_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andJurCreateTimeEqualTo(Date value) {
            addCriterion("jur_create_time =", value, "jurCreateTime");
            return (Criteria) this;
        }

        public Criteria andJurCreateTimeNotEqualTo(Date value) {
            addCriterion("jur_create_time <>", value, "jurCreateTime");
            return (Criteria) this;
        }

        public Criteria andJurCreateTimeGreaterThan(Date value) {
            addCriterion("jur_create_time >", value, "jurCreateTime");
            return (Criteria) this;
        }

        public Criteria andJurCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("jur_create_time >=", value, "jurCreateTime");
            return (Criteria) this;
        }

        public Criteria andJurCreateTimeLessThan(Date value) {
            addCriterion("jur_create_time <", value, "jurCreateTime");
            return (Criteria) this;
        }

        public Criteria andJurCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("jur_create_time <=", value, "jurCreateTime");
            return (Criteria) this;
        }

        public Criteria andJurCreateTimeIn(List<Date> values) {
            addCriterion("jur_create_time in", values, "jurCreateTime");
            return (Criteria) this;
        }

        public Criteria andJurCreateTimeNotIn(List<Date> values) {
            addCriterion("jur_create_time not in", values, "jurCreateTime");
            return (Criteria) this;
        }

        public Criteria andJurCreateTimeBetween(Date value1, Date value2) {
            addCriterion("jur_create_time between", value1, value2, "jurCreateTime");
            return (Criteria) this;
        }

        public Criteria andJurCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("jur_create_time not between", value1, value2, "jurCreateTime");
            return (Criteria) this;
        }

        public Criteria andJurUpdateTimeIsNull() {
            addCriterion("jur_update_time is null");
            return (Criteria) this;
        }

        public Criteria andJurUpdateTimeIsNotNull() {
            addCriterion("jur_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andJurUpdateTimeEqualTo(Date value) {
            addCriterion("jur_update_time =", value, "jurUpdateTime");
            return (Criteria) this;
        }

        public Criteria andJurUpdateTimeNotEqualTo(Date value) {
            addCriterion("jur_update_time <>", value, "jurUpdateTime");
            return (Criteria) this;
        }

        public Criteria andJurUpdateTimeGreaterThan(Date value) {
            addCriterion("jur_update_time >", value, "jurUpdateTime");
            return (Criteria) this;
        }

        public Criteria andJurUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("jur_update_time >=", value, "jurUpdateTime");
            return (Criteria) this;
        }

        public Criteria andJurUpdateTimeLessThan(Date value) {
            addCriterion("jur_update_time <", value, "jurUpdateTime");
            return (Criteria) this;
        }

        public Criteria andJurUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("jur_update_time <=", value, "jurUpdateTime");
            return (Criteria) this;
        }

        public Criteria andJurUpdateTimeIn(List<Date> values) {
            addCriterion("jur_update_time in", values, "jurUpdateTime");
            return (Criteria) this;
        }

        public Criteria andJurUpdateTimeNotIn(List<Date> values) {
            addCriterion("jur_update_time not in", values, "jurUpdateTime");
            return (Criteria) this;
        }

        public Criteria andJurUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("jur_update_time between", value1, value2, "jurUpdateTime");
            return (Criteria) this;
        }

        public Criteria andJurUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("jur_update_time not between", value1, value2, "jurUpdateTime");
            return (Criteria) this;
        }

        public Criteria andJurDelFlagIsNull() {
            addCriterion("jur_del_flag is null");
            return (Criteria) this;
        }

        public Criteria andJurDelFlagIsNotNull() {
            addCriterion("jur_del_flag is not null");
            return (Criteria) this;
        }

        public Criteria andJurDelFlagEqualTo(Integer value) {
            addCriterion("jur_del_flag =", value, "jurDelFlag");
            return (Criteria) this;
        }

        public Criteria andJurDelFlagNotEqualTo(Integer value) {
            addCriterion("jur_del_flag <>", value, "jurDelFlag");
            return (Criteria) this;
        }

        public Criteria andJurDelFlagGreaterThan(Integer value) {
            addCriterion("jur_del_flag >", value, "jurDelFlag");
            return (Criteria) this;
        }

        public Criteria andJurDelFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("jur_del_flag >=", value, "jurDelFlag");
            return (Criteria) this;
        }

        public Criteria andJurDelFlagLessThan(Integer value) {
            addCriterion("jur_del_flag <", value, "jurDelFlag");
            return (Criteria) this;
        }

        public Criteria andJurDelFlagLessThanOrEqualTo(Integer value) {
            addCriterion("jur_del_flag <=", value, "jurDelFlag");
            return (Criteria) this;
        }

        public Criteria andJurDelFlagIn(List<Integer> values) {
            addCriterion("jur_del_flag in", values, "jurDelFlag");
            return (Criteria) this;
        }

        public Criteria andJurDelFlagNotIn(List<Integer> values) {
            addCriterion("jur_del_flag not in", values, "jurDelFlag");
            return (Criteria) this;
        }

        public Criteria andJurDelFlagBetween(Integer value1, Integer value2) {
            addCriterion("jur_del_flag between", value1, value2, "jurDelFlag");
            return (Criteria) this;
        }

        public Criteria andJurDelFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("jur_del_flag not between", value1, value2, "jurDelFlag");
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
     * k2_jurisdiction
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * k2_jurisdiction 2019-08-06
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