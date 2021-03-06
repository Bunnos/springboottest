package com.boot.model.cluster;

import java.util.ArrayList;
import java.util.List;

public class JsResourceMidCategoriesExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table js_resource_mid_categories
     *
     * @mbggenerated Fri Jul 07 09:05:37 CST 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table js_resource_mid_categories
     *
     * @mbggenerated Fri Jul 07 09:05:37 CST 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table js_resource_mid_categories
     *
     * @mbggenerated Fri Jul 07 09:05:37 CST 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_resource_mid_categories
     *
     * @mbggenerated Fri Jul 07 09:05:37 CST 2017
     */
    public JsResourceMidCategoriesExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_resource_mid_categories
     *
     * @mbggenerated Fri Jul 07 09:05:37 CST 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_resource_mid_categories
     *
     * @mbggenerated Fri Jul 07 09:05:37 CST 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_resource_mid_categories
     *
     * @mbggenerated Fri Jul 07 09:05:37 CST 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_resource_mid_categories
     *
     * @mbggenerated Fri Jul 07 09:05:37 CST 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_resource_mid_categories
     *
     * @mbggenerated Fri Jul 07 09:05:37 CST 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_resource_mid_categories
     *
     * @mbggenerated Fri Jul 07 09:05:37 CST 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_resource_mid_categories
     *
     * @mbggenerated Fri Jul 07 09:05:37 CST 2017
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_resource_mid_categories
     *
     * @mbggenerated Fri Jul 07 09:05:37 CST 2017
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_resource_mid_categories
     *
     * @mbggenerated Fri Jul 07 09:05:37 CST 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_resource_mid_categories
     *
     * @mbggenerated Fri Jul 07 09:05:37 CST 2017
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table js_resource_mid_categories
     *
     * @mbggenerated Fri Jul 07 09:05:37 CST 2017
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andBusiidIsNull() {
            addCriterion("busiId is null");
            return (Criteria) this;
        }

        public Criteria andBusiidIsNotNull() {
            addCriterion("busiId is not null");
            return (Criteria) this;
        }

        public Criteria andBusiidEqualTo(String value) {
            addCriterion("busiId =", value, "busiid");
            return (Criteria) this;
        }

        public Criteria andBusiidNotEqualTo(String value) {
            addCriterion("busiId <>", value, "busiid");
            return (Criteria) this;
        }

        public Criteria andBusiidGreaterThan(String value) {
            addCriterion("busiId >", value, "busiid");
            return (Criteria) this;
        }

        public Criteria andBusiidGreaterThanOrEqualTo(String value) {
            addCriterion("busiId >=", value, "busiid");
            return (Criteria) this;
        }

        public Criteria andBusiidLessThan(String value) {
            addCriterion("busiId <", value, "busiid");
            return (Criteria) this;
        }

        public Criteria andBusiidLessThanOrEqualTo(String value) {
            addCriterion("busiId <=", value, "busiid");
            return (Criteria) this;
        }

        public Criteria andBusiidLike(String value) {
            addCriterion("busiId like", value, "busiid");
            return (Criteria) this;
        }

        public Criteria andBusiidNotLike(String value) {
            addCriterion("busiId not like", value, "busiid");
            return (Criteria) this;
        }

        public Criteria andBusiidIn(List<String> values) {
            addCriterion("busiId in", values, "busiid");
            return (Criteria) this;
        }

        public Criteria andBusiidNotIn(List<String> values) {
            addCriterion("busiId not in", values, "busiid");
            return (Criteria) this;
        }

        public Criteria andBusiidBetween(String value1, String value2) {
            addCriterion("busiId between", value1, value2, "busiid");
            return (Criteria) this;
        }

        public Criteria andBusiidNotBetween(String value1, String value2) {
            addCriterion("busiId not between", value1, value2, "busiid");
            return (Criteria) this;
        }

        public Criteria andTcategoriesidIsNull() {
            addCriterion("tCategoriesId is null");
            return (Criteria) this;
        }

        public Criteria andTcategoriesidIsNotNull() {
            addCriterion("tCategoriesId is not null");
            return (Criteria) this;
        }

        public Criteria andTcategoriesidEqualTo(String value) {
            addCriterion("tCategoriesId =", value, "tcategoriesid");
            return (Criteria) this;
        }

        public Criteria andTcategoriesidNotEqualTo(String value) {
            addCriterion("tCategoriesId <>", value, "tcategoriesid");
            return (Criteria) this;
        }

        public Criteria andTcategoriesidGreaterThan(String value) {
            addCriterion("tCategoriesId >", value, "tcategoriesid");
            return (Criteria) this;
        }

        public Criteria andTcategoriesidGreaterThanOrEqualTo(String value) {
            addCriterion("tCategoriesId >=", value, "tcategoriesid");
            return (Criteria) this;
        }

        public Criteria andTcategoriesidLessThan(String value) {
            addCriterion("tCategoriesId <", value, "tcategoriesid");
            return (Criteria) this;
        }

        public Criteria andTcategoriesidLessThanOrEqualTo(String value) {
            addCriterion("tCategoriesId <=", value, "tcategoriesid");
            return (Criteria) this;
        }

        public Criteria andTcategoriesidLike(String value) {
            addCriterion("tCategoriesId like", value, "tcategoriesid");
            return (Criteria) this;
        }

        public Criteria andTcategoriesidNotLike(String value) {
            addCriterion("tCategoriesId not like", value, "tcategoriesid");
            return (Criteria) this;
        }

        public Criteria andTcategoriesidIn(List<String> values) {
            addCriterion("tCategoriesId in", values, "tcategoriesid");
            return (Criteria) this;
        }

        public Criteria andTcategoriesidNotIn(List<String> values) {
            addCriterion("tCategoriesId not in", values, "tcategoriesid");
            return (Criteria) this;
        }

        public Criteria andTcategoriesidBetween(String value1, String value2) {
            addCriterion("tCategoriesId between", value1, value2, "tcategoriesid");
            return (Criteria) this;
        }

        public Criteria andTcategoriesidNotBetween(String value1, String value2) {
            addCriterion("tCategoriesId not between", value1, value2, "tcategoriesid");
            return (Criteria) this;
        }

        public Criteria andCategdeepIsNull() {
            addCriterion("categDeep is null");
            return (Criteria) this;
        }

        public Criteria andCategdeepIsNotNull() {
            addCriterion("categDeep is not null");
            return (Criteria) this;
        }

        public Criteria andCategdeepEqualTo(String value) {
            addCriterion("categDeep =", value, "categdeep");
            return (Criteria) this;
        }

        public Criteria andCategdeepNotEqualTo(String value) {
            addCriterion("categDeep <>", value, "categdeep");
            return (Criteria) this;
        }

        public Criteria andCategdeepGreaterThan(String value) {
            addCriterion("categDeep >", value, "categdeep");
            return (Criteria) this;
        }

        public Criteria andCategdeepGreaterThanOrEqualTo(String value) {
            addCriterion("categDeep >=", value, "categdeep");
            return (Criteria) this;
        }

        public Criteria andCategdeepLessThan(String value) {
            addCriterion("categDeep <", value, "categdeep");
            return (Criteria) this;
        }

        public Criteria andCategdeepLessThanOrEqualTo(String value) {
            addCriterion("categDeep <=", value, "categdeep");
            return (Criteria) this;
        }

        public Criteria andCategdeepLike(String value) {
            addCriterion("categDeep like", value, "categdeep");
            return (Criteria) this;
        }

        public Criteria andCategdeepNotLike(String value) {
            addCriterion("categDeep not like", value, "categdeep");
            return (Criteria) this;
        }

        public Criteria andCategdeepIn(List<String> values) {
            addCriterion("categDeep in", values, "categdeep");
            return (Criteria) this;
        }

        public Criteria andCategdeepNotIn(List<String> values) {
            addCriterion("categDeep not in", values, "categdeep");
            return (Criteria) this;
        }

        public Criteria andCategdeepBetween(String value1, String value2) {
            addCriterion("categDeep between", value1, value2, "categdeep");
            return (Criteria) this;
        }

        public Criteria andCategdeepNotBetween(String value1, String value2) {
            addCriterion("categDeep not between", value1, value2, "categdeep");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table js_resource_mid_categories
     *
     * @mbggenerated do_not_delete_during_merge Fri Jul 07 09:05:37 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table js_resource_mid_categories
     *
     * @mbggenerated Fri Jul 07 09:05:37 CST 2017
     */
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