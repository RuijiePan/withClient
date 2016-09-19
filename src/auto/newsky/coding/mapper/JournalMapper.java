package auto.newsky.coding.mapper;

import auto.newsky.coding.po.Journal;
import auto.newsky.coding.po.JournalExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JournalMapper {
    int countByExample(JournalExample example);

    int deleteByExample(JournalExample example);

    int deleteByPrimaryKey(Integer jourId);

    int insert(Journal record);

    int insertSelective(Journal record);

    List<Journal> selectByExample(JournalExample example);

    Journal selectByPrimaryKey(Integer jourId);

    int updateByExampleSelective(@Param("record") Journal record, @Param("example") JournalExample example);

    int updateByExample(@Param("record") Journal record, @Param("example") JournalExample example);

    int updateByPrimaryKeySelective(Journal record);

    int updateByPrimaryKey(Journal record);
}