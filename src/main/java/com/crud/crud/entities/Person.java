package com.crud.crud.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@NoArgsConstructor
@Data
@Table(name = "PERSON_TABLE")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name, email, address;
    @Column(name = "person_password")
    private String password;
    private Integer idade;
    private Date registerDay = new Date();
}
