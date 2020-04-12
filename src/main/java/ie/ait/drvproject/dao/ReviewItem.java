package ie.ait.drvproject.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Pelumi.Oyefeso on 12-04-2020
 */
@Entity
@Table(name = "REVIEWITEM")
@Getter
@Setter
public class ReviewItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REVIEWITEMID")
    private Integer reviewItemId;
    @OneToOne
    @JoinColumn(name = "ITEMID")
    private Item item;
    @OneToOne
    @JoinColumn(name = "REVIEWID")
    private Review review;
}
