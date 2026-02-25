package kg.test.lalafo.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class Ad {

    private String imageUrl;
    private String title;
    private String price;
    private String city;
    private LocalDateTime adDate;

}
