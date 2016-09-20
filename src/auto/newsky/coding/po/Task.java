package auto.newsky.coding.po;

public class Task {
    private Integer taskId;
    public Task() {}
    private Integer userId;

    private String taskContent;

    private String taskTitle;

    private Boolean taskIsDelete;

    private Integer taskIconType;

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTaskContent() {
        return taskContent;
    }

    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent == null ? null : taskContent.trim();
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle == null ? null : taskTitle.trim();
    }

    public Boolean getTaskIsDelete() {
        return taskIsDelete;
    }

    public void setTaskIsDelete(Boolean taskIsDelete) {
        this.taskIsDelete = taskIsDelete;
    }

    public Integer getTaskIconType() {
        return taskIconType;
    }

    public void setTaskIconType(Integer taskIconType) {
        this.taskIconType = taskIconType;
    }
}