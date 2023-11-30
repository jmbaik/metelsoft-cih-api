package metel.cih.api.dto;

import lombok.Data;

@Data
public class YoutubeSermonDto {

    private String vid;
    private String channelId;
    private String title;
    private String channelTitle;
    private String thumbnailDefault;
    private String thumbnailMedium;
    private String thumbnailHigh;
    private String grade;
    private String sort;
    private String description;
    private String createYmd;
    private String publishedAt;
    private String userId;
    private String updDt;

}
