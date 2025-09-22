package com.woniu.outlet.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PrescriptionItemPoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PrescriptionItemPoExample() {
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

        public Criteria andPsiDrugidIsNull() {
            addCriterion("psi_drugid is null");
            return (Criteria) this;
        }

        public Criteria andPsiDrugidIsNotNull() {
            addCriterion("psi_drugid is not null");
            return (Criteria) this;
        }

        public Criteria andPsiDrugidEqualTo(Integer value) {
            addCriterion("psi_drugid =", value, "psiDrugid");
            return (Criteria) this;
        }

        public Criteria andPsiDrugidNotEqualTo(Integer value) {
            addCriterion("psi_drugid <>", value, "psiDrugid");
            return (Criteria) this;
        }

        public Criteria andPsiDrugidGreaterThan(Integer value) {
            addCriterion("psi_drugid >", value, "psiDrugid");
            return (Criteria) this;
        }

        public Criteria andPsiDrugidGreaterThanOrEqualTo(Integer value) {
            addCriterion("psi_drugid >=", value, "psiDrugid");
            return (Criteria) this;
        }

        public Criteria andPsiDrugidLessThan(Integer value) {
            addCriterion("psi_drugid <", value, "psiDrugid");
            return (Criteria) this;
        }

        public Criteria andPsiDrugidLessThanOrEqualTo(Integer value) {
            addCriterion("psi_drugid <=", value, "psiDrugid");
            return (Criteria) this;
        }

        public Criteria andPsiDrugidIn(List<Integer> values) {
            addCriterion("psi_drugid in", values, "psiDrugid");
            return (Criteria) this;
        }

        public Criteria andPsiDrugidNotIn(List<Integer> values) {
            addCriterion("psi_drugid not in", values, "psiDrugid");
            return (Criteria) this;
        }

        public Criteria andPsiDrugidBetween(Integer value1, Integer value2) {
            addCriterion("psi_drugid between", value1, value2, "psiDrugid");
            return (Criteria) this;
        }

        public Criteria andPsiDrugidNotBetween(Integer value1, Integer value2) {
            addCriterion("psi_drugid not between", value1, value2, "psiDrugid");
            return (Criteria) this;
        }

        public Criteria andPsiDrugnameIsNull() {
            addCriterion("psi_drugname is null");
            return (Criteria) this;
        }

        public Criteria andPsiDrugnameIsNotNull() {
            addCriterion("psi_drugname is not null");
            return (Criteria) this;
        }

        public Criteria andPsiDrugnameEqualTo(String value) {
            addCriterion("psi_drugname =", value, "psiDrugname");
            return (Criteria) this;
        }

        public Criteria andPsiDrugnameNotEqualTo(String value) {
            addCriterion("psi_drugname <>", value, "psiDrugname");
            return (Criteria) this;
        }

        public Criteria andPsiDrugnameGreaterThan(String value) {
            addCriterion("psi_drugname >", value, "psiDrugname");
            return (Criteria) this;
        }

        public Criteria andPsiDrugnameGreaterThanOrEqualTo(String value) {
            addCriterion("psi_drugname >=", value, "psiDrugname");
            return (Criteria) this;
        }

        public Criteria andPsiDrugnameLessThan(String value) {
            addCriterion("psi_drugname <", value, "psiDrugname");
            return (Criteria) this;
        }

        public Criteria andPsiDrugnameLessThanOrEqualTo(String value) {
            addCriterion("psi_drugname <=", value, "psiDrugname");
            return (Criteria) this;
        }

        public Criteria andPsiDrugnameLike(String value) {
            addCriterion("psi_drugname like", value, "psiDrugname");
            return (Criteria) this;
        }

        public Criteria andPsiDrugnameNotLike(String value) {
            addCriterion("psi_drugname not like", value, "psiDrugname");
            return (Criteria) this;
        }

        public Criteria andPsiDrugnameIn(List<String> values) {
            addCriterion("psi_drugname in", values, "psiDrugname");
            return (Criteria) this;
        }

        public Criteria andPsiDrugnameNotIn(List<String> values) {
            addCriterion("psi_drugname not in", values, "psiDrugname");
            return (Criteria) this;
        }

        public Criteria andPsiDrugnameBetween(String value1, String value2) {
            addCriterion("psi_drugname between", value1, value2, "psiDrugname");
            return (Criteria) this;
        }

        public Criteria andPsiDrugnameNotBetween(String value1, String value2) {
            addCriterion("psi_drugname not between", value1, value2, "psiDrugname");
            return (Criteria) this;
        }

        public Criteria andPsiNumIsNull() {
            addCriterion("psi_num is null");
            return (Criteria) this;
        }

        public Criteria andPsiNumIsNotNull() {
            addCriterion("psi_num is not null");
            return (Criteria) this;
        }

        public Criteria andPsiNumEqualTo(Integer value) {
            addCriterion("psi_num =", value, "psiNum");
            return (Criteria) this;
        }

        public Criteria andPsiNumNotEqualTo(Integer value) {
            addCriterion("psi_num <>", value, "psiNum");
            return (Criteria) this;
        }

        public Criteria andPsiNumGreaterThan(Integer value) {
            addCriterion("psi_num >", value, "psiNum");
            return (Criteria) this;
        }

        public Criteria andPsiNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("psi_num >=", value, "psiNum");
            return (Criteria) this;
        }

        public Criteria andPsiNumLessThan(Integer value) {
            addCriterion("psi_num <", value, "psiNum");
            return (Criteria) this;
        }

        public Criteria andPsiNumLessThanOrEqualTo(Integer value) {
            addCriterion("psi_num <=", value, "psiNum");
            return (Criteria) this;
        }

        public Criteria andPsiNumIn(List<Integer> values) {
            addCriterion("psi_num in", values, "psiNum");
            return (Criteria) this;
        }

        public Criteria andPsiNumNotIn(List<Integer> values) {
            addCriterion("psi_num not in", values, "psiNum");
            return (Criteria) this;
        }

        public Criteria andPsiNumBetween(Integer value1, Integer value2) {
            addCriterion("psi_num between", value1, value2, "psiNum");
            return (Criteria) this;
        }

        public Criteria andPsiNumNotBetween(Integer value1, Integer value2) {
            addCriterion("psi_num not between", value1, value2, "psiNum");
            return (Criteria) this;
        }

        public Criteria andPsiPriceIsNull() {
            addCriterion("psi_price is null");
            return (Criteria) this;
        }

        public Criteria andPsiPriceIsNotNull() {
            addCriterion("psi_price is not null");
            return (Criteria) this;
        }

        public Criteria andPsiPriceEqualTo(BigDecimal value) {
            addCriterion("psi_price =", value, "psiPrice");
            return (Criteria) this;
        }

        public Criteria andPsiPriceNotEqualTo(BigDecimal value) {
            addCriterion("psi_price <>", value, "psiPrice");
            return (Criteria) this;
        }

        public Criteria andPsiPriceGreaterThan(BigDecimal value) {
            addCriterion("psi_price >", value, "psiPrice");
            return (Criteria) this;
        }

        public Criteria andPsiPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("psi_price >=", value, "psiPrice");
            return (Criteria) this;
        }

        public Criteria andPsiPriceLessThan(BigDecimal value) {
            addCriterion("psi_price <", value, "psiPrice");
            return (Criteria) this;
        }

        public Criteria andPsiPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("psi_price <=", value, "psiPrice");
            return (Criteria) this;
        }

        public Criteria andPsiPriceIn(List<BigDecimal> values) {
            addCriterion("psi_price in", values, "psiPrice");
            return (Criteria) this;
        }

        public Criteria andPsiPriceNotIn(List<BigDecimal> values) {
            addCriterion("psi_price not in", values, "psiPrice");
            return (Criteria) this;
        }

        public Criteria andPsiPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("psi_price between", value1, value2, "psiPrice");
            return (Criteria) this;
        }

        public Criteria andPsiPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("psi_price not between", value1, value2, "psiPrice");
            return (Criteria) this;
        }

        public Criteria andPsiPsidIsNull() {
            addCriterion("psi_psid is null");
            return (Criteria) this;
        }

        public Criteria andPsiPsidIsNotNull() {
            addCriterion("psi_psid is not null");
            return (Criteria) this;
        }

        public Criteria andPsiPsidEqualTo(Integer value) {
            addCriterion("psi_psid =", value, "psiPsid");
            return (Criteria) this;
        }

        public Criteria andPsiPsidNotEqualTo(Integer value) {
            addCriterion("psi_psid <>", value, "psiPsid");
            return (Criteria) this;
        }

        public Criteria andPsiPsidGreaterThan(Integer value) {
            addCriterion("psi_psid >", value, "psiPsid");
            return (Criteria) this;
        }

        public Criteria andPsiPsidGreaterThanOrEqualTo(Integer value) {
            addCriterion("psi_psid >=", value, "psiPsid");
            return (Criteria) this;
        }

        public Criteria andPsiPsidLessThan(Integer value) {
            addCriterion("psi_psid <", value, "psiPsid");
            return (Criteria) this;
        }

        public Criteria andPsiPsidLessThanOrEqualTo(Integer value) {
            addCriterion("psi_psid <=", value, "psiPsid");
            return (Criteria) this;
        }

        public Criteria andPsiPsidIn(List<Integer> values) {
            addCriterion("psi_psid in", values, "psiPsid");
            return (Criteria) this;
        }

        public Criteria andPsiPsidNotIn(List<Integer> values) {
            addCriterion("psi_psid not in", values, "psiPsid");
            return (Criteria) this;
        }

        public Criteria andPsiPsidBetween(Integer value1, Integer value2) {
            addCriterion("psi_psid between", value1, value2, "psiPsid");
            return (Criteria) this;
        }

        public Criteria andPsiPsidNotBetween(Integer value1, Integer value2) {
            addCriterion("psi_psid not between", value1, value2, "psiPsid");
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