package com.woniu.outlet.po;

import java.util.ArrayList;
import java.util.List;

public class RolePermsPoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RolePermsPoExample() {
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

        public Criteria andRpNameIsNull() {
            addCriterion("rp_name is null");
            return (Criteria) this;
        }

        public Criteria andRpNameIsNotNull() {
            addCriterion("rp_name is not null");
            return (Criteria) this;
        }

        public Criteria andRpNameEqualTo(String value) {
            addCriterion("rp_name =", value, "rpName");
            return (Criteria) this;
        }

        public Criteria andRpNameNotEqualTo(String value) {
            addCriterion("rp_name <>", value, "rpName");
            return (Criteria) this;
        }

        public Criteria andRpNameGreaterThan(String value) {
            addCriterion("rp_name >", value, "rpName");
            return (Criteria) this;
        }

        public Criteria andRpNameGreaterThanOrEqualTo(String value) {
            addCriterion("rp_name >=", value, "rpName");
            return (Criteria) this;
        }

        public Criteria andRpNameLessThan(String value) {
            addCriterion("rp_name <", value, "rpName");
            return (Criteria) this;
        }

        public Criteria andRpNameLessThanOrEqualTo(String value) {
            addCriterion("rp_name <=", value, "rpName");
            return (Criteria) this;
        }

        public Criteria andRpNameLike(String value) {
            addCriterion("rp_name like", value, "rpName");
            return (Criteria) this;
        }

        public Criteria andRpNameNotLike(String value) {
            addCriterion("rp_name not like", value, "rpName");
            return (Criteria) this;
        }

        public Criteria andRpNameIn(List<String> values) {
            addCriterion("rp_name in", values, "rpName");
            return (Criteria) this;
        }

        public Criteria andRpNameNotIn(List<String> values) {
            addCriterion("rp_name not in", values, "rpName");
            return (Criteria) this;
        }

        public Criteria andRpNameBetween(String value1, String value2) {
            addCriterion("rp_name between", value1, value2, "rpName");
            return (Criteria) this;
        }

        public Criteria andRpNameNotBetween(String value1, String value2) {
            addCriterion("rp_name not between", value1, value2, "rpName");
            return (Criteria) this;
        }

        public Criteria andRpCodeIsNull() {
            addCriterion("rp_code is null");
            return (Criteria) this;
        }

        public Criteria andRpCodeIsNotNull() {
            addCriterion("rp_code is not null");
            return (Criteria) this;
        }

        public Criteria andRpCodeEqualTo(String value) {
            addCriterion("rp_code =", value, "rpCode");
            return (Criteria) this;
        }

        public Criteria andRpCodeNotEqualTo(String value) {
            addCriterion("rp_code <>", value, "rpCode");
            return (Criteria) this;
        }

        public Criteria andRpCodeGreaterThan(String value) {
            addCriterion("rp_code >", value, "rpCode");
            return (Criteria) this;
        }

        public Criteria andRpCodeGreaterThanOrEqualTo(String value) {
            addCriterion("rp_code >=", value, "rpCode");
            return (Criteria) this;
        }

        public Criteria andRpCodeLessThan(String value) {
            addCriterion("rp_code <", value, "rpCode");
            return (Criteria) this;
        }

        public Criteria andRpCodeLessThanOrEqualTo(String value) {
            addCriterion("rp_code <=", value, "rpCode");
            return (Criteria) this;
        }

        public Criteria andRpCodeLike(String value) {
            addCriterion("rp_code like", value, "rpCode");
            return (Criteria) this;
        }

        public Criteria andRpCodeNotLike(String value) {
            addCriterion("rp_code not like", value, "rpCode");
            return (Criteria) this;
        }

        public Criteria andRpCodeIn(List<String> values) {
            addCriterion("rp_code in", values, "rpCode");
            return (Criteria) this;
        }

        public Criteria andRpCodeNotIn(List<String> values) {
            addCriterion("rp_code not in", values, "rpCode");
            return (Criteria) this;
        }

        public Criteria andRpCodeBetween(String value1, String value2) {
            addCriterion("rp_code between", value1, value2, "rpCode");
            return (Criteria) this;
        }

        public Criteria andRpCodeNotBetween(String value1, String value2) {
            addCriterion("rp_code not between", value1, value2, "rpCode");
            return (Criteria) this;
        }

        public Criteria andRpParentidIsNull() {
            addCriterion("rp_parentid is null");
            return (Criteria) this;
        }

        public Criteria andRpParentidIsNotNull() {
            addCriterion("rp_parentid is not null");
            return (Criteria) this;
        }

        public Criteria andRpParentidEqualTo(Integer value) {
            addCriterion("rp_parentid =", value, "rpParentid");
            return (Criteria) this;
        }

        public Criteria andRpParentidNotEqualTo(Integer value) {
            addCriterion("rp_parentid <>", value, "rpParentid");
            return (Criteria) this;
        }

        public Criteria andRpParentidGreaterThan(Integer value) {
            addCriterion("rp_parentid >", value, "rpParentid");
            return (Criteria) this;
        }

        public Criteria andRpParentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("rp_parentid >=", value, "rpParentid");
            return (Criteria) this;
        }

        public Criteria andRpParentidLessThan(Integer value) {
            addCriterion("rp_parentid <", value, "rpParentid");
            return (Criteria) this;
        }

        public Criteria andRpParentidLessThanOrEqualTo(Integer value) {
            addCriterion("rp_parentid <=", value, "rpParentid");
            return (Criteria) this;
        }

        public Criteria andRpParentidIn(List<Integer> values) {
            addCriterion("rp_parentid in", values, "rpParentid");
            return (Criteria) this;
        }

        public Criteria andRpParentidNotIn(List<Integer> values) {
            addCriterion("rp_parentid not in", values, "rpParentid");
            return (Criteria) this;
        }

        public Criteria andRpParentidBetween(Integer value1, Integer value2) {
            addCriterion("rp_parentid between", value1, value2, "rpParentid");
            return (Criteria) this;
        }

        public Criteria andRpParentidNotBetween(Integer value1, Integer value2) {
            addCriterion("rp_parentid not between", value1, value2, "rpParentid");
            return (Criteria) this;
        }

        public Criteria andRpTypeIsNull() {
            addCriterion("rp_type is null");
            return (Criteria) this;
        }

        public Criteria andRpTypeIsNotNull() {
            addCriterion("rp_type is not null");
            return (Criteria) this;
        }

        public Criteria andRpTypeEqualTo(String value) {
            addCriterion("rp_type =", value, "rpType");
            return (Criteria) this;
        }

        public Criteria andRpTypeNotEqualTo(String value) {
            addCriterion("rp_type <>", value, "rpType");
            return (Criteria) this;
        }

        public Criteria andRpTypeGreaterThan(String value) {
            addCriterion("rp_type >", value, "rpType");
            return (Criteria) this;
        }

        public Criteria andRpTypeGreaterThanOrEqualTo(String value) {
            addCriterion("rp_type >=", value, "rpType");
            return (Criteria) this;
        }

        public Criteria andRpTypeLessThan(String value) {
            addCriterion("rp_type <", value, "rpType");
            return (Criteria) this;
        }

        public Criteria andRpTypeLessThanOrEqualTo(String value) {
            addCriterion("rp_type <=", value, "rpType");
            return (Criteria) this;
        }

        public Criteria andRpTypeLike(String value) {
            addCriterion("rp_type like", value, "rpType");
            return (Criteria) this;
        }

        public Criteria andRpTypeNotLike(String value) {
            addCriterion("rp_type not like", value, "rpType");
            return (Criteria) this;
        }

        public Criteria andRpTypeIn(List<String> values) {
            addCriterion("rp_type in", values, "rpType");
            return (Criteria) this;
        }

        public Criteria andRpTypeNotIn(List<String> values) {
            addCriterion("rp_type not in", values, "rpType");
            return (Criteria) this;
        }

        public Criteria andRpTypeBetween(String value1, String value2) {
            addCriterion("rp_type between", value1, value2, "rpType");
            return (Criteria) this;
        }

        public Criteria andRpTypeNotBetween(String value1, String value2) {
            addCriterion("rp_type not between", value1, value2, "rpType");
            return (Criteria) this;
        }

        public Criteria andRpStatusIsNull() {
            addCriterion("rp_status is null");
            return (Criteria) this;
        }

        public Criteria andRpStatusIsNotNull() {
            addCriterion("rp_status is not null");
            return (Criteria) this;
        }

        public Criteria andRpStatusEqualTo(String value) {
            addCriterion("rp_status =", value, "rpStatus");
            return (Criteria) this;
        }

        public Criteria andRpStatusNotEqualTo(String value) {
            addCriterion("rp_status <>", value, "rpStatus");
            return (Criteria) this;
        }

        public Criteria andRpStatusGreaterThan(String value) {
            addCriterion("rp_status >", value, "rpStatus");
            return (Criteria) this;
        }

        public Criteria andRpStatusGreaterThanOrEqualTo(String value) {
            addCriterion("rp_status >=", value, "rpStatus");
            return (Criteria) this;
        }

        public Criteria andRpStatusLessThan(String value) {
            addCriterion("rp_status <", value, "rpStatus");
            return (Criteria) this;
        }

        public Criteria andRpStatusLessThanOrEqualTo(String value) {
            addCriterion("rp_status <=", value, "rpStatus");
            return (Criteria) this;
        }

        public Criteria andRpStatusLike(String value) {
            addCriterion("rp_status like", value, "rpStatus");
            return (Criteria) this;
        }

        public Criteria andRpStatusNotLike(String value) {
            addCriterion("rp_status not like", value, "rpStatus");
            return (Criteria) this;
        }

        public Criteria andRpStatusIn(List<String> values) {
            addCriterion("rp_status in", values, "rpStatus");
            return (Criteria) this;
        }

        public Criteria andRpStatusNotIn(List<String> values) {
            addCriterion("rp_status not in", values, "rpStatus");
            return (Criteria) this;
        }

        public Criteria andRpStatusBetween(String value1, String value2) {
            addCriterion("rp_status between", value1, value2, "rpStatus");
            return (Criteria) this;
        }

        public Criteria andRpStatusNotBetween(String value1, String value2) {
            addCriterion("rp_status not between", value1, value2, "rpStatus");
            return (Criteria) this;
        }

        public Criteria andRpPercodeIsNull() {
            addCriterion("rp_percode is null");
            return (Criteria) this;
        }

        public Criteria andRpPercodeIsNotNull() {
            addCriterion("rp_percode is not null");
            return (Criteria) this;
        }

        public Criteria andRpPercodeEqualTo(String value) {
            addCriterion("rp_percode =", value, "rpPercode");
            return (Criteria) this;
        }

        public Criteria andRpPercodeNotEqualTo(String value) {
            addCriterion("rp_percode <>", value, "rpPercode");
            return (Criteria) this;
        }

        public Criteria andRpPercodeGreaterThan(String value) {
            addCriterion("rp_percode >", value, "rpPercode");
            return (Criteria) this;
        }

        public Criteria andRpPercodeGreaterThanOrEqualTo(String value) {
            addCriterion("rp_percode >=", value, "rpPercode");
            return (Criteria) this;
        }

        public Criteria andRpPercodeLessThan(String value) {
            addCriterion("rp_percode <", value, "rpPercode");
            return (Criteria) this;
        }

        public Criteria andRpPercodeLessThanOrEqualTo(String value) {
            addCriterion("rp_percode <=", value, "rpPercode");
            return (Criteria) this;
        }

        public Criteria andRpPercodeLike(String value) {
            addCriterion("rp_percode like", value, "rpPercode");
            return (Criteria) this;
        }

        public Criteria andRpPercodeNotLike(String value) {
            addCriterion("rp_percode not like", value, "rpPercode");
            return (Criteria) this;
        }

        public Criteria andRpPercodeIn(List<String> values) {
            addCriterion("rp_percode in", values, "rpPercode");
            return (Criteria) this;
        }

        public Criteria andRpPercodeNotIn(List<String> values) {
            addCriterion("rp_percode not in", values, "rpPercode");
            return (Criteria) this;
        }

        public Criteria andRpPercodeBetween(String value1, String value2) {
            addCriterion("rp_percode between", value1, value2, "rpPercode");
            return (Criteria) this;
        }

        public Criteria andRpPercodeNotBetween(String value1, String value2) {
            addCriterion("rp_percode not between", value1, value2, "rpPercode");
            return (Criteria) this;
        }

        public Criteria andRpIconIsNull() {
            addCriterion("rp_icon is null");
            return (Criteria) this;
        }

        public Criteria andRpIconIsNotNull() {
            addCriterion("rp_icon is not null");
            return (Criteria) this;
        }

        public Criteria andRpIconEqualTo(String value) {
            addCriterion("rp_icon =", value, "rpIcon");
            return (Criteria) this;
        }

        public Criteria andRpIconNotEqualTo(String value) {
            addCriterion("rp_icon <>", value, "rpIcon");
            return (Criteria) this;
        }

        public Criteria andRpIconGreaterThan(String value) {
            addCriterion("rp_icon >", value, "rpIcon");
            return (Criteria) this;
        }

        public Criteria andRpIconGreaterThanOrEqualTo(String value) {
            addCriterion("rp_icon >=", value, "rpIcon");
            return (Criteria) this;
        }

        public Criteria andRpIconLessThan(String value) {
            addCriterion("rp_icon <", value, "rpIcon");
            return (Criteria) this;
        }

        public Criteria andRpIconLessThanOrEqualTo(String value) {
            addCriterion("rp_icon <=", value, "rpIcon");
            return (Criteria) this;
        }

        public Criteria andRpIconLike(String value) {
            addCriterion("rp_icon like", value, "rpIcon");
            return (Criteria) this;
        }

        public Criteria andRpIconNotLike(String value) {
            addCriterion("rp_icon not like", value, "rpIcon");
            return (Criteria) this;
        }

        public Criteria andRpIconIn(List<String> values) {
            addCriterion("rp_icon in", values, "rpIcon");
            return (Criteria) this;
        }

        public Criteria andRpIconNotIn(List<String> values) {
            addCriterion("rp_icon not in", values, "rpIcon");
            return (Criteria) this;
        }

        public Criteria andRpIconBetween(String value1, String value2) {
            addCriterion("rp_icon between", value1, value2, "rpIcon");
            return (Criteria) this;
        }

        public Criteria andRpIconNotBetween(String value1, String value2) {
            addCriterion("rp_icon not between", value1, value2, "rpIcon");
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