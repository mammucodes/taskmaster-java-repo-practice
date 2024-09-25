package com.todo.taskmaster.userinteractions;

import com.todo.taskmaster.conntroller.UserValidations;
import com.todo.taskmaster.exceptions.*;
import com.todo.taskmaster.service.UserService;
import com.todo.taskmaster.userrequests.userCreateRequest;
import com.todo.taskmaster.userresponses.createUserResponse;

import javax.naming.InvalidNameException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class UserInteractions {

    Scanner sc = new Scanner(System.in);
    public UserValidations validations = new UserValidations();
    private UserService service;

    public UserInteractions(String url, String user, String password) throws DBConnectionAfterRetryException, SQLException {

        service = new UserService(url, user, password);

    }

    public UserInteractions() {
    }


    public void helpUserRequests() {

        System.out.println("please select the below option ");
        System.out.println("1 to create user data data\n 2 to login user \n "
                + "3 updateUserPassword\n" + " 4  updateUserFullName\n"
                + "5 createTask\n" + "6 getTaskDetails   \n" + "8 updateTask\n" + "9 deleteTask\n" + " 9 getAllUserTasks");
        int option = sc.nextInt();
        sc.nextLine();
        switch (option) {
            case 1:
createUserResponse suserresponse =  createUserData();
                System.out.println(suserresponse);
                break;

        }

    }


    private createUserResponse createUserData() {

        System.out.println("enter user email");
        String email = sc.nextLine();
        System.out.println("enter user password");
        String password = sc.nextLine();
        System.out.println("enter user fullName");
        String fullName = sc.nextLine();

        userCreateRequest userrequest = new userCreateRequest(email, password, fullName);

        createUserResponse response = new createUserResponse();




            try {
                validations.validateCreateUserRequest(userrequest);
            } catch (InvalidEmailPassed e) {
                response.setStatus("failed");
                response.setMessage("Invalid email passed " + email);
                return response;
            } catch (NameInvalidException e) {
                response.setStatus("failed");
                response.setMessage("Null  or less  than 5 charcters  Name  passed " + fullName);
            } catch (InvalidPasswordException e) {
                response.setStatus("failed");
                response.setMessage("Invalid or length less than 5 charcter PasswordException" + password);
                return response;
            } catch (NullEmailPassed e) {
                response.setStatus("failed");
                response.setMessage("Null Email Passed Exception" + email);
                return response;
            }
//it will come to this line if no errors and calls save user() to save user data
            try {
                response =  service.saveUser(userrequest);
            } catch (SQLException e) {
                response.setStatus("failed");
                response.setMessage("DataBase Exception");
                return response;
            }

            response.setStatus("success");
            response.setMessage("User Created Successfully");
            return response;
        }
    }
