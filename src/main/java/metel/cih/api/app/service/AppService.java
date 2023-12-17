package metel.cih.api.app.service;


import lombok.RequiredArgsConstructor;
import metel.cih.api.app.mapper.AppMapper;
import metel.cih.api.dto.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppService {
    private final AppMapper mapper;

    public List<CommentsDto> selectComments(CommentsDto commentsDto){
        return mapper.selectComments(commentsDto);
    }
    public int mergeComments(CommentsDto commentsDto){
        return mapper.mergeComments(commentsDto);
    }
    public int mergeStatics(StaticsDto staticsDto) {
        return mapper.mergeStatics(staticsDto);
    }
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
    public int deleteRealDataYoutubePastor(YoutubeVideoDto youtubePastorDto){
        return mapper.deleteRealDataYoutubePastor(youtubePastorDto);
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
    public int deleteRealDataYoutubeCeleb(YoutubeVideoDto youtubeCelebDto){
        return mapper.deleteRealDataYoutubeCeleb(youtubeCelebDto);
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
    public int deleteRealDataYoutubeSermon(YoutubeVideoDto youtubeSermonDto){
        return mapper.deleteRealDataYoutubeSermon(youtubeSermonDto);
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
    public int deleteRealDataYoutubeMercy(YoutubeVideoDto youtubeMercyDto){
        return mapper.deleteRealDataYoutubeMercy(youtubeMercyDto);
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

    public int deleteRealDataShortsCcm(YoutubeVideoDto shortsCcmDto){
        return mapper.deleteRealDataShortsCcm(shortsCcmDto);
    }

    public int countYoutubeDataExists(YoutubeRequestDto youtubeRequestDto){
        return mapper.countYoutubeDataExists(youtubeRequestDto);
    }

    // youtube fiath part
    public List<YoutubeVideoDto> selectYoutubeFaith(HashMap<String, Object> map){
        return mapper.selectYoutubeFaith(map);
    }
    public int mergeYoutubeFaith(YoutubeVideoDto youtubeFaithDto){
        return mapper.mergeYoutubeFaith(youtubeFaithDto);
    }
    public int deleteYoutubeFaith(YoutubeVideoDto youtubeFaithDto){
        return mapper.deleteYoutubeFaith(youtubeFaithDto);
    }
    public int deleteRealDataYoutubeFaith(YoutubeVideoDto youtubeFaithDto){
        return mapper.deleteRealDataYoutubeFaith(youtubeFaithDto);
    }


}
