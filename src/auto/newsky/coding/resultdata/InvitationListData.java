package auto.newsky.coding.resultdata;

import java.util.List;

/**
 * Created by prj on 2016/9/18.
 */

public class InvitationListData {


    /**
     * originatorHeadUrl : image/head.png
     * menbersUrl : image/head1.png,image/head2.png
     * invitationTime : 2016-9-8 19:33
     * publishTime : 2016-9-8 19:33
     * originatorNickname : 阿道克
     * iconUrl : icon/icon1.png
     * invitaionId : 1
     * currentNumber : 2
     * sexRequire : 只要女生
     * content : 我们将迎来本学期一场狼人杀比赛
     * title : 狼人杀
     * totalNumber : 16
     * place : 中巴
     * members : [{"sex":"男","phone":1562261234,"userId":"1","realName":"潘大爷","headUrl":"image/head.png"}]
     * isJoin : true
     */

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String originatorHeadUrl;
        private String invitationTime;

        public Integer getSexRequire() {
            return sexRequire;
        }

        public boolean isJoin() {
            return isJoin;
        }

        public void setJoin(boolean join) {
            isJoin = join;
        }

        private String publishTime;
        private String originatorNickname;
        private Integer typeId;
        private int invitaionId;
        private int currentNumber;
        private Integer sexRequire;
        private String content;
        private String title;
        private int totalNumber;
        private String place;
        private boolean isJoin;
        /**
         * sex : 男
         * phone : 1562261234
         * userId : 1
         * realName : 潘大爷
         * headUrl : image/head.png
         */

        private List<MembersBean> members;

        public String getOriginatorHeadUrl() {
            return originatorHeadUrl;
        }

        public void setOriginatorHeadUrl(String originatorHeadUrl) {
            this.originatorHeadUrl = originatorHeadUrl;
        }


        public String getInvitationTime() {
            return invitationTime;
        }

        public void setInvitationTime(String invitationTime) {
            this.invitationTime = invitationTime;
        }

        public String getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(String publishTime) {
            this.publishTime = publishTime;
        }

        public String getOriginatorNickname() {
            return originatorNickname;
        }

        public void setOriginatorNickname(String originatorNickname) {
            this.originatorNickname = originatorNickname;
        }

        public Integer getTypeId() {
            return typeId;
        }

        public void setTypeId(Integer typeId) {
            this.typeId = typeId;
        }

        public int getInvitaionId() {
            return invitaionId;
        }

        public void setInvitaionId(int invitaionId) {
            this.invitaionId = invitaionId;
        }

        public int getCurrentNumber() {
            return currentNumber;
        }

        public void setCurrentNumber(int currentNumber) {
            this.currentNumber = currentNumber;
        }


        public void setSexRequire(Integer sexRequire) {
            this.sexRequire = sexRequire;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getTotalNumber() {
            return totalNumber;
        }

        public void setTotalNumber(int totalNumber) {
            this.totalNumber = totalNumber;
        }

        public String getPlace() {
            return place;
        }

        public void setPlace(String place) {
            this.place = place;
        }

        public boolean isIsJoin() {
            return isJoin;
        }

        public void setIsJoin(boolean isJoin) {
            this.isJoin = isJoin;
        }

        public List<MembersBean> getMembers() {
            return members;
        }

        public void setMembers(List<MembersBean> members) {
            this.members = members;
        }

        public static class MembersBean {
            private Integer sex;
            private String phone;
            private Integer userId;
            private String realName;
            private String headUrl;


            public Integer getSex() {
                return sex;
            }

            public void setSex(Integer sex) {
                this.sex = sex;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public Integer getUserId() {
                return userId;
            }

            public void setUserId(Integer userId) {
                this.userId = userId;
            }

            public String getRealName() {
                return realName;
            }

            public void setRealName(String realName) {
                this.realName = realName;
            }

            public String getHeadUrl() {
                return headUrl;
            }

            public void setHeadUrl(String headUrl) {
                this.headUrl = headUrl;
            }
        }
    }
}
