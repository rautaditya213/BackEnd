package com.example;

import com.example.Controller.UserController;
import com.example.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserController userController = context.getBean(UserController.class);
        userController.createUser("Aditya Raut");
        userController.createUser("Tejas bhau");
        userController.listUsers();

    }
}
