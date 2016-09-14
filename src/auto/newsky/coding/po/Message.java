package auto.newsky.coding.po;

import java.util.Date;

public class Message {
    private Integer msgId;

    private Integer fromUserId;

    private Integer toUserId;

    private Integer invitId;

    private Integer msgType;

    private Date msgSendTime;

    private String msgContent;

    private Boolean msgIsRead;

    private Boolean msgIsDelete;

    public Integer getMsgId() {
        return msgId;
    }

    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
    }

    public Integer getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Integer fromUserId) {
        this.fromUserId = fromUserId;
    }

    public Integer getToUserId() {
        return toUserId;
    }

    public void setToUserId(Integer toUserId) {
        this.toUserId = toUserId;
    }

    public Integer getInvitId() {
        return invitId;
    }

    public void setInvitId(Integer invitId) {
        this.invitId = invitId;
    }

    public Integer getMsgType() {
        return msgType;
    }

    public void setMsgType(Integer msgType) {
        this.msgType = msgType;
    }

    public Date getMsgSendTime() {
        return msgSendTime;
    }

    public void setMsgSendTime(Date msgSendTime) {
        this.msgSendTime = msgSendTime;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent == null ? null : msgContent.trim();
    }

    public Boolean getMsgIsRead() {
        return msgIsRead;
    }

    public void setMsgIsRead(Boolean msgIsRead) {
        this.msgIsRead = msgIsRead;
    }

    public Boolean getMsgIsDelete() {
        return msgIsDelete;
    }

    public void setMsgIsDelete(Boolean msgIsDelete) {
        this.msgIsDelete = msgIsDelete;
    }
}