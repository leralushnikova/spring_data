package com.lushnikova.tests;

import com.lushnikova.jdbc_spring.config.AppConfig;
import com.lushnikova.jdbc_spring.repository.PersonSpringJdbcRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test3 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        PersonSpringJdbcRepository repository = context.getBean(PersonSpringJdbcRepository.class);

        System.out.println(repository.findById(3L));

        context.close();
    }
}
