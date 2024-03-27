package ru.geekbrains.bookStore.book_store.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.bookStore.book_store.model.Book;
import ru.geekbrains.bookStore.book_store.repository.JPABookRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@AllArgsConstructor
@Service
public class BookStoreService {
    private JPABookRepository bookRepository;

    public List<Book> finAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> findBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Optional<Book> updateBookInfoById(Long id, Book book) {
        if (book.getId() == null || Objects.equals(book.getId(), id)) {
            book.setId(id);
            return Optional.of(bookRepository.save(book));
        } else {
            return Optional.empty();
        }
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

}
