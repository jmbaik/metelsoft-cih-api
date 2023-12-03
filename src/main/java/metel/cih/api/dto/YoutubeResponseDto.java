package metel.cih.api.dto;

import lombok.Data;

import java.util.List;

@Data
public class YoutubeResponseDto {
    private String channelId;
    private String category;
    private String prevPageToken;
    private String nextPageToken;
    private String q;
    List<YoutubeVideoDto> Videos;
}
