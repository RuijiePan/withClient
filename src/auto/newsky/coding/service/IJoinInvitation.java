package auto.newsky.coding.service;

import auto.newsky.coding.response.Result;

import auto.newsky.coding.po.User;
import auto.newsky.coding.resultdata.InvitationListData;

import java.util.List;

/**
 * Created by Administrator on 2016/9/16.
 */
public interface IJoinInvitation {
    boolean isJoin(Integer userId,Integer invitationId);

    Result acceptInvitation(Integer userId,Integer applyUserId,Integer invitationId,boolean isAccept);
    List<User> selectJoinMembers(Integer invitId,Integer myUserId);
}
