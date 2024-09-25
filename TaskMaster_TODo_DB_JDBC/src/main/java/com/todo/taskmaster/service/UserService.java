package com.todo.taskmaster.service;

import com.todo.taskmaster.db.UserDBSource;
import com.todo.taskmaster.exceptions.DBConnectionAfterRetryException;
import com.todo.taskmaster.exceptions.InvalidEmailPassed;
import com.todo.taskmaster.model.User;
import com.todo.taskmaster.userrequests.userCreateRequest;
import com.todo.taskmaster.userresponses.createUserResponse;
import com.todo.taskmaster.userresponses.getUserDetailsResponse;

import javax.naming.InvalidNameException;
import java.sql.SQLException;


public class UserService {

    private final UserDBSource userdb;

    public UserService(String url, String dbUser, String password) throws SQLException,
            DBConnectionAfterRetryException {
        userdb = new UserDBSource(url, dbUser, password);
    }
    public createUserResponse saveUser(userCreateRequest request) throws SQLException {
        User user = userdb.addUser(request);

        // create StudentCreateResponse and return it
        createUserResponse userresponse = new createUserResponse();

        if(user != null) {
            userresponse.setId(user.getId());
            userresponse.setStatus("Success");
            userresponse.setMessage("Saved succesfully");


        } else {
            userresponse.setStatus("failed");
            userresponse.setMessage("somethig wrong from db");
        }

        return userresponse;
    }
public getUserDetailsResponse getUserDetails(String email) throws InvalidEmailPassed, SQLException {
        User user = userdb.getUserDetails(email);
        if(user == null){
 throw  new InvalidEmailPassed("Ivalid email passed . enter correct email");
        }

        getUserDetailsResponse response = new getUserDetailsResponse();
        response.setId(user.getId());
        response.setEmail(user.getEmail());
        response.setPassword(user.getPassword());
        response.setFullName(user.getFullName());
        response.setRegisteredOn(user.getRegisteredOn());
        return response;

}

}



