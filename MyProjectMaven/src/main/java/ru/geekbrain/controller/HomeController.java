package ru.geekbrain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/") // Маршрутизация для главной страницы
    public String home(Model model) {
        model.addAttribute("message", "Привет, мир!"); // Добавление сообщения в модель
        return "index"; // Возвращение имени шаблона
    }
}