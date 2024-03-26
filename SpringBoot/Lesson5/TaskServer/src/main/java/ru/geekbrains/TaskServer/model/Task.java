package ru.geekbrains.TaskServer.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name="tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "status", nullable = false)
    @Enumerated
    private Status status;

    @Column(name = "creation_time", nullable = false)
    private LocalDateTime creationDate;

    @Column(name = "completion_time")
    private LocalDateTime completionDate;

    public Task() {
    }

    public Task(String description) {
        this.description = description;
    }

}
