package com.dao;

import com.model.User;

import java.util.List;
import java.util.Properties;

public interface UserDao {
    List<User> getAllUsers();
    List<User> addUser(User newUser);
    Properties getCreds();
}
