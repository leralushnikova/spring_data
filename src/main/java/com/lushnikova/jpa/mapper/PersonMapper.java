package com.lushnikova.jpa.mapper;

import com.lushnikova.jpa.dto.PersonDTO;
import com.lushnikova.jpa.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/*@Component
public class PersonMapper {
    public PersonDTO toDto(Person person) {
        return PersonDTO.builder()
                .age(person.getAge())
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .build();

    }
}*/
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PersonMapper {
    PersonDTO toDto(Person person);
}
