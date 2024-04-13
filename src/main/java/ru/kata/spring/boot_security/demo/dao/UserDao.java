package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.model.User;
import java.util.List;

public interface UserDao {
    void add(User user);
    void delete(Long id);
    User update(User user);
    List<User> getAllUsers();
    User getUserById(Long id);
}
