package auto.newsky.coding.mapper;

import auto.newsky.coding.po.Concern;
import auto.newsky.coding.po.ConcernExample;
import auto.newsky.coding.po.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ConcernMapper {
    int countByExample(ConcernExample example);

    int deleteByExample(ConcernExample example);

    int deleteByPrimaryKey(Integer conId);

    int insert(Concern record);

    int insertSelective(Concern record);

    List<Concern> selectByExample(ConcernExample example);

    Concern selectByPrimaryKey(Integer conId);

    int updateByExampleSelective(@Param("record") Concern record, @Param("example") ConcernExample example);

    int updateByExample(@Param("record") Concern record, @Param("example") ConcernExample example);

    int updateByPrimaryKeySelective(Concern record);

    int updateByPrimaryKey(Concern record);

    List<User> getConcernedUsers(@Param("myUserId")Integer myUserId, @Param("concernedUserId")Integer concernedUserId, @Param("limit")Integer limit);

    List<Concern> getConcerneTrue(@Param("myUserId")Integer myUserId, @Param("concernedUserId")Integer concernedUserId);
}