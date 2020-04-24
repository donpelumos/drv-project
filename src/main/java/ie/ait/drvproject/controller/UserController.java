package ie.ait.drvproject.controller;

import ie.ait.drvproject.dao.User;
import ie.ait.drvproject.exception.UserNotFoundException;
import ie.ait.drvproject.service.UserService;
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
 * Created by Pelumi.Oyefeso on 24-04-2020
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = {"", "/all"})
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Integer id){
        Optional<User> review = userService.findUserById(id);
        if(review.isPresent()){
            ResponseEntity<User> reviewResponseEntity = new ResponseEntity<>(review.get(), HttpStatus.OK);
            return reviewResponseEntity;
        }
        else{
            throw new UserNotFoundException("Requested store review not found");
        }
    }

    @PostMapping("")
    public ResponseEntity<User> createUser(@Valid @RequestBody User review){
        User createdUser = userService.saveNewUser(review);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(createdUser.getUserId()).toUri();
        return ResponseEntity.created(location).body(createdUser);
    }

    @PutMapping(value = {"", "{id}"})
    public ResponseEntity<User> updateUser(@Valid @RequestBody User reviewToUpdate, @PathVariable(value = "id", required = false) Integer id){
        id = (id == null) ? reviewToUpdate.getUserId() : id;
        Optional<User> review = userService.findUserById(id);
        if(review.isPresent()){
            reviewToUpdate.setUserId(id);
            User updatedUser = userService.updateUser(reviewToUpdate);
            ResponseEntity<User> reviewResponseEntity = new ResponseEntity<>(updatedUser, HttpStatus.OK);
            return reviewResponseEntity;
        }
        else{
            throw new UserNotFoundException("Requested review not found");
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") Integer id){
        int reviewDeleted = userService.deleteUser(id);
        if(reviewDeleted == 0){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        else{
            throw new UserNotFoundException("User with specified id does not exist");
        }
    }
}
