package by.g00dc4t.spring.library.service;

import by.g00dc4t.spring.library.dao.LibraryGenericDAO;
import by.g00dc4t.spring.library.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private LibraryGenericDAO<Person> personDAO;

    @Transactional
    public List<Person> getAllPersons() {
        return personDAO.getAll();
    }

    @Transactional
    public void savePerson(Person people) {
        personDAO.save(people);
    }

    @Transactional
    public Person getPerson(int id) {
        return personDAO.get(id);
    }

    @Transactional
    public void deletePerson(int id) {
        personDAO.delete(id);
    }
}
