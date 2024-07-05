package com.lushnikova.jdbc_spring.config;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.relational.core.mapping.event.RelationalEvent;

@Configuration
public class EntityListenerConfig {

    @Bean
    public ApplicationListener<?> loggingListener() {
        return (ApplicationListener<ApplicationEvent>) event -> {
            if (event instanceof RelationalEvent) {
               /* if (((RelationalEvent<?>) event).getType().equals(Person.class)) {
                    Person obj = (Person) ((RelationalEvent<?>) event).getEntity();
                    obj.setUpdateDatetime(LocalDate.now());
                    можно залезть в логику класса Person  и обновить данные
                }*/
                System.out.println("Received an event: " + event);
            }
        };
    }
}