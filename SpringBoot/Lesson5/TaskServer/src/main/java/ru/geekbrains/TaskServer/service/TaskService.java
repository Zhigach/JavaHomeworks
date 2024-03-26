package ru.geekbrains.TaskServer.service;

import org.springframework.stereotype.Service;
import ru.geekbrains.TaskServer.model.Status;
import ru.geekbrains.TaskServer.model.Task;
import ru.geekbrains.TaskServer.repository.TaskRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {

    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task createTask(Task task) {
        task.setStatus(Status.NEW);
        task.setCreationDate(LocalDateTime.now());
        return taskRepository.save(task);
    }
}
