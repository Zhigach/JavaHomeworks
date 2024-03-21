package ru.geekbrains.SeminarRest.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.geekbrains.SeminarRest.domain.User;

@Service
@Slf4j
public class NotificationService {


    public void notifyUser(User user) {
        String message = String.format("New user has been created: %s", user.getName());
        log.info(message);
//        System.out.printf("New user has been created: %s\n", user.getName());
    }

}
