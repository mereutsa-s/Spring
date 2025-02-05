package ru.geekbrain;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

public class UserService {
    private List<User> users;

    public UserService() {
        this.users = new ArrayList<>();
    }

    public User createUser(String name, int age, String email) {
        User newUser = new User(name, age, email);
        users.add(newUser);
        return newUser;
    }

    public List<User> getUsers() {
        return users;
    }

    @TrackUserAction
    public void createUser(String username) {
        // Логика создания пользователя
    }

    @TrackUserAction
    public void deleteUser(Long userId) {
        // Логика удаления пользователя
    }

    @TrackUserAction
    public void updateUser(Long userId, String newUsername) {
        // Логика обновления пользователя
    }
}