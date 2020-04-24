package ie.ait.drvproject.model.classes;

import ie.ait.drvproject.dao.User;
import ie.ait.drvproject.repository.*;
import ie.ait.drvproject.service.ItemService;
import ie.ait.drvproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Pelumi.Oyefeso on 12-04-2020
 */
@Component
public class Tester implements CommandLineRunner{
    @Autowired
    UserService userService;

    @Autowired
    ItemService itemService;

    @Override
    public void run(String... args) throws Exception {
        /*
        Cart cart = new Cart();
        cart.setPrice((double) 5000);
        //cart.setUser(userService.getAllUsers().get(0));
        //cartRepository.save(cart);
        CartItem cartItem = new CartItem();
        cartItem.setItem(itemRepository.findAll().get((3)));
        cartItem.setPrice(5000.00);
        cartItem.setQuantity(2);
        cartItem.setUser(userService.getAllUsers().get(0));
        //cartItemsRepository.save(cartItem);
        */

        List<User> allUsers = userService.getAllUsers();
        System.out.println();

    }
}
