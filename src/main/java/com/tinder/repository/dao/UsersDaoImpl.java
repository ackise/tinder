package com.tinder.repository.dao;

import com.tinder.repository.DataBase;
import com.tinder.repository.models.User;

import java.sql.*;
import java.util.ArrayList;

public class UsersDaoImpl implements UserDao {
    Connection database;

    public UsersDaoImpl() {
        this.database = new DataBase().connect();
    }

    @Override
    public User getUserById(int id) throws SQLException {
        String SQL = "SELECT id,name,avatar "
                + "FROM users "
                + "WHERE id = ?";
        PreparedStatement pstmt = database.prepareStatement(SQL);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        rs.next();
        return new User(rs.getInt("id"), rs.getString("name"), rs.getString("avatar"));
    }

    @Override
    public ArrayList<User> getUsersList() throws SQLException {
        String SQL = "SELECT id, name, avatar FROM users";
        Statement stmt = database.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);

        ArrayList<User> usersList = new ArrayList<>();
        while (rs.next()) {
            usersList.add(new User(rs.getInt("id"), rs.getString("name"), rs.getString("avatar")));
        }
        return usersList;
    }

}
