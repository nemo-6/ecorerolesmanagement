package com.ecore.ecorerolemanagement;

import com.ecore.ecorerolemanagement.model.TeamModel;
import com.ecore.ecorerolemanagement.service.TeamService;
import com.ecore.ecorerolemanagement.util.OkHttpClientImpl;
import com.mongodb.event.CommandEvent;
import okhttp3.OkHttpClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class EcorerolemanagementApplication {
    public static void main(String[] args) {
        SpringApplication.run(EcorerolemanagementApplication.class, args);
    }

}
