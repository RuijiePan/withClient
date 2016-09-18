package auto.newsky.coding.mapper;

import auto.newsky.coding.po.InvitationType;

public interface InvitationTypeMapper {
    int deleteByPrimaryKey(Integer typeId);

    int insert(InvitationType record);

    int insertSelective(InvitationType record);

    InvitationType selectByPrimaryKey(Integer typeId);

    int updateByPrimaryKeySelective(InvitationType record);

    int updateByPrimaryKey(InvitationType record);
}