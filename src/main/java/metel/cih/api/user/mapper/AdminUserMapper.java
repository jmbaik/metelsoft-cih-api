package metel.cih.api.user.mapper;

import metel.cih.api.dto.AdminUserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminUserMapper {
    AdminUserDto selectAdminLoginInfo(AdminUserDto adminUserDto);
}
