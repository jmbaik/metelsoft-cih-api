package metel.cih.api.dto;

import lombok.Data;

import java.util.List;

@Data
public class YoutubeRequestDto {
    private String category;
    private String channelId = "";
    private String playlistId = "";
    private String pastorCode;
    private String q = "";
    private String order;
    private String duration;
    private String userId;
    private String prevPageToken;
    private String nextPageToken;
    private String shortsCheckYn;
    private int lastItemNo =0;
    private String strToday ="";

    private List<YoutubeVideoDto> videos;
}
