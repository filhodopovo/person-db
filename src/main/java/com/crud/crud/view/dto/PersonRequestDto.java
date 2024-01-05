package com.crud.crud.view.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PersonRequestDto {
    @NotEmpty
    private String name;
    @NotEmpty
    private String email;
    @NotEmpty
    private String address;
    @NotEmpty
    @Size(min = 8, max = 16)
    private String password;
    @NotNull
    private Integer idade;
}
