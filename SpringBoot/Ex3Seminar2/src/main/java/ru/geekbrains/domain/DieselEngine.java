package ru.geekbrains.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class DieselEngine implements iEngine {

    public DieselEngine() {
        System.out.println("DieselEngine created.");
    }

    @Override
    public void startEngine() {
        System.out.println("Diesel engine works.");
    }
}
