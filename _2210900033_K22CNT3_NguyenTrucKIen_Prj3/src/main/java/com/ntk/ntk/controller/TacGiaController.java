package com.ntk.ntk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/tacgia")  // Define the base URL
public class TacGiaController {

    @GetMapping
    public String index() {
        return "admin/tacgia/index"; // View resolver will map this to the corresponding template
    }
@RequestMapping("/create")
    public String create() {
        return "admin/tacgia/create";
    }
}
