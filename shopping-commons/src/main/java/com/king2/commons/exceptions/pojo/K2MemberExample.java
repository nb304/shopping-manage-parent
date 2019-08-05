package com.king2.commons.exceptions.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class K2MemberExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public K2MemberExample() {
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

        public Criteria andMemberPasswordIsNull() {
            addCriterion("member_password is null");
            return (Criteria) this;
        }

        public Criteria andMemberPasswordIsNotNull() {
            addCriterion("member_password is not null");
            return (Criteria) this;
        }

        public Criteria andMemberPasswordEqualTo(String value) {
            addCriterion("member_password =", value, "memberPassword");
            return (Criteria) this;
        }

        public Criteria andMemberPasswordNotEqualTo(String value) {
            addCriterion("member_password <>", value, "memberPassword");
            return (Criteria) this;
        }

        public Criteria andMemberPasswordGreaterThan(String value) {
            addCriterion("member_password >", value, "memberPassword");
            return (Criteria) this;
        }

        public Criteria andMemberPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("member_password >=", value, "memberPassword");
            return (Criteria) this;
        }

        public Criteria andMemberPasswordLessThan(String value) {
            addCriterion("member_password <", value, "memberPassword");
            return (Criteria) this;
        }

        public Criteria andMemberPasswordLessThanOrEqualTo(String value) {
            addCriterion("member_password <=", value, "memberPassword");
            return (Criteria) this;
        }

        public Criteria andMemberPasswordLike(String value) {
            addCriterion("member_password like", value, "memberPassword");
            return (Criteria) this;
        }

        public Criteria andMemberPasswordNotLike(String value) {
            addCriterion("member_password not like", value, "memberPassword");
            return (Criteria) this;
        }

        public Criteria andMemberPasswordIn(List<String> values) {
            addCriterion("member_password in", values, "memberPassword");
            return (Criteria) this;
        }

        public Criteria andMemberPasswordNotIn(List<String> values) {
            addCriterion("member_password not in", values, "memberPassword");
            return (Criteria) this;
        }

        public Criteria andMemberPasswordBetween(String value1, String value2) {
            addCriterion("member_password between", value1, value2, "memberPassword");
            return (Criteria) this;
        }

        public Criteria andMemberPasswordNotBetween(String value1, String value2) {
            addCriterion("member_password not between", value1, value2, "memberPassword");
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

        public Criteria andMemberPhoneIsNull() {
            addCriterion("member_phone is null");
            return (Criteria) this;
        }

        public Criteria andMemberPhoneIsNotNull() {
            addCriterion("member_phone is not null");
            return (Criteria) this;
        }

        public Criteria andMemberPhoneEqualTo(String value) {
            addCriterion("member_phone =", value, "memberPhone");
            return (Criteria) this;
        }

        public Criteria andMemberPhoneNotEqualTo(String value) {
            addCriterion("member_phone <>", value, "memberPhone");
            return (Criteria) this;
        }

        public Criteria andMemberPhoneGreaterThan(String value) {
            addCriterion("member_phone >", value, "memberPhone");
            return (Criteria) this;
        }

        public Criteria andMemberPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("member_phone >=", value, "memberPhone");
            return (Criteria) this;
        }

        public Criteria andMemberPhoneLessThan(String value) {
            addCriterion("member_phone <", value, "memberPhone");
            return (Criteria) this;
        }

        public Criteria andMemberPhoneLessThanOrEqualTo(String value) {
            addCriterion("member_phone <=", value, "memberPhone");
            return (Criteria) this;
        }

        public Criteria andMemberPhoneLike(String value) {
            addCriterion("member_phone like", value, "memberPhone");
            return (Criteria) this;
        }

        public Criteria andMemberPhoneNotLike(String value) {
            addCriterion("member_phone not like", value, "memberPhone");
            return (Criteria) this;
        }

        public Criteria andMemberPhoneIn(List<String> values) {
            addCriterion("member_phone in", values, "memberPhone");
            return (Criteria) this;
        }

        public Criteria andMemberPhoneNotIn(List<String> values) {
            addCriterion("member_phone not in", values, "memberPhone");
            return (Criteria) this;
        }

        public Criteria andMemberPhoneBetween(String value1, String value2) {
            addCriterion("member_phone between", value1, value2, "memberPhone");
            return (Criteria) this;
        }

        public Criteria andMemberPhoneNotBetween(String value1, String value2) {
            addCriterion("member_phone not between", value1, value2, "memberPhone");
            return (Criteria) this;
        }

        public Criteria andMemberUidIsNull() {
            addCriterion("member_uid is null");
            return (Criteria) this;
        }

        public Criteria andMemberUidIsNotNull() {
            addCriterion("member_uid is not null");
            return (Criteria) this;
        }

        public Criteria andMemberUidEqualTo(String value) {
            addCriterion("member_uid =", value, "memberUid");
            return (Criteria) this;
        }

        public Criteria andMemberUidNotEqualTo(String value) {
            addCriterion("member_uid <>", value, "memberUid");
            return (Criteria) this;
        }

        public Criteria andMemberUidGreaterThan(String value) {
            addCriterion("member_uid >", value, "memberUid");
            return (Criteria) this;
        }

        public Criteria andMemberUidGreaterThanOrEqualTo(String value) {
            addCriterion("member_uid >=", value, "memberUid");
            return (Criteria) this;
        }

        public Criteria andMemberUidLessThan(String value) {
            addCriterion("member_uid <", value, "memberUid");
            return (Criteria) this;
        }

        public Criteria andMemberUidLessThanOrEqualTo(String value) {
            addCriterion("member_uid <=", value, "memberUid");
            return (Criteria) this;
        }

        public Criteria andMemberUidLike(String value) {
            addCriterion("member_uid like", value, "memberUid");
            return (Criteria) this;
        }

        public Criteria andMemberUidNotLike(String value) {
            addCriterion("member_uid not like", value, "memberUid");
            return (Criteria) this;
        }

        public Criteria andMemberUidIn(List<String> values) {
            addCriterion("member_uid in", values, "memberUid");
            return (Criteria) this;
        }

        public Criteria andMemberUidNotIn(List<String> values) {
            addCriterion("member_uid not in", values, "memberUid");
            return (Criteria) this;
        }

        public Criteria andMemberUidBetween(String value1, String value2) {
            addCriterion("member_uid between", value1, value2, "memberUid");
            return (Criteria) this;
        }

        public Criteria andMemberUidNotBetween(String value1, String value2) {
            addCriterion("member_uid not between", value1, value2, "memberUid");
            return (Criteria) this;
        }

        public Criteria andMemberAddressIsNull() {
            addCriterion("member_address is null");
            return (Criteria) this;
        }

        public Criteria andMemberAddressIsNotNull() {
            addCriterion("member_address is not null");
            return (Criteria) this;
        }

        public Criteria andMemberAddressEqualTo(String value) {
            addCriterion("member_address =", value, "memberAddress");
            return (Criteria) this;
        }

        public Criteria andMemberAddressNotEqualTo(String value) {
            addCriterion("member_address <>", value, "memberAddress");
            return (Criteria) this;
        }

        public Criteria andMemberAddressGreaterThan(String value) {
            addCriterion("member_address >", value, "memberAddress");
            return (Criteria) this;
        }

        public Criteria andMemberAddressGreaterThanOrEqualTo(String value) {
            addCriterion("member_address >=", value, "memberAddress");
            return (Criteria) this;
        }

        public Criteria andMemberAddressLessThan(String value) {
            addCriterion("member_address <", value, "memberAddress");
            return (Criteria) this;
        }

        public Criteria andMemberAddressLessThanOrEqualTo(String value) {
            addCriterion("member_address <=", value, "memberAddress");
            return (Criteria) this;
        }

        public Criteria andMemberAddressLike(String value) {
            addCriterion("member_address like", value, "memberAddress");
            return (Criteria) this;
        }

        public Criteria andMemberAddressNotLike(String value) {
            addCriterion("member_address not like", value, "memberAddress");
            return (Criteria) this;
        }

        public Criteria andMemberAddressIn(List<String> values) {
            addCriterion("member_address in", values, "memberAddress");
            return (Criteria) this;
        }

        public Criteria andMemberAddressNotIn(List<String> values) {
            addCriterion("member_address not in", values, "memberAddress");
            return (Criteria) this;
        }

        public Criteria andMemberAddressBetween(String value1, String value2) {
            addCriterion("member_address between", value1, value2, "memberAddress");
            return (Criteria) this;
        }

        public Criteria andMemberAddressNotBetween(String value1, String value2) {
            addCriterion("member_address not between", value1, value2, "memberAddress");
            return (Criteria) this;
        }

        public Criteria andMemberSexIsNull() {
            addCriterion("member_sex is null");
            return (Criteria) this;
        }

        public Criteria andMemberSexIsNotNull() {
            addCriterion("member_sex is not null");
            return (Criteria) this;
        }

        public Criteria andMemberSexEqualTo(Integer value) {
            addCriterion("member_sex =", value, "memberSex");
            return (Criteria) this;
        }

        public Criteria andMemberSexNotEqualTo(Integer value) {
            addCriterion("member_sex <>", value, "memberSex");
            return (Criteria) this;
        }

        public Criteria andMemberSexGreaterThan(Integer value) {
            addCriterion("member_sex >", value, "memberSex");
            return (Criteria) this;
        }

        public Criteria andMemberSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("member_sex >=", value, "memberSex");
            return (Criteria) this;
        }

        public Criteria andMemberSexLessThan(Integer value) {
            addCriterion("member_sex <", value, "memberSex");
            return (Criteria) this;
        }

        public Criteria andMemberSexLessThanOrEqualTo(Integer value) {
            addCriterion("member_sex <=", value, "memberSex");
            return (Criteria) this;
        }

        public Criteria andMemberSexIn(List<Integer> values) {
            addCriterion("member_sex in", values, "memberSex");
            return (Criteria) this;
        }

        public Criteria andMemberSexNotIn(List<Integer> values) {
            addCriterion("member_sex not in", values, "memberSex");
            return (Criteria) this;
        }

        public Criteria andMemberSexBetween(Integer value1, Integer value2) {
            addCriterion("member_sex between", value1, value2, "memberSex");
            return (Criteria) this;
        }

        public Criteria andMemberSexNotBetween(Integer value1, Integer value2) {
            addCriterion("member_sex not between", value1, value2, "memberSex");
            return (Criteria) this;
        }

        public Criteria andMemberSignatureIsNull() {
            addCriterion("member_signature is null");
            return (Criteria) this;
        }

        public Criteria andMemberSignatureIsNotNull() {
            addCriterion("member_signature is not null");
            return (Criteria) this;
        }

        public Criteria andMemberSignatureEqualTo(String value) {
            addCriterion("member_signature =", value, "memberSignature");
            return (Criteria) this;
        }

        public Criteria andMemberSignatureNotEqualTo(String value) {
            addCriterion("member_signature <>", value, "memberSignature");
            return (Criteria) this;
        }

        public Criteria andMemberSignatureGreaterThan(String value) {
            addCriterion("member_signature >", value, "memberSignature");
            return (Criteria) this;
        }

        public Criteria andMemberSignatureGreaterThanOrEqualTo(String value) {
            addCriterion("member_signature >=", value, "memberSignature");
            return (Criteria) this;
        }

        public Criteria andMemberSignatureLessThan(String value) {
            addCriterion("member_signature <", value, "memberSignature");
            return (Criteria) this;
        }

        public Criteria andMemberSignatureLessThanOrEqualTo(String value) {
            addCriterion("member_signature <=", value, "memberSignature");
            return (Criteria) this;
        }

        public Criteria andMemberSignatureLike(String value) {
            addCriterion("member_signature like", value, "memberSignature");
            return (Criteria) this;
        }

        public Criteria andMemberSignatureNotLike(String value) {
            addCriterion("member_signature not like", value, "memberSignature");
            return (Criteria) this;
        }

        public Criteria andMemberSignatureIn(List<String> values) {
            addCriterion("member_signature in", values, "memberSignature");
            return (Criteria) this;
        }

        public Criteria andMemberSignatureNotIn(List<String> values) {
            addCriterion("member_signature not in", values, "memberSignature");
            return (Criteria) this;
        }

        public Criteria andMemberSignatureBetween(String value1, String value2) {
            addCriterion("member_signature between", value1, value2, "memberSignature");
            return (Criteria) this;
        }

        public Criteria andMemberSignatureNotBetween(String value1, String value2) {
            addCriterion("member_signature not between", value1, value2, "memberSignature");
            return (Criteria) this;
        }

        public Criteria andMemberPortraitIsNull() {
            addCriterion("member_portrait is null");
            return (Criteria) this;
        }

        public Criteria andMemberPortraitIsNotNull() {
            addCriterion("member_portrait is not null");
            return (Criteria) this;
        }

        public Criteria andMemberPortraitEqualTo(String value) {
            addCriterion("member_portrait =", value, "memberPortrait");
            return (Criteria) this;
        }

        public Criteria andMemberPortraitNotEqualTo(String value) {
            addCriterion("member_portrait <>", value, "memberPortrait");
            return (Criteria) this;
        }

        public Criteria andMemberPortraitGreaterThan(String value) {
            addCriterion("member_portrait >", value, "memberPortrait");
            return (Criteria) this;
        }

        public Criteria andMemberPortraitGreaterThanOrEqualTo(String value) {
            addCriterion("member_portrait >=", value, "memberPortrait");
            return (Criteria) this;
        }

        public Criteria andMemberPortraitLessThan(String value) {
            addCriterion("member_portrait <", value, "memberPortrait");
            return (Criteria) this;
        }

        public Criteria andMemberPortraitLessThanOrEqualTo(String value) {
            addCriterion("member_portrait <=", value, "memberPortrait");
            return (Criteria) this;
        }

        public Criteria andMemberPortraitLike(String value) {
            addCriterion("member_portrait like", value, "memberPortrait");
            return (Criteria) this;
        }

        public Criteria andMemberPortraitNotLike(String value) {
            addCriterion("member_portrait not like", value, "memberPortrait");
            return (Criteria) this;
        }

        public Criteria andMemberPortraitIn(List<String> values) {
            addCriterion("member_portrait in", values, "memberPortrait");
            return (Criteria) this;
        }

        public Criteria andMemberPortraitNotIn(List<String> values) {
            addCriterion("member_portrait not in", values, "memberPortrait");
            return (Criteria) this;
        }

        public Criteria andMemberPortraitBetween(String value1, String value2) {
            addCriterion("member_portrait between", value1, value2, "memberPortrait");
            return (Criteria) this;
        }

        public Criteria andMemberPortraitNotBetween(String value1, String value2) {
            addCriterion("member_portrait not between", value1, value2, "memberPortrait");
            return (Criteria) this;
        }

        public Criteria andMemberEmailIsNull() {
            addCriterion("member_email is null");
            return (Criteria) this;
        }

        public Criteria andMemberEmailIsNotNull() {
            addCriterion("member_email is not null");
            return (Criteria) this;
        }

        public Criteria andMemberEmailEqualTo(String value) {
            addCriterion("member_email =", value, "memberEmail");
            return (Criteria) this;
        }

        public Criteria andMemberEmailNotEqualTo(String value) {
            addCriterion("member_email <>", value, "memberEmail");
            return (Criteria) this;
        }

        public Criteria andMemberEmailGreaterThan(String value) {
            addCriterion("member_email >", value, "memberEmail");
            return (Criteria) this;
        }

        public Criteria andMemberEmailGreaterThanOrEqualTo(String value) {
            addCriterion("member_email >=", value, "memberEmail");
            return (Criteria) this;
        }

        public Criteria andMemberEmailLessThan(String value) {
            addCriterion("member_email <", value, "memberEmail");
            return (Criteria) this;
        }

        public Criteria andMemberEmailLessThanOrEqualTo(String value) {
            addCriterion("member_email <=", value, "memberEmail");
            return (Criteria) this;
        }

        public Criteria andMemberEmailLike(String value) {
            addCriterion("member_email like", value, "memberEmail");
            return (Criteria) this;
        }

        public Criteria andMemberEmailNotLike(String value) {
            addCriterion("member_email not like", value, "memberEmail");
            return (Criteria) this;
        }

        public Criteria andMemberEmailIn(List<String> values) {
            addCriterion("member_email in", values, "memberEmail");
            return (Criteria) this;
        }

        public Criteria andMemberEmailNotIn(List<String> values) {
            addCriterion("member_email not in", values, "memberEmail");
            return (Criteria) this;
        }

        public Criteria andMemberEmailBetween(String value1, String value2) {
            addCriterion("member_email between", value1, value2, "memberEmail");
            return (Criteria) this;
        }

        public Criteria andMemberEmailNotBetween(String value1, String value2) {
            addCriterion("member_email not between", value1, value2, "memberEmail");
            return (Criteria) this;
        }

        public Criteria andMemberCreateTimeIsNull() {
            addCriterion("member_create_time is null");
            return (Criteria) this;
        }

        public Criteria andMemberCreateTimeIsNotNull() {
            addCriterion("member_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andMemberCreateTimeEqualTo(Date value) {
            addCriterion("member_create_time =", value, "memberCreateTime");
            return (Criteria) this;
        }

        public Criteria andMemberCreateTimeNotEqualTo(Date value) {
            addCriterion("member_create_time <>", value, "memberCreateTime");
            return (Criteria) this;
        }

        public Criteria andMemberCreateTimeGreaterThan(Date value) {
            addCriterion("member_create_time >", value, "memberCreateTime");
            return (Criteria) this;
        }

        public Criteria andMemberCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("member_create_time >=", value, "memberCreateTime");
            return (Criteria) this;
        }

        public Criteria andMemberCreateTimeLessThan(Date value) {
            addCriterion("member_create_time <", value, "memberCreateTime");
            return (Criteria) this;
        }

        public Criteria andMemberCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("member_create_time <=", value, "memberCreateTime");
            return (Criteria) this;
        }

        public Criteria andMemberCreateTimeIn(List<Date> values) {
            addCriterion("member_create_time in", values, "memberCreateTime");
            return (Criteria) this;
        }

        public Criteria andMemberCreateTimeNotIn(List<Date> values) {
            addCriterion("member_create_time not in", values, "memberCreateTime");
            return (Criteria) this;
        }

        public Criteria andMemberCreateTimeBetween(Date value1, Date value2) {
            addCriterion("member_create_time between", value1, value2, "memberCreateTime");
            return (Criteria) this;
        }

        public Criteria andMemberCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("member_create_time not between", value1, value2, "memberCreateTime");
            return (Criteria) this;
        }

        public Criteria andMemberStateIsNull() {
            addCriterion("member_state is null");
            return (Criteria) this;
        }

        public Criteria andMemberStateIsNotNull() {
            addCriterion("member_state is not null");
            return (Criteria) this;
        }

        public Criteria andMemberStateEqualTo(Integer value) {
            addCriterion("member_state =", value, "memberState");
            return (Criteria) this;
        }

        public Criteria andMemberStateNotEqualTo(Integer value) {
            addCriterion("member_state <>", value, "memberState");
            return (Criteria) this;
        }

        public Criteria andMemberStateGreaterThan(Integer value) {
            addCriterion("member_state >", value, "memberState");
            return (Criteria) this;
        }

        public Criteria andMemberStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("member_state >=", value, "memberState");
            return (Criteria) this;
        }

        public Criteria andMemberStateLessThan(Integer value) {
            addCriterion("member_state <", value, "memberState");
            return (Criteria) this;
        }

        public Criteria andMemberStateLessThanOrEqualTo(Integer value) {
            addCriterion("member_state <=", value, "memberState");
            return (Criteria) this;
        }

        public Criteria andMemberStateIn(List<Integer> values) {
            addCriterion("member_state in", values, "memberState");
            return (Criteria) this;
        }

        public Criteria andMemberStateNotIn(List<Integer> values) {
            addCriterion("member_state not in", values, "memberState");
            return (Criteria) this;
        }

        public Criteria andMemberStateBetween(Integer value1, Integer value2) {
            addCriterion("member_state between", value1, value2, "memberState");
            return (Criteria) this;
        }

        public Criteria andMemberStateNotBetween(Integer value1, Integer value2) {
            addCriterion("member_state not between", value1, value2, "memberState");
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

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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
