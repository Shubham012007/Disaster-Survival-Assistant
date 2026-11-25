package com.disaster.disaster_assistant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.disaster.entity.user;
import com.disaster.repository.UserRepository;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Register Page
    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    // Register User
    @PostMapping("/register")
    public String registerUser(@ModelAttribute user user) {

        userRepository.save(user);

        return "redirect:/";
    }
}