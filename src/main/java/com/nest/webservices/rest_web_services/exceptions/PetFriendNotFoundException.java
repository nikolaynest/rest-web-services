package com.nest.webservices.rest_web_services.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class PetFriendNotFoundException extends RuntimeException {

    public PetFriendNotFoundException(String message) {
        super(message);
    }
}
