package metel.cih.api.youtube.controller;

import lombok.RequiredArgsConstructor;
import metel.cih.api.base.ApiResponse;
import metel.cih.api.base.ResponseDto;
import metel.cih.api.dto.OriginVidDto;
import metel.cih.api.dto.YoutubePlayListDto;
import metel.cih.api.dto.YoutubeVideoDto;
import metel.cih.api.youtube.service.YoutubeService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("youtube-data")
@RequiredArgsConstructor
public class YoutubeDataAggController {
    private final YoutubeService service;

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
