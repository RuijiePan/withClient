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

        private String content;
        private int typeId;

        private int currentNumber;

        private String iconUrl;

        private int invitaionId;

        private String invitationTime;

        private boolean isJoin;

        private List<MembersBean> members ;

        private String originatorHeadUrl;

        private String originatorNickname;

        private String place;

        private String publishTime;

        private Integer sexRequire;

        private String title;

        private int totalNumber;

        public int getTypeId() {
            return typeId;
        }

        public void setTypeId(int typeId) {
            this.typeId = typeId;
        }

        public void setContent(String content){
            this.content = content;
        }
        public String getContent(){
            return this.content;
        }
        public void setCurrentNumber(int currentNumber){
            this.currentNumber = currentNumber;
        }
        public int getCurrentNumber(){
            return this.currentNumber;
        }
        public void setIconUrl(String iconUrl){
            this.iconUrl = iconUrl;
        }
        public String getIconUrl(){
            return this.iconUrl;
        }
        public void setInvitaionId(int invitaionId){
            this.invitaionId = invitaionId;
        }
        public int getInvitaionId(){
            return this.invitaionId;
        }
        public void setInvitationTime(String invitationTime){
            this.invitationTime = invitationTime;
        }
        public String getInvitationTime(){
            return this.invitationTime;
        }
        public void setIsJoin(boolean isJoin){
            this.isJoin = isJoin;
        }
        public boolean getIsJoin(){
            return this.isJoin;
        }
        public void setMembers(List<MembersBean> members){
            this.members = members;
        }
        public List<MembersBean> getMembers(){
            return this.members;
        }
        public void setOriginatorHeadUrl(String originatorHeadUrl){
            this.originatorHeadUrl = originatorHeadUrl;
        }
        public String getOriginatorHeadUrl(){
            return this.originatorHeadUrl;
        }
        public void setOriginatorNickname(String originatorNickname){
            this.originatorNickname = originatorNickname;
        }
        public String getOriginatorNickname(){
            return this.originatorNickname;
        }
        public void setPlace(String place){
            this.place = place;
        }
        public String getPlace(){
            return this.place;
        }
        public void setPublishTime(String publishTime){
            this.publishTime = publishTime;
        }
        public String getPublishTime(){
            return this.publishTime;
        }

        public boolean isJoin() {
            return isJoin;
        }

        public void setJoin(boolean join) {
            isJoin = join;
        }

        public Integer getSexRequire() {
            return sexRequire;
        }

        public void setSexRequire(Integer sexRequire) {
            this.sexRequire = sexRequire;
        }

        public void setTitle(String title){
            this.title = title;
        }
        public String getTitle(){
            return this.title;
        }
        public void setTotalNumber(int totalNumber){
            this.totalNumber = totalNumber;
        }
        public int getTotalNumber(){
            return this.totalNumber;
        }


        public static class MembersBean {
            private String headUrl;

            private String phone;

            private String realName;

            private Integer sex;

            private int userId;

            public void setHeadUrl(String headUrl){
                this.headUrl = headUrl;
            }
            public String getHeadUrl(){
                return this.headUrl;
            }

            public void setRealName(String realName){
                this.realName = realName;
            }
            public String getRealName(){
                return this.realName;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public Integer getSex() {
                return sex;
            }

            public void setSex(Integer sex) {
                this.sex = sex;
            }

            public void setUserId(int userId){
                this.userId = userId;
            }
            public int getUserId(){
                return this.userId;
            }
        }
    }
}
