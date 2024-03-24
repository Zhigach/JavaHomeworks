package ru.geekbrains.webage.services;

import org.springframework.stereotype.Service;
import ru.geekbrains.webage.model.User;
import ru.geekbrains.webage.repositories.iUserRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {

    private final iUserRepository userRepository;

    public UserService(iUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public User getUser(User user) {
        if (userRepository.isUserExists(user)) {
            return userRepository.getUserByName(user.getName());
        } else {
            user.setCreationDate(LocalDateTime.now());
            user.setLastLogin(user.getCreationDate());
            return userRepository.createUser(user);
        }
    }

    public User setUserBirthDate(User user, LocalDate birthDate) {
        return userRepository.updateUserBirthDate(user, birthDate);
    }
}
