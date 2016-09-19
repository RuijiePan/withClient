package auto.newsky.coding.resultdata;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by prj on 2016/9/18.
 */

public class LoginData {

    /**
     * sex : 男
     * phone : 18318744486
     * unReadedNumber : 8
     * nickName : 安道尔
     * token : dsdsadsadasa
     * userUrl : http://img4.hao123.com/data/1_901e41dcffca28d765bc95ef81ed1913_0
     * studentID : 201324133111
     * userId : 1
     * class : 13软件工程一班
     * realName : 杰哥
     * qq : 270949894
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private Integer sex;
        private String phone;
        private int unReadedNumber;
        private String nickName;
        private String token;
        private String userUrl;
        private String studentID;
        private int userId;
        @JsonProperty("class")
        private String classX;
        private String realName;
        private String qq;


        public Integer getSex() {
            return sex;
        }

        public void setSex(Integer sex) {
            this.sex = sex;
        }

        public int getUnReadedNumber() {
            return unReadedNumber;
        }

        public void setUnReadedNumber(int unReadedNumber) {
            this.unReadedNumber = unReadedNumber;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getUserUrl() {
            return userUrl;
        }

        public void setUserUrl(String userUrl) {
            this.userUrl = userUrl;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getStudentID() {
            return studentID;
        }

        public void setStudentID(String studentID) {
            this.studentID = studentID;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getClassX() {
            return classX;
        }

        public void setClassX(String classX) {
            this.classX = classX;
        }

        public String getRealName() {
            return realName;
        }

        public void setRealName(String realName) {
            this.realName = realName;
        }

        public String getQq() {
            return qq;
        }

        public void setQq(String qq) {
            this.qq = qq;
        }

        public DataBean(Integer sex, String phone, int unReadedNumber, String nickName, String token, String userUrl, String studentID, int userId, String classX, String realName, String qq) {
            this.sex = sex;
            this.phone = phone;
            this.unReadedNumber = unReadedNumber;
            this.nickName = nickName;
            this.token = token;
            this.userUrl = userUrl;
            this.studentID = studentID;
            this.userId = userId;
            this.classX = classX;
            this.realName = realName;
            this.qq = qq;
        }
    }

    public LoginData(DataBean data) {
        this.data = data;
    }
}
