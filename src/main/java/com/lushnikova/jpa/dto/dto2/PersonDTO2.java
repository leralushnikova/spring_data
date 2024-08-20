package com.lushnikova.jpa.dto.dto2;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PersonDTO2 {
    private Long id;
    private String firstName;

    public PersonDTO2(Long id, String firstName) {
        this.id = id;
        this.firstName = firstName;
    }
}