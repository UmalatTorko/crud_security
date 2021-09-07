package ru.gordanov.dao;

import ru.gordanov.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    void saveOrUpdate(User user);

    User getUserById(long id);

    void delete(long id);

    User getUserByUsername(String username);
}
