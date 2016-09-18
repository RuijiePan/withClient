package auto.newsky.coding.mapper;

public interface JournalMapper {
    int deleteByPrimaryKey(Integer jourId);

    int insert(Journal record);

    int insertSelective(Journal record);

    Journal selectByPrimaryKey(Integer jourId);

    int updateByPrimaryKeySelective(Journal record);

    int updateByPrimaryKey(Journal record);
}