package auto.newsky.coding.mapper;

import auto.newsky.coding.po.Version;
import auto.newsky.coding.po.VersionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VersionMapper {
    int countByExample(VersionExample example);

    int deleteByExample(VersionExample example);

    int deleteByPrimaryKey(Integer versionId);

    int insert(Version record);

    int insertSelective(Version record);

    List<Version> selectByExample(VersionExample example);

    Version selectByPrimaryKey(Integer versionId);

    int updateByExampleSelective(@Param("record") Version record, @Param("example") VersionExample example);

    int updateByExample(@Param("record") Version record, @Param("example") VersionExample example);

    int updateByPrimaryKeySelective(Version record);

    int updateByPrimaryKey(Version record);
}