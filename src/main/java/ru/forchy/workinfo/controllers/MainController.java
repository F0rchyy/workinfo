package ru.forchy.workinfo.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.forchy.workinfo.entity.Content;
import ru.forchy.workinfo.repository.ContentRepo;

import java.util.Optional;

/**
 * Класс, реализующий контроллер веб-приложения
 * Необходим для определения маршрутов и методов обработки запросов
 */

@Controller
public class MainController {

    @Autowired
    private ContentRepo contentRepo;

    @GetMapping(value = {"/", "/home"})
    public String home(Model model) {
        model.addAttribute("title", "Главная страница");

        // Подгрузка контента страницы из БД
        Optional<Content> content = contentRepo.findByTag("home");
        String res = content.map(Content::getContent).orElse(null);
        model.addAttribute("content", res);

        return "home";
    }

    @GetMapping("/login")
    public String login(Model model, @RequestParam(name = "error", required = false) String error) {
        model.addAttribute("title", "Авторизация");

        // Вывод ошибки аутентификации, если она есть
        if (error != null) {
            model.addAttribute("error", "Неизвестное сочетание логина и пароля");
        } else {
            model.addAttribute("error", "");
        }

        return "login";
    }

    // Инвалидация текущей сессии пользователя и редирект на страницу аутентификации
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            request.getSession().invalidate();
        }
        return "redirect:/login";
    }

    @GetMapping("/portfolio")
    public String portfolio(Model model) {
        model.addAttribute("title", "Портфолио");

        // Подгрузка контента страницы из БД
        Optional<Content> content = contentRepo.findByTag("portfolio");
        String res = content.map(Content::getContent).orElse(null);
        model.addAttribute("content", res);

        return "portfolio";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "О себе");

        // Подгрузка контента страницы из БД
        Optional<Content> content = contentRepo.findByTag("about");
        String res = content.map(Content::getContent).orElse(null);
        model.addAttribute("content", res);

        return "about";
    }

    @GetMapping("/site")
    public String site(Model model) {
        model.addAttribute("title", "Об этом сайте");

        // Подгрузка контента страницы из БД
        Optional<Content> content = contentRepo.findByTag("site");
        String res = content.map(Content::getContent).orElse(null);
        model.addAttribute("content", res);

        return "site";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("title", "Связаться");

        // Подгрузка контента страницы из БД
        Optional<Content> content = contentRepo.findByTag("contact");
        String res = content.map(Content::getContent).orElse(null);
        model.addAttribute("content", res);

        return "contact";
    }

    @GetMapping("/edit/{page}")
    public String editHome(@PathVariable(value = "page") String page, Model model) {
        model.addAttribute("title", "Редактирование");

        // Подгрузка контента страницы из БД
        Optional<Content> content = contentRepo.findByTag(page);
        String res = content.map(Content::getContent).orElse(null);
        model.addAttribute("content", res);

        return page + "-edit";
    }

    @PostMapping("/edit/{page}")
    public String contentPostUpdate(@PathVariable(value = "page") String page, @RequestParam String text, Model model) {
        // Изменение контента страницы
        Content content = contentRepo.findByTag(page).orElseThrow();
        content.setContent(text);
        contentRepo.save(content);

        return "redirect:/" + page;
    }
}