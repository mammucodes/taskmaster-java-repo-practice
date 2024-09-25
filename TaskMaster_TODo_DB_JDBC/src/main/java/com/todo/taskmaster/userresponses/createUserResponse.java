package com.todo.taskmaster.userresponses;

import java.time.LocalDate;

public class createUserResponse {

   int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    String status;
    String message;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "createUserResponse{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
