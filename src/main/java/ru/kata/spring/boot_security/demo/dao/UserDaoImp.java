package ru.kata.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.User;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao{
    @PersistenceContext
    private EntityManager manager;

    @Override
    public void add(User user) {
        manager.persist(user);
    }
    @Override
    public void delete(Long id) {
        User user = manager.find(User.class, id);
        manager.remove(user);
    }
    @Override
    public User update(User user) {
         return manager.merge(user);
    }
    @Override
    public List<User> getAllUsers() {
        return manager.createQuery("from User", User.class).getResultList();
    }
    @Override
    public User getUserById(Long id) {
        return manager.find(User.class, id);
    }
}