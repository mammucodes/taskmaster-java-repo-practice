package com.todo.taskmaster.taskresponses;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import  com.todo.taskmaster.model.Task;

public class userTasksDetailsResponse {
    private int userId;
    List<Task> tasks;

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "userTasksDetailsResponse{" +
                "userId=" + userId +
                ", tasks=" + tasks +
                '}';
    }
}
