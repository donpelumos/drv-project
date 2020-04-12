package ie.ait.drvproject.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Pelumi.Oyefeso on 12-04-2020
 */
@Entity
@Table(name = "ITEM")
@Getter
@Setter
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEMID")
    private Integer itemId;
    @Column(name = "NAME")
    private String itemName;
    private Double price;
    private String description;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CATEGORYID")
    private Category category;
    @OneToOne(mappedBy = "item")
    private CartItem cartItem;
    @OneToOne(mappedBy = "item")
    private UserOrderItem userOrderItem;
    @OneToOne(mappedBy = "item")
    private ReviewItem reviewItem;
}
