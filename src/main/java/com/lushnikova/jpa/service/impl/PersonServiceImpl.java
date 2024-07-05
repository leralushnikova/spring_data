package com.lushnikova.jpa.service.impl;

import com.lushnikova.jpa.dto.PageDTO;
import com.lushnikova.jpa.dto.PersonDTO;
import com.lushnikova.jpa.mapper.PersonMapper;
import com.lushnikova.jpa.model.Person;
import com.lushnikova.jpa.repository.PersonRepository;
import com.lushnikova.jpa.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    @Override
    @Transactional
    public List<PersonDTO> findByName(String name) {
        log.info("Find person by name: " + name);
        return personRepository.findByFirstName(name)
                .stream()
                .map(personMapper::toDto)
                .toList();
    }

    /*@Transactional
    public List<Person> findByFirstName(String firstName) {
        return personRepository.findByFirstName(firstName);
    }

    @Transactional
    public Optional<Person> findById(Long id) {
        return personRepository.findById(id);
    }

    @Transactional
    public void deleteById(Long id) {
        personRepository.findById(id).ifPresent(personRepository::delete);
    }*/

    @Override
    @Transactional
    public void savePerson(Person person) {
        log.info("Trying to save person: " + person);

        personRepository.save(person);
    }

    @Override
    @Transactional
    public void updateLastName(Long id, String newLastName) {
        log.info("Trying to update person with id: " + id);
        var person = personRepository.findById(id);
        if(person.isPresent()){
            log.info("Trying to update person with id: " + id);
            personRepository.updateLastName(id, newLastName);
        } else {
            log.info("Person not found with id: " + id);
        }
    }

    @Override
    public PageDTO<Person> findAll(int page, int size, Sort sort) {
        var pageable = PageRequest.of(page, size, sort);
        var result = personRepository.findAllBy(pageable);
        return new PageDTO<>(result, pageable);
    }
}
