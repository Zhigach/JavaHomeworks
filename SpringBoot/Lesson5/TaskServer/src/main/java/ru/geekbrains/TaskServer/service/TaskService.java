package ru.geekbrains.TaskServer.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.geekbrains.TaskServer.model.Status;
import ru.geekbrains.TaskServer.model.Task;
import ru.geekbrains.TaskServer.repository.TaskRepository;

import java.time.LocalDateTime;
import java.util.Arrays;
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

    public List<String> getStatusesList() {
        return Arrays.stream(Status.values()).map(Enum::toString).toList();
    }

    public List<Task> getTasksByStatus(String status) {
        return taskRepository.findTasksByStatus(Status.valueOf(status));
    }

    public ResponseEntity<Task> updateTaskStatusById(Long id, Task taskStatus) {
        Task task = taskRepository.getReferenceById(id);
        if (task.getStatus().ordinal() >= taskStatus.getStatus().ordinal()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            task.setStatus(taskStatus.getStatus());
            if (task.getStatus().equals(Status.DONE)) {
                task.setCompletionDate(LocalDateTime.now());
            }
            return new ResponseEntity<>(taskRepository.save(task), HttpStatus.OK);
        }
    }

    public void deleteTaskById(Long id) {
        taskRepository.delete(taskRepository.getReferenceById(id));
    }
}
