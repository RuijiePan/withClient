package auto.newsky.coding.po;

import java.util.Date;

public class Journal {
    private Integer jourId;
    public Journal() {}
    private Integer taskId;

    private Date jourDate;

    private String jourSummary;

    private Boolean jourPunch;

    private Boolean jourIsDelete;

    public Integer getJourId() {
        return jourId;
    }

    public void setJourId(Integer jourId) {
        this.jourId = jourId;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Date getJourDate() {
        return jourDate;
    }

    public void setJourDate(Date jourDate) {
        this.jourDate = jourDate;
    }

    public String getJourSummary() {
        return jourSummary;
    }

    public void setJourSummary(String jourSummary) {
        this.jourSummary = jourSummary == null ? null : jourSummary.trim();
    }

    public Boolean getJourPunch() {
        return jourPunch;
    }

    public void setJourPunch(Boolean jourPunch) {
        this.jourPunch = jourPunch;
    }

    public Boolean getJourIsDelete() {
        return jourIsDelete;
    }

    public void setJourIsDelete(Boolean jourIsDelete) {
        this.jourIsDelete = jourIsDelete;
    }
}