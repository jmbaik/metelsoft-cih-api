package metel.cih.api.dto;

import lombok.Data;

import java.util.List;

@Data
public class YoutubeRequestDto {
    private String category;
    private String channelId;
    private String pastorCode;
}
