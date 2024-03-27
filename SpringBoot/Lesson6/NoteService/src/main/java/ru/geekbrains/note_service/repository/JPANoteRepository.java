package ru.geekbrains.note_service.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.note_service.model.Note;

@Repository
@Primary
public interface JPANoteRepository extends JpaRepository<Note, Long> {
}
