package auto.newsky.coding.controller;

import auto.newsky.coding.controller.converter.CustomDateConverter;
import auto.newsky.coding.po.Invatation;
import auto.newsky.coding.response.Result;
import auto.newsky.coding.serviceImpl.InvitationImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
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
     * 获取邀约列表
     */
    //http://localhost:8080/invitation/getInvitations?token=1&typeId=1&userId=1&lastInvitationId=1&limit=1&invitaionId=1
    @ResponseBody
    @RequestMapping("/getInvitations")
    public Result getInvitations(@RequestParam(value="typeId", required=false) Integer typeId,
                                 @RequestParam(value="userId", required=false)Integer aimUserId,
                                 @RequestParam(value="lastInvitationId", required=false) Integer lastInvitationId,
                                 @RequestParam(value="limit", required=false)Integer limit){
        Integer myUserId = (Integer) request.getAttribute("myUserId");
        Result result = null;
        if (typeId==null && aimUserId==null){//获取未分类的邀约列表
                result = invitationService.getInvitationsUnType(myUserId,lastInvitationId,limit);
        } else if(typeId!=null && aimUserId==null){
            result = invitationService.getInvitationsByTypeId(myUserId,typeId,lastInvitationId,limit);//获取某分类的邀约邀约列表
        }else if (typeId==null&&aimUserId!=null){
            if (aimUserId == -1){//获取我的关注邀约
                result = invitationService.getInvitationsMyConcerned(myUserId,lastInvitationId,limit);
            }else{//获取某人发出的邀约
                result = invitationService.getInvitationsSBSend(myUserId,aimUserId,lastInvitationId,limit);
            }
        }
        return result;
    }

    /**
     * 发起邀约
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
        Date invitPublicationTime = new Date();
        Invatation invatation = new Invatation(myUserId, invitPublicationTime, invitationTime, place,totalNumber, 0, sexRequire,title, content, typeId, hiden, false);
        Result result = invitationService.publishInvitation(invatation);
        return result;
    }

    /**
     * 维护、修改邀约
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/alterInvitation")
    public Result alterInvitation(@RequestParam(value="token", required=true)String token
            ,@RequestParam(value="invitationId", required=true)Integer invitationId
            ,@RequestParam(value="invitationTime", required=true)Date invitationTime
            ,@RequestParam(value="place", required=true)String place
            ,@RequestParam(value="totalNumber", required=true)Integer totalNumber
            ,@RequestParam(value="content", required=true)String content
            ,@RequestParam(value="sexRequire", required=true)Integer sexRequire
            ,@RequestParam(value="hiden", required=true) Boolean hiden) throws Exception{
        int userId = 1;//userId = getUidFromToken(token);
        Invatation invatation = new Invatation(userId,invitationId,invitationTime, place, totalNumber,  sexRequire, content,  hiden) ;

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
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/deleteInvitation")
    public Result deleteInvitation() throws Exception{

        return new Result(request.getAttribute("myUserId"));
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
        Result result = invitationService.getConcernedUsers();
        return result;
    }

    /**
     * 关注/取消关注某用户
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/concernUser")
    public Result concernUser(@RequestParam(value = "token",required = true) String token
            ,@RequestParam(value = "concernedUserId",required = true) String concernedUserId) throws Exception{
        int userId = 1;//userId = getUidFromToken(token);
        Result result = invitationService.concernUser(userId,concernedUserId);
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
    @ResponseBody
    @RequestMapping("/test")
    public Result test(@RequestParam(value = "name",required = false) String name
            ,@RequestParam(value = "id",required = false)Integer id
            ,@RequestParam(value = "date",required = false)String date) throws Exception{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return new Result(simpleDateFormat.format(simpleDateFormat.parse(date)));
    }
}
