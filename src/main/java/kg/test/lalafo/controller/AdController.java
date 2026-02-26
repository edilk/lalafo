package kg.test.lalafo.controller;

import kg.test.lalafo.service.AdService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdController {

    private final AdService service;

    public AdController(AdService service) {
        this.service = service;
    }

    @GetMapping("/test-result")
    public String showAds(Model model) {
        model.addAttribute("ads", service.getAds());

        return "index";
    }
}
