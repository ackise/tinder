package com.tinder.repository.models;

public class User {
    private int id;
    private String name;
    private String avatar;

    public User(int id, String name, String avatar) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
    }
}
