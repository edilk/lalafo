package kg.test.lalafo.service;

import kg.test.lalafo.dto.AdImage;
import kg.test.lalafo.dto.AdResponse;
import kg.test.lalafo.dto.Item;
import kg.test.lalafo.model.Ad;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Service
public class AdService {

    private final LalafoClient client;

    public AdService(LalafoClient client) {
        this.client = client;
    }

    public List<Ad> getAds() {

        AdResponse response = client.fetchAds();

        System.out.println("Response: " + response);

        System.out.println("Items size: " + response.getItems().size());

        return response.getItems()
                .stream()
                .limit(100)
                .map(this::mapToAd)
                .toList();
    }

    private Ad mapToAd(Item item) {

        String imageUrl = item.getImages()
                .stream()
                .filter(img -> Boolean.TRUE.equals(img.getIs_main()))
                .findFirst()
                .map(AdImage::getOriginal_url)
                .orElse(null);

        String priceTxt = item.getPrice() + " " + item.getCurrency();

        LocalDateTime date = Instant.ofEpochSecond(item.getCreated_time())
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();

        Ad ad = new Ad();
        ad.setImageUrl(imageUrl);
        ad.setTitle(item.getTitle());
        ad.setPrice(priceTxt);
        ad.setCity(item.getCity());
        ad.setAdDate(date);

        return ad;
    }
}
