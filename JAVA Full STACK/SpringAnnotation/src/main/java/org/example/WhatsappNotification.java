package org.example;

import org.springframework.stereotype.Component;

@Component("whatsapp")
public class WhatsappNotification implements NotificationService {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending WhatsApp notification: " + message);
    }
}
