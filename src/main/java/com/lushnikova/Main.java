package com.lushnikova;


import com.lushnikova.jpa.config.AppConfig;
import com.lushnikova.jpa.service.PersonService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.PageRequest;


public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        PersonService personService = context.getBean(PersonService.class);
        System.out.println(personService.findAll(PageRequest.of(0, 10)));
        context.close();
    }
}