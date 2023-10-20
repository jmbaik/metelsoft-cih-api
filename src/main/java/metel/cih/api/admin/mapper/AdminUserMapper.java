package metel.cih.api.admin.mapper;

import metel.cih.api.dto.AdminUserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminUserMapper {
    AdminUserDto selectAdminLoginInfo(AdminUserDto adminUserDto);
}
