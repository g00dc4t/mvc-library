package by.g00dc4t.spring.library.dao;

import by.g00dc4t.spring.library.entity.Person;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class PeopleDAOImpl extends LibraryGenericDAO<Person> {
    @Override
    protected Query<Person> getQueryGetAll() {
        return sessionFactory.getCurrentSession().createQuery("from Person", Person.class);
    }

    @Override
    protected Query<Person> getQueryDelete() {
        Session session = sessionFactory.getCurrentSession();
        Query<Person> query = session.createQuery("delete from Person where id =:peopleId");
        return query;
    }

    @Override
    protected String getDeleteParam() {
        return "peopleId";
    }

    @Override
    protected Class<Person> getEntityClass() {
        return Person.class;
    }
}
