package metel.cih.api.admin.service;


import lombok.RequiredArgsConstructor;
import metel.cih.api.admin.mapper.CommonCodeMapper;
import metel.cih.api.dto.AreaCodeDto;
import metel.cih.api.dto.ChurchCodeDto;
import metel.cih.api.dto.PastorDto;
import org.springframework.stereotype.Service;

import java.awt.geom.Area;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommonCodeService {
    private final CommonCodeMapper mapper;
    public List<AreaCodeDto> selectAreaCode(){return mapper.selectAreaCode();}
    public int mergeAreaCode(AreaCodeDto dto){return mapper.mergeAreaCode(dto);}
    public int deleteAreaCode(String areaCode) {return mapper.deleteAreaCode(areaCode);}

    public List<ChurchCodeDto> selectChurchCode(){return mapper.selectChurchCode();}
    public List<PastorDto> selectPastor(){return mapper.selectPastor();}
    public int insertChurchCode(ChurchCodeDto dto){return mapper.insertChurchCode(dto);}
    public int updateChurchCode(ChurchCodeDto dto){return mapper.updateChurchCode(dto);}
    public int deleteChurchCode(ChurchCodeDto dto){return mapper.deleteChurchCode(dto);}

    public int insertPastor(PastorDto dto){return mapper.insertPastor(dto);}
    public int updatePastor(PastorDto dto){return mapper.updatePastor(dto);}
    public int deletePastor(PastorDto dto){return mapper.deletePastor(dto);}
}
