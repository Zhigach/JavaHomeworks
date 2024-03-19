package ru.geekbrains.domain;

import lombok.Data;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Data
@Component
@Primary
public class GasolineEngine implements iEngine {

    public GasolineEngine() {
        System.out.println("GasolineEngine created.");
    }

    @Override
    public void startEngine() {
        System.out.println("Gasoline engine works.");
    }
}
