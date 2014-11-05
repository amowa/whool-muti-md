package org.sonatype.mavenbook.weather.model;

import java.util.ArrayList;
import java.util.List;

public class AtmosphereExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AtmosphereExample() {
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

        public Criteria andHumidityIsNull() {
            addCriterion("HUMIDITY is null");
            return (Criteria) this;
        }

        public Criteria andHumidityIsNotNull() {
            addCriterion("HUMIDITY is not null");
            return (Criteria) this;
        }

        public Criteria andHumidityEqualTo(String value) {
            addCriterion("HUMIDITY =", value, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityNotEqualTo(String value) {
            addCriterion("HUMIDITY <>", value, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityGreaterThan(String value) {
            addCriterion("HUMIDITY >", value, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityGreaterThanOrEqualTo(String value) {
            addCriterion("HUMIDITY >=", value, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityLessThan(String value) {
            addCriterion("HUMIDITY <", value, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityLessThanOrEqualTo(String value) {
            addCriterion("HUMIDITY <=", value, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityLike(String value) {
            addCriterion("HUMIDITY like", value, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityNotLike(String value) {
            addCriterion("HUMIDITY not like", value, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityIn(List<String> values) {
            addCriterion("HUMIDITY in", values, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityNotIn(List<String> values) {
            addCriterion("HUMIDITY not in", values, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityBetween(String value1, String value2) {
            addCriterion("HUMIDITY between", value1, value2, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityNotBetween(String value1, String value2) {
            addCriterion("HUMIDITY not between", value1, value2, "humidity");
            return (Criteria) this;
        }

        public Criteria andPressureIsNull() {
            addCriterion("PRESSURE is null");
            return (Criteria) this;
        }

        public Criteria andPressureIsNotNull() {
            addCriterion("PRESSURE is not null");
            return (Criteria) this;
        }

        public Criteria andPressureEqualTo(String value) {
            addCriterion("PRESSURE =", value, "pressure");
            return (Criteria) this;
        }

        public Criteria andPressureNotEqualTo(String value) {
            addCriterion("PRESSURE <>", value, "pressure");
            return (Criteria) this;
        }

        public Criteria andPressureGreaterThan(String value) {
            addCriterion("PRESSURE >", value, "pressure");
            return (Criteria) this;
        }

        public Criteria andPressureGreaterThanOrEqualTo(String value) {
            addCriterion("PRESSURE >=", value, "pressure");
            return (Criteria) this;
        }

        public Criteria andPressureLessThan(String value) {
            addCriterion("PRESSURE <", value, "pressure");
            return (Criteria) this;
        }

        public Criteria andPressureLessThanOrEqualTo(String value) {
            addCriterion("PRESSURE <=", value, "pressure");
            return (Criteria) this;
        }

        public Criteria andPressureLike(String value) {
            addCriterion("PRESSURE like", value, "pressure");
            return (Criteria) this;
        }

        public Criteria andPressureNotLike(String value) {
            addCriterion("PRESSURE not like", value, "pressure");
            return (Criteria) this;
        }

        public Criteria andPressureIn(List<String> values) {
            addCriterion("PRESSURE in", values, "pressure");
            return (Criteria) this;
        }

        public Criteria andPressureNotIn(List<String> values) {
            addCriterion("PRESSURE not in", values, "pressure");
            return (Criteria) this;
        }

        public Criteria andPressureBetween(String value1, String value2) {
            addCriterion("PRESSURE between", value1, value2, "pressure");
            return (Criteria) this;
        }

        public Criteria andPressureNotBetween(String value1, String value2) {
            addCriterion("PRESSURE not between", value1, value2, "pressure");
            return (Criteria) this;
        }

        public Criteria andRisingIsNull() {
            addCriterion("RISING is null");
            return (Criteria) this;
        }

        public Criteria andRisingIsNotNull() {
            addCriterion("RISING is not null");
            return (Criteria) this;
        }

        public Criteria andRisingEqualTo(String value) {
            addCriterion("RISING =", value, "rising");
            return (Criteria) this;
        }

        public Criteria andRisingNotEqualTo(String value) {
            addCriterion("RISING <>", value, "rising");
            return (Criteria) this;
        }

        public Criteria andRisingGreaterThan(String value) {
            addCriterion("RISING >", value, "rising");
            return (Criteria) this;
        }

        public Criteria andRisingGreaterThanOrEqualTo(String value) {
            addCriterion("RISING >=", value, "rising");
            return (Criteria) this;
        }

        public Criteria andRisingLessThan(String value) {
            addCriterion("RISING <", value, "rising");
            return (Criteria) this;
        }

        public Criteria andRisingLessThanOrEqualTo(String value) {
            addCriterion("RISING <=", value, "rising");
            return (Criteria) this;
        }

        public Criteria andRisingLike(String value) {
            addCriterion("RISING like", value, "rising");
            return (Criteria) this;
        }

        public Criteria andRisingNotLike(String value) {
            addCriterion("RISING not like", value, "rising");
            return (Criteria) this;
        }

        public Criteria andRisingIn(List<String> values) {
            addCriterion("RISING in", values, "rising");
            return (Criteria) this;
        }

        public Criteria andRisingNotIn(List<String> values) {
            addCriterion("RISING not in", values, "rising");
            return (Criteria) this;
        }

        public Criteria andRisingBetween(String value1, String value2) {
            addCriterion("RISING between", value1, value2, "rising");
            return (Criteria) this;
        }

        public Criteria andRisingNotBetween(String value1, String value2) {
            addCriterion("RISING not between", value1, value2, "rising");
            return (Criteria) this;
        }

        public Criteria andVisibilityIsNull() {
            addCriterion("VISIBILITY is null");
            return (Criteria) this;
        }

        public Criteria andVisibilityIsNotNull() {
            addCriterion("VISIBILITY is not null");
            return (Criteria) this;
        }

        public Criteria andVisibilityEqualTo(String value) {
            addCriterion("VISIBILITY =", value, "visibility");
            return (Criteria) this;
        }

        public Criteria andVisibilityNotEqualTo(String value) {
            addCriterion("VISIBILITY <>", value, "visibility");
            return (Criteria) this;
        }

        public Criteria andVisibilityGreaterThan(String value) {
            addCriterion("VISIBILITY >", value, "visibility");
            return (Criteria) this;
        }

        public Criteria andVisibilityGreaterThanOrEqualTo(String value) {
            addCriterion("VISIBILITY >=", value, "visibility");
            return (Criteria) this;
        }

        public Criteria andVisibilityLessThan(String value) {
            addCriterion("VISIBILITY <", value, "visibility");
            return (Criteria) this;
        }

        public Criteria andVisibilityLessThanOrEqualTo(String value) {
            addCriterion("VISIBILITY <=", value, "visibility");
            return (Criteria) this;
        }

        public Criteria andVisibilityLike(String value) {
            addCriterion("VISIBILITY like", value, "visibility");
            return (Criteria) this;
        }

        public Criteria andVisibilityNotLike(String value) {
            addCriterion("VISIBILITY not like", value, "visibility");
            return (Criteria) this;
        }

        public Criteria andVisibilityIn(List<String> values) {
            addCriterion("VISIBILITY in", values, "visibility");
            return (Criteria) this;
        }

        public Criteria andVisibilityNotIn(List<String> values) {
            addCriterion("VISIBILITY not in", values, "visibility");
            return (Criteria) this;
        }

        public Criteria andVisibilityBetween(String value1, String value2) {
            addCriterion("VISIBILITY between", value1, value2, "visibility");
            return (Criteria) this;
        }

        public Criteria andVisibilityNotBetween(String value1, String value2) {
            addCriterion("VISIBILITY not between", value1, value2, "visibility");
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