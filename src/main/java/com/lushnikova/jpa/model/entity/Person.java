package com.lushnikova.jpa.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "people")
@SequenceGenerator(name = "people_id_generator", sequenceName = "people_id_seq", allocationSize = 1)
//@NamedQuery(name = "Person.findById",
//query = "select p from Person p where p.id = :id ")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "people_id_generator")
    private Long id;

    private Integer age;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birthdate")
    private LocalDate birthday;
}