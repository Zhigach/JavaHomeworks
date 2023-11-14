package seminars.fourth.book;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookServiceTest {
    static BookService bookService;
    static BookRepository bookRepositoryMock;
    @BeforeAll
    public static void globalSetUp(){
        bookRepositoryMock = mock(BookRepository.class);
        bookService = new BookService(bookRepositoryMock);
    }
    @Test
    void findBookById() {
        Book book1 = new Book("1");
        Book book2 = new Book("2");
        doReturn(book1).when(bookRepositoryMock).findById("1"); // задаем поведение мока
        Book result = bookService.findBookById("1"); // вызываем интересующую функцию
        assertEquals(book1, result); // проверяем метод класса BookService
        //verify(bookRepositoryMock).findById("1"); // проверяем что вызов случился с нужным ответом
    }

    @Test
    void findAllBooks() {
        Book book1 = new Book("1");
        Book book2 = new Book("2");
        doReturn(Arrays.asList(book1,book2)).when(bookRepositoryMock).findAll(); // задаем поведение мока
        List<Book> allBooks = Arrays.asList(book1, book2);
        assertArrayEquals(allBooks.toArray(), bookService.findAllBooks().toArray());
    }
}