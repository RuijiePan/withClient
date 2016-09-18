package auto.newsky.coding.serviceImpl;

import auto.newsky.coding.po.User;

import auto.newsky.coding.mapper.UserMapper;
import auto.newsky.coding.service.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/9/16.
 */
@Service("userService")
public class UserImpl implements IUser{

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByToken(String token) throws Exception {
        return userMapper.selectByToken(token);
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
