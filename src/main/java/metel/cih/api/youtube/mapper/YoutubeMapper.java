package metel.cih.api.youtube.mapper;


import metel.cih.api.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface YoutubeMapper {
    List<YoutubeVideoDto> selectYoutubePastor(HashMap<String, Object> map);
    List<OriginVidDto> selectOriginVid(HashMap<String, Object> map);

    int mergeYoutubePastor(YoutubeVideoDto youtubePastorDto);

    int updateYoutubePastor(YoutubeVideoDto youtubePastorDto);

    int deleteYoutubePastor(YoutubeVideoDto youtubePastorDto);

    int mergeOriginVid(OriginVidDto originVidDto);

    int updateOriginVid(OriginVidDto originVidDto);

    int deleteOriginVid(OriginVidDto originVidDto);

    //    youtube celeb part start
    List<YoutubeVideoDto> selectYoutubeCeleb(HashMap<String, Object> map);
    int mergeYoutubeCeleb(YoutubeVideoDto youtubeCelebDto);
    int deleteYoutubeCeleb(YoutubeVideoDto youtubeCelebDto);

    // youtube sermon part start
    List<YoutubeVideoDto> selectYoutubeSermon(HashMap<String, Object> map);
    int mergeYoutubeSermon(YoutubeVideoDto youtubeSermonDto);
    int deleteYoutubeSermon(YoutubeVideoDto youtubeSermonDto);

    // youtube mery part start
    List<YoutubeVideoDto> selectYoutubeMercy(HashMap<String, Object> map);
    int mergeYoutubeMercy(YoutubeVideoDto youtubeMercyDto);
    int deleteYoutubeMercy(YoutubeVideoDto youtubeMercyDto);

    // youtube ccm part start
    List<YoutubeVideoDto> selectShortsCcm(HashMap<String, Object> map);
    int mergeShortsCcm(YoutubeVideoDto shortsCcmDto);
    int deleteShortsCcm(YoutubeVideoDto shortsCcmDto);

}
