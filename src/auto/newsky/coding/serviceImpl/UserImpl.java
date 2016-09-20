package auto.newsky.coding.serviceImpl;


import auto.newsky.coding.mapper.UserMapper;
import auto.newsky.coding.po.User;
import auto.newsky.coding.po.UserExample;
import auto.newsky.coding.response.Result;
import auto.newsky.coding.service.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        userExample.createCriteria().andUserTokenEqualTo(token);
        List<User> withUsers =  userMapper.selectByExample(userExample);
        return (User) withUsers.get(0);
    }

    @Override
    public User getUserByStudentID(String studentId) throws Exception {

        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserStudentidEqualTo(studentId);
        List<User> list = userMapper.selectByExample(userExample);

        if (list!=null)
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
        userMapper.updateByPrimaryKey(user);
    }

    @Override
    public Result modifyPassword(Integer myUserId, String oldPassword, String newPassword) {
        Result result = new Result();
        result.setData(null);

        if (oldPassword.equals(newPassword)){
            result.setCode(409);
            result.setMsg("�¾����벻����ͬ");
            return result;
        }

        User user = userMapper.selectByPrimaryKey(myUserId);
        user.setUserPassword(newPassword);
        if (userMapper.updateByPrimaryKey(user)==0){
            result.setCode(408);
            result.setMsg("�����޸�ʧ��");
        }
        return result;
    }

    @Override
    public Result findBackPassword(String newPassword,String phone,String vertificationCode) {
        Result result = new Result();
        result.setData(null);

        return null;
    }


}
