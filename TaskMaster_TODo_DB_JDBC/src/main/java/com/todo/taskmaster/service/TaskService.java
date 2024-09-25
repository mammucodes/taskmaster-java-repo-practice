package com.todo.taskmaster.service;

import com.todo.taskmaster.db.TaskDBSource;
import com.todo.taskmaster.db.UserDBSource;
import com.todo.taskmaster.exceptions.DBConnectionAfterRetryException;
import com.todo.taskmaster.model.Task;
import com.todo.taskmaster.taskresponses.userTasksDetailsResponse;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaskService {
    private final TaskDBSource taskdb;

    public TaskService(String url, String dbUser, String password) throws SQLException,
            DBConnectionAfterRetryException {
        taskdb = new TaskDBSource(url, dbUser, password);
    }

    public userTasksDetailsResponse getUserAllTasksDetails(String email) throws SQLException {
        List<Task> tasks = taskdb.getUserAllTasks(email);
        userTasksDetailsResponse response = null;

        if (tasks != null && tasks.size() > 0) {
         response =    new userTasksDetailsResponse();
            int userId = tasks.get(0).getUser_id();
            response.setUserId(userId);
            response.setTasks(tasks);
            return response;
        } else {
         return response;


        }


    }

}
