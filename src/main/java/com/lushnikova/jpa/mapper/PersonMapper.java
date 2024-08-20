package com.lushnikova.jpa.mapper;

import com.lushnikova.jpa.dto.PersonDTO;
import com.lushnikova.jpa.model.entity.Person;
import com.lushnikova.jpa.model.command.PersonCommand;
import org.mapstruct.*;

/*@Component
public class PersonMapper {
    public PersonDTO toDto(Person person) {
        return PersonDTO.builder()
                .age(person.getAge())z
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .build();

    }
}*/
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PersonMapper {
    PersonDTO toDTO(Person person);

//    @Mapping(target = "age", expression = "java(new java.util.Random().nextInt(100))")
    Person toEntity(PersonCommand personCommand);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void update(@MappingTarget Person entity, PersonCommand updateEntity);

}
