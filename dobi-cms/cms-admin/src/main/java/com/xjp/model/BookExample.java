package com.xjp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public BookExample() {
        oredCriteria = new ArrayList<Criteria>();
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

    protected abstract static class GeneratedCriteria implements Serializable {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNull() {
            addCriterion("author is null");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNotNull() {
            addCriterion("author is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorEqualTo(String value) {
            addCriterion("author =", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotEqualTo(String value) {
            addCriterion("author <>", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThan(String value) {
            addCriterion("author >", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("author >=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThan(String value) {
            addCriterion("author <", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThanOrEqualTo(String value) {
            addCriterion("author <=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLike(String value) {
            addCriterion("author like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotLike(String value) {
            addCriterion("author not like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorIn(List<String> values) {
            addCriterion("author in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotIn(List<String> values) {
            addCriterion("author not in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorBetween(String value1, String value2) {
            addCriterion("author between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotBetween(String value1, String value2) {
            addCriterion("author not between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andPubdateIsNull() {
            addCriterion("pubdate is null");
            return (Criteria) this;
        }

        public Criteria andPubdateIsNotNull() {
            addCriterion("pubdate is not null");
            return (Criteria) this;
        }

        public Criteria andPubdateEqualTo(Date value) {
            addCriterion("pubdate =", value, "pubdate");
            return (Criteria) this;
        }

        public Criteria andPubdateNotEqualTo(Date value) {
            addCriterion("pubdate <>", value, "pubdate");
            return (Criteria) this;
        }

        public Criteria andPubdateGreaterThan(Date value) {
            addCriterion("pubdate >", value, "pubdate");
            return (Criteria) this;
        }

        public Criteria andPubdateGreaterThanOrEqualTo(Date value) {
            addCriterion("pubdate >=", value, "pubdate");
            return (Criteria) this;
        }

        public Criteria andPubdateLessThan(Date value) {
            addCriterion("pubdate <", value, "pubdate");
            return (Criteria) this;
        }

        public Criteria andPubdateLessThanOrEqualTo(Date value) {
            addCriterion("pubdate <=", value, "pubdate");
            return (Criteria) this;
        }

        public Criteria andPubdateIn(List<Date> values) {
            addCriterion("pubdate in", values, "pubdate");
            return (Criteria) this;
        }

        public Criteria andPubdateNotIn(List<Date> values) {
            addCriterion("pubdate not in", values, "pubdate");
            return (Criteria) this;
        }

        public Criteria andPubdateBetween(Date value1, Date value2) {
            addCriterion("pubdate between", value1, value2, "pubdate");
            return (Criteria) this;
        }

        public Criteria andPubdateNotBetween(Date value1, Date value2) {
            addCriterion("pubdate not between", value1, value2, "pubdate");
            return (Criteria) this;
        }

        public Criteria andDownloadurlIsNull() {
            addCriterion("downloadurl is null");
            return (Criteria) this;
        }

        public Criteria andDownloadurlIsNotNull() {
            addCriterion("downloadurl is not null");
            return (Criteria) this;
        }

        public Criteria andDownloadurlEqualTo(String value) {
            addCriterion("downloadurl =", value, "downloadurl");
            return (Criteria) this;
        }

        public Criteria andDownloadurlNotEqualTo(String value) {
            addCriterion("downloadurl <>", value, "downloadurl");
            return (Criteria) this;
        }

        public Criteria andDownloadurlGreaterThan(String value) {
            addCriterion("downloadurl >", value, "downloadurl");
            return (Criteria) this;
        }

        public Criteria andDownloadurlGreaterThanOrEqualTo(String value) {
            addCriterion("downloadurl >=", value, "downloadurl");
            return (Criteria) this;
        }

        public Criteria andDownloadurlLessThan(String value) {
            addCriterion("downloadurl <", value, "downloadurl");
            return (Criteria) this;
        }

        public Criteria andDownloadurlLessThanOrEqualTo(String value) {
            addCriterion("downloadurl <=", value, "downloadurl");
            return (Criteria) this;
        }

        public Criteria andDownloadurlLike(String value) {
            addCriterion("downloadurl like", value, "downloadurl");
            return (Criteria) this;
        }

        public Criteria andDownloadurlNotLike(String value) {
            addCriterion("downloadurl not like", value, "downloadurl");
            return (Criteria) this;
        }

        public Criteria andDownloadurlIn(List<String> values) {
            addCriterion("downloadurl in", values, "downloadurl");
            return (Criteria) this;
        }

        public Criteria andDownloadurlNotIn(List<String> values) {
            addCriterion("downloadurl not in", values, "downloadurl");
            return (Criteria) this;
        }

        public Criteria andDownloadurlBetween(String value1, String value2) {
            addCriterion("downloadurl between", value1, value2, "downloadurl");
            return (Criteria) this;
        }

        public Criteria andDownloadurlNotBetween(String value1, String value2) {
            addCriterion("downloadurl not between", value1, value2, "downloadurl");
            return (Criteria) this;
        }

        public Criteria andCoverIsNull() {
            addCriterion("cover is null");
            return (Criteria) this;
        }

        public Criteria andCoverIsNotNull() {
            addCriterion("cover is not null");
            return (Criteria) this;
        }

        public Criteria andCoverEqualTo(String value) {
            addCriterion("cover =", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverNotEqualTo(String value) {
            addCriterion("cover <>", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverGreaterThan(String value) {
            addCriterion("cover >", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverGreaterThanOrEqualTo(String value) {
            addCriterion("cover >=", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverLessThan(String value) {
            addCriterion("cover <", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverLessThanOrEqualTo(String value) {
            addCriterion("cover <=", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverLike(String value) {
            addCriterion("cover like", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverNotLike(String value) {
            addCriterion("cover not like", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverIn(List<String> values) {
            addCriterion("cover in", values, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverNotIn(List<String> values) {
            addCriterion("cover not in", values, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverBetween(String value1, String value2) {
            addCriterion("cover between", value1, value2, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverNotBetween(String value1, String value2) {
            addCriterion("cover not between", value1, value2, "cover");
            return (Criteria) this;
        }

        public Criteria andIntroIsNull() {
            addCriterion("intro is null");
            return (Criteria) this;
        }

        public Criteria andIntroIsNotNull() {
            addCriterion("intro is not null");
            return (Criteria) this;
        }

        public Criteria andIntroEqualTo(String value) {
            addCriterion("intro =", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroNotEqualTo(String value) {
            addCriterion("intro <>", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroGreaterThan(String value) {
            addCriterion("intro >", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroGreaterThanOrEqualTo(String value) {
            addCriterion("intro >=", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroLessThan(String value) {
            addCriterion("intro <", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroLessThanOrEqualTo(String value) {
            addCriterion("intro <=", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroLike(String value) {
            addCriterion("intro like", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroNotLike(String value) {
            addCriterion("intro not like", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroIn(List<String> values) {
            addCriterion("intro in", values, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroNotIn(List<String> values) {
            addCriterion("intro not in", values, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroBetween(String value1, String value2) {
            addCriterion("intro between", value1, value2, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroNotBetween(String value1, String value2) {
            addCriterion("intro not between", value1, value2, "intro");
            return (Criteria) this;
        }

        public Criteria andAmazonIsNull() {
            addCriterion("amazon is null");
            return (Criteria) this;
        }

        public Criteria andAmazonIsNotNull() {
            addCriterion("amazon is not null");
            return (Criteria) this;
        }

        public Criteria andAmazonEqualTo(String value) {
            addCriterion("amazon =", value, "amazon");
            return (Criteria) this;
        }

        public Criteria andAmazonNotEqualTo(String value) {
            addCriterion("amazon <>", value, "amazon");
            return (Criteria) this;
        }

        public Criteria andAmazonGreaterThan(String value) {
            addCriterion("amazon >", value, "amazon");
            return (Criteria) this;
        }

        public Criteria andAmazonGreaterThanOrEqualTo(String value) {
            addCriterion("amazon >=", value, "amazon");
            return (Criteria) this;
        }

        public Criteria andAmazonLessThan(String value) {
            addCriterion("amazon <", value, "amazon");
            return (Criteria) this;
        }

        public Criteria andAmazonLessThanOrEqualTo(String value) {
            addCriterion("amazon <=", value, "amazon");
            return (Criteria) this;
        }

        public Criteria andAmazonLike(String value) {
            addCriterion("amazon like", value, "amazon");
            return (Criteria) this;
        }

        public Criteria andAmazonNotLike(String value) {
            addCriterion("amazon not like", value, "amazon");
            return (Criteria) this;
        }

        public Criteria andAmazonIn(List<String> values) {
            addCriterion("amazon in", values, "amazon");
            return (Criteria) this;
        }

        public Criteria andAmazonNotIn(List<String> values) {
            addCriterion("amazon not in", values, "amazon");
            return (Criteria) this;
        }

        public Criteria andAmazonBetween(String value1, String value2) {
            addCriterion("amazon between", value1, value2, "amazon");
            return (Criteria) this;
        }

        public Criteria andAmazonNotBetween(String value1, String value2) {
            addCriterion("amazon not between", value1, value2, "amazon");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andCreateIsNull() {
            addCriterion("create is null");
            return (Criteria) this;
        }

        public Criteria andCreateIsNotNull() {
            addCriterion("create is not null");
            return (Criteria) this;
        }

        public Criteria andCreateEqualTo(Date value) {
            addCriterion("create =", value, "create");
            return (Criteria) this;
        }

        public Criteria andCreateNotEqualTo(Date value) {
            addCriterion("create <>", value, "create");
            return (Criteria) this;
        }

        public Criteria andCreateGreaterThan(Date value) {
            addCriterion("create >", value, "create");
            return (Criteria) this;
        }

        public Criteria andCreateGreaterThanOrEqualTo(Date value) {
            addCriterion("create >=", value, "create");
            return (Criteria) this;
        }

        public Criteria andCreateLessThan(Date value) {
            addCriterion("create <", value, "create");
            return (Criteria) this;
        }

        public Criteria andCreateLessThanOrEqualTo(Date value) {
            addCriterion("create <=", value, "create");
            return (Criteria) this;
        }

        public Criteria andCreateIn(List<Date> values) {
            addCriterion("create in", values, "create");
            return (Criteria) this;
        }

        public Criteria andCreateNotIn(List<Date> values) {
            addCriterion("create not in", values, "create");
            return (Criteria) this;
        }

        public Criteria andCreateBetween(Date value1, Date value2) {
            addCriterion("create between", value1, value2, "create");
            return (Criteria) this;
        }

        public Criteria andCreateNotBetween(Date value1, Date value2) {
            addCriterion("create not between", value1, value2, "create");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion implements Serializable {
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