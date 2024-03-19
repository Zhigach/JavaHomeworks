package ru.geekbrains;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.geekbrains.config.ProjectConfigurator;
import ru.geekbrains.domain.Car;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfigurator.class);

        Car car = context.getBean(Car.class);
        car.go();
    }
}
