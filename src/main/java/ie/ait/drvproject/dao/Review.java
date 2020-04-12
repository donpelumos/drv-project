package ie.ait.drvproject.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Pelumi.Oyefeso on 12-04-2020
 */
@Entity
@Table(name = "REVIEW")
@Getter
@Setter
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REVIEWID")
    private Integer reviewId;
    @Column(name = "REVIEWTEXT")
    private String reviewText;
    @Column(name = "REVIEWDATE")
    private Date reviewDate;
    @Column(name = "RATING")
    private Integer rating;
    @OneToOne
    @JoinColumn(name = "USERID")
    private User user;
    @OneToOne(mappedBy = "review")
    private ReviewItem reviewItem;
}
