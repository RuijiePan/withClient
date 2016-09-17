package auto.newsky.coding.serviceImpl;

import auto.newsky.coding.mapper.InvatationMapper;
import auto.newsky.coding.po.InvitationData;
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
    public InvitationData getInvitationsUnType(String token, int lastInvitationId, int limit) {
        return null;
    }

    @Override
    public InvitationData getInvitationsSmallType(String token, int typeId, int lastInvitationId, int limit) {
        return null;
    }

    @Override
    public InvitationData getInvitationsBigType(String token, int typeId, int lastInvitationId, int limit) {
        return null;
    }

    @Override
    public InvitationData getInvitationsSBSend(String token, int userId, int lastInvitationId, int limit) {
        return null;
    }

    @Override
    public InvitationData getInvitationsMyConcerned(String token,  int lastInvitationId, int limit) {
        return null;
    }
}
