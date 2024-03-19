package ru.geekbrains.domain;

import lombok.Data;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Data
@Component
@Lazy // do not load into container before class object is requested
public class DieselEngine implements iEngine {

    public DieselEngine() {
        System.out.println("DieselEngine created.");
    }

    @Override
    public void startEngine() {
        System.out.println("Diesel engine works.");
    }
}
