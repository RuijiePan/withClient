package auto.newsky.coding.serviceImpl;


import auto.newsky.coding.mapper.UserMapper;
import auto.newsky.coding.po.User;
import auto.newsky.coding.po.UserExample;
import auto.newsky.coding.response.Result;
import auto.newsky.coding.service.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.net.ssl.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.List;

/**
 * Created by Administrator on 2016/9/16.
 */
@Service("userService")
public class UserImpl implements IUser{

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByToken(String token) throws Exception {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserTokenEqualTo(token).andUserIsDeleteEqualTo(false);
        List<User> withUsers =  userMapper.selectByExample(userExample);
        if (withUsers == null ||withUsers.size()<=0){
            return null;
        }
        return (User) withUsers.get(0);
    }

    @Override
    public User getUserByStudentID(String studentId) throws Exception {

        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserStudentidEqualTo(studentId);
        List<User> list = userMapper.selectByExample(userExample);

        if (list!=null&&list.size()>0)//单单不为null不行
            return list.get(0);
        return null;
    }

    @Override
    public User getUserByPrimaryKey(Integer userId)  {
        return userMapper.selectByPrimaryKey(userId);
    }


    @Override
    public void add(User user) throws Exception {
        userMapper.insert(user);
    }

    @Override
    public void remove(Integer userId) throws Exception {
        userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public void modify(User user) throws Exception {
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public Result modifyPassword(Integer myUserId, String oldPassword, String newPassword) {
        Result result = new Result();
        result.setData(null);

        if (oldPassword.equals(newPassword)){
            result.setCode(409);
            result.setMsg("新旧密码不能相同ͬ");
            return result;
        }

        User user = userMapper.selectByPrimaryKey(myUserId);
        user.setUserPassword(newPassword);
        if (userMapper.updateByPrimaryKey(user)==0){
            result.setCode(408);
            result.setMsg("查找不到相对应的用户信息");
        }
        return result;
    }

    @Override
    public Result findBackPassword(String newPassword,String phone,String vertificationCode) {
        Result result = new Result();
        result.setData(null);

        return null;
    }

    @Override
    public Result getVertificationCode(String phone,String code) {

        Result result = new Result();
        int vertificationCode = requestData("https://webapi.sms.mob.com/sms/verify",
                "appkey=1711fda5318b2&phone="+phone+"&zone=86&&code="+code);
        result.setCode(parCode(vertificationCode));
        result.setMsg(padString(vertificationCode));
        return result;
    }

    @Override
    public User getUserByPhone(String phone) {
        UserExample userExample = new UserExample();
        userExample.or().andUserMobilephoneEqualTo(phone).andUserIsDeleteEqualTo(false);
        List<User> userList = userMapper.selectByExample(userExample);
        if (userList == null || userList.size()<=0){
            return null;
        }
        return userList.get(0);
    }

    @Override
    public boolean isPhoneBind(String phone) {
        UserExample userExample = new UserExample();
        userExample.or().andUserMobilephoneEqualTo(phone).andUserIsDeleteEqualTo(false);
        List<User> userList = userMapper.selectByExample(userExample);
        if (userList != null && userList.size()>0){
            return true;
        }
        return false;
    }

    @Override
    public Result modifyUserInfo(Integer userId,String nickname, String qq) {
        Result result = new Result();
        User user = userMapper.selectByPrimaryKey(userId);
        user.setUserNickname(nickname);
        user.setUserQq(qq);

        if (userMapper.updateByPrimaryKeySelective(user)==0){
            result.setCode(429);
            result.setMsg("编辑用户信息失败");
        }
        return result;
    }


    public int requestData(String address ,String params){

        HttpURLConnection conn = null;
        try {
            // Create a trust manager that does not validate certificate chains
            TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager(){
                public X509Certificate[] getAcceptedIssuers(){return null;}
                public void checkClientTrusted(X509Certificate[] certs, String authType){}
                public void checkServerTrusted(X509Certificate[] certs, String authType){}
            }};

            // Install the all-trusting trust manager
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new SecureRandom());

            //ip host verify
            HostnameVerifier hv = new HostnameVerifier() {
                public boolean verify(String urlHostName, SSLSession session) {
                    return urlHostName.equals(session.getPeerHost());
                }
            };

            //set ip host verify
            HttpsURLConnection.setDefaultHostnameVerifier(hv);

            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

            URL url = new URL(address);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");// POST
            conn.setConnectTimeout(3000);
            conn.setReadTimeout(3000);
            // set params ;post params
            if (params!=null) {
                conn.setDoOutput(true);
                DataOutputStream out = new DataOutputStream(conn.getOutputStream());
                out.write(params.getBytes(Charset.forName("UTF-8")));
                out.flush();
                out.close();
            }
            conn.connect();
            //get result
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                String result = parsRtn(conn.getInputStream());
                System.out.println("resultcode:======================="+result);
                return Integer.parseInt(result.substring(10,13));
            } else {
                System.out.println(conn.getResponseCode() + " "+ conn.getResponseMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null)
                conn.disconnect();
        }
        return 200;
    }

    private  String parsRtn(InputStream is) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuffer buffer = new StringBuffer();
        String line = null;
        boolean first = true;
        while ((line = reader.readLine()) != null) {
            if(first){
                first = false;
            }else{
                buffer.append("\n");
            }
            buffer.append(line);
        }
        return buffer.toString();
    }

    public int parCode(int code){
        int Code = 0;
        switch (code){
            case 200:
                Code =  200;
            break;
            case 405:
                Code =  420;
                break;
            case 406:
                Code =  421;
                break;
            case 456:
                Code =  422;
                break;
            case 457:
                Code =  423;
                break;
            case 466:
                Code =  424;
                break;
            case 467:
                Code =  425;
                break;
            case 468:
                Code =  426;
                break;
            case 474:
                Code =  427;
                break;
        }
        return Code;
    }

    private String padString(int code){
        String data = null;
        switch (code){
            case 405:
                data = "AppKey为空";
                break;
            case 406:
                data = "AppKey无效";
                break;
            case 456:
                data = "国家代码或手机号码为空";
                break;
            case 457:
                data = "手机号码格式错误";
                break;
            case 466:
                data = "请求校验的验证码为空";
                break;
            case 467:
                data = "请求校验验证码频繁（5分钟内同一个appkey的同一个号码最多只能校验三次）";
                break;
            case 468:
                data = "验证码错误";
                break;
            case 474:
                data = "没有打开服务端验证开关";
                break;
        }
        return data;
    }
}
