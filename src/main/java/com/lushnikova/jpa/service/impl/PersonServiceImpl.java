package com.lushnikova.jpa.service.impl;

import com.lushnikova.jpa.dto.PageDTO;
import com.lushnikova.jpa.dto.PersonDTO;
import com.lushnikova.jpa.dto.dto2.PersonDTO2;
import com.lushnikova.jpa.mapper.PersonMapper;
import com.lushnikova.jpa.model.command.PersonCommand;
import com.lushnikova.jpa.repository.PersonRepository;
import com.lushnikova.jpa.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    @Transactional
    public Optional<PersonDTO> findById(Long id) {
        log.info("Finding person by id {}", id);
        var person = personRepository.findById(id);
        if (person.isPresent()) {
            log.info("Found person with id {}", id);
            return person.map(personMapper::toDTO);
        }
        log.info("Person with id {} not found", id);
        return Optional.empty();
    }

    @Override
    public PageDTO<PersonDTO> findAll(Pageable pageable) {
        var result = personRepository.findAllBy(pageable);
        return new PageDTO<>(result, pageable);
    }

    @Transactional
    @Override
    public PersonDTO save(PersonCommand personCommand) {
        log.info("Trying to saving person {}", personCommand);
        var personToSave = personMapper.toEntity(personCommand);
        var person = personRepository.save(personToSave);
        log.info("Saved person {}", person);
        return personMapper.toDTO(person);
    }

    @Transactional
    @Override
    public Optional<PersonDTO> update(Long id, PersonCommand personCommand) {
        var optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()) {
            log.info("Updating person with id {}", id);
            var person = optionalPerson.get();
            personMapper.update(person, personCommand);
            return Optional.of(personMapper.toDTO(personRepository.save(person)));
        }
        log.info("Person with id {} not found", id);
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {
        log.info("Deleting person with id {}", id);
        personRepository.deleteById(id);
    }

    /*@Override
    public PageDTO<PersonDTO> findAllBy(int page, int size, Sort sort) {
        var pageable = PageRequest.of(page, size, sort);
        var result = personRepository.findAllBy(pageable);
        return new PageDTO<>(result, pageable);
    }*/

    /*@Override
    public PageDTO<Person> findAllBy(int page, int size, Sort sort) {
        var pageable = PageRequest.of(page, size, sort);
        var result = personRepository.findAllByPage(pageable);
        return new PageDTO<>(result, pageable);
    }*/

    /*@Override
    @Transactional
    public SliceDTO<PersonDTO3> findAllBy(int page, int size, Sort sort) {
        var pageable = PageRequest.of(page, size, sort);
        var result = personRepository.findAllBy(pageable);
        return new SliceDTO<>(result, pageable);
    }*/

    /*@Override
    @Transactional
    public SliceDTO<Person> findAllBy(int page, int size, Sort sort) {
        var pageable = PageRequest.of(page, size, sort);
        var result = personRepository.findAllBy(pageable);
        return new SliceDTO<>(result, pageable);
    }*/

    /*@Override
    public List<PersonDTO> findAll() {
        return personRepository.findAll().stream().map(personMapper::toDTO).toList();
    }*/

}
