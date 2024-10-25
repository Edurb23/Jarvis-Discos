package com.example.discos_jarvis_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Bem-vindo ao Sistema de Gerenciamento de Álbuns");
        return "index";
    }
}
