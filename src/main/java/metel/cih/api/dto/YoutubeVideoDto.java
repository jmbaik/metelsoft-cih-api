package metel.cih.api.dto;

import lombok.Data;

@Data
public class YoutubeVideoDto {

    private String vid;
    private String pastorCode;
    private String pastorName;
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
    private String prevPageToken;
    private String nextPageToken;
    private int totalResults;
    private int itemNo;
    private String userId;
    private String updDt;
}
