package auto.newsky.coding.controller;

import auto.newsky.coding.mapper.UserMapper;
import auto.newsky.coding.po.Invatation;
import auto.newsky.coding.po.InvitationData;
import auto.newsky.coding.response.Result;
import auto.newsky.coding.serviceImpl.InvitationImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

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
    public Result getInvitations(@RequestParam(value="token", required=false)String token,@RequestParam(value="typeId", required=false) Integer typeId, @RequestParam(value="userId", required=false)Integer userId,@RequestParam(value="lastInvitationId", required=false) Integer lastInvitationId, @RequestParam(value="limit", required=false)Integer limit){
        Result result = new Result();
        InvitationData invitationData = null;
        if (typeId==null && userId==null){//获取未分类的邀约列表
            invitationData = invitationService.getInvitationsUnType(token,lastInvitationId,limit);
        }else if(typeId!=null && userId==null){//
            if (invitationService.isSmallType(typeId)){//获取某大分类的邀约邀约列表
                invitationData = invitationService.getInvitationsBigType(token,typeId,lastInvitationId,limit);
            }else{//获取某小分类的邀约列表
                invitationData = invitationService.getInvitationsSmallType(token,typeId,lastInvitationId,limit);
            }
        }else if (typeId==null&&userId!=null){
            if (userId == -1){//获取我的关注邀约
                invitationData = invitationService.getInvitationsMyConcerned(token,lastInvitationId,limit);
            }else{//获取某人发出的邀约
                invitationData = invitationService.getInvitationsSBSend(token,userId,lastInvitationId,limit);
            }
        }
        result.setData(invitationData);
        return result;
    }

    /**
     * 发起邀约
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/publishInvitation")
    public Result publishInvitation(@RequestParam(value="token", required=false)String token
                                    ,@RequestParam(value="invitationTime", required=false)Date invitationTime
                                    ,@RequestParam(value="place", required=false)String place
                                    ,@RequestParam(value="totalNumber", required=false)Integer totalNumber
                                    ,@RequestParam(value="title", required=false)String title
                                    ,@RequestParam(value="content", required=false)String content
                                    ,@RequestParam(value="sexRequire", required=false)Integer sexRequire
                                    ,@RequestParam(value="type", required=false)Integer type
                                    ,@RequestParam(value="hiden", required=false)boolean hiden) throws Exception{
        int userId = 1;//userId = getUidFromToken(token);
        Date invitPublicationTime = new Date();
        int invitNumberCurr = 0;
        Invatation invatation = new Invatation(userId, invitPublicationTime, invitationTime, place, totalNumber, invitNumberCurr, sexRequire, title,content, 1, type, hiden) ;


        return new Result();
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

    /**
     * 1.如果用@RequestMapping注解的参数是int基本类型，但是required=false，这时如果不传参数值会报错，因为不传值，会赋值为null给int，这个不可以
     * 2.可以通过required=false或者true来要求@RequestParam配置的前端参数是否一定要传   @RequestParam(value="aa", required=true)
     * 3.可以对传入参数指定参数名 (对传入参数指定为aa，如果前端不传aa参数名，会报错 )  @RequestParam(value="aa") String inputStr
     * @param name
     * @param id
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/test")
    public Result test(@RequestParam(value = "name",required = false) String name,@RequestParam(value = "name",required = false)Integer id) throws Exception{
        return new Result(name);
    }
}
