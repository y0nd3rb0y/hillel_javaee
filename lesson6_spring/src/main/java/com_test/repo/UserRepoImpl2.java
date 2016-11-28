package com_test.repo;

import com_test.model.User;

import java.util.Arrays;
import java.util.List;

public class UserRepoImpl2 implements UserRepo {

    public List<User> getAllUsers() {
        return Arrays.asList(new User("x1", 13),
                new User("x8", 12),
                new User("x9", 13),
                new User("x10", 18),
                new User("x11", 11),
                new User("x12", 12),
                new User("x14", 24)
        );


    }
}
