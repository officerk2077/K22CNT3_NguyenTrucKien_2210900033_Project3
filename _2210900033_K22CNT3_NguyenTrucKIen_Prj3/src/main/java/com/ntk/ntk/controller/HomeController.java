package com.ntk.ntk.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/404")
    public String _404(Model model) {
        return "home/404";
    }
    @GetMapping("/index")
    public String index (Model model) {
        return "home/index";
    }
    @GetMapping("/about")
    public String about (Model model) {
        return "home/about";
    }
}