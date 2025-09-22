package com.woniu.outlet.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OperationItemPoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OperationItemPoExample() {
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

        public Criteria andOiNoIsNull() {
            addCriterion("oi_no is null");
            return (Criteria) this;
        }

        public Criteria andOiNoIsNotNull() {
            addCriterion("oi_no is not null");
            return (Criteria) this;
        }

        public Criteria andOiNoEqualTo(String value) {
            addCriterion("oi_no =", value, "oiNo");
            return (Criteria) this;
        }

        public Criteria andOiNoNotEqualTo(String value) {
            addCriterion("oi_no <>", value, "oiNo");
            return (Criteria) this;
        }

        public Criteria andOiNoGreaterThan(String value) {
            addCriterion("oi_no >", value, "oiNo");
            return (Criteria) this;
        }

        public Criteria andOiNoGreaterThanOrEqualTo(String value) {
            addCriterion("oi_no >=", value, "oiNo");
            return (Criteria) this;
        }

        public Criteria andOiNoLessThan(String value) {
            addCriterion("oi_no <", value, "oiNo");
            return (Criteria) this;
        }

        public Criteria andOiNoLessThanOrEqualTo(String value) {
            addCriterion("oi_no <=", value, "oiNo");
            return (Criteria) this;
        }

        public Criteria andOiNoLike(String value) {
            addCriterion("oi_no like", value, "oiNo");
            return (Criteria) this;
        }

        public Criteria andOiNoNotLike(String value) {
            addCriterion("oi_no not like", value, "oiNo");
            return (Criteria) this;
        }

        public Criteria andOiNoIn(List<String> values) {
            addCriterion("oi_no in", values, "oiNo");
            return (Criteria) this;
        }

        public Criteria andOiNoNotIn(List<String> values) {
            addCriterion("oi_no not in", values, "oiNo");
            return (Criteria) this;
        }

        public Criteria andOiNoBetween(String value1, String value2) {
            addCriterion("oi_no between", value1, value2, "oiNo");
            return (Criteria) this;
        }

        public Criteria andOiNoNotBetween(String value1, String value2) {
            addCriterion("oi_no not between", value1, value2, "oiNo");
            return (Criteria) this;
        }

        public Criteria andOiNameIsNull() {
            addCriterion("oi_name is null");
            return (Criteria) this;
        }

        public Criteria andOiNameIsNotNull() {
            addCriterion("oi_name is not null");
            return (Criteria) this;
        }

        public Criteria andOiNameEqualTo(String value) {
            addCriterion("oi_name =", value, "oiName");
            return (Criteria) this;
        }

        public Criteria andOiNameNotEqualTo(String value) {
            addCriterion("oi_name <>", value, "oiName");
            return (Criteria) this;
        }

        public Criteria andOiNameGreaterThan(String value) {
            addCriterion("oi_name >", value, "oiName");
            return (Criteria) this;
        }

        public Criteria andOiNameGreaterThanOrEqualTo(String value) {
            addCriterion("oi_name >=", value, "oiName");
            return (Criteria) this;
        }

        public Criteria andOiNameLessThan(String value) {
            addCriterion("oi_name <", value, "oiName");
            return (Criteria) this;
        }

        public Criteria andOiNameLessThanOrEqualTo(String value) {
            addCriterion("oi_name <=", value, "oiName");
            return (Criteria) this;
        }

        public Criteria andOiNameLike(String value) {
            addCriterion("oi_name like", value, "oiName");
            return (Criteria) this;
        }

        public Criteria andOiNameNotLike(String value) {
            addCriterion("oi_name not like", value, "oiName");
            return (Criteria) this;
        }

        public Criteria andOiNameIn(List<String> values) {
            addCriterion("oi_name in", values, "oiName");
            return (Criteria) this;
        }

        public Criteria andOiNameNotIn(List<String> values) {
            addCriterion("oi_name not in", values, "oiName");
            return (Criteria) this;
        }

        public Criteria andOiNameBetween(String value1, String value2) {
            addCriterion("oi_name between", value1, value2, "oiName");
            return (Criteria) this;
        }

        public Criteria andOiNameNotBetween(String value1, String value2) {
            addCriterion("oi_name not between", value1, value2, "oiName");
            return (Criteria) this;
        }

        public Criteria andOiSurgerycostIsNull() {
            addCriterion("oi_surgerycost is null");
            return (Criteria) this;
        }

        public Criteria andOiSurgerycostIsNotNull() {
            addCriterion("oi_surgerycost is not null");
            return (Criteria) this;
        }

        public Criteria andOiSurgerycostEqualTo(BigDecimal value) {
            addCriterion("oi_surgerycost =", value, "oiSurgerycost");
            return (Criteria) this;
        }

        public Criteria andOiSurgerycostNotEqualTo(BigDecimal value) {
            addCriterion("oi_surgerycost <>", value, "oiSurgerycost");
            return (Criteria) this;
        }

        public Criteria andOiSurgerycostGreaterThan(BigDecimal value) {
            addCriterion("oi_surgerycost >", value, "oiSurgerycost");
            return (Criteria) this;
        }

        public Criteria andOiSurgerycostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("oi_surgerycost >=", value, "oiSurgerycost");
            return (Criteria) this;
        }

        public Criteria andOiSurgerycostLessThan(BigDecimal value) {
            addCriterion("oi_surgerycost <", value, "oiSurgerycost");
            return (Criteria) this;
        }

        public Criteria andOiSurgerycostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("oi_surgerycost <=", value, "oiSurgerycost");
            return (Criteria) this;
        }

        public Criteria andOiSurgerycostIn(List<BigDecimal> values) {
            addCriterion("oi_surgerycost in", values, "oiSurgerycost");
            return (Criteria) this;
        }

        public Criteria andOiSurgerycostNotIn(List<BigDecimal> values) {
            addCriterion("oi_surgerycost not in", values, "oiSurgerycost");
            return (Criteria) this;
        }

        public Criteria andOiSurgerycostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("oi_surgerycost between", value1, value2, "oiSurgerycost");
            return (Criteria) this;
        }

        public Criteria andOiSurgerycostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("oi_surgerycost not between", value1, value2, "oiSurgerycost");
            return (Criteria) this;
        }

        public Criteria andOiLaborcostIsNull() {
            addCriterion("oi_laborcost is null");
            return (Criteria) this;
        }

        public Criteria andOiLaborcostIsNotNull() {
            addCriterion("oi_laborcost is not null");
            return (Criteria) this;
        }

        public Criteria andOiLaborcostEqualTo(BigDecimal value) {
            addCriterion("oi_laborcost =", value, "oiLaborcost");
            return (Criteria) this;
        }

        public Criteria andOiLaborcostNotEqualTo(BigDecimal value) {
            addCriterion("oi_laborcost <>", value, "oiLaborcost");
            return (Criteria) this;
        }

        public Criteria andOiLaborcostGreaterThan(BigDecimal value) {
            addCriterion("oi_laborcost >", value, "oiLaborcost");
            return (Criteria) this;
        }

        public Criteria andOiLaborcostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("oi_laborcost >=", value, "oiLaborcost");
            return (Criteria) this;
        }

        public Criteria andOiLaborcostLessThan(BigDecimal value) {
            addCriterion("oi_laborcost <", value, "oiLaborcost");
            return (Criteria) this;
        }

        public Criteria andOiLaborcostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("oi_laborcost <=", value, "oiLaborcost");
            return (Criteria) this;
        }

        public Criteria andOiLaborcostIn(List<BigDecimal> values) {
            addCriterion("oi_laborcost in", values, "oiLaborcost");
            return (Criteria) this;
        }

        public Criteria andOiLaborcostNotIn(List<BigDecimal> values) {
            addCriterion("oi_laborcost not in", values, "oiLaborcost");
            return (Criteria) this;
        }

        public Criteria andOiLaborcostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("oi_laborcost between", value1, value2, "oiLaborcost");
            return (Criteria) this;
        }

        public Criteria andOiLaborcostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("oi_laborcost not between", value1, value2, "oiLaborcost");
            return (Criteria) this;
        }

        public Criteria andOiSidIsNull() {
            addCriterion("oi_sid is null");
            return (Criteria) this;
        }

        public Criteria andOiSidIsNotNull() {
            addCriterion("oi_sid is not null");
            return (Criteria) this;
        }

        public Criteria andOiSidEqualTo(Integer value) {
            addCriterion("oi_sid =", value, "oiSid");
            return (Criteria) this;
        }

        public Criteria andOiSidNotEqualTo(Integer value) {
            addCriterion("oi_sid <>", value, "oiSid");
            return (Criteria) this;
        }

        public Criteria andOiSidGreaterThan(Integer value) {
            addCriterion("oi_sid >", value, "oiSid");
            return (Criteria) this;
        }

        public Criteria andOiSidGreaterThanOrEqualTo(Integer value) {
            addCriterion("oi_sid >=", value, "oiSid");
            return (Criteria) this;
        }

        public Criteria andOiSidLessThan(Integer value) {
            addCriterion("oi_sid <", value, "oiSid");
            return (Criteria) this;
        }

        public Criteria andOiSidLessThanOrEqualTo(Integer value) {
            addCriterion("oi_sid <=", value, "oiSid");
            return (Criteria) this;
        }

        public Criteria andOiSidIn(List<Integer> values) {
            addCriterion("oi_sid in", values, "oiSid");
            return (Criteria) this;
        }

        public Criteria andOiSidNotIn(List<Integer> values) {
            addCriterion("oi_sid not in", values, "oiSid");
            return (Criteria) this;
        }

        public Criteria andOiSidBetween(Integer value1, Integer value2) {
            addCriterion("oi_sid between", value1, value2, "oiSid");
            return (Criteria) this;
        }

        public Criteria andOiSidNotBetween(Integer value1, Integer value2) {
            addCriterion("oi_sid not between", value1, value2, "oiSid");
            return (Criteria) this;
        }

        public Criteria andOiSnameIsNull() {
            addCriterion("oi_sname is null");
            return (Criteria) this;
        }

        public Criteria andOiSnameIsNotNull() {
            addCriterion("oi_sname is not null");
            return (Criteria) this;
        }

        public Criteria andOiSnameEqualTo(String value) {
            addCriterion("oi_sname =", value, "oiSname");
            return (Criteria) this;
        }

        public Criteria andOiSnameNotEqualTo(String value) {
            addCriterion("oi_sname <>", value, "oiSname");
            return (Criteria) this;
        }

        public Criteria andOiSnameGreaterThan(String value) {
            addCriterion("oi_sname >", value, "oiSname");
            return (Criteria) this;
        }

        public Criteria andOiSnameGreaterThanOrEqualTo(String value) {
            addCriterion("oi_sname >=", value, "oiSname");
            return (Criteria) this;
        }

        public Criteria andOiSnameLessThan(String value) {
            addCriterion("oi_sname <", value, "oiSname");
            return (Criteria) this;
        }

        public Criteria andOiSnameLessThanOrEqualTo(String value) {
            addCriterion("oi_sname <=", value, "oiSname");
            return (Criteria) this;
        }

        public Criteria andOiSnameLike(String value) {
            addCriterion("oi_sname like", value, "oiSname");
            return (Criteria) this;
        }

        public Criteria andOiSnameNotLike(String value) {
            addCriterion("oi_sname not like", value, "oiSname");
            return (Criteria) this;
        }

        public Criteria andOiSnameIn(List<String> values) {
            addCriterion("oi_sname in", values, "oiSname");
            return (Criteria) this;
        }

        public Criteria andOiSnameNotIn(List<String> values) {
            addCriterion("oi_sname not in", values, "oiSname");
            return (Criteria) this;
        }

        public Criteria andOiSnameBetween(String value1, String value2) {
            addCriterion("oi_sname between", value1, value2, "oiSname");
            return (Criteria) this;
        }

        public Criteria andOiSnameNotBetween(String value1, String value2) {
            addCriterion("oi_sname not between", value1, value2, "oiSname");
            return (Criteria) this;
        }

        public Criteria andOiStatusIsNull() {
            addCriterion("oi_status is null");
            return (Criteria) this;
        }

        public Criteria andOiStatusIsNotNull() {
            addCriterion("oi_status is not null");
            return (Criteria) this;
        }

        public Criteria andOiStatusEqualTo(String value) {
            addCriterion("oi_status =", value, "oiStatus");
            return (Criteria) this;
        }

        public Criteria andOiStatusNotEqualTo(String value) {
            addCriterion("oi_status <>", value, "oiStatus");
            return (Criteria) this;
        }

        public Criteria andOiStatusGreaterThan(String value) {
            addCriterion("oi_status >", value, "oiStatus");
            return (Criteria) this;
        }

        public Criteria andOiStatusGreaterThanOrEqualTo(String value) {
            addCriterion("oi_status >=", value, "oiStatus");
            return (Criteria) this;
        }

        public Criteria andOiStatusLessThan(String value) {
            addCriterion("oi_status <", value, "oiStatus");
            return (Criteria) this;
        }

        public Criteria andOiStatusLessThanOrEqualTo(String value) {
            addCriterion("oi_status <=", value, "oiStatus");
            return (Criteria) this;
        }

        public Criteria andOiStatusLike(String value) {
            addCriterion("oi_status like", value, "oiStatus");
            return (Criteria) this;
        }

        public Criteria andOiStatusNotLike(String value) {
            addCriterion("oi_status not like", value, "oiStatus");
            return (Criteria) this;
        }

        public Criteria andOiStatusIn(List<String> values) {
            addCriterion("oi_status in", values, "oiStatus");
            return (Criteria) this;
        }

        public Criteria andOiStatusNotIn(List<String> values) {
            addCriterion("oi_status not in", values, "oiStatus");
            return (Criteria) this;
        }

        public Criteria andOiStatusBetween(String value1, String value2) {
            addCriterion("oi_status between", value1, value2, "oiStatus");
            return (Criteria) this;
        }

        public Criteria andOiStatusNotBetween(String value1, String value2) {
            addCriterion("oi_status not between", value1, value2, "oiStatus");
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