package auto.newsky.coding.service;

import auto.newsky.coding.po.User;

/**
 * Created by Administrator on 2016/9/13.
 */
public interface IUser {

    public void add(User user);

    public void modify(User user);

    public void getUser(String token);

    public void modifyPassword(String password);
}
