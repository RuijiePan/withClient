package auto.newsky.coding.mapper;

import auto.newsky.coding.po.JoinInvitation;
import auto.newsky.coding.po.JoinInvitationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JoinInvitationMapper {
    int countByExample(JoinInvitationExample example);

    int deleteByExample(JoinInvitationExample example);

    int insert(JoinInvitation record);

    int insertSelective(JoinInvitation record);

    List<JoinInvitation> selectByExample(JoinInvitationExample example);

    int updateByExampleSelective(@Param("record") JoinInvitation record, @Param("example") JoinInvitationExample example);

    int updateByExample(@Param("record") JoinInvitation record, @Param("example") JoinInvitationExample example);
}