package auto.newsky.coding.mapper;

import auto.newsky.coding.po.JoinInvitation;
import auto.newsky.coding.po.JoinInvitationExample;
import auto.newsky.coding.po.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JoinInvitationMapper {
    int countByExample(JoinInvitationExample example);

    int deleteByExample(JoinInvitationExample example);

    int deleteByPrimaryKey(Integer relationId);

    int insert(JoinInvitation record);

    int insertSelective(JoinInvitation record);

    List<JoinInvitation> selectByExample(JoinInvitationExample example);

    JoinInvitation selectByPrimaryKey(Integer relationId);

    int updateByExampleSelective(@Param("record") JoinInvitation record, @Param("example") JoinInvitationExample example);

    int updateByExample(@Param("record") JoinInvitation record, @Param("example") JoinInvitationExample example);

    int updateByPrimaryKeySelective(JoinInvitation record);

    int updateByPrimaryKey(JoinInvitation record);

    List<User> selectJoinMembers(@Param("invitId")Integer invitId,@Param("myUserId") Integer myUserId);//获取参与人，不包括自己
}