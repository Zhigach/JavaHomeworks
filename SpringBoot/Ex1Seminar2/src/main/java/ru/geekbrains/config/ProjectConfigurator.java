package ru.geekbrains.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import ru.geekbrains.domain.Car;

@Configuration
public class ProjectConfigurator {

    @Bean(name="patrik")
    Car car() {
        Car car = new Car();
        car.setModel("Patriot");
        car.setManufacturer("UAZ");
        return car;
    }

    @Bean
    @Primary
    Car car2() {
        Car car = new Car();
        car.setManufacturer("LADA");
        car.setModel("Largus");
        return car;
    }

    @Bean
    String hello() {
        return "Hello!";
    }

    @Bean
    Integer tan() {
        return 10;
    }

}
