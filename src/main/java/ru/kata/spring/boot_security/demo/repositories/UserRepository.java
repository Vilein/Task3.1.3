package ru.kata.spring.boot_security.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUserName(String username);
    User save(User user);
    void deleteById(Long id);
    //User saveOrUpdateByUsername(User user);
    List<User> findAll();
    User getUserById(Long id);
}
