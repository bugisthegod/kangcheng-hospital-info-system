package com.woniu.outlet.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class WardPoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WardPoExample() {
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

        public Criteria andWNoIsNull() {
            addCriterion("w_no is null");
            return (Criteria) this;
        }

        public Criteria andWNoIsNotNull() {
            addCriterion("w_no is not null");
            return (Criteria) this;
        }

        public Criteria andWNoEqualTo(String value) {
            addCriterion("w_no =", value, "wNo");
            return (Criteria) this;
        }

        public Criteria andWNoNotEqualTo(String value) {
            addCriterion("w_no <>", value, "wNo");
            return (Criteria) this;
        }

        public Criteria andWNoGreaterThan(String value) {
            addCriterion("w_no >", value, "wNo");
            return (Criteria) this;
        }

        public Criteria andWNoGreaterThanOrEqualTo(String value) {
            addCriterion("w_no >=", value, "wNo");
            return (Criteria) this;
        }

        public Criteria andWNoLessThan(String value) {
            addCriterion("w_no <", value, "wNo");
            return (Criteria) this;
        }

        public Criteria andWNoLessThanOrEqualTo(String value) {
            addCriterion("w_no <=", value, "wNo");
            return (Criteria) this;
        }

        public Criteria andWNoLike(String value) {
            addCriterion("w_no like", value, "wNo");
            return (Criteria) this;
        }

        public Criteria andWNoNotLike(String value) {
            addCriterion("w_no not like", value, "wNo");
            return (Criteria) this;
        }

        public Criteria andWNoIn(List<String> values) {
            addCriterion("w_no in", values, "wNo");
            return (Criteria) this;
        }

        public Criteria andWNoNotIn(List<String> values) {
            addCriterion("w_no not in", values, "wNo");
            return (Criteria) this;
        }

        public Criteria andWNoBetween(String value1, String value2) {
            addCriterion("w_no between", value1, value2, "wNo");
            return (Criteria) this;
        }

        public Criteria andWNoNotBetween(String value1, String value2) {
            addCriterion("w_no not between", value1, value2, "wNo");
            return (Criteria) this;
        }

        public Criteria andWLevelIsNull() {
            addCriterion("w_level is null");
            return (Criteria) this;
        }

        public Criteria andWLevelIsNotNull() {
            addCriterion("w_level is not null");
            return (Criteria) this;
        }

        public Criteria andWLevelEqualTo(String value) {
            addCriterion("w_level =", value, "wLevel");
            return (Criteria) this;
        }

        public Criteria andWLevelNotEqualTo(String value) {
            addCriterion("w_level <>", value, "wLevel");
            return (Criteria) this;
        }

        public Criteria andWLevelGreaterThan(String value) {
            addCriterion("w_level >", value, "wLevel");
            return (Criteria) this;
        }

        public Criteria andWLevelGreaterThanOrEqualTo(String value) {
            addCriterion("w_level >=", value, "wLevel");
            return (Criteria) this;
        }

        public Criteria andWLevelLessThan(String value) {
            addCriterion("w_level <", value, "wLevel");
            return (Criteria) this;
        }

        public Criteria andWLevelLessThanOrEqualTo(String value) {
            addCriterion("w_level <=", value, "wLevel");
            return (Criteria) this;
        }

        public Criteria andWLevelLike(String value) {
            addCriterion("w_level like", value, "wLevel");
            return (Criteria) this;
        }

        public Criteria andWLevelNotLike(String value) {
            addCriterion("w_level not like", value, "wLevel");
            return (Criteria) this;
        }

        public Criteria andWLevelIn(List<String> values) {
            addCriterion("w_level in", values, "wLevel");
            return (Criteria) this;
        }

        public Criteria andWLevelNotIn(List<String> values) {
            addCriterion("w_level not in", values, "wLevel");
            return (Criteria) this;
        }

        public Criteria andWLevelBetween(String value1, String value2) {
            addCriterion("w_level between", value1, value2, "wLevel");
            return (Criteria) this;
        }

        public Criteria andWLevelNotBetween(String value1, String value2) {
            addCriterion("w_level not between", value1, value2, "wLevel");
            return (Criteria) this;
        }

        public Criteria andWAreaIsNull() {
            addCriterion("w_area is null");
            return (Criteria) this;
        }

        public Criteria andWAreaIsNotNull() {
            addCriterion("w_area is not null");
            return (Criteria) this;
        }

        public Criteria andWAreaEqualTo(String value) {
            addCriterion("w_area =", value, "wArea");
            return (Criteria) this;
        }

        public Criteria andWAreaNotEqualTo(String value) {
            addCriterion("w_area <>", value, "wArea");
            return (Criteria) this;
        }

        public Criteria andWAreaGreaterThan(String value) {
            addCriterion("w_area >", value, "wArea");
            return (Criteria) this;
        }

        public Criteria andWAreaGreaterThanOrEqualTo(String value) {
            addCriterion("w_area >=", value, "wArea");
            return (Criteria) this;
        }

        public Criteria andWAreaLessThan(String value) {
            addCriterion("w_area <", value, "wArea");
            return (Criteria) this;
        }

        public Criteria andWAreaLessThanOrEqualTo(String value) {
            addCriterion("w_area <=", value, "wArea");
            return (Criteria) this;
        }

        public Criteria andWAreaLike(String value) {
            addCriterion("w_area like", value, "wArea");
            return (Criteria) this;
        }

        public Criteria andWAreaNotLike(String value) {
            addCriterion("w_area not like", value, "wArea");
            return (Criteria) this;
        }

        public Criteria andWAreaIn(List<String> values) {
            addCriterion("w_area in", values, "wArea");
            return (Criteria) this;
        }

        public Criteria andWAreaNotIn(List<String> values) {
            addCriterion("w_area not in", values, "wArea");
            return (Criteria) this;
        }

        public Criteria andWAreaBetween(String value1, String value2) {
            addCriterion("w_area between", value1, value2, "wArea");
            return (Criteria) this;
        }

        public Criteria andWAreaNotBetween(String value1, String value2) {
            addCriterion("w_area not between", value1, value2, "wArea");
            return (Criteria) this;
        }

        public Criteria andWPriceIsNull() {
            addCriterion("w_price is null");
            return (Criteria) this;
        }

        public Criteria andWPriceIsNotNull() {
            addCriterion("w_price is not null");
            return (Criteria) this;
        }

        public Criteria andWPriceEqualTo(BigDecimal value) {
            addCriterion("w_price =", value, "wPrice");
            return (Criteria) this;
        }

        public Criteria andWPriceNotEqualTo(BigDecimal value) {
            addCriterion("w_price <>", value, "wPrice");
            return (Criteria) this;
        }

        public Criteria andWPriceGreaterThan(BigDecimal value) {
            addCriterion("w_price >", value, "wPrice");
            return (Criteria) this;
        }

        public Criteria andWPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("w_price >=", value, "wPrice");
            return (Criteria) this;
        }

        public Criteria andWPriceLessThan(BigDecimal value) {
            addCriterion("w_price <", value, "wPrice");
            return (Criteria) this;
        }

        public Criteria andWPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("w_price <=", value, "wPrice");
            return (Criteria) this;
        }

        public Criteria andWPriceIn(List<BigDecimal> values) {
            addCriterion("w_price in", values, "wPrice");
            return (Criteria) this;
        }

        public Criteria andWPriceNotIn(List<BigDecimal> values) {
            addCriterion("w_price not in", values, "wPrice");
            return (Criteria) this;
        }

        public Criteria andWPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("w_price between", value1, value2, "wPrice");
            return (Criteria) this;
        }

        public Criteria andWPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("w_price not between", value1, value2, "wPrice");
            return (Criteria) this;
        }

        public Criteria andWNumIsNull() {
            addCriterion("w_num is null");
            return (Criteria) this;
        }

        public Criteria andWNumIsNotNull() {
            addCriterion("w_num is not null");
            return (Criteria) this;
        }

        public Criteria andWNumEqualTo(Integer value) {
            addCriterion("w_num =", value, "wNum");
            return (Criteria) this;
        }

        public Criteria andWNumNotEqualTo(Integer value) {
            addCriterion("w_num <>", value, "wNum");
            return (Criteria) this;
        }

        public Criteria andWNumGreaterThan(Integer value) {
            addCriterion("w_num >", value, "wNum");
            return (Criteria) this;
        }

        public Criteria andWNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("w_num >=", value, "wNum");
            return (Criteria) this;
        }

        public Criteria andWNumLessThan(Integer value) {
            addCriterion("w_num <", value, "wNum");
            return (Criteria) this;
        }

        public Criteria andWNumLessThanOrEqualTo(Integer value) {
            addCriterion("w_num <=", value, "wNum");
            return (Criteria) this;
        }

        public Criteria andWNumIn(List<Integer> values) {
            addCriterion("w_num in", values, "wNum");
            return (Criteria) this;
        }

        public Criteria andWNumNotIn(List<Integer> values) {
            addCriterion("w_num not in", values, "wNum");
            return (Criteria) this;
        }

        public Criteria andWNumBetween(Integer value1, Integer value2) {
            addCriterion("w_num between", value1, value2, "wNum");
            return (Criteria) this;
        }

        public Criteria andWNumNotBetween(Integer value1, Integer value2) {
            addCriterion("w_num not between", value1, value2, "wNum");
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

        public Criteria andWSnameIsNull() {
            addCriterion("w_sname is null");
            return (Criteria) this;
        }

        public Criteria andWSnameIsNotNull() {
            addCriterion("w_sname is not null");
            return (Criteria) this;
        }

        public Criteria andWSnameEqualTo(String value) {
            addCriterion("w_sname =", value, "wSname");
            return (Criteria) this;
        }

        public Criteria andWSnameNotEqualTo(String value) {
            addCriterion("w_sname <>", value, "wSname");
            return (Criteria) this;
        }

        public Criteria andWSnameGreaterThan(String value) {
            addCriterion("w_sname >", value, "wSname");
            return (Criteria) this;
        }

        public Criteria andWSnameGreaterThanOrEqualTo(String value) {
            addCriterion("w_sname >=", value, "wSname");
            return (Criteria) this;
        }

        public Criteria andWSnameLessThan(String value) {
            addCriterion("w_sname <", value, "wSname");
            return (Criteria) this;
        }

        public Criteria andWSnameLessThanOrEqualTo(String value) {
            addCriterion("w_sname <=", value, "wSname");
            return (Criteria) this;
        }

        public Criteria andWSnameLike(String value) {
            addCriterion("w_sname like", value, "wSname");
            return (Criteria) this;
        }

        public Criteria andWSnameNotLike(String value) {
            addCriterion("w_sname not like", value, "wSname");
            return (Criteria) this;
        }

        public Criteria andWSnameIn(List<String> values) {
            addCriterion("w_sname in", values, "wSname");
            return (Criteria) this;
        }

        public Criteria andWSnameNotIn(List<String> values) {
            addCriterion("w_sname not in", values, "wSname");
            return (Criteria) this;
        }

        public Criteria andWSnameBetween(String value1, String value2) {
            addCriterion("w_sname between", value1, value2, "wSname");
            return (Criteria) this;
        }

        public Criteria andWSnameNotBetween(String value1, String value2) {
            addCriterion("w_sname not between", value1, value2, "wSname");
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