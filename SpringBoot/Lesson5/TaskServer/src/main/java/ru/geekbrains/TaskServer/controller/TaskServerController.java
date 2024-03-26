package ru.geekbrains.TaskServer.controller;

import org.springframework.web.bind.annotation.*;
import ru.geekbrains.TaskServer.model.Task;
import ru.geekbrains.TaskServer.repository.TaskRepository;
import ru.geekbrains.TaskServer.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskServerController {
    private TaskService taskService;

    public TaskServerController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping("/tasks")
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

}
