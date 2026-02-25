package kg.test.lalafo.controller;

import kg.test.lalafo.model.Ad;
import kg.test.lalafo.service.AdService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AdController {

    private final AdService service;

    public AdController(AdService service) {
        this.service = service;
    }

    @GetMapping("/ads")
    public List<Ad> getAds() {
        return service.getAds();
    }

    @GetMapping("/test-result")
    public String showAds(Model model) {
        model.addAttribute("ads", service.getAds());

        return "index";
    }
}
