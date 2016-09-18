package auto.newsky.coding.mapper;

import auto.newsky.coding.po.Invitation;

public interface InvitationMapper {
    int deleteByPrimaryKey(Integer invitId);

    int insert(Invitation record);

    int insertSelective(Invitation record);

    Invitation selectByPrimaryKey(Integer invitId);

    int updateByPrimaryKeySelective(Invitation record);

    int updateByPrimaryKey(Invitation record);
}