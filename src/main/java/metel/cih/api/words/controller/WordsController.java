package metel.cih.api.words.controller;


import lombok.RequiredArgsConstructor;
import metel.cih.api.base.ApiResponse;
import metel.cih.api.base.ResponseDto;
import metel.cih.api.dto.ReadingBible;
import metel.cih.api.words.service.WordsService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("words")
@RequiredArgsConstructor
public class WordsController {
    private final WordsService service;

    @ResponseBody
    @GetMapping("/reading-bible")
    public ResponseDto<List<ReadingBible>> fetchReadingBible(
            @RequestParam(value="subject", required = false) String subject
            ,@RequestParam(value="overview", required = false) String overview
            ,@RequestParam(value="excDt", required = false) String excDt
    ) {
        HashMap<String, Object> map = new HashMap<>();
        if(!subject.isEmpty())
            map.put("subject", subject);
        if(!overview.isEmpty())
            map.put("overview", overview);
        if(!excDt.isEmpty())
            map.put("excDt", excDt);
        List<ReadingBible> list = service.selectReadingBible(map);
        return ApiResponse.Success(list);
    }

    @ResponseBody
    @PostMapping("/reading-bible")
    public ResponseDto<Integer> insertReadingBible(@RequestBody ReadingBible dto){
        int result = service.insertReadingBible(dto);
        return ApiResponse.Success(result);
    }

    @ResponseBody
    @PutMapping("/reading-bible")
    public ResponseDto<Integer> updateReadingBible(@RequestBody ReadingBible dto){
        int result = service.updateReadingBible(dto);
        return ApiResponse.Success(result);
    }

    @ResponseBody
    @DeleteMapping("/reading-bible")
    public ResponseDto<Integer> deleteReadingBible(@RequestBody ReadingBible dto){
        int result = service.deleteReadingBible(dto);
        return ApiResponse.Success(result);
    }
}
