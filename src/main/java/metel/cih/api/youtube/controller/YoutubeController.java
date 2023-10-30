package metel.cih.api.youtube.controller;


import lombok.RequiredArgsConstructor;
import metel.cih.api.base.ApiResponse;
import metel.cih.api.base.ResponseDto;
import metel.cih.api.dto.ChurchCodeDto;
import metel.cih.api.dto.OriginVidDto;
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

    @ResponseBody
    @GetMapping("/origin-vid")
    public ResponseDto<List<OriginVidDto>> getOriginVid(
            @RequestParam(value="name", required = false) String name
            ,@RequestParam(value="title", required = false) String title) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("title", title);
        List<OriginVidDto> list = service.selectOriginVid(map);
        return ApiResponse.Success(list);
    }

    @ResponseBody
    @PostMapping("/pastor")
    public ResponseDto<Integer> insertYoutubePastor(@RequestBody YoutubePastorDto youtubePastorDto){
        Integer result = service.insertYoutubePastor(youtubePastorDto);
        return ApiResponse.Success(result);
    }
    @ResponseBody
    @PutMapping("/pastor")
    public ResponseDto<Integer> updateYoutubePastor(@RequestBody YoutubePastorDto youtubePastorDto){
        Integer result = service.updateYoutubePastor(youtubePastorDto);
        return ApiResponse.Success(result);
    }

    @ResponseBody
    @DeleteMapping("/pastor")
    public ResponseDto<Integer> deleteYoutubePastor(@RequestBody YoutubePastorDto youtubePastorDto){
        Integer result = service.deleteYoutubePastor(youtubePastorDto);
        return ApiResponse.Success(result);
    }

    @ResponseBody
    @PostMapping("/origin-vid")
    public ResponseDto<Integer> insertOriginVid(@RequestBody OriginVidDto originVidDto){
        Integer result = service.insertOriginVid(originVidDto);
        return ApiResponse.Success(result);
    }

    @ResponseBody
    @PutMapping("/origin-vid")
    public ResponseDto<Integer> updateOriginVid(@RequestBody OriginVidDto originVidDto){
        Integer result = service.updateOriginVid(originVidDto);
        return ApiResponse.Success(result);
    }
    @ResponseBody
    @DeleteMapping("/origin-vid")
    public ResponseDto<Integer> deleteOriginVid(@RequestBody OriginVidDto originVidDto){
        Integer result = service.deleteOriginVid(originVidDto);
        return ApiResponse.Success(result);
    }

}