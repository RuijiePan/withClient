package auto.newsky.coding.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InvitationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InvitationExample() {
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

        public Criteria andInvitIdIsNull() {
            addCriterion("invit_id is null");
            return (Criteria) this;
        }

        public Criteria andInvitIdIsNotNull() {
            addCriterion("invit_id is not null");
            return (Criteria) this;
        }

        public Criteria andInvitIdEqualTo(Integer value) {
            addCriterion("invit_id =", value, "invitId");
            return (Criteria) this;
        }

        public Criteria andInvitIdNotEqualTo(Integer value) {
            addCriterion("invit_id <>", value, "invitId");
            return (Criteria) this;
        }

        public Criteria andInvitIdGreaterThan(Integer value) {
            addCriterion("invit_id >", value, "invitId");
            return (Criteria) this;
        }

        public Criteria andInvitIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("invit_id >=", value, "invitId");
            return (Criteria) this;
        }

        public Criteria andInvitIdLessThan(Integer value) {
            addCriterion("invit_id <", value, "invitId");
            return (Criteria) this;
        }

        public Criteria andInvitIdLessThanOrEqualTo(Integer value) {
            addCriterion("invit_id <=", value, "invitId");
            return (Criteria) this;
        }

        public Criteria andInvitIdIn(List<Integer> values) {
            addCriterion("invit_id in", values, "invitId");
            return (Criteria) this;
        }

        public Criteria andInvitIdNotIn(List<Integer> values) {
            addCriterion("invit_id not in", values, "invitId");
            return (Criteria) this;
        }

        public Criteria andInvitIdBetween(Integer value1, Integer value2) {
            addCriterion("invit_id between", value1, value2, "invitId");
            return (Criteria) this;
        }

        public Criteria andInvitIdNotBetween(Integer value1, Integer value2) {
            addCriterion("invit_id not between", value1, value2, "invitId");
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

        public Criteria andTypeIdIsNull() {
            addCriterion("type_id is null");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNotNull() {
            addCriterion("type_id is not null");
            return (Criteria) this;
        }

        public Criteria andTypeIdEqualTo(Integer value) {
            addCriterion("type_id =", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotEqualTo(Integer value) {
            addCriterion("type_id <>", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThan(Integer value) {
            addCriterion("type_id >", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("type_id >=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThan(Integer value) {
            addCriterion("type_id <", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("type_id <=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIn(List<Integer> values) {
            addCriterion("type_id in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotIn(List<Integer> values) {
            addCriterion("type_id not in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("type_id between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("type_id not between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andInvitPublicationTimeIsNull() {
            addCriterion("invit_publication_time is null");
            return (Criteria) this;
        }

        public Criteria andInvitPublicationTimeIsNotNull() {
            addCriterion("invit_publication_time is not null");
            return (Criteria) this;
        }

        public Criteria andInvitPublicationTimeEqualTo(Date value) {
            addCriterion("invit_publication_time =", value, "invitPublicationTime");
            return (Criteria) this;
        }

        public Criteria andInvitPublicationTimeNotEqualTo(Date value) {
            addCriterion("invit_publication_time <>", value, "invitPublicationTime");
            return (Criteria) this;
        }

        public Criteria andInvitPublicationTimeGreaterThan(Date value) {
            addCriterion("invit_publication_time >", value, "invitPublicationTime");
            return (Criteria) this;
        }

        public Criteria andInvitPublicationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("invit_publication_time >=", value, "invitPublicationTime");
            return (Criteria) this;
        }

        public Criteria andInvitPublicationTimeLessThan(Date value) {
            addCriterion("invit_publication_time <", value, "invitPublicationTime");
            return (Criteria) this;
        }

        public Criteria andInvitPublicationTimeLessThanOrEqualTo(Date value) {
            addCriterion("invit_publication_time <=", value, "invitPublicationTime");
            return (Criteria) this;
        }

        public Criteria andInvitPublicationTimeIn(List<Date> values) {
            addCriterion("invit_publication_time in", values, "invitPublicationTime");
            return (Criteria) this;
        }

        public Criteria andInvitPublicationTimeNotIn(List<Date> values) {
            addCriterion("invit_publication_time not in", values, "invitPublicationTime");
            return (Criteria) this;
        }

        public Criteria andInvitPublicationTimeBetween(Date value1, Date value2) {
            addCriterion("invit_publication_time between", value1, value2, "invitPublicationTime");
            return (Criteria) this;
        }

        public Criteria andInvitPublicationTimeNotBetween(Date value1, Date value2) {
            addCriterion("invit_publication_time not between", value1, value2, "invitPublicationTime");
            return (Criteria) this;
        }

        public Criteria andInvitActivityTimeIsNull() {
            addCriterion("invit_activity_time is null");
            return (Criteria) this;
        }

        public Criteria andInvitActivityTimeIsNotNull() {
            addCriterion("invit_activity_time is not null");
            return (Criteria) this;
        }

        public Criteria andInvitActivityTimeEqualTo(Date value) {
            addCriterion("invit_activity_time =", value, "invitActivityTime");
            return (Criteria) this;
        }

        public Criteria andInvitActivityTimeNotEqualTo(Date value) {
            addCriterion("invit_activity_time <>", value, "invitActivityTime");
            return (Criteria) this;
        }

        public Criteria andInvitActivityTimeGreaterThan(Date value) {
            addCriterion("invit_activity_time >", value, "invitActivityTime");
            return (Criteria) this;
        }

        public Criteria andInvitActivityTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("invit_activity_time >=", value, "invitActivityTime");
            return (Criteria) this;
        }

        public Criteria andInvitActivityTimeLessThan(Date value) {
            addCriterion("invit_activity_time <", value, "invitActivityTime");
            return (Criteria) this;
        }

        public Criteria andInvitActivityTimeLessThanOrEqualTo(Date value) {
            addCriterion("invit_activity_time <=", value, "invitActivityTime");
            return (Criteria) this;
        }

        public Criteria andInvitActivityTimeIn(List<Date> values) {
            addCriterion("invit_activity_time in", values, "invitActivityTime");
            return (Criteria) this;
        }

        public Criteria andInvitActivityTimeNotIn(List<Date> values) {
            addCriterion("invit_activity_time not in", values, "invitActivityTime");
            return (Criteria) this;
        }

        public Criteria andInvitActivityTimeBetween(Date value1, Date value2) {
            addCriterion("invit_activity_time between", value1, value2, "invitActivityTime");
            return (Criteria) this;
        }

        public Criteria andInvitActivityTimeNotBetween(Date value1, Date value2) {
            addCriterion("invit_activity_time not between", value1, value2, "invitActivityTime");
            return (Criteria) this;
        }

        public Criteria andInvitPlaceIsNull() {
            addCriterion("invit_place is null");
            return (Criteria) this;
        }

        public Criteria andInvitPlaceIsNotNull() {
            addCriterion("invit_place is not null");
            return (Criteria) this;
        }

        public Criteria andInvitPlaceEqualTo(String value) {
            addCriterion("invit_place =", value, "invitPlace");
            return (Criteria) this;
        }

        public Criteria andInvitPlaceNotEqualTo(String value) {
            addCriterion("invit_place <>", value, "invitPlace");
            return (Criteria) this;
        }

        public Criteria andInvitPlaceGreaterThan(String value) {
            addCriterion("invit_place >", value, "invitPlace");
            return (Criteria) this;
        }

        public Criteria andInvitPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("invit_place >=", value, "invitPlace");
            return (Criteria) this;
        }

        public Criteria andInvitPlaceLessThan(String value) {
            addCriterion("invit_place <", value, "invitPlace");
            return (Criteria) this;
        }

        public Criteria andInvitPlaceLessThanOrEqualTo(String value) {
            addCriterion("invit_place <=", value, "invitPlace");
            return (Criteria) this;
        }

        public Criteria andInvitPlaceLike(String value) {
            addCriterion("invit_place like", value, "invitPlace");
            return (Criteria) this;
        }

        public Criteria andInvitPlaceNotLike(String value) {
            addCriterion("invit_place not like", value, "invitPlace");
            return (Criteria) this;
        }

        public Criteria andInvitPlaceIn(List<String> values) {
            addCriterion("invit_place in", values, "invitPlace");
            return (Criteria) this;
        }

        public Criteria andInvitPlaceNotIn(List<String> values) {
            addCriterion("invit_place not in", values, "invitPlace");
            return (Criteria) this;
        }

        public Criteria andInvitPlaceBetween(String value1, String value2) {
            addCriterion("invit_place between", value1, value2, "invitPlace");
            return (Criteria) this;
        }

        public Criteria andInvitPlaceNotBetween(String value1, String value2) {
            addCriterion("invit_place not between", value1, value2, "invitPlace");
            return (Criteria) this;
        }

        public Criteria andInvitNumberMaxIsNull() {
            addCriterion("invit_number_max is null");
            return (Criteria) this;
        }

        public Criteria andInvitNumberMaxIsNotNull() {
            addCriterion("invit_number_max is not null");
            return (Criteria) this;
        }

        public Criteria andInvitNumberMaxEqualTo(Integer value) {
            addCriterion("invit_number_max =", value, "invitNumberMax");
            return (Criteria) this;
        }

        public Criteria andInvitNumberMaxNotEqualTo(Integer value) {
            addCriterion("invit_number_max <>", value, "invitNumberMax");
            return (Criteria) this;
        }

        public Criteria andInvitNumberMaxGreaterThan(Integer value) {
            addCriterion("invit_number_max >", value, "invitNumberMax");
            return (Criteria) this;
        }

        public Criteria andInvitNumberMaxGreaterThanOrEqualTo(Integer value) {
            addCriterion("invit_number_max >=", value, "invitNumberMax");
            return (Criteria) this;
        }

        public Criteria andInvitNumberMaxLessThan(Integer value) {
            addCriterion("invit_number_max <", value, "invitNumberMax");
            return (Criteria) this;
        }

        public Criteria andInvitNumberMaxLessThanOrEqualTo(Integer value) {
            addCriterion("invit_number_max <=", value, "invitNumberMax");
            return (Criteria) this;
        }

        public Criteria andInvitNumberMaxIn(List<Integer> values) {
            addCriterion("invit_number_max in", values, "invitNumberMax");
            return (Criteria) this;
        }

        public Criteria andInvitNumberMaxNotIn(List<Integer> values) {
            addCriterion("invit_number_max not in", values, "invitNumberMax");
            return (Criteria) this;
        }

        public Criteria andInvitNumberMaxBetween(Integer value1, Integer value2) {
            addCriterion("invit_number_max between", value1, value2, "invitNumberMax");
            return (Criteria) this;
        }

        public Criteria andInvitNumberMaxNotBetween(Integer value1, Integer value2) {
            addCriterion("invit_number_max not between", value1, value2, "invitNumberMax");
            return (Criteria) this;
        }

        public Criteria andInvitNumberCurrIsNull() {
            addCriterion("invit_number_curr is null");
            return (Criteria) this;
        }

        public Criteria andInvitNumberCurrIsNotNull() {
            addCriterion("invit_number_curr is not null");
            return (Criteria) this;
        }

        public Criteria andInvitNumberCurrEqualTo(Integer value) {
            addCriterion("invit_number_curr =", value, "invitNumberCurr");
            return (Criteria) this;
        }

        public Criteria andInvitNumberCurrNotEqualTo(Integer value) {
            addCriterion("invit_number_curr <>", value, "invitNumberCurr");
            return (Criteria) this;
        }

        public Criteria andInvitNumberCurrGreaterThan(Integer value) {
            addCriterion("invit_number_curr >", value, "invitNumberCurr");
            return (Criteria) this;
        }

        public Criteria andInvitNumberCurrGreaterThanOrEqualTo(Integer value) {
            addCriterion("invit_number_curr >=", value, "invitNumberCurr");
            return (Criteria) this;
        }

        public Criteria andInvitNumberCurrLessThan(Integer value) {
            addCriterion("invit_number_curr <", value, "invitNumberCurr");
            return (Criteria) this;
        }

        public Criteria andInvitNumberCurrLessThanOrEqualTo(Integer value) {
            addCriterion("invit_number_curr <=", value, "invitNumberCurr");
            return (Criteria) this;
        }

        public Criteria andInvitNumberCurrIn(List<Integer> values) {
            addCriterion("invit_number_curr in", values, "invitNumberCurr");
            return (Criteria) this;
        }

        public Criteria andInvitNumberCurrNotIn(List<Integer> values) {
            addCriterion("invit_number_curr not in", values, "invitNumberCurr");
            return (Criteria) this;
        }

        public Criteria andInvitNumberCurrBetween(Integer value1, Integer value2) {
            addCriterion("invit_number_curr between", value1, value2, "invitNumberCurr");
            return (Criteria) this;
        }

        public Criteria andInvitNumberCurrNotBetween(Integer value1, Integer value2) {
            addCriterion("invit_number_curr not between", value1, value2, "invitNumberCurr");
            return (Criteria) this;
        }

        public Criteria andInvitSexRequireIsNull() {
            addCriterion("invit_sex_require is null");
            return (Criteria) this;
        }

        public Criteria andInvitSexRequireIsNotNull() {
            addCriterion("invit_sex_require is not null");
            return (Criteria) this;
        }

        public Criteria andInvitSexRequireEqualTo(Integer value) {
            addCriterion("invit_sex_require =", value, "invitSexRequire");
            return (Criteria) this;
        }

        public Criteria andInvitSexRequireNotEqualTo(Integer value) {
            addCriterion("invit_sex_require <>", value, "invitSexRequire");
            return (Criteria) this;
        }

        public Criteria andInvitSexRequireGreaterThan(Integer value) {
            addCriterion("invit_sex_require >", value, "invitSexRequire");
            return (Criteria) this;
        }

        public Criteria andInvitSexRequireGreaterThanOrEqualTo(Integer value) {
            addCriterion("invit_sex_require >=", value, "invitSexRequire");
            return (Criteria) this;
        }

        public Criteria andInvitSexRequireLessThan(Integer value) {
            addCriterion("invit_sex_require <", value, "invitSexRequire");
            return (Criteria) this;
        }

        public Criteria andInvitSexRequireLessThanOrEqualTo(Integer value) {
            addCriterion("invit_sex_require <=", value, "invitSexRequire");
            return (Criteria) this;
        }

        public Criteria andInvitSexRequireIn(List<Integer> values) {
            addCriterion("invit_sex_require in", values, "invitSexRequire");
            return (Criteria) this;
        }

        public Criteria andInvitSexRequireNotIn(List<Integer> values) {
            addCriterion("invit_sex_require not in", values, "invitSexRequire");
            return (Criteria) this;
        }

        public Criteria andInvitSexRequireBetween(Integer value1, Integer value2) {
            addCriterion("invit_sex_require between", value1, value2, "invitSexRequire");
            return (Criteria) this;
        }

        public Criteria andInvitSexRequireNotBetween(Integer value1, Integer value2) {
            addCriterion("invit_sex_require not between", value1, value2, "invitSexRequire");
            return (Criteria) this;
        }

        public Criteria andInvitTitleIsNull() {
            addCriterion("invit_title is null");
            return (Criteria) this;
        }

        public Criteria andInvitTitleIsNotNull() {
            addCriterion("invit_title is not null");
            return (Criteria) this;
        }

        public Criteria andInvitTitleEqualTo(String value) {
            addCriterion("invit_title =", value, "invitTitle");
            return (Criteria) this;
        }

        public Criteria andInvitTitleNotEqualTo(String value) {
            addCriterion("invit_title <>", value, "invitTitle");
            return (Criteria) this;
        }

        public Criteria andInvitTitleGreaterThan(String value) {
            addCriterion("invit_title >", value, "invitTitle");
            return (Criteria) this;
        }

        public Criteria andInvitTitleGreaterThanOrEqualTo(String value) {
            addCriterion("invit_title >=", value, "invitTitle");
            return (Criteria) this;
        }

        public Criteria andInvitTitleLessThan(String value) {
            addCriterion("invit_title <", value, "invitTitle");
            return (Criteria) this;
        }

        public Criteria andInvitTitleLessThanOrEqualTo(String value) {
            addCriterion("invit_title <=", value, "invitTitle");
            return (Criteria) this;
        }

        public Criteria andInvitTitleLike(String value) {
            addCriterion("invit_title like", value, "invitTitle");
            return (Criteria) this;
        }

        public Criteria andInvitTitleNotLike(String value) {
            addCriterion("invit_title not like", value, "invitTitle");
            return (Criteria) this;
        }

        public Criteria andInvitTitleIn(List<String> values) {
            addCriterion("invit_title in", values, "invitTitle");
            return (Criteria) this;
        }

        public Criteria andInvitTitleNotIn(List<String> values) {
            addCriterion("invit_title not in", values, "invitTitle");
            return (Criteria) this;
        }

        public Criteria andInvitTitleBetween(String value1, String value2) {
            addCriterion("invit_title between", value1, value2, "invitTitle");
            return (Criteria) this;
        }

        public Criteria andInvitTitleNotBetween(String value1, String value2) {
            addCriterion("invit_title not between", value1, value2, "invitTitle");
            return (Criteria) this;
        }

        public Criteria andInvitContentIsNull() {
            addCriterion("invit_content is null");
            return (Criteria) this;
        }

        public Criteria andInvitContentIsNotNull() {
            addCriterion("invit_content is not null");
            return (Criteria) this;
        }

        public Criteria andInvitContentEqualTo(String value) {
            addCriterion("invit_content =", value, "invitContent");
            return (Criteria) this;
        }

        public Criteria andInvitContentNotEqualTo(String value) {
            addCriterion("invit_content <>", value, "invitContent");
            return (Criteria) this;
        }

        public Criteria andInvitContentGreaterThan(String value) {
            addCriterion("invit_content >", value, "invitContent");
            return (Criteria) this;
        }

        public Criteria andInvitContentGreaterThanOrEqualTo(String value) {
            addCriterion("invit_content >=", value, "invitContent");
            return (Criteria) this;
        }

        public Criteria andInvitContentLessThan(String value) {
            addCriterion("invit_content <", value, "invitContent");
            return (Criteria) this;
        }

        public Criteria andInvitContentLessThanOrEqualTo(String value) {
            addCriterion("invit_content <=", value, "invitContent");
            return (Criteria) this;
        }

        public Criteria andInvitContentLike(String value) {
            addCriterion("invit_content like", value, "invitContent");
            return (Criteria) this;
        }

        public Criteria andInvitContentNotLike(String value) {
            addCriterion("invit_content not like", value, "invitContent");
            return (Criteria) this;
        }

        public Criteria andInvitContentIn(List<String> values) {
            addCriterion("invit_content in", values, "invitContent");
            return (Criteria) this;
        }

        public Criteria andInvitContentNotIn(List<String> values) {
            addCriterion("invit_content not in", values, "invitContent");
            return (Criteria) this;
        }

        public Criteria andInvitContentBetween(String value1, String value2) {
            addCriterion("invit_content between", value1, value2, "invitContent");
            return (Criteria) this;
        }

        public Criteria andInvitContentNotBetween(String value1, String value2) {
            addCriterion("invit_content not between", value1, value2, "invitContent");
            return (Criteria) this;
        }

        public Criteria andInvitHiddenIsNull() {
            addCriterion("invit_hidden is null");
            return (Criteria) this;
        }

        public Criteria andInvitHiddenIsNotNull() {
            addCriterion("invit_hidden is not null");
            return (Criteria) this;
        }

        public Criteria andInvitHiddenEqualTo(Boolean value) {
            addCriterion("invit_hidden =", value, "invitHidden");
            return (Criteria) this;
        }

        public Criteria andInvitHiddenNotEqualTo(Boolean value) {
            addCriterion("invit_hidden <>", value, "invitHidden");
            return (Criteria) this;
        }

        public Criteria andInvitHiddenGreaterThan(Boolean value) {
            addCriterion("invit_hidden >", value, "invitHidden");
            return (Criteria) this;
        }

        public Criteria andInvitHiddenGreaterThanOrEqualTo(Boolean value) {
            addCriterion("invit_hidden >=", value, "invitHidden");
            return (Criteria) this;
        }

        public Criteria andInvitHiddenLessThan(Boolean value) {
            addCriterion("invit_hidden <", value, "invitHidden");
            return (Criteria) this;
        }

        public Criteria andInvitHiddenLessThanOrEqualTo(Boolean value) {
            addCriterion("invit_hidden <=", value, "invitHidden");
            return (Criteria) this;
        }

        public Criteria andInvitHiddenIn(List<Boolean> values) {
            addCriterion("invit_hidden in", values, "invitHidden");
            return (Criteria) this;
        }

        public Criteria andInvitHiddenNotIn(List<Boolean> values) {
            addCriterion("invit_hidden not in", values, "invitHidden");
            return (Criteria) this;
        }

        public Criteria andInvitHiddenBetween(Boolean value1, Boolean value2) {
            addCriterion("invit_hidden between", value1, value2, "invitHidden");
            return (Criteria) this;
        }

        public Criteria andInvitHiddenNotBetween(Boolean value1, Boolean value2) {
            addCriterion("invit_hidden not between", value1, value2, "invitHidden");
            return (Criteria) this;
        }

        public Criteria andInvitIsDeleteIsNull() {
            addCriterion("invit_is_delete is null");
            return (Criteria) this;
        }

        public Criteria andInvitIsDeleteIsNotNull() {
            addCriterion("invit_is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andInvitIsDeleteEqualTo(Boolean value) {
            addCriterion("invit_is_delete =", value, "invitIsDelete");
            return (Criteria) this;
        }

        public Criteria andInvitIsDeleteNotEqualTo(Boolean value) {
            addCriterion("invit_is_delete <>", value, "invitIsDelete");
            return (Criteria) this;
        }

        public Criteria andInvitIsDeleteGreaterThan(Boolean value) {
            addCriterion("invit_is_delete >", value, "invitIsDelete");
            return (Criteria) this;
        }

        public Criteria andInvitIsDeleteGreaterThanOrEqualTo(Boolean value) {
            addCriterion("invit_is_delete >=", value, "invitIsDelete");
            return (Criteria) this;
        }

        public Criteria andInvitIsDeleteLessThan(Boolean value) {
            addCriterion("invit_is_delete <", value, "invitIsDelete");
            return (Criteria) this;
        }

        public Criteria andInvitIsDeleteLessThanOrEqualTo(Boolean value) {
            addCriterion("invit_is_delete <=", value, "invitIsDelete");
            return (Criteria) this;
        }

        public Criteria andInvitIsDeleteIn(List<Boolean> values) {
            addCriterion("invit_is_delete in", values, "invitIsDelete");
            return (Criteria) this;
        }

        public Criteria andInvitIsDeleteNotIn(List<Boolean> values) {
            addCriterion("invit_is_delete not in", values, "invitIsDelete");
            return (Criteria) this;
        }

        public Criteria andInvitIsDeleteBetween(Boolean value1, Boolean value2) {
            addCriterion("invit_is_delete between", value1, value2, "invitIsDelete");
            return (Criteria) this;
        }

        public Criteria andInvitIsDeleteNotBetween(Boolean value1, Boolean value2) {
            addCriterion("invit_is_delete not between", value1, value2, "invitIsDelete");
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