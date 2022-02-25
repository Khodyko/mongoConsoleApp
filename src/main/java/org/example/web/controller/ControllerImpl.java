package org.example.web.controller;

import org.example.web.dao.TaskDao;
import org.example.web.dao.impl.TaskDaoImpl;
import org.example.web.entity.SubTask;
import org.example.web.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ControllerImpl implements Controller {
    TaskDao taskDaoImpl;

    @Autowired
    public ControllerImpl(TaskDao taskDaoImpl) {
        this.taskDaoImpl = taskDaoImpl;
    }

    public List<Task> findAllTasks() {
        return taskDaoImpl.findAllTasks();
    }

    @Override
    public Task insert(Task task) {
        return taskDaoImpl.insert(task);
    }

    @Override
    public List<Task> findTasksByPartOfName(String partOfName) {
        return taskDaoImpl.findTasksByPartOfName(partOfName);
    }

    @Override
    public List<Task> findTasksByPartOfDescription(String partOfDescription) {
        return taskDaoImpl.findTasksByPartOfDescription(partOfDescription);
    }

    @Override
    public List<Task> findAllTasksByDescription(String description) {
        return taskDaoImpl.findAllTasksByDescription(description);
    }

    @Override
    public Task findTaskByName(String name) {
        return taskDaoImpl.findTaskByName(name);
    }

    @Override
    public List<SubTask> findAllSubTasksByTaskName(String name) {
        return taskDaoImpl.findAllSubTasksByTaskName(name);
    }

    @Override
    public Task save(Task task) {
        return taskDaoImpl.save(task);
    }

    @Override
    public void delete(Task task) {
        taskDaoImpl.delete(task);
    }

    @Override
    public void addSubTask(String name, SubTask subTask) {
        taskDaoImpl.addSubTask(name, subTask);
    }

    @Override
    public void updateSubTasks(String name, List<SubTask> subTaskList) {
        taskDaoImpl.updateSubTasks(name, subTaskList);
    }

    @Override
    public void deleteSubTasks(String name) {
        taskDaoImpl.deleteSubTasks(name);
    }
}
