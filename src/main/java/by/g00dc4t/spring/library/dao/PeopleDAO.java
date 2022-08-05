package by.g00dc4t.spring.library.dao;

import by.g00dc4t.spring.library.entity.People;

import java.util.List;

public interface PeopleDAO {
    List<People> getAllPeople();

    void savePeople(People people);

    People getPeople(int id);

    void deletePeople(int id);
}
