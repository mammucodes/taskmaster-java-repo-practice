package com.todo.taskmaster.db;

import com.todo.taskmaster.exceptions.DBConnectionAfterRetryException;
import com.todo.taskmaster.model.Task;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TaskDBSource {

    private final String url;
    private String dbUser;
    private String password;
    private Connection con = null;

    PreparedStatement getUserTasksDetailsPrepStatement;


    public TaskDBSource(String url, String dbUser, String password) throws DBConnectionAfterRetryException, SQLException {
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
        getUserTasksDetailsPrepStatement = con.prepareStatement(ToDoAppQueries.getUserAllTasksDetails);

    }

    public List<Task> getUserAllTasks(String email) throws SQLException {
        //  LocalDate currentDate = LocalDate.now();
        getUserTasksDetailsPrepStatement.setString(1, email);
        ResultSet rs = getUserTasksDetailsPrepStatement.executeQuery();
        List<Task> tasks = new ArrayList<>();

        while (rs.next()) {
            int task_id = rs.getInt("task_id");
            int user_id = rs.getInt("user_id");
            String title = rs.getString("title");
            String description = rs.getString("descriptions");
            String category = rs.getString("category");
            String priority = rs.getString("priority_id");
            LocalDateTime due_date = rs.getTimestamp("due_date").toLocalDateTime();
            String status = rs.getString("status_id");
            LocalDateTime createdOn = rs.getTimestamp("created_date").toLocalDateTime();
            LocalDateTime updatedOn = rs.getTimestamp("updated_on").toLocalDateTime();
            int reaminderInMinutes = rs.getInt("reminder");
            Task task = new Task();
            task.setTask_id(task_id);
            task.setUser_id(user_id);
            task.setTitle(title);
            task.setDescription(description);
            task.setCategory(category);
            task.setPriority(priority);
            task.setDueDateTime(due_date);
            task.setStatus(status);
            task.setCreatedOn(createdOn);
            task.setUpdatedOn(updatedOn);
            task.setReaminderInMintues(reaminderInMinutes);
            tasks.add(task);
        }

        return tasks;
    }

}
