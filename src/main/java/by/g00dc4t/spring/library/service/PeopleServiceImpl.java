package by.g00dc4t.spring.library.service;

import by.g00dc4t.spring.library.dao.PeopleDAO;
import by.g00dc4t.spring.library.entity.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PeopleServiceImpl implements PeopleService {
    @Autowired
    private PeopleDAO peopleDAO;

    @Transactional
    public List<People> getAllPeople() {
        return peopleDAO.getAllPeople();
    }

    @Transactional
    public void savePeople(People people) {
        peopleDAO.savePeople(people);
    }

    @Transactional
    public People getPeople(int id) {
        return peopleDAO.getPeople(id);
    }

    @Transactional
    public void deletePeople(int id) {
        peopleDAO.deletePeople(id);
    }
}
