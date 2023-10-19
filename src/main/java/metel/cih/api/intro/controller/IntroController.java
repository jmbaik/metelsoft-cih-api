package metel.cih.api.intro.controller;

import lombok.RequiredArgsConstructor;
import metel.cih.api.base.ApiResponse;
import metel.cih.api.base.ResponseDto;
import metel.cih.api.dto.AreaCodeDto;
import metel.cih.api.dto.IntroDto;
import metel.cih.api.intro.service.IntroService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("intro")
@RequiredArgsConstructor
public class IntroController {

    private final IntroService service;

    @ResponseBody
    @GetMapping("/{cCode}/{opt}")
    public ResponseDto<List<IntroDto>> getIntroList(@PathVariable("cCode") String cCode, @PathVariable("opt") String opt){

        HashMap<String, Object> map = new HashMap<>();
        map.put("cCode", cCode);
        map.put("opt", opt);
        List<IntroDto> list = service.selectIntroList(map);
        return ApiResponse.Success(list);
    }

    @ResponseBody
    @GetMapping("/area-code")
    public ResponseDto<List<AreaCodeDto>> getAreaCode(){
        List<AreaCodeDto> list = service.selectAreaCode();
        return ApiResponse.Success(list);
    }

}
