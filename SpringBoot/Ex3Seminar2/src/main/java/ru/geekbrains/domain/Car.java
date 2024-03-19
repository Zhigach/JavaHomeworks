package ru.geekbrains.domain;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Component
public class Car {

    private String model;
    private String manufacturer;
    @Autowired
    private iEngine engine;

    public Car() {
        model = "Patriot";
        manufacturer = "UAZ";
        System.out.println("Car created.");
    }

    public void go() {
        engine.startEngine();
    }
}
