package metel.cih.api.video.mapper;

import metel.cih.api.dto.VideoDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface VideoMapper {
    List<VideoDto> selectVideoList(HashMap<String, Object> params);

    int insertVideoClip(VideoDto videoDto);

    int updateVideoClip(VideoDto videoDto);

    int getSeqVideo();

    int deleteVideoClip(VideoDto videoDto);
}
