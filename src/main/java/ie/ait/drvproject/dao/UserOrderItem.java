package ie.ait.drvproject.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Pelumi.Oyefeso on 12-04-2020
 */
@Entity
@Table(name = "USERORDERITEM")
@Getter
@Setter
public class UserOrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USERORDERITEMID")
    private Integer userOrderItemId;
    @Column(name = "ITEMCOUNT")
    private Integer itemCount;
    private Double price;
    @OneToOne
    @JoinColumn(name = "ITEMID")
    private Item item;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ORDERID")
    private Order order;
}
