package org.example.web;


import org.example.web.view.ViewPresenter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Runner {
    public Runner() {
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        ViewPresenter menuView=ctx.getBean(ViewPresenter.class);
        menuView.showMainPage();
    }
}
