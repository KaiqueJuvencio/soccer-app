package com.br.soccerapp.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/home")
public class HomeController {

    @GetMapping()
    public ModelAndView home(Model model) {
        ModelAndView modelAndView = new ModelAndView("home");
        model.addAttribute("message", "Hello, World!");
        return modelAndView;
    }
}
