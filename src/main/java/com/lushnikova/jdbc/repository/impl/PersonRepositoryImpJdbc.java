package com.lushnikova.jdbc.repository.impl;

import com.lushnikova.jdbc.mapper.PersonMapper;
import com.lushnikova.jdbc.model.Person;
import com.lushnikova.jdbc.repository.PersonRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonRepositoryImpJdbc implements PersonRepository {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/spring";
    private static final String USER = "lera";
    private static final String PASS = "lera";
    private static final String SELECT_BY_ID_SQL_QUERY = "select * from people where id = ?";
    private static final String SELECT_ALL_SQL_QUERY = "select * from people ";

    private final Connection connection;

    public PersonRepositoryImpJdbc() throws SQLException {
        this.connection = DriverManager.getConnection(DB_URL, USER, PASS);
    }

    @Override
    public Person getPeronById(Long id) {
        try {
            PreparedStatement selectStatement = connection.prepareStatement(SELECT_BY_ID_SQL_QUERY);
            selectStatement.setLong(1, id);
            ResultSet rs = selectStatement.executeQuery();
            rs.next();

            long personId = rs.getLong("id");
            int age = rs.getInt("age");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");

            return new Person(personId, age, firstName, lastName);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Person> getAllPersons() {
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_SQL_QUERY);
            PersonMapper personMapper = new PersonMapper();

            List<Person> persons = new ArrayList<>();
            int i = 0;
            while (resultSet.next()) {
                persons.add(personMapper.mapRow(resultSet, i++));
            }
            return persons;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deletePerson(Person person) {
        String deleteQuery = "delete from people where id = ?";;

        try {
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);

            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setLong(1, person.getId());
            preparedStatement.execute();

            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        return false;
    }

    @Override
    public boolean updatePerson(Person person) {
        return false;
    }

    @Override
    public boolean createPerson(Person person) {
        return false;
    }
}
