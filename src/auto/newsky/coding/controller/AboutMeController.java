package auto.newsky.coding.controller;

import auto.newsky.coding.po.User;
import auto.newsky.coding.response.Result;
import auto.newsky.coding.resultdata.LoginData;
import auto.newsky.coding.serviceImpl.InvitationImpl;
import auto.newsky.coding.serviceImpl.JoinInvitationImpl;
import auto.newsky.coding.serviceImpl.MessageImpl;
import auto.newsky.coding.serviceImpl.UserImpl;
import auto.newsky.coding.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Date;

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
    @Resource
    private JoinInvitationImpl joinInviationService;

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
     * @param phone
     * @return
     */
    @ResponseBody
    @RequestMapping("/getVertificationCode")
    public Result getVertificationCode(@RequestParam(value="phone", required=true)String phone,
                                       @RequestParam(value="code", required=true)String code){
        return userService.getVertificationCode(phone,code);
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
     * @param file
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/uploadHeadPic")
    public Result uploadHeadPic(@RequestParam("file")MultipartFile file)throws Exception{

        Integer myUserId = (Integer) request.getAttribute("myUserId");
        Result result = new Result();

        if (!file.isEmpty()){
            try {
                // 文件保存路径
                String filePath = request.getSession().getServletContext().getRealPath("/") + "upload/"
                        + file.getOriginalFilename();
                // 转存文件
                file.transferTo(new File(filePath));

                User uploadUser = userService.getUserByPrimaryKey(myUserId);
                uploadUser.setUserHeadurl(filePath);
                userService.modify(uploadUser);
                result.setMsg("上传头像成功");

            } catch (Exception e) {
                e.printStackTrace();
                result.setCode(420);
                result.setMsg("上传头像失败");
            }
        }
        /*try {
            //获取输出流
            String fileName = "E:/"+new Date().getTime()+file.getOriginalFilename();
            OutputStream os=new FileOutputStream(fileName);
            //获取输入流 CommonsMultipartFile 中可以直接得到文件的流
            InputStream is=file.getInputStream();
            int temp;
            //一个一个字节的读取并写入
            while((temp=is.read())!=(-1))
            {
                os.write(temp);
            }
            os.flush();
            os.close();
            is.close();

            User uploadUser = userService.getUserByPrimaryKey(myUserId);
            uploadUser.setUserHeadurl(fileName);
            userService.modify(uploadUser);

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            result.setCode(420);
            result.setMsg("上传头像失败");
        }*/
        return result;
    }

    /**
     * http://localhost:8080/with/user/getMessages?token=12345&lastMessageId=0&limit=10
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
     * http://localhost:8080/with/user/acceptMessage?invitationId=1&applyUserId=2&token=12345&isAccept=true
     * 批准特批
     * @param invitationId
     * @param applyUserId
     * @param isAccept
     * @return
     */
    @ResponseBody
    @RequestMapping("/acceptMessage")
    public Result acceptMessage(@RequestParam(value="invitationId", required=true)Integer invitationId,
                                @RequestParam(value="applyUserId", required=true)Integer applyUserId,
                                @RequestParam(value="isAccept", required=false)boolean isAccept){
        Integer myUserId = (Integer) request.getAttribute("myUserId");
        return joinInviationService.acceptInvitation(myUserId,applyUserId,invitationId,isAccept);
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
