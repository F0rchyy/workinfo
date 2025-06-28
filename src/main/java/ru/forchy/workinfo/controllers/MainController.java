package ru.forchy.workinfo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.forchy.workinfo.entity.Content;
import ru.forchy.workinfo.repository.ContentRepo;

import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    private ContentRepo contentRepo;

    @GetMapping(value = {"/", "/home"})
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

        Optional<Content> content = contentRepo.findByTag("portfolio");
        String res = content.map(Content::getContent).orElse(null);
        model.addAttribute("content", res);

        return "portfolio";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "О себе");

        Optional<Content> content = contentRepo.findByTag("about");
        String res = content.map(Content::getContent).orElse(null);
        model.addAttribute("content", res);

        return "about";
    }

    @GetMapping("/site")
    public String site(Model model) {
        model.addAttribute("title", "Об этом сайте");

        Optional<Content> content = contentRepo.findByTag("site");
        String res = content.map(Content::getContent).orElse(null);
        model.addAttribute("content", res);

        return "site";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("title", "Связаться");

        Optional<Content> content = contentRepo.findByTag("contact");
        String res = content.map(Content::getContent).orElse(null);
        model.addAttribute("content", res);

        return "contact";
    }

    @GetMapping("/edit/{page}")
    public String editHome(@PathVariable(value = "page") String page, Model model) {
        model.addAttribute("title", "Редактирование");

        Optional<Content> content = contentRepo.findByTag(page);
        String res = content.map(Content::getContent).orElse(null);
        model.addAttribute("content", res);

        return page + "-edit";
    }

    @PostMapping("/edit/{page}")
    public String contentPostUpdate(@PathVariable(value = "page") String page, @RequestParam String text, Model model) {
        Content content = contentRepo.findByTag(page).orElseThrow();
        content.setContent(text);
        contentRepo.save(content);

        return "redirect:/" + page;
    }
}