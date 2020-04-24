package ie.ait.drvproject.model.classes;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by Pelumi.Oyefeso on 13-04-2020
 */
@Getter
@Setter
@ApiModel(description = "Item POJO to be mapped to JSON in returning item search data.")
public class ItemResponse {
    private Integer itemId;
    @ApiModelProperty(notes = "Name of the item.")
    private String itemName;
    @ApiModelProperty(notes = "Description of the item.")
    private String itemDescription;
    @ApiModelProperty(notes = "Price of the item.")
    private Double itemPrice;
}
