package auto.newsky.coding.mapper;

import auto.newsky.coding.po.Invitation;
import auto.newsky.coding.po.InvitationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InvitationMapper {
    int countByExample(InvitationExample example);

    int deleteByExample(InvitationExample example);

    int deleteByPrimaryKey(Integer invitId);

    int insert(Invitation record);

    int insertSelective(Invitation record);

    List<Invitation> selectByExample(InvitationExample example);

    Invitation selectByPrimaryKey(Integer invitId);

    int updateByExampleSelective(@Param("record") Invitation record, @Param("example") InvitationExample example);

    int updateByExample(@Param("record") Invitation record, @Param("example") InvitationExample example);

    int updateByPrimaryKeySelective(Invitation record);

    int updateByPrimaryKey(Invitation record);
}