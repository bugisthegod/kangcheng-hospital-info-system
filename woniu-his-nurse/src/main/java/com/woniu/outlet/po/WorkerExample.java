package com.woniu.outlet.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class WorkerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WorkerExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andWAccountIsNull() {
            addCriterion("w_account is null");
            return (Criteria) this;
        }

        public Criteria andWAccountIsNotNull() {
            addCriterion("w_account is not null");
            return (Criteria) this;
        }

        public Criteria andWAccountEqualTo(String value) {
            addCriterion("w_account =", value, "wAccount");
            return (Criteria) this;
        }

        public Criteria andWAccountNotEqualTo(String value) {
            addCriterion("w_account <>", value, "wAccount");
            return (Criteria) this;
        }

        public Criteria andWAccountGreaterThan(String value) {
            addCriterion("w_account >", value, "wAccount");
            return (Criteria) this;
        }

        public Criteria andWAccountGreaterThanOrEqualTo(String value) {
            addCriterion("w_account >=", value, "wAccount");
            return (Criteria) this;
        }

        public Criteria andWAccountLessThan(String value) {
            addCriterion("w_account <", value, "wAccount");
            return (Criteria) this;
        }

        public Criteria andWAccountLessThanOrEqualTo(String value) {
            addCriterion("w_account <=", value, "wAccount");
            return (Criteria) this;
        }

        public Criteria andWAccountLike(String value) {
            addCriterion("w_account like", value, "wAccount");
            return (Criteria) this;
        }

        public Criteria andWAccountNotLike(String value) {
            addCriterion("w_account not like", value, "wAccount");
            return (Criteria) this;
        }

        public Criteria andWAccountIn(List<String> values) {
            addCriterion("w_account in", values, "wAccount");
            return (Criteria) this;
        }

        public Criteria andWAccountNotIn(List<String> values) {
            addCriterion("w_account not in", values, "wAccount");
            return (Criteria) this;
        }

        public Criteria andWAccountBetween(String value1, String value2) {
            addCriterion("w_account between", value1, value2, "wAccount");
            return (Criteria) this;
        }

        public Criteria andWAccountNotBetween(String value1, String value2) {
            addCriterion("w_account not between", value1, value2, "wAccount");
            return (Criteria) this;
        }

        public Criteria andWPasswordIsNull() {
            addCriterion("w_password is null");
            return (Criteria) this;
        }

        public Criteria andWPasswordIsNotNull() {
            addCriterion("w_password is not null");
            return (Criteria) this;
        }

        public Criteria andWPasswordEqualTo(String value) {
            addCriterion("w_password =", value, "wPassword");
            return (Criteria) this;
        }

        public Criteria andWPasswordNotEqualTo(String value) {
            addCriterion("w_password <>", value, "wPassword");
            return (Criteria) this;
        }

        public Criteria andWPasswordGreaterThan(String value) {
            addCriterion("w_password >", value, "wPassword");
            return (Criteria) this;
        }

        public Criteria andWPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("w_password >=", value, "wPassword");
            return (Criteria) this;
        }

        public Criteria andWPasswordLessThan(String value) {
            addCriterion("w_password <", value, "wPassword");
            return (Criteria) this;
        }

        public Criteria andWPasswordLessThanOrEqualTo(String value) {
            addCriterion("w_password <=", value, "wPassword");
            return (Criteria) this;
        }

        public Criteria andWPasswordLike(String value) {
            addCriterion("w_password like", value, "wPassword");
            return (Criteria) this;
        }

        public Criteria andWPasswordNotLike(String value) {
            addCriterion("w_password not like", value, "wPassword");
            return (Criteria) this;
        }

        public Criteria andWPasswordIn(List<String> values) {
            addCriterion("w_password in", values, "wPassword");
            return (Criteria) this;
        }

        public Criteria andWPasswordNotIn(List<String> values) {
            addCriterion("w_password not in", values, "wPassword");
            return (Criteria) this;
        }

        public Criteria andWPasswordBetween(String value1, String value2) {
            addCriterion("w_password between", value1, value2, "wPassword");
            return (Criteria) this;
        }

        public Criteria andWPasswordNotBetween(String value1, String value2) {
            addCriterion("w_password not between", value1, value2, "wPassword");
            return (Criteria) this;
        }

        public Criteria andWCardIsNull() {
            addCriterion("w_card is null");
            return (Criteria) this;
        }

        public Criteria andWCardIsNotNull() {
            addCriterion("w_card is not null");
            return (Criteria) this;
        }

        public Criteria andWCardEqualTo(String value) {
            addCriterion("w_card =", value, "wCard");
            return (Criteria) this;
        }

        public Criteria andWCardNotEqualTo(String value) {
            addCriterion("w_card <>", value, "wCard");
            return (Criteria) this;
        }

        public Criteria andWCardGreaterThan(String value) {
            addCriterion("w_card >", value, "wCard");
            return (Criteria) this;
        }

        public Criteria andWCardGreaterThanOrEqualTo(String value) {
            addCriterion("w_card >=", value, "wCard");
            return (Criteria) this;
        }

        public Criteria andWCardLessThan(String value) {
            addCriterion("w_card <", value, "wCard");
            return (Criteria) this;
        }

        public Criteria andWCardLessThanOrEqualTo(String value) {
            addCriterion("w_card <=", value, "wCard");
            return (Criteria) this;
        }

        public Criteria andWCardLike(String value) {
            addCriterion("w_card like", value, "wCard");
            return (Criteria) this;
        }

        public Criteria andWCardNotLike(String value) {
            addCriterion("w_card not like", value, "wCard");
            return (Criteria) this;
        }

        public Criteria andWCardIn(List<String> values) {
            addCriterion("w_card in", values, "wCard");
            return (Criteria) this;
        }

        public Criteria andWCardNotIn(List<String> values) {
            addCriterion("w_card not in", values, "wCard");
            return (Criteria) this;
        }

        public Criteria andWCardBetween(String value1, String value2) {
            addCriterion("w_card between", value1, value2, "wCard");
            return (Criteria) this;
        }

        public Criteria andWCardNotBetween(String value1, String value2) {
            addCriterion("w_card not between", value1, value2, "wCard");
            return (Criteria) this;
        }

        public Criteria andWDpidIsNull() {
            addCriterion("w_dpid is null");
            return (Criteria) this;
        }

        public Criteria andWDpidIsNotNull() {
            addCriterion("w_dpid is not null");
            return (Criteria) this;
        }

        public Criteria andWDpidEqualTo(Integer value) {
            addCriterion("w_dpid =", value, "wDpid");
            return (Criteria) this;
        }

        public Criteria andWDpidNotEqualTo(Integer value) {
            addCriterion("w_dpid <>", value, "wDpid");
            return (Criteria) this;
        }

        public Criteria andWDpidGreaterThan(Integer value) {
            addCriterion("w_dpid >", value, "wDpid");
            return (Criteria) this;
        }

        public Criteria andWDpidGreaterThanOrEqualTo(Integer value) {
            addCriterion("w_dpid >=", value, "wDpid");
            return (Criteria) this;
        }

        public Criteria andWDpidLessThan(Integer value) {
            addCriterion("w_dpid <", value, "wDpid");
            return (Criteria) this;
        }

        public Criteria andWDpidLessThanOrEqualTo(Integer value) {
            addCriterion("w_dpid <=", value, "wDpid");
            return (Criteria) this;
        }

        public Criteria andWDpidIn(List<Integer> values) {
            addCriterion("w_dpid in", values, "wDpid");
            return (Criteria) this;
        }

        public Criteria andWDpidNotIn(List<Integer> values) {
            addCriterion("w_dpid not in", values, "wDpid");
            return (Criteria) this;
        }

        public Criteria andWDpidBetween(Integer value1, Integer value2) {
            addCriterion("w_dpid between", value1, value2, "wDpid");
            return (Criteria) this;
        }

        public Criteria andWDpidNotBetween(Integer value1, Integer value2) {
            addCriterion("w_dpid not between", value1, value2, "wDpid");
            return (Criteria) this;
        }

        public Criteria andWSidIsNull() {
            addCriterion("w_sid is null");
            return (Criteria) this;
        }

        public Criteria andWSidIsNotNull() {
            addCriterion("w_sid is not null");
            return (Criteria) this;
        }

        public Criteria andWSidEqualTo(Integer value) {
            addCriterion("w_sid =", value, "wSid");
            return (Criteria) this;
        }

        public Criteria andWSidNotEqualTo(Integer value) {
            addCriterion("w_sid <>", value, "wSid");
            return (Criteria) this;
        }

        public Criteria andWSidGreaterThan(Integer value) {
            addCriterion("w_sid >", value, "wSid");
            return (Criteria) this;
        }

        public Criteria andWSidGreaterThanOrEqualTo(Integer value) {
            addCriterion("w_sid >=", value, "wSid");
            return (Criteria) this;
        }

        public Criteria andWSidLessThan(Integer value) {
            addCriterion("w_sid <", value, "wSid");
            return (Criteria) this;
        }

        public Criteria andWSidLessThanOrEqualTo(Integer value) {
            addCriterion("w_sid <=", value, "wSid");
            return (Criteria) this;
        }

        public Criteria andWSidIn(List<Integer> values) {
            addCriterion("w_sid in", values, "wSid");
            return (Criteria) this;
        }

        public Criteria andWSidNotIn(List<Integer> values) {
            addCriterion("w_sid not in", values, "wSid");
            return (Criteria) this;
        }

        public Criteria andWSidBetween(Integer value1, Integer value2) {
            addCriterion("w_sid between", value1, value2, "wSid");
            return (Criteria) this;
        }

        public Criteria andWSidNotBetween(Integer value1, Integer value2) {
            addCriterion("w_sid not between", value1, value2, "wSid");
            return (Criteria) this;
        }

        public Criteria andWAgeIsNull() {
            addCriterion("w_age is null");
            return (Criteria) this;
        }

        public Criteria andWAgeIsNotNull() {
            addCriterion("w_age is not null");
            return (Criteria) this;
        }

        public Criteria andWAgeEqualTo(Integer value) {
            addCriterion("w_age =", value, "wAge");
            return (Criteria) this;
        }

        public Criteria andWAgeNotEqualTo(Integer value) {
            addCriterion("w_age <>", value, "wAge");
            return (Criteria) this;
        }

        public Criteria andWAgeGreaterThan(Integer value) {
            addCriterion("w_age >", value, "wAge");
            return (Criteria) this;
        }

        public Criteria andWAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("w_age >=", value, "wAge");
            return (Criteria) this;
        }

        public Criteria andWAgeLessThan(Integer value) {
            addCriterion("w_age <", value, "wAge");
            return (Criteria) this;
        }

        public Criteria andWAgeLessThanOrEqualTo(Integer value) {
            addCriterion("w_age <=", value, "wAge");
            return (Criteria) this;
        }

        public Criteria andWAgeIn(List<Integer> values) {
            addCriterion("w_age in", values, "wAge");
            return (Criteria) this;
        }

        public Criteria andWAgeNotIn(List<Integer> values) {
            addCriterion("w_age not in", values, "wAge");
            return (Criteria) this;
        }

        public Criteria andWAgeBetween(Integer value1, Integer value2) {
            addCriterion("w_age between", value1, value2, "wAge");
            return (Criteria) this;
        }

        public Criteria andWAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("w_age not between", value1, value2, "wAge");
            return (Criteria) this;
        }

        public Criteria andWGenderIsNull() {
            addCriterion("w_gender is null");
            return (Criteria) this;
        }

        public Criteria andWGenderIsNotNull() {
            addCriterion("w_gender is not null");
            return (Criteria) this;
        }

        public Criteria andWGenderEqualTo(String value) {
            addCriterion("w_gender =", value, "wGender");
            return (Criteria) this;
        }

        public Criteria andWGenderNotEqualTo(String value) {
            addCriterion("w_gender <>", value, "wGender");
            return (Criteria) this;
        }

        public Criteria andWGenderGreaterThan(String value) {
            addCriterion("w_gender >", value, "wGender");
            return (Criteria) this;
        }

        public Criteria andWGenderGreaterThanOrEqualTo(String value) {
            addCriterion("w_gender >=", value, "wGender");
            return (Criteria) this;
        }

        public Criteria andWGenderLessThan(String value) {
            addCriterion("w_gender <", value, "wGender");
            return (Criteria) this;
        }

        public Criteria andWGenderLessThanOrEqualTo(String value) {
            addCriterion("w_gender <=", value, "wGender");
            return (Criteria) this;
        }

        public Criteria andWGenderLike(String value) {
            addCriterion("w_gender like", value, "wGender");
            return (Criteria) this;
        }

        public Criteria andWGenderNotLike(String value) {
            addCriterion("w_gender not like", value, "wGender");
            return (Criteria) this;
        }

        public Criteria andWGenderIn(List<String> values) {
            addCriterion("w_gender in", values, "wGender");
            return (Criteria) this;
        }

        public Criteria andWGenderNotIn(List<String> values) {
            addCriterion("w_gender not in", values, "wGender");
            return (Criteria) this;
        }

        public Criteria andWGenderBetween(String value1, String value2) {
            addCriterion("w_gender between", value1, value2, "wGender");
            return (Criteria) this;
        }

        public Criteria andWGenderNotBetween(String value1, String value2) {
            addCriterion("w_gender not between", value1, value2, "wGender");
            return (Criteria) this;
        }

        public Criteria andWNameIsNull() {
            addCriterion("w_name is null");
            return (Criteria) this;
        }

        public Criteria andWNameIsNotNull() {
            addCriterion("w_name is not null");
            return (Criteria) this;
        }

        public Criteria andWNameEqualTo(String value) {
            addCriterion("w_name =", value, "wName");
            return (Criteria) this;
        }

        public Criteria andWNameNotEqualTo(String value) {
            addCriterion("w_name <>", value, "wName");
            return (Criteria) this;
        }

        public Criteria andWNameGreaterThan(String value) {
            addCriterion("w_name >", value, "wName");
            return (Criteria) this;
        }

        public Criteria andWNameGreaterThanOrEqualTo(String value) {
            addCriterion("w_name >=", value, "wName");
            return (Criteria) this;
        }

        public Criteria andWNameLessThan(String value) {
            addCriterion("w_name <", value, "wName");
            return (Criteria) this;
        }

        public Criteria andWNameLessThanOrEqualTo(String value) {
            addCriterion("w_name <=", value, "wName");
            return (Criteria) this;
        }

        public Criteria andWNameLike(String value) {
            addCriterion("w_name like", value, "wName");
            return (Criteria) this;
        }

        public Criteria andWNameNotLike(String value) {
            addCriterion("w_name not like", value, "wName");
            return (Criteria) this;
        }

        public Criteria andWNameIn(List<String> values) {
            addCriterion("w_name in", values, "wName");
            return (Criteria) this;
        }

        public Criteria andWNameNotIn(List<String> values) {
            addCriterion("w_name not in", values, "wName");
            return (Criteria) this;
        }

        public Criteria andWNameBetween(String value1, String value2) {
            addCriterion("w_name between", value1, value2, "wName");
            return (Criteria) this;
        }

        public Criteria andWNameNotBetween(String value1, String value2) {
            addCriterion("w_name not between", value1, value2, "wName");
            return (Criteria) this;
        }

        public Criteria andWPhoneIsNull() {
            addCriterion("w_phone is null");
            return (Criteria) this;
        }

        public Criteria andWPhoneIsNotNull() {
            addCriterion("w_phone is not null");
            return (Criteria) this;
        }

        public Criteria andWPhoneEqualTo(String value) {
            addCriterion("w_phone =", value, "wPhone");
            return (Criteria) this;
        }

        public Criteria andWPhoneNotEqualTo(String value) {
            addCriterion("w_phone <>", value, "wPhone");
            return (Criteria) this;
        }

        public Criteria andWPhoneGreaterThan(String value) {
            addCriterion("w_phone >", value, "wPhone");
            return (Criteria) this;
        }

        public Criteria andWPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("w_phone >=", value, "wPhone");
            return (Criteria) this;
        }

        public Criteria andWPhoneLessThan(String value) {
            addCriterion("w_phone <", value, "wPhone");
            return (Criteria) this;
        }

        public Criteria andWPhoneLessThanOrEqualTo(String value) {
            addCriterion("w_phone <=", value, "wPhone");
            return (Criteria) this;
        }

        public Criteria andWPhoneLike(String value) {
            addCriterion("w_phone like", value, "wPhone");
            return (Criteria) this;
        }

        public Criteria andWPhoneNotLike(String value) {
            addCriterion("w_phone not like", value, "wPhone");
            return (Criteria) this;
        }

        public Criteria andWPhoneIn(List<String> values) {
            addCriterion("w_phone in", values, "wPhone");
            return (Criteria) this;
        }

        public Criteria andWPhoneNotIn(List<String> values) {
            addCriterion("w_phone not in", values, "wPhone");
            return (Criteria) this;
        }

        public Criteria andWPhoneBetween(String value1, String value2) {
            addCriterion("w_phone between", value1, value2, "wPhone");
            return (Criteria) this;
        }

        public Criteria andWPhoneNotBetween(String value1, String value2) {
            addCriterion("w_phone not between", value1, value2, "wPhone");
            return (Criteria) this;
        }

        public Criteria andWEmailIsNull() {
            addCriterion("w_email is null");
            return (Criteria) this;
        }

        public Criteria andWEmailIsNotNull() {
            addCriterion("w_email is not null");
            return (Criteria) this;
        }

        public Criteria andWEmailEqualTo(String value) {
            addCriterion("w_email =", value, "wEmail");
            return (Criteria) this;
        }

        public Criteria andWEmailNotEqualTo(String value) {
            addCriterion("w_email <>", value, "wEmail");
            return (Criteria) this;
        }

        public Criteria andWEmailGreaterThan(String value) {
            addCriterion("w_email >", value, "wEmail");
            return (Criteria) this;
        }

        public Criteria andWEmailGreaterThanOrEqualTo(String value) {
            addCriterion("w_email >=", value, "wEmail");
            return (Criteria) this;
        }

        public Criteria andWEmailLessThan(String value) {
            addCriterion("w_email <", value, "wEmail");
            return (Criteria) this;
        }

        public Criteria andWEmailLessThanOrEqualTo(String value) {
            addCriterion("w_email <=", value, "wEmail");
            return (Criteria) this;
        }

        public Criteria andWEmailLike(String value) {
            addCriterion("w_email like", value, "wEmail");
            return (Criteria) this;
        }

        public Criteria andWEmailNotLike(String value) {
            addCriterion("w_email not like", value, "wEmail");
            return (Criteria) this;
        }

        public Criteria andWEmailIn(List<String> values) {
            addCriterion("w_email in", values, "wEmail");
            return (Criteria) this;
        }

        public Criteria andWEmailNotIn(List<String> values) {
            addCriterion("w_email not in", values, "wEmail");
            return (Criteria) this;
        }

        public Criteria andWEmailBetween(String value1, String value2) {
            addCriterion("w_email between", value1, value2, "wEmail");
            return (Criteria) this;
        }

        public Criteria andWEmailNotBetween(String value1, String value2) {
            addCriterion("w_email not between", value1, value2, "wEmail");
            return (Criteria) this;
        }

        public Criteria andWSalaryIsNull() {
            addCriterion("w_salary is null");
            return (Criteria) this;
        }

        public Criteria andWSalaryIsNotNull() {
            addCriterion("w_salary is not null");
            return (Criteria) this;
        }

        public Criteria andWSalaryEqualTo(BigDecimal value) {
            addCriterion("w_salary =", value, "wSalary");
            return (Criteria) this;
        }

        public Criteria andWSalaryNotEqualTo(BigDecimal value) {
            addCriterion("w_salary <>", value, "wSalary");
            return (Criteria) this;
        }

        public Criteria andWSalaryGreaterThan(BigDecimal value) {
            addCriterion("w_salary >", value, "wSalary");
            return (Criteria) this;
        }

        public Criteria andWSalaryGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("w_salary >=", value, "wSalary");
            return (Criteria) this;
        }

        public Criteria andWSalaryLessThan(BigDecimal value) {
            addCriterion("w_salary <", value, "wSalary");
            return (Criteria) this;
        }

        public Criteria andWSalaryLessThanOrEqualTo(BigDecimal value) {
            addCriterion("w_salary <=", value, "wSalary");
            return (Criteria) this;
        }

        public Criteria andWSalaryIn(List<BigDecimal> values) {
            addCriterion("w_salary in", values, "wSalary");
            return (Criteria) this;
        }

        public Criteria andWSalaryNotIn(List<BigDecimal> values) {
            addCriterion("w_salary not in", values, "wSalary");
            return (Criteria) this;
        }

        public Criteria andWSalaryBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("w_salary between", value1, value2, "wSalary");
            return (Criteria) this;
        }

        public Criteria andWSalaryNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("w_salary not between", value1, value2, "wSalary");
            return (Criteria) this;
        }

        public Criteria andWSaltIsNull() {
            addCriterion("w_salt is null");
            return (Criteria) this;
        }

        public Criteria andWSaltIsNotNull() {
            addCriterion("w_salt is not null");
            return (Criteria) this;
        }

        public Criteria andWSaltEqualTo(String value) {
            addCriterion("w_salt =", value, "wSalt");
            return (Criteria) this;
        }

        public Criteria andWSaltNotEqualTo(String value) {
            addCriterion("w_salt <>", value, "wSalt");
            return (Criteria) this;
        }

        public Criteria andWSaltGreaterThan(String value) {
            addCriterion("w_salt >", value, "wSalt");
            return (Criteria) this;
        }

        public Criteria andWSaltGreaterThanOrEqualTo(String value) {
            addCriterion("w_salt >=", value, "wSalt");
            return (Criteria) this;
        }

        public Criteria andWSaltLessThan(String value) {
            addCriterion("w_salt <", value, "wSalt");
            return (Criteria) this;
        }

        public Criteria andWSaltLessThanOrEqualTo(String value) {
            addCriterion("w_salt <=", value, "wSalt");
            return (Criteria) this;
        }

        public Criteria andWSaltLike(String value) {
            addCriterion("w_salt like", value, "wSalt");
            return (Criteria) this;
        }

        public Criteria andWSaltNotLike(String value) {
            addCriterion("w_salt not like", value, "wSalt");
            return (Criteria) this;
        }

        public Criteria andWSaltIn(List<String> values) {
            addCriterion("w_salt in", values, "wSalt");
            return (Criteria) this;
        }

        public Criteria andWSaltNotIn(List<String> values) {
            addCriterion("w_salt not in", values, "wSalt");
            return (Criteria) this;
        }

        public Criteria andWSaltBetween(String value1, String value2) {
            addCriterion("w_salt between", value1, value2, "wSalt");
            return (Criteria) this;
        }

        public Criteria andWSaltNotBetween(String value1, String value2) {
            addCriterion("w_salt not between", value1, value2, "wSalt");
            return (Criteria) this;
        }

        public Criteria andWStatusIsNull() {
            addCriterion("w_status is null");
            return (Criteria) this;
        }

        public Criteria andWStatusIsNotNull() {
            addCriterion("w_status is not null");
            return (Criteria) this;
        }

        public Criteria andWStatusEqualTo(String value) {
            addCriterion("w_status =", value, "wStatus");
            return (Criteria) this;
        }

        public Criteria andWStatusNotEqualTo(String value) {
            addCriterion("w_status <>", value, "wStatus");
            return (Criteria) this;
        }

        public Criteria andWStatusGreaterThan(String value) {
            addCriterion("w_status >", value, "wStatus");
            return (Criteria) this;
        }

        public Criteria andWStatusGreaterThanOrEqualTo(String value) {
            addCriterion("w_status >=", value, "wStatus");
            return (Criteria) this;
        }

        public Criteria andWStatusLessThan(String value) {
            addCriterion("w_status <", value, "wStatus");
            return (Criteria) this;
        }

        public Criteria andWStatusLessThanOrEqualTo(String value) {
            addCriterion("w_status <=", value, "wStatus");
            return (Criteria) this;
        }

        public Criteria andWStatusLike(String value) {
            addCriterion("w_status like", value, "wStatus");
            return (Criteria) this;
        }

        public Criteria andWStatusNotLike(String value) {
            addCriterion("w_status not like", value, "wStatus");
            return (Criteria) this;
        }

        public Criteria andWStatusIn(List<String> values) {
            addCriterion("w_status in", values, "wStatus");
            return (Criteria) this;
        }

        public Criteria andWStatusNotIn(List<String> values) {
            addCriterion("w_status not in", values, "wStatus");
            return (Criteria) this;
        }

        public Criteria andWStatusBetween(String value1, String value2) {
            addCriterion("w_status between", value1, value2, "wStatus");
            return (Criteria) this;
        }

        public Criteria andWStatusNotBetween(String value1, String value2) {
            addCriterion("w_status not between", value1, value2, "wStatus");
            return (Criteria) this;
        }

        public Criteria andWRoleidIsNull() {
            addCriterion("w_roleid is null");
            return (Criteria) this;
        }

        public Criteria andWRoleidIsNotNull() {
            addCriterion("w_roleid is not null");
            return (Criteria) this;
        }

        public Criteria andWRoleidEqualTo(Integer value) {
            addCriterion("w_roleid =", value, "wRoleid");
            return (Criteria) this;
        }

        public Criteria andWRoleidNotEqualTo(Integer value) {
            addCriterion("w_roleid <>", value, "wRoleid");
            return (Criteria) this;
        }

        public Criteria andWRoleidGreaterThan(Integer value) {
            addCriterion("w_roleid >", value, "wRoleid");
            return (Criteria) this;
        }

        public Criteria andWRoleidGreaterThanOrEqualTo(Integer value) {
            addCriterion("w_roleid >=", value, "wRoleid");
            return (Criteria) this;
        }

        public Criteria andWRoleidLessThan(Integer value) {
            addCriterion("w_roleid <", value, "wRoleid");
            return (Criteria) this;
        }

        public Criteria andWRoleidLessThanOrEqualTo(Integer value) {
            addCriterion("w_roleid <=", value, "wRoleid");
            return (Criteria) this;
        }

        public Criteria andWRoleidIn(List<Integer> values) {
            addCriterion("w_roleid in", values, "wRoleid");
            return (Criteria) this;
        }

        public Criteria andWRoleidNotIn(List<Integer> values) {
            addCriterion("w_roleid not in", values, "wRoleid");
            return (Criteria) this;
        }

        public Criteria andWRoleidBetween(Integer value1, Integer value2) {
            addCriterion("w_roleid between", value1, value2, "wRoleid");
            return (Criteria) this;
        }

        public Criteria andWRoleidNotBetween(Integer value1, Integer value2) {
            addCriterion("w_roleid not between", value1, value2, "wRoleid");
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