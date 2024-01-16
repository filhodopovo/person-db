package com.crud.crud.exceptions.infra;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class PersonExistException extends RuntimeException {
    public PersonExistException() {
        super("Person exists");
    }
}
