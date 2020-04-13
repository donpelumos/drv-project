package ie.ait.drvproject.model.classes;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by Pelumi.Oyefeso on 13-04-2020
 */
@Getter
@Setter
public class ItemResponse {
    private Integer itemId;
    private String itemName;
    private String itemDescription;
    private Double itemPrice;
    private Integer itemCategoryId;
}
