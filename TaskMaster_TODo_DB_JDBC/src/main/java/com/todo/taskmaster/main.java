package com.todo.taskmaster;

import com.todo.taskmaster.exceptions.*;
import com.todo.taskmaster.service.TaskService;
import com.todo.taskmaster.service.UserService;
import com.todo.taskmaster.taskresponses.userTasksDetailsResponse;
import com.todo.taskmaster.userinteractions.UserInteractions;
import com.todo.taskmaster.userresponses.getUserDetailsResponse;

import javax.naming.InvalidNameException;
import java.io.IOException;
import java.sql.SQLException;

public class main {
    public static void main(String[] args) throws SQLException, DBConnectionAfterRetryException, NullEmailPassed, NameInvalidException, InvalidNameException, InvalidPasswordException, InvalidEmailPassed, IOException {
        String url = "jdbc:mysql://localhost:3306/taskmaster_db";
        String username = "mammu";
        String password = "mammu";
        TaskService ts = new TaskService(url,username,password);


        userTasksDetailsResponse response = ts.getUserAllTasksDetails("mammuraj@gmail.com");

        System.out.println(response);
//        UserService service = new UserService(url,username,password);
//        getUserDetailsResponse  response =    service.getUserDetails("mammuraj@gmail.com");
//        System.out.println(response);
//
//        UserInteractions ui = new UserInteractions(url,username,password);
//        ui.helpUserRequests();


    }
}
