package auto.newsky.coding.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MessageExample() {
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

        public Criteria andMsgIdIsNull() {
            addCriterion("msg_id is null");
            return (Criteria) this;
        }

        public Criteria andMsgIdIsNotNull() {
            addCriterion("msg_id is not null");
            return (Criteria) this;
        }

        public Criteria andMsgIdEqualTo(Integer value) {
            addCriterion("msg_id =", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdNotEqualTo(Integer value) {
            addCriterion("msg_id <>", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdGreaterThan(Integer value) {
            addCriterion("msg_id >", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("msg_id >=", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdLessThan(Integer value) {
            addCriterion("msg_id <", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdLessThanOrEqualTo(Integer value) {
            addCriterion("msg_id <=", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdIn(List<Integer> values) {
            addCriterion("msg_id in", values, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdNotIn(List<Integer> values) {
            addCriterion("msg_id not in", values, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdBetween(Integer value1, Integer value2) {
            addCriterion("msg_id between", value1, value2, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdNotBetween(Integer value1, Integer value2) {
            addCriterion("msg_id not between", value1, value2, "msgId");
            return (Criteria) this;
        }

        public Criteria andFromUserIdIsNull() {
            addCriterion("from_user_id is null");
            return (Criteria) this;
        }

        public Criteria andFromUserIdIsNotNull() {
            addCriterion("from_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andFromUserIdEqualTo(Integer value) {
            addCriterion("from_user_id =", value, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andFromUserIdNotEqualTo(Integer value) {
            addCriterion("from_user_id <>", value, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andFromUserIdGreaterThan(Integer value) {
            addCriterion("from_user_id >", value, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andFromUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("from_user_id >=", value, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andFromUserIdLessThan(Integer value) {
            addCriterion("from_user_id <", value, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andFromUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("from_user_id <=", value, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andFromUserIdIn(List<Integer> values) {
            addCriterion("from_user_id in", values, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andFromUserIdNotIn(List<Integer> values) {
            addCriterion("from_user_id not in", values, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andFromUserIdBetween(Integer value1, Integer value2) {
            addCriterion("from_user_id between", value1, value2, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andFromUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("from_user_id not between", value1, value2, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andToUserIdIsNull() {
            addCriterion("to_user_id is null");
            return (Criteria) this;
        }

        public Criteria andToUserIdIsNotNull() {
            addCriterion("to_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andToUserIdEqualTo(Integer value) {
            addCriterion("to_user_id =", value, "toUserId");
            return (Criteria) this;
        }

        public Criteria andToUserIdNotEqualTo(Integer value) {
            addCriterion("to_user_id <>", value, "toUserId");
            return (Criteria) this;
        }

        public Criteria andToUserIdGreaterThan(Integer value) {
            addCriterion("to_user_id >", value, "toUserId");
            return (Criteria) this;
        }

        public Criteria andToUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("to_user_id >=", value, "toUserId");
            return (Criteria) this;
        }

        public Criteria andToUserIdLessThan(Integer value) {
            addCriterion("to_user_id <", value, "toUserId");
            return (Criteria) this;
        }

        public Criteria andToUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("to_user_id <=", value, "toUserId");
            return (Criteria) this;
        }

        public Criteria andToUserIdIn(List<Integer> values) {
            addCriterion("to_user_id in", values, "toUserId");
            return (Criteria) this;
        }

        public Criteria andToUserIdNotIn(List<Integer> values) {
            addCriterion("to_user_id not in", values, "toUserId");
            return (Criteria) this;
        }

        public Criteria andToUserIdBetween(Integer value1, Integer value2) {
            addCriterion("to_user_id between", value1, value2, "toUserId");
            return (Criteria) this;
        }

        public Criteria andToUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("to_user_id not between", value1, value2, "toUserId");
            return (Criteria) this;
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

        public Criteria andMsgTypeIsNull() {
            addCriterion("msg_type is null");
            return (Criteria) this;
        }

        public Criteria andMsgTypeIsNotNull() {
            addCriterion("msg_type is not null");
            return (Criteria) this;
        }

        public Criteria andMsgTypeEqualTo(Integer value) {
            addCriterion("msg_type =", value, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeNotEqualTo(Integer value) {
            addCriterion("msg_type <>", value, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeGreaterThan(Integer value) {
            addCriterion("msg_type >", value, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("msg_type >=", value, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeLessThan(Integer value) {
            addCriterion("msg_type <", value, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeLessThanOrEqualTo(Integer value) {
            addCriterion("msg_type <=", value, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeIn(List<Integer> values) {
            addCriterion("msg_type in", values, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeNotIn(List<Integer> values) {
            addCriterion("msg_type not in", values, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeBetween(Integer value1, Integer value2) {
            addCriterion("msg_type between", value1, value2, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("msg_type not between", value1, value2, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgSendTimeIsNull() {
            addCriterion("msg_send_time is null");
            return (Criteria) this;
        }

        public Criteria andMsgSendTimeIsNotNull() {
            addCriterion("msg_send_time is not null");
            return (Criteria) this;
        }

        public Criteria andMsgSendTimeEqualTo(Date value) {
            addCriterion("msg_send_time =", value, "msgSendTime");
            return (Criteria) this;
        }

        public Criteria andMsgSendTimeNotEqualTo(Date value) {
            addCriterion("msg_send_time <>", value, "msgSendTime");
            return (Criteria) this;
        }

        public Criteria andMsgSendTimeGreaterThan(Date value) {
            addCriterion("msg_send_time >", value, "msgSendTime");
            return (Criteria) this;
        }

        public Criteria andMsgSendTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("msg_send_time >=", value, "msgSendTime");
            return (Criteria) this;
        }

        public Criteria andMsgSendTimeLessThan(Date value) {
            addCriterion("msg_send_time <", value, "msgSendTime");
            return (Criteria) this;
        }

        public Criteria andMsgSendTimeLessThanOrEqualTo(Date value) {
            addCriterion("msg_send_time <=", value, "msgSendTime");
            return (Criteria) this;
        }

        public Criteria andMsgSendTimeIn(List<Date> values) {
            addCriterion("msg_send_time in", values, "msgSendTime");
            return (Criteria) this;
        }

        public Criteria andMsgSendTimeNotIn(List<Date> values) {
            addCriterion("msg_send_time not in", values, "msgSendTime");
            return (Criteria) this;
        }

        public Criteria andMsgSendTimeBetween(Date value1, Date value2) {
            addCriterion("msg_send_time between", value1, value2, "msgSendTime");
            return (Criteria) this;
        }

        public Criteria andMsgSendTimeNotBetween(Date value1, Date value2) {
            addCriterion("msg_send_time not between", value1, value2, "msgSendTime");
            return (Criteria) this;
        }

        public Criteria andMsgContentIsNull() {
            addCriterion("msg_content is null");
            return (Criteria) this;
        }

        public Criteria andMsgContentIsNotNull() {
            addCriterion("msg_content is not null");
            return (Criteria) this;
        }

        public Criteria andMsgContentEqualTo(String value) {
            addCriterion("msg_content =", value, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentNotEqualTo(String value) {
            addCriterion("msg_content <>", value, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentGreaterThan(String value) {
            addCriterion("msg_content >", value, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentGreaterThanOrEqualTo(String value) {
            addCriterion("msg_content >=", value, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentLessThan(String value) {
            addCriterion("msg_content <", value, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentLessThanOrEqualTo(String value) {
            addCriterion("msg_content <=", value, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentLike(String value) {
            addCriterion("msg_content like", value, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentNotLike(String value) {
            addCriterion("msg_content not like", value, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentIn(List<String> values) {
            addCriterion("msg_content in", values, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentNotIn(List<String> values) {
            addCriterion("msg_content not in", values, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentBetween(String value1, String value2) {
            addCriterion("msg_content between", value1, value2, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentNotBetween(String value1, String value2) {
            addCriterion("msg_content not between", value1, value2, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgIsReadIsNull() {
            addCriterion("msg_is_read is null");
            return (Criteria) this;
        }

        public Criteria andMsgIsReadIsNotNull() {
            addCriterion("msg_is_read is not null");
            return (Criteria) this;
        }

        public Criteria andMsgIsReadEqualTo(Boolean value) {
            addCriterion("msg_is_read =", value, "msgIsRead");
            return (Criteria) this;
        }

        public Criteria andMsgIsReadNotEqualTo(Boolean value) {
            addCriterion("msg_is_read <>", value, "msgIsRead");
            return (Criteria) this;
        }

        public Criteria andMsgIsReadGreaterThan(Boolean value) {
            addCriterion("msg_is_read >", value, "msgIsRead");
            return (Criteria) this;
        }

        public Criteria andMsgIsReadGreaterThanOrEqualTo(Boolean value) {
            addCriterion("msg_is_read >=", value, "msgIsRead");
            return (Criteria) this;
        }

        public Criteria andMsgIsReadLessThan(Boolean value) {
            addCriterion("msg_is_read <", value, "msgIsRead");
            return (Criteria) this;
        }

        public Criteria andMsgIsReadLessThanOrEqualTo(Boolean value) {
            addCriterion("msg_is_read <=", value, "msgIsRead");
            return (Criteria) this;
        }

        public Criteria andMsgIsReadIn(List<Boolean> values) {
            addCriterion("msg_is_read in", values, "msgIsRead");
            return (Criteria) this;
        }

        public Criteria andMsgIsReadNotIn(List<Boolean> values) {
            addCriterion("msg_is_read not in", values, "msgIsRead");
            return (Criteria) this;
        }

        public Criteria andMsgIsReadBetween(Boolean value1, Boolean value2) {
            addCriterion("msg_is_read between", value1, value2, "msgIsRead");
            return (Criteria) this;
        }

        public Criteria andMsgIsReadNotBetween(Boolean value1, Boolean value2) {
            addCriterion("msg_is_read not between", value1, value2, "msgIsRead");
            return (Criteria) this;
        }

        public Criteria andMsgIsDeleteIsNull() {
            addCriterion("msg_is_delete is null");
            return (Criteria) this;
        }

        public Criteria andMsgIsDeleteIsNotNull() {
            addCriterion("msg_is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andMsgIsDeleteEqualTo(Boolean value) {
            addCriterion("msg_is_delete =", value, "msgIsDelete");
            return (Criteria) this;
        }

        public Criteria andMsgIsDeleteNotEqualTo(Boolean value) {
            addCriterion("msg_is_delete <>", value, "msgIsDelete");
            return (Criteria) this;
        }

        public Criteria andMsgIsDeleteGreaterThan(Boolean value) {
            addCriterion("msg_is_delete >", value, "msgIsDelete");
            return (Criteria) this;
        }

        public Criteria andMsgIsDeleteGreaterThanOrEqualTo(Boolean value) {
            addCriterion("msg_is_delete >=", value, "msgIsDelete");
            return (Criteria) this;
        }

        public Criteria andMsgIsDeleteLessThan(Boolean value) {
            addCriterion("msg_is_delete <", value, "msgIsDelete");
            return (Criteria) this;
        }

        public Criteria andMsgIsDeleteLessThanOrEqualTo(Boolean value) {
            addCriterion("msg_is_delete <=", value, "msgIsDelete");
            return (Criteria) this;
        }

        public Criteria andMsgIsDeleteIn(List<Boolean> values) {
            addCriterion("msg_is_delete in", values, "msgIsDelete");
            return (Criteria) this;
        }

        public Criteria andMsgIsDeleteNotIn(List<Boolean> values) {
            addCriterion("msg_is_delete not in", values, "msgIsDelete");
            return (Criteria) this;
        }

        public Criteria andMsgIsDeleteBetween(Boolean value1, Boolean value2) {
            addCriterion("msg_is_delete between", value1, value2, "msgIsDelete");
            return (Criteria) this;
        }

        public Criteria andMsgIsDeleteNotBetween(Boolean value1, Boolean value2) {
            addCriterion("msg_is_delete not between", value1, value2, "msgIsDelete");
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