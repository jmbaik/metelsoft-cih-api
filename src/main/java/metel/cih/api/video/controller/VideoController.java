package metel.cih.api.video.controller;

import lombok.RequiredArgsConstructor;
import metel.cih.api.base.ApiResponse;
import metel.cih.api.base.ResponseDto;
import metel.cih.api.dto.VideoDto;
import metel.cih.api.video.service.VideoService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("video")
@RequiredArgsConstructor
public class VideoController {

    private final VideoService service;

    @ResponseBody
    @PostMapping("/default")
    public ResponseDto<Integer> saveVideoClip(@RequestBody VideoDto videoDto){
        Integer result = service.saveVideoClip(videoDto);
        return ApiResponse.Success(result);
    }
    @ResponseBody
    @DeleteMapping("/default")
    public ResponseDto<Integer> deleteVideoClip(@RequestBody VideoDto videoDto){
        Integer result = service.deleteVideoClip(videoDto);
        return ApiResponse.Success(result);
    }
    @ResponseBody
    @GetMapping("/default")
    public ResponseDto<List<VideoDto>> getVideoClips(@RequestParam(required = false) String cCode,
                                                     @RequestParam(required = false) String cat){
        HashMap<String, Object> params = new HashMap<>();
        params.put("cCode", cCode);
        params.put("cat", cat);
        List<VideoDto> list = service.selectVideoList(params);
        return ApiResponse.Success(list);
    }

    @ResponseBody
    @GetMapping("/seq-video")
    public ResponseDto<Integer> getVideoClips(){
        Integer result = service.getSeqVideo();
        return ApiResponse.Success(result);
    }


}
