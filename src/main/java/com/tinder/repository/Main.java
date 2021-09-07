package com.tinder.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tinder.repository.services.UserService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, JsonProcessingException {
        new JettyServer().start();
    }
}
