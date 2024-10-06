package metel.cih.api.dto.prayer;


import lombok.Data;
import metel.cih.api.dto.DogoPrayer;

import java.util.List;

@Data
public class DogoPrayerViewModel {
    private String ym;
    private List<DogoPrayer> prayerItems1;
    private List<DogoPrayer> prayerItems2;
    private List<DogoPrayer> prayerItems3;
    private List<DogoPrayer> prayerItems4;
    private List<DogoPrayer> prayerItems5;
}
