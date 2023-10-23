package metel.cih.api.admin.mapper;


import metel.cih.api.dto.AreaCodeDto;
import metel.cih.api.dto.ChurchCodeDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommonCodeMapper {

    List<AreaCodeDto> selectAreaCode();
    List<ChurchCodeDto> selectChurchCode();
    
}
