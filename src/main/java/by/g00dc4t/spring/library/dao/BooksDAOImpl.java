package by.g00dc4t.spring.library.dao;

import by.g00dc4t.spring.library.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BooksDAOImpl implements BooksDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public List<Book> getAllBooks() {
        Session session = sessionFactory.getCurrentSession();
        List<Book> books = session.createQuery("from Book", Book.class).getResultList();
        return books;
    }

    public void saveBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(book);
    }

    public Book getBook(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Book.class, id);
    }

    public void deleteBook(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Book> query = session.createQuery("delete from Book where id =:bookId");
        query.setParameter("bookId", id);
        query.executeUpdate();
    }
}
