package kg.test.lalafo.dto;

import lombok.Data;

import java.util.List;

@Data
public class Item {

    private String title;
    private String city;
    private Double price;
    private String currency;
    private Long createAt;
    private List<AdImage> images;
}
