package auto.newsky.coding.resultdata;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

/**
 * Created by prj on 2016/9/18.
 */

public class ConcernUserListData {


    /**
     * isConcerned : true
     */

    private List<DataBean> data ;

    public void setData(List<DataBean> data){
        this.data = data;
    }
    public List<DataBean> getData(){
        return this.data;
    }

    public static class DataBean {


        private int concernedUserId;

        private String headUrl;

        private boolean concerned;


        public boolean isConcerned() {
            return concerned;
        }

        public void setConcerned(boolean concerned) {
            this.concerned = concerned;
        }

        private String name;

        private String summary = "summary";

        public int getConcernedUserId() {
            return concernedUserId;
        }

        public void setConcernedUserId(int concernedUserId) {
            this.concernedUserId = concernedUserId;
        }

        public String getHeadUrl() {
            return headUrl;
        }

        public void setHeadUrl(String headUrl) {
            this.headUrl = headUrl;
        }


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }
    }
}
