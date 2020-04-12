package ie.ait.drvproject.dao;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.CodePointLength;

import javax.persistence.*;

/**
 * Created by Pelumi.Oyefeso on 12-04-2020
 */
@Entity
@Table(name = "CART")
@Getter
@Setter
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CARTID")
    private Integer cartId;
    @OneToOne
    @JoinColumn(name = "USERID")
    private User user;
    private Double price;
}
