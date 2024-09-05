package metel.cih.api.prayer.mapper;

import metel.cih.api.dto.DogoPrayer;
import metel.cih.api.dto.UserPrayer;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface PrayerMapper {
    List<DogoPrayer> selectDogoPrayer(HashMap<String, Object> map);

    int mergeDogoPrayer(DogoPrayer dto);

    int deleteDogoPrayer(DogoPrayer dto);

    List<UserPrayer> selectUserPrayer(HashMap<String, Object> map);

    int mergeUserPrayer(UserPrayer dto);

    int deleteUserPrayer(UserPrayer dto);
}
