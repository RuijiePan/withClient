package auto.newsky.coding.controller;


import auto.newsky.coding.po.User;
import auto.newsky.coding.resultdata.LoginData;
import auto.newsky.coding.response.Result;
import auto.newsky.coding.serviceImpl.UserImpl;
import auto.newsky.coding.util.UUIDUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by prj on 2016/9/16.
 */
@Controller
@RequestMapping("/user")
public class AboutMeController {

    @Resource
    private UserImpl userService;

    /**
     * http://localhost:8080/with/user/login?token=1&phone=2password=6
     * 登录
     * @param token
     * @param password
     * @param phone
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/login")
    public Result getInvitations(@RequestParam(value="token", required=true)String token,
                                 @RequestParam(value="password", required=true)String password,
                                 @RequestParam(value="phone", required=true)String phone) throws Exception {
        Result result = new Result();
        User user = userService.getUserByToken(token);
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
     * @param token
     * @param studentNumber
     * @param realName
     * @param sex
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/registerVertification")
    public Result registerVertification(@RequestParam(value="token", required=true)String token,
                                        @RequestParam(value="studentNumber", required=true)String studentNumber,
                                        @RequestParam(value="realName", required=true)String realName,
                                        @RequestParam(value="sex", required=true)Integer sex) throws Exception{
        Result result = new Result();
        result.setData(null);
        User user = userService.getUserByStudentID(studentNumber);
        if (!(user.getUserRealname().equals(realName)&&
                user.getUserSex()==sex)){
            result.setCode(406);
            result.setMsg("信息不匹配");
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
     * @param token
     * @param phone
     * @param vertificationCode
     * @param password
     * @param studentNumber
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/register")
    public Result register(@RequestParam(value="token", required=true)String token,
                           @RequestParam(value="phone", required=true)String phone,
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
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping("/findBackPassWord")
    public Result findBackPassWord(User user){
        return new Result(user);
    }
    /**
     * 上传用户头像
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping("/uploadHeadPic")
    public Result uploadHeadPic(User user){
        return new Result(user);
    }
    /**
     * 获取我的收到的信息列表
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping("/getMessages")
    public Result getMessages(User user){
        return new Result(user);
    }
    /**
     * 删除消息
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping("/deleteMessage")
    public Result deleteMessage(User user){
        return new Result(user);
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
     * 获取指定用户的信息
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping("/getUserInfo")
    public Result getUserInfo(User user){
        return new Result(user);
    }
    /**
     * 密码修改
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping("/changPassword")
    public Result changPassword(User user){
        return new Result(user);
    }


}
