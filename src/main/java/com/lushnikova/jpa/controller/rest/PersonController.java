package com.lushnikova.jpa.controller.rest;

import com.lushnikova.jpa.dto.PageDTO;
import com.lushnikova.jpa.dto.PersonDTO;
import com.lushnikova.jpa.model.command.PersonCommand;
import com.lushnikova.jpa.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @RequestMapping(value = "/people", method = RequestMethod.GET)
    public PageDTO<PersonDTO> getPeople(@RequestParam(value = "size", defaultValue = "10") int size,
                                        @RequestParam(value = "page", defaultValue = "0") int page) {
        return personService.findAll(PageRequest.of(page, size));
    }

    /*@GetMapping("/people")
    public PageDTO<PersonDTO> getPeople(@PageableDefault(size = 10, page = 0) Pageable pageable) {
        return personService.findAll(pageable);
    }
*/

    @GetMapping("/people/{id}")
    public ResponseEntity<PersonDTO> getPerson(@PathVariable(name = "id") Long id) {
        return personService.findById(id)
                .map(personDTO -> new ResponseEntity<>(personDTO, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/people", method = RequestMethod.POST)
    //@PostMapping("/people")
    public ResponseEntity<PersonDTO> createPerson(@RequestBody PersonCommand personCommand) {
        var createdPerson = personService.save(personCommand);
        return new ResponseEntity<>(createdPerson, HttpStatus.CREATED);
    }


    @RequestMapping(value = "/people/{id}", method = RequestMethod.PUT)
    //@PutMapping("/people/{id}")
    public ResponseEntity<PersonDTO> updatePerson(@PathVariable("id") Long id, @RequestBody PersonCommand personCommand) {
        return personService.update(id, personCommand)
                .map(personDTO -> new ResponseEntity<>(personDTO, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/people/{id}", method = RequestMethod.DELETE)
    //@DeleteMapping("/people/{id}")
    public ResponseEntity<PersonDTO> deletePerson(@PathVariable("id") Long id) {
        personService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
