package ie.ait.drvproject.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Pelumi.Oyefeso on 12-04-2020
 */
@Entity
@Table(name = "CARTITEM")
@Getter
@Setter
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CARTITEMID")
    private Integer cartItemId;
    private Integer quantity = 1;
    private Double price;
    @ManyToOne
    @JoinColumn(name = "USERID")
    User user;
    @OneToOne
    @JoinColumn(name = "ITEMID")
    Item item;
}
