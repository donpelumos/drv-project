package ie.ait.drvproject.controller;

import ie.ait.drvproject.dao.Stock;
import ie.ait.drvproject.exception.StockNotFoundException;
import ie.ait.drvproject.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

/**
 * Created by Pelumi.Oyefeso on 14-04-2020
 */
@RestController
@RequestMapping("/api/stock")
public class StockController {
    
    @Autowired
    StockService stockService;

    @GetMapping(value = {"/", "/all"})
    public ResponseEntity<List<Stock>> getAllStocks(){
        return new ResponseEntity<>(stockService.getAllStocks(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Stock> getStock(@PathVariable("id") Integer id){
        Optional<Stock> stock = stockService.findStockById(id);
        if(stock.isPresent()){
            ResponseEntity<Stock> stockResponseEntity = new ResponseEntity<>(stock.get(), HttpStatus.OK);
            return stockResponseEntity;
        }
        else{
            throw new StockNotFoundException("Requested store item stock not found");
        }
    }


    @PostMapping("/")
    public ResponseEntity<Stock> createStock(@Valid @RequestBody Stock stock){
        Stock createdStock = stockService.saveNewStock(stock);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(createdStock.getStockId()).toUri();
        return ResponseEntity.created(location).build();
    }

    
    @PutMapping("{id}")
    public ResponseEntity<Stock> updateStock(@Valid @RequestBody Stock stockToUpdate, @PathVariable("id") Integer id){
        Optional<Stock> stock = stockService.findStockById(id);
        if(stock.isPresent()){
            stockToUpdate.setStockId(id);
            Stock updatedStock = stockService.updateStock(stockToUpdate);
            ResponseEntity<Stock> carResponseEntity = new ResponseEntity<>(updatedStock, HttpStatus.OK);
            return carResponseEntity;
        }
        else{
            throw new StockNotFoundException("Requested car not found");
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Stock> deleteStock(@PathVariable("id") Integer id){
        int stockDeleted = stockService.deleteStock(id);
        if(stockDeleted == 0){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        else{
            throw new StockNotFoundException("Car with specified id does not exist");
        }
    }
}
