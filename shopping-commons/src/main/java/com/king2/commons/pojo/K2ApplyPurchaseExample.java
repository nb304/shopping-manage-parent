package com.king2.commons.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class K2ApplyPurchaseExample {
    /**
     * k2_apply_purchase
     */
    protected String orderByClause;

    /**
     * k2_apply_purchase
     */
    protected boolean distinct;

    /**
     * k2_apply_purchase
     */
    protected List<Criteria> oredCriteria;

    public K2ApplyPurchaseExample() {
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
     * k2_apply_purchase 2019-08-06
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

        public Criteria andApIdIsNull() {
            addCriterion("ap_id is null");
            return (Criteria) this;
        }

        public Criteria andApIdIsNotNull() {
            addCriterion("ap_id is not null");
            return (Criteria) this;
        }

        public Criteria andApIdEqualTo(Integer value) {
            addCriterion("ap_id =", value, "apId");
            return (Criteria) this;
        }

        public Criteria andApIdNotEqualTo(Integer value) {
            addCriterion("ap_id <>", value, "apId");
            return (Criteria) this;
        }

        public Criteria andApIdGreaterThan(Integer value) {
            addCriterion("ap_id >", value, "apId");
            return (Criteria) this;
        }

        public Criteria andApIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ap_id >=", value, "apId");
            return (Criteria) this;
        }

        public Criteria andApIdLessThan(Integer value) {
            addCriterion("ap_id <", value, "apId");
            return (Criteria) this;
        }

        public Criteria andApIdLessThanOrEqualTo(Integer value) {
            addCriterion("ap_id <=", value, "apId");
            return (Criteria) this;
        }

        public Criteria andApIdIn(List<Integer> values) {
            addCriterion("ap_id in", values, "apId");
            return (Criteria) this;
        }

        public Criteria andApIdNotIn(List<Integer> values) {
            addCriterion("ap_id not in", values, "apId");
            return (Criteria) this;
        }

        public Criteria andApIdBetween(Integer value1, Integer value2) {
            addCriterion("ap_id between", value1, value2, "apId");
            return (Criteria) this;
        }

        public Criteria andApIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ap_id not between", value1, value2, "apId");
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

        public Criteria andApplicantDescIsNull() {
            addCriterion("applicant_desc is null");
            return (Criteria) this;
        }

        public Criteria andApplicantDescIsNotNull() {
            addCriterion("applicant_desc is not null");
            return (Criteria) this;
        }

        public Criteria andApplicantDescEqualTo(String value) {
            addCriterion("applicant_desc =", value, "applicantDesc");
            return (Criteria) this;
        }

        public Criteria andApplicantDescNotEqualTo(String value) {
            addCriterion("applicant_desc <>", value, "applicantDesc");
            return (Criteria) this;
        }

        public Criteria andApplicantDescGreaterThan(String value) {
            addCriterion("applicant_desc >", value, "applicantDesc");
            return (Criteria) this;
        }

        public Criteria andApplicantDescGreaterThanOrEqualTo(String value) {
            addCriterion("applicant_desc >=", value, "applicantDesc");
            return (Criteria) this;
        }

        public Criteria andApplicantDescLessThan(String value) {
            addCriterion("applicant_desc <", value, "applicantDesc");
            return (Criteria) this;
        }

        public Criteria andApplicantDescLessThanOrEqualTo(String value) {
            addCriterion("applicant_desc <=", value, "applicantDesc");
            return (Criteria) this;
        }

        public Criteria andApplicantDescLike(String value) {
            addCriterion("applicant_desc like", value, "applicantDesc");
            return (Criteria) this;
        }

        public Criteria andApplicantDescNotLike(String value) {
            addCriterion("applicant_desc not like", value, "applicantDesc");
            return (Criteria) this;
        }

        public Criteria andApplicantDescIn(List<String> values) {
            addCriterion("applicant_desc in", values, "applicantDesc");
            return (Criteria) this;
        }

        public Criteria andApplicantDescNotIn(List<String> values) {
            addCriterion("applicant_desc not in", values, "applicantDesc");
            return (Criteria) this;
        }

        public Criteria andApplicantDescBetween(String value1, String value2) {
            addCriterion("applicant_desc between", value1, value2, "applicantDesc");
            return (Criteria) this;
        }

        public Criteria andApplicantDescNotBetween(String value1, String value2) {
            addCriterion("applicant_desc not between", value1, value2, "applicantDesc");
            return (Criteria) this;
        }

        public Criteria andApplicantMemberAccountIsNull() {
            addCriterion("applicant_member_account is null");
            return (Criteria) this;
        }

        public Criteria andApplicantMemberAccountIsNotNull() {
            addCriterion("applicant_member_account is not null");
            return (Criteria) this;
        }

        public Criteria andApplicantMemberAccountEqualTo(String value) {
            addCriterion("applicant_member_account =", value, "applicantMemberAccount");
            return (Criteria) this;
        }

        public Criteria andApplicantMemberAccountNotEqualTo(String value) {
            addCriterion("applicant_member_account <>", value, "applicantMemberAccount");
            return (Criteria) this;
        }

        public Criteria andApplicantMemberAccountGreaterThan(String value) {
            addCriterion("applicant_member_account >", value, "applicantMemberAccount");
            return (Criteria) this;
        }

        public Criteria andApplicantMemberAccountGreaterThanOrEqualTo(String value) {
            addCriterion("applicant_member_account >=", value, "applicantMemberAccount");
            return (Criteria) this;
        }

        public Criteria andApplicantMemberAccountLessThan(String value) {
            addCriterion("applicant_member_account <", value, "applicantMemberAccount");
            return (Criteria) this;
        }

        public Criteria andApplicantMemberAccountLessThanOrEqualTo(String value) {
            addCriterion("applicant_member_account <=", value, "applicantMemberAccount");
            return (Criteria) this;
        }

        public Criteria andApplicantMemberAccountLike(String value) {
            addCriterion("applicant_member_account like", value, "applicantMemberAccount");
            return (Criteria) this;
        }

        public Criteria andApplicantMemberAccountNotLike(String value) {
            addCriterion("applicant_member_account not like", value, "applicantMemberAccount");
            return (Criteria) this;
        }

        public Criteria andApplicantMemberAccountIn(List<String> values) {
            addCriterion("applicant_member_account in", values, "applicantMemberAccount");
            return (Criteria) this;
        }

        public Criteria andApplicantMemberAccountNotIn(List<String> values) {
            addCriterion("applicant_member_account not in", values, "applicantMemberAccount");
            return (Criteria) this;
        }

        public Criteria andApplicantMemberAccountBetween(String value1, String value2) {
            addCriterion("applicant_member_account between", value1, value2, "applicantMemberAccount");
            return (Criteria) this;
        }

        public Criteria andApplicantMemberAccountNotBetween(String value1, String value2) {
            addCriterion("applicant_member_account not between", value1, value2, "applicantMemberAccount");
            return (Criteria) this;
        }

        public Criteria andApplicantMemberNameIsNull() {
            addCriterion("applicant_member_name is null");
            return (Criteria) this;
        }

        public Criteria andApplicantMemberNameIsNotNull() {
            addCriterion("applicant_member_name is not null");
            return (Criteria) this;
        }

        public Criteria andApplicantMemberNameEqualTo(String value) {
            addCriterion("applicant_member_name =", value, "applicantMemberName");
            return (Criteria) this;
        }

        public Criteria andApplicantMemberNameNotEqualTo(String value) {
            addCriterion("applicant_member_name <>", value, "applicantMemberName");
            return (Criteria) this;
        }

        public Criteria andApplicantMemberNameGreaterThan(String value) {
            addCriterion("applicant_member_name >", value, "applicantMemberName");
            return (Criteria) this;
        }

        public Criteria andApplicantMemberNameGreaterThanOrEqualTo(String value) {
            addCriterion("applicant_member_name >=", value, "applicantMemberName");
            return (Criteria) this;
        }

        public Criteria andApplicantMemberNameLessThan(String value) {
            addCriterion("applicant_member_name <", value, "applicantMemberName");
            return (Criteria) this;
        }

        public Criteria andApplicantMemberNameLessThanOrEqualTo(String value) {
            addCriterion("applicant_member_name <=", value, "applicantMemberName");
            return (Criteria) this;
        }

        public Criteria andApplicantMemberNameLike(String value) {
            addCriterion("applicant_member_name like", value, "applicantMemberName");
            return (Criteria) this;
        }

        public Criteria andApplicantMemberNameNotLike(String value) {
            addCriterion("applicant_member_name not like", value, "applicantMemberName");
            return (Criteria) this;
        }

        public Criteria andApplicantMemberNameIn(List<String> values) {
            addCriterion("applicant_member_name in", values, "applicantMemberName");
            return (Criteria) this;
        }

        public Criteria andApplicantMemberNameNotIn(List<String> values) {
            addCriterion("applicant_member_name not in", values, "applicantMemberName");
            return (Criteria) this;
        }

        public Criteria andApplicantMemberNameBetween(String value1, String value2) {
            addCriterion("applicant_member_name between", value1, value2, "applicantMemberName");
            return (Criteria) this;
        }

        public Criteria andApplicantMemberNameNotBetween(String value1, String value2) {
            addCriterion("applicant_member_name not between", value1, value2, "applicantMemberName");
            return (Criteria) this;
        }

        public Criteria andApplicantMemberPhoneIsNull() {
            addCriterion("applicant_member_phone is null");
            return (Criteria) this;
        }

        public Criteria andApplicantMemberPhoneIsNotNull() {
            addCriterion("applicant_member_phone is not null");
            return (Criteria) this;
        }

        public Criteria andApplicantMemberPhoneEqualTo(String value) {
            addCriterion("applicant_member_phone =", value, "applicantMemberPhone");
            return (Criteria) this;
        }

        public Criteria andApplicantMemberPhoneNotEqualTo(String value) {
            addCriterion("applicant_member_phone <>", value, "applicantMemberPhone");
            return (Criteria) this;
        }

        public Criteria andApplicantMemberPhoneGreaterThan(String value) {
            addCriterion("applicant_member_phone >", value, "applicantMemberPhone");
            return (Criteria) this;
        }

        public Criteria andApplicantMemberPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("applicant_member_phone >=", value, "applicantMemberPhone");
            return (Criteria) this;
        }

        public Criteria andApplicantMemberPhoneLessThan(String value) {
            addCriterion("applicant_member_phone <", value, "applicantMemberPhone");
            return (Criteria) this;
        }

        public Criteria andApplicantMemberPhoneLessThanOrEqualTo(String value) {
            addCriterion("applicant_member_phone <=", value, "applicantMemberPhone");
            return (Criteria) this;
        }

        public Criteria andApplicantMemberPhoneLike(String value) {
            addCriterion("applicant_member_phone like", value, "applicantMemberPhone");
            return (Criteria) this;
        }

        public Criteria andApplicantMemberPhoneNotLike(String value) {
            addCriterion("applicant_member_phone not like", value, "applicantMemberPhone");
            return (Criteria) this;
        }

        public Criteria andApplicantMemberPhoneIn(List<String> values) {
            addCriterion("applicant_member_phone in", values, "applicantMemberPhone");
            return (Criteria) this;
        }

        public Criteria andApplicantMemberPhoneNotIn(List<String> values) {
            addCriterion("applicant_member_phone not in", values, "applicantMemberPhone");
            return (Criteria) this;
        }

        public Criteria andApplicantMemberPhoneBetween(String value1, String value2) {
            addCriterion("applicant_member_phone between", value1, value2, "applicantMemberPhone");
            return (Criteria) this;
        }

        public Criteria andApplicantMemberPhoneNotBetween(String value1, String value2) {
            addCriterion("applicant_member_phone not between", value1, value2, "applicantMemberPhone");
            return (Criteria) this;
        }

        public Criteria andApCreateTimeIsNull() {
            addCriterion("ap_create_time is null");
            return (Criteria) this;
        }

        public Criteria andApCreateTimeIsNotNull() {
            addCriterion("ap_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andApCreateTimeEqualTo(Date value) {
            addCriterion("ap_create_time =", value, "apCreateTime");
            return (Criteria) this;
        }

        public Criteria andApCreateTimeNotEqualTo(Date value) {
            addCriterion("ap_create_time <>", value, "apCreateTime");
            return (Criteria) this;
        }

        public Criteria andApCreateTimeGreaterThan(Date value) {
            addCriterion("ap_create_time >", value, "apCreateTime");
            return (Criteria) this;
        }

        public Criteria andApCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ap_create_time >=", value, "apCreateTime");
            return (Criteria) this;
        }

        public Criteria andApCreateTimeLessThan(Date value) {
            addCriterion("ap_create_time <", value, "apCreateTime");
            return (Criteria) this;
        }

        public Criteria andApCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("ap_create_time <=", value, "apCreateTime");
            return (Criteria) this;
        }

        public Criteria andApCreateTimeIn(List<Date> values) {
            addCriterion("ap_create_time in", values, "apCreateTime");
            return (Criteria) this;
        }

        public Criteria andApCreateTimeNotIn(List<Date> values) {
            addCriterion("ap_create_time not in", values, "apCreateTime");
            return (Criteria) this;
        }

        public Criteria andApCreateTimeBetween(Date value1, Date value2) {
            addCriterion("ap_create_time between", value1, value2, "apCreateTime");
            return (Criteria) this;
        }

        public Criteria andApCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("ap_create_time not between", value1, value2, "apCreateTime");
            return (Criteria) this;
        }

        public Criteria andApprovalStateIsNull() {
            addCriterion("approval_state is null");
            return (Criteria) this;
        }

        public Criteria andApprovalStateIsNotNull() {
            addCriterion("approval_state is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalStateEqualTo(Integer value) {
            addCriterion("approval_state =", value, "approvalState");
            return (Criteria) this;
        }

        public Criteria andApprovalStateNotEqualTo(Integer value) {
            addCriterion("approval_state <>", value, "approvalState");
            return (Criteria) this;
        }

        public Criteria andApprovalStateGreaterThan(Integer value) {
            addCriterion("approval_state >", value, "approvalState");
            return (Criteria) this;
        }

        public Criteria andApprovalStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("approval_state >=", value, "approvalState");
            return (Criteria) this;
        }

        public Criteria andApprovalStateLessThan(Integer value) {
            addCriterion("approval_state <", value, "approvalState");
            return (Criteria) this;
        }

        public Criteria andApprovalStateLessThanOrEqualTo(Integer value) {
            addCriterion("approval_state <=", value, "approvalState");
            return (Criteria) this;
        }

        public Criteria andApprovalStateIn(List<Integer> values) {
            addCriterion("approval_state in", values, "approvalState");
            return (Criteria) this;
        }

        public Criteria andApprovalStateNotIn(List<Integer> values) {
            addCriterion("approval_state not in", values, "approvalState");
            return (Criteria) this;
        }

        public Criteria andApprovalStateBetween(Integer value1, Integer value2) {
            addCriterion("approval_state between", value1, value2, "approvalState");
            return (Criteria) this;
        }

        public Criteria andApprovalStateNotBetween(Integer value1, Integer value2) {
            addCriterion("approval_state not between", value1, value2, "approvalState");
            return (Criteria) this;
        }

        public Criteria andApprovalAccountIsNull() {
            addCriterion("approval_account is null");
            return (Criteria) this;
        }

        public Criteria andApprovalAccountIsNotNull() {
            addCriterion("approval_account is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalAccountEqualTo(String value) {
            addCriterion("approval_account =", value, "approvalAccount");
            return (Criteria) this;
        }

        public Criteria andApprovalAccountNotEqualTo(String value) {
            addCriterion("approval_account <>", value, "approvalAccount");
            return (Criteria) this;
        }

        public Criteria andApprovalAccountGreaterThan(String value) {
            addCriterion("approval_account >", value, "approvalAccount");
            return (Criteria) this;
        }

        public Criteria andApprovalAccountGreaterThanOrEqualTo(String value) {
            addCriterion("approval_account >=", value, "approvalAccount");
            return (Criteria) this;
        }

        public Criteria andApprovalAccountLessThan(String value) {
            addCriterion("approval_account <", value, "approvalAccount");
            return (Criteria) this;
        }

        public Criteria andApprovalAccountLessThanOrEqualTo(String value) {
            addCriterion("approval_account <=", value, "approvalAccount");
            return (Criteria) this;
        }

        public Criteria andApprovalAccountLike(String value) {
            addCriterion("approval_account like", value, "approvalAccount");
            return (Criteria) this;
        }

        public Criteria andApprovalAccountNotLike(String value) {
            addCriterion("approval_account not like", value, "approvalAccount");
            return (Criteria) this;
        }

        public Criteria andApprovalAccountIn(List<String> values) {
            addCriterion("approval_account in", values, "approvalAccount");
            return (Criteria) this;
        }

        public Criteria andApprovalAccountNotIn(List<String> values) {
            addCriterion("approval_account not in", values, "approvalAccount");
            return (Criteria) this;
        }

        public Criteria andApprovalAccountBetween(String value1, String value2) {
            addCriterion("approval_account between", value1, value2, "approvalAccount");
            return (Criteria) this;
        }

        public Criteria andApprovalAccountNotBetween(String value1, String value2) {
            addCriterion("approval_account not between", value1, value2, "approvalAccount");
            return (Criteria) this;
        }

        public Criteria andApprovalNameIsNull() {
            addCriterion("approval_name is null");
            return (Criteria) this;
        }

        public Criteria andApprovalNameIsNotNull() {
            addCriterion("approval_name is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalNameEqualTo(String value) {
            addCriterion("approval_name =", value, "approvalName");
            return (Criteria) this;
        }

        public Criteria andApprovalNameNotEqualTo(String value) {
            addCriterion("approval_name <>", value, "approvalName");
            return (Criteria) this;
        }

        public Criteria andApprovalNameGreaterThan(String value) {
            addCriterion("approval_name >", value, "approvalName");
            return (Criteria) this;
        }

        public Criteria andApprovalNameGreaterThanOrEqualTo(String value) {
            addCriterion("approval_name >=", value, "approvalName");
            return (Criteria) this;
        }

        public Criteria andApprovalNameLessThan(String value) {
            addCriterion("approval_name <", value, "approvalName");
            return (Criteria) this;
        }

        public Criteria andApprovalNameLessThanOrEqualTo(String value) {
            addCriterion("approval_name <=", value, "approvalName");
            return (Criteria) this;
        }

        public Criteria andApprovalNameLike(String value) {
            addCriterion("approval_name like", value, "approvalName");
            return (Criteria) this;
        }

        public Criteria andApprovalNameNotLike(String value) {
            addCriterion("approval_name not like", value, "approvalName");
            return (Criteria) this;
        }

        public Criteria andApprovalNameIn(List<String> values) {
            addCriterion("approval_name in", values, "approvalName");
            return (Criteria) this;
        }

        public Criteria andApprovalNameNotIn(List<String> values) {
            addCriterion("approval_name not in", values, "approvalName");
            return (Criteria) this;
        }

        public Criteria andApprovalNameBetween(String value1, String value2) {
            addCriterion("approval_name between", value1, value2, "approvalName");
            return (Criteria) this;
        }

        public Criteria andApprovalNameNotBetween(String value1, String value2) {
            addCriterion("approval_name not between", value1, value2, "approvalName");
            return (Criteria) this;
        }

        public Criteria andApprovalDescIsNull() {
            addCriterion("approval_desc is null");
            return (Criteria) this;
        }

        public Criteria andApprovalDescIsNotNull() {
            addCriterion("approval_desc is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalDescEqualTo(String value) {
            addCriterion("approval_desc =", value, "approvalDesc");
            return (Criteria) this;
        }

        public Criteria andApprovalDescNotEqualTo(String value) {
            addCriterion("approval_desc <>", value, "approvalDesc");
            return (Criteria) this;
        }

        public Criteria andApprovalDescGreaterThan(String value) {
            addCriterion("approval_desc >", value, "approvalDesc");
            return (Criteria) this;
        }

        public Criteria andApprovalDescGreaterThanOrEqualTo(String value) {
            addCriterion("approval_desc >=", value, "approvalDesc");
            return (Criteria) this;
        }

        public Criteria andApprovalDescLessThan(String value) {
            addCriterion("approval_desc <", value, "approvalDesc");
            return (Criteria) this;
        }

        public Criteria andApprovalDescLessThanOrEqualTo(String value) {
            addCriterion("approval_desc <=", value, "approvalDesc");
            return (Criteria) this;
        }

        public Criteria andApprovalDescLike(String value) {
            addCriterion("approval_desc like", value, "approvalDesc");
            return (Criteria) this;
        }

        public Criteria andApprovalDescNotLike(String value) {
            addCriterion("approval_desc not like", value, "approvalDesc");
            return (Criteria) this;
        }

        public Criteria andApprovalDescIn(List<String> values) {
            addCriterion("approval_desc in", values, "approvalDesc");
            return (Criteria) this;
        }

        public Criteria andApprovalDescNotIn(List<String> values) {
            addCriterion("approval_desc not in", values, "approvalDesc");
            return (Criteria) this;
        }

        public Criteria andApprovalDescBetween(String value1, String value2) {
            addCriterion("approval_desc between", value1, value2, "approvalDesc");
            return (Criteria) this;
        }

        public Criteria andApprovalDescNotBetween(String value1, String value2) {
            addCriterion("approval_desc not between", value1, value2, "approvalDesc");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeIsNull() {
            addCriterion("approval_time is null");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeIsNotNull() {
            addCriterion("approval_time is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeEqualTo(Date value) {
            addCriterion("approval_time =", value, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeNotEqualTo(Date value) {
            addCriterion("approval_time <>", value, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeGreaterThan(Date value) {
            addCriterion("approval_time >", value, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("approval_time >=", value, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeLessThan(Date value) {
            addCriterion("approval_time <", value, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeLessThanOrEqualTo(Date value) {
            addCriterion("approval_time <=", value, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeIn(List<Date> values) {
            addCriterion("approval_time in", values, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeNotIn(List<Date> values) {
            addCriterion("approval_time not in", values, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeBetween(Date value1, Date value2) {
            addCriterion("approval_time between", value1, value2, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeNotBetween(Date value1, Date value2) {
            addCriterion("approval_time not between", value1, value2, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalResultIsNull() {
            addCriterion("approval_result is null");
            return (Criteria) this;
        }

        public Criteria andApprovalResultIsNotNull() {
            addCriterion("approval_result is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalResultEqualTo(Integer value) {
            addCriterion("approval_result =", value, "approvalResult");
            return (Criteria) this;
        }

        public Criteria andApprovalResultNotEqualTo(Integer value) {
            addCriterion("approval_result <>", value, "approvalResult");
            return (Criteria) this;
        }

        public Criteria andApprovalResultGreaterThan(Integer value) {
            addCriterion("approval_result >", value, "approvalResult");
            return (Criteria) this;
        }

        public Criteria andApprovalResultGreaterThanOrEqualTo(Integer value) {
            addCriterion("approval_result >=", value, "approvalResult");
            return (Criteria) this;
        }

        public Criteria andApprovalResultLessThan(Integer value) {
            addCriterion("approval_result <", value, "approvalResult");
            return (Criteria) this;
        }

        public Criteria andApprovalResultLessThanOrEqualTo(Integer value) {
            addCriterion("approval_result <=", value, "approvalResult");
            return (Criteria) this;
        }

        public Criteria andApprovalResultIn(List<Integer> values) {
            addCriterion("approval_result in", values, "approvalResult");
            return (Criteria) this;
        }

        public Criteria andApprovalResultNotIn(List<Integer> values) {
            addCriterion("approval_result not in", values, "approvalResult");
            return (Criteria) this;
        }

        public Criteria andApprovalResultBetween(Integer value1, Integer value2) {
            addCriterion("approval_result between", value1, value2, "approvalResult");
            return (Criteria) this;
        }

        public Criteria andApprovalResultNotBetween(Integer value1, Integer value2) {
            addCriterion("approval_result not between", value1, value2, "approvalResult");
            return (Criteria) this;
        }

        public Criteria andApDelFlagIsNull() {
            addCriterion("ap_del_flag is null");
            return (Criteria) this;
        }

        public Criteria andApDelFlagIsNotNull() {
            addCriterion("ap_del_flag is not null");
            return (Criteria) this;
        }

        public Criteria andApDelFlagEqualTo(Integer value) {
            addCriterion("ap_del_flag =", value, "apDelFlag");
            return (Criteria) this;
        }

        public Criteria andApDelFlagNotEqualTo(Integer value) {
            addCriterion("ap_del_flag <>", value, "apDelFlag");
            return (Criteria) this;
        }

        public Criteria andApDelFlagGreaterThan(Integer value) {
            addCriterion("ap_del_flag >", value, "apDelFlag");
            return (Criteria) this;
        }

        public Criteria andApDelFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("ap_del_flag >=", value, "apDelFlag");
            return (Criteria) this;
        }

        public Criteria andApDelFlagLessThan(Integer value) {
            addCriterion("ap_del_flag <", value, "apDelFlag");
            return (Criteria) this;
        }

        public Criteria andApDelFlagLessThanOrEqualTo(Integer value) {
            addCriterion("ap_del_flag <=", value, "apDelFlag");
            return (Criteria) this;
        }

        public Criteria andApDelFlagIn(List<Integer> values) {
            addCriterion("ap_del_flag in", values, "apDelFlag");
            return (Criteria) this;
        }

        public Criteria andApDelFlagNotIn(List<Integer> values) {
            addCriterion("ap_del_flag not in", values, "apDelFlag");
            return (Criteria) this;
        }

        public Criteria andApDelFlagBetween(Integer value1, Integer value2) {
            addCriterion("ap_del_flag between", value1, value2, "apDelFlag");
            return (Criteria) this;
        }

        public Criteria andApDelFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("ap_del_flag not between", value1, value2, "apDelFlag");
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
     * k2_apply_purchase
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * k2_apply_purchase 2019-08-06
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