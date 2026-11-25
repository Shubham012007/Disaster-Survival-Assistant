package com.disaster.disaster_assistant.controller;

import java.util.Comparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.disaster.entity.Alert;
import com.disaster.repository.AlertRepository;

@RestController
public class NotificationController {

    @Autowired
    private AlertRepository alertRepository;

    @GetMapping("/api/alerts/latest")
    public Alert getLatestAlert() {

        return alertRepository.findAll()
                .stream()
                .max(Comparator.comparing(Alert::getId))
                .orElse(null);
    }
}