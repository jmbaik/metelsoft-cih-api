package metel.cih.api.dto;

import lombok.Data;

import java.math.BigInteger;

@Data
public class UserPrayer {
    private BigInteger pSeq;
    private String uid;
    private String startDt;
    private String endDt;
    private String prayer;
    private String regDt;
    private String updDt;
}
