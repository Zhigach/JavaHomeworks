package ru.geekbrains.TaskServer.services;

import org.springframework.stereotype.Service;
import ru.geekbrains.TaskServer.model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TaskService {
    private final List<Task> taskList = new ArrayList<>();

    public List<Task> getAllTasks() {
        return taskList;
    }

    public Task getTask(UUID uuid) {
        return taskList.stream().filter(t -> t.getUuid().equals(uuid)).findFirst().orElse(null);
    }

    public Task addTask(Task task) {
        taskList.add(task);
        return task;
    }

    public void deleteTask(UUID uuid) {
        taskList.removeIf(t -> t.getUuid().equals(uuid));
    }

    public Task updateTask(UUID uuid, Task task) {
        Task oldTask = getTask(uuid);
        if (oldTask != null) {
            oldTask.setDescription(task.getDescription());
            oldTask.setName(task.getName());
            oldTask.setStatus(task.getStatus());
        }
        return oldTask;
    }


}
