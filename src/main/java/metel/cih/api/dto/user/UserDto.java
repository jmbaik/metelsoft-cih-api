package metel.cih.api.dto.user;

import lombok.Data;

@Data
public class UserDto {
    private String uid;
    private String logId;
    private String name;
    private String nick;
    private String pwd;
    private String email;
    private String phone;
    private String phoneTag;
    private String gender;
    private String region;
    private String regionName;
    private String birth;
    private String church;
    private String grade;
    private String member;
    private String deviceId;
    private String regDt;
    private String updDt;
}
