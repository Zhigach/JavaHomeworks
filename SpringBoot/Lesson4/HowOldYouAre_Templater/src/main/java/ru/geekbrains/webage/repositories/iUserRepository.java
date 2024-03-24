package ru.geekbrains.webage.repositories;

import ru.geekbrains.webage.model.User;

import java.time.LocalDate;
import java.util.List;

public interface iUserRepository {
    List<User> getAllUsers();

    User createUser(User user);

    boolean isUserExists(User user);

    User getUserByName(String name);

    void updateLatLoginTime(User user);

    User updateUserBirthDate(User user, LocalDate birthDate);
}
