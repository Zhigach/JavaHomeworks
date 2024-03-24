package ru.geekbrains.webage.model;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Component
@Scope("session")
public class User {
    private long id;
    private String name;
    private String email;
    private LocalDate birthDate;
    private LocalDateTime creationDate;
    private LocalDateTime lastLogin;
}
