package ru.geekbrains.note_service.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.note_service.model.Note;
import ru.geekbrains.note_service.service.NotesService;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/notes")
public class NotesController {
    private NotesService notesService;

    @GetMapping
    public List<Note> findAll() {
        return notesService.finAllBooks();
    }

    @PostMapping
    public ResponseEntity<Note> addNote(@RequestBody Note note) {
        return new ResponseEntity<>(notesService.addNote(note), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> findNoteById(@PathVariable Long id) {
        Optional<Note> book = notesService.findBookById(id);
        return book.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNoteInfo(@PathVariable Long id, @RequestBody Note note) {
        Optional<Note> updatedNote = notesService.updateNoteInfoById(id, note);
        return updatedNote.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNoteById(@PathVariable Long id) {
        notesService.deleteBookById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
