package ie.ait.drvproject.repository;

import ie.ait.drvproject.dao.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Set;

/**
 * Created by Pelumi.Oyefeso on 12-04-2020
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
}
