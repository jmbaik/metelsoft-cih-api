package metel.cih.api.youtube.mapper;


import metel.cih.api.dto.OriginVidDto;
import metel.cih.api.dto.YoutubePastorDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface YoutubeMapper {
    List<YoutubePastorDto> selectYoutubePastor(HashMap<String, Object> map);
    List<OriginVidDto> selectOriginVid(HashMap<String, Object> map);

    int insertYoutubePastor(YoutubePastorDto youtubePastorDto);

    int updateYoutubePastor(YoutubePastorDto youtubePastorDto);

    int deleteYoutubePastor(YoutubePastorDto youtubePastorDto);

    int insertOriginVid(OriginVidDto originVidDto);

    int updateOriginVid(OriginVidDto originVidDto);

    int deleteOriginVid(OriginVidDto originVidDto);


}
