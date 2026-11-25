package com.disaster.disaster_assistant;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DisasterController {

    @GetMapping("/active")
    public String active() {
        return "active";
    }
}