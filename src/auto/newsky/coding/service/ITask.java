package auto.newsky.coding.service;

import auto.newsky.coding.po.Task;
import auto.newsky.coding.response.Result;
import auto.newsky.coding.resultdata.TaskList;

import java.util.Date;
import java.util.List;

/**
 * Created by prj on 2016/9/16.
 */
public interface ITask {

    Result createTask(Integer userId,String title,String content,Integer iconIndex);

    Result deleteTask(Integer userId,Integer taskId);

    Result getTasks(Integer userId);

    Result getTaskMessages(Integer userId,String date,Integer taskId);
}
