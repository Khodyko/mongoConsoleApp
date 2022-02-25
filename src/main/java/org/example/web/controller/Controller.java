package org.example.web.controller;

import org.example.web.entity.SubTask;
import org.example.web.entity.Task;

import java.util.List;

/**
 * This class communicate with Dao
 */
public interface Controller {

    public List<Task> findAllTasks();

    public List<Task> findOverdueTasks();

    public Task insert(Task task);

    public List<Task> findTasksByPartOfName(String partOfName);

    public List<Task> findTasksByPartOfDescription(String partOfDescription);

    public List<Task> findAllTasksByDescription(String description);

    public Task findTaskByName(String name);

    public List<SubTask> findAllSubTasksByTaskName(String name);

    public Task save(Task task);

    public void deleteTaskByName(String name);

    public void addSubTask(String name, SubTask subTask);

    public void updateSubTasks(String name, List<SubTask> subTaskList);

    public void deleteSubTasks(String name);


}
