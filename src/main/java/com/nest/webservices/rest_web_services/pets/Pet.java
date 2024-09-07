package com.nest.webservices.rest_web_services.pets;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class Pet {
    private int id;
    private String name;
    private LocalDate birthDate;
}
