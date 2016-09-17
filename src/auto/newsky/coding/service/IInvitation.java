package auto.newsky.coding.service;

import auto.newsky.coding.po.InvitationData;

import java.util.List;

/**
 * Created by Administrator on 2016/9/16.
 */
public interface IInvitation {
    boolean isSmallType(int typeId);
    InvitationData getInvitationsUnType(String token,int lastInvitationId,int limit);
    InvitationData getInvitationsSmallType(String token,int typeId,int lastInvitationId,int limit);
    InvitationData getInvitationsBigType(String token,int typeId,int lastInvitationId,int limit);
    InvitationData getInvitationsSBSend(String token,int userId,int lastInvitationId,int limit);
    InvitationData getInvitationsMyConcerned(String token,int lastInvitationId,int limit);

}
