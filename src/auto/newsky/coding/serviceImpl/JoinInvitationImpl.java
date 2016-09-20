package auto.newsky.coding.serviceImpl;

import auto.newsky.coding.mapper.JoinInvitationMapper;
import auto.newsky.coding.mapper.UserMapper;
import auto.newsky.coding.po.JoinInvitation;
import auto.newsky.coding.po.JoinInvitationExample;
import auto.newsky.coding.po.User;
import auto.newsky.coding.po.UserExample;
import auto.newsky.coding.resultdata.InvitationListData;
import auto.newsky.coding.service.IJoinInvitation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/16.
 */
@Service
public class JoinInvitationImpl implements IJoinInvitation{
    @Autowired
    private JoinInvitationMapper userJoinInvatationMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean isJoin(Integer userId, Integer invitationId) {
        JoinInvitationExample joinInvitationExample = new JoinInvitationExample();
        joinInvitationExample.or().andUserIdEqualTo(userId).andInvitIdEqualTo(invitationId);
        List<JoinInvitation> joinInvitations =  userJoinInvatationMapper.selectByExample(joinInvitationExample);
        return joinInvitations.size()>0?true:false;
    }

    @Override
    public List<User> selectJoinMembers(Integer invitId,Integer myUserId) {
        /*JoinInvitationExample joinInvitationExample = new JoinInvitationExample();
        joinInvitationExample.or().andInvitIdEqualTo(invitId).andRelationIsDeleteEqualTo(false);
        List<JoinInvitation> joinInvitations = userJoinInvatationMapper.selectByExample(joinInvitationExample);

        UserExample userExample = new UserExample();
        List<Integer> userIdList = new ArrayList<Integer>();
        for (JoinInvitation joinInvitation:joinInvitations){
            userIdList.add(joinInvitation.getUserId());
        }
        userExample.or().andUserIdIn(userIdList);
        List<User> userList = userMapper.selectByExample(userExample);*/
        List<User> userList = userJoinInvatationMapper.selectJoinMembers(invitId,myUserId);
        return userList;
    }
    public int join(JoinInvitation joinInvitation){
        return userJoinInvatationMapper.insert(joinInvitation);
    }
}
