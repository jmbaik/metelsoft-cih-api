package metel.cih.api.dto;

import lombok.Data;

@Data
public class AdminUserDto {
    private String uid;
    private String email;
    private String phone;
    private String password;
    private String adminLevel;
    private String churchCode;
    private String churchName;
    private String churchPic;
    private String name;
    private String nickName;
    private String comment;
    private String pic;
    private String token;
    private String regId;
    private String regDate;
    private String updId;
    private String updDate;
}
