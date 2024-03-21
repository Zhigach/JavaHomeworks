package ru.geekbrains.SeminarRest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.SeminarRest.domain.User;
import ru.geekbrains.SeminarRest.repository.iUserRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataProcessingService {

    @Autowired
    private iUserRepository userRepository;

    public List<User> sortUsersByAge() {
        return userRepository.getAllUsers().stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
    }

    public List<User> filterUsersByAge(int age) {
        return userRepository.getAllUsers().stream()
                .filter(user -> user.getAge() > age)
                .collect(Collectors.toList());
    }

    public double calculateAverageAge() {
        return userRepository.getAllUsers().stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
    }

}
