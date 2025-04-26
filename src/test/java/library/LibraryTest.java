package library;

import org.example.library.Book;
import org.example.library.Library;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    @Test
    public void testAddBookAndFindBook() {
        Library library = new Library();
        Book book = new Book("1984", "Джордж Оруэлл");
        library.addBook(book);
        assertEquals(book, library.findBookByTitle("1984"));
    }

    @Test
    public void testBorrowBook() {
        Book book = new Book("Маленький принц", "Антуан де Сент-Экзюпери");
        book.borrow();
        assertFalse(book.isAvailable());
    }

    @Test
    public void testReturnBook() {
        Book book = new Book("Гарри Поттер", "Дж. К. Роулинг");
        book.borrow();
        book.returnBook();
        assertTrue(book.isAvailable());
    }

    @Test
    public void testBorrowAlreadyBorrowedBook() {
        Book book = new Book("Тестовая книга", "Автор");
        book.borrow();
        Exception exception = assertThrows(IllegalStateException.class, book::borrow);
        assertEquals("Книга уже занята!", exception.getMessage());
    }

    @Test
    public void testReturnAlreadyReturnedBook() {
        Book book = new Book("Тестовая книга", "Автор");
        Exception exception = assertThrows(IllegalStateException.class, book::returnBook);
        assertEquals("Книга уже возвращена!", exception.getMessage());
    }
}

