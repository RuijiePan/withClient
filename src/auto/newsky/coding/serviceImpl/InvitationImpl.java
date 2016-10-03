package auto.newsky.coding.serviceImpl;

import auto.newsky.coding.constant.Constant;
import auto.newsky.coding.mapper.*;
import auto.newsky.coding.po.*;
import auto.newsky.coding.response.Result;
import auto.newsky.coding.resultdata.*;
import auto.newsky.coding.service.IInvitation;
import auto.newsky.coding.util.DateConveter;
import auto.newsky.coding.util.DateUtil;
import auto.newsky.coding.util.IpUtil;
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
    private InvitationMapper invitationMapper;
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
        //InvitationListData invitationListData = packData(myUserId, invitations);
        List<InvitationListData.DataBean> beenList = packData(myUserId, invitations);
        if(invitations.size()>0){
            result.setData(beenList);
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
        //InvitationListData invitationListData = packData(myUserId, invitations);

        List<InvitationListData.DataBean> beenList = packData(myUserId, invitations);
        if(invitations.size()>0){
            result.setData(beenList);
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
        //InvitationListData invitationListData = packData(myUserId, invitations);

        List<InvitationListData.DataBean> beenList = packData(myUserId, invitations);
        if(invitations.size()>0){
            result.setData(beenList);
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
        //InvitationListData invitationListData = packData(myUserId, invitations);

        List<InvitationListData.DataBean> beenList = packData(myUserId, invitations);
        if(invitations.size()>0){
            result.setData(beenList);
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
    public Result alterInvitation(Integer myUserId ,Invitation invitation) {
        Result result = new Result();

        if (invitation == null || invitation.getInvitIsDelete() == true){//
            result.setCode(454);
            result.setMsg("不存在活动");
            return result;
        }
        if (myUserId != invitation.getUserId()){
            result.setCode(453);
            result.setMsg("无权限");
            return result;
        }
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
        User user = userService.getUserByPrimaryKey(myUserId);
        if(joinInvitationService.join(new JoinInvitation(myUserId,invitationId,false))>0){
            Message message = new Message(myUserId, invitation.getUserId(), invitationId, Constant.MESSAGE_TYPE_ADD,
                    DateUtil.getCurrentTime(), user.getUserRealname()+"加入了" + invitation.getInvitTitle() + "活动", false, false);
            messageMapper.insert(message);

            //当前人数+1
            InvitationExample invitationExample = new InvitationExample();
            invitationExample.or().andInvitIdEqualTo(invitationId).andInvitIsDeleteEqualTo(false);
            List<Invitation>  invitations = invitationMapper.selectByExample(invitationExample);
            if (invitations != null&& invitations.size() > 0){
                Invitation invitationTemp = invitations.get(0);
                //invitationTemp.setInvitId(null);
                int num = invitationTemp.getInvitNumberCurr()+1 >= invitationTemp.getInvitNumberMax()?invitationTemp.getInvitNumberMax():invitationTemp.getInvitNumberCurr()+1;
                invitationTemp.setInvitNumberCurr(num);
                invitationMapper.updateByPrimaryKey(invitationTemp);
            }

            return result;
        }
        result.setCode(451);
        result.setMsg("参加邀约失败");
        return result;
    }


    @Override
    public Result getUserInfo(Integer myuserId,Integer aimUserId, Integer invitationId) {
        Result result = new Result();

        UserInfoData.DataBean dataBean = null;
        //先判断目标用户和我都参加了同一个活动
        if (joinInvitationService.isJoin(aimUserId,invitationId)&&joinInvitationService.isJoin(myuserId,invitationId)){
            User user = userService.getUserByPrimaryKey(aimUserId);
            if (user != null){
                dataBean = new UserInfoData.DataBean();
                dataBean.setPhone(user.getUserMobilephone());
                dataBean.setSex(user.getUserSex());
                dataBean.setIsConcerned(concernService.isConcerned(myuserId, aimUserId));
                dataBean.setStudentId(user.getUserStudentid());
                dataBean.setName(user.getUserRealname());
                dataBean.setHeadUrl(IpUtil.getPicUrl(user.getUserHeadurl()));
                dataBean.setQq(user.getUserQq());
                result.setData(dataBean);
            }else {
                result.setMsg("找不到用户");
                result.setCode(466);
                dataBean = new UserInfoData.DataBean("",0,false,"","","","");
                result.setData(dataBean);
            }
        }else{
            result.setMsg("无权限查改用户信息");
            result.setCode(467);
        }
        return result;
    }

    @Override
    public Result agreeInvitation(Integer myUserId, Integer aimId, Integer invitId,Integer messageId) {
        Result result = new Result();
        if(joinInvitationService.isJoin(myUserId,invitId)){
            result.setCode(452);
            result.setMsg("已经参加了");
            return result;
        }
        Invitation invitation = invatationMapper.selectByPrimaryKey(invitId);
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

        if(joinInvitationService.join(new JoinInvitation(myUserId,invitId,false))>0){
            Message message = new Message(myUserId, invitation.getUserId(), invitId, Constant.MESSAGE_TYPE_AGREE,
                    DateUtil.getCurrentTime(), "同意了你加入" + invitation.getInvitTitle() + "活动", false, false);
            messageMapper.insert(message);

            //已读处理
            MessageExample messageExample = new MessageExample();
            messageExample.or().andMsgIdEqualTo(messageId).andMsgIsReadEqualTo(false);
            Message message1 = new Message();
            message1.setMsgId(messageId);
            message1.setMsgIsRead(true);
            messageMapper.updateByExampleSelective(message1,messageExample);

            //当前人数+1
            InvitationExample invitationExample = new InvitationExample();
            invitationExample.or().andInvitIdEqualTo(invitId).andInvitIsDeleteEqualTo(false);
            List<Invitation>  invitations = invitationMapper.selectByExample(invitationExample);
            if (invitations != null&& invitations.size() > 0){
                Invitation invitationTemp = invitations.get(0);
                //invitationTemp.setInvitId(null);
                int num = invitationTemp.getInvitNumberCurr()+1 >= invitationTemp.getInvitNumberMax()?invitationTemp.getInvitNumberMax():invitationTemp.getInvitNumberCurr()+1;
                invitationTemp.setInvitNumberCurr(num);
                invitationMapper.updateByPrimaryKey(invitationTemp);
            }


            return result;
        }
        result.setCode(451);
        result.setMsg("同意邀约操作失败");
        return result;
    }

    @Override
    public Result rejectInvitation(Integer myUserId, Integer aimId, Integer invitId,Integer messageId) {
        Result result = new Result();
        if(joinInvitationService.isJoin(myUserId,invitId)){
            result.setCode(452);
            result.setMsg("已经参加了");
            return result;
        }
        Invitation invitation = invatationMapper.selectByPrimaryKey(invitId);
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
//
        Message message = new Message(myUserId, invitation.getUserId(), invitId, Constant.MESSAGE_TYPE_REJECT,
                DateUtil.getCurrentTime(), "拒绝了你加入" + invitation.getInvitTitle() + "活动", false, false);

        if(messageMapper.insert(message)>0){
            //已读处理
            MessageExample messageExample = new MessageExample();
            messageExample.or().andMsgIdEqualTo(messageId).andMsgIsReadEqualTo(false);
            Message message1 = new Message();
            message1.setMsgId(messageId);
            message1.setMsgIsRead(true);
            messageMapper.updateByExampleSelective(message1,messageExample);
            return result;
        }
        result.setCode(451);
        result.setMsg("拒绝邀约操作失败");
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

        MessageExample messageExample = new MessageExample();
        messageExample.or().andFromUserIdEqualTo(myUserId).andToUserIdEqualTo(invitation.getUserId()).andMsgIsReadEqualTo(false).andMsgIsDeleteEqualTo(false);
        List<Message> messages = messageMapper.selectByExample(messageExample);

        if (messages == null || messages.size() <=0){
            User user = userMapper.selectByPrimaryKey(myUserId);
            Message message = new Message(myUserId, invitation.getUserId(), invitationId, Constant.MESSAGE_TYPE_APPLY,
                    DateUtil.getCurrentTime(), user.getUserRealname()+"申请加入" + invitation.getInvitTitle() + "活动", false, false);
            messageMapper.insert(message);
        }else{
            result.setCode(454);
            result.setMsg("已经申请过了，等待处理");
        }
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
            result.setCode(200);
            result.setMsg("成功退出活动");
        }


        User user = userMapper.selectByPrimaryKey(myUserId);
        Message message = new Message(myUserId, invitation.getUserId(), invitationId, Constant.MESSAGE_TYPE_QUIT,
                DateUtil.getCurrentTime(), user.getUserRealname()+"退出了" + invitation.getInvitTitle() + "活动", false, false);
        messageMapper.insert(message);
        //人数-1
        InvitationExample invitationExample = new InvitationExample();
        invitationExample.or().andInvitIdEqualTo(invitationId).andInvitIsDeleteEqualTo(false);
        List<Invitation>  invitations = invitationMapper.selectByExample(invitationExample);
        if (invitations != null&& invitations.size() > 0){
            Invitation invitationTemp = invitations.get(0);
            int num = invitationTemp.getInvitNumberCurr()-1 <= 0?0:invitationTemp.getInvitNumberCurr()-1;
            invitationTemp.setInvitNumberCurr(num);
            invitationMapper.updateByPrimaryKey(invitationTemp);
        }

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
            result.setCode(456);
            result.setMsg("无法删除非自己的活动");
            return result;
        }

        //把参与关系表 所有人的参与关系去除
        List<JoinInvitation> joinInvitations = joinInvitationService.getAllByInvitationId(invitation.getInvitId());
        if (joinInvitations != null || joinInvitations.size() >0){
            for (JoinInvitation joinInvitation:joinInvitations){
                if(!joinInvitationService.quit(joinInvitation.getRelationId())){
                    result.setCode(457);
                    result.setMsg("解除活动关系失败");
                    return result;
                }
                Message message = new Message(myUserId, joinInvitation.getUserId(), invitationId, Constant.MESSAGE_TYPE_CANCEL,
                        DateUtil.getCurrentTime(), invitation.getInvitTitle() + "活动解散", false, false);
                messageMapper.insert(message);
            }
        }
        //该活动设置为删除
        invitation.setInvitIsDelete(true);
        invatationMapper.updateByPrimaryKeySelective(invitation);
        //User user = userMapper.selectByPrimaryKey(myUserId);
        result.setCode(451);
        return result;
    }

    @Override
    public Result getConcernedUsers(Integer myUserId, Integer concernedUserId, Integer limit) {

        Result result = new Result();
       // ConcernUserListData concernUserListData = null;
        List<ConcernUserListData.DataBean > dataBeanList ;
        ConcernUserListData.DataBean dataBean = null;

        List<User> userList = concernMapper.getConcernedUsers(myUserId,concernedUserId,limit);
        if (userList!=null ){
            //concernUserListData = new ConcernUserListData();
            dataBeanList = new ArrayList<ConcernUserListData.DataBean>();
            for (User user:userList){
                dataBean = new ConcernUserListData.DataBean();
                dataBean.setHeadUrl(IpUtil.getPicUrl(user.getUserHeadurl()));
                dataBean.setConcernedUserId(user.getUserId());
                dataBean.setConcerned(true);
                dataBean.setName(user.getUserNickname());
                dataBeanList.add(dataBean);
            }
            //concernUserListData.setData(dataBeanList);
            result.setData(dataBeanList);
            return result;
        }
        result.setCode(412);
        result.setMsg("该信息不存在");
        return result;
    }

    @Override
    public Result concernUser(Integer myUserId, Integer concernedUserId) {
        Result result = new Result();
        if (myUserId == concernedUserId){
            result.setCode(458);
            result.setMsg("自己不能关注自己");
            return result;
        }
        ConcernUserData concernUserData = new ConcernUserData();
        Concern concern = concernService.getConcerne(myUserId,concernedUserId);
        if (concern != null) {
            //Concern concern = concernService.getConcerneTrue(myUserId, concernedUserId);
            if (concernService.isConcerned(myUserId,concernedUserId)) {
                if (concernService.cancelConcerneUser(concern)) {
                    result.setCode(459);
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


    private List<InvitationListData.DataBean> packData(Integer myUserId, List<Invitation> invitations) {
        InvitationListData invitationListData = new InvitationListData();
        //进行包装
        List<InvitationListData.DataBean> dataBeanList = new ArrayList<InvitationListData.DataBean>();
        for (Invitation invitation:invitations) {
            InvitationListData.DataBean dataBean = new InvitationListData.DataBean();
            User user = userService.getUserByPrimaryKey(invitation.getUserId());
            dataBean.setOriginatorHeadUrl(IpUtil.getPicUrl(user.getUserHeadurl()));
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
            dataBean.setIconUrl(invitation.getTypeId()+"");
            List<InvitationListData.DataBean.MembersBean> membersBeanList = new ArrayList<InvitationListData.DataBean.MembersBean>();
            //获取某邀约的参与人
            List<User>  users =   joinInvitationService.selectJoinMembers(invitation.getInvitId(),invitation.getUserId());
            //进行包装
            InvitationListData.DataBean.MembersBean membersBean = new InvitationListData.DataBean.MembersBean();
            membersBean.setHeadUrl(IpUtil.getPicMinUrl(user.getUserHeadurl()));
            membersBean.setRealName(user.getUserRealname());
            membersBean.setUserId(user.getUserId());
            membersBean.setPhone(user.getUserMobilephone());
            membersBean.setSex(user.getUserSex());
            membersBeanList.add(membersBean);
            if(users!=null)
                for (User user1:users){
                    membersBean = new InvitationListData.DataBean.MembersBean();
                    membersBean.setHeadUrl(IpUtil.getPicMinUrl(user1.getUserHeadurl()));
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
        return dataBeanList;
    }


    @Override
    public Result getInvitationsByUidAndPrimaryKey(Integer aimUserId, Integer invitId) {

        Result result = new Result();
        Invitation invitation = invatationMapper.selectByUidAndPrimaryKey(aimUserId, invitId);

        if (invitation==null){
            result.setData(null);
            result.setCode(412);
            result.setMsg("该信息不存在");
        }else {
            User user = userMapper.selectByPrimaryKey(invitation.getUserId());
            if (user!=null) {
                result.setData(user);
            }else {
                result.setData(null);
                result.setCode(412);
                result.setMsg("该信息不存在");
            }
        }
        return result;
    }
}
