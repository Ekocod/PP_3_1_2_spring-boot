package com.slambek.springboot.dao;

import com.slambek.springboot.model.User;

import java.util.List;

public interface UserDao {

    void saveUser(User user);

    List<User> getAllUsers();

    void deleteUser(int id);

    void updateUser(User user, int id);

    User getUser(int id);
}