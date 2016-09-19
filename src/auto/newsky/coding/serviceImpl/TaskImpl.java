package auto.newsky.coding.serviceImpl;

import auto.newsky.coding.mapper.TaskMapper;
import auto.newsky.coding.po.Task;
import auto.newsky.coding.resultdata.TaskList;
import auto.newsky.coding.service.ITask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/9/16.
 */
@Service
public class TaskImpl implements ITask{

    @Autowired
    private TaskMapper taskMapper;


    @Override
    public void add(Task task) {

    }

    @Override
    public void remove(int taskId) {

    }

    @Override
    public List<TaskList> getTask(int userId) {
        return null;
    }


}
