package auto.newsky.coding.po;

public class JoinInvitation {
    public JoinInvitation(Integer userId, Integer invitId, Boolean relationIsDelete) {
        this.userId = userId;
        this.invitId = invitId;
        this.relationIsDelete = relationIsDelete;
    }

    public JoinInvitation() {

    }


    public JoinInvitation(Integer relationId, Integer userId, Integer invitId, Boolean relationIsDelete) {
        this.relationId = relationId;
        this.userId = userId;
        this.invitId = invitId;
        this.relationIsDelete = relationIsDelete;
    }

    private Integer relationId;

    private Integer userId;

    private Integer invitId;

    private Boolean relationIsDelete;

    public Integer getRelationId() {
        return relationId;
    }

    public void setRelationId(Integer relationId) {
        this.relationId = relationId;
    }

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

    public Boolean getRelationIsDelete() {
        return relationIsDelete;
    }

    public void setRelationIsDelete(Boolean relationIsDelete) {
        this.relationIsDelete = relationIsDelete;
    }

    @Override
    public String toString() {
        return "JoinInvitation{" +
                "relationId=" + relationId +
                ", userId=" + userId +
                ", invitId=" + invitId +
                ", relationIsDelete=" + relationIsDelete +
                '}';
    }
}