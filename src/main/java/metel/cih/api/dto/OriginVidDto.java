package metel.cih.api.dto;

import lombok.Data;

@Data
public class OriginVidDto {
    private String channelId;
    private String channelTitle;
    private String channelDescription;
    private String shortDescription;
    private String userId;
    private String updId;
    private String updDt;
    private String itemsCount;
}
