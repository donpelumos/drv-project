package ie.ait.drvproject.service;

import ie.ait.drvproject.dao.Item;
import ie.ait.drvproject.dao.User;
import ie.ait.drvproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Pelumi.Oyefeso on 12-04-2020
 */
@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Page<User> searchUsers(String searchPhrase, Pageable pageable){
        if(searchPhrase.trim().isEmpty()){
            Page<User> foundUsersPage = userRepository.findAll(pageable);
            return foundUsersPage;
        }
        Page<User> foundUsersPage = userRepository.findAllByUsernameOrUsernameContains(searchPhrase.toLowerCase(),
                searchPhrase.toLowerCase(), pageable);
        return foundUsersPage;
    }
}
