package com.example.todolist;

import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "task_table")
public class Task {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String caption;
    private String description;
    private boolean isComplete;
    private int priority;

    public Task(String caption, String description, boolean isComplete, int priority) {
        this.caption = caption;
        this.description = description;
        this.isComplete = isComplete;
        this.priority = priority;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getCaption() {
        return caption;
    }

    public String getDescription() {
        return description;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public int getPriority() {
        return priority;
    }

}
