package ru.geekbrains.note_service.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.note_service.model.Note;
import ru.geekbrains.note_service.repository.JPANoteRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@AllArgsConstructor
@Service
public class NotesService {
    private JPANoteRepository bookRepository;

    public List<Note> finAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Note> findBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Note addNote(Note note) {
        note.setCreationDate(LocalDateTime.now());
        return bookRepository.save(note);
    }

    public Optional<Note> updateNoteInfoById(Long id, Note note) {
        if (note.getId() == null || Objects.equals(note.getId(), id)) {
            note.setId(id);
            return Optional.of(bookRepository.save(note));
        } else {
            return Optional.empty();
        }
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

}
