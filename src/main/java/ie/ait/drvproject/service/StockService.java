package ie.ait.drvproject.service;

import ie.ait.drvproject.dao.Stock;
import ie.ait.drvproject.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Pelumi.Oyefeso on 14-04-2020
 */
@Service
public class StockService {
    @Autowired
    StockRepository stockRepository;

    public List<Stock> getAllStocks(){
        return stockRepository.findAll();
    }

    public Optional<Stock> findStockByItemId(Integer itemId){
        return stockRepository.findByItemItemId(itemId);
    }

    public Optional<Stock> findStockById(Integer id){
        return stockRepository.findById(id);
    }

    public Stock saveNewStock(Stock stock){
        return stockRepository.save(stock);
    }

    public Stock updateStock(Stock stock){
        return stockRepository.save(stock);
    }

    public int deleteStock(Integer id) {
        Optional<Stock> stock = stockRepository.findById(id);
        if(stock.isPresent()){
            stockRepository.delete(stock.get());
            return 0;
        }
        else{
            return -1;
        }
    }
}
