package auto.newsky.coding.mapper;

import auto.newsky.coding.po.Journal;

public interface JournalMapper {
    int deleteByPrimaryKey(Integer jourId);

    int insert(Journal record);

    int insertSelective(Journal record);

    Journal selectByPrimaryKey(Integer jourId);

    int updateByPrimaryKeySelective(Journal record);

    int updateByPrimaryKey(Journal record);
}