package com.todo.taskmaster.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Task {

//    "userId": 101,
//            "title": "Complete Assignment",
//            "description": "Finish the math assignment due tomorrow.",
//            "category": "Education",
//            "priority": "High",
//            "dueDate": "2024-09-20",
//            "status": "Pending"
//            "reaminderInMintues":100

    private  int task_id;
    private int user_id;
    private String title;
    private String  description;
    private String category;
    private String priority;
    private LocalDateTime dueDateTime;
    private LocalDateTime createdOn;

    private LocalDateTime updatedOn;

    private String status;
    private int reaminderInMintues;

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public LocalDateTime getDueDateTime() {
        return dueDateTime;
    }

    public void setDueDateTime(LocalDateTime dueDateTime) {
        this.dueDateTime = dueDateTime;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getReaminderInMintues() {
        return reaminderInMintues;
    }

    public void setReaminderInMintues(int reaminderInMintues) {
        this.reaminderInMintues = reaminderInMintues;
    }

    @Override
    public String toString() {
        return "Task{" +
                "task_id=" + task_id +
                ", user_id=" + user_id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", priority='" + priority + '\'' +
                ", dueDateTime=" + dueDateTime +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                ", status='" + status + '\'' +
                ", reaminderInMintues=" + reaminderInMintues +
                '}';
    }
}


