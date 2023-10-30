package metel.cih.api.youtube.mapper;


import metel.cih.api.dto.YoutubePastorDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface YoutubeMapper {
    List<YoutubePastorDto> selectYoutubePastor(HashMap<String, Object> map);

}
