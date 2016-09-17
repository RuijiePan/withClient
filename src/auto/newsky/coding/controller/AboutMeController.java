package auto.newsky.coding.controller;

import auto.newsky.coding.po.Invatation;
import auto.newsky.coding.po.User;
import auto.newsky.coding.response.Result;
import auto.newsky.coding.serviceImpl.TaskImpl;
import auto.newsky.coding.serviceImpl.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by prj on 2016/9/16.
 */
@Controller
@RequestMapping("/aboutme/")
public class AboutMeController {
    @Autowired
    private UserImpl userService;

    /**
     * 登录
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping("/login")
    public Result getInvitations(User user){
        return new Result(user);
    }
    /**
     * 注册验证
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping("/registerVertification")
    public Result registerVertification(User user){
        return new Result(user);
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
     * 注册
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping("/register")
    public Result register(User user){
        return new Result(user);
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
