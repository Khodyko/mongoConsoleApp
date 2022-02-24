package org.example.web.dao.impl;

import org.example.web.dao.TaskDao;
import org.example.web.entity.SubTask;
import org.example.web.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskDaoImpl implements TaskDao {
    private MongoTemplate template;
    private MongoOperations mongo;

    @Autowired
    public TaskDaoImpl(MongoTemplate template, MongoOperations mongo) {
        this.template = template;
        this.mongo = mongo;
    }


    public TaskDaoImpl() {
    }

@Override
    public List<Task> findAll() {
        return template.findAll(Task.class);
    }

    @Override
    public Task insert(Task task) {
        template.insert(task);
        return task;
    }
    @Override
    public List<Task> findTasksByPartOfName(String partOfName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").regex(".*" + partOfName + ".*", "i"));
        return template.find(query, Task.class);
    }
    @Override
    public List<Task> findTasksByPartOfDescription(String partOfDescription) {
        Query query = new Query();
        query.addCriteria(Criteria.where("description").regex(".*" + partOfDescription + ".*", "i"));
        return template.find(query, Task.class);
    }
    @Override
    public List<Task> findAllTasksByDescription(String description) {
        Query query = new Query();
        query.addCriteria(Criteria.where("description").is(description));
        return template.find(query, Task.class);
    }
    @Override
    public Task findAllByName(String name) {
        return template.findById(name, Task.class);
    }

    @Override
    public List<SubTask> findAllSubTasksByTaskName(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        Task task = template.findById(name, Task.class);
        return task.getSubTaskList();
    }
    @Override
    public Task save(Task task) {

        return template.save(task);
    }

    @Override
    public void delete(Task task) {
        template.remove(task);
    }
    @Override
    public void addSubTask(String name, SubTask subTask) {
        Update update = new Update();
        update.addToSet("subTaskList", subTask);
        Criteria criteria = Criteria.where("_id").is(name);
        template.updateFirst(Query.query(criteria), update, "taskEntity");
    }
    @Override
    public void updateSubTasks(String name, List<SubTask> subTaskList) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(name));
        Update update = new Update();
        update.set("subTaskList", subTaskList);
        template.updateFirst(query, update, "taskEntity");
    }
    @Override
    public void deleteSubTasks(String name) {
        List<SubTask> subTaskList = new ArrayList<>();
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(name));
        Update update = new Update();
        update.set("subTaskList", subTaskList);
        template.updateFirst(query, update, "taskEntity");
    }
}
