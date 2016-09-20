package auto.newsky.coding.serviceImpl;

import auto.newsky.coding.mapper.InvitationMapper;
import auto.newsky.coding.mapper.InvitationTypeMapper;
import auto.newsky.coding.mapper.UserMapper;
import auto.newsky.coding.po.*;
import auto.newsky.coding.response.Result;
import auto.newsky.coding.resultdata.InvitationData;
import auto.newsky.coding.resultdata.InvitationListData;
import auto.newsky.coding.service.IInvitation;
import auto.newsky.coding.util.DateConveter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/16.
 */
@Service("invitationService")
public class InvitationImpl implements IInvitation{
    @Autowired
    private InvitationMapper invatationMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private InvitationTypeImpl invitationTypeService;
    @Autowired
    private JoinInvitationImpl joinInvitationService;
    @Autowired
    private UserImpl userService;
    @Override
    public boolean isSmallType(int typeId) {
        return false;
    }

    @Override
    public Result getInvitationsUnType(Integer myUserId, int lastInvitationId, int limit) {
        Result result = new Result();
        //获取未分类邀约
        List<Invitation> invitations = invatationMapper.selectInvitationsUnType(lastInvitationId,limit);
        InvitationListData invitationListData = packData(myUserId, invitations);
        if(invitations.size()>0){
            result.setData(invitationListData);
            return result;
        }
        result.setCode(450);
        result.setMsg("找不到数据");
        return result;
    }


    @Override
    public Result getInvitationsByTypeId(Integer myUserId, int typeId, int lastInvitationId, int limit) {
        Result result = new Result();
        List<Invitation> invitations = null;
        if (invitationTypeService.isParentType(typeId)){//大类查询
             invitations = invatationMapper.selectInvitationsByParentType(typeId,lastInvitationId,limit);
        }else{//小类查询
            invitations = invatationMapper.selectInvitationsByType(typeId,lastInvitationId,limit);
        }
        InvitationListData invitationListData = packData(myUserId, invitations);
        if(invitations.size()>0){
            result.setData(invitationListData);
            return result;
        }
        result.setCode(450);
        result.setMsg("找不到数据");
        return result;
    }

    @Override
    public Result getInvitationsSBSend(Integer myUserId, int userId, int lastInvitationId, int limit) {
        Result result = new Result();
        //获取某人的邀约列表
        List<Invitation> invitations = invatationMapper.selectInvitationsByUserId(userId,lastInvitationId,limit);
        InvitationListData invitationListData = packData(myUserId, invitations);
        if(invitations.size()>0){
            result.setData(invitationListData);
            return result;
        }
        result.setCode(450);
        result.setMsg("找不到数据");
        return result;
    }

    @Override
    public Result getInvitationsMyConcerned(Integer myUserId,  int lastInvitationId, int limit) {
        Result result = new Result();
        //获取我关注的的邀约列表
        List<Invitation> invitations = invatationMapper.selectInvitationsConcern(myUserId,lastInvitationId,limit);
        InvitationListData invitationListData = packData(myUserId, invitations);
        if(invitations.size()>0){
            result.setData(invitationListData);
            return result;
        }
        result.setCode(450);
        result.setMsg("找不到数据");
        return result;
    }



    @Override
    public Result publishInvitation(Invitation invatation) {
        Result result = new Result();
        invatation.setTypeParentId(invitationTypeService.getParentType(invatation.getTypeId()));
        if(invatationMapper.insert(invatation)>0){
            joinInvitationService.join(new JoinInvitation(invatation.getUserId(),invatation.getInvitId(),false));
            return result;
        }
        result.setCode(407);
        result.setMsg("数据库插入失败");
        return result;
    }

    @Override
    public Result alterInvitation(Invitation invitation) {
        Result result = new Result();
        if(invatationMapper.updateByPrimaryKeySelective(invitation)>0){
            return result;
        }
        result.setCode(408);
        result.setMsg("数据库更新失败");
        return result;
    }

    @Override
    public Result participateInvitation(Integer myUserId, Integer invitationId) {
        return null;
    }

    @Override
    public Result getInvitationsByUidAndPrimaryKey(Integer aimUserId, Integer invitId) {

        Result result = new Result();
        Invitation invitation = invatationMapper.selectByUidAndPrimaryKey(aimUserId, invitId);

        if (invitation==null){
            result.setData(null);
            result.setCode(407);
            result.setMsg("查找不到相对应的用户信息");
        }else {
            User user = userMapper.selectByPrimaryKey(invitation.getUserId());
            if (user!=null) {
                result.setData(user);
            }else {
                result.setData(null);
                result.setCode(407);
                result.setMsg("查找不到相对应的用户信息");
            }
        }
        return result;
    }


    @Override
    public Result applyInvitation(Integer myUserId, Integer invitationId) {
        return null;
    }

    @Override
    public Result quitInvitation(Integer myUserId, Integer invitationId) {
        return null;
    }

    @Override
    public Result deleteInvitation(Integer myUserId, Integer invitationId) {
        return null;
    }

    @Override
    public Result getConcernedUsers(Integer myUserId, Integer concernedUserId, Integer limit) {
        return null;
    }

    @Override
    public Result concernUser(Integer myUserId, Integer concernedUserId) {
        return null;
    }


    private InvitationListData packData(Integer myUserId, List<Invitation> invitations) {
        InvitationListData invitationListData = new InvitationListData();
        //进行包装
        List<InvitationListData.DataBean> dataBeanList = new ArrayList<InvitationListData.DataBean>();
        for (Invitation invitation:invitations) {
            InvitationListData.DataBean dataBean = new InvitationListData.DataBean();
            User user = userService.getUserByPrimaryKey(invitation.getUserId());
            dataBean.setOriginatorHeadUrl(user.getUserHeadurl());
            dataBean.setInvitationTime(DateConveter.dateToString(invitation.getInvitActivityTime()));
            dataBean.setPublishTime(DateConveter.dateToString(invitation.getInvitPublicationTime()));
            dataBean.setOriginatorNickname(user.getUserNickname());
            dataBean.setInvitaionId(invitation.getInvitId());
            dataBean.setCurrentNumber(invitation.getInvitNumberCurr());
            dataBean.setSexRequire(invitation.getInvitSexRequire());
            dataBean.setContent(invitation.getInvitContent());
            dataBean.setTitle(invitation.getInvitTitle());
            dataBean.setTotalNumber(invitation.getInvitNumberMax());
            dataBean.setPlace(invitation.getInvitPlace());
            dataBean.setIsJoin(joinInvitationService.isJoin(myUserId,invitation.getInvitId()));
            dataBean.setTypeId(invitation.getTypeId());
            List<InvitationListData.DataBean.MembersBean> membersBeanList = new ArrayList<InvitationListData.DataBean.MembersBean>();
            //获取某邀约的参与人
            List<User>  users =   joinInvitationService.selectJoinMembers(invitation.getInvitId(),invitation.getUserId());
            //进行包装
            InvitationListData.DataBean.MembersBean membersBean = new InvitationListData.DataBean.MembersBean();
            membersBean.setHeadUrl(user.getUserHeadurl());
            membersBean.setRealName(user.getUserRealname());
            membersBean.setUserId(user.getUserId());
            membersBean.setPhone(user.getUserMobilephone());
            membersBean.setSex(user.getUserSex());
            membersBeanList.add(membersBean);
            for (User user1:users){
                membersBean = new InvitationListData.DataBean.MembersBean();
                membersBean.setHeadUrl(user1.getUserHeadurl());
                membersBean.setRealName(user1.getUserRealname());
                membersBean.setUserId(user1.getUserId());
                membersBean.setPhone(user1.getUserMobilephone());
                membersBean.setSex(user1.getUserSex());
                membersBeanList.add(membersBean);
            }
            dataBean.setMembers(membersBeanList);

            dataBeanList.add(dataBean);
        }
        invitationListData.setData(dataBeanList);
        return invitationListData;
    }
}
