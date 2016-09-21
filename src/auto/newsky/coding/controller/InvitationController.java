package auto.newsky.coding.controller;

import auto.newsky.coding.po.Invitation;
import auto.newsky.coding.po.User;
import auto.newsky.coding.response.Result;
import auto.newsky.coding.serviceImpl.InvitationImpl;
import auto.newsky.coding.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by Administrator on 2016/9/16.
 */
@Controller
@RequestMapping("/invitation")
public class InvitationController {

    @Autowired
    private InvitationImpl invitationService;

    @Autowired
    private HttpServletRequest request;

    /**
     *
     * 获取邀约列表
     * @param typeId
     * @param aimUserId
     * @param lastInvitationId
     * @param limit
     * @return
     */

    @ResponseBody
    @RequestMapping("/getInvitations")
    public Result getInvitations(@RequestParam(value="typeId", required=false) Integer typeId,
                                 @RequestParam(value="userId", required=false)Integer aimUserId,
                                 @RequestParam(value="lastInvitationId", required=false) Integer lastInvitationId,
                                 @RequestParam(value="limit", required=false)Integer limit){
        Integer myUserId = (Integer) request.getAttribute("myUserId");
        Result result = null;
        if (typeId==null && aimUserId==null){
            //获取未分类的邀约列表
            //http://localhost:8080/invitation/getInvitations?token=1&lastInvitationId=0&limit=10
                result = invitationService.getInvitationsUnType(myUserId,lastInvitationId,limit);
        } else if(typeId!=null && aimUserId==null){
            //获取某分类的邀约邀约列表
            //http://localhost:8080/invitation/getInvitations?token=1&typeId=3&lastInvitationId=0&limit=10
            result = invitationService.getInvitationsByTypeId(myUserId,typeId,lastInvitationId,limit);
        }else if (typeId==null&&aimUserId!=null){
            if (aimUserId == -1){
                //获取我的关注邀约
                //http://localhost:8080/invitation/getInvitations?token=1&lastInvitationId=0&limit=10&userId=-1
                result = invitationService.getInvitationsMyConcerned(myUserId,lastInvitationId,limit);
            }else{
                //获取某人发出的邀约
                //http://localhost:8080/invitation/getInvitations?token=1&lastInvitationId=0&limit=10&userId=2
                result = invitationService.getInvitationsSBSend(myUserId,aimUserId,lastInvitationId,limit);
            }
        }
        return result;
    }

    /**
     * http://localhost:8080/invitation/publishInvitation?invitationTime=2016-1-1%2020:20:20&place=xxplace&totalNumber=1&title=xxtitle&content=xxcontent&sexRequire=0&type=4&hiden=false
     * 发起邀约
     * @param invitationTime
     * @param place
     * @param totalNumber
     * @param title
     * @param content
     * @param sexRequire
     * @param typeId
     * @param hiden
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/publishInvitation")
    public Result publishInvitation(@RequestParam(value="invitationTime", required=true)Date invitationTime
                                    ,@RequestParam(value="place", required=true)        String place
                                    ,@RequestParam(value="totalNumber", required=true)  Integer totalNumber
                                    ,@RequestParam(value="title", required=true)        String title
                                    ,@RequestParam(value="content", required=true)      String content
                                    ,@RequestParam(value="sexRequire", required=true)   Integer sexRequire
                                    ,@RequestParam(value="type", required=true)         Integer typeId
                                    ,@RequestParam(value="hiden", required=true)        Boolean hiden) throws Exception{
        Integer myUserId = (Integer) request.getAttribute("myUserId");
        Date invitPublicationTime = DateUtil.getCurrentTime();
        Invitation invitation = new Invitation(myUserId, invitPublicationTime, invitationTime, place,totalNumber, 0, sexRequire,title, content, typeId, hiden, false);
        Result result = invitationService.publishInvitation(invitation);
        return result;
    }

    /**
     * http://localhost:8080/invitation/alterInvitation?invitationId=1&invitationTime=2016-1-1%2020:20:20&place=xxplace&totalNumber=1&content=xxcontent&sexRequire=0&hiden=false
     * 维护、修改邀约
     * @param invitationId
     * @param invitationTime
     * @param place
     * @param totalNumber
     * @param content
     * @param sexRequire
     * @param hiden
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/alterInvitation")
    public Result alterInvitation(@RequestParam(value="invitationId", required=true)Integer invitationId
            ,@RequestParam(value="invitationTime", required=false)Date invitationTime
            ,@RequestParam(value="place", required=false)String place
            ,@RequestParam(value="totalNumber", required=false)Integer totalNumber
            ,@RequestParam(value="content", required=false)String content
            ,@RequestParam(value="sexRequire", required=false)Integer sexRequire
            ,@RequestParam(value="hiden", required=false) Boolean hiden) throws Exception{
        Integer myUserId = (Integer) request.getAttribute("myUserId");
        Invitation invitation = new Invitation(myUserId,invitationId,invitationTime, place, totalNumber,  sexRequire, content,  hiden) ;
        Result result = invitationService.alterInvitation(myUserId,invitation);
        return  result;
    }

    /**
     * 参加邀约/申请加入特批/退出邀约
     * @param invitationId
     * @param type
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/participateInvitation")
    public Result participateInvitation(@RequestParam(value="invitaionId", required=true)Integer invitationId
                                        ,@RequestParam(value="type", required=true)Integer type) throws Exception{
        Integer myUserId = (Integer) request.getAttribute("myUserId");
        Result result = null;
        if (type == 1){
            result = invitationService.participateInvitation(myUserId,invitationId);
        }else if (type == 0){
            result = invitationService.applyInvitation(myUserId,invitationId);
        }else  if(type == 2){
            result = invitationService.quitInvitation(myUserId,invitationId);
        }

        return result;
    }

    /**
     *
     * 删除指定邀约
     * @param invitationId
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/deleteInvitation")
    public Result deleteInvitation(@RequestParam(value="invitaionId", required=true)Integer invitationId) throws Exception{
        Integer myUserId = (Integer) request.getAttribute("myUserId");
        Result result = null;

        result = invitationService.deleteInvitation(myUserId,invitationId);
        return result;
    }

    /**
     * http://localhost:8080/invitation/getConcernedUsers?token=1&concernedUserId=1&limit=2
     * 获取我关注的用户列表
     * @param limit
     * @return
     * @throws Exception
     */

    @ResponseBody
    @RequestMapping("/getConcernedUsers")
    public Result getConcernedUsers(@RequestParam(value="concernedUserId", required=false)Integer lastConcernedUserId
                                    ,@RequestParam(value="limit", required=false)Integer limit) throws Exception{
        Integer myUserId = (Integer) request.getAttribute("myUserId");
        Result result = null;
        result = invitationService.getConcernedUsers(myUserId,lastConcernedUserId,limit);
        return result;
    }

    /**
     * http://localhost:8080/invitation/concernUser?token=1&concernedUserId=3
     * 关注/取消关注某用户
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/concernUser")
    public Result concernUser(@RequestParam(value = "concernedUserId",required = true) Integer concernedUserId) throws Exception{
        Integer myUserId = (Integer) request.getAttribute("myUserId");
        Result result = null;
        result = invitationService.concernUser(myUserId,concernedUserId);
        return result;
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

}
