package ru.gordanov.service;

import ru.gordanov.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void save(User user);

    void update(User user);

    User getUserById(long id);

    void delete(long id);

    User getUserByUsername(String username);
}
