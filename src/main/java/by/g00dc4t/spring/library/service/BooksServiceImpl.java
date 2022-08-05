package by.g00dc4t.spring.library.service;

import by.g00dc4t.spring.library.dao.LibraryGenericDAO;
import by.g00dc4t.spring.library.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BooksServiceImpl implements BooksService {
    @Autowired
    private LibraryGenericDAO<Book> booksDAO;

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
        return booksDAO.get(id);
    }

    @Transactional
    public void deleteBook(int id) {
        booksDAO.delete(id);
    }
}