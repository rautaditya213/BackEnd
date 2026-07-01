package Loose;

public class WhatsAppNotificationService implements NotificationService{
    @Override
    public void send(String message) {
        System.out.println("Sending WhatsApp message: " + message);
    }
}
