package com.lushnikova.jdbc_spring.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table("people")
public class Person {
    @Id
    private Long id;
    private Integer age;
    private String firstName;
    private String lastName;
}
