package auto.newsky.coding.po;

import java.util.ArrayList;
import java.util.List;

public class TaskExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaskExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andTaskContentIsNull() {
            addCriterion("task_content is null");
            return (Criteria) this;
        }

        public Criteria andTaskContentIsNotNull() {
            addCriterion("task_content is not null");
            return (Criteria) this;
        }

        public Criteria andTaskContentEqualTo(String value) {
            addCriterion("task_content =", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentNotEqualTo(String value) {
            addCriterion("task_content <>", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentGreaterThan(String value) {
            addCriterion("task_content >", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentGreaterThanOrEqualTo(String value) {
            addCriterion("task_content >=", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentLessThan(String value) {
            addCriterion("task_content <", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentLessThanOrEqualTo(String value) {
            addCriterion("task_content <=", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentLike(String value) {
            addCriterion("task_content like", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentNotLike(String value) {
            addCriterion("task_content not like", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentIn(List<String> values) {
            addCriterion("task_content in", values, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentNotIn(List<String> values) {
            addCriterion("task_content not in", values, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentBetween(String value1, String value2) {
            addCriterion("task_content between", value1, value2, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentNotBetween(String value1, String value2) {
            addCriterion("task_content not between", value1, value2, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskTitleIsNull() {
            addCriterion("task_title is null");
            return (Criteria) this;
        }

        public Criteria andTaskTitleIsNotNull() {
            addCriterion("task_title is not null");
            return (Criteria) this;
        }

        public Criteria andTaskTitleEqualTo(String value) {
            addCriterion("task_title =", value, "taskTitle");
            return (Criteria) this;
        }

        public Criteria andTaskTitleNotEqualTo(String value) {
            addCriterion("task_title <>", value, "taskTitle");
            return (Criteria) this;
        }

        public Criteria andTaskTitleGreaterThan(String value) {
            addCriterion("task_title >", value, "taskTitle");
            return (Criteria) this;
        }

        public Criteria andTaskTitleGreaterThanOrEqualTo(String value) {
            addCriterion("task_title >=", value, "taskTitle");
            return (Criteria) this;
        }

        public Criteria andTaskTitleLessThan(String value) {
            addCriterion("task_title <", value, "taskTitle");
            return (Criteria) this;
        }

        public Criteria andTaskTitleLessThanOrEqualTo(String value) {
            addCriterion("task_title <=", value, "taskTitle");
            return (Criteria) this;
        }

        public Criteria andTaskTitleLike(String value) {
            addCriterion("task_title like", value, "taskTitle");
            return (Criteria) this;
        }

        public Criteria andTaskTitleNotLike(String value) {
            addCriterion("task_title not like", value, "taskTitle");
            return (Criteria) this;
        }

        public Criteria andTaskTitleIn(List<String> values) {
            addCriterion("task_title in", values, "taskTitle");
            return (Criteria) this;
        }

        public Criteria andTaskTitleNotIn(List<String> values) {
            addCriterion("task_title not in", values, "taskTitle");
            return (Criteria) this;
        }

        public Criteria andTaskTitleBetween(String value1, String value2) {
            addCriterion("task_title between", value1, value2, "taskTitle");
            return (Criteria) this;
        }

        public Criteria andTaskTitleNotBetween(String value1, String value2) {
            addCriterion("task_title not between", value1, value2, "taskTitle");
            return (Criteria) this;
        }

        public Criteria andTaskIsDeleteIsNull() {
            addCriterion("task_is_delete is null");
            return (Criteria) this;
        }

        public Criteria andTaskIsDeleteIsNotNull() {
            addCriterion("task_is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIsDeleteEqualTo(Boolean value) {
            addCriterion("task_is_delete =", value, "taskIsDelete");
            return (Criteria) this;
        }

        public Criteria andTaskIsDeleteNotEqualTo(Boolean value) {
            addCriterion("task_is_delete <>", value, "taskIsDelete");
            return (Criteria) this;
        }

        public Criteria andTaskIsDeleteGreaterThan(Boolean value) {
            addCriterion("task_is_delete >", value, "taskIsDelete");
            return (Criteria) this;
        }

        public Criteria andTaskIsDeleteGreaterThanOrEqualTo(Boolean value) {
            addCriterion("task_is_delete >=", value, "taskIsDelete");
            return (Criteria) this;
        }

        public Criteria andTaskIsDeleteLessThan(Boolean value) {
            addCriterion("task_is_delete <", value, "taskIsDelete");
            return (Criteria) this;
        }

        public Criteria andTaskIsDeleteLessThanOrEqualTo(Boolean value) {
            addCriterion("task_is_delete <=", value, "taskIsDelete");
            return (Criteria) this;
        }

        public Criteria andTaskIsDeleteIn(List<Boolean> values) {
            addCriterion("task_is_delete in", values, "taskIsDelete");
            return (Criteria) this;
        }

        public Criteria andTaskIsDeleteNotIn(List<Boolean> values) {
            addCriterion("task_is_delete not in", values, "taskIsDelete");
            return (Criteria) this;
        }

        public Criteria andTaskIsDeleteBetween(Boolean value1, Boolean value2) {
            addCriterion("task_is_delete between", value1, value2, "taskIsDelete");
            return (Criteria) this;
        }

        public Criteria andTaskIsDeleteNotBetween(Boolean value1, Boolean value2) {
            addCriterion("task_is_delete not between", value1, value2, "taskIsDelete");
            return (Criteria) this;
        }

        public Criteria andTaskIconTypeIsNull() {
            addCriterion("task_icon_type is null");
            return (Criteria) this;
        }

        public Criteria andTaskIconTypeIsNotNull() {
            addCriterion("task_icon_type is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIconTypeEqualTo(Integer value) {
            addCriterion("task_icon_type =", value, "taskIconType");
            return (Criteria) this;
        }

        public Criteria andTaskIconTypeNotEqualTo(Integer value) {
            addCriterion("task_icon_type <>", value, "taskIconType");
            return (Criteria) this;
        }

        public Criteria andTaskIconTypeGreaterThan(Integer value) {
            addCriterion("task_icon_type >", value, "taskIconType");
            return (Criteria) this;
        }

        public Criteria andTaskIconTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_icon_type >=", value, "taskIconType");
            return (Criteria) this;
        }

        public Criteria andTaskIconTypeLessThan(Integer value) {
            addCriterion("task_icon_type <", value, "taskIconType");
            return (Criteria) this;
        }

        public Criteria andTaskIconTypeLessThanOrEqualTo(Integer value) {
            addCriterion("task_icon_type <=", value, "taskIconType");
            return (Criteria) this;
        }

        public Criteria andTaskIconTypeIn(List<Integer> values) {
            addCriterion("task_icon_type in", values, "taskIconType");
            return (Criteria) this;
        }

        public Criteria andTaskIconTypeNotIn(List<Integer> values) {
            addCriterion("task_icon_type not in", values, "taskIconType");
            return (Criteria) this;
        }

        public Criteria andTaskIconTypeBetween(Integer value1, Integer value2) {
            addCriterion("task_icon_type between", value1, value2, "taskIconType");
            return (Criteria) this;
        }

        public Criteria andTaskIconTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("task_icon_type not between", value1, value2, "taskIconType");
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