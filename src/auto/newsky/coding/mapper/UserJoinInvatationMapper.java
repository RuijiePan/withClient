package auto.newsky.coding.mapper;

import auto.newsky.coding.po.UserJoinInvatation;

public interface UserJoinInvatationMapper {
    int insert(UserJoinInvatation record);

    int insertSelective(UserJoinInvatation record);
}