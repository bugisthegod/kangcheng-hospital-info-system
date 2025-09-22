package com.woniu.outlet.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DrugSendItemPoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DrugSendItemPoExample() {
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

        public Criteria andDdDrugidIsNull() {
            addCriterion("dd_drugid is null");
            return (Criteria) this;
        }

        public Criteria andDdDrugidIsNotNull() {
            addCriterion("dd_drugid is not null");
            return (Criteria) this;
        }

        public Criteria andDdDrugidEqualTo(Integer value) {
            addCriterion("dd_drugid =", value, "ddDrugid");
            return (Criteria) this;
        }

        public Criteria andDdDrugidNotEqualTo(Integer value) {
            addCriterion("dd_drugid <>", value, "ddDrugid");
            return (Criteria) this;
        }

        public Criteria andDdDrugidGreaterThan(Integer value) {
            addCriterion("dd_drugid >", value, "ddDrugid");
            return (Criteria) this;
        }

        public Criteria andDdDrugidGreaterThanOrEqualTo(Integer value) {
            addCriterion("dd_drugid >=", value, "ddDrugid");
            return (Criteria) this;
        }

        public Criteria andDdDrugidLessThan(Integer value) {
            addCriterion("dd_drugid <", value, "ddDrugid");
            return (Criteria) this;
        }

        public Criteria andDdDrugidLessThanOrEqualTo(Integer value) {
            addCriterion("dd_drugid <=", value, "ddDrugid");
            return (Criteria) this;
        }

        public Criteria andDdDrugidIn(List<Integer> values) {
            addCriterion("dd_drugid in", values, "ddDrugid");
            return (Criteria) this;
        }

        public Criteria andDdDrugidNotIn(List<Integer> values) {
            addCriterion("dd_drugid not in", values, "ddDrugid");
            return (Criteria) this;
        }

        public Criteria andDdDrugidBetween(Integer value1, Integer value2) {
            addCriterion("dd_drugid between", value1, value2, "ddDrugid");
            return (Criteria) this;
        }

        public Criteria andDdDrugidNotBetween(Integer value1, Integer value2) {
            addCriterion("dd_drugid not between", value1, value2, "ddDrugid");
            return (Criteria) this;
        }

        public Criteria andDdDrugnameIsNull() {
            addCriterion("dd_drugname is null");
            return (Criteria) this;
        }

        public Criteria andDdDrugnameIsNotNull() {
            addCriterion("dd_drugname is not null");
            return (Criteria) this;
        }

        public Criteria andDdDrugnameEqualTo(String value) {
            addCriterion("dd_drugname =", value, "ddDrugname");
            return (Criteria) this;
        }

        public Criteria andDdDrugnameNotEqualTo(String value) {
            addCriterion("dd_drugname <>", value, "ddDrugname");
            return (Criteria) this;
        }

        public Criteria andDdDrugnameGreaterThan(String value) {
            addCriterion("dd_drugname >", value, "ddDrugname");
            return (Criteria) this;
        }

        public Criteria andDdDrugnameGreaterThanOrEqualTo(String value) {
            addCriterion("dd_drugname >=", value, "ddDrugname");
            return (Criteria) this;
        }

        public Criteria andDdDrugnameLessThan(String value) {
            addCriterion("dd_drugname <", value, "ddDrugname");
            return (Criteria) this;
        }

        public Criteria andDdDrugnameLessThanOrEqualTo(String value) {
            addCriterion("dd_drugname <=", value, "ddDrugname");
            return (Criteria) this;
        }

        public Criteria andDdDrugnameLike(String value) {
            addCriterion("dd_drugname like", value, "ddDrugname");
            return (Criteria) this;
        }

        public Criteria andDdDrugnameNotLike(String value) {
            addCriterion("dd_drugname not like", value, "ddDrugname");
            return (Criteria) this;
        }

        public Criteria andDdDrugnameIn(List<String> values) {
            addCriterion("dd_drugname in", values, "ddDrugname");
            return (Criteria) this;
        }

        public Criteria andDdDrugnameNotIn(List<String> values) {
            addCriterion("dd_drugname not in", values, "ddDrugname");
            return (Criteria) this;
        }

        public Criteria andDdDrugnameBetween(String value1, String value2) {
            addCriterion("dd_drugname between", value1, value2, "ddDrugname");
            return (Criteria) this;
        }

        public Criteria andDdDrugnameNotBetween(String value1, String value2) {
            addCriterion("dd_drugname not between", value1, value2, "ddDrugname");
            return (Criteria) this;
        }

        public Criteria andDdDrugnumIsNull() {
            addCriterion("dd_drugnum is null");
            return (Criteria) this;
        }

        public Criteria andDdDrugnumIsNotNull() {
            addCriterion("dd_drugnum is not null");
            return (Criteria) this;
        }

        public Criteria andDdDrugnumEqualTo(Integer value) {
            addCriterion("dd_drugnum =", value, "ddDrugnum");
            return (Criteria) this;
        }

        public Criteria andDdDrugnumNotEqualTo(Integer value) {
            addCriterion("dd_drugnum <>", value, "ddDrugnum");
            return (Criteria) this;
        }

        public Criteria andDdDrugnumGreaterThan(Integer value) {
            addCriterion("dd_drugnum >", value, "ddDrugnum");
            return (Criteria) this;
        }

        public Criteria andDdDrugnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("dd_drugnum >=", value, "ddDrugnum");
            return (Criteria) this;
        }

        public Criteria andDdDrugnumLessThan(Integer value) {
            addCriterion("dd_drugnum <", value, "ddDrugnum");
            return (Criteria) this;
        }

        public Criteria andDdDrugnumLessThanOrEqualTo(Integer value) {
            addCriterion("dd_drugnum <=", value, "ddDrugnum");
            return (Criteria) this;
        }

        public Criteria andDdDrugnumIn(List<Integer> values) {
            addCriterion("dd_drugnum in", values, "ddDrugnum");
            return (Criteria) this;
        }

        public Criteria andDdDrugnumNotIn(List<Integer> values) {
            addCriterion("dd_drugnum not in", values, "ddDrugnum");
            return (Criteria) this;
        }

        public Criteria andDdDrugnumBetween(Integer value1, Integer value2) {
            addCriterion("dd_drugnum between", value1, value2, "ddDrugnum");
            return (Criteria) this;
        }

        public Criteria andDdDrugnumNotBetween(Integer value1, Integer value2) {
            addCriterion("dd_drugnum not between", value1, value2, "ddDrugnum");
            return (Criteria) this;
        }

        public Criteria andDdPriceIsNull() {
            addCriterion("dd_price is null");
            return (Criteria) this;
        }

        public Criteria andDdPriceIsNotNull() {
            addCriterion("dd_price is not null");
            return (Criteria) this;
        }

        public Criteria andDdPriceEqualTo(BigDecimal value) {
            addCriterion("dd_price =", value, "ddPrice");
            return (Criteria) this;
        }

        public Criteria andDdPriceNotEqualTo(BigDecimal value) {
            addCriterion("dd_price <>", value, "ddPrice");
            return (Criteria) this;
        }

        public Criteria andDdPriceGreaterThan(BigDecimal value) {
            addCriterion("dd_price >", value, "ddPrice");
            return (Criteria) this;
        }

        public Criteria andDdPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("dd_price >=", value, "ddPrice");
            return (Criteria) this;
        }

        public Criteria andDdPriceLessThan(BigDecimal value) {
            addCriterion("dd_price <", value, "ddPrice");
            return (Criteria) this;
        }

        public Criteria andDdPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("dd_price <=", value, "ddPrice");
            return (Criteria) this;
        }

        public Criteria andDdPriceIn(List<BigDecimal> values) {
            addCriterion("dd_price in", values, "ddPrice");
            return (Criteria) this;
        }

        public Criteria andDdPriceNotIn(List<BigDecimal> values) {
            addCriterion("dd_price not in", values, "ddPrice");
            return (Criteria) this;
        }

        public Criteria andDdPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dd_price between", value1, value2, "ddPrice");
            return (Criteria) this;
        }

        public Criteria andDdPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dd_price not between", value1, value2, "ddPrice");
            return (Criteria) this;
        }

        public Criteria andDdDrugsendidIsNull() {
            addCriterion("dd_drugsendid is null");
            return (Criteria) this;
        }

        public Criteria andDdDrugsendidIsNotNull() {
            addCriterion("dd_drugsendid is not null");
            return (Criteria) this;
        }

        public Criteria andDdDrugsendidEqualTo(Integer value) {
            addCriterion("dd_drugsendid =", value, "ddDrugsendid");
            return (Criteria) this;
        }

        public Criteria andDdDrugsendidNotEqualTo(Integer value) {
            addCriterion("dd_drugsendid <>", value, "ddDrugsendid");
            return (Criteria) this;
        }

        public Criteria andDdDrugsendidGreaterThan(Integer value) {
            addCriterion("dd_drugsendid >", value, "ddDrugsendid");
            return (Criteria) this;
        }

        public Criteria andDdDrugsendidGreaterThanOrEqualTo(Integer value) {
            addCriterion("dd_drugsendid >=", value, "ddDrugsendid");
            return (Criteria) this;
        }

        public Criteria andDdDrugsendidLessThan(Integer value) {
            addCriterion("dd_drugsendid <", value, "ddDrugsendid");
            return (Criteria) this;
        }

        public Criteria andDdDrugsendidLessThanOrEqualTo(Integer value) {
            addCriterion("dd_drugsendid <=", value, "ddDrugsendid");
            return (Criteria) this;
        }

        public Criteria andDdDrugsendidIn(List<Integer> values) {
            addCriterion("dd_drugsendid in", values, "ddDrugsendid");
            return (Criteria) this;
        }

        public Criteria andDdDrugsendidNotIn(List<Integer> values) {
            addCriterion("dd_drugsendid not in", values, "ddDrugsendid");
            return (Criteria) this;
        }

        public Criteria andDdDrugsendidBetween(Integer value1, Integer value2) {
            addCriterion("dd_drugsendid between", value1, value2, "ddDrugsendid");
            return (Criteria) this;
        }

        public Criteria andDdDrugsendidNotBetween(Integer value1, Integer value2) {
            addCriterion("dd_drugsendid not between", value1, value2, "ddDrugsendid");
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