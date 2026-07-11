package org.example;


import org.springframework.stereotype.Component;


@Component("email")
public class EmailNotification implements NotificationService {

    @Override
    public void sendNotification(String message) {
        System.out.println("Sending email notification: " + message);
    }
}
