package metel.cih.api.words.service;

import lombok.RequiredArgsConstructor;
import metel.cih.api.dto.ReadingBible;
import metel.cih.api.words.mapper.WordsMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WordsService {
    private final WordsMapper mapper;

    public List<ReadingBible> selectReadingBible(HashMap<String, Object> map) {
        return mapper.selectReadingBible(map);
    }

    public int insertReadingBible(ReadingBible dto){
        return mapper.insertReadingBible(dto);
    }
    public int updateReadingBible(ReadingBible dto){
        return mapper.updateReadingBible(dto);
    }
    public int deleteReadingBible(ReadingBible dto){
        return mapper.deleteReadingBible(dto);
    }

}
