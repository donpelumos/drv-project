package ie.ait.drvproject.repository;

import ie.ait.drvproject.dao.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Pelumi.Oyefeso on 13-04-2020
 */
@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
}
