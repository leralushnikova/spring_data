package com.lushnikova.tests;

import com.lushnikova.jpa.config.AppConfig;
import com.lushnikova.jpa.repository.PersonRepository;
import com.lushnikova.jpa.service.PersonService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test7 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        PersonService personService = context.getBean(PersonService.class);
//        var result = personService.findAll();
//        System.out.println(result);
        context.close();
    }
}
