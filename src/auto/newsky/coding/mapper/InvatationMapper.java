package auto.newsky.coding.mapper;

import auto.newsky.coding.po.Invatation;

public interface InvatationMapper {
    int deleteByPrimaryKey(Integer invitId);

    int insert(Invatation record);

    int insertSelective(Invatation record);

    Invatation selectByPrimaryKey(Integer invitId);

    int updateByPrimaryKeySelective(Invatation record);

    int updateByPrimaryKey(Invatation record);
}