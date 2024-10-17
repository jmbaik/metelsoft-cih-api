package metel.cih.api.dto.user;

import lombok.Data;

@Data
public class UserDto {
    private String uid;
    private String log_id;
    private String name;
    private String nick;
    private String pwd;
    private String email;
    private String phone;
    private String phone_tag;
    private String gender;
    private String region;
    private String region_name;
    private String birth;
    private String church;
    private String grade;
    private String member;
    private String device_id;
    private String regdt;
    private String upddt;
}
