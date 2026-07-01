package Tight;

public class UserService {
    NotificationServices notificationServices = new NotificationServices();

    public void notifyUser(String message) {
        notificationServices.sendNotification(message);
    }
}
