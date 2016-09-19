package auto.newsky.coding.serviceImpl;

import auto.newsky.coding.mapper.InvitationMapper;
import auto.newsky.coding.mapper.InvitationTypeMapper;
import auto.newsky.coding.po.Invitation;
import auto.newsky.coding.po.InvitationExample;
import auto.newsky.coding.po.InvitationType;
import auto.newsky.coding.po.InvitationTypeExample;
import auto.newsky.coding.response.Result;
import auto.newsky.coding.service.IInvitation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/9/16.
 */
@Service
public class InvitationImpl implements IInvitation{
    @Autowired
    private InvitationMapper invatationMapper;

    @Autowired
    private InvitationTypeImpl invitationTypeService;
    @Override
    public boolean isSmallType(int typeId) {
        return false;
    }

    @Override
    public Result getInvitationsUnType(Integer myUserId, int lastInvitationId, int limit) {
        Result result = new Result();
        InvitationExample invitationExample = new InvitationExample();

        if(invatationMapper.selectByExample(invitationExample).size()>0){
            return result;
        }

        result.setCode(407);
        result.setMsg("数据库插入失败");
        return result;
    }

    @Override
    public Result getInvitationsByTypeId(Integer myUserId, int typeId, int lastInvitationId, int limit) {
        Result result = new Result();
        if (invitationTypeService.isParentType(typeId)){//大类查询
           // invatationMapper.select
        }else{//小类查询

        }
        InvitationExample invitationExample = new InvitationExample();

        if(invatationMapper.selectByExample(invitationExample).size()>0){
            return result;
        }

        result.setCode(407);
        result.setMsg("数据库插入失败");
        return result;
    }

    @Override
    public Result getInvitationsSBSend(Integer myUserId, int userId, int lastInvitationId, int limit) {
        return null;
    }

    @Override
    public Result getInvitationsMyConcerned(Integer myUserId,  int lastInvitationId, int limit) {
        return null;
    }



    @Override
    public Result publishInvitation(Invitation invatation) {
        Result result = new Result();
        invatation.setTypeParentId(invitationTypeService.getParentType(invatation.getTypeId()));
        if(invatationMapper.insert(invatation)>0){
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


}
