package ru.forchy.workinfo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Главная страница");

        return "home";
    }

    @GetMapping("/portfolio")
    public String portfolio(Model model) {
        model.addAttribute("title", "Портфолио");
        return "about";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "О себе");
        return "about";
    }

    @GetMapping("/site")
    public String site(Model model) {
        model.addAttribute("title", "Об этом сайте");
        return "about";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("title", "Связаться");
        return "about";
    }
}