package ru.geekbrains.TaskServer.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.TaskServer.model.Task;
import ru.geekbrains.TaskServer.services.TaskService;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class TaskController {

    private final TaskService taskService;
    //swagger at http://localhost:8080/swagger-ui/index.html#/

    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/tasks/{uuid}")
    public Task getTask(@PathVariable UUID uuid) {
        return taskService.getTask(uuid);
    }

    @PostMapping("/tasks")
    public Task addTask(@RequestBody Task task) {
        return taskService.addTask(task);
    }

    @DeleteMapping("/task/{uuid}")
    public void deleteTask(@PathVariable UUID uuid) {
        taskService.deleteTask(uuid);
    }

}
