package Loose;

public class UserService {

    private NotificationService notificationService;

    public UserService(
            NotificationService notificationService) {

        this.notificationService =
                notificationService;
    }

    public void notifyUser(String message) {

        notificationService.send(message);
    }
}
