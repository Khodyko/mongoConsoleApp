package org.example.web.controller;

import org.example.web.dao.TaskDao;
import org.example.web.entity.Task;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Controller {

    TaskDao taskDao;

    public Controller() {
    }

    public Controller(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    public List<Task> findAll() {
        return taskDao.findAll();
    }

}
