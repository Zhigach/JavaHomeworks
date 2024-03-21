package ru.geekbrains.SeminarRest.repository;

import ru.geekbrains.SeminarRest.domain.User;

import java.util.List;

public interface iUserRepository {

    void createUser(User user);

    List<User> getAllUsers();

}
