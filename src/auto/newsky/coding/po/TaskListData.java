package auto.newsky.coding.po;

import java.util.List;

/**
 * Created by prj on 2016/9/18.
 */

public class TaskListData {

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
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
}
