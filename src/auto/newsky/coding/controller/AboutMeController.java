package auto.newsky.coding.controller;

import auto.newsky.coding.po.User;
import auto.newsky.coding.response.Result;
import auto.newsky.coding.resultdata.LoginData;
import auto.newsky.coding.serviceImpl.InvitationImpl;
import auto.newsky.coding.serviceImpl.MessageImpl;
import auto.newsky.coding.serviceImpl.UserImpl;
import auto.newsky.coding.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by prj on 2016/9/16.
 */
@Controller
@RequestMapping("/user")
public class AboutMeController {

    @Resource
    private UserImpl userService;
    @Resource
    private InvitationImpl invitationService;
    @Resource
    private MessageImpl messageService;

    @Autowired
    private HttpServletRequest request;
    /**
     * http://localhost:8080/with/user/login?token=1&phone=2&password=6
     * 登录
     * @param password
     * @param phone
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/login")
    public Result getInvitations(@RequestParam(value="password", required=true)String password,
                                 @RequestParam(value="phone", required=true)String phone) throws Exception {
        Integer myUserId = (Integer) request.getAttribute("myUserId");
        Result result = new Result();
        User user = userService.getUserByPrimaryKey(myUserId);
        if (user.getUserMobilephone().equals(phone)&&
                user.getUserPassword().equals(password)){
            LoginData.DataBean dataBean = new LoginData.DataBean(user.getUserSex(),user.getUserMobilephone(),
                    8,user.getUserNickname(),user.getUserToken(),
                    user.getUserHeadurl(),user.getUserStudentid(),user.getUserId(),
                    user.getUserClass(),user.getUserRealname(),user.getUserQq());
            result.setData(new LoginData(dataBean));
        }else {
            result.setCode(405);
            result.setData(null);
            result.setMsg("账号或密码错误");
        }
        return result;
    }

    /**
     * 注册验证
     * @param studentNumber
     * @param realName
     * @param sex
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/registerVertification")
    public Result registerVertification(@RequestParam(value="studentNumber", required=true)String studentNumber,
                                        @RequestParam(value="realName", required=true)String realName,
                                        @RequestParam(value="sex", required=true)Integer sex) throws Exception{
        Result result = new Result();
        result.setData(null);
        User user = userService.getUserByStudentID(studentNumber);
        if (!(user.getUserRealname().equals(realName)&&
                user.getUserSex().equals(sex))){
            result.setCode(406);
            result.setMsg("用户信息不匹配");
        }
        if (user.getUserPassword()!=null){
            result.setCode(410);
            result.setMsg("该用户已存在");
        }
        return result;
    }
    /**
     * 获取验证码
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping("/getVertificationCode")
    public Result getVertificationCode(User user){
        return new Result(user);
    }

    /**
     * http://localhost:8080/with/user/register?token=1&phone=2&vertificationCode=5&password=6&studentNumber=1
     * @param phone
     * @param vertificationCode
     * @param password
     * @param studentNumber
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/register")
    public Result register(@RequestParam(value="phone", required=true)String phone,
                           @RequestParam(value="vertificationCode", required=true)String vertificationCode,
                           @RequestParam(value="password", required=true)String password,
                           @RequestParam(value="studentNumber", required=true)String studentNumber) throws Exception {

        Result result = new Result();
        User user = userService.getUserByStudentID(studentNumber);
        if (user!=null){
            user.setUserMobilephone(phone);
            user.setUserPassword(password);
            user.setUserToken(UUIDUtil.createUUID());
            userService.modify(user);
        }else {
            result.setCode(404);
            result.setMsg("验证码错误");
        }
        result.setData(null);
        return result;
    }

    /**
     * 找回密码
     * @param phone
     * @param vertificationCode
     * @param passWord
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/findBackPassWord")
    public Result findBackPassWord(@RequestParam(value="phone", required=true)String phone,
                                   @RequestParam(value="vertificationCode", required=true)String vertificationCode,
                                   @RequestParam(value="passWord", required=true)String passWord)throws Exception{
        Integer myUserId = (Integer) request.getAttribute("myUserId");
        Result result = new Result();
        User user = userService.getUserByPrimaryKey(myUserId);

        //userService.modifyPassword(myUserId,)
        return result;
    }
    /**
     * 上传用户头像
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/uploadHeadPic",method = RequestMethod.POST)
    public Result uploadHeadPic(User user){
        return new Result(user);
    }

    /**
     * 获取我的收到的信息列表
     * @param lastMessageId
     * @param limit
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/getMessages")
    public Result getMessages(@RequestParam(value="lastMessageId", required=false)Integer lastMessageId,
                              @RequestParam(value="limit", required=false)Integer limit)throws Exception{
        Integer myUserId = (Integer) request.getAttribute("myUserId");
        return messageService.getMessages(myUserId,lastMessageId,limit);
    }

    /**
     * 删除消息
     * @param messageId
     * @return
     */
    @ResponseBody
    @RequestMapping("/deleteMessage")
    public Result deleteMessage(@RequestParam(value="messageId", required=true)Integer messageId){
        return messageService.deleteMessage(messageId);
    }
    /**
     * 批准特批
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping("/acceptMessage")
    public Result acceptMessage(User user){
        return new Result(user);
    }

    /**
     * http://localhost:8080/with/user/getUserInfo?token=1&invitationId=1&aimUserId=1
     * 获取指定用户的信息
     * @param invitationId
     * @param aimUserId
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/getUserInfo")
    public Result getUserInfo(@RequestParam(value="invitationId", required=true)Integer invitationId,
                              @RequestParam(value="aimUserId", required=true)Integer aimUserId) throws Exception{
        return invitationService.getInvitationsByUidAndPrimaryKey(aimUserId,invitationId);
    }

    /**
     * 密码修改
     * @param oldPassword
     * @param newPassword
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/changPassword")
    public Result changPassword(@RequestParam(value="oldPassword", required=true)String oldPassword,
                                @RequestParam(value="newPassword", required=true)String newPassword)throws Exception{
        Integer myUserId = (Integer) request.getAttribute("myUserId");
        return userService.modifyPassword(myUserId,oldPassword,newPassword);
    }

}
