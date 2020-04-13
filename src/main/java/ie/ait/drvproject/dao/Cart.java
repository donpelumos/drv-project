package ie.ait.drvproject.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Pelumi.Oyefeso on 13-04-2020
 */
@Entity
@Getter
@Setter
@Table(name = "Carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartId;
    private Double cartPrice;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
