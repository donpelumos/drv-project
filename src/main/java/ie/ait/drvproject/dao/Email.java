package ie.ait.drvproject.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Pelumi.Oyefeso on 12-04-2020
 */
@Entity
@Table(name = "EMAIL")
@Getter
@Setter
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMAILID")
    private Integer emailId;
    private String topic;
    private String body;
    @OneToOne
    @JoinColumn(name = "USERID")
    private User user;
    @OneToOne
    @JoinColumn(name = "ORDERID")
    private Order order;
}
