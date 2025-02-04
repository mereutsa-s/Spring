package ru.geekbrain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {

    @GetMapping("/form") // Маршрутизация для страницы с формой
    public String showForm() {
        return "form"; // Возвращение имени шаблона с формой
    }

    @PostMapping("/form") // Обработка отправки формы
    public String processForm(@RequestParam("name") String name, @RequestParam("email") String email, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("email", email);
        return "result"; // Переход к результатам
    }
}