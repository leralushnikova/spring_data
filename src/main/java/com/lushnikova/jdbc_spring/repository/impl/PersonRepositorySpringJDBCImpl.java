package com.lushnikova.jdbc_spring.repository.impl;

import com.lushnikova.jdbc_spring.mapper.PersonMapper;
import com.lushnikova.jdbc_spring.model.Person;
import com.lushnikova.jdbc_spring.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PersonRepositorySpringJDBCImpl implements PersonRepository {

    private final JdbcTemplate jdbcTemplate;
    private final TransactionTemplate template;

    private final String SQL_FIND_PERSON = "select * from people where id = ?";
    private final String SQL_DELETE_PERSON = "delete from people where id = ?";
    private final String SQL_UPDATE_PERSON = "update from people where first_name = ?, last_name = ?, age = ? where id = ?";
    private final String SQL_GET_ALL = "select * from people";
    private final String SQL_INSERT_PERSON = "insert into people (id, first_name, last_name, age) values (?, ?, ?, ?)";

    @Override
    public Person getPeronById(Long id) {
        return jdbcTemplate.queryForObject(SQL_FIND_PERSON, new Object[]{id}, new PersonMapper());
    }

    @Override
    public List<Person> getAllPersons() {
        return jdbcTemplate.query(SQL_GET_ALL, new PersonMapper());
    }

    @Override
    public boolean deletePerson(Person person) {
        return template.execute(status -> jdbcTemplate.update(SQL_DELETE_PERSON,person.getId()) > 0);
    }

    @Override
    public boolean updatePerson(Person person) {
        return jdbcTemplate.update(SQL_UPDATE_PERSON, person.getFirstName(), person.getLastName(), person.getAge(), person.getId()) > 0;
    }

    @Override
    public boolean createPerson(Person person) {
        return jdbcTemplate.update(SQL_INSERT_PERSON, person.getId(), person.getFirstName(), person.getLastName(), person.getAge()) > 0;
    }
}
