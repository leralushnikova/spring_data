package com.lushnikova.jdbc_spring.repository;

import com.lushnikova.jdbc_spring.model.Person;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

@Repository
public interface PersonSpringJdbcRepository extends CrudRepository<Person, Long> {

    List<Person> findByFirstName(String firstName);

    Person findByFirstNameAndLastName(String firstName, String lastName);

    Person findFistByLastName(String lastName);

    @Query("SELECT * FROM people WHERE last_name = :lastname")
    List<Person> findByLastName(String lastName);

    @Query("SELECT * FROM people WHERE last_name = :lastname")
    Stream<Person> findByLastNameContaining(String lastName);

}
