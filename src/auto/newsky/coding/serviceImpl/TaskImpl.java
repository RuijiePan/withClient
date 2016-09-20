package auto.newsky.coding.serviceImpl;

import auto.newsky.coding.mapper.JournalMapper;
import auto.newsky.coding.mapper.TaskMapper;
import auto.newsky.coding.po.Task;
import auto.newsky.coding.po.TaskExample;
import auto.newsky.coding.response.Result;
import auto.newsky.coding.resultdata.TaskInfoData;
import auto.newsky.coding.resultdata.TaskList;
import auto.newsky.coding.service.ITask;
import auto.newsky.coding.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/9/16.
 */
@Service
public class TaskImpl implements ITask{

    @Autowired
    private TaskMapper taskMapper;
    @Resource
    private JournalImpl journalService;


    @Override
    public Result createTask(Integer userId, String title, String content, Integer iconIndex) {

        Result result = new Result();

        TaskExample taskExample = new TaskExample();
        taskExample.createCriteria().andUserIdEqualTo(userId)
                .andTaskIsDeleteEqualTo(false);

        if (taskMapper.selectByExample(taskExample).size()<5){

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

    @Override
    public Result getTasks(Integer userId) {
        Result result = new Result();

        return null;
    }

    @Override
    public Result getTaskMessages(Integer userId, String date, Integer taskId) {

        Result result = new Result();

        Task task = taskMapper.selectByPrimaryKey(taskId);

        TaskInfoData.TaskBean taskBean =
                new TaskInfoData.TaskBean(taskId,task.getTaskContent(),task.getTaskTitle());

        List<TaskInfoData.CalendarBean> list =
                journalService.getCalendarList(DateUtil.getFirstDay(date),DateUtil.getLastDay(date));

        TaskInfoData taskInfoData = new TaskInfoData(taskBean,list);

        result.setData(taskInfoData);
        return result;
    }
}
