package com.crud.crud.controllers;

import com.crud.crud.view.dto.PersonRequestDto;
import com.crud.crud.view.dto.PersonResponseDto;
import com.crud.crud.services.PersonService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/person")
public class PersonController {
    private PersonService personService;

    @PostMapping("/register")
    public ResponseEntity<PersonResponseDto> register(@RequestBody @Valid PersonRequestDto personRequestDto) {
        return new ResponseEntity<>(this.personService.register(personRequestDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PersonResponseDto>> listAllPersons() {
        return new ResponseEntity<>(this.personService.listAllPersons(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonResponseDto> personById(@RequestBody @PathVariable("id") @Valid Long id) {
        return new ResponseEntity<>(this.personService.personById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonResponseDto> updatePerson(@PathVariable("id") @Valid Long id, @RequestBody @Valid PersonRequestDto person) {
        return new ResponseEntity<>(this.personService.updatePerson(id, person), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") @Valid Long id) {
        this.personService.deleteById(id);
        return new ResponseEntity<>("Person delete", HttpStatus.NO_CONTENT);
    }
}
