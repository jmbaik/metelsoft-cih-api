package metel.cih.api.dto;

import lombok.Data;

@Data
public class UsersDto {
    private String uid;
    private String email;
    private String name;
    private String nickName;
    private String phone;
    private String grade;
    private String delYn;
    private String last;
    private String regDt;
    private String updDt;
}
