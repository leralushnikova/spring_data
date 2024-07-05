package com.lushnikova.jdbc_spring.repository;

import com.lushnikova.jdbc_spring.model.Person;

import java.util.List;

public interface PersonRepository {
    Person getPeronById(Long id);

    List<Person> getAllPersons();

    boolean deletePerson(Person person);

    boolean updatePerson(Person person);

    boolean createPerson(Person person);
}
