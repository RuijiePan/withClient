package auto.newsky.coding.serviceImpl;

import auto.newsky.coding.mapper.InvitationMapper;
import auto.newsky.coding.mapper.JoinInvitationMapper;
import auto.newsky.coding.mapper.MessageMapper;
import auto.newsky.coding.po.Invitation;
import auto.newsky.coding.po.JoinInvitation;
import auto.newsky.coding.po.Message;
import auto.newsky.coding.po.MessageExample;
import auto.newsky.coding.response.Result;
import auto.newsky.coding.mapper.UserMapper;
import auto.newsky.coding.po.JoinInvitation;
import auto.newsky.coding.po.JoinInvitationExample;
import auto.newsky.coding.po.User;
import auto.newsky.coding.po.UserExample;
import auto.newsky.coding.resultdata.InvitationListData;
import auto.newsky.coding.service.IJoinInvitation;
import auto.newsky.coding.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/16.
 */
@Service("joinInviationService")
public class JoinInvitationImpl implements IJoinInvitation{

    @Autowired
    private JoinInvitationMapper userJoinInvatationMapper;
    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private InvitationMapper invitationMapper;

    @Autowired
    private UserMapper userMapper;
    @Override
    public Result acceptInvitation(Integer userId, Integer applyUserId, Integer invitationId,boolean isAccept) {
        Result result = new Result();

        if (userId==-1){
            result.setCode(401);
            result.setMsg("用户未登录");
        }
        if (userId!=-1){
            Invitation invitation = invitationMapper.selectByPrimaryKey(invitationId);

            if (isAccept) {
                JoinInvitation joinInvitation = new JoinInvitation(applyUserId, invitationId, false);
                if (userJoinInvatationMapper.insert(joinInvitation) > 0) {

                    if (invitation.getInvitNumberCurr() >= invitation.getInvitNumberMax()) {
                        invitation.setInvitNumberMax(invitation.getInvitNumberMax() + 1);
                        invitation.setInvitNumberCurr(invitation.getInvitNumberCurr() + 1);
                    } else {
                        invitation.setInvitNumberCurr(invitation.getInvitNumberCurr() + 1);
                    }
                    invitationMapper.updateByPrimaryKey(invitation);
                    /*MessageExample messageExample = new MessageExample();
                    messageExample.createCriteria().andInvitIdEqualTo(invitationId)
                            .andFromUserIdEqualTo(userId)
                            .andToUserIdEqualTo(applyUserId);
                    Message userMessage = messageMapper.selectByExample(messageExample).get(0);*/

                    Message message = new Message(userId, applyUserId, invitationId, 3,
                            DateUtil.getCurrentTime(), "您报名的" + invitation.getInvitTitle() + "活动已经被批准了", false, false);
                    messageMapper.insert(message);
                    result.setMsg("特批成功");
                } else {
                    result.setCode(413);
                    result.setMsg("特批失败");
                }
            }else {
                Message message = new Message(userId, applyUserId, invitationId, 4,
                        DateUtil.getCurrentTime(), "您报名的" + invitation.getInvitContent() + "活动已经被拒绝了", false, false);
                result.setMsg("申请特批未通过");
                messageMapper.insert(message);
            }
        }
        return result;
    }


    @Override
    public boolean isJoin(Integer userId, Integer invitationId) {
        JoinInvitationExample joinInvitationExample = new JoinInvitationExample();
        joinInvitationExample.or().andUserIdEqualTo(userId).andInvitIdEqualTo(invitationId).andRelationIsDeleteEqualTo(false);
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

    public boolean quit(Integer myUserId, Integer invitationId) {
        JoinInvitationExample joinexample = new JoinInvitationExample();
        joinexample.or().andUserIdEqualTo(myUserId).andInvitIdEqualTo(invitationId).andRelationIsDeleteEqualTo(false);
        List<JoinInvitation> joinList = userJoinInvatationMapper.selectByExample(joinexample);
        if (joinList == null ||joinList.size() <= 0){
            return false;
        }
        Integer relationId = joinList.get(0).getRelationId();
        if (userJoinInvatationMapper.updateByPrimaryKeySelective(new JoinInvitation(relationId,myUserId,invitationId,true))>0){
            return true;
        }
       // userJoinInvatationMapper.updateByExample();
       return false;
    }

    public boolean quit(Integer relationId) {
        if (userJoinInvatationMapper.updateByPrimaryKeySelective(new JoinInvitation(relationId,null,null,true))>0){
            return true;
        }
        return false;
    }

    public List<JoinInvitation> getAllByInvitationId(Integer invitId) {
        JoinInvitationExample joinexample = new JoinInvitationExample();
        joinexample.or().andInvitIdEqualTo(invitId).andRelationIsDeleteEqualTo(false);
        List<JoinInvitation> joinList = userJoinInvatationMapper.selectByExample(joinexample);
        return joinList;
    }
}
