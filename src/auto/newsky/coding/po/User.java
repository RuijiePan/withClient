package auto.newsky.coding.po;

public class User {
    private Integer userId;

    private String userNickname;

    private String userPassword;

    private String userStudentid;

    private String userRealname;

    private Integer userSex;

    private String userMobilephone;

    private String userHeadurl;

    private String userQq;

    private String userToken;

    private Boolean userIsDelete;

    private String userClass;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname == null ? null : userNickname.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserStudentid() {
        return userStudentid;
    }

    public void setUserStudentid(String userStudentid) {
        this.userStudentid = userStudentid == null ? null : userStudentid.trim();
    }

    public String getUserRealname() {
        return userRealname;
    }

    public void setUserRealname(String userRealname) {
        this.userRealname = userRealname == null ? null : userRealname.trim();
    }

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    public String getUserMobilephone() {
        return userMobilephone;
    }

    public void setUserMobilephone(String userMobilephone) {
        this.userMobilephone = userMobilephone == null ? null : userMobilephone.trim();
    }

    public String getUserHeadurl() {
        return userHeadurl;
    }

    public void setUserHeadurl(String userHeadurl) {
        this.userHeadurl = userHeadurl == null ? null : userHeadurl.trim();
    }

    public String getUserQq() {
        return userQq;
    }

    public void setUserQq(String userQq) {
        this.userQq = userQq == null ? null : userQq.trim();
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken == null ? null : userToken.trim();
    }

    public Boolean getUserIsDelete() {
        return userIsDelete;
    }

    public void setUserIsDelete(Boolean userIsDelete) {
        this.userIsDelete = userIsDelete;
    }

    public String getUserClass() {
        return userClass;
    }

    public void setUserClass(String userClass) {
        this.userClass = userClass == null ? null : userClass.trim();
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userNickname='" + userNickname + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userStudentid='" + userStudentid + '\'' +
                ", userRealname='" + userRealname + '\'' +
                ", userSex=" + userSex +
                ", userMobilephone='" + userMobilephone + '\'' +
                ", userHeadurl='" + userHeadurl + '\'' +
                ", userQq='" + userQq + '\'' +
                ", userToken='" + userToken + '\'' +
                ", userIsDelete=" + userIsDelete +
                ", userClass='" + userClass + '\'' +
                '}';
    }
}