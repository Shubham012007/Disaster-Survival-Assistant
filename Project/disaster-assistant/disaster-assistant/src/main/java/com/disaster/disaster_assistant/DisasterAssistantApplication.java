package com.disaster.disaster_assistant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.disaster")
@EnableJpaRepositories(basePackages = "com.disaster.repository")
@EntityScan(basePackages = "com.disaster.entity")
public class DisasterAssistantApplication {

    public static void main(String[] args) {
        SpringApplication.run(DisasterAssistantApplication.class, args);
    }
}