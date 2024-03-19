package ru.geekbrain.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.geekbrain.crud.model.User;
import ru.geekbrain.crud.service.UserService;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/1.0/users")
    public String getAllUsers(Model model) {
        List<User> userList = userService.findAllUsers();
        model.addAttribute("users", userList);
        return "user-list";
    }

    /*@GetMapping("/api/1.0/user-update/{id}")
    public String getUser(Model model, @PathVariable("id") int id) {
        User user = userService.findUser(id);
        model.addAttribute("user", user);
        return "user-update";
    }

     */


    @GetMapping("/api/1.0/user-create")
    public String createUserForm(User user) {
        return "user-create";
    }

    @PostMapping("/api/1.0/user-create")
    public String createUser(User user){
        userService.saveUser(user);
        return "redirect:/api/1.0/users";
    }

    @GetMapping("/api/1.0/user-delete/{id}")
    public String deleteUserById(@PathVariable("id") int id) {
        userService.deleteUserById(id);
        return "redirect:/api/1.0/users";
    }

    @GetMapping("/api/1.0/user-update/{id}")
    public String createUpdateUserForm(Model model, @PathVariable("id") int id) {
        User user = userService.findUser(id);
        model.addAttribute("user", user);
        //model.addAttribute("id", id);
        return "user-update";
    }

    @PostMapping("/api/1.0/user-update/")
    public String updateUser(User user) {
        userService.updateUser(user);
        return "redirect:/api/1.0/users";
    }

}
