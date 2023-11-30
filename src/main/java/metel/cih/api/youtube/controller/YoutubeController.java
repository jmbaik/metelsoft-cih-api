package metel.cih.api.youtube.controller;


import lombok.RequiredArgsConstructor;
import metel.cih.api.base.ApiResponse;
import metel.cih.api.base.ResponseDto;
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
            @RequestParam(value="options", required = false) String options
            ,@RequestParam(value="keyword", required = false) String keyword) {
        System.out.println("----"+options);
        HashMap<String, Object> map = new HashMap<>();
        map.put("options", options);
        map.put("keyword", keyword);
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
    public ResponseDto<Integer> mergeYoutubePastor(@RequestBody YoutubePastorDto youtubePastorDto){
        int result = service.mergeYoutubePastor(youtubePastorDto);
        OriginVidDto originVidDto = new OriginVidDto();
        originVidDto.setChannelId(youtubePastorDto.getChannelId());
        originVidDto.setChannelTitle(youtubePastorDto.getChannelTitle());
        originVidDto.setUserId(youtubePastorDto.getUserId());
        result += service.mergeOriginVid(originVidDto);
        return ApiResponse.Success(result);
    }
    @ResponseBody
    @PutMapping("/pastor")
    public ResponseDto<Integer> updateYoutubePastor(@RequestBody YoutubePastorDto youtubePastorDto){
        Integer result = service.updateYoutubePastor(youtubePastorDto);
        return ApiResponse.Success(result);
    }

    @ResponseBody
    @PostMapping("/pastor-delete")
    public ResponseDto<Integer> deleteYoutubePastor(@RequestBody YoutubePastorDto youtubePastorDto){
        Integer result = service.deleteYoutubePastor(youtubePastorDto);
        return ApiResponse.Success(result);
    }

    @ResponseBody
    @PostMapping("/origin-vid")
    public ResponseDto<Integer> mergeOriginVid(@RequestBody OriginVidDto originVidDto){
        Integer result = service.mergeOriginVid(originVidDto);
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
