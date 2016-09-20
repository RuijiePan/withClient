package auto.newsky.coding.serviceImpl;

import auto.newsky.coding.mapper.TaskMapper;
import auto.newsky.coding.po.Task;
import auto.newsky.coding.po.TaskExample;
import auto.newsky.coding.response.Result;
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
    public Result createTask(Integer userId, String title, String content, Integer iconIndex) {

        Result result = new Result();

        TaskExample taskExample = new TaskExample();
        taskExample.createCriteria().andUserIdEqualTo(userId)
                .andTaskIconTypeEqualTo(iconIndex)
                .andTaskIsDeleteEqualTo(false);

        if (taskMapper.selectByExample(taskExample).size()<=3){

            Task task = new Task(userId, content, title, false, iconIndex);
            if (taskMapper.insert(task) == 0) {
                result.setCode(414);
                result.setMsg("创建坚持活动失败");
            }
        }else {
            result.setCode(419);
            result.setMsg("活动已达上限");
        }

        return result;
    }

    @Override
    public Result deleteTask(Integer userId, Integer taskId) {

        Result result = new Result();

        if (userId!=-1)
        {
            Task task = taskMapper.selectByPrimaryKey(taskId);
            task.setTaskIsDelete(true);
            if (taskMapper.updateByPrimaryKey(task)==0){
                result.setCode(415);
                result.setMsg("坚持活动删除失败");
            }
        }else {
            result.setCode(401);
            result.setMsg("用户未登录");
        }

        return result;
    }
}
