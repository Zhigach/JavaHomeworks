package ru.geekbrains.bookStore.book_store.controller;

import lombok.AllArgsConstructor;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.bookStore.book_store.model.Book;
import ru.geekbrains.bookStore.book_store.service.BookStoreService;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/books")
public class BookStoreRestController {
    private BookStoreService bookStoreService;

    @GetMapping
    public List<Book> findAll() {
        return bookStoreService.finAllBooks();
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        return new ResponseEntity<>(bookStoreService.addBook(book), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findBookById(@PathVariable Long id) {
        Optional<Book> book = bookStoreService.findBookById(id);
        return book.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBookInfo(@PathVariable Long id, @RequestBody Book book) {
        Optional<Book> updatedBook = bookStoreService.updateBookInfoById(id, book);
        return updatedBook.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBookById(@PathVariable Long id) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
