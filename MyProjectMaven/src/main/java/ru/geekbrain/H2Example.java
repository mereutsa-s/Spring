package ru.geekbrain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2Example {
    public static void main(String[] args) {
        String url = "jdbc:h2:~/test"; // URL базы данных
        String user = "sa"; // Имя пользователя
        String password = ""; // Пароль (по умолчанию пустой)

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Соединение с H2 установлено.");
        } catch (SQLException e) {
            System.err.println("Ошибка соединения: " + e.getMessage());
        }
    }
}

//todo public class H2Example {
//    public static void main(String[] args) {
//        String url = "jdbc:h2:~/test";
//
//        try (Connection conn = DriverManager.getConnection(url, "sa", "")) {
//            Statement stmt = conn.createStatement();
//            stmt.execute("CREATE TABLE IF NOT EXISTS users (id INT PRIMARY KEY, name VARCHAR(255));");
//            stmt.execute("INSERT INTO users (id, name) VALUES (1, 'John Doe');");
//            System.out.println("Таблица создана и данные добавлены.");
//        } catch (SQLException e) {
//            System.err.println("Ошибка: " + e.getMessage());
//        }
//    }
//}