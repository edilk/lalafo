package kg.test.lalafo.service;

import kg.test.lalafo.dto.AdResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LalafoClient {

    private final RestTemplate template = new RestTemplate();

    private static final String URL = "https://lalafo.kg/api/search/v3/feed?expand=url&page=1&per-page=100";

    public AdResponse fetchAds() {

        HttpHeaders headers = new HttpHeaders();
        headers.set("User-Agent", "Mozilla/5.0");
        headers.set("Accept", "application/json");
        headers.set("device", "pc");
        headers.set("Country-Id", "12");
        headers.set("language", "ru_RU");
        headers.set("referer", "https://lalafo.kg");

        HttpEntity entity = new HttpEntity(headers);

        ResponseEntity<AdResponse> response =
                template.exchange(
                        URL,
                        HttpMethod.GET,
                        entity,
                        AdResponse.class
                );

        System.out.println("Response getBody: " + response.getBody());

        return response.getBody();
    }
}
