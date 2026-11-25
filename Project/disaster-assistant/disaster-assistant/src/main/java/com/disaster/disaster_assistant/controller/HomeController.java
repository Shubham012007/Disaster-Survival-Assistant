package com.disaster.disaster_assistant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.disaster.repository.AlertRepository;

@Controller
public class HomeController {

    @Autowired
    private AlertRepository alertRepository;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/emergency")
    public String emergency() {
        return "emergency";
    }

    @GetMapping("/chatbot")
    public String chatbot() {
        return "chatbot";
    }

    @GetMapping("/alerts")
    public String alerts(Model model) {

        model.addAttribute("alerts", alertRepository.findAll());

        return "alerts";
    }

    @GetMapping("/checklist")
    public String checklist() {
        return "checklist";
    }
}	