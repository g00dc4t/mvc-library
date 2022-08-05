package by.g00dc4t.spring.library.service;

import by.g00dc4t.spring.library.dao.BooksDAO;
import by.g00dc4t.spring.library.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BooksServiceImpl implements BooksService {
    @Autowired
    private BooksDAO booksDAO;

    @Transactional
    public List<Book> getAllBooks() {
        return booksDAO.getAllBooks();
    }

    @Transactional
    public void saveBook(Book book) {
        booksDAO.saveBook(book);
    }

    @Transactional
    public Book getBook(int id) {
        return booksDAO.getBook(id);
    }

    @Transactional
    public void deleteBook(int id) {
        booksDAO.deleteBook(id);
    }
}
