package by.g00dc4t.spring.library.service;

import by.g00dc4t.spring.library.dao.LibraryGenericDAO;
import by.g00dc4t.spring.library.entity.Book;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BooksServiceImpl implements BooksService {
    private final LibraryGenericDAO<Book> booksDAO;

    public BooksServiceImpl(LibraryGenericDAO<Book> booksDAO) {
        this.booksDAO = booksDAO;
    }

    @Transactional
    public List<Book> getAllBooks() {
        return booksDAO.getAll();
    }

    @Transactional
    public void saveBook(Book book) {
        booksDAO.save(book);
    }

    @Transactional
    public Book getBook(int id) {
        Book result = null;
        Optional<Book> optionalBook = booksDAO.get(id);
        if (optionalBook.isPresent()) {
            result = optionalBook.get();
        }
        return result;
    }

    @Transactional
    public void deleteBook(int id) {
        booksDAO.delete(id);
    }
}
