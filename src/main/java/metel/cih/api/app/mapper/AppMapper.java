package metel.cih.api.app.mapper;


import metel.cih.api.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface AppMapper {

    List<CommentsDto> selectComments(CommentsDto commentsDto);
    int mergeComments(CommentsDto commentsDto);
    int mergeStatics(StaticsDto staticsDto);

    List<YoutubeVideoDto> selectYoutubePastor(HashMap<String, Object> map);
    List<OriginVidDto> selectOriginVid(HashMap<String, Object> map);

    int mergeYoutubePastor(YoutubeVideoDto youtubePastorDto);

    int updateYoutubePastor(YoutubeVideoDto youtubePastorDto);

    int deleteYoutubePastor(YoutubeVideoDto youtubePastorDto);
    int deleteRealDataYoutubePastor(YoutubeVideoDto youtubePastorDto);

    int mergeOriginVid(OriginVidDto originVidDto);

    int updateOriginVid(OriginVidDto originVidDto);

    int deleteOriginVid(OriginVidDto originVidDto);

    //    youtube celeb part start
    List<YoutubeVideoDto> selectYoutubeCeleb(HashMap<String, Object> map);
    int mergeYoutubeCeleb(YoutubeVideoDto youtubeCelebDto);
    int deleteYoutubeCeleb(YoutubeVideoDto youtubeCelebDto);
    int deleteRealDataYoutubeCeleb(YoutubeVideoDto youtubeCelebDto);

    // youtube sermon part start
    List<YoutubeVideoDto> selectYoutubeSermon(HashMap<String, Object> map);
    int mergeYoutubeSermon(YoutubeVideoDto youtubeSermonDto);
    int deleteYoutubeSermon(YoutubeVideoDto youtubeSermonDto);
    int deleteRealDataYoutubeSermon(YoutubeVideoDto youtubeSermonDto);

    // youtube mery part start
    List<YoutubeVideoDto> selectYoutubeMercy(HashMap<String, Object> map);
    int mergeYoutubeMercy(YoutubeVideoDto youtubeMercyDto);
    int deleteYoutubeMercy(YoutubeVideoDto youtubeMercyDto);
    int deleteRealDataYoutubeMercy(YoutubeVideoDto youtubeMercyDto);

    // youtube ccm part start
    List<YoutubeVideoDto> selectShortsCcm(HashMap<String, Object> map);
    int mergeShortsCcm(YoutubeVideoDto shortsCcmDto);
    int deleteShortsCcm(YoutubeVideoDto shortsCcmDto);
    int deleteRealDataShortsCcm(YoutubeVideoDto shortsCcmDto);

    //    youtube celeb part start
    List<YoutubeVideoDto> selectYoutubeFaith(HashMap<String, Object> map);
    int mergeYoutubeFaith(YoutubeVideoDto youtubeFaithDto);
    int deleteYoutubeFaith(YoutubeVideoDto youtubeFaithDto);
    int deleteRealDataYoutubeFaith(YoutubeVideoDto youtubeFaithDto);

    int countYoutubeDataExists(YoutubeRequestDto youtubeRequestDto);


}
