package com.lushnikova.tests;

import com.lushnikova.jpa.config.AppConfig;
import com.lushnikova.jpa.model.Person;
import com.lushnikova.jpa.repository.PersonRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;

public class Test4 {
    public static Random rand = new Random();
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        PersonRepository repository = context.getBean(PersonRepository.class);
        for (int i = 0; i < 1000; i++) {
            Person person = Person.builder()
                    .age(rand.nextInt(100))
                    .firstName("Lera" + i)
                    .lastName("Nem" + i)
                    .build();
            repository.save(person);
        }
        context.close();
    }
}
