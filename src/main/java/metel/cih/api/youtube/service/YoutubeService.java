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

    public List<YoutubeVideoDto> selectYoutubePastor(HashMap<String, Object> map){
        return mapper.selectYoutubePastor(map);
    }
    public List<OriginVidDto> selectOriginVid(HashMap<String, Object> map){
        return mapper.selectOriginVid(map);
    }

    public int mergeYoutubePastor(YoutubeVideoDto youtubePastorDto){
        return mapper.mergeYoutubePastor(youtubePastorDto);
    }
    public int updateYoutubePastor(YoutubeVideoDto youtubePastorDto){
        return mapper.updateYoutubePastor(youtubePastorDto);
    }
    public int deleteYoutubePastor(YoutubeVideoDto youtubePastorDto){
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
    public List<YoutubeVideoDto> selectYoutubeCeleb(HashMap<String, Object> map){
        return mapper.selectYoutubeCeleb(map);
    }
    public int mergeYoutubeCeleb(YoutubeVideoDto youtubeCelebDto){
        return mapper.mergeYoutubeCeleb(youtubeCelebDto);
    }
    public int deleteYoutubeCeleb(YoutubeVideoDto youtubeCelebDto){
        return mapper.deleteYoutubeCeleb(youtubeCelebDto);
    }

    // youtube sermon part
    public List<YoutubeVideoDto> selectYoutubeSermon(HashMap<String, Object> map){
        return mapper.selectYoutubeSermon(map);
    }
    public int mergeYoutubeSermon(YoutubeVideoDto youtubeSermonDto){
        return mapper.mergeYoutubeSermon(youtubeSermonDto);
    }
    public int deleteYoutubeSermon(YoutubeVideoDto youtubeSermonDto){
        return mapper.deleteYoutubeSermon(youtubeSermonDto);
    }

    // youtube mercy part
    public List<YoutubeVideoDto> selectYoutubeMercy(HashMap<String, Object> map){
        return mapper.selectYoutubeMercy(map);
    }
    public int mergeYoutubeMercy(YoutubeVideoDto youtubeMercyDto){
        return mapper.mergeYoutubeMercy(youtubeMercyDto);
    }
    public int deleteYoutubeMercy(YoutubeVideoDto youtubeMercyDto){
        return mapper.deleteYoutubeMercy(youtubeMercyDto);
    }

    // youtube ccm part
    public List<YoutubeVideoDto> selectShortsCcm(HashMap<String, Object> map){
        return mapper.selectShortsCcm(map);
    }
    public int mergeShortsCcm(YoutubeVideoDto shortsCcmDto){
        return mapper.mergeShortsCcm(shortsCcmDto);
    }
    public int deleteShortsCcm(YoutubeVideoDto shortsCcmDto){
        return mapper.deleteShortsCcm(shortsCcmDto);
    }

}
