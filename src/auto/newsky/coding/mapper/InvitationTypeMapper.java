package auto.newsky.coding.mapper;

import auto.newsky.coding.po.InvitationType;
import auto.newsky.coding.po.InvitationTypeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InvitationTypeMapper {
    int countByExample(InvitationTypeExample example);

    int deleteByExample(InvitationTypeExample example);

    int deleteByPrimaryKey(Integer typeId);

    int insert(InvitationType record);

    int insertSelective(InvitationType record);

    List<InvitationType> selectByExample(InvitationTypeExample example);

    InvitationType selectByPrimaryKey(Integer typeId);

    int updateByExampleSelective(@Param("record") InvitationType record, @Param("example") InvitationTypeExample example);

    int updateByExample(@Param("record") InvitationType record, @Param("example") InvitationTypeExample example);

    int updateByPrimaryKeySelective(InvitationType record);

    int updateByPrimaryKey(InvitationType record);


}