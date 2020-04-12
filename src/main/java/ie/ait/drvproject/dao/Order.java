package ie.ait.drvproject.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Pelumi.Oyefeso on 12-04-2020
 */
@Entity
@Table(name = "ORDERS")
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDERID")
    private Integer orderId;
    @Column(name = "ORDERDATE")
    private Date orderDate;
    private Double price;
    @ManyToOne
    @JoinColumn(name = "USERID")
    private User user;
    @OneToOne(mappedBy = "order")
    private Email email;
    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    private Set<UserOrderItem> orderItems;
}
