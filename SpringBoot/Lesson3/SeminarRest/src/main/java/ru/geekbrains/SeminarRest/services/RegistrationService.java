package ru.geekbrains.SeminarRest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.SeminarRest.domain.User;

@Service
public class RegistrationService {

    @Autowired
    private UserService userService;

    @Autowired
    private NotificationService notificationService;

    public User processRegistration(User user) throws IllegalArgumentException {
        User newUser = userService.createUser(user);
        notificationService.notifyUser(newUser);
        return newUser;
    }
}
