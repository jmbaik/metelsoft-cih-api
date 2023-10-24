package metel.cih.api.admin.service;


import lombok.RequiredArgsConstructor;
import metel.cih.api.admin.mapper.CommonCodeMapper;
import metel.cih.api.dto.AreaCodeDto;
import metel.cih.api.dto.ChurchCodeDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommonCodeService {
    private final CommonCodeMapper mapper;
    public List<AreaCodeDto> selectAreaCode(){
        return mapper.selectAreaCode();
    }
    public List<ChurchCodeDto> selectChurchCode(){
        return mapper.selectChurchCode();
    }
}