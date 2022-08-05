package by.g00dc4t.spring.library.dao;

import by.g00dc4t.spring.library.entity.Book;

import java.util.List;

public interface BooksDAO {
    List<Book> getAllBooks();

    void saveBook(Book book);

    Book getBook(int id);

    void deleteBook(int id);
}
