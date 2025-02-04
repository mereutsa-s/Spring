package ru.geekbrain;

public class NotificationService {

    public void sendNotification(User user, String message) {
        // В реальной жизни здесь будет код для отправки сообщения (например, по электронной почте)
        System.out.println("Sending notification to " + user.getEmail() + ": " + message);
    }
}