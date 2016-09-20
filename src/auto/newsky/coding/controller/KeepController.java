package auto.newsky.coding.controller;

import auto.newsky.coding.response.Result;
import auto.newsky.coding.resultdata.InvitationData;
import auto.newsky.coding.serviceImpl.InvitationImpl;
import auto.newsky.coding.serviceImpl.JournalImpl;
import auto.newsky.coding.serviceImpl.TaskImpl;
import auto.newsky.coding.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created by prj on 2016/9/16.
 */
@Controller
@RequestMapping("/keep")
public class KeepController {

    @Autowired
    private TaskImpl taskService;
    @Autowired
    private JournalImpl journalService;

    @Autowired
    private HttpServletRequest request;

    /**
     * http://localhost:8080/with/keep/createTask?title=%E5%93%88%E5%93%88%E5%93%88&content=%E5%9D%9A%E6%8C%81%E9%94%BB%E7%82%BC&iconIndex=1&token=123456
     * 新建任务
     * @param title
     * @param content
     * @param iconIndex
     * @return
     */
    @ResponseBody
    @RequestMapping("/createTask")
    public Result createTask(@RequestParam(value="title", required=true)String title,
                             @RequestParam(value="content", required=true)String content,
                             @RequestParam(value="iconIndex", required=true)int iconIndex){
        Integer myUserId = (Integer) request.getAttribute("myUserId");
        return taskService.createTask(myUserId,title,content,iconIndex);
    }

    /**
     * http://localhost:8080/with/keep/deleteTask?taskId=1&token=12345
     * 删除任务
     * @param taskId
     * @return
     */
    @ResponseBody
    @RequestMapping("/deleteTask")
    public Result deleteTask(@RequestParam(value="taskId", required=true)Integer taskId){
        Integer myUserId = (Integer) request.getAttribute("myUserId");
        return taskService.deleteTask(myUserId,taskId);
    }

    /**
     * http://localhost:8080/with/keep/signIn?taskId=1&token=123456
     * 打卡签到
     * @param taskId
     * @return
     */
    @ResponseBody
    @RequestMapping("/signIn")
    public Result signIn(@RequestParam(value="taskId", required=true)Integer taskId){
        return journalService.signIn(taskId);
    }

    /**
     * 指定日期：http://localhost:8080/with/keep/editTaskMessage?token=12345&taskId=1&remark=haha&date=2016-07-08
     * 默认日期：http://localhost:8080/with/keep/editTaskMessage?token=12345&taskId=1&remark=haha
     * 打卡编辑
     * @param taskId
     * @param date
     * @param remark
     * @return
     */
    @ResponseBody
    @RequestMapping("/editTaskMessage")
    public Result editTaskMessage(@RequestParam(value="taskId", required=true)Integer taskId,
                                  @RequestParam(value="date", required=false)String date,
                                  @RequestParam(value="remark", required=true)String remark){
        if (date==null)
            return journalService.editTaskMessage(taskId, DateUtil.getCurrentDate(),remark);
        else {
            Date d = DateUtil.stringToDate(date);
            return journalService.editTaskMessage(taskId, d, remark);
        }
    }

    /**
     * 获取任务列表(正在进行的任务和过去的任务)
     * @return
     */
    @ResponseBody
    @RequestMapping("/getTasks")
    public Result getTasks(){
        Integer myUserId = (Integer) request.getAttribute("myUserId");
        return null;
    }

    /**
     * 获取某任务指定某月份下的所有相关信息
     * @param date
     * @param taskId
     * @return
     */
    @ResponseBody
    @RequestMapping("/getTaskMessages")
    public Result getTaskMessages(@RequestParam(value="date", required=true)String date,
                                  @RequestParam(value="taskId", required=true)Integer taskId){
        Integer myUserId = (Integer) request.getAttribute("myUserId");
        return null;
    }

}
