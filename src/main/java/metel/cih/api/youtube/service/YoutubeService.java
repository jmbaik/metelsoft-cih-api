package metel.cih.api.youtube.service;


import lombok.RequiredArgsConstructor;
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
}
