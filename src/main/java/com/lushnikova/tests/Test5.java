package com.lushnikova.tests;

import com.lushnikova.jpa.config.AppConfig;
import com.lushnikova.jpa.model.entity.Person;
import com.lushnikova.jpa.service.PersonService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;


public class Test5 {
    private static final Random random = new Random();
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        PersonService personService = context.getBean(PersonService.class);

        for (long i = 11; i <= 100; i++) {
            Person person = Person.builder()
                    .firstName("John"+(i))
                    .lastName("Doe"+(i))
                    .age(random.nextInt(100))
                    .build();
//            personService.save(person);
        }
        context.close();
    }
}

