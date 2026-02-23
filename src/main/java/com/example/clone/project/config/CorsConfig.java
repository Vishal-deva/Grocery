package com.example.clone.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();

        // Allow credentials for cookies/sessions
        config.setAllowCredentials(true);

        // Allow your frontend domain + localhost for testing
        config.addAllowedOriginPattern("*"); // Use "*" for testing or Vercel domain specifically
        // config.addAllowedOrigin("https://grocery-frontend-eta-lovat.vercel.app");
        // config.addAllowedOrigin("http://localhost:5500");

        // Allow all headers
        config.addAllowedHeader("*");

        // Allow all HTTP methods
        config.addAllowedMethod("*");

        // Register CORS config for all endpoints
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
}