package auto.newsky.coding.service;

import auto.newsky.coding.po.Invitation;
import auto.newsky.coding.response.Result;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2016/9/16.
 */
public interface IInvitation {

    boolean isSmallType(int typeId);

    Result getInvitationsUnType(Integer myUserId,int lastInvitationId,int limit,HttpServletRequest request);

    Result getInvitationsByTypeId(Integer myUserId,int typeId,int lastInvitationId,int limit,HttpServletRequest request);

    Result getInvitationsSBSend(Integer myUserId,int userId,int lastInvitationId,int limit,HttpServletRequest request);

    Result getInvitationsMyConcerned(Integer myUserId,int lastInvitationId,int limit,HttpServletRequest request);

    Result alterInvitation(Integer myuserid ,Invitation invitation);

    Result participateInvitation(Integer myUserId, Integer invitationId);

    Result applyInvitation(Integer myUserId, Integer invitationId);

    Result quitInvitation(Integer myUserId, Integer invitationId);

    Result deleteInvitation(Integer myUserId, Integer invitationId);

    Result getConcernedUsers(Integer myUserId, Integer concernedUserId, Integer limit,HttpServletRequest request);

    Result concernUser(Integer myUserId, Integer concernedUserId);

    Result publishInvitation(Invitation invitation);

    Result getInvitationsByUidAndPrimaryKey(Integer myUserId,Integer invitId);

    Result getUserInfo(Integer myuserId,Integer aimUserId, Integer invitationId,HttpServletRequest request);


    Result agreeInvitation(Integer myUserId, Integer aimId, Integer invitId, Integer messageId);

    Result rejectInvitation(Integer myUserId, Integer aimId, Integer invitId, Integer messageId);

    Result getInvitationsPaticipateByMe(Integer myUserId, Integer lastInvitationId, Integer limit,HttpServletRequest request);
}
