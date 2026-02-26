package kg.test.lalafo.dto;

import lombok.Data;

@Data
public class AdImage {

    private String original_url;
    private Boolean is_main;

    public String getOriginal_url() {
        return original_url;
    }

    public void setOriginal_url(String original_url) {
        this.original_url = original_url;
    }

    public Boolean getIs_main() {
        return is_main;
    }

    public void setIs_main(Boolean main) {
        is_main = main;
    }
}
