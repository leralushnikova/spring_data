package com.lushnikova.jpa.service;

import com.lushnikova.jpa.dto.PageDTO;
import com.lushnikova.jpa.dto.PersonDTO;
import com.lushnikova.jpa.model.Person;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface PersonService {
    List<PersonDTO> findByName(String name);

    void savePerson(Person person);

    void updateLastName(Long id, String newLastName);

    PageDTO<Person> findAll(int page, int size, Sort sort);
}
