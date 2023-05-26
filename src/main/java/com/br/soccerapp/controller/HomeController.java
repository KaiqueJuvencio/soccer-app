package com.br.soccerapp.controller;

import com.br.soccerapp.service.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    LeagueService leagueService;

    @GetMapping()
    public ModelAndView home(Model model) {
        ModelAndView modelAndView = new ModelAndView("home");
        model.addAttribute("message", "Hello, World!");
        return modelAndView;
    }
}
