package auto.newsky.coding.service;

import auto.newsky.coding.po.Invitation;
import auto.newsky.coding.response.Result;

/**
 * Created by Administrator on 2016/9/16.
 */
public interface IInvitation {
    boolean isSmallType(int typeId);
    Result getInvitationsUnType(Integer myUserId,int lastInvitationId,int limit);
    Result getInvitationsByTypeId(Integer myUserId,int typeId,int lastInvitationId,int limit);
    Result getInvitationsSBSend(Integer myUserId,int userId,int lastInvitationId,int limit);
    Result getInvitationsMyConcerned(Integer myUserId,int lastInvitationId,int limit);
    
    Result publishInvitation(Invitation invatation);

    Result alterInvitation(Invitation invitation);

    Result participateInvitation(Integer myUserId, Integer invitationId);

    Result applyInvitation(Integer myUserId, Integer invitationId);

    Result quitInvitation(Integer myUserId, Integer invitationId);

    Result deleteInvitation(Integer myUserId, Integer invitationId);

    Result getConcernedUsers(Integer myUserId, Integer concernedUserId, Integer limit);

    Result concernUser(Integer myUserId, Integer concernedUserId);
}
