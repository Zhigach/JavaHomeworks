package ru.geekbrains.TaskServer.model;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class Task {
    enum Status{
        TO_DO,
        IN_PROGRESS,
        DONE
    }
    private final UUID uuid;
    private String name;
    private String description;
    private Status status;
    private LocalDateTime creationDate;
    private LocalDateTime completionDate;

    public Task(String name, String description) {
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.status = Status.TO_DO;
        this.creationDate = LocalDateTime.now();
    }
}
