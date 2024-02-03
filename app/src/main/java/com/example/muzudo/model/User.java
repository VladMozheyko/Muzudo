package com.example.muzudo.model;

public class User {
    private int id;
    private String name;
    private String location;
    private String phoneNumber;
    private String email;
    private String password;

    public User(String name, String location, String phoneNumber, String email, String password) {
        this.name = name;
        this.location = location;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
