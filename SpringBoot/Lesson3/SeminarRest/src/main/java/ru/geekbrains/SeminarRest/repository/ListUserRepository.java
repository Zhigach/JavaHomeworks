package ru.geekbrains.SeminarRest.repository;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import ru.geekbrains.SeminarRest.domain.User;

import java.util.ArrayList;
import java.util.List;

@Data
@Slf4j
@Repository
@Profile("test")
public class ListUserRepository implements iUserRepository {

    private final List<User> userList = new ArrayList<>();

    @Override
    public void createUser(User user) throws IllegalArgumentException {
        if (userList.stream().noneMatch(usr -> usr.getName().equals(user.getName()))) {
            userList.add(user);
        } else {
            log.error(String.format("User with name %s already exists.", user.getName()));
            throw new IllegalArgumentException("User already exists");
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userList;
    }
}
