package ie.ait.drvproject.dao;

import ie.ait.drvproject.model.enums.Gender;
import ie.ait.drvproject.model.enums.Status;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

/**
 * Created by Pelumi.Oyefeso on 12-04-2020
 */
@Entity
@Getter
@Setter
@Table(name = "Users")
@ApiModel(description = "Entity for a User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    @Size(min = 5, message = "Username should be a minimum of 5 characters.")
    @ApiModelProperty(notes = "Username of a user. Should be a minimum of 7 characters.")
    @NotNull(message = "Username cannot be null")
    private String username;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String address;
    private String county;
    @Size(min = 7, message = "Phone number should be a minimum of 7 characters.")
    @NotNull(message = "Phone number cannot be null")
    private String phone;
    @Email
    private String email;
    @Enumerated(EnumType.ORDINAL)
    private Status status;
}
