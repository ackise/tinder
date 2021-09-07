package com.tinder.repository.dao;

import com.tinder.repository.DataBase;
import com.tinder.repository.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LikedDao {
    Connection database;

    public LikedDao() {
        this.database = new DataBase().connect();
    }

    public List<Integer> getUserLikedList(int id) throws SQLException {
        String SQL = "SELECT l.liked_user_id "
                + "FROM liked l "
                + "WHERE user_id = ?";
        PreparedStatement pstmt = database.prepareStatement(SQL);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();

        ArrayList<Integer> likedUsers = new ArrayList<>();

        while (rs.next()) {
            likedUsers.add(rs.getInt(1));
        }

        return likedUsers;
    }
}
