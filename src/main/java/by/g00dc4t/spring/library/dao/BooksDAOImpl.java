package by.g00dc4t.spring.library.dao;

import by.g00dc4t.spring.library.entity.Book;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class BooksDAOImpl extends LibraryGenericDAO<Book> {
    @Override
    protected Query<Book> getQueryGetAll() {
        return sessionFactory.getCurrentSession().createQuery("from Book", Book.class);
    }

    @Override
    protected Query<Book> getQueryDelete() {
        Session session = sessionFactory.getCurrentSession();
        Query<Book> query = session.createQuery("delete from Book where id =:bookId");
        return query;
    }

    @Override
    protected String getDeleteParam() {
        return "bookId";
    }

    @Override
    protected Class<Book> getEntityClass() {
        return Book.class;
    }
}
