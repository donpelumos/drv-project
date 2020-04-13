package ie.ait.drvproject.repository;

import ie.ait.drvproject.dao.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Pelumi.Oyefeso on 12-04-2020
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    Page<Item> findAllByItemNameOrItemNameContains(String itemName, String itemPartName, Pageable pageable);

    Page<Item> findAllByDescriptionOrDescriptionContains(String description, String partDescription, Pageable pageable);
}
