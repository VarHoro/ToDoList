package com.example.todolist;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class TaskViewModel extends AndroidViewModel {
    private TaskRepository repository;
    private LiveData<List<Task>> allTasks;

    public TaskViewModel(@NonNull Application application) {
        super(application);
        repository = new TaskRepository(application);
        allTasks = repository.getAllTasks();
    }

    public void insert(Task task){
        repository.insert(task);
    }

    public void update(Task task){
        repository.update(task);
    }

    public void delete(Task task){
        repository.delete(task);
    }

    public void deleteAllTasks(){
        repository.deleteAllTasks();
    }

    public LiveData<List<Task>> getAllTasks() {
        return allTasks;
    }
}
