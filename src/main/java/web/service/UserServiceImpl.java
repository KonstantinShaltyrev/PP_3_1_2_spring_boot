package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import web.dao.UserDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUser(User user) {
        userDao.save(user);
    }

    @Override
    public List<User> getUsers() {
        List<User> list = new ArrayList<>();
        userDao.findAll().forEach(list::add);
        return list;
    }

    @Override
    public Optional<User> getById(long id) {
        return userDao.findById(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.save(user);
    }

    @Override
    public void deleteUser(long id) {
        userDao.deleteById(id);
    }
}
