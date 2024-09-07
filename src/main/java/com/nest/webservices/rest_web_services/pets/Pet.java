package com.nest.webservices.rest_web_services.pets;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class Pet {
    private int id;
    @NotNull
    @Size(min = 2, message = "Name should have at least 2 characters")
    private String name;
    @NotNull
    @Past(message = "Birth Date should be in the past")
    private LocalDate birthDate;
}
