package auto.newsky.coding.service;

import java.util.List;

/**
 * Created by prj on 2016/9/16.
 */
public interface ITask {

    void add(Task task);

    void remove(int taskId);

    List<TaskList> getTask(int userId);


}
