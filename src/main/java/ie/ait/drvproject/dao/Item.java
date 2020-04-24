package ie.ait.drvproject.dao;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Pelumi.Oyefeso on 12-04-2020
 */
@Entity
@Getter
@Setter
@Table(name = "Items")
@ApiModel(description = "Entity for a Store Item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itemId;
    @Size(min = 7, message = "Item name should be a minimum of 7 characters.")
    @ApiModelProperty(notes = "Name of the item. Should be a minimum of 7 characters.")
    @NotNull(message = "Item name cannot be null")
    private String itemName;
    @Min(value=2, message = "The minimum item price is 2.00 Euros.")
    @Max(value=500, message = "The maximum item price is 500.00 Euros.")
    @ApiModelProperty(notes = "Price of the item. Should be a minimum of 2.00.")
    @NotNull(message = "Item price cannot be null")
    private Double itemPrice;
    @Size(min = 15, message = "Item description should be a minimum of 15 characters.")
    @NotNull(message = "Item description cannot be null")
    @ApiModelProperty(notes = "Description of the item. Should be a minimum of 15 characters.")
    private String itemDescription;
    @Min(value=2, message = "Item quantity should be greater than 0.")
    @ApiModelProperty(notes = "Quantity of the item. Should be greater than 0.")
    @NotNull(message = "Item quantity cannot be null")
    private Integer itemQuantity;
}
