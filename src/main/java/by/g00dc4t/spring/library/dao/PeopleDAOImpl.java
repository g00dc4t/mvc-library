package by.g00dc4t.spring.library.dao;

import by.g00dc4t.spring.library.entity.People;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class PeopleDAOImpl extends LibraryGenericDAO<People> {
    @Override
    protected Query<People> getQueryGetAll() {
        return sessionFactory.getCurrentSession().createQuery("from People", People.class);
    }

    @Override
    protected Query<People> getQueryDelete() {
        Session session = sessionFactory.getCurrentSession();
        Query<People> query = session.createQuery("delete from People where id =:peopleId");
        return query;
    }

    @Override
    protected String getDeleteParam() {
        return "peopleId";
    }

    @Override
    protected Class<People> getEntityClass() {
        return People.class;
    }
}
