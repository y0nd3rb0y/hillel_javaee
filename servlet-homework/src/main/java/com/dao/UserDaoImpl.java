package com.dao;

import com.model.User;
import org.springframework.stereotype.Repository;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

@Repository("userDao")
public class UserDaoImpl implements UserDao{
    private List<User> users = new ArrayList<User>(Arrays.asList(
            new User("name1", 12),
            new User("name2", 23),
            new User("name3", 32)));

    private String credsFilename = "src/creds.properties";
    private Properties creds = new Properties();
    private FileInputStream fileInputStream = null;

    public UserDaoImpl() {
        try {
            fileInputStream = new FileInputStream(credsFilename);
            creds.load(fileInputStream);

        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        System.out.println("--- userDao ::: constructor");
    }

    public List<User> getAllUsers() {
        return users;
    }

    public List<User> addUser(User newUser) {
        users.add(newUser);
        return users;
    }

    public Properties getCreds() {
        return creds;
    }
}
