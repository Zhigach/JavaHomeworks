package ru.geekbrains;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.geekbrains.config.ProjectConfigurator;
import ru.geekbrains.domain.Car;
import ru.geekbrains.domain.DieselEngine;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfigurator.class);
        System.out.println("------MAIN EXECUTION----");
        Car car = context.getBean(Car.class);
        car.go();

        System.out.println("------------------");
        DieselEngine de = context.getBean(DieselEngine.class);
    }
}
