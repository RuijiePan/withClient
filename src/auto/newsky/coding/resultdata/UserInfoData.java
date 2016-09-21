package auto.newsky.coding.resultdata;

/**
 * Created by prj on 2016/9/18.
 */

public class UserInfoData {


    /**
     * phone : 15622625081
     * sex : 0
     * isConcerned : true
     * studentId : 201324133121
     * name : 吴一鸣
     * headUrl : headimg/head.png
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
        private String  phone;
        private int sex;
        private boolean isConcerned;
        private String studentId;
        private String name;
        private String headUrl;
        private String qq;

        public String getPhone() {
            return phone;
        }

        public boolean isConcerned() {
            return isConcerned;
        }

        public void setConcerned(boolean concerned) {
            isConcerned = concerned;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public boolean isIsConcerned() {
            return isConcerned;
        }

        public void setIsConcerned(boolean isConcerned) {
            this.isConcerned = isConcerned;
        }

        public String getStudentId() {
            return studentId;
        }

        public void setStudentId(String studentId) {
            this.studentId = studentId;
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

        public String getQq() {
            return qq;
        }

        public void setQq(String qq) {
            this.qq = qq;
        }
    }
}
