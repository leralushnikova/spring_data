package com.lushnikova.jdbc.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Person {
    private Long id;
    private Integer age;
    private String firstName;
    private String lastName;
}