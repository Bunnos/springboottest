package com.boot.model.cluster;

import java.util.ArrayList;
import java.util.List;

public class JsEbookTemplateExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table js_ebook_template
     *
     * @mbggenerated Tue Aug 01 14:16:04 CST 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table js_ebook_template
     *
     * @mbggenerated Tue Aug 01 14:16:04 CST 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table js_ebook_template
     *
     * @mbggenerated Tue Aug 01 14:16:04 CST 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_ebook_template
     *
     * @mbggenerated Tue Aug 01 14:16:04 CST 2017
     */
    public JsEbookTemplateExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_ebook_template
     *
     * @mbggenerated Tue Aug 01 14:16:04 CST 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_ebook_template
     *
     * @mbggenerated Tue Aug 01 14:16:04 CST 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_ebook_template
     *
     * @mbggenerated Tue Aug 01 14:16:04 CST 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_ebook_template
     *
     * @mbggenerated Tue Aug 01 14:16:04 CST 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_ebook_template
     *
     * @mbggenerated Tue Aug 01 14:16:04 CST 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_ebook_template
     *
     * @mbggenerated Tue Aug 01 14:16:04 CST 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_ebook_template
     *
     * @mbggenerated Tue Aug 01 14:16:04 CST 2017
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_ebook_template
     *
     * @mbggenerated Tue Aug 01 14:16:04 CST 2017
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
     * This method corresponds to the database table js_ebook_template
     *
     * @mbggenerated Tue Aug 01 14:16:04 CST 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_ebook_template
     *
     * @mbggenerated Tue Aug 01 14:16:04 CST 2017
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table js_ebook_template
     *
     * @mbggenerated Tue Aug 01 14:16:04 CST 2017
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

        public Criteria andRelationidIsNull() {
            addCriterion("relationId is null");
            return (Criteria) this;
        }

        public Criteria andRelationidIsNotNull() {
            addCriterion("relationId is not null");
            return (Criteria) this;
        }

        public Criteria andRelationidEqualTo(String value) {
            addCriterion("relationId =", value, "relationid");
            return (Criteria) this;
        }

        public Criteria andRelationidNotEqualTo(String value) {
            addCriterion("relationId <>", value, "relationid");
            return (Criteria) this;
        }

        public Criteria andRelationidGreaterThan(String value) {
            addCriterion("relationId >", value, "relationid");
            return (Criteria) this;
        }

        public Criteria andRelationidGreaterThanOrEqualTo(String value) {
            addCriterion("relationId >=", value, "relationid");
            return (Criteria) this;
        }

        public Criteria andRelationidLessThan(String value) {
            addCriterion("relationId <", value, "relationid");
            return (Criteria) this;
        }

        public Criteria andRelationidLessThanOrEqualTo(String value) {
            addCriterion("relationId <=", value, "relationid");
            return (Criteria) this;
        }

        public Criteria andRelationidLike(String value) {
            addCriterion("relationId like", value, "relationid");
            return (Criteria) this;
        }

        public Criteria andRelationidNotLike(String value) {
            addCriterion("relationId not like", value, "relationid");
            return (Criteria) this;
        }

        public Criteria andRelationidIn(List<String> values) {
            addCriterion("relationId in", values, "relationid");
            return (Criteria) this;
        }

        public Criteria andRelationidNotIn(List<String> values) {
            addCriterion("relationId not in", values, "relationid");
            return (Criteria) this;
        }

        public Criteria andRelationidBetween(String value1, String value2) {
            addCriterion("relationId between", value1, value2, "relationid");
            return (Criteria) this;
        }

        public Criteria andRelationidNotBetween(String value1, String value2) {
            addCriterion("relationId not between", value1, value2, "relationid");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Byte value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Byte value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Byte value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Byte value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Byte value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Byte value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Byte> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Byte> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Byte value1, Byte value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Byte value1, Byte value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andRtypeIsNull() {
            addCriterion("rtype is null");
            return (Criteria) this;
        }

        public Criteria andRtypeIsNotNull() {
            addCriterion("rtype is not null");
            return (Criteria) this;
        }

        public Criteria andRtypeEqualTo(Byte value) {
            addCriterion("rtype =", value, "rtype");
            return (Criteria) this;
        }

        public Criteria andRtypeNotEqualTo(Byte value) {
            addCriterion("rtype <>", value, "rtype");
            return (Criteria) this;
        }

        public Criteria andRtypeGreaterThan(Byte value) {
            addCriterion("rtype >", value, "rtype");
            return (Criteria) this;
        }

        public Criteria andRtypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("rtype >=", value, "rtype");
            return (Criteria) this;
        }

        public Criteria andRtypeLessThan(Byte value) {
            addCriterion("rtype <", value, "rtype");
            return (Criteria) this;
        }

        public Criteria andRtypeLessThanOrEqualTo(Byte value) {
            addCriterion("rtype <=", value, "rtype");
            return (Criteria) this;
        }

        public Criteria andRtypeIn(List<Byte> values) {
            addCriterion("rtype in", values, "rtype");
            return (Criteria) this;
        }

        public Criteria andRtypeNotIn(List<Byte> values) {
            addCriterion("rtype not in", values, "rtype");
            return (Criteria) this;
        }

        public Criteria andRtypeBetween(Byte value1, Byte value2) {
            addCriterion("rtype between", value1, value2, "rtype");
            return (Criteria) this;
        }

        public Criteria andRtypeNotBetween(Byte value1, Byte value2) {
            addCriterion("rtype not between", value1, value2, "rtype");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table js_ebook_template
     *
     * @mbggenerated do_not_delete_during_merge Tue Aug 01 14:16:04 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table js_ebook_template
     *
     * @mbggenerated Tue Aug 01 14:16:04 CST 2017
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