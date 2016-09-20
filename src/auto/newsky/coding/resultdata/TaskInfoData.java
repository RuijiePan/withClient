package auto.newsky.coding.resultdata;

import java.util.List;

/**
 * Created by prj on 2016/9/18.
 */

public class TaskInfoData {


    /**
     * task : {"taskId":1,"teskContent":"每天早上6点读30分钟","teskTitle":"背英语单词"}
     * calendar : [{"remark":"今天头疼，没背","jour_punch":true,"day":1}]
     */

        public TaskInfoData(TaskBean task, List<CalendarBean> calendar) {
            this.task = task;
            this.calendar = calendar;
        }

        /**
         * taskId : 1
         * teskContent : 每天早上6点读30分钟
         * teskTitle : 背英语单词
         */


        private TaskBean task;
        /**
         * remark : 今天头疼，没背
         * jour_punch : true
         * day : 1
         */

        private List<CalendarBean> calendar;

        public TaskBean getTask() {
            return task;
        }

        public void setTask(TaskBean task) {
            this.task = task;
        }

        public List<CalendarBean> getCalendar() {
            return calendar;
        }

        public void setCalendar(List<CalendarBean> calendar) {
            this.calendar = calendar;
        }

        public static class TaskBean {
            private int taskId;
            private String teskContent;
            private String teskTitle;

            public int getTaskId() {
                return taskId;
            }

            public void setTaskId(int taskId) {
                this.taskId = taskId;
            }

            public String getTeskContent() {
                return teskContent;
            }

            public void setTeskContent(String teskContent) {
                this.teskContent = teskContent;
            }

            public String getTeskTitle() {
                return teskTitle;
            }

            public void setTeskTitle(String teskTitle) {
                this.teskTitle = teskTitle;
            }

            public TaskBean(int taskId, String teskContent, String teskTitle) {
                this.taskId = taskId;
                this.teskContent = teskContent;
                this.teskTitle = teskTitle;
            }
        }

        public static class CalendarBean {
            private String remark;
            private boolean jour_punch;
            private int day;

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public boolean isJour_punch() {
                return jour_punch;
            }

            public void setJour_punch(boolean jour_punch) {
                this.jour_punch = jour_punch;
            }

            public int getDay() {
                return day;
            }

            public void setDay(int day) {
                this.day = day;
            }

            public CalendarBean(String remark, boolean jour_punch, int day) {
                this.remark = remark;
                this.jour_punch = jour_punch;
                this.day = day;
            }
        }
}
