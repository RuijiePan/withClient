package auto.newsky.coding.service;

import auto.newsky.coding.po.Invatation;
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

    Result concernUser(int userId, String concernedUserId);

    Result getConcernedUsers();

    Result publishInvitation(Invatation invatation);
}
