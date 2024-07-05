package com.lushnikova.jpa.model;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "people")
//@SequenceGenerator(name = "people_id_generator", sequenceName = "people_id_seq")
//@NamedQuery(name = "Person.findById",
//query = "select p from Person p where p.id = :id ")
public class Person {
    @Id
    @GeneratedValue/*(strategy = GenerationType.SEQUENCE, generator = "people_id_generator")*/
    private Long id;

    private Integer age;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
}