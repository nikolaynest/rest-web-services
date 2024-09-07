package com.nest.webservices.rest_web_services;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @GetMapping(path = "/health")
    public ResponseEntity<String> getHealth() {
        return ResponseEntity.ok( "{\"health\":\"ok\"}");
    }
}
