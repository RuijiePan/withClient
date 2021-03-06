package auto.newsky.coding.controller;

import auto.newsky.coding.po.User;
import auto.newsky.coding.response.Result;
import auto.newsky.coding.resultdata.LoginData;
import auto.newsky.coding.resultdata.RegisterData;
import auto.newsky.coding.resultdata.VertificationData;
import auto.newsky.coding.serviceImpl.*;
import auto.newsky.coding.util.ImageUtil;
import auto.newsky.coding.util.ImgCompressUtil;
import auto.newsky.coding.util.IpUtil;
import auto.newsky.coding.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
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
    @Resource
    private VersionImpl versionService;

    @Autowired
    private HttpServletRequest request;

    /**
     * http://localhost:8080/with/user/login?token=1&phone=2&password=6
     * 登录
     *
     * @param password
     * @param phone
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/login")
    public Result login(@RequestParam(value = "password", required = true) String password,
                                 @RequestParam(value = "phone", required = true) String phone) throws Exception {
        Integer myUserId = (Integer) request.getAttribute("myUserId");
        Result result = new Result();

        User user = userService.getUserByPhone(phone);
        if ( user == null) {
            //myUserId = user.getUserId();
            result.setCode(404);
            result.setData(null);
            result.setMsg("不存在用户");
            return result;
        }
        if (user.getUserMobilephone().equals(phone) &&
                user.getUserPassword().equals(password)) {
            user.setUserToken(UUIDUtil.createUUID());
            LoginData.DataBean dataBean = new LoginData.DataBean(user.getUserSex(), user.getUserMobilephone(),
                    messageService.getUnreadNumber(myUserId), user.getUserNickname(), user.getUserToken(),
                    IpUtil.getPicUrl(user.getUserHeadurl(),request), user.getUserStudentid(), user.getUserId(),
                    user.getUserClass(), user.getUserRealname(), user.getUserQq());
            result.setData(dataBean);
            result.setMsg("登陆成功");
            userService.modify(user);

        } else {
            result.setCode(405);
            result.setData(null);
            result.setMsg("账号或密码错误");
        }
        return result;
    }

    /**
     * 注册验证
     *
     * @param studentNumber
     * @param realName
     * @param sex
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/registerVertification")
    public Result registerVertification(@RequestParam(value = "studentNumber", required = true) String studentNumber,
                                        @RequestParam(value = "realName", required = true) String realName,
                                        @RequestParam(value = "sex", required = true) Integer sex) throws Exception {
        Result result = new Result();
        //VertificationData vertificationData = new VertificationData();
        VertificationData.DataBean bean = null;
        result.setMsg("验证成功");
        result.setData(null);
        User user = userService.getUserByStudentID(studentNumber);
        if (user == null) {//不存在学号
            result.setCode(404);
            result.setMsg("不存在学号");
            return result;
        }
        if (!(user.getUserRealname().trim().equals(realName) &&
                user.getUserSex() == sex)) {
            result.setCode(406);
            result.setMsg("用户信息不匹配");
            return result;
        }
        //有号码，并且没被删除，就是被绑定了
        if (user.getUserMobilephone() != null && !user.getUserMobilephone().trim().equals("") && user.getUserIsDelete() != true) {
            result.setCode(410);
            result.setMsg("该用户已经被手机号" + user.getUserMobilephone() + "绑定");
            String resultPhone =  user.getUserMobilephone().substring(0,3)+"******"+user.getUserMobilephone().substring(9,11);
            bean = new VertificationData.DataBean(resultPhone);
            //vertificationData.setData(new VertificationData.DataBean(user.getUserMobilephone()));
        }
        result.setData(bean);
        return result;
    }

    /**
     * http://localhost:8080/with/user/getVertificationCode?token=12345&phone=18318744486&code=1232
     * 获取验证码
     *
     * @param phone
     * @return
     */
    @ResponseBody
    @RequestMapping("/getVertificationCode")
    public Result getVertificationCode(@RequestParam(value = "phone", required = true) String phone,
                                       @RequestParam(value = "code", required = true) String code) {
        return userService.getVertificationCode(phone, code);
    }

    /**
     * http://localhost:8080/with/user/register?token=1&phone=2&vertificationCode=5&password=6&studentNumber=1
     *
     * @param phone
     * @param vertificationCode
     * @param password
     * @param studentNumber
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/register")
    public Result register(@RequestParam(value = "phone", required = true) String phone,
                           @RequestParam(value = "vertificationCode", required = true) String vertificationCode,
                           @RequestParam(value = "password", required = true) String password,
                           @RequestParam(value = "studentNumber", required = true) String studentNumber) throws Exception {

        Result result = new Result();
        Result vertificationResult = userService.getVertificationCode(phone, vertificationCode);
        User user = userService.getUserByPhone(phone);
        if (vertificationResult.getCode()!=200){//返回验证码不正确
            return vertificationResult;
        }

        if (user!=null ){//返回验证码正确，但是已经绑定了其他号码
            String resultPhone =  user.getUserMobilephone().substring(0,3)+"******"+user.getUserMobilephone().substring(9,11);
            result.setCode(428);
            result.setData(new RegisterData(resultPhone));
            result.setMsg("该号码已经绑定了其他账号");
            return result;
        }
        if (vertificationResult.getCode() == 200) {
            user = userService.getUserByStudentID(studentNumber);
            if (user != null) {
                user.setUserMobilephone(phone);
                user.setUserPassword(password);
                user.setUserNickname("xx同学");
                user.setUserIsDelete(false);
                result.setMsg("注册成功");
                user.setUserHeadurl("http://img2.5sing.kgimg.com/force/T1LVYnBXKT1RXrhCrK_180_180.jpg");
                user.setUserToken(UUIDUtil.createUUID());
                userService.modify(user);
            } else {
                result.setCode(428);
                result.setMsg("该学号信息未录入数据库");
            }
        }


        return result;
    }

    /**
     * 找回密码
     *
     * @param phone
     * @param vertificationCode
     * @param passWord
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/findBackPassWord")
    public Result findBackPassWord(@RequestParam(value = "phone", required = true) String phone,
                                   @RequestParam(value = "vertificationCode", required = true) String vertificationCode,
                                   @RequestParam(value = "passWord", required = true) String passWord) throws Exception {
        Integer myUserId = (Integer) request.getAttribute("myUserId");
        Result result = new Result();

        Result vertificationResult = userService.getVertificationCode(phone, vertificationCode);
        if (vertificationResult.getCode() == 200) {
            User user = userService.getUserByPrimaryKey(myUserId);
            user.setUserPassword(passWord);
            userService.modify(user);
        } else {
            return vertificationResult;
        }
        //userService.modifyPassword(myUserId,)
        return result;
    }

    /**
     * 上传用户头像
     *
     * @param file
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/upLoadHeadPic")
    public Result uploadHeadPic(@RequestParam("file") MultipartFile file,HttpServletRequest request) throws Exception {

        Integer myUserId = (Integer) request.getAttribute("myUserId");
        Result result = new Result();
       /* String filePath = request.getSession().getServletContext().getRealPath("/") + "upload/"
                + file.getOriginalFilename();
        System.out.print("hahaha!!!!!"+filePath);*/

        if (!file.isEmpty()) {
            try {
                String fileDest = request.getSession().getServletContext().getRealPath("/") + "upload\\";
                // 文件保存路径
                String filePath = fileDest + file.getOriginalFilename();
                // 转存文件
                file.transferTo(new File(filePath));

                System.out.println("filePath:"+filePath);
                String minFilePathS = file.getOriginalFilename().split("max.")[0];
                String minFilePathE = file.getOriginalFilename().split("max.")[1];
                String minFilePath = fileDest+minFilePathS+"min."+minFilePathE;
                ImageUtil.resize(filePath, minFilePath, 80, 80);
                //ImgCompressUtil.ImgCompress(filePath,minFilePath,500,500);

                User uploadUser = userService.getUserByPrimaryKey(myUserId);
                uploadUser.setUserHeadurl("upload/" + file.getOriginalFilename());
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
     *
     * @param lastMessageId
     * @param limit
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/getMessages")
    public Result getMessages(@RequestParam(value = "lastMessageId", required = false) Integer lastMessageId,
                              @RequestParam(value = "limit", required = false) Integer limit) throws Exception {
        Integer myUserId = (Integer) request.getAttribute("myUserId");
        return messageService.getMessages(myUserId, lastMessageId, limit,request);
    }

    /**
     * 删除消息
     *
     * @param messageId
     * @return
     */
    @ResponseBody
    @RequestMapping("/deleteMessage")
    public Result deleteMessage(@RequestParam(value = "messageId", required = true) Integer messageId) {
        Integer myUserId = (Integer) request.getAttribute("myUserId");
        return messageService.deleteMessage(myUserId,messageId);
    } /**
     * 设置已读消息
     *
     * @param messageId
     * @return
     */
    @ResponseBody
    @RequestMapping("/readMessage")
    public Result readMessage(@RequestParam(value = "messageId", required = true) Integer messageId) {
        Integer myUserId = (Integer) request.getAttribute("myUserId");
        return messageService.readMessage(myUserId,messageId);
    }

   /* *//**
     * http://localhost:8080/with/user/acceptMessage?invitationId=1&applyUserId=2&token=12345&isAccept=true
     * 批准特批
     *
     * @param invitationId
     * @param applyUserId
     * @param isAccept
     * @return
     *//*
    @ResponseBody
    @RequestMapping("/acceptMessage")
    public Result acceptMessage(@RequestParam(value = "invitationId", required = true) Integer invitationId,
                                @RequestParam(value = "applyUserId", required = true) Integer applyUserId,
                                @RequestParam(value = "isAccept", required = false) boolean isAccept) {
        Integer myUserId = (Integer) request.getAttribute("myUserId");
        return joinInviationService.acceptInvitation(myUserId, applyUserId, invitationId, isAccept);
    }*/

    /**
     *
     * 同意邀约yes/拒绝邀约no
     * @param aimId
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/acceptMessage")
    public Result acceptMessage(@RequestParam(value="applyUserId", required=true)Integer aimId
            ,@RequestParam(value="isAccept", required=true)Boolean isAccept
            ,@RequestParam(value="messageId", required=true)Integer messageId
            , @RequestParam(value="invitationId", required=true)Integer invitId) throws Exception{
        Integer myUserId = (Integer) request.getAttribute("myUserId");
        Result result = new Result();
        if (isAccept){
            result = invitationService.agreeInvitation(myUserId,aimId,invitId,messageId);
        }else {
            result = invitationService.rejectInvitation(myUserId,aimId,invitId,messageId);
        }

        return result;
    }

    /**
     * http://localhost:8080/with/user/getUserInfo?token=1&invitationId=1&aimUserId=1
     * 获取指定用户的信息
     *
     * @param invitationId
     * @param aimUserId
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/getUserInfo")
    public Result getUserInfo(@RequestParam(value = "invitationId", required = true) Integer invitationId,
                              @RequestParam(value = "aimUserId", required = true) Integer aimUserId) throws Exception {
        Integer myUserId = (Integer) request.getAttribute("myUserId");
        return invitationService.getUserInfo(myUserId, aimUserId, invitationId,request);
    }

    /**
     * 密码修改
     *
     * @param oldPassword
     * @param newPassword
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/changPassword")
    public Result changPassword(@RequestParam(value = "oldPassword", required = true) String oldPassword,
                                @RequestParam(value = "newPassword", required = true) String newPassword) throws Exception {
        Integer myUserId = (Integer) request.getAttribute("myUserId");
        return userService.modifyPassword(myUserId, oldPassword, newPassword);
    }

    /**
     *
     * 编辑用户信息
     * @param nickname
     * @param qq
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/editUserInfo")
    public Result editUserInfo(@RequestParam(value="nickname", required=true)String nickname,
                               @RequestParam(value="qq", required=true)String qq)throws Exception{
        Integer myUserId = (Integer) request.getAttribute("myUserId");
        return userService.modifyUserInfo(myUserId, nickname, qq);
    }

    /**
     * 版本更新
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/versionUpdate")
    public Result versionUpdate() throws Exception{
        return versionService.getUpdateInfo();
    }
}
