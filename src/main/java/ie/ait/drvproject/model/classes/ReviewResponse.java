package ie.ait.drvproject.model.classes;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

/**
 * Created by Pelumi.Oyefeso on 13-04-2020
 */
@Getter
@Setter
public class ReviewResponse {
    private Integer reviewId;
    private Double rating;
    private String reviewsText;
    private Date reviewDate;
}
