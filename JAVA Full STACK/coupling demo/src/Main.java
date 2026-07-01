import Loose.EmailNotificationService;
import Loose.NotificationService;
import Loose.UserService;
import Loose.WhatsAppNotificationService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        NotificationService service = new WhatsAppNotificationService();
        UserService userService = new UserService(service);
        userService.notifyUser("Welcome Aditya");
    }
}