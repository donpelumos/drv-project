package ie.ait.drvproject.repository;

import ie.ait.drvproject.dao.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by Pelumi.Oyefeso on 13-04-2020
 */
@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {
    Optional<Stock> findByItemItemId(Integer itemId);
}
