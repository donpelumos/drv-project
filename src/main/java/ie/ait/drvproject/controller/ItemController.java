package ie.ait.drvproject.controller;

import ie.ait.drvproject.dao.Item;
import ie.ait.drvproject.dao.User;
import ie.ait.drvproject.model.classes.CustomPageableResponse;
import ie.ait.drvproject.model.classes.ItemResponse;
import ie.ait.drvproject.repository.UserRepository;
import ie.ait.drvproject.service.ItemService;
import ie.ait.drvproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pelumi.Oyefeso on 13-04-2020
 */
@RestController
@RequestMapping("/items")
public class ItemController {
    @Autowired
    ItemService itemService;

    @Autowired
    UserService userService;

    @GetMapping("")
    public List<ItemResponse> getAllItems(){
        List<ItemResponse> itemResponses = new ArrayList<>();
        List<Item> items = itemService.getAllItems();
        for(Item item : items){
            ItemResponse itemResponse = new ItemResponse();
            itemResponse.setItemName(item.getItemName());
            itemResponse.setItemDescription(item.getDescription());
            itemResponses.add(itemResponse);
        }
        return itemResponses;
    }

    @GetMapping("all-items/search-phrase/{searchPhrase}")
    public CustomPageableResponse<Item, ItemResponse> searchItems(@PathVariable("searchPhrase") String searchPhrase, Pageable pageable){
        return itemService.searchItems(searchPhrase, pageable);
        //return userService.searchUsers(searchPhrase, pageable);
    }
}
