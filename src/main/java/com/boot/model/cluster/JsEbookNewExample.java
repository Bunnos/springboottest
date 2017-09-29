package com.boot.model.cluster;

import java.util.ArrayList;
import java.util.List;

public class JsEbookNewExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table js_ebook_new
     *
     * @mbggenerated Fri Sep 08 09:15:39 CST 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table js_ebook_new
     *
     * @mbggenerated Fri Sep 08 09:15:39 CST 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table js_ebook_new
     *
     * @mbggenerated Fri Sep 08 09:15:39 CST 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_ebook_new
     *
     * @mbggenerated Fri Sep 08 09:15:39 CST 2017
     */
    public JsEbookNewExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_ebook_new
     *
     * @mbggenerated Fri Sep 08 09:15:39 CST 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_ebook_new
     *
     * @mbggenerated Fri Sep 08 09:15:39 CST 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_ebook_new
     *
     * @mbggenerated Fri Sep 08 09:15:39 CST 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_ebook_new
     *
     * @mbggenerated Fri Sep 08 09:15:39 CST 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_ebook_new
     *
     * @mbggenerated Fri Sep 08 09:15:39 CST 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_ebook_new
     *
     * @mbggenerated Fri Sep 08 09:15:39 CST 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_ebook_new
     *
     * @mbggenerated Fri Sep 08 09:15:39 CST 2017
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_ebook_new
     *
     * @mbggenerated Fri Sep 08 09:15:39 CST 2017
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
     * This method corresponds to the database table js_ebook_new
     *
     * @mbggenerated Fri Sep 08 09:15:39 CST 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_ebook_new
     *
     * @mbggenerated Fri Sep 08 09:15:39 CST 2017
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table js_ebook_new
     *
     * @mbggenerated Fri Sep 08 09:15:39 CST 2017
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

        public Criteria andTemplateidIsNull() {
            addCriterion("templateId is null");
            return (Criteria) this;
        }

        public Criteria andTemplateidIsNotNull() {
            addCriterion("templateId is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateidEqualTo(String value) {
            addCriterion("templateId =", value, "templateid");
            return (Criteria) this;
        }

        public Criteria andTemplateidNotEqualTo(String value) {
            addCriterion("templateId <>", value, "templateid");
            return (Criteria) this;
        }

        public Criteria andTemplateidGreaterThan(String value) {
            addCriterion("templateId >", value, "templateid");
            return (Criteria) this;
        }

        public Criteria andTemplateidGreaterThanOrEqualTo(String value) {
            addCriterion("templateId >=", value, "templateid");
            return (Criteria) this;
        }

        public Criteria andTemplateidLessThan(String value) {
            addCriterion("templateId <", value, "templateid");
            return (Criteria) this;
        }

        public Criteria andTemplateidLessThanOrEqualTo(String value) {
            addCriterion("templateId <=", value, "templateid");
            return (Criteria) this;
        }

        public Criteria andTemplateidLike(String value) {
            addCriterion("templateId like", value, "templateid");
            return (Criteria) this;
        }

        public Criteria andTemplateidNotLike(String value) {
            addCriterion("templateId not like", value, "templateid");
            return (Criteria) this;
        }

        public Criteria andTemplateidIn(List<String> values) {
            addCriterion("templateId in", values, "templateid");
            return (Criteria) this;
        }

        public Criteria andTemplateidNotIn(List<String> values) {
            addCriterion("templateId not in", values, "templateid");
            return (Criteria) this;
        }

        public Criteria andTemplateidBetween(String value1, String value2) {
            addCriterion("templateId between", value1, value2, "templateid");
            return (Criteria) this;
        }

        public Criteria andTemplateidNotBetween(String value1, String value2) {
            addCriterion("templateId not between", value1, value2, "templateid");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andCategoriescodeIsNull() {
            addCriterion("categoriesCode is null");
            return (Criteria) this;
        }

        public Criteria andCategoriescodeIsNotNull() {
            addCriterion("categoriesCode is not null");
            return (Criteria) this;
        }

        public Criteria andCategoriescodeEqualTo(String value) {
            addCriterion("categoriesCode =", value, "categoriescode");
            return (Criteria) this;
        }

        public Criteria andCategoriescodeNotEqualTo(String value) {
            addCriterion("categoriesCode <>", value, "categoriescode");
            return (Criteria) this;
        }

        public Criteria andCategoriescodeGreaterThan(String value) {
            addCriterion("categoriesCode >", value, "categoriescode");
            return (Criteria) this;
        }

        public Criteria andCategoriescodeGreaterThanOrEqualTo(String value) {
            addCriterion("categoriesCode >=", value, "categoriescode");
            return (Criteria) this;
        }

        public Criteria andCategoriescodeLessThan(String value) {
            addCriterion("categoriesCode <", value, "categoriescode");
            return (Criteria) this;
        }

        public Criteria andCategoriescodeLessThanOrEqualTo(String value) {
            addCriterion("categoriesCode <=", value, "categoriescode");
            return (Criteria) this;
        }

        public Criteria andCategoriescodeLike(String value) {
            addCriterion("categoriesCode like", value, "categoriescode");
            return (Criteria) this;
        }

        public Criteria andCategoriescodeNotLike(String value) {
            addCriterion("categoriesCode not like", value, "categoriescode");
            return (Criteria) this;
        }

        public Criteria andCategoriescodeIn(List<String> values) {
            addCriterion("categoriesCode in", values, "categoriescode");
            return (Criteria) this;
        }

        public Criteria andCategoriescodeNotIn(List<String> values) {
            addCriterion("categoriesCode not in", values, "categoriescode");
            return (Criteria) this;
        }

        public Criteria andCategoriescodeBetween(String value1, String value2) {
            addCriterion("categoriesCode between", value1, value2, "categoriescode");
            return (Criteria) this;
        }

        public Criteria andCategoriescodeNotBetween(String value1, String value2) {
            addCriterion("categoriesCode not between", value1, value2, "categoriescode");
            return (Criteria) this;
        }

        public Criteria andPrefixpathIsNull() {
            addCriterion("prefixPath is null");
            return (Criteria) this;
        }

        public Criteria andPrefixpathIsNotNull() {
            addCriterion("prefixPath is not null");
            return (Criteria) this;
        }

        public Criteria andPrefixpathEqualTo(String value) {
            addCriterion("prefixPath =", value, "prefixpath");
            return (Criteria) this;
        }

        public Criteria andPrefixpathNotEqualTo(String value) {
            addCriterion("prefixPath <>", value, "prefixpath");
            return (Criteria) this;
        }

        public Criteria andPrefixpathGreaterThan(String value) {
            addCriterion("prefixPath >", value, "prefixpath");
            return (Criteria) this;
        }

        public Criteria andPrefixpathGreaterThanOrEqualTo(String value) {
            addCriterion("prefixPath >=", value, "prefixpath");
            return (Criteria) this;
        }

        public Criteria andPrefixpathLessThan(String value) {
            addCriterion("prefixPath <", value, "prefixpath");
            return (Criteria) this;
        }

        public Criteria andPrefixpathLessThanOrEqualTo(String value) {
            addCriterion("prefixPath <=", value, "prefixpath");
            return (Criteria) this;
        }

        public Criteria andPrefixpathLike(String value) {
            addCriterion("prefixPath like", value, "prefixpath");
            return (Criteria) this;
        }

        public Criteria andPrefixpathNotLike(String value) {
            addCriterion("prefixPath not like", value, "prefixpath");
            return (Criteria) this;
        }

        public Criteria andPrefixpathIn(List<String> values) {
            addCriterion("prefixPath in", values, "prefixpath");
            return (Criteria) this;
        }

        public Criteria andPrefixpathNotIn(List<String> values) {
            addCriterion("prefixPath not in", values, "prefixpath");
            return (Criteria) this;
        }

        public Criteria andPrefixpathBetween(String value1, String value2) {
            addCriterion("prefixPath between", value1, value2, "prefixpath");
            return (Criteria) this;
        }

        public Criteria andPrefixpathNotBetween(String value1, String value2) {
            addCriterion("prefixPath not between", value1, value2, "prefixpath");
            return (Criteria) this;
        }

        public Criteria andIndexnumIsNull() {
            addCriterion("indexNum is null");
            return (Criteria) this;
        }

        public Criteria andIndexnumIsNotNull() {
            addCriterion("indexNum is not null");
            return (Criteria) this;
        }

        public Criteria andIndexnumEqualTo(String value) {
            addCriterion("indexNum =", value, "indexnum");
            return (Criteria) this;
        }

        public Criteria andIndexnumNotEqualTo(String value) {
            addCriterion("indexNum <>", value, "indexnum");
            return (Criteria) this;
        }

        public Criteria andIndexnumGreaterThan(String value) {
            addCriterion("indexNum >", value, "indexnum");
            return (Criteria) this;
        }

        public Criteria andIndexnumGreaterThanOrEqualTo(String value) {
            addCriterion("indexNum >=", value, "indexnum");
            return (Criteria) this;
        }

        public Criteria andIndexnumLessThan(String value) {
            addCriterion("indexNum <", value, "indexnum");
            return (Criteria) this;
        }

        public Criteria andIndexnumLessThanOrEqualTo(String value) {
            addCriterion("indexNum <=", value, "indexnum");
            return (Criteria) this;
        }

        public Criteria andIndexnumLike(String value) {
            addCriterion("indexNum like", value, "indexnum");
            return (Criteria) this;
        }

        public Criteria andIndexnumNotLike(String value) {
            addCriterion("indexNum not like", value, "indexnum");
            return (Criteria) this;
        }

        public Criteria andIndexnumIn(List<String> values) {
            addCriterion("indexNum in", values, "indexnum");
            return (Criteria) this;
        }

        public Criteria andIndexnumNotIn(List<String> values) {
            addCriterion("indexNum not in", values, "indexnum");
            return (Criteria) this;
        }

        public Criteria andIndexnumBetween(String value1, String value2) {
            addCriterion("indexNum between", value1, value2, "indexnum");
            return (Criteria) this;
        }

        public Criteria andIndexnumNotBetween(String value1, String value2) {
            addCriterion("indexNum not between", value1, value2, "indexnum");
            return (Criteria) this;
        }

        public Criteria andTotalnumIsNull() {
            addCriterion("totalNum is null");
            return (Criteria) this;
        }

        public Criteria andTotalnumIsNotNull() {
            addCriterion("totalNum is not null");
            return (Criteria) this;
        }

        public Criteria andTotalnumEqualTo(Integer value) {
            addCriterion("totalNum =", value, "totalnum");
            return (Criteria) this;
        }

        public Criteria andTotalnumNotEqualTo(Integer value) {
            addCriterion("totalNum <>", value, "totalnum");
            return (Criteria) this;
        }

        public Criteria andTotalnumGreaterThan(Integer value) {
            addCriterion("totalNum >", value, "totalnum");
            return (Criteria) this;
        }

        public Criteria andTotalnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("totalNum >=", value, "totalnum");
            return (Criteria) this;
        }

        public Criteria andTotalnumLessThan(Integer value) {
            addCriterion("totalNum <", value, "totalnum");
            return (Criteria) this;
        }

        public Criteria andTotalnumLessThanOrEqualTo(Integer value) {
            addCriterion("totalNum <=", value, "totalnum");
            return (Criteria) this;
        }

        public Criteria andTotalnumIn(List<Integer> values) {
            addCriterion("totalNum in", values, "totalnum");
            return (Criteria) this;
        }

        public Criteria andTotalnumNotIn(List<Integer> values) {
            addCriterion("totalNum not in", values, "totalnum");
            return (Criteria) this;
        }

        public Criteria andTotalnumBetween(Integer value1, Integer value2) {
            addCriterion("totalNum between", value1, value2, "totalnum");
            return (Criteria) this;
        }

        public Criteria andTotalnumNotBetween(Integer value1, Integer value2) {
            addCriterion("totalNum not between", value1, value2, "totalnum");
            return (Criteria) this;
        }

        public Criteria andOriginIsNull() {
            addCriterion("origin is null");
            return (Criteria) this;
        }

        public Criteria andOriginIsNotNull() {
            addCriterion("origin is not null");
            return (Criteria) this;
        }

        public Criteria andOriginEqualTo(String value) {
            addCriterion("origin =", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginNotEqualTo(String value) {
            addCriterion("origin <>", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginGreaterThan(String value) {
            addCriterion("origin >", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginGreaterThanOrEqualTo(String value) {
            addCriterion("origin >=", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginLessThan(String value) {
            addCriterion("origin <", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginLessThanOrEqualTo(String value) {
            addCriterion("origin <=", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginLike(String value) {
            addCriterion("origin like", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginNotLike(String value) {
            addCriterion("origin not like", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginIn(List<String> values) {
            addCriterion("origin in", values, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginNotIn(List<String> values) {
            addCriterion("origin not in", values, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginBetween(String value1, String value2) {
            addCriterion("origin between", value1, value2, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginNotBetween(String value1, String value2) {
            addCriterion("origin not between", value1, value2, "origin");
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

        public Criteria andRtypeEqualTo(Integer value) {
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
     * This class corresponds to the database table js_ebook_new
     *
     * @mbggenerated do_not_delete_during_merge Fri Sep 08 09:15:39 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table js_ebook_new
     *
     * @mbggenerated Fri Sep 08 09:15:39 CST 2017
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