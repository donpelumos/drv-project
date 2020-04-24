package ie.ait.drvproject.dao;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * Created by Pelumi.Oyefeso on 13-04-2020
 */
@Entity
@Getter
@Setter
@Table(name = "Reviews")
@ApiModel(description = "Entity for an Item's Review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reviewId;
    @Size(min = 15, message = "Review text should be a minimum of 15 characters.")
    @NotNull(message = "Review text cannot be null")
    @ApiModelProperty(notes = "Review text given for an item. Should be a minimum of 15 characters.")
    private String reviewText;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "Review date cannot be null")
    @ApiModelProperty(notes = "Date of the review in the format yyy-MM-dd HH:mm:ss. Cannot be null.")
    private LocalDateTime reviewDate;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;
}
