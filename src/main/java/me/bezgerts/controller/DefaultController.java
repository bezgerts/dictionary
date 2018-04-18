package me.bezgerts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/about")
    private String about()
    {
        return "about";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }
}
