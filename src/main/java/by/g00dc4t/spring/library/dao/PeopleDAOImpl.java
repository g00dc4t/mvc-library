package by.g00dc4t.spring.library.dao;

import by.g00dc4t.spring.library.entity.People;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PeopleDAOImpl implements PeopleDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public List<People> getAllPeople() {
        Session session = sessionFactory.getCurrentSession();
        List<People> people = session.createQuery("from People", People.class).getResultList();
        return people;
    }

    public void savePeople(People people) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(people);
    }

    public People getPeople(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(People.class, id);
    }

    public void deletePeople(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<People> query = session.createQuery("delete from People where id =:peopleId");
        query.setParameter("peopleId", id);
        query.executeUpdate();
    }
}
