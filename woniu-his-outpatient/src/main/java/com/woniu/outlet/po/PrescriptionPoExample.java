package com.woniu.outlet.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PrescriptionPoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PrescriptionPoExample() {
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

        public Criteria andPsNoIsNull() {
            addCriterion("ps_no is null");
            return (Criteria) this;
        }

        public Criteria andPsNoIsNotNull() {
            addCriterion("ps_no is not null");
            return (Criteria) this;
        }

        public Criteria andPsNoEqualTo(String value) {
            addCriterion("ps_no =", value, "psNo");
            return (Criteria) this;
        }

        public Criteria andPsNoNotEqualTo(String value) {
            addCriterion("ps_no <>", value, "psNo");
            return (Criteria) this;
        }

        public Criteria andPsNoGreaterThan(String value) {
            addCriterion("ps_no >", value, "psNo");
            return (Criteria) this;
        }

        public Criteria andPsNoGreaterThanOrEqualTo(String value) {
            addCriterion("ps_no >=", value, "psNo");
            return (Criteria) this;
        }

        public Criteria andPsNoLessThan(String value) {
            addCriterion("ps_no <", value, "psNo");
            return (Criteria) this;
        }

        public Criteria andPsNoLessThanOrEqualTo(String value) {
            addCriterion("ps_no <=", value, "psNo");
            return (Criteria) this;
        }

        public Criteria andPsNoLike(String value) {
            addCriterion("ps_no like", value, "psNo");
            return (Criteria) this;
        }

        public Criteria andPsNoNotLike(String value) {
            addCriterion("ps_no not like", value, "psNo");
            return (Criteria) this;
        }

        public Criteria andPsNoIn(List<String> values) {
            addCriterion("ps_no in", values, "psNo");
            return (Criteria) this;
        }

        public Criteria andPsNoNotIn(List<String> values) {
            addCriterion("ps_no not in", values, "psNo");
            return (Criteria) this;
        }

        public Criteria andPsNoBetween(String value1, String value2) {
            addCriterion("ps_no between", value1, value2, "psNo");
            return (Criteria) this;
        }

        public Criteria andPsNoNotBetween(String value1, String value2) {
            addCriterion("ps_no not between", value1, value2, "psNo");
            return (Criteria) this;
        }

        public Criteria andPsPatientidIsNull() {
            addCriterion("ps_patientid is null");
            return (Criteria) this;
        }

        public Criteria andPsPatientidIsNotNull() {
            addCriterion("ps_patientid is not null");
            return (Criteria) this;
        }

        public Criteria andPsPatientidEqualTo(Integer value) {
            addCriterion("ps_patientid =", value, "psPatientid");
            return (Criteria) this;
        }

        public Criteria andPsPatientidNotEqualTo(Integer value) {
            addCriterion("ps_patientid <>", value, "psPatientid");
            return (Criteria) this;
        }

        public Criteria andPsPatientidGreaterThan(Integer value) {
            addCriterion("ps_patientid >", value, "psPatientid");
            return (Criteria) this;
        }

        public Criteria andPsPatientidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ps_patientid >=", value, "psPatientid");
            return (Criteria) this;
        }

        public Criteria andPsPatientidLessThan(Integer value) {
            addCriterion("ps_patientid <", value, "psPatientid");
            return (Criteria) this;
        }

        public Criteria andPsPatientidLessThanOrEqualTo(Integer value) {
            addCriterion("ps_patientid <=", value, "psPatientid");
            return (Criteria) this;
        }

        public Criteria andPsPatientidIn(List<Integer> values) {
            addCriterion("ps_patientid in", values, "psPatientid");
            return (Criteria) this;
        }

        public Criteria andPsPatientidNotIn(List<Integer> values) {
            addCriterion("ps_patientid not in", values, "psPatientid");
            return (Criteria) this;
        }

        public Criteria andPsPatientidBetween(Integer value1, Integer value2) {
            addCriterion("ps_patientid between", value1, value2, "psPatientid");
            return (Criteria) this;
        }

        public Criteria andPsPatientidNotBetween(Integer value1, Integer value2) {
            addCriterion("ps_patientid not between", value1, value2, "psPatientid");
            return (Criteria) this;
        }

        public Criteria andPsDoctoridIsNull() {
            addCriterion("ps_doctorid is null");
            return (Criteria) this;
        }

        public Criteria andPsDoctoridIsNotNull() {
            addCriterion("ps_doctorid is not null");
            return (Criteria) this;
        }

        public Criteria andPsDoctoridEqualTo(Integer value) {
            addCriterion("ps_doctorid =", value, "psDoctorid");
            return (Criteria) this;
        }

        public Criteria andPsDoctoridNotEqualTo(Integer value) {
            addCriterion("ps_doctorid <>", value, "psDoctorid");
            return (Criteria) this;
        }

        public Criteria andPsDoctoridGreaterThan(Integer value) {
            addCriterion("ps_doctorid >", value, "psDoctorid");
            return (Criteria) this;
        }

        public Criteria andPsDoctoridGreaterThanOrEqualTo(Integer value) {
            addCriterion("ps_doctorid >=", value, "psDoctorid");
            return (Criteria) this;
        }

        public Criteria andPsDoctoridLessThan(Integer value) {
            addCriterion("ps_doctorid <", value, "psDoctorid");
            return (Criteria) this;
        }

        public Criteria andPsDoctoridLessThanOrEqualTo(Integer value) {
            addCriterion("ps_doctorid <=", value, "psDoctorid");
            return (Criteria) this;
        }

        public Criteria andPsDoctoridIn(List<Integer> values) {
            addCriterion("ps_doctorid in", values, "psDoctorid");
            return (Criteria) this;
        }

        public Criteria andPsDoctoridNotIn(List<Integer> values) {
            addCriterion("ps_doctorid not in", values, "psDoctorid");
            return (Criteria) this;
        }

        public Criteria andPsDoctoridBetween(Integer value1, Integer value2) {
            addCriterion("ps_doctorid between", value1, value2, "psDoctorid");
            return (Criteria) this;
        }

        public Criteria andPsDoctoridNotBetween(Integer value1, Integer value2) {
            addCriterion("ps_doctorid not between", value1, value2, "psDoctorid");
            return (Criteria) this;
        }

        public Criteria andPsTotalIsNull() {
            addCriterion("ps_total is null");
            return (Criteria) this;
        }

        public Criteria andPsTotalIsNotNull() {
            addCriterion("ps_total is not null");
            return (Criteria) this;
        }

        public Criteria andPsTotalEqualTo(BigDecimal value) {
            addCriterion("ps_total =", value, "psTotal");
            return (Criteria) this;
        }

        public Criteria andPsTotalNotEqualTo(BigDecimal value) {
            addCriterion("ps_total <>", value, "psTotal");
            return (Criteria) this;
        }

        public Criteria andPsTotalGreaterThan(BigDecimal value) {
            addCriterion("ps_total >", value, "psTotal");
            return (Criteria) this;
        }

        public Criteria andPsTotalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ps_total >=", value, "psTotal");
            return (Criteria) this;
        }

        public Criteria andPsTotalLessThan(BigDecimal value) {
            addCriterion("ps_total <", value, "psTotal");
            return (Criteria) this;
        }

        public Criteria andPsTotalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ps_total <=", value, "psTotal");
            return (Criteria) this;
        }

        public Criteria andPsTotalIn(List<BigDecimal> values) {
            addCriterion("ps_total in", values, "psTotal");
            return (Criteria) this;
        }

        public Criteria andPsTotalNotIn(List<BigDecimal> values) {
            addCriterion("ps_total not in", values, "psTotal");
            return (Criteria) this;
        }

        public Criteria andPsTotalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ps_total between", value1, value2, "psTotal");
            return (Criteria) this;
        }

        public Criteria andPsTotalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ps_total not between", value1, value2, "psTotal");
            return (Criteria) this;
        }

        public Criteria andPsDateIsNull() {
            addCriterion("ps_date is null");
            return (Criteria) this;
        }

        public Criteria andPsDateIsNotNull() {
            addCriterion("ps_date is not null");
            return (Criteria) this;
        }

        public Criteria andPsDateEqualTo(Date value) {
            addCriterion("ps_date =", value, "psDate");
            return (Criteria) this;
        }

        public Criteria andPsDateNotEqualTo(Date value) {
            addCriterion("ps_date <>", value, "psDate");
            return (Criteria) this;
        }

        public Criteria andPsDateGreaterThan(Date value) {
            addCriterion("ps_date >", value, "psDate");
            return (Criteria) this;
        }

        public Criteria andPsDateGreaterThanOrEqualTo(Date value) {
            addCriterion("ps_date >=", value, "psDate");
            return (Criteria) this;
        }

        public Criteria andPsDateLessThan(Date value) {
            addCriterion("ps_date <", value, "psDate");
            return (Criteria) this;
        }

        public Criteria andPsDateLessThanOrEqualTo(Date value) {
            addCriterion("ps_date <=", value, "psDate");
            return (Criteria) this;
        }

        public Criteria andPsDateIn(List<Date> values) {
            addCriterion("ps_date in", values, "psDate");
            return (Criteria) this;
        }

        public Criteria andPsDateNotIn(List<Date> values) {
            addCriterion("ps_date not in", values, "psDate");
            return (Criteria) this;
        }

        public Criteria andPsDateBetween(Date value1, Date value2) {
            addCriterion("ps_date between", value1, value2, "psDate");
            return (Criteria) this;
        }

        public Criteria andPsDateNotBetween(Date value1, Date value2) {
            addCriterion("ps_date not between", value1, value2, "psDate");
            return (Criteria) this;
        }

        public Criteria andPsStatusIsNull() {
            addCriterion("ps_status is null");
            return (Criteria) this;
        }

        public Criteria andPsStatusIsNotNull() {
            addCriterion("ps_status is not null");
            return (Criteria) this;
        }

        public Criteria andPsStatusEqualTo(String value) {
            addCriterion("ps_status =", value, "psStatus");
            return (Criteria) this;
        }

        public Criteria andPsStatusNotEqualTo(String value) {
            addCriterion("ps_status <>", value, "psStatus");
            return (Criteria) this;
        }

        public Criteria andPsStatusGreaterThan(String value) {
            addCriterion("ps_status >", value, "psStatus");
            return (Criteria) this;
        }

        public Criteria andPsStatusGreaterThanOrEqualTo(String value) {
            addCriterion("ps_status >=", value, "psStatus");
            return (Criteria) this;
        }

        public Criteria andPsStatusLessThan(String value) {
            addCriterion("ps_status <", value, "psStatus");
            return (Criteria) this;
        }

        public Criteria andPsStatusLessThanOrEqualTo(String value) {
            addCriterion("ps_status <=", value, "psStatus");
            return (Criteria) this;
        }

        public Criteria andPsStatusLike(String value) {
            addCriterion("ps_status like", value, "psStatus");
            return (Criteria) this;
        }

        public Criteria andPsStatusNotLike(String value) {
            addCriterion("ps_status not like", value, "psStatus");
            return (Criteria) this;
        }

        public Criteria andPsStatusIn(List<String> values) {
            addCriterion("ps_status in", values, "psStatus");
            return (Criteria) this;
        }

        public Criteria andPsStatusNotIn(List<String> values) {
            addCriterion("ps_status not in", values, "psStatus");
            return (Criteria) this;
        }

        public Criteria andPsStatusBetween(String value1, String value2) {
            addCriterion("ps_status between", value1, value2, "psStatus");
            return (Criteria) this;
        }

        public Criteria andPsStatusNotBetween(String value1, String value2) {
            addCriterion("ps_status not between", value1, value2, "psStatus");
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