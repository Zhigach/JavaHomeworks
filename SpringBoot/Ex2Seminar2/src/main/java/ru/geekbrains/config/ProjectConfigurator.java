package ru.geekbrains.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import ru.geekbrains.domain.Car;
import ru.geekbrains.domain.Engine;

@Configuration
@ComponentScan(basePackages = "ru.geekbrains.domain")
public class ProjectConfigurator {

/*    @Bean(name="patrik")
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
        car.setEngine(engine());
        return car;
    }

    @Bean
    Engine engine() {
        Engine engine = new Engine();
        engine.setEngineType("gasoline");
        return engine;
    }

 */

}
