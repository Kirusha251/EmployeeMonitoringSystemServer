package by.specificgroup.kirill.repository;

import by.specificgroup.kirill.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by user1 on 7/10/2017.
 */
public interface UserRepository extends JpaRepository<Users, Integer> {
    Users findByEmail(String email);
}
