package com.woniu.outlet.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DrugSendPoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DrugSendPoExample() {
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

        public Criteria andDsNoIsNull() {
            addCriterion("ds_no is null");
            return (Criteria) this;
        }

        public Criteria andDsNoIsNotNull() {
            addCriterion("ds_no is not null");
            return (Criteria) this;
        }

        public Criteria andDsNoEqualTo(String value) {
            addCriterion("ds_no =", value, "dsNo");
            return (Criteria) this;
        }

        public Criteria andDsNoNotEqualTo(String value) {
            addCriterion("ds_no <>", value, "dsNo");
            return (Criteria) this;
        }

        public Criteria andDsNoGreaterThan(String value) {
            addCriterion("ds_no >", value, "dsNo");
            return (Criteria) this;
        }

        public Criteria andDsNoGreaterThanOrEqualTo(String value) {
            addCriterion("ds_no >=", value, "dsNo");
            return (Criteria) this;
        }

        public Criteria andDsNoLessThan(String value) {
            addCriterion("ds_no <", value, "dsNo");
            return (Criteria) this;
        }

        public Criteria andDsNoLessThanOrEqualTo(String value) {
            addCriterion("ds_no <=", value, "dsNo");
            return (Criteria) this;
        }

        public Criteria andDsNoLike(String value) {
            addCriterion("ds_no like", value, "dsNo");
            return (Criteria) this;
        }

        public Criteria andDsNoNotLike(String value) {
            addCriterion("ds_no not like", value, "dsNo");
            return (Criteria) this;
        }

        public Criteria andDsNoIn(List<String> values) {
            addCriterion("ds_no in", values, "dsNo");
            return (Criteria) this;
        }

        public Criteria andDsNoNotIn(List<String> values) {
            addCriterion("ds_no not in", values, "dsNo");
            return (Criteria) this;
        }

        public Criteria andDsNoBetween(String value1, String value2) {
            addCriterion("ds_no between", value1, value2, "dsNo");
            return (Criteria) this;
        }

        public Criteria andDsNoNotBetween(String value1, String value2) {
            addCriterion("ds_no not between", value1, value2, "dsNo");
            return (Criteria) this;
        }

        public Criteria andDsPatientidIsNull() {
            addCriterion("ds_patientid is null");
            return (Criteria) this;
        }

        public Criteria andDsPatientidIsNotNull() {
            addCriterion("ds_patientid is not null");
            return (Criteria) this;
        }

        public Criteria andDsPatientidEqualTo(Integer value) {
            addCriterion("ds_patientid =", value, "dsPatientid");
            return (Criteria) this;
        }

        public Criteria andDsPatientidNotEqualTo(Integer value) {
            addCriterion("ds_patientid <>", value, "dsPatientid");
            return (Criteria) this;
        }

        public Criteria andDsPatientidGreaterThan(Integer value) {
            addCriterion("ds_patientid >", value, "dsPatientid");
            return (Criteria) this;
        }

        public Criteria andDsPatientidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ds_patientid >=", value, "dsPatientid");
            return (Criteria) this;
        }

        public Criteria andDsPatientidLessThan(Integer value) {
            addCriterion("ds_patientid <", value, "dsPatientid");
            return (Criteria) this;
        }

        public Criteria andDsPatientidLessThanOrEqualTo(Integer value) {
            addCriterion("ds_patientid <=", value, "dsPatientid");
            return (Criteria) this;
        }

        public Criteria andDsPatientidIn(List<Integer> values) {
            addCriterion("ds_patientid in", values, "dsPatientid");
            return (Criteria) this;
        }

        public Criteria andDsPatientidNotIn(List<Integer> values) {
            addCriterion("ds_patientid not in", values, "dsPatientid");
            return (Criteria) this;
        }

        public Criteria andDsPatientidBetween(Integer value1, Integer value2) {
            addCriterion("ds_patientid between", value1, value2, "dsPatientid");
            return (Criteria) this;
        }

        public Criteria andDsPatientidNotBetween(Integer value1, Integer value2) {
            addCriterion("ds_patientid not between", value1, value2, "dsPatientid");
            return (Criteria) this;
        }

        public Criteria andDsPatientnameIsNull() {
            addCriterion("ds_patientname is null");
            return (Criteria) this;
        }

        public Criteria andDsPatientnameIsNotNull() {
            addCriterion("ds_patientname is not null");
            return (Criteria) this;
        }

        public Criteria andDsPatientnameEqualTo(String value) {
            addCriterion("ds_patientname =", value, "dsPatientname");
            return (Criteria) this;
        }

        public Criteria andDsPatientnameNotEqualTo(String value) {
            addCriterion("ds_patientname <>", value, "dsPatientname");
            return (Criteria) this;
        }

        public Criteria andDsPatientnameGreaterThan(String value) {
            addCriterion("ds_patientname >", value, "dsPatientname");
            return (Criteria) this;
        }

        public Criteria andDsPatientnameGreaterThanOrEqualTo(String value) {
            addCriterion("ds_patientname >=", value, "dsPatientname");
            return (Criteria) this;
        }

        public Criteria andDsPatientnameLessThan(String value) {
            addCriterion("ds_patientname <", value, "dsPatientname");
            return (Criteria) this;
        }

        public Criteria andDsPatientnameLessThanOrEqualTo(String value) {
            addCriterion("ds_patientname <=", value, "dsPatientname");
            return (Criteria) this;
        }

        public Criteria andDsPatientnameLike(String value) {
            addCriterion("ds_patientname like", value, "dsPatientname");
            return (Criteria) this;
        }

        public Criteria andDsPatientnameNotLike(String value) {
            addCriterion("ds_patientname not like", value, "dsPatientname");
            return (Criteria) this;
        }

        public Criteria andDsPatientnameIn(List<String> values) {
            addCriterion("ds_patientname in", values, "dsPatientname");
            return (Criteria) this;
        }

        public Criteria andDsPatientnameNotIn(List<String> values) {
            addCriterion("ds_patientname not in", values, "dsPatientname");
            return (Criteria) this;
        }

        public Criteria andDsPatientnameBetween(String value1, String value2) {
            addCriterion("ds_patientname between", value1, value2, "dsPatientname");
            return (Criteria) this;
        }

        public Criteria andDsPatientnameNotBetween(String value1, String value2) {
            addCriterion("ds_patientname not between", value1, value2, "dsPatientname");
            return (Criteria) this;
        }

        public Criteria andDsTotalIsNull() {
            addCriterion("ds_total is null");
            return (Criteria) this;
        }

        public Criteria andDsTotalIsNotNull() {
            addCriterion("ds_total is not null");
            return (Criteria) this;
        }

        public Criteria andDsTotalEqualTo(BigDecimal value) {
            addCriterion("ds_total =", value, "dsTotal");
            return (Criteria) this;
        }

        public Criteria andDsTotalNotEqualTo(BigDecimal value) {
            addCriterion("ds_total <>", value, "dsTotal");
            return (Criteria) this;
        }

        public Criteria andDsTotalGreaterThan(BigDecimal value) {
            addCriterion("ds_total >", value, "dsTotal");
            return (Criteria) this;
        }

        public Criteria andDsTotalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ds_total >=", value, "dsTotal");
            return (Criteria) this;
        }

        public Criteria andDsTotalLessThan(BigDecimal value) {
            addCriterion("ds_total <", value, "dsTotal");
            return (Criteria) this;
        }

        public Criteria andDsTotalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ds_total <=", value, "dsTotal");
            return (Criteria) this;
        }

        public Criteria andDsTotalIn(List<BigDecimal> values) {
            addCriterion("ds_total in", values, "dsTotal");
            return (Criteria) this;
        }

        public Criteria andDsTotalNotIn(List<BigDecimal> values) {
            addCriterion("ds_total not in", values, "dsTotal");
            return (Criteria) this;
        }

        public Criteria andDsTotalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ds_total between", value1, value2, "dsTotal");
            return (Criteria) this;
        }

        public Criteria andDsTotalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ds_total not between", value1, value2, "dsTotal");
            return (Criteria) this;
        }

        public Criteria andDsDateIsNull() {
            addCriterion("ds_date is null");
            return (Criteria) this;
        }

        public Criteria andDsDateIsNotNull() {
            addCriterion("ds_date is not null");
            return (Criteria) this;
        }

        public Criteria andDsDateEqualTo(Date value) {
            addCriterion("ds_date =", value, "dsDate");
            return (Criteria) this;
        }

        public Criteria andDsDateNotEqualTo(Date value) {
            addCriterion("ds_date <>", value, "dsDate");
            return (Criteria) this;
        }

        public Criteria andDsDateGreaterThan(Date value) {
            addCriterion("ds_date >", value, "dsDate");
            return (Criteria) this;
        }

        public Criteria andDsDateGreaterThanOrEqualTo(Date value) {
            addCriterion("ds_date >=", value, "dsDate");
            return (Criteria) this;
        }

        public Criteria andDsDateLessThan(Date value) {
            addCriterion("ds_date <", value, "dsDate");
            return (Criteria) this;
        }

        public Criteria andDsDateLessThanOrEqualTo(Date value) {
            addCriterion("ds_date <=", value, "dsDate");
            return (Criteria) this;
        }

        public Criteria andDsDateIn(List<Date> values) {
            addCriterion("ds_date in", values, "dsDate");
            return (Criteria) this;
        }

        public Criteria andDsDateNotIn(List<Date> values) {
            addCriterion("ds_date not in", values, "dsDate");
            return (Criteria) this;
        }

        public Criteria andDsDateBetween(Date value1, Date value2) {
            addCriterion("ds_date between", value1, value2, "dsDate");
            return (Criteria) this;
        }

        public Criteria andDsDateNotBetween(Date value1, Date value2) {
            addCriterion("ds_date not between", value1, value2, "dsDate");
            return (Criteria) this;
        }

        public Criteria andDsStatusIsNull() {
            addCriterion("ds_status is null");
            return (Criteria) this;
        }

        public Criteria andDsStatusIsNotNull() {
            addCriterion("ds_status is not null");
            return (Criteria) this;
        }

        public Criteria andDsStatusEqualTo(String value) {
            addCriterion("ds_status =", value, "dsStatus");
            return (Criteria) this;
        }

        public Criteria andDsStatusNotEqualTo(String value) {
            addCriterion("ds_status <>", value, "dsStatus");
            return (Criteria) this;
        }

        public Criteria andDsStatusGreaterThan(String value) {
            addCriterion("ds_status >", value, "dsStatus");
            return (Criteria) this;
        }

        public Criteria andDsStatusGreaterThanOrEqualTo(String value) {
            addCriterion("ds_status >=", value, "dsStatus");
            return (Criteria) this;
        }

        public Criteria andDsStatusLessThan(String value) {
            addCriterion("ds_status <", value, "dsStatus");
            return (Criteria) this;
        }

        public Criteria andDsStatusLessThanOrEqualTo(String value) {
            addCriterion("ds_status <=", value, "dsStatus");
            return (Criteria) this;
        }

        public Criteria andDsStatusLike(String value) {
            addCriterion("ds_status like", value, "dsStatus");
            return (Criteria) this;
        }

        public Criteria andDsStatusNotLike(String value) {
            addCriterion("ds_status not like", value, "dsStatus");
            return (Criteria) this;
        }

        public Criteria andDsStatusIn(List<String> values) {
            addCriterion("ds_status in", values, "dsStatus");
            return (Criteria) this;
        }

        public Criteria andDsStatusNotIn(List<String> values) {
            addCriterion("ds_status not in", values, "dsStatus");
            return (Criteria) this;
        }

        public Criteria andDsStatusBetween(String value1, String value2) {
            addCriterion("ds_status between", value1, value2, "dsStatus");
            return (Criteria) this;
        }

        public Criteria andDsStatusNotBetween(String value1, String value2) {
            addCriterion("ds_status not between", value1, value2, "dsStatus");
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