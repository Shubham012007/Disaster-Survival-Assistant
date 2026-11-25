package com.disaster.disaster_assistant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.disaster.entity.user;
import com.disaster.repository.UserRepository;

@Controller
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    // Admin Login Page
    @GetMapping("/admin-login")
    public String adminLogin() {
        return "admin-login";
    }

    // Admin Login Check
    @PostMapping("/admin-login")
    public String adminLoginCheck(
            @RequestParam("username") String username,
            @RequestParam("password") String password) {

        username = username.trim();
        password = password.trim();

        if (username.equals("admin") &&
            password.equals("admin123")) {

            return "redirect:/admin";

        } else {

            return "redirect:/admin-login?error=true";
        }
    }

    // Admin Dashboard
    @GetMapping("/admin")
    public String adminDashboard(Model model) {

        model.addAttribute(
            "users",
            userRepository.findAll()
        );

        return "admin";
    }

 
}