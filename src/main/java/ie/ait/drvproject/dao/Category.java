package ie.ait.drvproject.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Pelumi.Oyefeso on 12-04-2020
 */

@Entity
@Table(name = "CATEGORY")
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATEGORYID")
    private Integer categoryId;
    @Column(name = "CATEGORYNAME")
    private String categoryName;
    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    List<Item> items;
}
