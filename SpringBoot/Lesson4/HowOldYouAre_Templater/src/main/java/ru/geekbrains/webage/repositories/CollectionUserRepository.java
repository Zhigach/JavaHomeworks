package ru.geekbrains.webage.repositories;

import org.springframework.stereotype.Repository;
import ru.geekbrains.webage.model.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Repository
public class CollectionUserRepository implements iUserRepository {

    private final ConcurrentMap<String, User> users;

    public CollectionUserRepository() {
        users = new ConcurrentHashMap<>();
    }

    @Override
    public List<User> getAllUsers() {
        return users.values().stream().toList();
    }

    public User createUser(User user) {
        user.setId(users.size());
        users.put(user.getName(), user);
        return user;
    }

    @Override
    public boolean isUserExists(User user) {
        return users.containsKey(user.getName()) && users.get(user.getName()).equals(user);
    }

    @Override
    public User getUserByName(String name) {
        return users.get(name);
    }

    @Override
    public void updateLatLoginTime(User user) {
        users.get(user.getName()).setLastLogin(LocalDateTime.now());
    }

    @Override
    public User updateUserBirthDate(User user, LocalDate birthDate) {
        User updatedUser = getUserByName(user.getName());
        updatedUser.setBirthDate(birthDate);
        return updatedUser;
    }
}
