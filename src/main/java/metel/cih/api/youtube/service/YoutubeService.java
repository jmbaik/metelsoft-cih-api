package metel.cih.api.youtube.service;


import lombok.RequiredArgsConstructor;
import metel.cih.api.dto.OriginVidDto;
import metel.cih.api.dto.YoutubePastorDto;
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

    public int insertYoutubePastor(YoutubePastorDto youtubePastorDto){
        return mapper.insertYoutubePastor(youtubePastorDto);
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

}
