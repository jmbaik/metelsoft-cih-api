package metel.cih.api.youtube.service;


import lombok.RequiredArgsConstructor;
import metel.cih.api.dto.*;
import metel.cih.api.youtube.mapper.YoutubeMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class YoutubeService {
    private final YoutubeMapper mapper;

    public List<YoutubePastorDto> selectYoutubePastor(HashMap<String, Object> map){
        return mapper.selectYoutubePastor(map);
    }
    public List<OriginVidDto> selectOriginVid(HashMap<String, Object> map){
        return mapper.selectOriginVid(map);
    }

    public int mergeYoutubePastor(YoutubePastorDto youtubePastorDto){
        return mapper.mergeYoutubePastor(youtubePastorDto);
    }
    public int updateYoutubePastor(YoutubePastorDto youtubePastorDto){
        return mapper.updateYoutubePastor(youtubePastorDto);
    }
    public int deleteYoutubePastor(YoutubePastorDto youtubePastorDto){
        return mapper.deleteYoutubePastor(youtubePastorDto);
    }
    public int mergeOriginVid(OriginVidDto originVidDto){
        return mapper.mergeOriginVid(originVidDto);
    }
    public int updateOriginVid(OriginVidDto originVidDto){
        return mapper.updateOriginVid(originVidDto);
    }
    public int deleteOriginVid(OriginVidDto originVidDto){
        return mapper.deleteOriginVid(originVidDto);
    }

    // youtube celeb part
    public List<YoutubeCelebDto> selectYoutubeCeleb(HashMap<String, Object> map){
        return mapper.selectYoutubeCeleb(map);
    }
    public int mergeYoutubeCeleb(YoutubeCelebDto youtubeCelebDto){
        return mapper.mergeYoutubeCeleb(youtubeCelebDto);
    }
    public int deleteYoutubeCeleb(YoutubeCelebDto youtubeCelebDto){
        return mapper.deleteYoutubeCeleb(youtubeCelebDto);
    }

    // youtube sermon part
    public List<YoutubeSermonDto> selectYoutubeSermon(HashMap<String, Object> map){
        return mapper.selectYoutubeSermon(map);
    }
    public int mergeYoutubeSermon(YoutubeSermonDto youtubeSermonDto){
        return mapper.mergeYoutubeSermon(youtubeSermonDto);
    }
    public int deleteYoutubeSermon(YoutubeSermonDto youtubeSermonDto){
        return mapper.deleteYoutubeSermon(youtubeSermonDto);
    }

    // youtube mercy part
    public List<YoutubeMercyDto> selectYoutubeMercy(HashMap<String, Object> map){
        return mapper.selectYoutubeMercy(map);
    }
    public int mergeYoutubeMercy(YoutubeMercyDto youtubeMercyDto){
        return mapper.mergeYoutubeMercy(youtubeMercyDto);
    }
    public int deleteYoutubeMercy(YoutubeMercyDto youtubeMercyDto){
        return mapper.deleteYoutubeMercy(youtubeMercyDto);
    }

    // youtube ccm part
    public List<ShortsCcmDto> selectShortsCcm(HashMap<String, Object> map){
        return mapper.selectShortsCcm(map);
    }
    public int mergeShortsCcm(ShortsCcmDto shortsCcmDto){
        return mapper.mergeShortsCcm(shortsCcmDto);
    }
    public int deleteShortsCcm(ShortsCcmDto shortsCcmDto){
        return mapper.deleteShortsCcm(shortsCcmDto);
    }

}
