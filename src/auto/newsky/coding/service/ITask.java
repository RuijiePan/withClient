package auto.newsky.coding.service;

import auto.newsky.coding.po.Task;
import auto.newsky.coding.po.TaskInfo;
import auto.newsky.coding.po.TaskList;

import java.util.List;

/**
 * Created by prj on 2016/9/16.
 */
public interface ITask {

    void add(Task task);

    void remove(int taskId);

    List<TaskList> getTask(String token);

    List<TaskInfo> getTaskMessages(String data,String token,int taskId);

}
