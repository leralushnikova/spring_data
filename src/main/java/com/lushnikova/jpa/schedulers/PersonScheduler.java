package com.lushnikova.jpa.schedulers;

import com.lushnikova.jpa.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonScheduler {
    private final PersonRepository personRepository;

    /*@Async
    @Scheduled(cron = "0/5 * * ? * *")
    public void createPerson(){
        Person person = new Person();
        person.setAge(100);
        person.setFirstName("John");
        person.setLastName("Smith");

        personRepository.save(person);
    }*/


}
