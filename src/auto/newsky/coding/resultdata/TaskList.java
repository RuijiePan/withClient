package auto.newsky.coding.resultdata;

import java.util.List;

/**
 * Created by prj on 2016/9/17.
 */

public class TaskList {

    public TaskList(List<CurrTasksBean> currTasks, List<PreTasksBean> preTasks) {
        this.currTasks = currTasks;
        this.preTasks = preTasks;
    }

    /**
     * content : 每天跑5公里
     * taskId : 1
     * title : xxxtitle
     * task_icon_type : 1
     */

    private List<CurrTasksBean> currTasks;
    /**
     * content : 背单词
     * taskId : 2
     * title : xxxtitle
     * task_icon_type : 2
     */

    private List<PreTasksBean> preTasks;

    public List<CurrTasksBean> getCurrTasks() {
        return currTasks;
    }

    public void setCurrTasks(List<CurrTasksBean> currTasks) {
        this.currTasks = currTasks;
    }

    public List<PreTasksBean> getPreTasks() {
        return preTasks;
    }

    public void setPreTasks(List<PreTasksBean> preTasks) {
        this.preTasks = preTasks;
    }

    public static class CurrTasksBean {

        public CurrTasksBean(String content, int taskId, String title, int task_icon_type) {
            this.content = content;
            this.taskId = taskId;
            this.title = title;
            this.task_icon_type = task_icon_type;
        }

        private String content;
        private int taskId;
        private String title;
        private int task_icon_type;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getTaskId() {
            return taskId;
        }

        public void setTaskId(int taskId) {
            this.taskId = taskId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getTask_icon_type() {
            return task_icon_type;
        }

        public void setTask_icon_type(int task_icon_type) {
            this.task_icon_type = task_icon_type;
        }
    }

    public static class PreTasksBean {

        public PreTasksBean(String content, int taskId, String title, int task_icon_type) {
            this.content = content;
            this.taskId = taskId;
            this.title = title;
            this.task_icon_type = task_icon_type;
        }

        private String content;
        private int taskId;
        private String title;
        private int task_icon_type;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getTaskId() {
            return taskId;
        }

        public void setTaskId(int taskId) {
            this.taskId = taskId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getTask_icon_type() {
            return task_icon_type;
        }

        public void setTask_icon_type(int task_icon_type) {
            this.task_icon_type = task_icon_type;
        }
    }
}
