package com.king2.commons.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class K2MemberDeliveryAddressExample {
    /**
     * k2_member_delivery_address
     */
    protected String orderByClause;

    /**
     * k2_member_delivery_address
     */
    protected boolean distinct;

    /**
     * k2_member_delivery_address
     */
    protected List<Criteria> oredCriteria;

    public K2MemberDeliveryAddressExample() {
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
     * k2_member_delivery_address 2019-08-06
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

        public Criteria andDaIdIsNull() {
            addCriterion("da_id is null");
            return (Criteria) this;
        }

        public Criteria andDaIdIsNotNull() {
            addCriterion("da_id is not null");
            return (Criteria) this;
        }

        public Criteria andDaIdEqualTo(Integer value) {
            addCriterion("da_id =", value, "daId");
            return (Criteria) this;
        }

        public Criteria andDaIdNotEqualTo(Integer value) {
            addCriterion("da_id <>", value, "daId");
            return (Criteria) this;
        }

        public Criteria andDaIdGreaterThan(Integer value) {
            addCriterion("da_id >", value, "daId");
            return (Criteria) this;
        }

        public Criteria andDaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("da_id >=", value, "daId");
            return (Criteria) this;
        }

        public Criteria andDaIdLessThan(Integer value) {
            addCriterion("da_id <", value, "daId");
            return (Criteria) this;
        }

        public Criteria andDaIdLessThanOrEqualTo(Integer value) {
            addCriterion("da_id <=", value, "daId");
            return (Criteria) this;
        }

        public Criteria andDaIdIn(List<Integer> values) {
            addCriterion("da_id in", values, "daId");
            return (Criteria) this;
        }

        public Criteria andDaIdNotIn(List<Integer> values) {
            addCriterion("da_id not in", values, "daId");
            return (Criteria) this;
        }

        public Criteria andDaIdBetween(Integer value1, Integer value2) {
            addCriterion("da_id between", value1, value2, "daId");
            return (Criteria) this;
        }

        public Criteria andDaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("da_id not between", value1, value2, "daId");
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

        public Criteria andDaTelphoneIsNull() {
            addCriterion("da_telphone is null");
            return (Criteria) this;
        }

        public Criteria andDaTelphoneIsNotNull() {
            addCriterion("da_telphone is not null");
            return (Criteria) this;
        }

        public Criteria andDaTelphoneEqualTo(String value) {
            addCriterion("da_telphone =", value, "daTelphone");
            return (Criteria) this;
        }

        public Criteria andDaTelphoneNotEqualTo(String value) {
            addCriterion("da_telphone <>", value, "daTelphone");
            return (Criteria) this;
        }

        public Criteria andDaTelphoneGreaterThan(String value) {
            addCriterion("da_telphone >", value, "daTelphone");
            return (Criteria) this;
        }

        public Criteria andDaTelphoneGreaterThanOrEqualTo(String value) {
            addCriterion("da_telphone >=", value, "daTelphone");
            return (Criteria) this;
        }

        public Criteria andDaTelphoneLessThan(String value) {
            addCriterion("da_telphone <", value, "daTelphone");
            return (Criteria) this;
        }

        public Criteria andDaTelphoneLessThanOrEqualTo(String value) {
            addCriterion("da_telphone <=", value, "daTelphone");
            return (Criteria) this;
        }

        public Criteria andDaTelphoneLike(String value) {
            addCriterion("da_telphone like", value, "daTelphone");
            return (Criteria) this;
        }

        public Criteria andDaTelphoneNotLike(String value) {
            addCriterion("da_telphone not like", value, "daTelphone");
            return (Criteria) this;
        }

        public Criteria andDaTelphoneIn(List<String> values) {
            addCriterion("da_telphone in", values, "daTelphone");
            return (Criteria) this;
        }

        public Criteria andDaTelphoneNotIn(List<String> values) {
            addCriterion("da_telphone not in", values, "daTelphone");
            return (Criteria) this;
        }

        public Criteria andDaTelphoneBetween(String value1, String value2) {
            addCriterion("da_telphone between", value1, value2, "daTelphone");
            return (Criteria) this;
        }

        public Criteria andDaTelphoneNotBetween(String value1, String value2) {
            addCriterion("da_telphone not between", value1, value2, "daTelphone");
            return (Criteria) this;
        }

        public Criteria andDaCountryIsNull() {
            addCriterion("da_country is null");
            return (Criteria) this;
        }

        public Criteria andDaCountryIsNotNull() {
            addCriterion("da_country is not null");
            return (Criteria) this;
        }

        public Criteria andDaCountryEqualTo(String value) {
            addCriterion("da_country =", value, "daCountry");
            return (Criteria) this;
        }

        public Criteria andDaCountryNotEqualTo(String value) {
            addCriterion("da_country <>", value, "daCountry");
            return (Criteria) this;
        }

        public Criteria andDaCountryGreaterThan(String value) {
            addCriterion("da_country >", value, "daCountry");
            return (Criteria) this;
        }

        public Criteria andDaCountryGreaterThanOrEqualTo(String value) {
            addCriterion("da_country >=", value, "daCountry");
            return (Criteria) this;
        }

        public Criteria andDaCountryLessThan(String value) {
            addCriterion("da_country <", value, "daCountry");
            return (Criteria) this;
        }

        public Criteria andDaCountryLessThanOrEqualTo(String value) {
            addCriterion("da_country <=", value, "daCountry");
            return (Criteria) this;
        }

        public Criteria andDaCountryLike(String value) {
            addCriterion("da_country like", value, "daCountry");
            return (Criteria) this;
        }

        public Criteria andDaCountryNotLike(String value) {
            addCriterion("da_country not like", value, "daCountry");
            return (Criteria) this;
        }

        public Criteria andDaCountryIn(List<String> values) {
            addCriterion("da_country in", values, "daCountry");
            return (Criteria) this;
        }

        public Criteria andDaCountryNotIn(List<String> values) {
            addCriterion("da_country not in", values, "daCountry");
            return (Criteria) this;
        }

        public Criteria andDaCountryBetween(String value1, String value2) {
            addCriterion("da_country between", value1, value2, "daCountry");
            return (Criteria) this;
        }

        public Criteria andDaCountryNotBetween(String value1, String value2) {
            addCriterion("da_country not between", value1, value2, "daCountry");
            return (Criteria) this;
        }

        public Criteria andDaProvinceIsNull() {
            addCriterion("da_province is null");
            return (Criteria) this;
        }

        public Criteria andDaProvinceIsNotNull() {
            addCriterion("da_province is not null");
            return (Criteria) this;
        }

        public Criteria andDaProvinceEqualTo(String value) {
            addCriterion("da_province =", value, "daProvince");
            return (Criteria) this;
        }

        public Criteria andDaProvinceNotEqualTo(String value) {
            addCriterion("da_province <>", value, "daProvince");
            return (Criteria) this;
        }

        public Criteria andDaProvinceGreaterThan(String value) {
            addCriterion("da_province >", value, "daProvince");
            return (Criteria) this;
        }

        public Criteria andDaProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("da_province >=", value, "daProvince");
            return (Criteria) this;
        }

        public Criteria andDaProvinceLessThan(String value) {
            addCriterion("da_province <", value, "daProvince");
            return (Criteria) this;
        }

        public Criteria andDaProvinceLessThanOrEqualTo(String value) {
            addCriterion("da_province <=", value, "daProvince");
            return (Criteria) this;
        }

        public Criteria andDaProvinceLike(String value) {
            addCriterion("da_province like", value, "daProvince");
            return (Criteria) this;
        }

        public Criteria andDaProvinceNotLike(String value) {
            addCriterion("da_province not like", value, "daProvince");
            return (Criteria) this;
        }

        public Criteria andDaProvinceIn(List<String> values) {
            addCriterion("da_province in", values, "daProvince");
            return (Criteria) this;
        }

        public Criteria andDaProvinceNotIn(List<String> values) {
            addCriterion("da_province not in", values, "daProvince");
            return (Criteria) this;
        }

        public Criteria andDaProvinceBetween(String value1, String value2) {
            addCriterion("da_province between", value1, value2, "daProvince");
            return (Criteria) this;
        }

        public Criteria andDaProvinceNotBetween(String value1, String value2) {
            addCriterion("da_province not between", value1, value2, "daProvince");
            return (Criteria) this;
        }

        public Criteria andDaCityIsNull() {
            addCriterion("da_city is null");
            return (Criteria) this;
        }

        public Criteria andDaCityIsNotNull() {
            addCriterion("da_city is not null");
            return (Criteria) this;
        }

        public Criteria andDaCityEqualTo(String value) {
            addCriterion("da_city =", value, "daCity");
            return (Criteria) this;
        }

        public Criteria andDaCityNotEqualTo(String value) {
            addCriterion("da_city <>", value, "daCity");
            return (Criteria) this;
        }

        public Criteria andDaCityGreaterThan(String value) {
            addCriterion("da_city >", value, "daCity");
            return (Criteria) this;
        }

        public Criteria andDaCityGreaterThanOrEqualTo(String value) {
            addCriterion("da_city >=", value, "daCity");
            return (Criteria) this;
        }

        public Criteria andDaCityLessThan(String value) {
            addCriterion("da_city <", value, "daCity");
            return (Criteria) this;
        }

        public Criteria andDaCityLessThanOrEqualTo(String value) {
            addCriterion("da_city <=", value, "daCity");
            return (Criteria) this;
        }

        public Criteria andDaCityLike(String value) {
            addCriterion("da_city like", value, "daCity");
            return (Criteria) this;
        }

        public Criteria andDaCityNotLike(String value) {
            addCriterion("da_city not like", value, "daCity");
            return (Criteria) this;
        }

        public Criteria andDaCityIn(List<String> values) {
            addCriterion("da_city in", values, "daCity");
            return (Criteria) this;
        }

        public Criteria andDaCityNotIn(List<String> values) {
            addCriterion("da_city not in", values, "daCity");
            return (Criteria) this;
        }

        public Criteria andDaCityBetween(String value1, String value2) {
            addCriterion("da_city between", value1, value2, "daCity");
            return (Criteria) this;
        }

        public Criteria andDaCityNotBetween(String value1, String value2) {
            addCriterion("da_city not between", value1, value2, "daCity");
            return (Criteria) this;
        }

        public Criteria andDaAreaIsNull() {
            addCriterion("da_area is null");
            return (Criteria) this;
        }

        public Criteria andDaAreaIsNotNull() {
            addCriterion("da_area is not null");
            return (Criteria) this;
        }

        public Criteria andDaAreaEqualTo(String value) {
            addCriterion("da_area =", value, "daArea");
            return (Criteria) this;
        }

        public Criteria andDaAreaNotEqualTo(String value) {
            addCriterion("da_area <>", value, "daArea");
            return (Criteria) this;
        }

        public Criteria andDaAreaGreaterThan(String value) {
            addCriterion("da_area >", value, "daArea");
            return (Criteria) this;
        }

        public Criteria andDaAreaGreaterThanOrEqualTo(String value) {
            addCriterion("da_area >=", value, "daArea");
            return (Criteria) this;
        }

        public Criteria andDaAreaLessThan(String value) {
            addCriterion("da_area <", value, "daArea");
            return (Criteria) this;
        }

        public Criteria andDaAreaLessThanOrEqualTo(String value) {
            addCriterion("da_area <=", value, "daArea");
            return (Criteria) this;
        }

        public Criteria andDaAreaLike(String value) {
            addCriterion("da_area like", value, "daArea");
            return (Criteria) this;
        }

        public Criteria andDaAreaNotLike(String value) {
            addCriterion("da_area not like", value, "daArea");
            return (Criteria) this;
        }

        public Criteria andDaAreaIn(List<String> values) {
            addCriterion("da_area in", values, "daArea");
            return (Criteria) this;
        }

        public Criteria andDaAreaNotIn(List<String> values) {
            addCriterion("da_area not in", values, "daArea");
            return (Criteria) this;
        }

        public Criteria andDaAreaBetween(String value1, String value2) {
            addCriterion("da_area between", value1, value2, "daArea");
            return (Criteria) this;
        }

        public Criteria andDaAreaNotBetween(String value1, String value2) {
            addCriterion("da_area not between", value1, value2, "daArea");
            return (Criteria) this;
        }

        public Criteria andDaStreetIsNull() {
            addCriterion("da_street is null");
            return (Criteria) this;
        }

        public Criteria andDaStreetIsNotNull() {
            addCriterion("da_street is not null");
            return (Criteria) this;
        }

        public Criteria andDaStreetEqualTo(String value) {
            addCriterion("da_street =", value, "daStreet");
            return (Criteria) this;
        }

        public Criteria andDaStreetNotEqualTo(String value) {
            addCriterion("da_street <>", value, "daStreet");
            return (Criteria) this;
        }

        public Criteria andDaStreetGreaterThan(String value) {
            addCriterion("da_street >", value, "daStreet");
            return (Criteria) this;
        }

        public Criteria andDaStreetGreaterThanOrEqualTo(String value) {
            addCriterion("da_street >=", value, "daStreet");
            return (Criteria) this;
        }

        public Criteria andDaStreetLessThan(String value) {
            addCriterion("da_street <", value, "daStreet");
            return (Criteria) this;
        }

        public Criteria andDaStreetLessThanOrEqualTo(String value) {
            addCriterion("da_street <=", value, "daStreet");
            return (Criteria) this;
        }

        public Criteria andDaStreetLike(String value) {
            addCriterion("da_street like", value, "daStreet");
            return (Criteria) this;
        }

        public Criteria andDaStreetNotLike(String value) {
            addCriterion("da_street not like", value, "daStreet");
            return (Criteria) this;
        }

        public Criteria andDaStreetIn(List<String> values) {
            addCriterion("da_street in", values, "daStreet");
            return (Criteria) this;
        }

        public Criteria andDaStreetNotIn(List<String> values) {
            addCriterion("da_street not in", values, "daStreet");
            return (Criteria) this;
        }

        public Criteria andDaStreetBetween(String value1, String value2) {
            addCriterion("da_street between", value1, value2, "daStreet");
            return (Criteria) this;
        }

        public Criteria andDaStreetNotBetween(String value1, String value2) {
            addCriterion("da_street not between", value1, value2, "daStreet");
            return (Criteria) this;
        }

        public Criteria andDaZipIsNull() {
            addCriterion("da_zip is null");
            return (Criteria) this;
        }

        public Criteria andDaZipIsNotNull() {
            addCriterion("da_zip is not null");
            return (Criteria) this;
        }

        public Criteria andDaZipEqualTo(String value) {
            addCriterion("da_zip =", value, "daZip");
            return (Criteria) this;
        }

        public Criteria andDaZipNotEqualTo(String value) {
            addCriterion("da_zip <>", value, "daZip");
            return (Criteria) this;
        }

        public Criteria andDaZipGreaterThan(String value) {
            addCriterion("da_zip >", value, "daZip");
            return (Criteria) this;
        }

        public Criteria andDaZipGreaterThanOrEqualTo(String value) {
            addCriterion("da_zip >=", value, "daZip");
            return (Criteria) this;
        }

        public Criteria andDaZipLessThan(String value) {
            addCriterion("da_zip <", value, "daZip");
            return (Criteria) this;
        }

        public Criteria andDaZipLessThanOrEqualTo(String value) {
            addCriterion("da_zip <=", value, "daZip");
            return (Criteria) this;
        }

        public Criteria andDaZipLike(String value) {
            addCriterion("da_zip like", value, "daZip");
            return (Criteria) this;
        }

        public Criteria andDaZipNotLike(String value) {
            addCriterion("da_zip not like", value, "daZip");
            return (Criteria) this;
        }

        public Criteria andDaZipIn(List<String> values) {
            addCriterion("da_zip in", values, "daZip");
            return (Criteria) this;
        }

        public Criteria andDaZipNotIn(List<String> values) {
            addCriterion("da_zip not in", values, "daZip");
            return (Criteria) this;
        }

        public Criteria andDaZipBetween(String value1, String value2) {
            addCriterion("da_zip between", value1, value2, "daZip");
            return (Criteria) this;
        }

        public Criteria andDaZipNotBetween(String value1, String value2) {
            addCriterion("da_zip not between", value1, value2, "daZip");
            return (Criteria) this;
        }

        public Criteria andDaDefAddressIsNull() {
            addCriterion("da_def_address is null");
            return (Criteria) this;
        }

        public Criteria andDaDefAddressIsNotNull() {
            addCriterion("da_def_address is not null");
            return (Criteria) this;
        }

        public Criteria andDaDefAddressEqualTo(Integer value) {
            addCriterion("da_def_address =", value, "daDefAddress");
            return (Criteria) this;
        }

        public Criteria andDaDefAddressNotEqualTo(Integer value) {
            addCriterion("da_def_address <>", value, "daDefAddress");
            return (Criteria) this;
        }

        public Criteria andDaDefAddressGreaterThan(Integer value) {
            addCriterion("da_def_address >", value, "daDefAddress");
            return (Criteria) this;
        }

        public Criteria andDaDefAddressGreaterThanOrEqualTo(Integer value) {
            addCriterion("da_def_address >=", value, "daDefAddress");
            return (Criteria) this;
        }

        public Criteria andDaDefAddressLessThan(Integer value) {
            addCriterion("da_def_address <", value, "daDefAddress");
            return (Criteria) this;
        }

        public Criteria andDaDefAddressLessThanOrEqualTo(Integer value) {
            addCriterion("da_def_address <=", value, "daDefAddress");
            return (Criteria) this;
        }

        public Criteria andDaDefAddressIn(List<Integer> values) {
            addCriterion("da_def_address in", values, "daDefAddress");
            return (Criteria) this;
        }

        public Criteria andDaDefAddressNotIn(List<Integer> values) {
            addCriterion("da_def_address not in", values, "daDefAddress");
            return (Criteria) this;
        }

        public Criteria andDaDefAddressBetween(Integer value1, Integer value2) {
            addCriterion("da_def_address between", value1, value2, "daDefAddress");
            return (Criteria) this;
        }

        public Criteria andDaDefAddressNotBetween(Integer value1, Integer value2) {
            addCriterion("da_def_address not between", value1, value2, "daDefAddress");
            return (Criteria) this;
        }

        public Criteria andDaCreateTimeIsNull() {
            addCriterion("da_create_time is null");
            return (Criteria) this;
        }

        public Criteria andDaCreateTimeIsNotNull() {
            addCriterion("da_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andDaCreateTimeEqualTo(Date value) {
            addCriterion("da_create_time =", value, "daCreateTime");
            return (Criteria) this;
        }

        public Criteria andDaCreateTimeNotEqualTo(Date value) {
            addCriterion("da_create_time <>", value, "daCreateTime");
            return (Criteria) this;
        }

        public Criteria andDaCreateTimeGreaterThan(Date value) {
            addCriterion("da_create_time >", value, "daCreateTime");
            return (Criteria) this;
        }

        public Criteria andDaCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("da_create_time >=", value, "daCreateTime");
            return (Criteria) this;
        }

        public Criteria andDaCreateTimeLessThan(Date value) {
            addCriterion("da_create_time <", value, "daCreateTime");
            return (Criteria) this;
        }

        public Criteria andDaCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("da_create_time <=", value, "daCreateTime");
            return (Criteria) this;
        }

        public Criteria andDaCreateTimeIn(List<Date> values) {
            addCriterion("da_create_time in", values, "daCreateTime");
            return (Criteria) this;
        }

        public Criteria andDaCreateTimeNotIn(List<Date> values) {
            addCriterion("da_create_time not in", values, "daCreateTime");
            return (Criteria) this;
        }

        public Criteria andDaCreateTimeBetween(Date value1, Date value2) {
            addCriterion("da_create_time between", value1, value2, "daCreateTime");
            return (Criteria) this;
        }

        public Criteria andDaCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("da_create_time not between", value1, value2, "daCreateTime");
            return (Criteria) this;
        }

        public Criteria andDaDelFlagIsNull() {
            addCriterion("da_del_flag is null");
            return (Criteria) this;
        }

        public Criteria andDaDelFlagIsNotNull() {
            addCriterion("da_del_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDaDelFlagEqualTo(Integer value) {
            addCriterion("da_del_flag =", value, "daDelFlag");
            return (Criteria) this;
        }

        public Criteria andDaDelFlagNotEqualTo(Integer value) {
            addCriterion("da_del_flag <>", value, "daDelFlag");
            return (Criteria) this;
        }

        public Criteria andDaDelFlagGreaterThan(Integer value) {
            addCriterion("da_del_flag >", value, "daDelFlag");
            return (Criteria) this;
        }

        public Criteria andDaDelFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("da_del_flag >=", value, "daDelFlag");
            return (Criteria) this;
        }

        public Criteria andDaDelFlagLessThan(Integer value) {
            addCriterion("da_del_flag <", value, "daDelFlag");
            return (Criteria) this;
        }

        public Criteria andDaDelFlagLessThanOrEqualTo(Integer value) {
            addCriterion("da_del_flag <=", value, "daDelFlag");
            return (Criteria) this;
        }

        public Criteria andDaDelFlagIn(List<Integer> values) {
            addCriterion("da_del_flag in", values, "daDelFlag");
            return (Criteria) this;
        }

        public Criteria andDaDelFlagNotIn(List<Integer> values) {
            addCriterion("da_del_flag not in", values, "daDelFlag");
            return (Criteria) this;
        }

        public Criteria andDaDelFlagBetween(Integer value1, Integer value2) {
            addCriterion("da_del_flag between", value1, value2, "daDelFlag");
            return (Criteria) this;
        }

        public Criteria andDaDelFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("da_del_flag not between", value1, value2, "daDelFlag");
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
     * k2_member_delivery_address
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * k2_member_delivery_address 2019-08-06
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