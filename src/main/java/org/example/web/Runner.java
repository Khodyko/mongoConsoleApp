package org.example.web;


import org.example.web.dao.TaskDao;
import org.example.web.entity.SubTask;
import org.example.web.entity.Task;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    public Runner() {
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Date date = new Date(System.currentTimeMillis());
        List<SubTask> subTaskList = new ArrayList<>();
        SubTask subTask = new SubTask("SubTask5", "MakeSubTaskNew");
        SubTask subTask2 = new SubTask("SubTask4", "MakeSubTask2");
        subTaskList.add(subTask);
        subTaskList.add(subTask2);
        Task task = new Task(date, date, "Task3", "Make a task", subTaskList);
        TaskDao taskDao = ctx.getBean("TaskDaoImpl", TaskDao.class);
//        System.out.println(taskDao.insert(task));
        System.out.println("task2: " + taskDao.findAllByName("Task2"));
        System.out.println("task3: " + taskDao.findAllByName("Task5"));

    }
}
