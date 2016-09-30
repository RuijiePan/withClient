package auto.newsky.coding.service;


import auto.newsky.coding.po.User;
import auto.newsky.coding.response.Result;

/**
 * Created by Administrator on 2016/9/16.
 */
public interface IUser {

    public User getUserByToken(String token) throws Exception;

    public User getUserByStudentID(String studentId) throws Exception;

    public User getUserByPrimaryKey(Integer userId)throws Exception;

    public void add(User user) throws Exception;

    public void remove(Integer userId) throws Exception;

    public void modify(User user) throws Exception;

    Result modifyPassword(Integer myUserId, String oldPassword,String newPassword)throws Exception;

    Result findBackPassword(String newPassword,String phone,String vertificationCode)throws Exception;

    Result getVertificationCode(String phone,String code);

    Result modifyUserInfo(Integer userId,String nickname,String qq);

    User getUserByPhone(String phone);

    boolean isPhoneBind(String phone);
}
