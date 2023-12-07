package metel.cih.api.youtube.controller;

import com.google.api.services.youtube.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import metel.cih.api.base.ApiResponse;
import metel.cih.api.base.CommonUtils;
import metel.cih.api.base.ResponseDto;
import metel.cih.api.dto.YoutubePlayListDto;
import metel.cih.api.dto.YoutubeRequestDto;
import metel.cih.api.dto.YoutubeResponseDto;
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
    @PostMapping("/save-all-videos-by-playlist")
    public ResponseDto<YoutubeResponseDto> saveAllVideosByPlaylistId(@RequestBody YoutubeRequestDto request){
        YoutubeResponseDto youtubeResponseDto = new YoutubeResponseDto();
        List<YoutubeVideoDto> youtubeVideoDtoList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar c1 = Calendar.getInstance();
        String strToday = sdf.format(c1.getTime());
        request.setStrToday(strToday);
        boolean isShortsCheck = request.getShortsCheckYn().equals("Y");
        List<PlaylistItemListResponse> responses = youtubeDataApiService.getAllPlayListItems(request.getPlaylistId());
        for(PlaylistItemListResponse response: responses){
            setVideoListFromPlaylistItemList(request, response, youtubeVideoDtoList, isShortsCheck);
        }
        mergeYoutubeVideoToTables(request.getCategory(), youtubeVideoDtoList);
        youtubeResponseDto.setResult("success");
        youtubeResponseDto.setVideos(youtubeVideoDtoList);
        youtubeResponseDto.setCategory(request.getCategory());
        return ApiResponse.Success(youtubeResponseDto);
    }
    @ResponseBody
    @PostMapping("/update-shorts-by-playlist")
    public ResponseDto<YoutubeResponseDto> updateShortsByPlaylist(@RequestBody YoutubeRequestDto request){
        YoutubeResponseDto youtubeResponseDto = new YoutubeResponseDto();
        String category = request.getCategory();
        String qSignal = CommonUtils.getQSignal(request);
        HashMap<String, Object> map = new HashMap<>();
        List<YoutubeVideoDto> list = new ArrayList<>();
        map.put("qSignal", qSignal);
        if (category.equals("pastor")) {
            list = service.selectYoutubePastor(map);
        }
        if (category.equals("celeb")) {
            list = service.selectYoutubeCeleb(map);
        }
        if (category.equals("mercy")) {
            list = service.selectYoutubeMercy(map);
        }
        if (category.equals("sermon")) {
            list = service.selectYoutubeSermon(map);
        }
        if (category.equals("ccm")) {
            list = service.selectShortsCcm(map);
        }
        if (category.equals("faith")) {
            list = service.selectYoutubeFaith(map);
        }
        for(YoutubeVideoDto dto: list){
            String shorts = dto.getShorts();
            if(shorts == null || shorts.equals("N")) {
                shorts = CommonUtils.IsShorts(dto.getVid());
                dto.setShorts(shorts);
                if (category.equals("pastor")) {
                    service.mergeYoutubePastor(dto);
                }
                if (category.equals("celeb")) {
                    service.mergeYoutubeCeleb(dto);
                }
                if (category.equals("sermon")) {
                    service.mergeYoutubeSermon(dto);
                }
                if (category.equals("ccm")) {
                    service.mergeShortsCcm(dto);
                }
                if (category.equals("faith")) {
                    service.mergeYoutubeFaith(dto);
                }
                if (category.equals("mercy")) {
                    service.mergeYoutubeMercy(dto);
                }
            }
        }
        youtubeResponseDto.setResult("success");
        youtubeResponseDto.setVideos(list);
        youtubeResponseDto.setCategory(request.getCategory());
        return ApiResponse.Success(youtubeResponseDto);
    }

    private void setVideoListFromPlaylistItemList(YoutubeRequestDto request, PlaylistItemListResponse response,  List<YoutubeVideoDto> youtubeVideoDtoList){
        setVideoListFromPlaylistItemList(request, response, youtubeVideoDtoList, false);
    }
    private void setVideoListFromPlaylistItemList(YoutubeRequestDto request, PlaylistItemListResponse response,  List<YoutubeVideoDto> youtubeVideoDtoList, boolean isShorts){
        String _prevPageToken = response.getPrevPageToken();
        String _nextPageToken = response.getNextPageToken();
        int totalResults = response.getPageInfo().getTotalResults();
        List<PlaylistItem> items = response.getItems();
        for (PlaylistItem item : items) {
            if(item.getSnippet().getThumbnails().getDefault() == null){
                continue;
            }
            YoutubeVideoDto youtubeVideoDto = new YoutubeVideoDto();
            String videoId = item.getSnippet().getResourceId().getVideoId();
            youtubeVideoDto.setVid(videoId);
            if(isShorts){
                String shorts = CommonUtils.IsShorts(videoId);
                youtubeVideoDto.setShorts(shorts);
            }
            youtubeVideoDto.setPastorCode(request.getPastorCode());
            youtubeVideoDto.setChannelId(item.getSnippet().getChannelId());
            youtubeVideoDto.setTitle(item.getSnippet().getTitle());
            youtubeVideoDto.setChannelTitle(item.getSnippet().getChannelTitle());
            youtubeVideoDto.setThumbnailDefault(item.getSnippet().getThumbnails().getDefault().getUrl());
            youtubeVideoDto.setThumbnailMedium(item.getSnippet().getThumbnails().getMedium().getUrl());
            youtubeVideoDto.setThumbnailHigh(item.getSnippet().getThumbnails().getHigh().getUrl());
            youtubeVideoDto.setDescription(item.getSnippet().getDescription());
            youtubeVideoDto.setCreateYmd(request.getStrToday());
            youtubeVideoDto.setPublishedAt(item.getSnippet().getPublishedAt().toString());
            youtubeVideoDto.setPrevPageToken(_prevPageToken);
            youtubeVideoDto.setNextPageToken(_nextPageToken);
            youtubeVideoDto.setTotalResults(totalResults);
            youtubeVideoDto.setItemNo(request.getLastItemNo() + 1);
            youtubeVideoDto.setQSignal(CommonUtils.getQSignal(request));
            youtubeVideoDto.setUserId(request.getUserId());
            youtubeVideoDtoList.add(youtubeVideoDto);
        }
    }
    @ResponseBody
    @PostMapping("/save-videos-by-playlist")
    public ResponseDto<YoutubeResponseDto> saveVideosByPlaylistId(@RequestBody YoutubeRequestDto dto){
        YoutubeResponseDto youtubeResponseDto = new YoutubeResponseDto();
        List<YoutubeVideoDto> youtubeVideoDtoList = new ArrayList<>();
        String category = dto.getCategory();
        String channelId = dto.getChannelId();
        String playlistId = dto.getPlaylistId();
        String pastorCode = dto.getPastorCode();
        String userId = dto.getUserId();
        String nextPageToken = dto.getNextPageToken();
        String prevPageToken = dto.getPrevPageToken();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar c1 = Calendar.getInstance();
        String strToday = sdf.format(c1.getTime());
        PlaylistItemListResponse response = youtubeDataApiService.getPlayListItems(playlistId, nextPageToken, prevPageToken);
        String _prevPageToken = response.getPrevPageToken();
        String _nextPageToken = response.getNextPageToken();
        int totalResults = response.getPageInfo().getTotalResults();
        List<PlaylistItem> items = response.getItems();
        int itemNo = dto.getLastItemNo();
        for (PlaylistItem item : items) {
            if(item.getSnippet().getThumbnails().getDefault() == null){
                continue;
            }
            YoutubeVideoDto youtubeVideoDto = new YoutubeVideoDto();
            String videoId = item.getSnippet().getResourceId().getVideoId();
            youtubeVideoDto.setVid(videoId);
            String shorts = CommonUtils.IsShorts(videoId);
            youtubeVideoDto.setShorts(shorts);
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
            youtubeVideoDto.setQSignal(channelId + "-" + category + "-" + playlistId);
            youtubeVideoDto.setUserId(userId);
            youtubeVideoDtoList.add(youtubeVideoDto);
        }
        mergeYoutubeVideoToTables(category, youtubeVideoDtoList);
        youtubeResponseDto.setResult("success");
        youtubeResponseDto.setVideos(youtubeVideoDtoList);
        youtubeResponseDto.setCategory(category);
        youtubeResponseDto.setPrevPageToken(_prevPageToken);
        youtubeResponseDto.setNextPageToken(_nextPageToken);
        return ApiResponse.Success(youtubeResponseDto);
    }

    private void mergeYoutubeVideoToTables(String category, List<YoutubeVideoDto> youtubeVideoDtoList) {
        if (category.equals("pastor")) {
            for (YoutubeVideoDto youtubeVideoDto : youtubeVideoDtoList) {
                service.mergeYoutubePastor(youtubeVideoDto);
            }
        }
        if (category.equals("celeb")) {
            for (YoutubeVideoDto youtubeVideoDto : youtubeVideoDtoList) {
                service.mergeYoutubeCeleb(youtubeVideoDto);
            }
        }
        if (category.equals("mercy")) {
            for (YoutubeVideoDto youtubeVideoDto : youtubeVideoDtoList) {
                service.mergeYoutubeMercy(youtubeVideoDto);
            }
        }
        if (category.equals("sermon")) {
            for (YoutubeVideoDto youtubeVideoDto : youtubeVideoDtoList) {
                service.mergeYoutubeSermon(youtubeVideoDto);
            }
        }
        if (category.equals("ccm")) {
            for (YoutubeVideoDto youtubeVideoDto : youtubeVideoDtoList) {
                service.mergeShortsCcm(youtubeVideoDto);
            }
        }
        if (category.equals("faith")) {
            for (YoutubeVideoDto youtubeVideoDto : youtubeVideoDtoList) {
                service.mergeYoutubeFaith(youtubeVideoDto);
            }
        }
    }

    @ResponseBody
    @PostMapping("/save-videos-by-search")
    public ResponseDto<YoutubeResponseDto> saveVideosBySearchApi(@RequestBody YoutubeRequestDto dto) {
        YoutubeResponseDto youtubeResponseDto = new YoutubeResponseDto();
        int existsCount = service.countYoutubeDataExists(dto);
        if(existsCount>0){
            youtubeResponseDto.setResult("error");
            youtubeResponseDto.setMessage("이미 조회한 데이터입니다.");
            return ApiResponse.Success(youtubeResponseDto);
        }
        List<YoutubeVideoDto> youtubeVideoDtoList = new ArrayList<>();
        String category = dto.getCategory();
        String channelId = dto.getChannelId();
        String pastorCode = dto.getPastorCode();
        String order = dto.getOrder();
        String duration = dto.getDuration();
        String userId = dto.getUserId();
        String q = dto.getQ();
        String nextPageToken = dto.getNextPageToken();
        String prevPageToken = dto.getPrevPageToken();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar c1 = Calendar.getInstance();
        String strToday = sdf.format(c1.getTime());
        SearchListResponse response = youtubeDataApiService.getVideosBySearch(channelId, q, order, duration, nextPageToken, prevPageToken);
        String _prevPageToken = response.getPrevPageToken();
        String _nextPageToken = response.getNextPageToken();
        int totalResults = response.getPageInfo().getTotalResults();
        List<SearchResult> items = response.getItems();
        int itemNo = dto.getLastItemNo();
        for (SearchResult item : items) {
            if(item.getSnippet().getThumbnails().getDefault() == null){
                continue;
            }
            String videoId = item.getId().getVideoId();
            YoutubeVideoDto youtubeVideoDto = new YoutubeVideoDto();
            youtubeVideoDto.setVid(videoId);
            String shorts = CommonUtils.IsShorts(videoId);
            youtubeVideoDto.setShorts(shorts);
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
            youtubeVideoDto.setQSignal(channelId + "-" + category + "-" + q);
            youtubeVideoDto.setUserId(userId);
            youtubeVideoDtoList.add(youtubeVideoDto);
        }
        mergeYoutubeVideoToTables(category, youtubeVideoDtoList);
        youtubeResponseDto.setResult("success");
        youtubeResponseDto.setVideos(youtubeVideoDtoList);
        youtubeResponseDto.setCategory(category);
        youtubeResponseDto.setQ(q);
        youtubeResponseDto.setPrevPageToken(_prevPageToken);
        youtubeResponseDto.setNextPageToken(_nextPageToken);
        return ApiResponse.Success(youtubeResponseDto);
    }

    @ResponseBody
    @PostMapping("/delete-videos")
    public ResponseDto<YoutubeResponseDto> deleteRealDataAllBySearch(@RequestBody YoutubeRequestDto youtubeRequestDto) {
        YoutubeResponseDto youtubeResponseDto = new YoutubeResponseDto();
        int result = 0;
        String category = youtubeRequestDto.getCategory();
        List<YoutubeVideoDto> youtubeVideoDtoList = youtubeRequestDto.getVideos();
        if (category.equals("pastor")) {
            for (YoutubeVideoDto youtubeVideoDto : youtubeVideoDtoList) {
                result += service.deleteRealDataYoutubePastor(youtubeVideoDto);
            }
        }
        if (category.equals("celeb")) {
            for (YoutubeVideoDto youtubeVideoDto : youtubeVideoDtoList) {
                result += service.deleteRealDataYoutubeCeleb(youtubeVideoDto);
            }
        }
        if (category.equals("mercy")) {
            for (YoutubeVideoDto youtubeVideoDto : youtubeVideoDtoList) {
                result += service.deleteRealDataYoutubeMercy(youtubeVideoDto);
            }
        }
        if (category.equals("sermon")) {
            for (YoutubeVideoDto youtubeVideoDto : youtubeVideoDtoList) {
                result += service.deleteRealDataYoutubeSermon(youtubeVideoDto);
            }
        }
        if (category.equals("ccm")) {
            for (YoutubeVideoDto youtubeVideoDto : youtubeVideoDtoList) {
                result += service.deleteRealDataShortsCcm(youtubeVideoDto);
            }
        }
        if (category.equals("faith")) {
            for (YoutubeVideoDto youtubeVideoDto : youtubeVideoDtoList) {
                result += service.deleteRealDataYoutubeFaith(youtubeVideoDto);
            }
        }
        youtubeResponseDto.setChannelId(youtubeResponseDto.getChannelId());
        youtubeResponseDto.setResultCount(result);
        youtubeResponseDto.setCategory(youtubeResponseDto.getCategory());
        youtubeResponseDto.setQ(youtubeResponseDto.getQ());
        return ApiResponse.Success(youtubeResponseDto);
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
                if(item.getSnippet().getThumbnails().getDefault() == null){
                    continue;
                }
                String videoId = item.getSnippet().getResourceId().getVideoId();
                YoutubeVideoDto youtubeVideoDto = new YoutubeVideoDto();
                youtubeVideoDto.setVid(videoId);
                String shorts = CommonUtils.IsShorts(videoId);
                youtubeVideoDto.setShorts(shorts);
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
            mergeYoutubeVideoToTables(category, youtubeVideoDtoList);
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
        if (category.equals("faith")) {
            for (YoutubeVideoDto item: videos){
                service.mergeYoutubeFaith(item);
            }
            result = service.selectYoutubeFaith(param);
        }
        return ApiResponse.Success(result);
    }
}
