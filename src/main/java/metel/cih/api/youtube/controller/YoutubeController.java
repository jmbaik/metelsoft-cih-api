package metel.cih.api.youtube.controller;


import lombok.RequiredArgsConstructor;
import metel.cih.api.base.ApiResponse;
import metel.cih.api.base.ResponseDto;
import metel.cih.api.dto.ChurchCodeDto;
import metel.cih.api.dto.YoutubePastorDto;
import metel.cih.api.youtube.service.YoutubeService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("youtube")
@RequiredArgsConstructor
public class YoutubeController {
    private final YoutubeService service;

    @ResponseBody
    @GetMapping("/pastor")
    public ResponseDto<List<YoutubePastorDto>> getChurchCode(
            @RequestParam(value="pastorCode", required = false) String pastorCode
            ,@RequestParam(value="ovid", required = false) String ovid) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("ovid", ovid);
        map.put("pastorCode", pastorCode);
        List<YoutubePastorDto> list = service.selectYoutubePastor(map);
        return ApiResponse.Success(list);
    }
}
