package by.g00dc4t.spring.library.service;

import by.g00dc4t.spring.library.entity.People;

import java.util.List;

public interface PeopleService {
    List<People> getAllPeople();

    void savePeople(People people);

    People getPeople(int id);

    void deletePeople(int id);
}
