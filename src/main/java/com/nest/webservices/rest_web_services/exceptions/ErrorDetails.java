package com.nest.webservices.rest_web_services.exceptions;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@ToString
@Builder
public class ErrorDetails {

    private LocalDateTime timestamp;
    private String message;
    private String details;
}
