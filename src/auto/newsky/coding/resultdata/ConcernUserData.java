package auto.newsky.coding.resultdata;

/**
 * Created by prj on 2016/9/18.
 */

public class ConcernUserData {

    /**
     * isConcerned : fasle
     */

    private boolean isConcerned;


    public ConcernUserData() {

    }

    public ConcernUserData(boolean isConcerned) {
        this.isConcerned = isConcerned;
    }

    public boolean isConcerned() {
        return isConcerned;
    }

    public void setConcerned(boolean concerned) {
        isConcerned = concerned;
    }
}
