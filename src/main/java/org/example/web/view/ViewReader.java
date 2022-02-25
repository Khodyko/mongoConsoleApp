package org.example.web.view;

import org.example.web.entity.SubTask;
import org.example.web.entity.Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ViewReader implements AutoCloseable {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public String getString(String message) {
        System.out.println(message);
        String string=null;
        try {
        string=bufferedReader.readLine().trim();
        //validate
        return string;
        } catch (IOException e) {
            e.printStackTrace();
            //fixme
        }
        return null;
        //fixme
    }

    public Integer getMenuOperationNum(String message) {
        System.out.println();
        String commandNum = null;
        try  {
            commandNum = bufferedReader.readLine().trim();
            int num = Integer.parseInt(commandNum);
            if (num > 0 && num < 14) {
                return num;
            }
        } catch (IOException e) {
            e.printStackTrace();
            //fixme
        } catch (NumberFormatException e) {
//fixme
            e.printStackTrace();
        }
        return null;
        //fixme
    }

    public Task getTask(){
        Task task=new Task();
        Date dateOfCreating = new Date(System.currentTimeMillis());
        Date deadline =getDate("Введите дату выполнения текущей задачи в формате YYYY-MM-dd");

        String name =getString("Введите название задачи");
        String description =getString("Введите описание задачи");
        List<SubTask> subTaskList=getSubTaskList();
        task.setDateOfCreation(dateOfCreating);
        task.setName(name);
        task.setDeadline(deadline);
        task.setDescription(description);
        task.setSubTaskList(subTaskList);
        return task;
    }

    public Date getDate(String message){
        System.out.println(message);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("YYYY-MM-dd");
        try {
            String dateString=bufferedReader.readLine();
            //validate
            Date date=simpleDateFormat.parse(dateString);
            return  date;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();//fixme
        }
        return null; //fixme
    }

    public Boolean getAgreement(String message){
        System.out.println(message);
        //validate
        try {
            String agreement=bufferedReader.readLine();
            if(agreement.equalsIgnoreCase("Y")){
                return true;
            }
            else if(agreement.equalsIgnoreCase("N")){
            return false;}
        } catch (IOException e) {
            e.printStackTrace(); //fixme
        }
        return null; //fixme
    }
    public SubTask getSubTask(){
        SubTask subTask=new SubTask();
        String name=getString("Введите название подзадачи");
        String description=getString("Введите описание подзадачи");
        subTask.setName(name);
        subTask.setDescription(description);
        return subTask;
    }
    public List<SubTask> getSubTaskList(){
        System.out.println("Вводим список подзадач");
        List<SubTask> subTaskList=new ArrayList<>();
        while(getAgreement("Требуется ли добавить подзадачу в список? Текущее количество подзадач="+subTaskList.size())){
            subTaskList.add(getSubTask());
        }
        return subTaskList;
    }

    @Override
    public void close() throws Exception {
        bufferedReader.close();
    }
}
