package ru.gordanov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.gordanov.dao.UserDao;
import ru.gordanov.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserDao userDao;

    public UserServiceImpl(BCryptPasswordEncoder bCryptPasswordEncoder, UserDao userDao) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userDao = userDao;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void update(User user) {
        User userDB = userDao.getUserById(user.getId());
        if (!bCryptPasswordEncoder.matches(userDB.getPassword(), bCryptPasswordEncoder.encode(user.getPassword()))) {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        }
        userDao.update(user);
    }

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDao.save(user);
    }

    @Override
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }

    @Override
    public void delete(long id) {
        userDao.delete(id);
    }

    @Override
    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }
}
