package ru.geekbrains.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Engine {
    private String engineType = "gasoline";

    public Engine() {
        System.out.println("Engine created.");
    }
}
