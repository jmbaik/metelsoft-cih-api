package metel.cih.api.admin.service;

import lombok.RequiredArgsConstructor;
import metel.cih.api.dto.AdminUserDto;
import metel.cih.api.admin.mapper.AdminUserMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminUserService {

    private final AdminUserMapper mapper;

    public AdminUserDto selectAdminLoginInfo(AdminUserDto adminUserDto){
        return mapper.selectAdminLoginInfo(adminUserDto);
    }

}
