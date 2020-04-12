package ie.ait.drvproject.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Pelumi.Oyefeso on 12-04-2020
 */
@Entity
@Table(name = "STOCK")
@Getter
@Setter
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STOCKID")
    private Integer stockId;
    private Double price;
    private Integer quantity;
    @OneToOne
    @JoinColumn(name = "ITEMID")
    private Item item;
}
