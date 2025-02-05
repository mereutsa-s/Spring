package ru.geekbrain;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ResourceController {

    @GetMapping("/private-data")
    public String privateData() {
        return "Это приватные данные, доступные только для ADMIN.";
    }

    @GetMapping("/public-data")
    public String publicData() {
        return "Это публичные данные, доступные для всех аутентифицированных пользователей.";
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // Название вашего шаблона для страницы входа
    }
}