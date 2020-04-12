package ie.ait.drvproject.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Pelumi.Oyefeso on 12-04-2020
 */
@Entity
@Getter
@Setter
@Table(name = "Items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itemId;
    private String itemName;
    private Double itemPrice;
    private String description;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
