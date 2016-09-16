package auto.newsky.coding.controller;

import auto.newsky.coding.response.Result;
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

    @RequestMapping("createTask")
    public String createTask(String token,String title,String content,int index
            ,HttpServletRequest request,HttpServletResponse response){
        return token;
    }
}
