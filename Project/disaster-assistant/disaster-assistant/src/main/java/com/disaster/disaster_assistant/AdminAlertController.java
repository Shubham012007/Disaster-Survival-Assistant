package com.disaster.disaster_assistant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.disaster.entity.Alert;
import com.disaster.repository.AlertRepository;

@Controller
public class AdminAlertController {

    @Autowired
    private AlertRepository alertRepository;

    // Admin Alerts Page
    @GetMapping("/admin-alerts")
    public String adminAlerts(Model model) {

        model.addAttribute("alerts", alertRepository.findAll());

        return "admin-alerts";
    }

    // Add New Alert
    @PostMapping("/admin-alerts/add")
    public String addAlert(
            @RequestParam("title") String title,
            @RequestParam("disasterType") String disasterType,
            @RequestParam("message") String message,
            @RequestParam("severity") String severity) {

        Alert alert = new Alert();

        alert.setTitle(title);
        alert.setDisasterType(disasterType);
        alert.setMessage(message);
        alert.setSeverity(severity);

        alertRepository.save(alert);

        return "redirect:/admin-alerts";
    }

    // Delete Alert
    @GetMapping("/admin-alerts/delete")
    public String deleteAlert(@RequestParam("id") Long id) {

        alertRepository.deleteById(id);

        return "redirect:/admin-alerts";
    }
}