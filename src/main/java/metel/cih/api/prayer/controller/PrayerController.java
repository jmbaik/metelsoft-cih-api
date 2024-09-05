package metel.cih.api.prayer.controller;


import lombok.RequiredArgsConstructor;
import metel.cih.api.base.ApiResponse;
import metel.cih.api.base.ResponseDto;
import metel.cih.api.dto.DogoPrayer;
import metel.cih.api.dto.UserPrayer;
import metel.cih.api.prayer.service.PrayerService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("prayer")
@RequiredArgsConstructor
public class PrayerController {
    private final PrayerService service;

    @ResponseBody
    @GetMapping("/dogo-prayer")
    public ResponseDto<List<DogoPrayer>> fetchDogoPrayer(
            @RequestParam(value="ym", required = false) String ym
            ,@RequestParam(value="cat", required = false) String cat
            ,@RequestParam(value="prayer", required = false) String prayer
    ) {
        HashMap<String, Object> map = new HashMap<>();
        if(!ym.isEmpty())
            map.put("ym", ym);
        if(!cat.isEmpty())
            map.put("cat", cat);
        if(!prayer.isEmpty())
            map.put("prayer", prayer);
        List<DogoPrayer> list = service.selectDogoPrayer(map);
        return ApiResponse.Success(list);
    }

    @ResponseBody
    @PostMapping("/dogo-prayer")
    public ResponseDto<Integer> mergeDogoPrayer(@RequestBody DogoPrayer dto){
        int result = service.mergeDogoPrayer(dto);
        return ApiResponse.Success(result);
    }

    @ResponseBody
    @DeleteMapping("/dogo-prayer")
    public ResponseDto<Integer> deleteDogoPrayer(@RequestBody DogoPrayer dto){
        int result = service.deleteDogoPrayer(dto);
        return ApiResponse.Success(result);
    }

    @ResponseBody
    @PostMapping("/dogo-prayers")
    public ResponseDto<Integer> mergeDogoPrayers(@RequestBody List<DogoPrayer> list){
        int result =0;
        for (DogoPrayer dto : list) {
            result += service.mergeDogoPrayer(dto);
        }
        return ApiResponse.Success(result);
    }

    @ResponseBody
    @GetMapping("/user-prayer")
    public ResponseDto<List<UserPrayer>> fetchUserPrayer(
            @RequestParam(value="uid", required = false) String uid
            ,@RequestParam(value="startDt", required = false) String startDt
            ,@RequestParam(value="endDt", required = false) String endDt
            ,@RequestParam(value="prayer", required = false) String prayer
    ) {
        HashMap<String, Object> map = new HashMap<>();
        if(!uid.isEmpty())
            map.put("uid", uid);
        if(!startDt.isEmpty())
            map.put("startDt", startDt);
        if(!endDt.isEmpty())
            map.put("endDt", endDt);
        if(!prayer.isEmpty())
            map.put("prayer", prayer);
        List<UserPrayer> list = service.selectUserPrayer(map);
        return ApiResponse.Success(list);
    }

    @ResponseBody
    @PostMapping("/user-prayer")
    public ResponseDto<Integer> mergeUserPrayer(@RequestBody UserPrayer dto){
        int result = service.mergeUserPrayer(dto);
        return ApiResponse.Success(result);
    }

    @ResponseBody
    @DeleteMapping("/user-prayer")
    public ResponseDto<Integer> deleteUserPrayer(@RequestBody UserPrayer dto){
        int result = service.deleteUserPrayer(dto);
        return ApiResponse.Success(result);
    }

    @ResponseBody
    @PostMapping("/user-prayers")
    public ResponseDto<Integer> mergeUserPrayers(@RequestBody List<UserPrayer> list){
        int result =0;
        for (UserPrayer dto : list) {
            result += service.mergeUserPrayer(dto);
        }
        return ApiResponse.Success(result);
    }

}

