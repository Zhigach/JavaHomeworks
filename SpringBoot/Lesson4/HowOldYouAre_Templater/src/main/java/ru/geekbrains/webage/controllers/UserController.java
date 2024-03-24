package ru.geekbrains.webage.controllers;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.webage.model.User;
import ru.geekbrains.webage.services.DataProcessingService;
import ru.geekbrains.webage.services.UserService;

import java.util.List;

@Controller
@Scope("session")
@RequestMapping("/")
public class UserController {

    private final UserService userService;
    private final DataProcessingService dataProcessingService;

    public UserController(UserService userService, DataProcessingService dataProcessingService) {
        this.userService = userService;
        this.dataProcessingService = dataProcessingService;
    }

    @GetMapping("/index.html")
    public String welcome() {
        return "homepage";
    }

    @GetMapping("/welcome-page.html")
    public String singUpForm(User user) {
        return "welcome-page";
    }

    @PostMapping("/create-user")
    public String startSession(User user, Model model) {
        userService.getUser(user);
        List<Long> durations = dataProcessingService.getDurations(user.getBirthDate());
        model.addAttribute("durations", durations);
        model.addAttribute("user", user);
        return "calculation-results";
    }


    @RestController
    @Scope("session")
    private class AdminController {
        @GetMapping("/api/1.0/users")
        public List<User> getAllUsers() {
            return userService.getAllUsers();
        }
    }
}
