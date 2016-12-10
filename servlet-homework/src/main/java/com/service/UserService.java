package com.service;

import com.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    List<User> addUser(User newUser);
    boolean isUserAuthenticated(String name, String passwd);
}
