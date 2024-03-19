package ru.geekbrain.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrain.crud.model.User;
import ru.geekbrain.crud.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAllUsers() {
        return userRepository.getAllUsers();
    }

    public User findUser(int id) {
        return userRepository.findUser(id);
    }

    public void saveUser(User user){
        userRepository.save(user);
    }

    public void deleteUserById(int id) {
        userRepository.deleteUserById(id);
    }

    public void updateUser(User user) {
        userRepository.updateUserById(user);
    }
}
