package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        GreetingService greetingService = (GreetingService) context.getBean("myBean");
        greetingService.sayHello();

        NotificationManager notificationManager = (NotificationManager) context.getBean("notificationManager");
        notificationManager.sendNotification("Hello, this is a notification from email!");
    }
}
