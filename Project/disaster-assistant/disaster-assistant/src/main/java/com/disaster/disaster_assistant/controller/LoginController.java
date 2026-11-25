package com.disaster.disaster_assistant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.disaster.entity.user;
import com.disaster.repository.UserRepository;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    // Login Page
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    // Login Check
    @PostMapping("/login")
    public String loginUser(
            @RequestParam("email") String email,
            @RequestParam("password") String password) {

        email = email.trim();
        password = password.trim();

        List<user> users =
                userRepository.findAllByEmail(email);

        for (user u : users) {

            if (u.getPassword() != null &&
                u.getPassword().equals(password)) {

                return "redirect:/";
            }
        }

        return "redirect:/login?error=true";
    }
}