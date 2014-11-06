package org.sonatype.mavenbook.weather.model;

import java.util.ArrayList;
import java.util.List;

public class SearchCriteria {
    protected String orderByClause;

    protected boolean distinct;
    
    protected List<Criteria> oredCriteria; /*用 OR 连接的条件*/
    protected List<Criteria> andedCriteria; /*用 AND 连接的条件*/

    public SearchCriteria() {
        oredCriteria = new ArrayList<Criteria>();
        andedCriteria = new ArrayList<Criteria>();//wu add
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
    
    /*wu add*/
    public Criteria and() {
    	Criteria criteria = createCriteriaInternal();
    	andedCriteria.add(criteria);
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
        andedCriteria.clear(); //wu add
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria IsNull(String filedName) {
            addCriterion(filedName +" is null");
            return (Criteria) this;
        }

        public Criteria IsNotNull(String filedName) {
            addCriterion(filedName +" is not null");
            return (Criteria) this;
        }

        public Criteria EqualTo(String filedName, String value) {
            addCriterion(filedName +" =", value, filedName.toLowerCase());
            return (Criteria) this;
        }

        public Criteria NotEqualTo(String filedName, String value) {
            addCriterion(filedName +" <>", value, filedName.toLowerCase());
            return (Criteria) this;
        }

        public Criteria GreaterThan(String filedName, String value) {
            addCriterion(filedName +" >", value, filedName.toLowerCase());
            return (Criteria) this;
        }

        public Criteria GreaterThanOrEqualTo(String filedName, String value) {
            addCriterion(filedName +" >=", value, filedName.toLowerCase());
            return (Criteria) this;
        }

        public Criteria LessThan(String filedName, String value) {
            addCriterion(filedName +" <", value, filedName.toLowerCase());
            return (Criteria) this;
        }

        public Criteria LessThanOrEqualTo(String filedName, String value) {
            addCriterion(filedName +" <=", value, filedName.toLowerCase());
            return (Criteria) this;
        }

        public Criteria Like(String filedName, String value) {
            addCriterion(filedName +" like", value, filedName.toLowerCase());
            return (Criteria) this;
        }

        public Criteria NotLike(String filedName, String value) {
            addCriterion(filedName +" not like", value, filedName.toLowerCase());
            return (Criteria) this;
        }

        public Criteria In(String filedName, List<String> values) {
            addCriterion(filedName +" in", values, filedName.toLowerCase());
            return (Criteria) this;
        }

        public Criteria NotIn(String filedName, List<String> values) {
            addCriterion(filedName +" not in", values, filedName.toLowerCase());
            return (Criteria) this;
        }

        public Criteria Between(String filedName, String value1, String value2) {
            addCriterion(filedName +" between", value1, value2, filedName.toLowerCase());
            return (Criteria) this;
        }

        public Criteria NotBetween(String filedName, String value1, String value2) {
            addCriterion(filedName +" not between", value1, value2, filedName.toLowerCase());
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