package metel.cih.api.user.service;

import lombok.RequiredArgsConstructor;
import metel.cih.api.dto.AdminUserDto;
import metel.cih.api.user.mapper.AdminUserMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminUserService {

    private final AdminUserMapper mapper;

    public AdminUserDto selectAdminLoginInfo(AdminUserDto adminUserDto){
        return mapper.selectAdminLoginInfo(adminUserDto);
    }

}
