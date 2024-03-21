package ru.geekbrains.SeminarRest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.SeminarRest.domain.User;
import ru.geekbrains.SeminarRest.services.DataProcessingService;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private DataProcessingService dataProcessingService;

    @GetMapping
    public List<String> getTasks() {
        return Arrays.stream(DataProcessingService.class.getDeclaredMethods())
                .map(Method::getName)
                .collect(Collectors.toList());
    }

    @GetMapping("/sortUsersByAge")
    public List<User> sortUsersByAge() {
        return dataProcessingService.sortUsersByAge();
    }

    @GetMapping("/filterUsersByAge")
    public List<User> filterUsersByAge(@RequestParam int age) {
        return dataProcessingService.filterUsersByAge(age);
    }

    @GetMapping("/filter/{age}")
    public List<User> filterUsersByAge_2(@PathVariable int age) {
        return dataProcessingService.filterUsersByAge(age);
    }

    @GetMapping("/calculateAverageAge")
    public double calculateAverageAge() {
        return dataProcessingService.calculateAverageAge();
    }
}
