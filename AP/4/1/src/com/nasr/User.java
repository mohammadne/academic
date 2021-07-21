package com.nasr;

public class User {
    final String name;
    private String date;

    public User(String name) {
        this.name = name;
    }

    String getDate() {
        return this.date;
    }

    void setDate(String date) {
        this.date = date;
    }
}
