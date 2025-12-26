package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * Configures Cross-Origin Resource Sharing (CORS).
     * This is required for the frontend to communicate with the backend 
     * and for the 'OPTIONS' request test case to pass.
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Apply to all endpoints
                .allowedOrigins("*") // Allow all origins (use specific domains in production)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Explicitly allow OPTIONS
                .allowedHeaders("*") // Allow all headers
                .allowCredentials(false) // Credentials should be false if origin is "*"
                .maxAge(3600); // Cache the options response for 1 hour
    }
}