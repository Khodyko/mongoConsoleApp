package org.example.web.view;

import org.example.web.MessageBundle;
import org.example.web.controller.Controller;
import org.example.web.entity.SubTask;
import org.example.web.entity.Task;
import org.example.web.exception.ReaderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * This class presents menu.
 * Runs operations of Menu in infinity cycle.
 * Gets input from Reader.
 * Gets info from Controller.
 * @see Reader
 * @see Controller
 */
@Component
public class ViewPresenter {
    private MessageBundle bundle;
    private ViewPresenter viewPresenter;
    private Controller controllerImpl;
    private Reader viewReader;

    public ViewPresenter getViewPresenter() {
        return viewPresenter;
    }

    @Autowired
    public void setViewPresenter(ViewPresenter viewPresenter) {
        this.viewPresenter = viewPresenter;
    }

    public ViewPresenter(MessageBundle bundle, Controller controllerImpl, Reader viewReader) {
        this.bundle = bundle;
        this.controllerImpl = controllerImpl;
        this.viewReader = viewReader;
    }

    public ViewPresenter() {
    }

    public void showMainPage() {
        while (true) {
            System.out.println(bundle.getStr("mes.view.menu.title"));
            System.out.println(bundle.getStr("mes.view.menu.operation.1"));
            System.out.println(bundle.getStr("mes.view.menu.operation.2"));
            System.out.println(bundle.getStr("mes.view.menu.operation.3"));
            System.out.println(bundle.getStr("mes.view.menu.operation.4"));
            System.out.println(bundle.getStr("mes.view.menu.operation.5"));
            System.out.println(bundle.getStr("mes.view.menu.operation.6"));
            System.out.println(bundle.getStr("mes.view.menu.operation.7"));
            System.out.println(bundle.getStr("mes.view.menu.operation.8"));
            System.out.println(bundle.getStr("mes.view.menu.operation.9"));
            System.out.println(bundle.getStr("mes.view.menu.operation.10"));
            System.out.println(bundle.getStr("mes.view.menu.operation.11"));
            System.out.println(bundle.getStr("mes.view.menu.operation.12"));
            System.out.println(bundle.getStr("mes.view.menu.operation.13"));
            System.out.println(bundle.getStr("mes.view.menu.operation.14"));
            executeOperation();
        }
    }

    public void executeOperation() {
        try {
            Integer num = viewReader.getMenuOperationNum(bundle.getStr("mes.view.ask.input.operation"));
            switch (num) {
                case 1: {
                    System.out.println(bundle.getStr("mes.view.tasklist"));
                    System.out.println(controllerImpl.findAllTasks());
                    break;
                }
                case 2: {
                    String name = viewReader.getString(bundle.getStr("mes.view.ask.input.task.name"));
                    System.out.println("Задание с именем " + name);
                    System.out.println(controllerImpl.findTaskByName(name));
                    break;
                }
                case 3: {
                    String partOfName = viewReader.getString(bundle.getStr("mes.view.ask.input.part.task.name"));
                    System.out.println(controllerImpl.findTasksByPartOfName(partOfName));
                    break;
                }
                case 4: {
                    String description = viewReader.getString(bundle.getStr("mes.view.ask.input.task.description"));
                    System.out.println(controllerImpl.findAllTasksByDescription(description));
                    break;
                }
                case 5: {
                    String descriptionPart = viewReader.getString(bundle.getStr("mes.view.ask.input.part.task.description"));
                    System.out.println(controllerImpl.findTasksByPartOfDescription(descriptionPart));
                    break;
                }
                case 6: {
                    String name = viewReader.getString(bundle.getStr("mes.view.ask.input.task.name"));
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
                    String name = viewReader.getString(bundle.getStr("mes.view.ask.input.task.name"));
                    controllerImpl.deleteTaskByName(name);
                    break;
                }
                case 10: {
                    String name = viewReader.getString(bundle.getStr("mes.view.ask.input.task.name"));
                    SubTask subTask = viewReader.getSubTask();
                    controllerImpl.addSubTask(name, subTask);
                    break;
                }
                case 11: {
                    String name = viewReader.getString(bundle.getStr("mes.view.ask.input.task.name"));
                    List<SubTask> subTaskList = viewReader.getSubTaskList();
                    controllerImpl.updateSubTasks(name, subTaskList);
                    break;
                }
                case 12: {
                    String name = viewReader.getString(bundle.getStr("mes.view.ask.input.task.name"));
                    controllerImpl.deleteSubTasks(name);
                    break;
                }
                case 13: {
                    System.out.println(controllerImpl.findOverdueTasks());
                    break;
                }
                case 14: {
                    try {
                        viewReader.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        System.exit(0);
                    }
                    break;
                }
            }
        } catch (ReaderException e) {
            System.err.println(bundle.getStr("mes.error"));
//            e.printStackTrace();
            System.err.println(e.getMessage());
            System.out.println(bundle.getStr("mes.repeat.start"));
        } catch (Exception e) {
            System.err.println(bundle.getStr("mes.error"));
            //            e.printStackTrace();
            System.err.println("Непредвиденная ошибка");
            System.out.println(bundle.getStr("mes.repeat.start"));
        }
    }
}
