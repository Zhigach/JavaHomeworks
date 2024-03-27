package ru.geekbrains.bookStore.book_store.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.bookStore.book_store.model.Book;

@Repository
@Primary
public interface JPABookRepository extends JpaRepository<Book, Long> {
}
