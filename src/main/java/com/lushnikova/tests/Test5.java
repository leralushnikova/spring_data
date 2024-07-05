package com.lushnikova.tests;

import com.lushnikova.jpa.config.AppConfig;
import com.lushnikova.jpa.model.Person;
import com.lushnikova.jpa.service.PersonService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;


public class Test5 {
    private static Random random = new Random();
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        PersonService personService = context.getBean(PersonService.class);

        for (int i = 0; i < 10; i++) {
            Person person = Person.builder()
                    .firstName("John"+(i+1))
                    .lastName("Doe"+(i+1))
                    .age(random.nextInt(100))
                    .build();
            personService.savePerson(person);
        }
        context.close();
    }
}

/*
        //200-250
        var pageable = PageRequest.of(5, 50);
        //100-150 + сортировка
        var sort = Sort.by(ASC, "first_name");
        var sortHard = Sort.by("last_name").and(Sort.by("first_name"));
        var pageableWithSort = PageRequest.of(5, 50, sort);*/
