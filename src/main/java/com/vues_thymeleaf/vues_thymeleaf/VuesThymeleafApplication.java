package com.vues_thymeleaf.vues_thymeleaf;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VuesThymeleafApplication {

    public static void main(String[] args) {
        SpringApplication.run(VuesThymeleafApplication.class, args);
    }

}
