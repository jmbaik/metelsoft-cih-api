package metel.cih.api.user.controller;

import lombok.RequiredArgsConstructor;
import metel.cih.api.base.ApiResponse;
import metel.cih.api.base.ResponseDto;
import metel.cih.api.base.constants.AppConstants;
import metel.cih.api.dto.user.UserDto;
import metel.cih.api.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("member")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @ResponseBody
    @GetMapping("/login")
    public ResponseDto<UserDto> loginUser(
            @RequestParam(value = "logId") String logId
            , @RequestParam(value = "pwd") String pwd
    ) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("logId", logId);
        map.put("pwd", pwd);
        List<UserDto> list = service.selectUsers(map);
        if (list.isEmpty()) {
            return new ResponseDto<>(AppConstants.ErrorCodeLoginNotExists, "로그인 정보가 없습니다.", null);
        }
        return ApiResponse.Success(list.get(0));
    }

    @ResponseBody
    @GetMapping("/fetch")
    public ResponseDto<List<UserDto>> fetchUser(
            @RequestParam Map<String, Object> paramMap
    ) {
        List<UserDto> list = service.selectUsers((HashMap<String, Object>) paramMap);
        return ApiResponse.Success(list);
    }

    @ResponseBody
    @PostMapping("/register")
    public ResponseDto<Integer> registerUser(@RequestBody UserDto dto) {
        // uid add
        String uid = service.getUserUid(dto);
        dto.setUid(uid);
        int result = service.mergeUser(dto);
        return ApiResponse.Success(result);
    }

    @ResponseBody
    @PostMapping("/update")
    public ResponseDto<Integer> updateUser(@RequestBody UserDto dto) {
        int result = service.mergeUser(dto);
        return ApiResponse.Success(result);
    }
    
}
