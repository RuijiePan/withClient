package auto.newsky.coding.controller;

import auto.newsky.coding.response.Result;
import auto.newsky.coding.serviceImpl.InvitationImpl;
import auto.newsky.coding.serviceImpl.TaskImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by prj on 2016/9/16.
 */
@Controller
@RequestMapping("/keep/")
public class KeepController {
    @Autowired
    private TaskImpl taskService;
    @RequestMapping("createTask")

    public String createTask(String token,String title,String content,int index
            ,HttpServletRequest request,HttpServletResponse response){
        return token;
    }
}
