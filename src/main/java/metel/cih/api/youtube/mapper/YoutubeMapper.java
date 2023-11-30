package metel.cih.api.youtube.mapper;


import metel.cih.api.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface YoutubeMapper {
    List<YoutubePastorDto> selectYoutubePastor(HashMap<String, Object> map);
    List<OriginVidDto> selectOriginVid(HashMap<String, Object> map);

    int mergeYoutubePastor(YoutubePastorDto youtubePastorDto);

    int updateYoutubePastor(YoutubePastorDto youtubePastorDto);

    int deleteYoutubePastor(YoutubePastorDto youtubePastorDto);

    int mergeOriginVid(OriginVidDto originVidDto);

    int updateOriginVid(OriginVidDto originVidDto);

    int deleteOriginVid(OriginVidDto originVidDto);

    //    youtube celeb part start
    List<YoutubeCelebDto> selectYoutubeCeleb(HashMap<String, Object> map);
    int mergeYoutubeCeleb(YoutubeCelebDto youtubeCelebDto);
    int deleteYoutubeCeleb(YoutubeCelebDto youtubeCelebDto);

    // youtube sermon part start
    List<YoutubeSermonDto> selectYoutubeSermon(HashMap<String, Object> map);
    int mergeYoutubeSermon(YoutubeSermonDto youtubeSermonDto);
    int deleteYoutubeSermon(YoutubeSermonDto youtubeSermonDto);

    // youtube mery part start
    List<YoutubeMercyDto> selectYoutubeMercy(HashMap<String, Object> map);
    int mergeYoutubeMercy(YoutubeMercyDto youtubeMercyDto);
    int deleteYoutubeMercy(YoutubeMercyDto youtubeMercyDto);

    // youtube ccm part start
    List<ShortsCcmDto> selectShortsCcm(HashMap<String, Object> map);
    int mergeShortsCcm(ShortsCcmDto shortsCcmDto);
    int deleteShortsCcm(ShortsCcmDto shortsCcmDto);

}
