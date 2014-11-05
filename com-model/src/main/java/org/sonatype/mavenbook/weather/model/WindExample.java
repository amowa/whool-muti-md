package org.sonatype.mavenbook.weather.model;

import java.util.ArrayList;
import java.util.List;

public class WindExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WindExample() {
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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andChillIsNull() {
            addCriterion("CHILL is null");
            return (Criteria) this;
        }

        public Criteria andChillIsNotNull() {
            addCriterion("CHILL is not null");
            return (Criteria) this;
        }

        public Criteria andChillEqualTo(String value) {
            addCriterion("CHILL =", value, "chill");
            return (Criteria) this;
        }

        public Criteria andChillNotEqualTo(String value) {
            addCriterion("CHILL <>", value, "chill");
            return (Criteria) this;
        }

        public Criteria andChillGreaterThan(String value) {
            addCriterion("CHILL >", value, "chill");
            return (Criteria) this;
        }

        public Criteria andChillGreaterThanOrEqualTo(String value) {
            addCriterion("CHILL >=", value, "chill");
            return (Criteria) this;
        }

        public Criteria andChillLessThan(String value) {
            addCriterion("CHILL <", value, "chill");
            return (Criteria) this;
        }

        public Criteria andChillLessThanOrEqualTo(String value) {
            addCriterion("CHILL <=", value, "chill");
            return (Criteria) this;
        }

        public Criteria andChillLike(String value) {
            addCriterion("CHILL like", value, "chill");
            return (Criteria) this;
        }

        public Criteria andChillNotLike(String value) {
            addCriterion("CHILL not like", value, "chill");
            return (Criteria) this;
        }

        public Criteria andChillIn(List<String> values) {
            addCriterion("CHILL in", values, "chill");
            return (Criteria) this;
        }

        public Criteria andChillNotIn(List<String> values) {
            addCriterion("CHILL not in", values, "chill");
            return (Criteria) this;
        }

        public Criteria andChillBetween(String value1, String value2) {
            addCriterion("CHILL between", value1, value2, "chill");
            return (Criteria) this;
        }

        public Criteria andChillNotBetween(String value1, String value2) {
            addCriterion("CHILL not between", value1, value2, "chill");
            return (Criteria) this;
        }

        public Criteria andDirectionIsNull() {
            addCriterion("DIRECTION is null");
            return (Criteria) this;
        }

        public Criteria andDirectionIsNotNull() {
            addCriterion("DIRECTION is not null");
            return (Criteria) this;
        }

        public Criteria andDirectionEqualTo(String value) {
            addCriterion("DIRECTION =", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotEqualTo(String value) {
            addCriterion("DIRECTION <>", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionGreaterThan(String value) {
            addCriterion("DIRECTION >", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionGreaterThanOrEqualTo(String value) {
            addCriterion("DIRECTION >=", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionLessThan(String value) {
            addCriterion("DIRECTION <", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionLessThanOrEqualTo(String value) {
            addCriterion("DIRECTION <=", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionLike(String value) {
            addCriterion("DIRECTION like", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotLike(String value) {
            addCriterion("DIRECTION not like", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionIn(List<String> values) {
            addCriterion("DIRECTION in", values, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotIn(List<String> values) {
            addCriterion("DIRECTION not in", values, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionBetween(String value1, String value2) {
            addCriterion("DIRECTION between", value1, value2, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotBetween(String value1, String value2) {
            addCriterion("DIRECTION not between", value1, value2, "direction");
            return (Criteria) this;
        }

        public Criteria andSpeedIsNull() {
            addCriterion("SPEED is null");
            return (Criteria) this;
        }

        public Criteria andSpeedIsNotNull() {
            addCriterion("SPEED is not null");
            return (Criteria) this;
        }

        public Criteria andSpeedEqualTo(String value) {
            addCriterion("SPEED =", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedNotEqualTo(String value) {
            addCriterion("SPEED <>", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedGreaterThan(String value) {
            addCriterion("SPEED >", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedGreaterThanOrEqualTo(String value) {
            addCriterion("SPEED >=", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedLessThan(String value) {
            addCriterion("SPEED <", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedLessThanOrEqualTo(String value) {
            addCriterion("SPEED <=", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedLike(String value) {
            addCriterion("SPEED like", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedNotLike(String value) {
            addCriterion("SPEED not like", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedIn(List<String> values) {
            addCriterion("SPEED in", values, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedNotIn(List<String> values) {
            addCriterion("SPEED not in", values, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedBetween(String value1, String value2) {
            addCriterion("SPEED between", value1, value2, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedNotBetween(String value1, String value2) {
            addCriterion("SPEED not between", value1, value2, "speed");
            return (Criteria) this;
        }

        public Criteria andWeatherIdIsNull() {
            addCriterion("WEATHER_ID is null");
            return (Criteria) this;
        }

        public Criteria andWeatherIdIsNotNull() {
            addCriterion("WEATHER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andWeatherIdEqualTo(Integer value) {
            addCriterion("WEATHER_ID =", value, "weatherId");
            return (Criteria) this;
        }

        public Criteria andWeatherIdNotEqualTo(Integer value) {
            addCriterion("WEATHER_ID <>", value, "weatherId");
            return (Criteria) this;
        }

        public Criteria andWeatherIdGreaterThan(Integer value) {
            addCriterion("WEATHER_ID >", value, "weatherId");
            return (Criteria) this;
        }

        public Criteria andWeatherIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("WEATHER_ID >=", value, "weatherId");
            return (Criteria) this;
        }

        public Criteria andWeatherIdLessThan(Integer value) {
            addCriterion("WEATHER_ID <", value, "weatherId");
            return (Criteria) this;
        }

        public Criteria andWeatherIdLessThanOrEqualTo(Integer value) {
            addCriterion("WEATHER_ID <=", value, "weatherId");
            return (Criteria) this;
        }

        public Criteria andWeatherIdIn(List<Integer> values) {
            addCriterion("WEATHER_ID in", values, "weatherId");
            return (Criteria) this;
        }

        public Criteria andWeatherIdNotIn(List<Integer> values) {
            addCriterion("WEATHER_ID not in", values, "weatherId");
            return (Criteria) this;
        }

        public Criteria andWeatherIdBetween(Integer value1, Integer value2) {
            addCriterion("WEATHER_ID between", value1, value2, "weatherId");
            return (Criteria) this;
        }

        public Criteria andWeatherIdNotBetween(Integer value1, Integer value2) {
            addCriterion("WEATHER_ID not between", value1, value2, "weatherId");
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