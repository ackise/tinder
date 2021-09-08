package com.tinder.repository.services;

import com.tinder.repository.dao.LikedDao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LikedService {
    LikedDao likedDao;

    public LikedService() {
        this.likedDao = new LikedDao();
    }

    public List<Integer> getUserLikedList(int id) {
        try {
            return likedDao.getUserLikedList(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return new ArrayList<>();
    }
}
