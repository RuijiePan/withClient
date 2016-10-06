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

    List<Invitation>  selectInvitationsUnType(@Param("lastInvitationId") Integer lastInvitationId,@Param("limit") Integer limit);

    Invitation selectByUidAndPrimaryKey(@Param("aimUserId")Integer aimUserId,
                                        @Param("invitId")Integer invitId);

    List<Invitation> selectInvitationsByParentType(@Param("typeId")Integer typeId,@Param("lastInvitationId") Integer lastInvitationId, @Param("limit")Integer limit);

    List<Invitation> selectInvitationsByType(@Param("typeId")Integer typeId, @Param("lastInvitationId")Integer lastInvitationId, @Param("limit")Integer limit);


    List<Invitation> selectInvitationsByUserId(@Param("userId")Integer userId, @Param("lastInvitationId")Integer lastInvitationId, @Param("limit")Integer limit);

    List<Invitation> selectInvitationsConcern(@Param("myUserId")Integer myUserId, @Param("lastInvitationId")Integer lastInvitationId, @Param("limit")Integer limit);

    Integer getUserLastInvitationId(@Param("myUserId")Integer myUserId);

    List<Invitation> selectInvitationsPaticipateByMe(@Param("myUserId")Integer myUserId,@Param("lastInvitationId") Integer lastInvitationId,@Param("limit") Integer limit);
}