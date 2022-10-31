package by.g00dc4t.spring.library.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public abstract class LibraryGenericDAO<T> {

    protected SessionFactory sessionFactory;

    public LibraryGenericDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected abstract Query<T> getQueryGetAll();

    protected abstract Query<T> getQueryDelete();

    protected abstract String getDeleteParam();

    protected abstract Class<T> getEntityClass();

    public List<T> getAll() {
        List<T> books = getQueryGetAll().getResultList();
        return books;
    }

    public void save(T entity) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(entity);
    }

    public Optional<T> get(int id) {
        Session session = sessionFactory.getCurrentSession();
        return Optional.of(session.get(getEntityClass(), id));
    }

    public void delete(int id) {
        Query<T> query = getQueryDelete();
        query.setParameter(getDeleteParam(), id);
        query.executeUpdate();
    }
}
