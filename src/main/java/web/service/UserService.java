package web.service;

import web.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public void addUser(User user);
    public List<User> getUsers();
    public Optional<User> getById(long id);
    public void updateUser(User user);
    public void deleteUser(long id);
}
