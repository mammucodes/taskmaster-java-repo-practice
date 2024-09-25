package com.todo.taskmaster.db;

public class ToDoAppQueries {


    //    updateuserpassword(string email,int token, string newpassword);
//    updateuserfullname(string email,int token, string newfullname);
//    createtask(taskinputrequest,request,int token);
//    gettaskdetails(int taskid, int token);
//    updatetask(int taskid, taskrequest, request, String title);
//    deletetask(int taskid);
//    getallusertasks(int userid, int token)
    public static final String insertUser = "insert into users(email,password,full_name, registered_on) values(?,?,?, ?)";
    public static  final String getUserDatails  = " select  id,email, password, full_name, registered_on  from users where email=?";
    public static final String updateUserPassword = "UPDATE users SET password=? WHERE email=?";
    public static final String updateUserFullName = "update users set full_name = ? where email=?";

    public static final String insertTask =
            "insert into tasks( title, descriptions, category, priority_id, due_date, status_id, reminder, updated_on) " +
                    "values(?,?,?, ?,?,?,?, ?)";
    public static final String getTaskDetails = "select *  from  tasks where task_id= ?";
    public static final  String updateTaskTitle = "update tasks set title =? where task_id =?";
    public static final String deleteTask = "delete from tasks where task_id = ?";

    public static final String  deleteUser = "delete from users where email = ?";
    public static final String getAllUserTasks =" select * from users where id= ?";

    public static final String getUserAllTasksDetails = "SELECT t.task_id, t.user_id, t.title, t.descriptions, t.category, t.priority_id, " +
            "t.due_date, \n" +
            " t.status_id, t.created_date, t.updated_on, t.reminder\n" +
            "FROM tasks t \n" +
            "JOIN users u ON t.user_id = u.id\n" +
            "WHERE u.email = ?";
}