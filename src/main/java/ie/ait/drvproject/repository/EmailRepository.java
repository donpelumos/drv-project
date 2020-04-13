package ie.ait.drvproject.repository;

import ie.ait.drvproject.dao.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Pelumi.Oyefeso on 13-04-2020
 */
@Repository
public interface EmailRepository extends JpaRepository<Email, Integer> {
}
