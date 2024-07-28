package metel.cih.api.admin.mapper;


import metel.cih.api.dto.AreaCodeDto;
import metel.cih.api.dto.ChurchCodeDto;
import metel.cih.api.dto.PastorDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommonCodeMapper {

    List<AreaCodeDto> selectAreaCode();
    List<ChurchCodeDto> selectChurchCode();
    List<PastorDto> selectPastor();

    int mergeAreaCode(AreaCodeDto dto) ;
    int deleteAreaCode(String areaCode);
    int insertChurchCode(ChurchCodeDto dto);
    int updateChurchCode(ChurchCodeDto dto);
    int deleteChurchCode(ChurchCodeDto dto);
    int insertPastor(PastorDto dto);
    int updatePastor(PastorDto dto);
    int deletePastor(PastorDto dto);
}
