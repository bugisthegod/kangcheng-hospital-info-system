package com.woniu.outlet.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class EquipmentPoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EquipmentPoExample() {
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

        public Criteria andEqNoIsNull() {
            addCriterion("eq_no is null");
            return (Criteria) this;
        }

        public Criteria andEqNoIsNotNull() {
            addCriterion("eq_no is not null");
            return (Criteria) this;
        }

        public Criteria andEqNoEqualTo(String value) {
            addCriterion("eq_no =", value, "eqNo");
            return (Criteria) this;
        }

        public Criteria andEqNoNotEqualTo(String value) {
            addCriterion("eq_no <>", value, "eqNo");
            return (Criteria) this;
        }

        public Criteria andEqNoGreaterThan(String value) {
            addCriterion("eq_no >", value, "eqNo");
            return (Criteria) this;
        }

        public Criteria andEqNoGreaterThanOrEqualTo(String value) {
            addCriterion("eq_no >=", value, "eqNo");
            return (Criteria) this;
        }

        public Criteria andEqNoLessThan(String value) {
            addCriterion("eq_no <", value, "eqNo");
            return (Criteria) this;
        }

        public Criteria andEqNoLessThanOrEqualTo(String value) {
            addCriterion("eq_no <=", value, "eqNo");
            return (Criteria) this;
        }

        public Criteria andEqNoLike(String value) {
            addCriterion("eq_no like", value, "eqNo");
            return (Criteria) this;
        }

        public Criteria andEqNoNotLike(String value) {
            addCriterion("eq_no not like", value, "eqNo");
            return (Criteria) this;
        }

        public Criteria andEqNoIn(List<String> values) {
            addCriterion("eq_no in", values, "eqNo");
            return (Criteria) this;
        }

        public Criteria andEqNoNotIn(List<String> values) {
            addCriterion("eq_no not in", values, "eqNo");
            return (Criteria) this;
        }

        public Criteria andEqNoBetween(String value1, String value2) {
            addCriterion("eq_no between", value1, value2, "eqNo");
            return (Criteria) this;
        }

        public Criteria andEqNoNotBetween(String value1, String value2) {
            addCriterion("eq_no not between", value1, value2, "eqNo");
            return (Criteria) this;
        }

        public Criteria andEqNameIsNull() {
            addCriterion("eq_name is null");
            return (Criteria) this;
        }

        public Criteria andEqNameIsNotNull() {
            addCriterion("eq_name is not null");
            return (Criteria) this;
        }

        public Criteria andEqNameEqualTo(String value) {
            addCriterion("eq_name =", value, "eqName");
            return (Criteria) this;
        }

        public Criteria andEqNameNotEqualTo(String value) {
            addCriterion("eq_name <>", value, "eqName");
            return (Criteria) this;
        }

        public Criteria andEqNameGreaterThan(String value) {
            addCriterion("eq_name >", value, "eqName");
            return (Criteria) this;
        }

        public Criteria andEqNameGreaterThanOrEqualTo(String value) {
            addCriterion("eq_name >=", value, "eqName");
            return (Criteria) this;
        }

        public Criteria andEqNameLessThan(String value) {
            addCriterion("eq_name <", value, "eqName");
            return (Criteria) this;
        }

        public Criteria andEqNameLessThanOrEqualTo(String value) {
            addCriterion("eq_name <=", value, "eqName");
            return (Criteria) this;
        }

        public Criteria andEqNameLike(String value) {
            addCriterion("eq_name like", value, "eqName");
            return (Criteria) this;
        }

        public Criteria andEqNameNotLike(String value) {
            addCriterion("eq_name not like", value, "eqName");
            return (Criteria) this;
        }

        public Criteria andEqNameIn(List<String> values) {
            addCriterion("eq_name in", values, "eqName");
            return (Criteria) this;
        }

        public Criteria andEqNameNotIn(List<String> values) {
            addCriterion("eq_name not in", values, "eqName");
            return (Criteria) this;
        }

        public Criteria andEqNameBetween(String value1, String value2) {
            addCriterion("eq_name between", value1, value2, "eqName");
            return (Criteria) this;
        }

        public Criteria andEqNameNotBetween(String value1, String value2) {
            addCriterion("eq_name not between", value1, value2, "eqName");
            return (Criteria) this;
        }

        public Criteria andEqPriceIsNull() {
            addCriterion("eq_price is null");
            return (Criteria) this;
        }

        public Criteria andEqPriceIsNotNull() {
            addCriterion("eq_price is not null");
            return (Criteria) this;
        }

        public Criteria andEqPriceEqualTo(BigDecimal value) {
            addCriterion("eq_price =", value, "eqPrice");
            return (Criteria) this;
        }

        public Criteria andEqPriceNotEqualTo(BigDecimal value) {
            addCriterion("eq_price <>", value, "eqPrice");
            return (Criteria) this;
        }

        public Criteria andEqPriceGreaterThan(BigDecimal value) {
            addCriterion("eq_price >", value, "eqPrice");
            return (Criteria) this;
        }

        public Criteria andEqPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("eq_price >=", value, "eqPrice");
            return (Criteria) this;
        }

        public Criteria andEqPriceLessThan(BigDecimal value) {
            addCriterion("eq_price <", value, "eqPrice");
            return (Criteria) this;
        }

        public Criteria andEqPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("eq_price <=", value, "eqPrice");
            return (Criteria) this;
        }

        public Criteria andEqPriceIn(List<BigDecimal> values) {
            addCriterion("eq_price in", values, "eqPrice");
            return (Criteria) this;
        }

        public Criteria andEqPriceNotIn(List<BigDecimal> values) {
            addCriterion("eq_price not in", values, "eqPrice");
            return (Criteria) this;
        }

        public Criteria andEqPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("eq_price between", value1, value2, "eqPrice");
            return (Criteria) this;
        }

        public Criteria andEqPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("eq_price not between", value1, value2, "eqPrice");
            return (Criteria) this;
        }

        public Criteria andEqNumIsNull() {
            addCriterion("eq_num is null");
            return (Criteria) this;
        }

        public Criteria andEqNumIsNotNull() {
            addCriterion("eq_num is not null");
            return (Criteria) this;
        }

        public Criteria andEqNumEqualTo(Integer value) {
            addCriterion("eq_num =", value, "eqNum");
            return (Criteria) this;
        }

        public Criteria andEqNumNotEqualTo(Integer value) {
            addCriterion("eq_num <>", value, "eqNum");
            return (Criteria) this;
        }

        public Criteria andEqNumGreaterThan(Integer value) {
            addCriterion("eq_num >", value, "eqNum");
            return (Criteria) this;
        }

        public Criteria andEqNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("eq_num >=", value, "eqNum");
            return (Criteria) this;
        }

        public Criteria andEqNumLessThan(Integer value) {
            addCriterion("eq_num <", value, "eqNum");
            return (Criteria) this;
        }

        public Criteria andEqNumLessThanOrEqualTo(Integer value) {
            addCriterion("eq_num <=", value, "eqNum");
            return (Criteria) this;
        }

        public Criteria andEqNumIn(List<Integer> values) {
            addCriterion("eq_num in", values, "eqNum");
            return (Criteria) this;
        }

        public Criteria andEqNumNotIn(List<Integer> values) {
            addCriterion("eq_num not in", values, "eqNum");
            return (Criteria) this;
        }

        public Criteria andEqNumBetween(Integer value1, Integer value2) {
            addCriterion("eq_num between", value1, value2, "eqNum");
            return (Criteria) this;
        }

        public Criteria andEqNumNotBetween(Integer value1, Integer value2) {
            addCriterion("eq_num not between", value1, value2, "eqNum");
            return (Criteria) this;
        }

        public Criteria andEqSidIsNull() {
            addCriterion("eq_sid is null");
            return (Criteria) this;
        }

        public Criteria andEqSidIsNotNull() {
            addCriterion("eq_sid is not null");
            return (Criteria) this;
        }

        public Criteria andEqSidEqualTo(Integer value) {
            addCriterion("eq_sid =", value, "eqSid");
            return (Criteria) this;
        }

        public Criteria andEqSidNotEqualTo(Integer value) {
            addCriterion("eq_sid <>", value, "eqSid");
            return (Criteria) this;
        }

        public Criteria andEqSidGreaterThan(Integer value) {
            addCriterion("eq_sid >", value, "eqSid");
            return (Criteria) this;
        }

        public Criteria andEqSidGreaterThanOrEqualTo(Integer value) {
            addCriterion("eq_sid >=", value, "eqSid");
            return (Criteria) this;
        }

        public Criteria andEqSidLessThan(Integer value) {
            addCriterion("eq_sid <", value, "eqSid");
            return (Criteria) this;
        }

        public Criteria andEqSidLessThanOrEqualTo(Integer value) {
            addCriterion("eq_sid <=", value, "eqSid");
            return (Criteria) this;
        }

        public Criteria andEqSidIn(List<Integer> values) {
            addCriterion("eq_sid in", values, "eqSid");
            return (Criteria) this;
        }

        public Criteria andEqSidNotIn(List<Integer> values) {
            addCriterion("eq_sid not in", values, "eqSid");
            return (Criteria) this;
        }

        public Criteria andEqSidBetween(Integer value1, Integer value2) {
            addCriterion("eq_sid between", value1, value2, "eqSid");
            return (Criteria) this;
        }

        public Criteria andEqSidNotBetween(Integer value1, Integer value2) {
            addCriterion("eq_sid not between", value1, value2, "eqSid");
            return (Criteria) this;
        }

        public Criteria andEqSnameIsNull() {
            addCriterion("eq_sname is null");
            return (Criteria) this;
        }

        public Criteria andEqSnameIsNotNull() {
            addCriterion("eq_sname is not null");
            return (Criteria) this;
        }

        public Criteria andEqSnameEqualTo(String value) {
            addCriterion("eq_sname =", value, "eqSname");
            return (Criteria) this;
        }

        public Criteria andEqSnameNotEqualTo(String value) {
            addCriterion("eq_sname <>", value, "eqSname");
            return (Criteria) this;
        }

        public Criteria andEqSnameGreaterThan(String value) {
            addCriterion("eq_sname >", value, "eqSname");
            return (Criteria) this;
        }

        public Criteria andEqSnameGreaterThanOrEqualTo(String value) {
            addCriterion("eq_sname >=", value, "eqSname");
            return (Criteria) this;
        }

        public Criteria andEqSnameLessThan(String value) {
            addCriterion("eq_sname <", value, "eqSname");
            return (Criteria) this;
        }

        public Criteria andEqSnameLessThanOrEqualTo(String value) {
            addCriterion("eq_sname <=", value, "eqSname");
            return (Criteria) this;
        }

        public Criteria andEqSnameLike(String value) {
            addCriterion("eq_sname like", value, "eqSname");
            return (Criteria) this;
        }

        public Criteria andEqSnameNotLike(String value) {
            addCriterion("eq_sname not like", value, "eqSname");
            return (Criteria) this;
        }

        public Criteria andEqSnameIn(List<String> values) {
            addCriterion("eq_sname in", values, "eqSname");
            return (Criteria) this;
        }

        public Criteria andEqSnameNotIn(List<String> values) {
            addCriterion("eq_sname not in", values, "eqSname");
            return (Criteria) this;
        }

        public Criteria andEqSnameBetween(String value1, String value2) {
            addCriterion("eq_sname between", value1, value2, "eqSname");
            return (Criteria) this;
        }

        public Criteria andEqSnameNotBetween(String value1, String value2) {
            addCriterion("eq_sname not between", value1, value2, "eqSname");
            return (Criteria) this;
        }

        public Criteria andEqStatusIsNull() {
            addCriterion("eq_status is null");
            return (Criteria) this;
        }

        public Criteria andEqStatusIsNotNull() {
            addCriterion("eq_status is not null");
            return (Criteria) this;
        }

        public Criteria andEqStatusEqualTo(String value) {
            addCriterion("eq_status =", value, "eqStatus");
            return (Criteria) this;
        }

        public Criteria andEqStatusNotEqualTo(String value) {
            addCriterion("eq_status <>", value, "eqStatus");
            return (Criteria) this;
        }

        public Criteria andEqStatusGreaterThan(String value) {
            addCriterion("eq_status >", value, "eqStatus");
            return (Criteria) this;
        }

        public Criteria andEqStatusGreaterThanOrEqualTo(String value) {
            addCriterion("eq_status >=", value, "eqStatus");
            return (Criteria) this;
        }

        public Criteria andEqStatusLessThan(String value) {
            addCriterion("eq_status <", value, "eqStatus");
            return (Criteria) this;
        }

        public Criteria andEqStatusLessThanOrEqualTo(String value) {
            addCriterion("eq_status <=", value, "eqStatus");
            return (Criteria) this;
        }

        public Criteria andEqStatusLike(String value) {
            addCriterion("eq_status like", value, "eqStatus");
            return (Criteria) this;
        }

        public Criteria andEqStatusNotLike(String value) {
            addCriterion("eq_status not like", value, "eqStatus");
            return (Criteria) this;
        }

        public Criteria andEqStatusIn(List<String> values) {
            addCriterion("eq_status in", values, "eqStatus");
            return (Criteria) this;
        }

        public Criteria andEqStatusNotIn(List<String> values) {
            addCriterion("eq_status not in", values, "eqStatus");
            return (Criteria) this;
        }

        public Criteria andEqStatusBetween(String value1, String value2) {
            addCriterion("eq_status between", value1, value2, "eqStatus");
            return (Criteria) this;
        }

        public Criteria andEqStatusNotBetween(String value1, String value2) {
            addCriterion("eq_status not between", value1, value2, "eqStatus");
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