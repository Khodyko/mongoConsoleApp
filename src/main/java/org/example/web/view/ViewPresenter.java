package org.example.web.view;

import org.example.web.controller.Controller;
import org.example.web.entity.SubTask;
import org.example.web.entity.Task;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class ViewPresenter {

    Controller controllerImpl;
    ViewReader viewReader;

    public ViewPresenter(Controller controllerImpl, ViewReader viewReader) {
        this.controllerImpl = controllerImpl;
        this.viewReader = viewReader;
    }

    public ViewPresenter() {
    }

    public void showMainPage() {
        System.out.println("Список возможных операций");
        System.out.println("1. Показать список всех заданий");
        System.out.println("2. Найти задание по имени задания");
        System.out.println("3. Найти задание по части имени задания");
        System.out.println("4. Найти задание по описанию задания");
        System.out.println("5. Найти задание по части описания задания");
        System.out.println("6. Найти все подзадание по имени задания");
        System.out.println("7. Создать новое задание");
        System.out.println("8. Изменить задание");
        System.out.println("9. Удалить задание");
        System.out.println("10. Добавить подзадание в задание");
        System.out.println("11. Изменить список подзаданий в задании");
        System.out.println("12. Удалить список подзаданий в задании");
        System.out.println("13. Выйти");
        executeOperation();
    }

    public void executeOperation() {

        Integer num = viewReader.getMenuOperationNum("Введите номер требуемой операции(без точки)");
        switch (num) {
            case 1: {
                System.out.println("Список всех заданий");
                System.out.println(controllerImpl.findAllTasks());
                break;
            }
            case 2: {
                String name = viewReader.getString("Введите имя задания");
                System.out.println("Задание с именем " + name);
                System.out.println(controllerImpl.findTaskByName(name));
                break;
            }
            case 3: {
                String partOfName = viewReader.getString("Введите часть имени задания");
                System.out.println(controllerImpl.findTasksByPartOfName(partOfName));
                break;
            }
            case 4: {
                String description = viewReader.getString("Введите описание задания");
                System.out.println(controllerImpl.findAllTasksByDescription(description));
                break;
            }
            case 5: {
                String descriptionPart = viewReader.getString("Введите часть описания задания");
                System.out.println(controllerImpl.findAllTasksByDescription(descriptionPart));
                break;
            }
            case 6: {
                String name = viewReader.getString("Введите имя задания");
                System.out.println(controllerImpl.findAllSubTasksByTaskName(name));
                break;
            }
            case 7: {
                Task task = viewReader.getTask();
                System.out.println(controllerImpl.insert(task));
                break;
            }
            case 8: {
                Task task = viewReader.getTask();
                controllerImpl.save(task);
                break;
            }
            case 9: {
                Task task = viewReader.getTask();
                controllerImpl.delete(task);
                break;
            }
            case 10: {
                String name = viewReader.getString("Введите название задачи");
                SubTask subTask = viewReader.getSubTask();
                controllerImpl.addSubTask(name, subTask);
                break;
            }
            case 11: {
                String name = viewReader.getString("Введите название задачи");
                List<SubTask> subTaskList = viewReader.getSubTaskList();
                controllerImpl.updateSubTasks(name, subTaskList);
            }
            case 12: {
                //вынести строки в проперти или в final
                String name = viewReader.getString("Введите название задачи");
                controllerImpl.deleteSubTasks(name);
            }
//Дописать
            case 13: {
                try {
                    viewReader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            default: {
                try {
                    viewReader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
