package metel.cih.api.words.mapper;

import metel.cih.api.dto.ReadingBible;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface WordsMapper {
    List<ReadingBible> selectReadingBible(HashMap<String, Object> map);
    int insertReadingBible(ReadingBible readingBible);
    int mergeReadingBible(ReadingBible readingBible);
    int updateReadingBible(ReadingBible readingBible);
    int deleteReadingBible(ReadingBible readingBible);
}
