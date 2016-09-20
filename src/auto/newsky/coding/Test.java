package auto.newsky.coding;

import auto.newsky.coding.mapper.InvitationMapper;
import auto.newsky.coding.mapper.InvitationTypeMapper;
import auto.newsky.coding.mapper.JoinInvitationMapper;
import auto.newsky.coding.mapper.UserMapper;
import auto.newsky.coding.po.*;
import auto.newsky.coding.serviceImpl.InvitationImpl;
import auto.newsky.coding.serviceImpl.JoinInvitationImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/19.
 */
public class Test {
    public static void main(String[] args){

        ApplicationContext ac = new org.springframework.context.support.ClassPathXmlApplicationContext("spring/applicationContext-dao.xml");
        UserMapper userMapper = (UserMapper)ac.getBean("userMapper");
       /* UserExample userExample = new UserExample();
        userExample.createCriteria().andUserTokenEqualTo("12345");
        List<User> withUsers =  mapper.selectByExample(userExample);
        for (User user : withUsers){
            System.out.println(user.toString());
        }*/
        JoinInvitationMapper userJoinInvatationMapper = (JoinInvitationMapper)ac.getBean("joinInvitationMapper");
        //userJoinInvatationMapper.updateByPrimaryKeySelective(new JoinInvitation(11,null,null,true));

        JoinInvitationExample joinexample = new JoinInvitationExample();
        joinexample.or().andInvitIdEqualTo(15).andRelationIsDeleteEqualTo(false);
        List<JoinInvitation> joinList = userJoinInvatationMapper.selectByExample(joinexample);
        System.out.println(joinList.toString());
       //InvitationMapper invitationMapper = (InvitationMapper) ac.getBean("invitationMapper");
        //System.out.println(invitationMapper.selectInvitationsUnType(0,10).toString());
        //UserMapper mapper = (UserMapper)ac.getBean("userMapper");
        /*InvitationMapper invitationMapper = (InvitationMapper)ac.getBean("invitationMapper");
        System.out.println("--------------"+ mapper.selectByPrimaryKey(1).toString());*/
        //System.out.println("--------------"+ mapper.selectByPrimaryKey(1));
        /*JoinInvitationMapper joinInvitationMapper = (JoinInvitationMapper)ac.getBean("joinInvitationMapper");
        JoinInvitationExample joinInvitationExample = new JoinInvitationExample();
        joinInvitationExample.or().andUserIdEqualTo(1).andInvitIdEqualTo(1);
        List<JoinInvitation> joinInvitations =  joinInvitationMapper.selectByExample(joinInvitationExample);*/
        /*InvitationTypeMapper invitationTypeMapper = (InvitationTypeMapper)ac.getBean("invitationTypeMapper");
        InvitationType invitationType = invitationTypeMapper.selectByPrimaryKey(1);
        System.out.print(invitationType.getTypeParent());*/

        //joinInvitationMapper.is
        /*JoinInvitationExample joinInvitationExample = new JoinInvitationExample();
        joinInvitationExample.or().andInvitIdEqualTo(1).andRelationIsDeleteEqualTo(false);
        List<JoinInvitation> joinInvitations = joinInvitationMapper.selectByExample(joinInvitationExample);

        UserExample userExample = new UserExample();
        List<Integer> userIdList = new ArrayList<Integer>();
        for (JoinInvitation joinInvitation:joinInvitations){
            userIdList.add(joinInvitation.getUserId());
        }
        userExample.or().andUserIdIn(userIdList);
        List<User> userList = userMapper.selectByExample(userExample);

        System.out.println(joinInvitations.toString());
        System.out.println(userList.toString());*/
        //System.out.println(joinInvitationMapper.selectJoinMembers(1).toString());
    }
}
