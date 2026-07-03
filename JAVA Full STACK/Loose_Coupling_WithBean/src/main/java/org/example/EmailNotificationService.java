package org.example;

public class EmailNotificationService implements NotificationService {
    public void sendNotification(String message) {
        System.out.println("Sending email notification: " + message);
    }
}
