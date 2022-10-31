package by.g00dc4t.spring.library.dao;

import by.g00dc4t.spring.library.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class PeopleDAOImpl extends LibraryGenericDAO<Person> {
    private static final String FROM_QUERY = "from Person";
    private static final String DELETE_FROM_QUERY = "delete from Person where id =:peopleId";
    private static final String DELETE_PARAM = "peopleId";

    public PeopleDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    protected Query<Person> getQueryGetAll() {
        return sessionFactory.getCurrentSession().createQuery(FROM_QUERY, Person.class);
    }

    @Override
    protected Query<Person> getQueryDelete() {
        Session session = sessionFactory.getCurrentSession();
        Query<Person> query = session.createQuery(DELETE_FROM_QUERY);
        return query;
    }

    @Override
    protected String getDeleteParam() {
        return DELETE_PARAM;
    }

    @Override
    protected Class<Person> getEntityClass() {
        return Person.class;
    }
}
