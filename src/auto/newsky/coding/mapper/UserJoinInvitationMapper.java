package auto.newsky.coding.mapper;

import auto.newsky.coding.po.UserJoinInvitation;

public interface UserJoinInvitationMapper {
    int insert(UserJoinInvitation record);

    int insertSelective(UserJoinInvitation record);
}