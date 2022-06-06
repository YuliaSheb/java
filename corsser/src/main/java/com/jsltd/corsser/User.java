package com.jsltd.corsser;

public class User {
    private String firstname;
    private String username;
    private String password;
    private String role;

    public User(String firstname, String username, String password, String role) {
        this.firstname = firstname;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User() {

    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
