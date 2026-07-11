package org.example;

import org.springframework.beans.factory.annotation.Qualifier;

public class LifeCycleBean {
    private NotificationService notificationService;

    public LifeCycleBean(@Qualifier("email")NotificationService notificationService) {
        System.out.println("LifeCycleBean constructor called");
        this.notificationService = notificationService;
    }

    public void init() {
        System.out.println("LifeCycleBean init method called");

    }

    public void performAction() {
        System.out.println("LifeCycleBean performAction method called");
        notificationService.sendNotification("Hello from LifeCycleBean!");
    }

    public void cleanup() {
        System.out.println("LifeCycleBean destroy method called");
    }
}


