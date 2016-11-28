package com_test.service;

import com_test.model.User;
import com_test.repo.UserRepo;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserRepo userRepo;
    public UserServiceImpl() {}

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public UserRepo getUserRepo() {
        return userRepo;
    }

    public void setUserRepo(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getAllUsers() {
        return userRepo.getAllUsers();
    }
}
