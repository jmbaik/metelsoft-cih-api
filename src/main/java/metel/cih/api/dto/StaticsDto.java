package metel.cih.api.dto;


import lombok.Data;

@Data
public class StaticsDto {
    private String category;
    private String vid;
    private int likes;
    private int hates;
    private String regDt;
    private String updDt;
}
