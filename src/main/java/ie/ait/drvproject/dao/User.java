package ie.ait.drvproject.dao;

import ie.ait.drvproject.model.enums.Gender;
import ie.ait.drvproject.model.enums.Status;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by Pelumi.Oyefeso on 12-04-2020
 */
@Entity
@Table(name = "USER")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USERID")
    private Integer userId;
    private String username;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String address;
    private String county;
    private String phone;
    private String email;
    @Enumerated(EnumType.ORDINAL)
    private Status status;
    @OneToOne(mappedBy = "user")
    private Cart cart;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<CartItem> cartItems;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<Order> orders;
    @OneToOne(mappedBy = "user")
    private Review review;
}
