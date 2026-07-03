package org.example;

public class WhatsAppService implements NotificationService{
    public void sendNotification(String message) {
        System.out.println("Sending WhatsApp notification: " + message);
    }
}
