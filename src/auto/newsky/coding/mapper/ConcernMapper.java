package auto.newsky.coding.mapper;

import auto.newsky.coding.po.Concern;
import auto.newsky.coding.po.ConcernExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ConcernMapper {
    int countByExample(ConcernExample example);

    int deleteByExample(ConcernExample example);

    int insert(Concern record);

    int insertSelective(Concern record);

    List<Concern> selectByExample(ConcernExample example);

    int updateByExampleSelective(@Param("record") Concern record, @Param("example") ConcernExample example);

    int updateByExample(@Param("record") Concern record, @Param("example") ConcernExample example);
}