package com.tinder.repository.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tinder.repository.dao.UserDao;
import com.tinder.repository.dao.UsersDaoImpl;
import com.tinder.repository.models.User;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserService {
    UserDao userDao;

    public UserService() {
        userDao = new UsersDaoImpl();
    }

    public User getUserById(int id) throws SQLException, JsonProcessingException {
        return userDao.getUserById(id);
    }

    public ArrayList<User> getUsersList() throws SQLException, JsonProcessingException {
        return userDao.getUsersList();
    }
    public User getUsersCredentials(String name, String password) throws SQLException, JsonProcessingException {
        return userDao.getUsersCredentials(name,password);
    }
}
