package metel.cih.api.dto;

import lombok.Data;

import java.util.List;

@Data
public class YoutubeRequestDto {
    private String category;
    private String channelId;
    private String pastorCode;
    private String q;
    private String userId;
    private String prevPageToken;
    private String nextPageToken;
    private int lastItemNo =0;

    private List<YoutubeVideoDto> videos;
}
