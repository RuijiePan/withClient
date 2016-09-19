package auto.newsky.coding;

import auto.newsky.coding.mapper.InvitationMapper;
import auto.newsky.coding.mapper.UserMapper;
import auto.newsky.coding.po.User;
import auto.newsky.coding.po.UserExample;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * Created by Administrator on 2016/9/19.
 */
public class Test {
    public static void main(String[] args){
        ApplicationContext ac = new org.springframework.context.support.ClassPathXmlApplicationContext("spring/applicationContext-dao.xml");
        //UserMapper mapper = (UserMapper)ac.getBean("userMapper");
       /* UserExample userExample = new UserExample();
        userExample.createCriteria().andUserTokenEqualTo("12345");
        List<User> withUsers =  mapper.selectByExample(userExample);
        for (User user : withUsers){
            System.out.println(user.toString());
        }*/
       //InvitationMapper invitationMapper = (InvitationMapper) ac.getBean("invitationMapper");
        //invitationMapper.selectInvitationsUnType(1,10);
        //UserMapper mapper = (UserMapper)ac.getBean("userMapper");
        /*InvitationMapper invitationMapper = (InvitationMapper)ac.getBean("invitationMapper");
        System.out.println("--------------"+ mapper.selectByPrimaryKey(1).toString());*/
        //System.out.println("--------------"+ mapper.selectByPrimaryKey(1));
    }
}
