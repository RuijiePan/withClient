package auto.newsky.coding.po;

public class UserJoinInvitation {
    private Integer userId;

    private Integer invitId;

    private Integer relationIsDelete;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getInvitId() {
        return invitId;
    }

    public void setInvitId(Integer invitId) {
        this.invitId = invitId;
    }

    public Integer getRelationIsDelete() {
        return relationIsDelete;
    }

    public void setRelationIsDelete(Integer relationIsDelete) {
        this.relationIsDelete = relationIsDelete;
    }
}