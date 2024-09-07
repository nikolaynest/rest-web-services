package com.nest.webservices.rest_web_services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HealthCheckController {

    private final MessageSource messageSource;

    @Autowired
    public HealthCheckController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping(path = "/health")
    public ResponseEntity<String> getHealth() {
        return ResponseEntity.ok( "{\"health\":\"ok\"}");
    }

    @GetMapping(path = "/internationalized")
    public ResponseEntity<String> getInternationalizedString() {
        Locale locale = LocaleContextHolder.getLocale();
        return ResponseEntity.ok(messageSource.getMessage("good.morning.message", null, "Default Message", locale));
    }
}
