package metel.cih.api.admin.controller;

import lombok.RequiredArgsConstructor;
import metel.cih.api.base.ApiResponse;
import metel.cih.api.base.ResponseDto;
import metel.cih.api.dto.AdminUserDto;
import metel.cih.api.admin.service.AdminUserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin-user")
@RequiredArgsConstructor
public class AdminUserController {

    private final AdminUserService service;

    @ResponseBody
    @PostMapping("/login")
    public ResponseDto<AdminUserDto> getAdminLoginInfo(@RequestBody AdminUserDto adminUserDto){
        AdminUserDto info = service.selectAdminLoginInfo(adminUserDto);
        if(info == null){
            return ApiResponse.Error("해당 사용자가 없습니다. 다시 입력하여 주십시요", null);
        }
        return ApiResponse.Success(info);
    }

}
