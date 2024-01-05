package com.crud.crud.view.dto;

import lombok.Data;

@Data
public class PersonResponseDto {
    private Long id;
    private String name;
    private String email;
    private String address;
    private Integer idade;
}