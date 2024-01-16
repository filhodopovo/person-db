package com.crud.crud.dtos;

import com.crud.crud.entities.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonResponseDto {
    private Long id;
    private String name;
    private String email;
    private String address;
    private Integer idade;

    public PersonResponseDto(Person model) {
        this(model.getId(), model.getName(), model.getEmail(), model.getAddress(), model.getIdade());
    }
}