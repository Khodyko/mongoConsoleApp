package org.example.web.view;

import org.example.web.MessageBundle;
import org.example.web.entity.SubTask;
import org.example.web.entity.Task;
import org.example.web.exception.ReaderException;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class read console input. Catch all Exceptions and returns Reader Exception.
 * @see ReaderException
 */
public class Reader implements AutoCloseable {
    private MessageBundle bundle;
    private Validator validator;
    /**
     * Close at shutDown of programm by Autoclosable
     */
    private final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public Reader() {
    }

    @Autowired
    public Reader(MessageBundle bundle, Validator validator) {
        this.bundle = bundle;
        this.validator = validator;
    }

    public String getString(String message) throws ReaderException {
        System.out.println(message);
        try {
            String string = bufferedReader.readLine().trim();
            validator.isStringNotNullNotVoid(string);
            return string;
        } catch (IOException e) {
            throw new ReaderException(bundle.getStr("mes.error.io"), e);
        }
    }

    public Integer getMenuOperationNum(String message) throws ReaderException {
        try {
            String commandNum = bufferedReader.readLine().trim();
            validator.isStringNotNullNotVoid(commandNum);
            validator.isStringNumIsBetween(commandNum, 0, 15);
            int num = Integer.parseInt(commandNum);
            return num;
        } catch (IOException e) {
            throw new ReaderException(bundle.getStr("mes.error.io"), e);
        }
    }

    public Task getTask() throws ReaderException {
        Task task = new Task();
        Date dateOfCreating = new Date(System.currentTimeMillis());
        Date deadline = getDate("Введите дату выполнения текущей задачи в формате yyyy-MM-dd");
        String name = getString(bundle.getStr("mes.view.ask.input.task.name"));
        String description = getString(bundle.getStr("mes.view.ask.input.task.discription"));
        List<SubTask> subTaskList = getSubTaskList();
        task.setDateOfCreation(dateOfCreating);
        task.setName(name);
        task.setDeadline(deadline);
        task.setDescription(description);
        task.setSubTaskList(subTaskList);
        return task;
    }

    public Date getDate(String message) throws ReaderException {
        System.out.println(message);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            String dateString = bufferedReader.readLine();
            Date date = simpleDateFormat.parse(dateString);
            return date;
        } catch (IOException e) {
            throw new ReaderException(bundle.getStr("mes.error.io"), e);
        } catch (ParseException e) {
            throw new ReaderException("Строка не соответствует формату", e);
        }
    }

    public Boolean getAgreement(String message) throws ReaderException {
        System.out.println(message);
        try {
            String agreement = bufferedReader.readLine();
            if (agreement.equalsIgnoreCase("Y")) {
                return true;
            } else if (agreement.equalsIgnoreCase("N")) {
                return false;
            } else {
                throw new ReaderException("Ввод не соответствует ни \"Y\", ни \"N\"");
            }
        } catch (IOException e) {
            throw new ReaderException(bundle.getStr("mes.error.io"), e);
        }
    }

    public SubTask getSubTask() throws ReaderException {
        SubTask subTask = new SubTask();
        String name = getString("Введите название подзадачи");
        String description = getString("Введите описание подзадачи");
        subTask.setName(name);
        subTask.setDescription(description);
        return subTask;
    }

    public List<SubTask> getSubTaskList() throws ReaderException {
        System.out.println("Вводим список подзадач");
        List<SubTask> subTaskList = new ArrayList<>();
        while (getAgreement("Требуется ли добавить подзадачу в список?(Y/N) " +
                "           Текущее количество подзадач=" + subTaskList.size())) {
            subTaskList.add(getSubTask());
        }
        return subTaskList;
    }

    @Override
    public void close() throws Exception {
        bufferedReader.close();
    }
}
