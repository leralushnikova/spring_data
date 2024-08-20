package com.lushnikova.jpa.service;

import com.lushnikova.jpa.dto.PageDTO;
import com.lushnikova.jpa.dto.PersonDTO;
import com.lushnikova.jpa.model.command.PersonCommand;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PersonService {

    Optional<PersonDTO> findById(Long id);

    PageDTO<PersonDTO> findAll(Pageable pageable);

    PersonDTO save(PersonCommand personCommand);

    Optional<PersonDTO> update(Long id, PersonCommand personCommand);

    void delete(Long id);

//    List<PersonDTO> findByName(String name);
//
//    void savePerson(Person person);
//
//    void updateLastName(Long id, String newLastName);
//
////    PageDTO<Person> findAllBy(int page, int size, Sort sort);
//    PageDTO<PersonDTO> findAllBy(int page, int size, Sort sort);
//
////    SliceDTO<Person> findAllBy(int page, int size, Sort sort);
////    SliceDTO<PersonDTO3> findAllBy(int page, int size, Sort sort);
//
//    List<PersonDTO> findAll();
//
//    Page<PersonDTO> findAll(Pageable pageable);
}
