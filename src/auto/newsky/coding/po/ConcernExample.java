package auto.newsky.coding.po;

import java.util.ArrayList;
import java.util.List;

public class ConcernExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ConcernExample() {
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

        public Criteria andConFromUserIdIsNull() {
            addCriterion("con_from_user_id is null");
            return (Criteria) this;
        }

        public Criteria andConFromUserIdIsNotNull() {
            addCriterion("con_from_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andConFromUserIdEqualTo(Integer value) {
            addCriterion("con_from_user_id =", value, "conFromUserId");
            return (Criteria) this;
        }

        public Criteria andConFromUserIdNotEqualTo(Integer value) {
            addCriterion("con_from_user_id <>", value, "conFromUserId");
            return (Criteria) this;
        }

        public Criteria andConFromUserIdGreaterThan(Integer value) {
            addCriterion("con_from_user_id >", value, "conFromUserId");
            return (Criteria) this;
        }

        public Criteria andConFromUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("con_from_user_id >=", value, "conFromUserId");
            return (Criteria) this;
        }

        public Criteria andConFromUserIdLessThan(Integer value) {
            addCriterion("con_from_user_id <", value, "conFromUserId");
            return (Criteria) this;
        }

        public Criteria andConFromUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("con_from_user_id <=", value, "conFromUserId");
            return (Criteria) this;
        }

        public Criteria andConFromUserIdIn(List<Integer> values) {
            addCriterion("con_from_user_id in", values, "conFromUserId");
            return (Criteria) this;
        }

        public Criteria andConFromUserIdNotIn(List<Integer> values) {
            addCriterion("con_from_user_id not in", values, "conFromUserId");
            return (Criteria) this;
        }

        public Criteria andConFromUserIdBetween(Integer value1, Integer value2) {
            addCriterion("con_from_user_id between", value1, value2, "conFromUserId");
            return (Criteria) this;
        }

        public Criteria andConFromUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("con_from_user_id not between", value1, value2, "conFromUserId");
            return (Criteria) this;
        }

        public Criteria andConToUserIdIsNull() {
            addCriterion("con_to_user_id is null");
            return (Criteria) this;
        }

        public Criteria andConToUserIdIsNotNull() {
            addCriterion("con_to_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andConToUserIdEqualTo(Integer value) {
            addCriterion("con_to_user_id =", value, "conToUserId");
            return (Criteria) this;
        }

        public Criteria andConToUserIdNotEqualTo(Integer value) {
            addCriterion("con_to_user_id <>", value, "conToUserId");
            return (Criteria) this;
        }

        public Criteria andConToUserIdGreaterThan(Integer value) {
            addCriterion("con_to_user_id >", value, "conToUserId");
            return (Criteria) this;
        }

        public Criteria andConToUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("con_to_user_id >=", value, "conToUserId");
            return (Criteria) this;
        }

        public Criteria andConToUserIdLessThan(Integer value) {
            addCriterion("con_to_user_id <", value, "conToUserId");
            return (Criteria) this;
        }

        public Criteria andConToUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("con_to_user_id <=", value, "conToUserId");
            return (Criteria) this;
        }

        public Criteria andConToUserIdIn(List<Integer> values) {
            addCriterion("con_to_user_id in", values, "conToUserId");
            return (Criteria) this;
        }

        public Criteria andConToUserIdNotIn(List<Integer> values) {
            addCriterion("con_to_user_id not in", values, "conToUserId");
            return (Criteria) this;
        }

        public Criteria andConToUserIdBetween(Integer value1, Integer value2) {
            addCriterion("con_to_user_id between", value1, value2, "conToUserId");
            return (Criteria) this;
        }

        public Criteria andConToUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("con_to_user_id not between", value1, value2, "conToUserId");
            return (Criteria) this;
        }

        public Criteria andConIsConcernIsNull() {
            addCriterion("con_is_concern is null");
            return (Criteria) this;
        }

        public Criteria andConIsConcernIsNotNull() {
            addCriterion("con_is_concern is not null");
            return (Criteria) this;
        }

        public Criteria andConIsConcernEqualTo(Boolean value) {
            addCriterion("con_is_concern =", value, "conIsConcern");
            return (Criteria) this;
        }

        public Criteria andConIsConcernNotEqualTo(Boolean value) {
            addCriterion("con_is_concern <>", value, "conIsConcern");
            return (Criteria) this;
        }

        public Criteria andConIsConcernGreaterThan(Boolean value) {
            addCriterion("con_is_concern >", value, "conIsConcern");
            return (Criteria) this;
        }

        public Criteria andConIsConcernGreaterThanOrEqualTo(Boolean value) {
            addCriterion("con_is_concern >=", value, "conIsConcern");
            return (Criteria) this;
        }

        public Criteria andConIsConcernLessThan(Boolean value) {
            addCriterion("con_is_concern <", value, "conIsConcern");
            return (Criteria) this;
        }

        public Criteria andConIsConcernLessThanOrEqualTo(Boolean value) {
            addCriterion("con_is_concern <=", value, "conIsConcern");
            return (Criteria) this;
        }

        public Criteria andConIsConcernIn(List<Boolean> values) {
            addCriterion("con_is_concern in", values, "conIsConcern");
            return (Criteria) this;
        }

        public Criteria andConIsConcernNotIn(List<Boolean> values) {
            addCriterion("con_is_concern not in", values, "conIsConcern");
            return (Criteria) this;
        }

        public Criteria andConIsConcernBetween(Boolean value1, Boolean value2) {
            addCriterion("con_is_concern between", value1, value2, "conIsConcern");
            return (Criteria) this;
        }

        public Criteria andConIsConcernNotBetween(Boolean value1, Boolean value2) {
            addCriterion("con_is_concern not between", value1, value2, "conIsConcern");
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