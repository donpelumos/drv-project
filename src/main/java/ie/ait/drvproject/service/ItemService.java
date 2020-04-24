package ie.ait.drvproject.service;

import ie.ait.drvproject.dao.Item;
import ie.ait.drvproject.model.classes.CustomPageableResponse;
import ie.ait.drvproject.model.classes.ItemResponse;
import ie.ait.drvproject.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Pelumi.Oyefeso on 13-04-2020
 */
@Service
public class ItemService {
    @Autowired
    ItemRepository itemRepository;

    public List<Item> getAllItems(){
        return itemRepository.findAll();
    }

    public Optional<Item> findItemById(Integer id){
        return itemRepository.findById(id);
    }

    public Item saveNewItem(Item item){
        return itemRepository.save(item);
    }

    public Item updateItem(Item item){
        return itemRepository.save(item);
    }

    public CustomPageableResponse<Item, ItemResponse> searchItems(String searchPhrase, Pageable pageable){
        if(searchPhrase.trim().isEmpty()){
            Page<Item> foundItemsPage = itemRepository.findAll(pageable);
            List<Item> items = foundItemsPage.getContent();
            List<ItemResponse> itemResponses = items.stream().map((item -> mapItemToItemResponse(item))).collect(Collectors.toList());
            return new CustomPageableResponse<>(foundItemsPage, itemResponses);
        }
        Page<Item> foundItemsPage = null;
        if(pageable.getSort().toString().toLowerCase().contains("description")){
            foundItemsPage = itemRepository.findAllByItemDescriptionOrItemDescriptionContains(searchPhrase.toLowerCase(),
                    searchPhrase.toLowerCase(), pageable);
        }
        else{
            foundItemsPage = itemRepository.findAllByItemNameOrItemNameContains(searchPhrase.toLowerCase(),
                    searchPhrase.toLowerCase(), pageable);
        }
        List<Item> items = foundItemsPage.getContent();
        List<ItemResponse> itemResponses = items.stream().map((item -> mapItemToItemResponse(item))).collect(Collectors.toList());
        return new CustomPageableResponse<>(foundItemsPage, itemResponses);
    }

    private ItemResponse mapItemToItemResponse(Item item){
        ItemResponse itemResponse = new ItemResponse();
        itemResponse.setItemId(item.getItemId());
        itemResponse.setItemDescription(item.getItemDescription());
        itemResponse.setItemName(item.getItemName());
        itemResponse.setItemPrice(item.getItemPrice());
        return itemResponse;
    }

    public int deleteItem(Integer id) {
        Optional<Item> item = itemRepository.findById(id);
        if(item.isPresent()){
            itemRepository.delete(item.get());
            return 0;
        }
        else{
            return -1;
        }
    }

}
