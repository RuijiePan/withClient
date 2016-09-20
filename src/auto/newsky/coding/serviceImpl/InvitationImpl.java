package auto.newsky.coding.serviceImpl;

import auto.newsky.coding.mapper.*;
import auto.newsky.coding.po.*;
import auto.newsky.coding.response.Result;
import auto.newsky.coding.resultdata.ConcernUserData;
import auto.newsky.coding.resultdata.ConcernUserListData;
import auto.newsky.coding.resultdata.InvitationData;
import auto.newsky.coding.resultdata.InvitationListData;
import auto.newsky.coding.service.IInvitation;
import auto.newsky.coding.util.DateConveter;
import auto.newsky.coding.util.DateUtil;
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
    private MessageMapper messageMapper;
    @Autowired
    private ConcernMapper concernMapper;
    @Autowired
    private InvitationTypeImpl invitationTypeService;
    @Autowired
    private JoinInvitationImpl joinInvitationService;
    @Autowired
    private UserImpl userService;
    @Autowired
    private ConcernImpl concernService;
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
        if (invitationTypeService.isParentType(invatation.getTypeId())){
            result.setCode(451);
            result.setMsg("类别错误");
            return result;
        }
        invatation.setTypeParentId(invitationTypeService.getParentType(invatation.getTypeId()));
        if((invatationMapper.insert(invatation))>0){
            invatation.setInvitId(invatationMapper.getUserLastInvitationId(invatation.getUserId()));
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
        Result result = new Result();
        if(joinInvitationService.isJoin(myUserId,invitationId)){
            result.setCode(452);
            result.setMsg("已经参加了");
            return result;
        }
        Invitation invitation = invatationMapper.selectByPrimaryKey(invitationId);
        if (invitation == null || invitation.getInvitIsDelete() == true){//
            result.setCode(454);
            result.setMsg("不存在活动");
            return result;
        }
        if (myUserId == invitation.getUserId()){
            result.setCode(453);
            result.setMsg("自己的活动不需要参加");
            return result;
        }
        if(joinInvitationService.join(new JoinInvitation(myUserId,invitationId,false))>0){
            Message message = new Message(myUserId, invitation.getUserId(), invitationId, 1,
                    DateUtil.getCurrentTime(), "成功加入" + invitation.getInvitTitle() + "活动", false, false);
            messageMapper.insert(message);
            return result;
        }
        result.setCode(451);
        result.setMsg("参加邀约失败");
        return result;
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
        Result result = new Result();
        if(joinInvitationService.isJoin(myUserId,invitationId)){
            result.setCode(456);
            result.setMsg("已经参加了，无需申请");
            return result;
        }
        Invitation invitation = invatationMapper.selectByPrimaryKey(invitationId);
        if (invitation == null || invitation.getInvitIsDelete() == true){//
            result.setCode(454);
            result.setMsg("不存在活动");
            return result;
        }
        if (myUserId == invitation.getUserId()){
            result.setCode(453);
            result.setMsg("自己的活动不需要申请");
            return result;
        }
        Message message = new Message(myUserId, invitation.getUserId(), invitationId, 0,
                DateUtil.getCurrentTime(), "向房主申请加入" + invitation.getInvitTitle() + "活动", false, false);
        messageMapper.insert(message);

        result.setCode(451);
        return result;
    }

    @Override
    public Result quitInvitation(Integer myUserId, Integer invitationId) {
        Result result = new Result();
        if(!joinInvitationService.isJoin(myUserId,invitationId)){
            result.setCode(456);
            result.setMsg("没有参加该活动");
            return result;
        }

        Invitation invitation = invatationMapper.selectByPrimaryKey(invitationId);
        if (invitation == null || invitation.getInvitIsDelete() == true){//
            result.setCode(454);
            result.setMsg("不存在活动");
            return result;
        }
        if (myUserId == invitation.getUserId()){
            result.setCode(453);
            result.setMsg("自己的活动不能退出");
            return result;
        }
        if (joinInvitationService.quit(myUserId,invitationId)){
            result.setCode(460);
            result.setMsg("成功退出活动");
        }

        User user = userMapper.selectByPrimaryKey(myUserId);
        Message message = new Message(myUserId, invitation.getUserId(), invitationId, 0,
                DateUtil.getCurrentTime(), user.getUserRealname()+"退出了" + invitation.getInvitTitle() + "活动", false, false);
        messageMapper.insert(message);

        result.setCode(451);
        return result;
    }

    @Override
    public Result deleteInvitation(Integer myUserId, Integer invitationId) {
        //记得删掉参与
        Result result = new Result();
        Invitation invitation = invatationMapper.selectByPrimaryKey(invitationId);
        if (invitation == null || invitation.getInvitIsDelete() == true){//
            result.setCode(454);
            result.setMsg("不存在活动");
            return result;
        }
        if (myUserId != invitation.getUserId()){
            result.setCode(453);
            result.setMsg("无法删除非自己的活动");
            return result;
        }

        List<JoinInvitation> joinInvitations = joinInvitationService.getAllByInvitationId(invitation.getInvitId());
        if (joinInvitations != null || joinInvitations.size() >0){
            for (JoinInvitation joinInvitation:joinInvitations){
                if(!joinInvitationService.quit(joinInvitation.getRelationId())){
                    result.setMsg("解除活动关系失败");
                    return result;
                }
                Message message = new Message(myUserId, invitation.getUserId(), invitationId, 0,
                        DateUtil.getCurrentTime(), invitation.getInvitTitle() + "活动解散", false, false);
                messageMapper.insert(message);
            }
        }
        invitation.setInvitIsDelete(true);
        invatationMapper.updateByPrimaryKeySelective(invitation);
        //User user = userMapper.selectByPrimaryKey(myUserId);
        result.setCode(451);
        return result;
    }

    @Override
    public Result getConcernedUsers(Integer myUserId, Integer concernedUserId, Integer limit) {
        Result result = new Result();
        ConcernUserListData concernUserListData = null;
        List<ConcernUserListData.DataBean > dataBeanList ;
        ConcernUserListData.DataBean dataBean = null;

        List<User> userList = concernMapper.getConcernedUsers(myUserId,concernedUserId,limit);
        if (userList!=null ){
            concernUserListData = new ConcernUserListData();
            dataBeanList = new ArrayList<ConcernUserListData.DataBean>();
            for (User user:userList){
                dataBean = new ConcernUserListData.DataBean();
                dataBean.setHeadUrl(user.getUserHeadurl());
                dataBean.setConcernedUserId(user.getUserId());
                dataBean.setIsConcerned(true);
                dataBean.setName(user.getUserNickname());
                dataBeanList.add(dataBean);
            }
            concernUserListData.setData(dataBeanList);
            result.setData(concernUserListData);
            return result;
        }
        result.setCode(466);
        result.setMsg("找不到数据");
        return result;
    }

    @Override
    public Result concernUser(Integer myUserId, Integer concernedUserId) {
        Result result = new Result();
        if (myUserId == concernedUserId){
            result.setMsg("自己不能关注自己");
            return result;
        }
        ConcernUserData concernUserData = new ConcernUserData(false);
        Concern concern = concernService.getConcerne(myUserId,concernedUserId);
        if (concern != null) {
            //Concern concern = concernService.getConcerneTrue(myUserId, concernedUserId);
            if (concernService.isConcerned(myUserId,concernedUserId)) {
                if (concernService.cancelConcerneUser(concern)) {
                    result.setMsg("取消关注成功");
                    concernUserData.setConcerned(false);
                }
            } else {
                if (concernService.concerneUser(concern)) {
                    result.setMsg("关注成功");
                    concernUserData.setConcerned(true);
                }
            }
        }else{
            if (concernService.insertConcern(myUserId,concernedUserId)){
                result.setMsg("关注成功");
                concernUserData.setConcerned(true);
            }
        }
        result.setData(concernUserData);
        return result;
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
