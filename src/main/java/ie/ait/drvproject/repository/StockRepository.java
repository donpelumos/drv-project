package ie.ait.drvproject.repository;

import ie.ait.drvproject.dao.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Pelumi.Oyefeso on 12-04-2020
 */
@Repository
public interface StockRepository extends JpaRepository<Stock, Integer>{
}