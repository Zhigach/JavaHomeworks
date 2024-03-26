package ru.geekbrains.TaskServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.TaskServer.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
