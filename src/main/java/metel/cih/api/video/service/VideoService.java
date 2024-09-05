package metel.cih.api.video.service;


import lombok.RequiredArgsConstructor;
import metel.cih.api.dto.VideoDto;
import metel.cih.api.video.mapper.VideoMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VideoService {
    private final VideoMapper mapper;

    public List<VideoDto> selectVideoList(HashMap<String, Object> params){
        return mapper.selectVideoList(params);
    }

    public int getSeqVideo(){
        return mapper.getSeqVideo();
    }
    public int saveVideoClip(VideoDto videoDto){
        if(videoDto.getVid() == null || videoDto.getVid().isEmpty()){
            return mapper.insertVideoClip(videoDto);
        } else {
            return mapper.updateVideoClip(videoDto);
        }
    }
    public int deleteVideoClip(VideoDto videoDto){
        return mapper.deleteVideoClip(videoDto);
    }

}
