package metel.cih.api.user.service;


import lombok.RequiredArgsConstructor;
import metel.cih.api.dto.user.UserDto;
import metel.cih.api.user.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;

    public List<UserDto> selectUsers(HashMap<String, Object> map) {
        return mapper.selectUsers(map);
    }

    public String getUserUid(UserDto userDto) {
        return mapper.getUserUid(userDto);
    }
    
    public int mergeUser(UserDto userDto) {
        return mapper.mergeUser(userDto);
    }
}
