package com.lushnikova.jpa.controller.web;

import com.lushnikova.jpa.model.command.PersonCommand;
import com.lushnikova.jpa.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/persons")
public class PersonWebController {

    private final PersonService personService;

    @GetMapping
    public ModelAndView greetingsBye(ModelAndView modelAndView) {
        modelAndView.setViewName("people");
        modelAndView.addObject("persons", personService.findAll(Pageable.ofSize(10)).getContent());
        return modelAndView;
    }

    @GetMapping("/new")
    public ModelAndView showCreateForm(ModelAndView model) {
        model.addObject("person", new PersonCommand());
        model.setViewName("person_form");
        return model;
    }

    @PostMapping("/save")
    public ModelAndView savePerson(PersonCommand person) {
        if (person.getId() != null) {
            log.info("Updating person");
            personService.update(person.getId(), person);
        } else {
            log.info("Saving person");
            personService.save(person);
        }
        return new ModelAndView("redirect:/persons");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable("id") Long id, ModelAndView modelAndView) {
        var person = personService.findById(id);
        if (person.isPresent()) {
            modelAndView.addObject("person", person.get());
            modelAndView.setViewName("person_form");
        } else {
            modelAndView.setViewName("redirect:/persons");
        }
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable("id") Long id) {
        personService.delete(id);
        return "redirect:/persons";
    }
}