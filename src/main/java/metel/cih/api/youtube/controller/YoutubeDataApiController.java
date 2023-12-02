package metel.cih.api.youtube.controller;

import com.google.api.services.youtube.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import metel.cih.api.base.ApiResponse;
import metel.cih.api.base.ResponseDto;
import metel.cih.api.dto.YoutubePlayListDto;
import metel.cih.api.dto.YoutubeRequestDto;
import metel.cih.api.dto.YoutubeVideoDto;
import metel.cih.api.youtube.service.YoutubeDataApiService;
import metel.cih.api.youtube.service.YoutubeService;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("youtube-data")
@RequiredArgsConstructor
public class YoutubeDataApiController {
    private final YoutubeService service;
    private final YoutubeDataApiService youtubeDataApiService;

    @ResponseBody
    @PostMapping("/save-videos-by-search")
    public ResponseDto<List<YoutubeVideoDto>> saveVideosBySearchApi(@RequestBody YoutubeRequestDto dto) {
        List<YoutubeVideoDto> youtubeVideoDtoList = new ArrayList<>();
        String category = dto.getCategory();
        String channelId = dto.getChannelId();
        String pastorCode = dto.getPastorCode();
        String userId = dto.getUserId();
        String q = dto.getQ();
        String nextPageToken = dto.getNextPageToken();
        String prevPageToken = dto.getPrevPageToken();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar c1 = Calendar.getInstance();
        String strToday = sdf.format(c1.getTime());
        SearchListResponse response = youtubeDataApiService.getVideosBySearch(channelId, q, nextPageToken, prevPageToken);
        String _prevPageToken = response.getPrevPageToken();
        String _nextPageToken = response.getNextPageToken();
        int totalResults = response.getPageInfo().getTotalResults();
        List<SearchResult> items = response.getItems();
        int itemNo = dto.getLastItemNo();
        for(SearchResult item: items){
            YoutubeVideoDto youtubeVideoDto = new YoutubeVideoDto();
            youtubeVideoDto.setVid(item.getId().getVideoId());
            youtubeVideoDto.setPastorCode(pastorCode);
            youtubeVideoDto.setChannelId(channelId);
            youtubeVideoDto.setTitle(item.getSnippet().getTitle());
            youtubeVideoDto.setChannelTitle(item.getSnippet().getChannelTitle());
            youtubeVideoDto.setThumbnailDefault(item.getSnippet().getThumbnails().getDefault().getUrl());
            youtubeVideoDto.setThumbnailMedium(item.getSnippet().getThumbnails().getMedium().getUrl());
            youtubeVideoDto.setThumbnailHigh(item.getSnippet().getThumbnails().getHigh().getUrl());
            youtubeVideoDto.setDescription(item.getSnippet().getDescription());
            youtubeVideoDto.setCreateYmd(strToday);
            youtubeVideoDto.setPublishedAt(item.getSnippet().getPublishedAt().toString());
            youtubeVideoDto.setPrevPageToken(_prevPageToken);
            youtubeVideoDto.setNextPageToken(_nextPageToken);
            youtubeVideoDto.setTotalResults(totalResults);
            youtubeVideoDto.setItemNo(itemNo + 1);
            youtubeVideoDto.setUserId(userId);
            youtubeVideoDtoList.add(youtubeVideoDto);
        }
        if(category.equals("pastor")){
            for(YoutubeVideoDto youtubeVideoDto: youtubeVideoDtoList){
                service.mergeYoutubePastor(youtubeVideoDto);
            }
        }
        if(category.equals("celeb")){
            for(YoutubeVideoDto youtubeVideoDto: youtubeVideoDtoList){
                service.mergeYoutubeCeleb(youtubeVideoDto);
            }
        }
        if(category.equals("mercy")){
            for(YoutubeVideoDto youtubeVideoDto: youtubeVideoDtoList){
                service.mergeYoutubeMercy(youtubeVideoDto);
            }
        }
        if(category.equals("sermon")){
            for(YoutubeVideoDto youtubeVideoDto: youtubeVideoDtoList){
                service.mergeYoutubeSermon(youtubeVideoDto);
            }
        }
        if(category.equals("ccm")){
            for(YoutubeVideoDto youtubeVideoDto: youtubeVideoDtoList){
                service.mergeShortsCcm(youtubeVideoDto);
            }
        }
        return ApiResponse.Success(youtubeVideoDtoList);
    }

    @ResponseBody
    @PostMapping("/save-videos-by-channel")
    public ResponseDto<List<YoutubeVideoDto>> saveVideosByChannel(@RequestBody YoutubeRequestDto dto){
        List<YoutubeVideoDto> youtubeVideoDtoList = new ArrayList<>();
        String category = dto.getCategory();
        String channelId = dto.getChannelId();
        String pastorCode = dto.getPastorCode();
        String userId = dto.getUserId();
        String nextPageToken = dto.getNextPageToken();
        String prevPageToken = dto.getPrevPageToken();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar c1 = Calendar.getInstance();
        String strToday = sdf.format(c1.getTime());
        ChannelListResponse channelListResponse = youtubeDataApiService.getPlayListByChannelId(channelId);
        List<Channel> channels = channelListResponse.getItems();
        for(Channel channel : channels){
            log.debug(channel.getContentDetails().getRelatedPlaylists().getUploads());
            String playListId = channel.getContentDetails().getRelatedPlaylists().getUploads();
            PlaylistItemListResponse itemsResponse = youtubeDataApiService.getPlayListItems(playListId, nextPageToken, prevPageToken);
            String _prevPageToken = itemsResponse.getPrevPageToken();
            String _nextPageToken = itemsResponse.getNextPageToken();
            int totalResults = itemsResponse.getPageInfo().getTotalResults();
            List<PlaylistItem> items = itemsResponse.getItems();
            int itemNo = dto.getLastItemNo();
            for(PlaylistItem item : items){
                YoutubeVideoDto youtubeVideoDto = new YoutubeVideoDto();
                youtubeVideoDto.setVid(item.getSnippet().getResourceId().getVideoId());
                youtubeVideoDto.setPastorCode(pastorCode);
                youtubeVideoDto.setChannelId(channelId);
                youtubeVideoDto.setTitle(item.getSnippet().getTitle());
                youtubeVideoDto.setChannelTitle(channel.getSnippet().getTitle());
                youtubeVideoDto.setThumbnailDefault(item.getSnippet().getThumbnails().getDefault().getUrl());
                youtubeVideoDto.setThumbnailMedium(item.getSnippet().getThumbnails().getMedium().getUrl());
                youtubeVideoDto.setThumbnailHigh(item.getSnippet().getThumbnails().getHigh().getUrl());
                youtubeVideoDto.setDescription(item.getSnippet().getDescription());
                youtubeVideoDto.setCreateYmd(strToday);
                youtubeVideoDto.setPublishedAt(item.getSnippet().getPublishedAt().toString());
                youtubeVideoDto.setPrevPageToken(_prevPageToken);
                youtubeVideoDto.setNextPageToken(_nextPageToken);
                youtubeVideoDto.setTotalResults(totalResults);
                youtubeVideoDto.setItemNo(itemNo + 1);
                youtubeVideoDto.setUserId(userId);
                youtubeVideoDtoList.add(youtubeVideoDto);
            }
            if(category.equals("pastor")){
                for(YoutubeVideoDto youtubeVideoDto: youtubeVideoDtoList){
                    service.mergeYoutubePastor(youtubeVideoDto);
                }
            }
            if(category.equals("celeb")){
                for(YoutubeVideoDto youtubeVideoDto: youtubeVideoDtoList){
                    service.mergeYoutubeCeleb(youtubeVideoDto);
                }
            }
            if(category.equals("mercy")){
                for(YoutubeVideoDto youtubeVideoDto: youtubeVideoDtoList){
                    service.mergeYoutubeMercy(youtubeVideoDto);
                }
            }
            if(category.equals("sermon")){
                for(YoutubeVideoDto youtubeVideoDto: youtubeVideoDtoList){
                    service.mergeYoutubeSermon(youtubeVideoDto);
                }
            }
            if(category.equals("ccm")){
                for(YoutubeVideoDto youtubeVideoDto: youtubeVideoDtoList){
                    service.mergeShortsCcm(youtubeVideoDto);
                }
            }
        }
        return ApiResponse.Success(youtubeVideoDtoList);
    }

    @ResponseBody
    @PostMapping("/save-playlist")
    public ResponseDto<List<YoutubeVideoDto>> savePlayList(@RequestBody YoutubePlayListDto dto){
        List<YoutubeVideoDto> result = new ArrayList<>();
        String category = dto.getCategory();
        String channelId = dto.getChannelId();
        String pastorCode = dto.getPastorCode();
        HashMap<String, Object> param = new HashMap<>();
        param.put("channelId", channelId);
        List<YoutubeVideoDto> videos = dto.getVideos();
        if (category.equals("pastor")) {
            for (YoutubeVideoDto item: videos){
                item.setPastorCode(pastorCode);
                service.mergeYoutubePastor(item);
            }
            result = service.selectYoutubePastor(param);
        }
        if (category.equals("sermon")) {
            for (YoutubeVideoDto item: videos){
                service.mergeYoutubeSermon(item);
            }
            result = service.selectYoutubeSermon(param);
        }
        if (category.equals("mercy")) {
            for (YoutubeVideoDto item: videos){
                service.mergeYoutubeMercy(item);
            }
            result = service.selectYoutubeMercy(param);
        }
        if (category.equals("celeb")) {
            for (YoutubeVideoDto item: videos){
                service.mergeYoutubeCeleb(item);
            }
            result = service.selectYoutubeCeleb(param);
        }
        if (category.equals("ccm")) {
            for (YoutubeVideoDto item: videos){
                service.mergeShortsCcm(item);
            }
            result = service.selectShortsCcm(param);
        }
        return ApiResponse.Success(result);
    }
}
