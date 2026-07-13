package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;




//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome to Spring Framework!");
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

//        GreetingService greetingService = (GreetingService) context.getBean("myBean");
//        greetingService.sayHello();
//
//        NotificationManager notificationManager = (NotificationManager) context.getBean("notificationManager");
//        notificationManager.sendNotification("Hello, this is a notification from email!");

        System.out.println("retrieving bean from context");
        LifeCycleBean lifeCycleBean = context.getBean(LifeCycleBean.class);
        lifeCycleBean.performAction();


    }
}
