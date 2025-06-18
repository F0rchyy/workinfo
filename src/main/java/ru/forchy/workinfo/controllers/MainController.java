package ru.forchy.workinfo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.forchy.workinfo.entity.Content;
import ru.forchy.workinfo.repository.ContentRepo;

import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    private ContentRepo contentRepo;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Главная страница");

        Optional<Content> content = contentRepo.findByTag("home");
        String res = content.map(Content::getContent).orElse(null);
        model.addAttribute("content", res);

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

    @GetMapping("/edit/home")
    public String editHome(Model model) {
        model.addAttribute("title", "Главная страница");

        Optional<Content> content = contentRepo.findByTag("home");
        String res = content.map(Content::getContent).orElse(null);
        model.addAttribute("content", res);

        return "home-edit";
    }

    @PostMapping("/edit/home")
    public String contentPostUpdate(@RequestParam String text, Model model) {
        Content content = contentRepo.findByTag("home").orElseThrow();
        content.setContent(text);
        contentRepo.save(content);

        return "redirect:/";
    }
}