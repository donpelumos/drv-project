package ie.ait.drvproject.controller;

import ie.ait.drvproject.dao.Item;
import ie.ait.drvproject.dao.Stock;
import ie.ait.drvproject.dao.User;
import ie.ait.drvproject.exception.ItemNotFoundException;
import ie.ait.drvproject.exception.StockNotFoundException;
import ie.ait.drvproject.model.classes.CustomPageableResponse;
import ie.ait.drvproject.model.classes.ItemResponse;
import ie.ait.drvproject.repository.UserRepository;
import ie.ait.drvproject.service.ItemService;
import ie.ait.drvproject.service.StockService;
import ie.ait.drvproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Pelumi.Oyefeso on 13-04-2020
 */
@RestController
@RequestMapping("/api/item")
public class ItemController {

    @Autowired
    ItemService itemService;

    @Autowired
    StockService stockService;

    @GetMapping(value = {"/", "/all"})
    public ResponseEntity<List<Item>> getAllItems(){
        return new ResponseEntity<>(itemService.getAllItems(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Item> getItem(@PathVariable("id") Integer id){
        Optional<Item> item = itemService.findItemById(id);
        if(item.isPresent()){
            ResponseEntity<Item> itemResponseEntity = new ResponseEntity<>(item.get(), HttpStatus.OK);
            return itemResponseEntity;
        }
        else{
            throw new ItemNotFoundException("Requested store item not found");
        }
    }

    @GetMapping("{id}/stock")
    public ResponseEntity<Stock> getItemStock(@PathVariable("id") Integer id){
        Optional<Stock> stock = stockService.findStockByItemId(id);
        if(stock.isPresent()){
            ResponseEntity<Stock> stockResponseEntity = new ResponseEntity<>(stock.get(), HttpStatus.OK);
            return stockResponseEntity;
        }
        else{
            throw new StockNotFoundException("No stock information found for requested store item");
        }
    }

    @PostMapping("/")
    public ResponseEntity<Item> createItem(@Valid @RequestBody Item item){
        Item createdItem = itemService.saveNewItem(item);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(createdItem.getItemId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("search-query/{searchQuery}")
    public CustomPageableResponse<Item, ItemResponse> searchItems(@PathVariable("searchQuery") String searchPhrase, Pageable pageable){
        return itemService.searchItems(searchPhrase, pageable);
    }

    @PutMapping("{id}")
    public ResponseEntity<Item> updateItem(@Valid @RequestBody Item itemToUpdate, @PathVariable("id") Integer id){
        Optional<Item> item = itemService.findItemById(id);
        if(item.isPresent()){
            itemToUpdate.setItemId(id);
            Item updatedItem = itemService.updateItem(itemToUpdate);
            ResponseEntity<Item> itemResponseEntity = new ResponseEntity<>(updatedItem, HttpStatus.OK);
            return itemResponseEntity;
        }
        else{
            throw new ItemNotFoundException("Requested item not found");
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Item> deleteItem(@PathVariable("id") Integer id){
        int itemDeleted = itemService.deleteItem(id);
        if(itemDeleted == 0){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        else{
            throw new ItemNotFoundException("Item with specified id does not exist");
        }
    }
}
