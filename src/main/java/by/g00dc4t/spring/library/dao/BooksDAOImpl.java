package by.g00dc4t.spring.library.dao;

import by.g00dc4t.spring.library.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class BooksDAOImpl extends LibraryGenericDAO<Book> {
    private static final String FROM_QUERY = "from Book";
    private static final String DELETE_FROM_QUERY = "delete from Book where id =:bookId";
    private static final String DELETE_PARAM = "bookId";

    public BooksDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    protected Query<Book> getQueryGetAll() {
        return sessionFactory.getCurrentSession().createQuery(FROM_QUERY, Book.class);
    }

    @Override
    protected Query<Book> getQueryDelete() {
        Session session = sessionFactory.getCurrentSession();
        Query<Book> query = session.createQuery(DELETE_FROM_QUERY);
        return query;
    }

    @Override
    protected String getDeleteParam() {
        return DELETE_PARAM;
    }

    @Override
    protected Class<Book> getEntityClass() {
        return Book.class;
    }
}
