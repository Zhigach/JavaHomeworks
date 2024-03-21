package ru.geekbrains.SeminarRest.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.SeminarRest.domain.User;
import ru.geekbrains.SeminarRest.repository.iUserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private iUserRepository userRepository;

    public User createUser(User user) throws IllegalArgumentException {
        User newUser = new User(user.getName(), user.getAge(), user.getEmail());

        userRepository.createUser(newUser);

        return newUser;
    }

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }
}
