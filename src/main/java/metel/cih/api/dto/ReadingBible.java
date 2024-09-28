package metel.cih.api.dto;


import lombok.Data;

@Data
public class ReadingBible {
    private int seqReading;
    private String subject;
    private String refBasic;
    private String refPoint;
    private String overview;
    private String bible;
    private String regId;
    private String regDt;
    private String updId;
    private String updDt;
}
