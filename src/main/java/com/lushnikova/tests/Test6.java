package com.lushnikova.tests;

import com.lushnikova.jpa.config.AppConfig;
import com.lushnikova.jpa.service.PersonService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Sort;

public class Test6 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        PersonService personService = context.getBean(PersonService.class);
        var sort = Sort.by(Sort.Direction.DESC, "firstName")
                .and(Sort.by(Sort.Direction.DESC, "lastName"));
//        var result = personService.findAllBy(1, 10, sort);
//        System.out.println(result);

        context.close();
    }
}
