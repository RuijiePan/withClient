package auto.newsky.coding.serviceImpl;

import auto.newsky.coding.po.Invatation;
import auto.newsky.coding.mapper.InvatationMapper;
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
    private InvatationMapper invatationMapper;

    @Override
    public boolean isSmallType(int typeId) {
        return false;
    }

    @Override
    public Result getInvitationsUnType(Integer myUserId, int lastInvitationId, int limit) {
        return null;
    }

    @Override
    public Result getInvitationsByTypeId(Integer myUserId, int typeId, int lastInvitationId, int limit) {
        return null;
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
    public Result concernUser(int userId, String concernedUserId) {
        return new Result();
    }

    @Override
    public Result getConcernedUsers() {
        return new Result();
    }

    @Override
    public Result publishInvitation(Invatation invatation) {
        return null;
    }
}
