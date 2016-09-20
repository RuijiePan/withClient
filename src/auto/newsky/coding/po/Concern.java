package auto.newsky.coding.po;

public class Concern {

    public Concern() {

    }

    public Concern(Integer conFromUserId, Integer conToUserId, Boolean conIsConcern) {
        this.conFromUserId = conFromUserId;
        this.conToUserId = conToUserId;
        this.conIsConcern = conIsConcern;
    }
    private Integer conId;

    private Integer conFromUserId;

    private Integer conToUserId;

    private Boolean conIsConcern;

    public Integer getConId() {
        return conId;
    }

    public void setConId(Integer conId) {
        this.conId = conId;
    }

    public Integer getConFromUserId() {
        return conFromUserId;
    }

    public void setConFromUserId(Integer conFromUserId) {
        this.conFromUserId = conFromUserId;
    }

    public Integer getConToUserId() {
        return conToUserId;
    }

    public void setConToUserId(Integer conToUserId) {
        this.conToUserId = conToUserId;
    }

    public Boolean getConIsConcern() {
        return conIsConcern;
    }

    public void setConIsConcern(Boolean conIsConcern) {
        this.conIsConcern = conIsConcern;
    }
}