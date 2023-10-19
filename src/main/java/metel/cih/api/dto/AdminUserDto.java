package metel.cih.api.dto;

import lombok.Data;

@Data
public class AdminUserDto {
    private String email;
    private String password;
    private String phone;
    private String name;
    private String userId;

    private String regDate;
    private String updDate;

    private String cCode;
    private String adminLevel;

    private String churchName;

    private String pic;

    private String token;
}
