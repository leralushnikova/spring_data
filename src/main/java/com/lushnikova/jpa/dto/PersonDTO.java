package com.lushnikova.jpa.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PersonDTO {
    private Integer age;
    private String firstName;
    private String lastName;
}