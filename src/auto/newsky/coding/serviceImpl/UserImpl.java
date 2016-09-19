package auto.newsky.coding.serviceImpl;


import auto.newsky.coding.mapper.UserMapper;
import auto.newsky.coding.po.User;
import auto.newsky.coding.po.UserExample;
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
        return null;
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
}
