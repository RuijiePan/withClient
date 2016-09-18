package auto.newsky.coding.mapper;


import auto.newsky.coding.po.Concern;

public interface ConcernMapper {
    int insert(Concern record);

    int insertSelective(Concern record);
}