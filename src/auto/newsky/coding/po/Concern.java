package auto.newsky.coding.po;

public class Concern {
    private Integer conFromUserId;

    private Integer conToUserId;

    private Boolean conIsConcern;

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