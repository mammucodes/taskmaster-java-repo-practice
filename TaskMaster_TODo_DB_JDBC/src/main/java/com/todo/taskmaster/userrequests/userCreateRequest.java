package com.todo.taskmaster.userrequests;

public class userCreateRequest {
    private String  email;
    private String password;
    private  String fullname;
    public userCreateRequest(String email,String password, String fullName){
        this.email = email;
        this.password = password;
        this.fullname = fullName;

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

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}
