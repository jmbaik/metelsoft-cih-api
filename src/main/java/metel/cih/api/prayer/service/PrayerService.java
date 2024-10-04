package metel.cih.api.prayer.service;

import lombok.RequiredArgsConstructor;
import metel.cih.api.dto.DogoPrayer;
import metel.cih.api.dto.UserPrayer;
import metel.cih.api.prayer.mapper.PrayerMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PrayerService {
    private final PrayerMapper mapper;

    public List<DogoPrayer> selectDogoPrayer(HashMap<String, Object> map) {
        return mapper.selectDogoPrayer(map);
    }

    public int mergeDogoPrayer(DogoPrayer dto){
        return mapper.mergeDogoPrayer(dto);
    }

    public int deleteDogoPrayer(DogoPrayer dto){
        return mapper.deleteDogoPrayer(dto);
    }

    public int deleteDogoPrayerByCat(DogoPrayer dto) {
        return mapper.deleteDogoPrayerByCat(dto);
    }

    public List<UserPrayer> selectUserPrayer(HashMap<String, Object> map) {
        return mapper.selectUserPrayer(map);
    }

    public int mergeUserPrayer(UserPrayer dto){
        return mapper.mergeUserPrayer(dto);
    }

    public int deleteUserPrayer(UserPrayer dto){
        return mapper.deleteUserPrayer(dto);
    }

}
