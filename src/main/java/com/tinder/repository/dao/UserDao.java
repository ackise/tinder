package com.tinder.repository.dao;

import com.tinder.repository.models.User;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UserDao {
    public User getUserById(int id) throws SQLException;
    public ArrayList<User> getUsersList() throws SQLException;
}
