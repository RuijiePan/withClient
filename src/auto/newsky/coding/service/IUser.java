package auto.newsky.coding.service;


import auto.newsky.coding.po.User;

/**
 * Created by Administrator on 2016/9/16.
 */
public interface IUser {

    public User getUserByToken(String token) throws Exception;

    public User getUserByStudentID(String studentId) throws Exception;

    public void add(User user) throws Exception;

    public void remove(Integer userId) throws Exception;

    public void modify(User user) throws Exception;
}
