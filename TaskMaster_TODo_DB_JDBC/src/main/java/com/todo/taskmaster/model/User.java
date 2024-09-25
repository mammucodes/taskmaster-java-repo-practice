package com.todo.taskmaster.model;

import java.time.LocalDate;

public class User {
    private  int id;
    private  String email;
    private String password;
    private String fullName;
    private LocalDate RegisteredOn;

    public User(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getRegisteredOn() {
        return RegisteredOn;
    }

    public void setRegisteredOn(LocalDate registeredOn) {
        RegisteredOn = registeredOn;
    }
}
