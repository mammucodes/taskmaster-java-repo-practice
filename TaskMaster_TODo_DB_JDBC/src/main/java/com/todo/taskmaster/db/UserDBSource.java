package com.todo.taskmaster.db;

import com.todo.taskmaster.exceptions.DBConnectionAfterRetryException;
import com.todo.taskmaster.model.User;
import com.todo.taskmaster.userrequests.userCreateRequest;

import java.sql.*;
import java.time.LocalDate;

public class UserDBSource {
    private final String url;
    private String dbUser;
    private String password;
    private Connection con = null;

    PreparedStatement insertPrepStatement;
    PreparedStatement getUserDetailsPrepStatement;





    public  UserDBSource(String url, String dbUser, String password) throws DBConnectionAfterRetryException, SQLException {
        this.url = url;
        this.dbUser = dbUser;
        this.password = password;

        int retryCount = 0;
        while (retryCount < 3) {
            try {
                retryCount++;
                con = DriverManager.getConnection(url, dbUser, password); //if this is success it goes to next line and break from the loop
                break;
            } catch (SQLException ex) {
                System.out.println("somehting happended " + ex.getMessage());
            }
        }

        if (con == null) {
            throw new DBConnectionAfterRetryException("DB CConnection error even after " + retryCount + " tries");
        }

        insertPrepStatement = con.prepareStatement(ToDoAppQueries.insertUser, PreparedStatement.RETURN_GENERATED_KEYS);
        getUserDetailsPrepStatement = con.prepareStatement(ToDoAppQueries.getUserDatails);
    }

    public User addUser(userCreateRequest userRequest) throws SQLException {
        LocalDate currentDate = LocalDate.now();;

        insertPrepStatement.setString(1, userRequest.getEmail());
        insertPrepStatement.setString(2, userRequest.getPassword());
        insertPrepStatement.setString(3, userRequest.getFullname());
        insertPrepStatement.setDate(4, Date.valueOf(currentDate));
        int returnValue = insertPrepStatement.executeUpdate();
        //it  returns the generated id values from DB  in the form of ResultSet
        ResultSet rs = insertPrepStatement.getGeneratedKeys();
        User user = null;
        if (returnValue == 1) {
            if (rs.next()) {
                int userId = rs.getInt(1);
                // String name = rs.getString(2);
                user = new User();

                user.setId(userId);

                //  student.setName(name);
                user.setEmail(userRequest.getEmail());
                user.setPassword(userRequest.getPassword());
                user.setFullName(userRequest.getEmail());
                user.setRegisteredOn(currentDate);


            }

        }
        return user;
    }

     public User getUserDetails(String  email) throws SQLException {
 getUserDetailsPrepStatement.setString(1,email);
   ResultSet rs = getUserDetailsPrepStatement.executeQuery();
   User user= null ;
   if(rs.next()){
       int userId = rs.getInt("id");
       String userEMAIL = rs.getString("email");
       String password = rs.getString("password");
       String fullName = rs.getString("full_name");
       LocalDate  registeredOn = rs.getDate("registered_on").toLocalDate();
      user = new  User();
      user.setId(userId);
      user.setEmail(userEMAIL);
      user.setPassword(password);
      user.setFullName(fullName);
      user.setRegisteredOn(registeredOn);
   }

return user;
     }

}