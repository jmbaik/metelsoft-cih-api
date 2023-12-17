package metel.cih.api.dto;

import lombok.Data;

@Data
public class CommentsDto {
    private String category;
    private String vid;
    private int commentId;
    private String comment;
    private String userId;
    private String nickName;
    private String phone;
    private String regDt;
    private String updDt;
}
