package ru.kata.spring.boot_security.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.dao.UserDao;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService{
    private final UserDao userDao;

    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void add(User user) {
        userDao.add(user);
    }
    @Override
    @Transactional
    public void delete(Long id) {
        userDao.delete(id);
    }
    @Override
    @Transactional
    public User update(User user) {
        return userDao.update(user);
    }
    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }
}