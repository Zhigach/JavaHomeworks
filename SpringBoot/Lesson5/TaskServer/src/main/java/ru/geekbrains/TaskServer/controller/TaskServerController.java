package ru.geekbrains.TaskServer.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.TaskServer.model.Task;
import ru.geekbrains.TaskServer.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskServerController {
    private TaskService taskService;

    public TaskServerController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/status")
    public List<String> getStatusesList() {
        return taskService.getStatusesList();
    }

    @GetMapping("/tasks")
    public List<Task> getAllTasks(@RequestParam(required = false) String status) {
        if (status == null) {
            return taskService.getAllTasks();
        } else {
            return taskService.getTasksByStatus(status);
        }
    }

    @PostMapping("/tasks")
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<Task> updateTaskById(@PathVariable Long id, @RequestBody Task taskStatus) {
        return taskService.updateTaskStatusById(id, taskStatus);
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Task> deleteTaskById(@PathVariable Long id) {
        taskService.deleteTaskById(id);
        return new ResponseEntity<Task>(HttpStatus.OK);
    }

}
