package metel.cih.api.admin.controller;


import lombok.RequiredArgsConstructor;
import metel.cih.api.admin.service.CommonCodeService;
import metel.cih.api.base.ApiResponse;
import metel.cih.api.base.ResponseDto;
import metel.cih.api.dto.AdminUserDto;
import metel.cih.api.dto.AreaCodeDto;
import metel.cih.api.dto.ChurchCodeDto;
import metel.cih.api.dto.PastorDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("common-code")
@RequiredArgsConstructor
public class CommonCodeController {
    private final CommonCodeService service;

    @ResponseBody
    @GetMapping("/area-code")
    public ResponseDto<List<AreaCodeDto>> getAreaCode() {
        List<AreaCodeDto> list = service.selectAreaCode();
        return ApiResponse.Success(list);
    }

    @ResponseBody
    @GetMapping("/church-code")
    public ResponseDto<List<ChurchCodeDto>> getChurchCode() {
        List<ChurchCodeDto> list = service.selectChurchCode();
        return ApiResponse.Success(list);
    }

    @ResponseBody
    @PostMapping("/church-code")
    public ResponseDto<Integer> insertChurchCode(@RequestBody ChurchCodeDto churchCodeDto){
        Integer result = service.insertChurchCode(churchCodeDto);
        return ApiResponse.Success(result);
    }

    @ResponseBody
    @PutMapping("/church-code")
    public ResponseDto<Integer> updateChurchCode(@RequestBody ChurchCodeDto churchCodeDto){
        Integer result = service.updateChurchCode(churchCodeDto);
        return ApiResponse.Success(result);
    }

    @ResponseBody
    @DeleteMapping("/church-code")
    public ResponseDto<Integer> deleteChurchCode(@RequestBody ChurchCodeDto churchCodeDto){
        Integer result = service.deleteChurchCode(churchCodeDto);
        return ApiResponse.Success(result);
    }
    @ResponseBody
    @GetMapping("/pastor")
    public ResponseDto<List<PastorDto>> getPastor() {
        List<PastorDto> list = service.selectPastor();
        return ApiResponse.Success(list);
    }

    @ResponseBody
    @PostMapping("/pastor")
    public ResponseDto<Integer> insertPastor(@RequestBody PastorDto pastorDto){
        Integer result = service.insertPastor(pastorDto);
        return ApiResponse.Success(result);
    }

    @ResponseBody
    @PutMapping("/pastor")
    public ResponseDto<Integer> updatePastor(@RequestBody PastorDto pastorDto){
        Integer result = service.updatePastor(pastorDto);
        return ApiResponse.Success(result);
    }

    @ResponseBody
    @DeleteMapping("/pastor")
    public ResponseDto<Integer> deletePastor(@RequestBody PastorDto pastorDto){
        Integer result = service.deletePastor(pastorDto);
        return ApiResponse.Success(result);
    }
}
