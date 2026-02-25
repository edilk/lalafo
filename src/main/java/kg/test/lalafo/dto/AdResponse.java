package kg.test.lalafo.dto;

import lombok.Data;

import java.util.List;

@Data
public class AdResponse {

    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
