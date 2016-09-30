package auto.newsky.coding.resultdata;



import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

/**
 * Created by Administrator on 2016/9/17.
 */
public class InvitationData {

    private List<Data> data;
    private int code;
    private String msg;
    public void setData(List<Data> data) {
        this.data = data;
    }
    public List<Data> getData() {
        return data;
    }

    public void setCode(int code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    public String getMsg() {
        return msg;
    }

    static class Members {

        private String sex;
        private int phone;
        private String userid;
        private String realname;
        private String headurl;
        public void setSex(String sex) {
            this.sex = sex;
        }
        public String getSex() {
            return sex;
        }

        public void setPhone(int phone) {
            this.phone = phone;
        }
        public int getPhone() {
            return phone;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }
        public String getUserid() {
            return userid;
        }

        public void setRealname(String realname) {
            this.realname = realname;
        }
        public String getRealname() {
            return realname;
        }

        public void setHeadurl(String headurl) {
            this.headurl = headurl;
        }
        public String getHeadurl() {
            return headurl;
        }

    }

    public class Data {

        @JsonProperty("originatorHeadUrl")
        private String originatorheadurl;
        @JsonProperty("menbersUrl")
        private String menbersurl;
        @JsonProperty("invitationTime")
        private String invitationtime;
        @JsonProperty("publishTime")
        private String publishtime;
        @JsonProperty("originatorNickname")
        private String originatornickname;
        @JsonProperty("iconUrl")
        private String iconurl;
        @JsonProperty("invitaionId")
        private int invitaionid;
        @JsonProperty("currentNumber")
        private int currentnumber;
        @JsonProperty("sexRequire")
        private String sexrequire;
        private String content;
        private String title;
        @JsonProperty("totalNumber")
        private int totalnumber;
        private String place;
        private List<Members> members;
        @JsonProperty("isJoin")
        private boolean isjoin;
        public void setOriginatorheadurl(String originatorheadurl) {
            this.originatorheadurl = originatorheadurl;
        }
        public String getOriginatorheadurl() {
            return originatorheadurl;
        }

        public void setMenbersurl(String menbersurl) {
            this.menbersurl = menbersurl;
        }
        public String getMenbersurl() {
            return menbersurl;
        }

        public void setInvitationtime(String invitationtime) {
            this.invitationtime = invitationtime;
        }
        public String getInvitationtime() {
            return invitationtime;
        }

        public void setPublishtime(String publishtime) {
            this.publishtime = publishtime;
        }
        public String getPublishtime() {
            return publishtime;
        }

        public void setOriginatornickname(String originatornickname) {
            this.originatornickname = originatornickname;
        }
        public String getOriginatornickname() {
            return originatornickname;
        }

        public void setIconurl(String iconurl) {
            this.iconurl = iconurl;
        }
        public String getIconurl() {
            return iconurl;
        }

        public void setInvitaionid(int invitaionid) {
            this.invitaionid = invitaionid;
        }
        public int getInvitaionid() {
            return invitaionid;
        }

        public void setCurrentnumber(int currentnumber) {
            this.currentnumber = currentnumber;
        }
        public int getCurrentnumber() {
            return currentnumber;
        }

        public void setSexrequire(String sexrequire) {
            this.sexrequire = sexrequire;
        }
        public String getSexrequire() {
            return sexrequire;
        }

        public void setContent(String content) {
            this.content = content;
        }
        public String getContent() {
            return content;
        }

        public void setTitle(String title) {
            this.title = title;
        }
        public String getTitle() {
            return title;
        }

        public void setTotalnumber(int totalnumber) {
            this.totalnumber = totalnumber;
        }
        public int getTotalnumber() {
            return totalnumber;
        }

        public void setPlace(String place) {
            this.place = place;
        }
        public String getPlace() {
            return place;
        }

        public void setMembers(List<Members> members) {
            this.members = members;
        }
        public List<Members> getMembers() {
            return members;
        }

        public void setIsjoin(boolean isjoin) {
            this.isjoin = isjoin;
        }
        public boolean getIsjoin() {
            return isjoin;
        }

    }

}
