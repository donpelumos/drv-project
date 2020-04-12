package ie.ait.drvproject.repository;

import ie.ait.drvproject.dao.ReviewItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Pelumi.Oyefeso on 12-04-2020
 */
@Repository
public interface ReviewItemRepository extends JpaRepository<ReviewItem, Integer> {
}
