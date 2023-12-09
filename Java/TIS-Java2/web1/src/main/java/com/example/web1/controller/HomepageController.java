package com.example.web1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomepageController {
// Métodos
    @GetMapping("/")
    public String homepage(){return "pages/homepage";}

}
