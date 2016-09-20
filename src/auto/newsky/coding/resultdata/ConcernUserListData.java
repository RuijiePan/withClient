package auto.newsky.coding.resultdata;

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

        private boolean isConcerned;

        private String name;

        private String headUrl;


        public void setConcernedUserId(int concernedUserId){
            this.concernedUserId = concernedUserId;
        }
        public int getConcernedUserId(){
            return this.concernedUserId;
        }
        public void setIsConcerned(boolean isConcerned){
            this.isConcerned = isConcerned;
        }
        public boolean getIsConcerned(){
            return this.isConcerned;
        }
        public void setName(String name){
            this.name = name;
        }
        public String getName(){
            return this.name;
        }
        public void setHeadUrl(String headUrl){
            this.headUrl = headUrl;
        }
        public String getHeadUrl(){
            return this.headUrl;
        }
    }
}
