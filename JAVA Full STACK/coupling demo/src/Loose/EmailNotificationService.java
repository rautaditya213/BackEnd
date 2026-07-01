package Loose;


public class EmailNotificationService implements NotificationService {

    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}