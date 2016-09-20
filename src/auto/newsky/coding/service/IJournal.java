package auto.newsky.coding.service;


import auto.newsky.coding.po.Journal;
import auto.newsky.coding.response.Result;
import auto.newsky.coding.resultdata.TaskInfoData;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/9/16.
 */
public interface IJournal {

    Result signIn(Integer taskId);

    Result editTaskMessage(Integer taskId,Date date,String remark);

    List<TaskInfoData.CalendarBean> getCalendarList(Date firstDay,Date lastDay);
}
