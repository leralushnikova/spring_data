package com.lushnikova.tests;

import com.lushnikova.jdbc.repository.PersonRepository;
import com.lushnikova.jdbc.repository.impl.PersonRepositoryImpJdbc;

import java.sql.SQLException;

public class Test1 {
    public static void main(String[] args) throws SQLException {
        PersonRepository repository = new PersonRepositoryImpJdbc();
        System.out.println(repository.getAllPersons());
    }
}
