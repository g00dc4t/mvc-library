package by.g00dc4t.spring.library.service;

import by.g00dc4t.spring.library.entity.Person;

import java.util.List;

public interface PersonService {
    List<Person> getAllPersons();

    void savePerson(Person people);

    Person getPerson(int id);

    void deletePerson(int id);
}
