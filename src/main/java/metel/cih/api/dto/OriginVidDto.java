package metel.cih.api.dto;

import lombok.Data;

@Data
public class OriginVidDto {
    private String ovid;
    private String originName;
    private String originTitle;
    private String channelUrl;
    private String originComment;
    private String userId;
    private String updDt;
}
