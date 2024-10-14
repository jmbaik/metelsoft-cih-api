package metel.cih.api.user.mapper;


import metel.cih.api.dto.user.UserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface UserMapper {
    List<UserDto> selectUsers(HashMap<String, Object> map);

    String getUserUid(UserDto user);

    int mergeUser(UserDto userDto);
}
