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
        String SQL = "SELECT id, name, avatar "
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

    @Override
    public User getUsersCredentials(String email,String password) throws SQLException {
        String SQL = "SELECT id, name ,email, password FROM users WHERE email = ? AND password = ?";
        PreparedStatement pstmt = database.prepareStatement(SQL);
        pstmt.setString(1,email);
        pstmt.setString(2,password);
        ResultSet rs = pstmt.executeQuery();
        User user = null;
        while(rs.next()) {
            user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("password"));
        }
        return user;
    }

}
