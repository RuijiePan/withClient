package auto.newsky.coding.resultdata;

import java.util.List;

/**
 * Created by prj on 2016/9/18.
 */

public class MessageListData {


    /**
     * readed : true
     * invationId : 2
     * invitationTotalNumber : 10
     * invitationTime : 2016-9-12 16:40
     * sendTime : 2016-9-10 22:30
     * invitationCurrNumber : 8
     * messageType : 1
     * content : 取消活动
     * applyUserId : 2
     * invitationTitle : 接师妹
     * name : 吴一鸣
     * headUrl : headimg/head.png
     * messageId : 1
     * invitationPlace : 青年广场
     */

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private boolean readed;
        private int invationId;
        private int invitationTotalNumber;
        private String invitationTime;
        private String sendTime;
        private int invitationCurrNumber;
        private int messageType;
        private String content;
        private int applyUserId;
        private String invitationTitle;
        private String name;
        private String headUrl;
        private int messageId;
        private String invitationPlace;

        public boolean isReaded() {
            return readed;
        }

        public void setReaded(boolean readed) {
            this.readed = readed;
        }

        public int getInvationId() {
            return invationId;
        }

        public void setInvationId(int invationId) {
            this.invationId = invationId;
        }

        public int getInvitationTotalNumber() {
            return invitationTotalNumber;
        }

        public void setInvitationTotalNumber(int invitationTotalNumber) {
            this.invitationTotalNumber = invitationTotalNumber;
        }

        public String getInvitationTime() {
            return invitationTime;
        }

        public void setInvitationTime(String invitationTime) {
            this.invitationTime = invitationTime;
        }

        public String getSendTime() {
            return sendTime;
        }

        public void setSendTime(String sendTime) {
            this.sendTime = sendTime;
        }

        public int getInvitationCurrNumber() {
            return invitationCurrNumber;
        }

        public void setInvitationCurrNumber(int invitationCurrNumber) {
            this.invitationCurrNumber = invitationCurrNumber;
        }

        public int getMessageType() {
            return messageType;
        }

        public void setMessageType(int messageType) {
            this.messageType = messageType;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getApplyUserId() {
            return applyUserId;
        }

        public void setApplyUserId(int applyUserId) {
            this.applyUserId = applyUserId;
        }

        public String getInvitationTitle() {
            return invitationTitle;
        }

        public void setInvitationTitle(String invitationTitle) {
            this.invitationTitle = invitationTitle;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getHeadUrl() {
            return headUrl;
        }

        public void setHeadUrl(String headUrl) {
            this.headUrl = headUrl;
        }

        public int getMessageId() {
            return messageId;
        }

        public void setMessageId(int messageId) {
            this.messageId = messageId;
        }

        public String getInvitationPlace() {
            return invitationPlace;
        }

        public void setInvitationPlace(String invitationPlace) {
            this.invitationPlace = invitationPlace;
        }

        public DataBean(boolean readed, int invationId, int invitationTotalNumber,
                        String invitationTime, String sendTime, int invitationCurrNumber,
                        int messageType, String content, int applyUserId,
                        String invitationTitle, String name, String headUrl,
                        int messageId, String invitationPlace) {
            this.readed = readed;
            this.invationId = invationId;
            this.invitationTotalNumber = invitationTotalNumber;
            this.invitationTime = invitationTime;
            this.sendTime = sendTime;
            this.invitationCurrNumber = invitationCurrNumber;
            this.messageType = messageType;
            this.content = content;
            this.applyUserId = applyUserId;
            this.invitationTitle = invitationTitle;
            this.name = name;
            this.headUrl = headUrl;
            this.messageId = messageId;
            this.invitationPlace = invitationPlace;
        }
    }
}
