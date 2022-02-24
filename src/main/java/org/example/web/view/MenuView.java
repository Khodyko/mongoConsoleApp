package org.example.web.view;

import org.example.web.view.commands.CommandExecutor;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class MenuView {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    CommandExecutor commandExecutor;

    public MenuView() {
    }

    public void showMainPage(){
        String commandNum=null;
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
        System.out.println("Введите номер требуемой операции (без точки)");
        try {
            commandNum = bufferedReader.readLine().trim();
            int num= Integer.parseInt(commandNum);
            if( commandNum.matches(""))
            commandExecutor.runCommand(commandNum);
            //parseException

        } catch (IOException e) {
            e.printStackTrace();
            commandExecutor.runCommand("-1");
        }
    }
}
