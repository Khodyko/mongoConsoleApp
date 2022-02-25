package org.example.web.controller;

import org.example.web.dao.TaskDao;
import org.example.web.entity.SubTask;
import org.example.web.entity.Task;
import org.springframework.stereotype.Component;

import java.util.List;


public interface Controller {

    public List<Task> findAllTasks();
    public Task  insert(Task task);
    public List<Task> findTasksByPartOfName(String partOfName);
    public List<Task> findTasksByPartOfDescription(String partOfDescription);
    public List<Task> findAllTasksByDescription(String description);
    public Task findTaskByName(String name);
    public List<SubTask> findAllSubTasksByTaskName(String name);
    public Task save(Task task);
    public void delete(Task task);
    public void addSubTask(String name, SubTask subTask);
    public void updateSubTasks(String name, List<SubTask> subTaskList);
    public void deleteSubTasks(String name);



}
