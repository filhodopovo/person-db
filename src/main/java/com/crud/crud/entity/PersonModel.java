package com.crud.crud.entity;

import com.crud.crud.view.dto.PersonRequestDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@NoArgsConstructor
@Data
@Table(name = "PERSON_TABLE")
public class PersonModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name, email, address;
    @Column(name = "person_password")
    private String password;
    private Integer idade;
    private Date registerDay = new Date();

    public void setterPersonModel(PersonRequestDto person) {
        this.name = person.getName();
        this.email = person.getEmail();
        this.address = person.getAddress();
        this.password = person.getPassword();
        this.idade = person.getIdade();
    }
}
