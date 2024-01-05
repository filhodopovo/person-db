package com.crud.crud.exceptions;

import com.crud.crud.exceptions.model.PersonExceptionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseStatus
public class PersonExceptions {
    private PersonExceptionModel model;

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<PersonExceptionModel> notNull() {
        model = new PersonExceptionModel(HttpStatus.BAD_REQUEST, 400, "Não permitimos valores vazios");
        return new ResponseEntity<>(model, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<PersonExceptionModel> personNotFound() {
        model = new PersonExceptionModel(HttpStatus.NOT_FOUND, 404, "Person Not Found");
        return new ResponseEntity<>(model, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceExistException.class)
    public ResponseEntity<PersonExceptionModel> personExist() {
        model = new PersonExceptionModel(HttpStatus.NOT_ACCEPTABLE, 406, "Person exists");
        return new ResponseEntity<>(model, HttpStatus.NOT_ACCEPTABLE);
    }
}
