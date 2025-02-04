package ru.geekbrain;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        NotificationService notificationService = new NotificationService();

        // Создаем пользователей
        User user1 = userService.createUser("Alice", 30, "alice@example.com");
        User user2 = userService.createUser("Bob", 25, "bob@example.com");

        // Отправляем уведомления
        notificationService.sendNotification(user1, "Welcome to our service, Alice!");
        notificationService.sendNotification(user2, "Welcome to our service, Bob!");

        // Выводим всех пользователей
        for (User user : userService.getUsers()) {
            System.out.println(user);
        }
    }
}