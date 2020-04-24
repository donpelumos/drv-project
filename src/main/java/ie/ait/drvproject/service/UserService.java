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
import java.util.Optional;

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

    public Optional<User> findUserById(Integer id){
        return userRepository.findById(id);
    }

    public User saveNewUser(User item){
        return userRepository.save(item);
    }

    public User updateUser(User item){
        return userRepository.save(item);
    }

    public int deleteUser(Integer id) {
        Optional<User> item = userRepository.findById(id);
        if(item.isPresent()){
            userRepository.delete(item.get());
            return 0;
        }
        else{
            return -1;
        }
    }
}
