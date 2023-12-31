package metel.cih.api.app.controller;


import lombok.RequiredArgsConstructor;
import metel.cih.api.app.service.AppService;
import metel.cih.api.base.ApiResponse;
import metel.cih.api.base.CommonUtils;
import metel.cih.api.base.ResponseDto;
import metel.cih.api.dto.CommentsDto;
import metel.cih.api.dto.OriginVidDto;
import metel.cih.api.dto.StaticsDto;
import metel.cih.api.dto.YoutubeVideoDto;
import metel.cih.api.youtube.service.YoutubeService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("app")
@RequiredArgsConstructor
public class AppController {
    private final AppService service;

    @ResponseBody
    @GetMapping("/main-ccm")
    public ResponseDto<List<YoutubeVideoDto>> getMainCcm() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("any", "any");
          List<YoutubeVideoDto> list = service.selectMainCcm(map);
        return ApiResponse.Success(list);
    }

    @ResponseBody
    @GetMapping("/main-sermon")
    public ResponseDto<List<YoutubeVideoDto>> getMainSermon() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("any", "any");
          List<YoutubeVideoDto> list = service.selectMainSermon(map);
        return ApiResponse.Success(list);
    }

    @ResponseBody
    @GetMapping("/main-pastor")
    public ResponseDto<List<YoutubeVideoDto>> getMainPastor() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("any", "any");
        List<YoutubeVideoDto> list = service.selectMainPastor(map);
        return ApiResponse.Success(list);
    }

    @ResponseBody
    @GetMapping("/main-celeb")
    public ResponseDto<List<YoutubeVideoDto>> getMainCeleb() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("any", "any");
          List<YoutubeVideoDto> list = service.selectMainCeleb(map);
        return ApiResponse.Success(list);
    }

    @ResponseBody
    @GetMapping("/comments")
    public ResponseDto<List<CommentsDto>> getComments(
            @RequestParam(value="category", required = true) String category
            ,@RequestParam(value="vid", required = true) String vid
    ) {
        CommentsDto commentsDto = new CommentsDto();
        commentsDto.setCategory(category);
        commentsDto.setVid(vid);
        List<CommentsDto> list = service.selectComments(commentsDto);
        return ApiResponse.Success(list);
    }

    @ResponseBody
    @PostMapping("/comments")
    public ResponseDto<Integer> mergeComments(@RequestBody CommentsDto commentsDto){
        int result = service.mergeComments(commentsDto);
        return ApiResponse.Success(result);
    }

    @ResponseBody
    @PostMapping("/statics")
    public ResponseDto<Integer> mergeStatics(@RequestBody StaticsDto staticsDto){
        int result = service.mergeStatics(staticsDto);
        return ApiResponse.Success(result);
    }

    // youtube faith part
    @ResponseBody
    @GetMapping("/faith")
    public ResponseDto<List<YoutubeVideoDto>> getYoutubeFaith(
            @RequestParam(value="options", required = false) String options
            ,@RequestParam(value="keyword", required = false) String keyword
            ,@RequestParam(value="shorts", required = false) String shorts
            ,@RequestParam(value="page", required = false) String page
    ) {
        System.out.println("----"+options);
        HashMap<String, Object> map = new HashMap<>();
        map.put("options", options);
        map.put("keyword", keyword);
        map.put("shorts", shorts);
        if(page != null ){
            int _page = Integer.parseInt(page);
            map.put("page", (_page-1)*50);
        }
        List<YoutubeVideoDto> list = service.selectYoutubeFaith(map);
        return ApiResponse.Success(list);
    }

    @ResponseBody
    @PostMapping("/faith")
    public ResponseDto<Integer> mergeYoutubeFaith(@RequestBody YoutubeVideoDto youtubeFaithDto){
        String shorts = CommonUtils.IsShorts(youtubeFaithDto.getVid());
        youtubeFaithDto.setShorts(shorts);
        int result = service.mergeYoutubeFaith(youtubeFaithDto);
        OriginVidDto originVidDto = new OriginVidDto();
        originVidDto.setChannelId(youtubeFaithDto.getChannelId());
        originVidDto.setChannelTitle(youtubeFaithDto.getChannelTitle());
        originVidDto.setUserId(youtubeFaithDto.getUserId());
        result += service.mergeOriginVid(originVidDto);
        return ApiResponse.Success(result);
    }
    @ResponseBody
    @PostMapping("/faith-delete")
    public ResponseDto<Integer> deleteYoutubeFaith(@RequestBody YoutubeVideoDto youtubeFaithDto){
        Integer result = service.deleteYoutubeFaith(youtubeFaithDto);
        return ApiResponse.Success(result);
    }

    // shorts ccm part
    @ResponseBody
    @GetMapping("/ccm")
    public ResponseDto<List<YoutubeVideoDto>> getShortsCcm(
            @RequestParam(value="options", required = false) String options
            ,@RequestParam(value="keyword", required = false) String keyword
            ,@RequestParam(value="shorts", required = false) String shorts
            ,@RequestParam(value="page", required = false) int page
    ) {
        System.out.println("----"+options);
        HashMap<String, Object> map = new HashMap<>();
        map.put("options", options);
        map.put("keyword", keyword);
        map.put("shorts", shorts);
        map.put("page", (page-1)*50);
        List<YoutubeVideoDto> list = service.selectShortsCcm(map);
        return ApiResponse.Success(list);
    }
    @ResponseBody
    @PostMapping("/ccm")
    public ResponseDto<Integer> mergeShortsCcm(@RequestBody YoutubeVideoDto shortsCcmDto){
        String shorts = CommonUtils.IsShorts(shortsCcmDto.getVid());
        shortsCcmDto.setShorts(shorts);
        int result = service.mergeShortsCcm(shortsCcmDto);
        OriginVidDto originVidDto = new OriginVidDto();
        originVidDto.setChannelId(shortsCcmDto.getChannelId());
        originVidDto.setChannelTitle(shortsCcmDto.getChannelTitle());
        originVidDto.setUserId(shortsCcmDto.getUserId());
        result += service.mergeOriginVid(originVidDto);
        return ApiResponse.Success(result);
    }
    @ResponseBody
    @PostMapping("/ccm-delete")
    public ResponseDto<Integer> deleteShortsCcm(@RequestBody YoutubeVideoDto shortsCcmDto){
        Integer result = service.deleteShortsCcm(shortsCcmDto);
        return ApiResponse.Success(result);
    }

    //youtube mercy part
    @ResponseBody
    @GetMapping("/mercy")
    public ResponseDto<List<YoutubeVideoDto>> getYoutubeMercy(
            @RequestParam(value="options", required = false) String options
            ,@RequestParam(value="keyword", required = false) String keyword
            ,@RequestParam(value="shorts", required = false) String shorts
            ,@RequestParam(value="page", required = false) int page
    ) {
        System.out.println("----"+options);
        HashMap<String, Object> map = new HashMap<>();
        map.put("options", options);
        map.put("keyword", keyword);
        map.put("shorts", shorts);
        map.put("page", (page-1)*50);
        List<YoutubeVideoDto> list = service.selectYoutubeMercy(map);
        return ApiResponse.Success(list);
    }
    @ResponseBody
    @PostMapping("/mercy")
    public ResponseDto<Integer> mergeYoutubeMercy(@RequestBody YoutubeVideoDto youtubeMercyDto){
        String shorts = CommonUtils.IsShorts(youtubeMercyDto.getVid());
        youtubeMercyDto.setShorts(shorts);
        int result = service.mergeYoutubeMercy(youtubeMercyDto);
        OriginVidDto originVidDto = new OriginVidDto();
        originVidDto.setChannelId(youtubeMercyDto.getChannelId());
        originVidDto.setChannelTitle(youtubeMercyDto.getChannelTitle());
        originVidDto.setUserId(youtubeMercyDto.getUserId());
        result += service.mergeOriginVid(originVidDto);
        return ApiResponse.Success(result);
    }
    @ResponseBody
    @PostMapping("/mercy-delete")
    public ResponseDto<Integer> deleteYoutubeMercy(@RequestBody YoutubeVideoDto youtubeMercyDto){
        Integer result = service.deleteYoutubeMercy(youtubeMercyDto);
        return ApiResponse.Success(result);
    }

    // youtube sermon part
    @ResponseBody
    @GetMapping("/sermon")
    public ResponseDto<List<YoutubeVideoDto>> getYoutubeSermon(
            @RequestParam(value="options", required = false) String options
            ,@RequestParam(value="keyword", required = false) String keyword
            ,@RequestParam(value="shorts", required = false) String shorts
            ,@RequestParam(value="page", required = false) int page
    ) {
        System.out.println("----"+options);
        HashMap<String, Object> map = new HashMap<>();
        map.put("options", options);
        map.put("keyword", keyword);
        map.put("shorts", shorts);
        map.put("page", (page-1)*50);
        List<YoutubeVideoDto> list = service.selectYoutubeSermon(map);
        return ApiResponse.Success(list);
    }

    @ResponseBody
    @PostMapping("/sermon")
    public ResponseDto<Integer> mergeYoutubeSermon(@RequestBody YoutubeVideoDto youtubeSermonDto) {
        String shorts = CommonUtils.IsShorts(youtubeSermonDto.getVid());
        youtubeSermonDto.setShorts(shorts);
        int result = service.mergeYoutubeSermon(youtubeSermonDto);
        OriginVidDto originVidDto = new OriginVidDto();
        originVidDto.setChannelId(youtubeSermonDto.getChannelId());
        originVidDto.setChannelTitle(youtubeSermonDto.getChannelTitle());
        originVidDto.setUserId(youtubeSermonDto.getUserId());
        result += service.mergeOriginVid(originVidDto);
        return ApiResponse.Success(result);
    }
    @ResponseBody
    @PostMapping("/sermon-delete")
    public ResponseDto<Integer> deleteYoutubeSermon(@RequestBody YoutubeVideoDto youtubeSermonDto){
        Integer result = service.deleteYoutubeSermon(youtubeSermonDto);
        return ApiResponse.Success(result);
    }

    // youtube celeb part
    @ResponseBody
    @GetMapping("/celeb")
    public ResponseDto<List<YoutubeVideoDto>> getYoutubeCeleb(
            @RequestParam(value="options", required = false) String options
            ,@RequestParam(value="keyword", required = false) String keyword
            ,@RequestParam(value="shorts", required = false) String shorts
            ,@RequestParam(value="page", required = false) int page
    ) {
        System.out.println("----"+options);
        HashMap<String, Object> map = new HashMap<>();
        map.put("options", options);
        map.put("keyword", keyword);
        map.put("shorts", shorts);
        map.put("page", (page-1)*50);
        List<YoutubeVideoDto> list = service.selectYoutubeCeleb(map);
        return ApiResponse.Success(list);
    }
    @ResponseBody
    @PostMapping("/celeb")
    public ResponseDto<Integer> mergeYoutubeCeleb(@RequestBody YoutubeVideoDto youtubeCelebDto){
        String shorts = CommonUtils.IsShorts(youtubeCelebDto.getVid());
        youtubeCelebDto.setShorts(shorts);
        int result = service.mergeYoutubeCeleb(youtubeCelebDto);
        OriginVidDto originVidDto = new OriginVidDto();
        originVidDto.setChannelId(youtubeCelebDto.getChannelId());
        originVidDto.setChannelTitle(youtubeCelebDto.getChannelTitle());
        originVidDto.setUserId(youtubeCelebDto.getUserId());
        result += service.mergeOriginVid(originVidDto);
        return ApiResponse.Success(result);
    }
    @ResponseBody
    @PostMapping("/celeb-delete")
    public ResponseDto<Integer> deleteYoutubeCeleb(@RequestBody YoutubeVideoDto youtubeCelebDto){
        Integer result = service.deleteYoutubeCeleb(youtubeCelebDto);
        return ApiResponse.Success(result);
    }

    @ResponseBody
    @GetMapping("/pastor")
    public ResponseDto<List<YoutubeVideoDto>> getYoutubePastor(
            @RequestParam(value="options", required = false) String options
            ,@RequestParam(value="keyword", required = false) String keyword
            ,@RequestParam(value="shorts", required = false) String shorts
            ,@RequestParam(value="page", required = false) Integer page
    ) {
        System.out.println("----"+options);
        HashMap<String, Object> map = new HashMap<>();
        map.put("options", options);
        map.put("keyword", keyword);
        map.put("shorts", shorts);
        if(page != null)
            map.put("page", (page-1)*50);
        List<YoutubeVideoDto> list = service.selectYoutubePastor(map);
        return ApiResponse.Success(list);
    }
    @ResponseBody
    @PostMapping("/pastor")
    public ResponseDto<Integer> mergeYoutubePastor(@RequestBody YoutubeVideoDto youtubePastorDto){
        String shorts = CommonUtils.IsShorts(youtubePastorDto.getVid());
        youtubePastorDto.setShorts(shorts);
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
    public ResponseDto<Integer> updateYoutubePastor(@RequestBody YoutubeVideoDto youtubePastorDto){
        Integer result = service.updateYoutubePastor(youtubePastorDto);
        return ApiResponse.Success(result);
    }

    @ResponseBody
    @PostMapping("/pastor-delete")
    public ResponseDto<Integer> deleteYoutubePastor(@RequestBody YoutubeVideoDto youtubePastorDto){
        Integer result = service.deleteYoutubePastor(youtubePastorDto);
        return ApiResponse.Success(result);
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
