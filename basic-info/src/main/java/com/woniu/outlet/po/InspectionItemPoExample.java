package com.woniu.outlet.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class InspectionItemPoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InspectionItemPoExample() {
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

        public Criteria andIiNoIsNull() {
            addCriterion("ii_no is null");
            return (Criteria) this;
        }

        public Criteria andIiNoIsNotNull() {
            addCriterion("ii_no is not null");
            return (Criteria) this;
        }

        public Criteria andIiNoEqualTo(String value) {
            addCriterion("ii_no =", value, "iiNo");
            return (Criteria) this;
        }

        public Criteria andIiNoNotEqualTo(String value) {
            addCriterion("ii_no <>", value, "iiNo");
            return (Criteria) this;
        }

        public Criteria andIiNoGreaterThan(String value) {
            addCriterion("ii_no >", value, "iiNo");
            return (Criteria) this;
        }

        public Criteria andIiNoGreaterThanOrEqualTo(String value) {
            addCriterion("ii_no >=", value, "iiNo");
            return (Criteria) this;
        }

        public Criteria andIiNoLessThan(String value) {
            addCriterion("ii_no <", value, "iiNo");
            return (Criteria) this;
        }

        public Criteria andIiNoLessThanOrEqualTo(String value) {
            addCriterion("ii_no <=", value, "iiNo");
            return (Criteria) this;
        }

        public Criteria andIiNoLike(String value) {
            addCriterion("ii_no like", value, "iiNo");
            return (Criteria) this;
        }

        public Criteria andIiNoNotLike(String value) {
            addCriterion("ii_no not like", value, "iiNo");
            return (Criteria) this;
        }

        public Criteria andIiNoIn(List<String> values) {
            addCriterion("ii_no in", values, "iiNo");
            return (Criteria) this;
        }

        public Criteria andIiNoNotIn(List<String> values) {
            addCriterion("ii_no not in", values, "iiNo");
            return (Criteria) this;
        }

        public Criteria andIiNoBetween(String value1, String value2) {
            addCriterion("ii_no between", value1, value2, "iiNo");
            return (Criteria) this;
        }

        public Criteria andIiNoNotBetween(String value1, String value2) {
            addCriterion("ii_no not between", value1, value2, "iiNo");
            return (Criteria) this;
        }

        public Criteria andIiNameIsNull() {
            addCriterion("ii_name is null");
            return (Criteria) this;
        }

        public Criteria andIiNameIsNotNull() {
            addCriterion("ii_name is not null");
            return (Criteria) this;
        }

        public Criteria andIiNameEqualTo(String value) {
            addCriterion("ii_name =", value, "iiName");
            return (Criteria) this;
        }

        public Criteria andIiNameNotEqualTo(String value) {
            addCriterion("ii_name <>", value, "iiName");
            return (Criteria) this;
        }

        public Criteria andIiNameGreaterThan(String value) {
            addCriterion("ii_name >", value, "iiName");
            return (Criteria) this;
        }

        public Criteria andIiNameGreaterThanOrEqualTo(String value) {
            addCriterion("ii_name >=", value, "iiName");
            return (Criteria) this;
        }

        public Criteria andIiNameLessThan(String value) {
            addCriterion("ii_name <", value, "iiName");
            return (Criteria) this;
        }

        public Criteria andIiNameLessThanOrEqualTo(String value) {
            addCriterion("ii_name <=", value, "iiName");
            return (Criteria) this;
        }

        public Criteria andIiNameLike(String value) {
            addCriterion("ii_name like", value, "iiName");
            return (Criteria) this;
        }

        public Criteria andIiNameNotLike(String value) {
            addCriterion("ii_name not like", value, "iiName");
            return (Criteria) this;
        }

        public Criteria andIiNameIn(List<String> values) {
            addCriterion("ii_name in", values, "iiName");
            return (Criteria) this;
        }

        public Criteria andIiNameNotIn(List<String> values) {
            addCriterion("ii_name not in", values, "iiName");
            return (Criteria) this;
        }

        public Criteria andIiNameBetween(String value1, String value2) {
            addCriterion("ii_name between", value1, value2, "iiName");
            return (Criteria) this;
        }

        public Criteria andIiNameNotBetween(String value1, String value2) {
            addCriterion("ii_name not between", value1, value2, "iiName");
            return (Criteria) this;
        }

        public Criteria andIiPriceIsNull() {
            addCriterion("ii_price is null");
            return (Criteria) this;
        }

        public Criteria andIiPriceIsNotNull() {
            addCriterion("ii_price is not null");
            return (Criteria) this;
        }

        public Criteria andIiPriceEqualTo(BigDecimal value) {
            addCriterion("ii_price =", value, "iiPrice");
            return (Criteria) this;
        }

        public Criteria andIiPriceNotEqualTo(BigDecimal value) {
            addCriterion("ii_price <>", value, "iiPrice");
            return (Criteria) this;
        }

        public Criteria andIiPriceGreaterThan(BigDecimal value) {
            addCriterion("ii_price >", value, "iiPrice");
            return (Criteria) this;
        }

        public Criteria andIiPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ii_price >=", value, "iiPrice");
            return (Criteria) this;
        }

        public Criteria andIiPriceLessThan(BigDecimal value) {
            addCriterion("ii_price <", value, "iiPrice");
            return (Criteria) this;
        }

        public Criteria andIiPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ii_price <=", value, "iiPrice");
            return (Criteria) this;
        }

        public Criteria andIiPriceIn(List<BigDecimal> values) {
            addCriterion("ii_price in", values, "iiPrice");
            return (Criteria) this;
        }

        public Criteria andIiPriceNotIn(List<BigDecimal> values) {
            addCriterion("ii_price not in", values, "iiPrice");
            return (Criteria) this;
        }

        public Criteria andIiPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ii_price between", value1, value2, "iiPrice");
            return (Criteria) this;
        }

        public Criteria andIiPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ii_price not between", value1, value2, "iiPrice");
            return (Criteria) this;
        }

        public Criteria andIiSidIsNull() {
            addCriterion("ii_sid is null");
            return (Criteria) this;
        }

        public Criteria andIiSidIsNotNull() {
            addCriterion("ii_sid is not null");
            return (Criteria) this;
        }

        public Criteria andIiSidEqualTo(Integer value) {
            addCriterion("ii_sid =", value, "iiSid");
            return (Criteria) this;
        }

        public Criteria andIiSidNotEqualTo(Integer value) {
            addCriterion("ii_sid <>", value, "iiSid");
            return (Criteria) this;
        }

        public Criteria andIiSidGreaterThan(Integer value) {
            addCriterion("ii_sid >", value, "iiSid");
            return (Criteria) this;
        }

        public Criteria andIiSidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ii_sid >=", value, "iiSid");
            return (Criteria) this;
        }

        public Criteria andIiSidLessThan(Integer value) {
            addCriterion("ii_sid <", value, "iiSid");
            return (Criteria) this;
        }

        public Criteria andIiSidLessThanOrEqualTo(Integer value) {
            addCriterion("ii_sid <=", value, "iiSid");
            return (Criteria) this;
        }

        public Criteria andIiSidIn(List<Integer> values) {
            addCriterion("ii_sid in", values, "iiSid");
            return (Criteria) this;
        }

        public Criteria andIiSidNotIn(List<Integer> values) {
            addCriterion("ii_sid not in", values, "iiSid");
            return (Criteria) this;
        }

        public Criteria andIiSidBetween(Integer value1, Integer value2) {
            addCriterion("ii_sid between", value1, value2, "iiSid");
            return (Criteria) this;
        }

        public Criteria andIiSidNotBetween(Integer value1, Integer value2) {
            addCriterion("ii_sid not between", value1, value2, "iiSid");
            return (Criteria) this;
        }

        public Criteria andIiSnameIsNull() {
            addCriterion("ii_sname is null");
            return (Criteria) this;
        }

        public Criteria andIiSnameIsNotNull() {
            addCriterion("ii_sname is not null");
            return (Criteria) this;
        }

        public Criteria andIiSnameEqualTo(String value) {
            addCriterion("ii_sname =", value, "iiSname");
            return (Criteria) this;
        }

        public Criteria andIiSnameNotEqualTo(String value) {
            addCriterion("ii_sname <>", value, "iiSname");
            return (Criteria) this;
        }

        public Criteria andIiSnameGreaterThan(String value) {
            addCriterion("ii_sname >", value, "iiSname");
            return (Criteria) this;
        }

        public Criteria andIiSnameGreaterThanOrEqualTo(String value) {
            addCriterion("ii_sname >=", value, "iiSname");
            return (Criteria) this;
        }

        public Criteria andIiSnameLessThan(String value) {
            addCriterion("ii_sname <", value, "iiSname");
            return (Criteria) this;
        }

        public Criteria andIiSnameLessThanOrEqualTo(String value) {
            addCriterion("ii_sname <=", value, "iiSname");
            return (Criteria) this;
        }

        public Criteria andIiSnameLike(String value) {
            addCriterion("ii_sname like", value, "iiSname");
            return (Criteria) this;
        }

        public Criteria andIiSnameNotLike(String value) {
            addCriterion("ii_sname not like", value, "iiSname");
            return (Criteria) this;
        }

        public Criteria andIiSnameIn(List<String> values) {
            addCriterion("ii_sname in", values, "iiSname");
            return (Criteria) this;
        }

        public Criteria andIiSnameNotIn(List<String> values) {
            addCriterion("ii_sname not in", values, "iiSname");
            return (Criteria) this;
        }

        public Criteria andIiSnameBetween(String value1, String value2) {
            addCriterion("ii_sname between", value1, value2, "iiSname");
            return (Criteria) this;
        }

        public Criteria andIiSnameNotBetween(String value1, String value2) {
            addCriterion("ii_sname not between", value1, value2, "iiSname");
            return (Criteria) this;
        }

        public Criteria andIiStatusIsNull() {
            addCriterion("ii_status is null");
            return (Criteria) this;
        }

        public Criteria andIiStatusIsNotNull() {
            addCriterion("ii_status is not null");
            return (Criteria) this;
        }

        public Criteria andIiStatusEqualTo(String value) {
            addCriterion("ii_status =", value, "iiStatus");
            return (Criteria) this;
        }

        public Criteria andIiStatusNotEqualTo(String value) {
            addCriterion("ii_status <>", value, "iiStatus");
            return (Criteria) this;
        }

        public Criteria andIiStatusGreaterThan(String value) {
            addCriterion("ii_status >", value, "iiStatus");
            return (Criteria) this;
        }

        public Criteria andIiStatusGreaterThanOrEqualTo(String value) {
            addCriterion("ii_status >=", value, "iiStatus");
            return (Criteria) this;
        }

        public Criteria andIiStatusLessThan(String value) {
            addCriterion("ii_status <", value, "iiStatus");
            return (Criteria) this;
        }

        public Criteria andIiStatusLessThanOrEqualTo(String value) {
            addCriterion("ii_status <=", value, "iiStatus");
            return (Criteria) this;
        }

        public Criteria andIiStatusLike(String value) {
            addCriterion("ii_status like", value, "iiStatus");
            return (Criteria) this;
        }

        public Criteria andIiStatusNotLike(String value) {
            addCriterion("ii_status not like", value, "iiStatus");
            return (Criteria) this;
        }

        public Criteria andIiStatusIn(List<String> values) {
            addCriterion("ii_status in", values, "iiStatus");
            return (Criteria) this;
        }

        public Criteria andIiStatusNotIn(List<String> values) {
            addCriterion("ii_status not in", values, "iiStatus");
            return (Criteria) this;
        }

        public Criteria andIiStatusBetween(String value1, String value2) {
            addCriterion("ii_status between", value1, value2, "iiStatus");
            return (Criteria) this;
        }

        public Criteria andIiStatusNotBetween(String value1, String value2) {
            addCriterion("ii_status not between", value1, value2, "iiStatus");
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