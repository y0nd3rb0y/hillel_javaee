package com_test.repo;

import com_test.model.User;

import java.util.Arrays;
import java.util.List;

public class UserRepoImpl implements UserRepo {

    public List<User> getAllUsers() {
        return Arrays.asList(new User("x1", 13),
                new User("x2", 14),
                new User("x3", 13),
                new User("x4", 18),
                new User("x5", 13),
                new User("x6", 18),
                new User("x7", 23)
        );


    }
}
