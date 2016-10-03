package auto.newsky.coding.po;

import java.util.ArrayList;
import java.util.List;

public class VersionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VersionExample() {
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

        public Criteria andVersionIdIsNull() {
            addCriterion("version_id is null");
            return (Criteria) this;
        }

        public Criteria andVersionIdIsNotNull() {
            addCriterion("version_id is not null");
            return (Criteria) this;
        }

        public Criteria andVersionIdEqualTo(Integer value) {
            addCriterion("version_id =", value, "versionId");
            return (Criteria) this;
        }

        public Criteria andVersionIdNotEqualTo(Integer value) {
            addCriterion("version_id <>", value, "versionId");
            return (Criteria) this;
        }

        public Criteria andVersionIdGreaterThan(Integer value) {
            addCriterion("version_id >", value, "versionId");
            return (Criteria) this;
        }

        public Criteria andVersionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("version_id >=", value, "versionId");
            return (Criteria) this;
        }

        public Criteria andVersionIdLessThan(Integer value) {
            addCriterion("version_id <", value, "versionId");
            return (Criteria) this;
        }

        public Criteria andVersionIdLessThanOrEqualTo(Integer value) {
            addCriterion("version_id <=", value, "versionId");
            return (Criteria) this;
        }

        public Criteria andVersionIdIn(List<Integer> values) {
            addCriterion("version_id in", values, "versionId");
            return (Criteria) this;
        }

        public Criteria andVersionIdNotIn(List<Integer> values) {
            addCriterion("version_id not in", values, "versionId");
            return (Criteria) this;
        }

        public Criteria andVersionIdBetween(Integer value1, Integer value2) {
            addCriterion("version_id between", value1, value2, "versionId");
            return (Criteria) this;
        }

        public Criteria andVersionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("version_id not between", value1, value2, "versionId");
            return (Criteria) this;
        }

        public Criteria andVersionCodeIsNull() {
            addCriterion("version_code is null");
            return (Criteria) this;
        }

        public Criteria andVersionCodeIsNotNull() {
            addCriterion("version_code is not null");
            return (Criteria) this;
        }

        public Criteria andVersionCodeEqualTo(Integer value) {
            addCriterion("version_code =", value, "versionCode");
            return (Criteria) this;
        }

        public Criteria andVersionCodeNotEqualTo(Integer value) {
            addCriterion("version_code <>", value, "versionCode");
            return (Criteria) this;
        }

        public Criteria andVersionCodeGreaterThan(Integer value) {
            addCriterion("version_code >", value, "versionCode");
            return (Criteria) this;
        }

        public Criteria andVersionCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("version_code >=", value, "versionCode");
            return (Criteria) this;
        }

        public Criteria andVersionCodeLessThan(Integer value) {
            addCriterion("version_code <", value, "versionCode");
            return (Criteria) this;
        }

        public Criteria andVersionCodeLessThanOrEqualTo(Integer value) {
            addCriterion("version_code <=", value, "versionCode");
            return (Criteria) this;
        }

        public Criteria andVersionCodeIn(List<Integer> values) {
            addCriterion("version_code in", values, "versionCode");
            return (Criteria) this;
        }

        public Criteria andVersionCodeNotIn(List<Integer> values) {
            addCriterion("version_code not in", values, "versionCode");
            return (Criteria) this;
        }

        public Criteria andVersionCodeBetween(Integer value1, Integer value2) {
            addCriterion("version_code between", value1, value2, "versionCode");
            return (Criteria) this;
        }

        public Criteria andVersionCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("version_code not between", value1, value2, "versionCode");
            return (Criteria) this;
        }

        public Criteria andVersionNameIsNull() {
            addCriterion("version_name is null");
            return (Criteria) this;
        }

        public Criteria andVersionNameIsNotNull() {
            addCriterion("version_name is not null");
            return (Criteria) this;
        }

        public Criteria andVersionNameEqualTo(Double value) {
            addCriterion("version_name =", value, "versionName");
            return (Criteria) this;
        }

        public Criteria andVersionNameNotEqualTo(Double value) {
            addCriterion("version_name <>", value, "versionName");
            return (Criteria) this;
        }

        public Criteria andVersionNameGreaterThan(Double value) {
            addCriterion("version_name >", value, "versionName");
            return (Criteria) this;
        }

        public Criteria andVersionNameGreaterThanOrEqualTo(Double value) {
            addCriterion("version_name >=", value, "versionName");
            return (Criteria) this;
        }

        public Criteria andVersionNameLessThan(Double value) {
            addCriterion("version_name <", value, "versionName");
            return (Criteria) this;
        }

        public Criteria andVersionNameLessThanOrEqualTo(Double value) {
            addCriterion("version_name <=", value, "versionName");
            return (Criteria) this;
        }

        public Criteria andVersionNameIn(List<Double> values) {
            addCriterion("version_name in", values, "versionName");
            return (Criteria) this;
        }

        public Criteria andVersionNameNotIn(List<Double> values) {
            addCriterion("version_name not in", values, "versionName");
            return (Criteria) this;
        }

        public Criteria andVersionNameBetween(Double value1, Double value2) {
            addCriterion("version_name between", value1, value2, "versionName");
            return (Criteria) this;
        }

        public Criteria andVersionNameNotBetween(Double value1, Double value2) {
            addCriterion("version_name not between", value1, value2, "versionName");
            return (Criteria) this;
        }

        public Criteria andVersionContentIsNull() {
            addCriterion("version_content is null");
            return (Criteria) this;
        }

        public Criteria andVersionContentIsNotNull() {
            addCriterion("version_content is not null");
            return (Criteria) this;
        }

        public Criteria andVersionContentEqualTo(String value) {
            addCriterion("version_content =", value, "versionContent");
            return (Criteria) this;
        }

        public Criteria andVersionContentNotEqualTo(String value) {
            addCriterion("version_content <>", value, "versionContent");
            return (Criteria) this;
        }

        public Criteria andVersionContentGreaterThan(String value) {
            addCriterion("version_content >", value, "versionContent");
            return (Criteria) this;
        }

        public Criteria andVersionContentGreaterThanOrEqualTo(String value) {
            addCriterion("version_content >=", value, "versionContent");
            return (Criteria) this;
        }

        public Criteria andVersionContentLessThan(String value) {
            addCriterion("version_content <", value, "versionContent");
            return (Criteria) this;
        }

        public Criteria andVersionContentLessThanOrEqualTo(String value) {
            addCriterion("version_content <=", value, "versionContent");
            return (Criteria) this;
        }

        public Criteria andVersionContentLike(String value) {
            addCriterion("version_content like", value, "versionContent");
            return (Criteria) this;
        }

        public Criteria andVersionContentNotLike(String value) {
            addCriterion("version_content not like", value, "versionContent");
            return (Criteria) this;
        }

        public Criteria andVersionContentIn(List<String> values) {
            addCriterion("version_content in", values, "versionContent");
            return (Criteria) this;
        }

        public Criteria andVersionContentNotIn(List<String> values) {
            addCriterion("version_content not in", values, "versionContent");
            return (Criteria) this;
        }

        public Criteria andVersionContentBetween(String value1, String value2) {
            addCriterion("version_content between", value1, value2, "versionContent");
            return (Criteria) this;
        }

        public Criteria andVersionContentNotBetween(String value1, String value2) {
            addCriterion("version_content not between", value1, value2, "versionContent");
            return (Criteria) this;
        }

        public Criteria andVersionForceUpdateIsNull() {
            addCriterion("version_force_update is null");
            return (Criteria) this;
        }

        public Criteria andVersionForceUpdateIsNotNull() {
            addCriterion("version_force_update is not null");
            return (Criteria) this;
        }

        public Criteria andVersionForceUpdateEqualTo(Integer value) {
            addCriterion("version_force_update =", value, "versionForceUpdate");
            return (Criteria) this;
        }

        public Criteria andVersionForceUpdateNotEqualTo(Integer value) {
            addCriterion("version_force_update <>", value, "versionForceUpdate");
            return (Criteria) this;
        }

        public Criteria andVersionForceUpdateGreaterThan(Integer value) {
            addCriterion("version_force_update >", value, "versionForceUpdate");
            return (Criteria) this;
        }

        public Criteria andVersionForceUpdateGreaterThanOrEqualTo(Integer value) {
            addCriterion("version_force_update >=", value, "versionForceUpdate");
            return (Criteria) this;
        }

        public Criteria andVersionForceUpdateLessThan(Integer value) {
            addCriterion("version_force_update <", value, "versionForceUpdate");
            return (Criteria) this;
        }

        public Criteria andVersionForceUpdateLessThanOrEqualTo(Integer value) {
            addCriterion("version_force_update <=", value, "versionForceUpdate");
            return (Criteria) this;
        }

        public Criteria andVersionForceUpdateIn(List<Integer> values) {
            addCriterion("version_force_update in", values, "versionForceUpdate");
            return (Criteria) this;
        }

        public Criteria andVersionForceUpdateNotIn(List<Integer> values) {
            addCriterion("version_force_update not in", values, "versionForceUpdate");
            return (Criteria) this;
        }

        public Criteria andVersionForceUpdateBetween(Integer value1, Integer value2) {
            addCriterion("version_force_update between", value1, value2, "versionForceUpdate");
            return (Criteria) this;
        }

        public Criteria andVersionForceUpdateNotBetween(Integer value1, Integer value2) {
            addCriterion("version_force_update not between", value1, value2, "versionForceUpdate");
            return (Criteria) this;
        }

        public Criteria andVersionUrlIsNull() {
            addCriterion("version_url is null");
            return (Criteria) this;
        }

        public Criteria andVersionUrlIsNotNull() {
            addCriterion("version_url is not null");
            return (Criteria) this;
        }

        public Criteria andVersionUrlEqualTo(String value) {
            addCriterion("version_url =", value, "versionUrl");
            return (Criteria) this;
        }

        public Criteria andVersionUrlNotEqualTo(String value) {
            addCriterion("version_url <>", value, "versionUrl");
            return (Criteria) this;
        }

        public Criteria andVersionUrlGreaterThan(String value) {
            addCriterion("version_url >", value, "versionUrl");
            return (Criteria) this;
        }

        public Criteria andVersionUrlGreaterThanOrEqualTo(String value) {
            addCriterion("version_url >=", value, "versionUrl");
            return (Criteria) this;
        }

        public Criteria andVersionUrlLessThan(String value) {
            addCriterion("version_url <", value, "versionUrl");
            return (Criteria) this;
        }

        public Criteria andVersionUrlLessThanOrEqualTo(String value) {
            addCriterion("version_url <=", value, "versionUrl");
            return (Criteria) this;
        }

        public Criteria andVersionUrlLike(String value) {
            addCriterion("version_url like", value, "versionUrl");
            return (Criteria) this;
        }

        public Criteria andVersionUrlNotLike(String value) {
            addCriterion("version_url not like", value, "versionUrl");
            return (Criteria) this;
        }

        public Criteria andVersionUrlIn(List<String> values) {
            addCriterion("version_url in", values, "versionUrl");
            return (Criteria) this;
        }

        public Criteria andVersionUrlNotIn(List<String> values) {
            addCriterion("version_url not in", values, "versionUrl");
            return (Criteria) this;
        }

        public Criteria andVersionUrlBetween(String value1, String value2) {
            addCriterion("version_url between", value1, value2, "versionUrl");
            return (Criteria) this;
        }

        public Criteria andVersionUrlNotBetween(String value1, String value2) {
            addCriterion("version_url not between", value1, value2, "versionUrl");
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