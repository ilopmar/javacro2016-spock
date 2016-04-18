package demo;

public class UserService {

    private NotificationService notificationService;

    public UserService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    void createUser(String name, String lastName) {
        Person person = new Person(name, lastName);

        // Storing person on DB

        notificationService.sendNotification(person, "User created");
    }
}
