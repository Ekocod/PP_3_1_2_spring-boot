package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);

    List<User> getAllUsers();

    void deleteUser(int id);

    void updateUser(User user, int id);

    User getUser(int id);
}