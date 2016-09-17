package auto.newsky.coding.po;

import java.util.Date;

public class Invatation {
    private Integer invitId;

    private Integer userId;

    private Date invitPublicationTime;

    private Date invitActivityTime;

    private String invitPlace;

    private Integer invitNumberMax;

    private Integer invitNumberCurr;

    private Integer invitSexRequire;

    private String invitTitle;

    private String invitContent;

    private Integer invitClass;

    private Integer invitType;

    private Boolean invitHidden;

    private Boolean invitIsDelete;

    public Invatation(Integer userId, Date invitPublicationTime, Date invitActivityTime, String invitPlace, Integer invitNumberMax, Integer invitNumberCurr, Integer invitSexRequire, String invitTitle, String invitContent, Integer invitClass, Integer invitType, Boolean invitHidden) {
        this.userId = userId;
        this.invitPublicationTime = invitPublicationTime;
        this.invitActivityTime = invitActivityTime;
        this.invitPlace = invitPlace;
        this.invitNumberMax = invitNumberMax;
        this.invitNumberCurr = invitNumberCurr;
        this.invitSexRequire = invitSexRequire;
        this.invitTitle = invitTitle;
        this.invitContent = invitContent;
        this.invitClass = invitClass;
        this.invitType = invitType;
        this.invitHidden = invitHidden;
    }

    public Integer getInvitId() {
        return invitId;
    }

    public void setInvitId(Integer invitId) {
        this.invitId = invitId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getInvitPublicationTime() {
        return invitPublicationTime;
    }

    public void setInvitPublicationTime(Date invitPublicationTime) {
        this.invitPublicationTime = invitPublicationTime;
    }

    public Date getInvitActivityTime() {
        return invitActivityTime;
    }

    public void setInvitActivityTime(Date invitActivityTime) {
        this.invitActivityTime = invitActivityTime;
    }

    public String getInvitPlace() {
        return invitPlace;
    }

    public void setInvitPlace(String invitPlace) {
        this.invitPlace = invitPlace == null ? null : invitPlace.trim();
    }

    public Integer getInvitNumberMax() {
        return invitNumberMax;
    }

    public void setInvitNumberMax(Integer invitNumberMax) {
        this.invitNumberMax = invitNumberMax;
    }

    public Integer getInvitNumberCurr() {
        return invitNumberCurr;
    }

    public void setInvitNumberCurr(Integer invitNumberCurr) {
        this.invitNumberCurr = invitNumberCurr;
    }

    public Integer getInvitSexRequire() {
        return invitSexRequire;
    }

    public void setInvitSexRequire(Integer invitSexRequire) {
        this.invitSexRequire = invitSexRequire;
    }

    public String getInvitTitle() {
        return invitTitle;
    }

    public void setInvitTitle(String invitTitle) {
        this.invitTitle = invitTitle == null ? null : invitTitle.trim();
    }

    public String getInvitContent() {
        return invitContent;
    }

    public void setInvitContent(String invitContent) {
        this.invitContent = invitContent == null ? null : invitContent.trim();
    }

    public Integer getInvitClass() {
        return invitClass;
    }

    public void setInvitClass(Integer invitClass) {
        this.invitClass = invitClass;
    }

    public Integer getInvitType() {
        return invitType;
    }

    public void setInvitType(Integer invitType) {
        this.invitType = invitType;
    }

    public Boolean getInvitHidden() {
        return invitHidden;
    }

    public void setInvitHidden(Boolean invitHidden) {
        this.invitHidden = invitHidden;
    }

    public Boolean getInvitIsDelete() {
        return invitIsDelete;
    }

    public void setInvitIsDelete(Boolean invitIsDelete) {
        this.invitIsDelete = invitIsDelete;
    }
}