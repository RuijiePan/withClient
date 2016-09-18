package auto.newsky.coding.po;

/**
 * Created by prj on 2016/9/18.
 */

public class ConcernUserListData {


    /**
     * isConcerned : true
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private boolean isConcerned;

        public boolean isIsConcerned() {
            return isConcerned;
        }

        public void setIsConcerned(boolean isConcerned) {
            this.isConcerned = isConcerned;
        }
    }
}
