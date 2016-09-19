package auto.newsky.coding.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JournalExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JournalExample() {
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

        public Criteria andJourIdIsNull() {
            addCriterion("jour_id is null");
            return (Criteria) this;
        }

        public Criteria andJourIdIsNotNull() {
            addCriterion("jour_id is not null");
            return (Criteria) this;
        }

        public Criteria andJourIdEqualTo(Integer value) {
            addCriterion("jour_id =", value, "jourId");
            return (Criteria) this;
        }

        public Criteria andJourIdNotEqualTo(Integer value) {
            addCriterion("jour_id <>", value, "jourId");
            return (Criteria) this;
        }

        public Criteria andJourIdGreaterThan(Integer value) {
            addCriterion("jour_id >", value, "jourId");
            return (Criteria) this;
        }

        public Criteria andJourIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("jour_id >=", value, "jourId");
            return (Criteria) this;
        }

        public Criteria andJourIdLessThan(Integer value) {
            addCriterion("jour_id <", value, "jourId");
            return (Criteria) this;
        }

        public Criteria andJourIdLessThanOrEqualTo(Integer value) {
            addCriterion("jour_id <=", value, "jourId");
            return (Criteria) this;
        }

        public Criteria andJourIdIn(List<Integer> values) {
            addCriterion("jour_id in", values, "jourId");
            return (Criteria) this;
        }

        public Criteria andJourIdNotIn(List<Integer> values) {
            addCriterion("jour_id not in", values, "jourId");
            return (Criteria) this;
        }

        public Criteria andJourIdBetween(Integer value1, Integer value2) {
            addCriterion("jour_id between", value1, value2, "jourId");
            return (Criteria) this;
        }

        public Criteria andJourIdNotBetween(Integer value1, Integer value2) {
            addCriterion("jour_id not between", value1, value2, "jourId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNull() {
            addCriterion("task_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("task_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(Integer value) {
            addCriterion("task_id =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(Integer value) {
            addCriterion("task_id <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(Integer value) {
            addCriterion("task_id >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_id >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(Integer value) {
            addCriterion("task_id <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(Integer value) {
            addCriterion("task_id <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(List<Integer> values) {
            addCriterion("task_id in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(List<Integer> values) {
            addCriterion("task_id not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(Integer value1, Integer value2) {
            addCriterion("task_id between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(Integer value1, Integer value2) {
            addCriterion("task_id not between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andJourDateIsNull() {
            addCriterion("jour_date is null");
            return (Criteria) this;
        }

        public Criteria andJourDateIsNotNull() {
            addCriterion("jour_date is not null");
            return (Criteria) this;
        }

        public Criteria andJourDateEqualTo(Date value) {
            addCriterion("jour_date =", value, "jourDate");
            return (Criteria) this;
        }

        public Criteria andJourDateNotEqualTo(Date value) {
            addCriterion("jour_date <>", value, "jourDate");
            return (Criteria) this;
        }

        public Criteria andJourDateGreaterThan(Date value) {
            addCriterion("jour_date >", value, "jourDate");
            return (Criteria) this;
        }

        public Criteria andJourDateGreaterThanOrEqualTo(Date value) {
            addCriterion("jour_date >=", value, "jourDate");
            return (Criteria) this;
        }

        public Criteria andJourDateLessThan(Date value) {
            addCriterion("jour_date <", value, "jourDate");
            return (Criteria) this;
        }

        public Criteria andJourDateLessThanOrEqualTo(Date value) {
            addCriterion("jour_date <=", value, "jourDate");
            return (Criteria) this;
        }

        public Criteria andJourDateIn(List<Date> values) {
            addCriterion("jour_date in", values, "jourDate");
            return (Criteria) this;
        }

        public Criteria andJourDateNotIn(List<Date> values) {
            addCriterion("jour_date not in", values, "jourDate");
            return (Criteria) this;
        }

        public Criteria andJourDateBetween(Date value1, Date value2) {
            addCriterion("jour_date between", value1, value2, "jourDate");
            return (Criteria) this;
        }

        public Criteria andJourDateNotBetween(Date value1, Date value2) {
            addCriterion("jour_date not between", value1, value2, "jourDate");
            return (Criteria) this;
        }

        public Criteria andJourSummaryIsNull() {
            addCriterion("jour_summary is null");
            return (Criteria) this;
        }

        public Criteria andJourSummaryIsNotNull() {
            addCriterion("jour_summary is not null");
            return (Criteria) this;
        }

        public Criteria andJourSummaryEqualTo(String value) {
            addCriterion("jour_summary =", value, "jourSummary");
            return (Criteria) this;
        }

        public Criteria andJourSummaryNotEqualTo(String value) {
            addCriterion("jour_summary <>", value, "jourSummary");
            return (Criteria) this;
        }

        public Criteria andJourSummaryGreaterThan(String value) {
            addCriterion("jour_summary >", value, "jourSummary");
            return (Criteria) this;
        }

        public Criteria andJourSummaryGreaterThanOrEqualTo(String value) {
            addCriterion("jour_summary >=", value, "jourSummary");
            return (Criteria) this;
        }

        public Criteria andJourSummaryLessThan(String value) {
            addCriterion("jour_summary <", value, "jourSummary");
            return (Criteria) this;
        }

        public Criteria andJourSummaryLessThanOrEqualTo(String value) {
            addCriterion("jour_summary <=", value, "jourSummary");
            return (Criteria) this;
        }

        public Criteria andJourSummaryLike(String value) {
            addCriterion("jour_summary like", value, "jourSummary");
            return (Criteria) this;
        }

        public Criteria andJourSummaryNotLike(String value) {
            addCriterion("jour_summary not like", value, "jourSummary");
            return (Criteria) this;
        }

        public Criteria andJourSummaryIn(List<String> values) {
            addCriterion("jour_summary in", values, "jourSummary");
            return (Criteria) this;
        }

        public Criteria andJourSummaryNotIn(List<String> values) {
            addCriterion("jour_summary not in", values, "jourSummary");
            return (Criteria) this;
        }

        public Criteria andJourSummaryBetween(String value1, String value2) {
            addCriterion("jour_summary between", value1, value2, "jourSummary");
            return (Criteria) this;
        }

        public Criteria andJourSummaryNotBetween(String value1, String value2) {
            addCriterion("jour_summary not between", value1, value2, "jourSummary");
            return (Criteria) this;
        }

        public Criteria andJourPunchIsNull() {
            addCriterion("jour_punch is null");
            return (Criteria) this;
        }

        public Criteria andJourPunchIsNotNull() {
            addCriterion("jour_punch is not null");
            return (Criteria) this;
        }

        public Criteria andJourPunchEqualTo(Boolean value) {
            addCriterion("jour_punch =", value, "jourPunch");
            return (Criteria) this;
        }

        public Criteria andJourPunchNotEqualTo(Boolean value) {
            addCriterion("jour_punch <>", value, "jourPunch");
            return (Criteria) this;
        }

        public Criteria andJourPunchGreaterThan(Boolean value) {
            addCriterion("jour_punch >", value, "jourPunch");
            return (Criteria) this;
        }

        public Criteria andJourPunchGreaterThanOrEqualTo(Boolean value) {
            addCriterion("jour_punch >=", value, "jourPunch");
            return (Criteria) this;
        }

        public Criteria andJourPunchLessThan(Boolean value) {
            addCriterion("jour_punch <", value, "jourPunch");
            return (Criteria) this;
        }

        public Criteria andJourPunchLessThanOrEqualTo(Boolean value) {
            addCriterion("jour_punch <=", value, "jourPunch");
            return (Criteria) this;
        }

        public Criteria andJourPunchIn(List<Boolean> values) {
            addCriterion("jour_punch in", values, "jourPunch");
            return (Criteria) this;
        }

        public Criteria andJourPunchNotIn(List<Boolean> values) {
            addCriterion("jour_punch not in", values, "jourPunch");
            return (Criteria) this;
        }

        public Criteria andJourPunchBetween(Boolean value1, Boolean value2) {
            addCriterion("jour_punch between", value1, value2, "jourPunch");
            return (Criteria) this;
        }

        public Criteria andJourPunchNotBetween(Boolean value1, Boolean value2) {
            addCriterion("jour_punch not between", value1, value2, "jourPunch");
            return (Criteria) this;
        }

        public Criteria andJourIsDeleteIsNull() {
            addCriterion("jour_is_delete is null");
            return (Criteria) this;
        }

        public Criteria andJourIsDeleteIsNotNull() {
            addCriterion("jour_is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andJourIsDeleteEqualTo(Boolean value) {
            addCriterion("jour_is_delete =", value, "jourIsDelete");
            return (Criteria) this;
        }

        public Criteria andJourIsDeleteNotEqualTo(Boolean value) {
            addCriterion("jour_is_delete <>", value, "jourIsDelete");
            return (Criteria) this;
        }

        public Criteria andJourIsDeleteGreaterThan(Boolean value) {
            addCriterion("jour_is_delete >", value, "jourIsDelete");
            return (Criteria) this;
        }

        public Criteria andJourIsDeleteGreaterThanOrEqualTo(Boolean value) {
            addCriterion("jour_is_delete >=", value, "jourIsDelete");
            return (Criteria) this;
        }

        public Criteria andJourIsDeleteLessThan(Boolean value) {
            addCriterion("jour_is_delete <", value, "jourIsDelete");
            return (Criteria) this;
        }

        public Criteria andJourIsDeleteLessThanOrEqualTo(Boolean value) {
            addCriterion("jour_is_delete <=", value, "jourIsDelete");
            return (Criteria) this;
        }

        public Criteria andJourIsDeleteIn(List<Boolean> values) {
            addCriterion("jour_is_delete in", values, "jourIsDelete");
            return (Criteria) this;
        }

        public Criteria andJourIsDeleteNotIn(List<Boolean> values) {
            addCriterion("jour_is_delete not in", values, "jourIsDelete");
            return (Criteria) this;
        }

        public Criteria andJourIsDeleteBetween(Boolean value1, Boolean value2) {
            addCriterion("jour_is_delete between", value1, value2, "jourIsDelete");
            return (Criteria) this;
        }

        public Criteria andJourIsDeleteNotBetween(Boolean value1, Boolean value2) {
            addCriterion("jour_is_delete not between", value1, value2, "jourIsDelete");
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