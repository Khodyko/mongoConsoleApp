package org.example.web.dao;

import org.example.web.entity.SubTask;
import org.example.web.entity.Task;

import java.util.List;

public interface TaskDao {
    public List<Task> findAll();
    public Task  insert(Task task);
    public List<Task> findTasksByPartOfName(String partOfName);
    public List<Task> findTasksByPartOfDescription(String partOfDescription);
    public List<Task> findAllTasksByDescription(String description);
    public Task findAllByName(String name);
    public List<SubTask> findAllSubTasksByTaskName(String name);
    public Task save(Task task);
    public void delete(Task task);
    public void addSubTask(String name, SubTask subTask);
    public void updateSubTasks(String name, List<SubTask> subTaskList);
    public void deleteSubTasks(String name);
}
