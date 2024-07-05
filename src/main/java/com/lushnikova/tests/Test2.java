package com.lushnikova.tests;

import com.lushnikova.jdbc_spring.config.AppConfig;
import com.lushnikova.jdbc_spring.repository.PersonRepository;
import com.lushnikova.jdbc_spring.repository.impl.PersonRepositorySpringJDBCImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        PersonRepository repository = context.getBean(PersonRepositorySpringJDBCImpl.class);
        System.out.println(repository.getAllPersons());

        context.close();
    }
}
