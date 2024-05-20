package com.example.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MVCController {

    @RequestMapping("/")
    public String homePage() {
        return "homepage";
    }

    @RequestMapping("/inputUser")
    public String displayUser(Model inputForm) {
        inputForm.addAttribute("message", "message here");
        return "user";
    }
}
