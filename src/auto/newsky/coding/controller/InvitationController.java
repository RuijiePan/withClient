package auto.newsky.coding.controller;

import auto.newsky.coding.mapper.UserMapper;
import auto.newsky.coding.po.Invatation;
import auto.newsky.coding.response.Result;
import auto.newsky.coding.serviceImpl.InvitationImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2016/9/16.
 */
@Controller
@RequestMapping("/invitation")
public class InvitationController {

    @Autowired
    private InvitationImpl invitationService;
    /**
     * 获取邀约列表
     */
    //http://localhost:8080/invitation/getInvitations?token=1&typeId=1&userId=1&lastInvitationId=1&limit=1&invitaionId=1
    @ResponseBody
    @RequestMapping("/getInvitations")
    public Result getInvitations(Invatation invitatioon,@RequestParam("token")String token,@RequestParam("typeId") int typeId, @RequestParam("userId")int userId,@RequestParam("lastInvitationId") int lastInvitationId, @RequestParam("limit")int limit){
        //.......
        return new Result(invitatioon);
    }

    /**
     * 发起邀约
     * @param invatation
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/publishInvitation")
    public Result publishInvitation(Invatation invatation) throws Exception{
        return new Result(invatation);
    }

    /**
     * 维护、修改邀约
     * @param invatation
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/alterInvitation")
    public Result alterInvitation(Invatation invatation) throws Exception{
        return new Result();
    }

    /**
     * 参加邀约/申请加入特批/退出邀约
     * @param invatation
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/participateInvitation")
    public Result participateInvitation(Invatation invatation) throws Exception{
        return new Result();
    }

    /**
     * 删除指定邀约
     * @param invatation
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/deleteInvitation")
    public Result deleteInvitation(Invatation invatation) throws Exception{
        return new Result();
    }

    /**
     * 获取我关注的用户列表
     * @param invatation
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/getConcernedUsers")
    public Result getConcernedUsers(Invatation invatation) throws Exception{
        return new Result();
    }

    /**
     * 关注/取消关注某用户
     * @param invatation
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/concernUser")
    public Result concernUser(Invatation invatation) throws Exception{
        return new Result();
    }


}
