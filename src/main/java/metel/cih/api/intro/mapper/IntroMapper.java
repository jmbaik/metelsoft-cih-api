package metel.cih.api.intro.mapper;

import metel.cih.api.dto.AreaCodeDto;
import metel.cih.api.dto.IntroDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface IntroMapper {
    List<IntroDto> selectIntroList(HashMap<String, Object> map);

    List<AreaCodeDto> selectAreaCode();
}
