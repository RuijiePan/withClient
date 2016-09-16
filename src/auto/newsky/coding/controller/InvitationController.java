package auto.newsky.coding.controller;

import auto.newsky.coding.po.Invatation;
import auto.newsky.coding.response.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2016/9/16.
 */
@Controller
@RequestMapping("/invitation")
public class InvitationController {

    /**
     * 获取邀约列表
     */
    @ResponseBody
    @RequestMapping("/getInvitations")
    public void getInvitations(){

    }

    @ResponseBody
    @RequestMapping("/publishInvitation")
    public Result publishInvitation(Invatation invatation) throws Exception{
        return new Result(null);
    }

    @ResponseBody
    @RequestMapping("/alterInvitation")
    public Result alterInvitation(Invatation invatation) throws Exception{
        return new Result();
    }
}
